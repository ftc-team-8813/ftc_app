package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardware.Intake;
import org.firstinspires.ftc.teamcode.hardware.Lift;
import org.firstinspires.ftc.teamcode.hardware.Robot;
import org.firstinspires.ftc.teamcode.input.ControllerMap;
import org.firstinspires.ftc.teamcode.util.Status;

import java.util.Timer;

public class IntakeControl extends ControlModule {
    private Intake intake;
    private Lift lift;
    private Gamepad gamepad1;
    private Gamepad gamepad2;

    private double direction = 1; // positive = Intake, negative = Outtake
    private double side = 3; // 1 = Front, 0 = Center, -1 = Back, 2 = Dump
    private double side_was = 3; // position of bucket on last loop cycle
    private boolean carrying = true;

    private long current_time = 0;
    private long target_time = Status.TIME_BEFORE_INTAKING;

    private boolean was_rumbling = false;


    public IntakeControl(String name) {
        super(name);
    }

    @Override
    public void initialize(Robot robot, Gamepad gamepad1, Gamepad gamepad2, ControlMgr manager) {
        this.intake = robot.intake;
        this.lift = robot.lift;
        this.intake.stop();
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;

        intake.deposit(Status.DEPOSITS.get("carry"));
    }

    @Override
    public void update(Telemetry telemetry) {
        current_time = System.nanoTime();
        if (intake.getFreightDistance() < Status.FREIGHT_DETECTION){
            direction = -0.9;
            side = 0;
            carrying = true;

            if (!was_rumbling) {
                gamepad1.rumble(1, 1, 150);
                gamepad2.rumble(1, 1, 150);
                was_rumbling = true;
            }
        } else  {
            direction = 0.9;
            carrying = false;
            was_rumbling = false;
        }

        if (gamepad1.right_trigger > 0.5){
            if (!carrying){
                side = 1;
            }
            if (side == side_was && current_time >= target_time){
                intake.setIntakeFront(direction);
            }
        } else {
            intake.setIntakeFront(0);
        }

        if (gamepad1.left_trigger > 0.5){
            if (!carrying){
                side = -1;
            }
            if (side == side_was && current_time >= target_time) {
                intake.setIntakeBack(direction);
            }
        } else {
            intake.setIntakeBack(0);
        }

        if (gamepad1.left_bumper){
            intake.setIntakeFront(-1);
            intake.setIntakeBack(-1);
        }

        if (lift.getLiftTargetPos() > 1000) {
            if (gamepad2.right_bumper) {
                intake.deposit(Status.DEPOSITS.get("dump"));
                side = 2;
            } else {
                side = 0;
            }
        }

        if (side == 0){
            if (lift.getLiftTargetPos() == Status.STAGES.get("pitstop") || lift.getLiftTargetPos() == 0 || lift.getLiftTargetPos() > Status.STAGES.get("neutral") + 20000) {
                if (side_was == 1){
                    intake.deposit(Status.DEPOSITS.get("front_tilt"));
                } else if (side_was == -1){
                    intake.deposit(Status.DEPOSITS.get("back_tilt"));
                }
            } else {
                intake.deposit(Status.DEPOSITS.get("neutral_tilt"));
            }
        } else if (side == 1){
            if (lift.getLiftCurrentPos() < 2000) {
                intake.deposit(Status.DEPOSITS.get("front"));
            }
        } else if (side == -1){
            if (lift.getLiftCurrentPos() < 2000) {
                intake.deposit(Status.DEPOSITS.get("back"));
            }
        }

        if (side != side_was){
            target_time = current_time+Status.TIME_BEFORE_INTAKING;
        }

        side_was=side;
    }
}