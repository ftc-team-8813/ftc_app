package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Lift;
import org.firstinspires.ftc.teamcode.hardware.LineFinder;
import org.firstinspires.ftc.teamcode.hardware.Robot;
import org.firstinspires.ftc.teamcode.input.ControllerMap;
import org.firstinspires.ftc.teamcode.hardware.AutoDrive;
import org.firstinspires.ftc.teamcode.util.Status;

public class DriveControl extends ControlModule{
    private Drivetrain drivetrain;
    private Lift lift;
    private AutoDrive autoDrive;
    private LineFinder lineFinder;
    private Gamepad gamepad1;
    private Gamepad gamepad2;

    private double speed_scalar = 2;
    private double heading_was;
    public double heading_delta;

    //private double target_angle=0.0; // robot target heading for correction
    //private double turn_scaling=0.1; //scales the right joystick x value for turn correction


    public DriveControl(String name) {
        super(name);
    }


    @Override
    public void initialize(Robot robot, Gamepad gamepad1, Gamepad gamepad2, ControlMgr manager) {
        this.drivetrain = robot.drivetrain;
        this.lift = robot.lift;
        this.lineFinder = robot.lineFinder;
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
    }


    @Override
    public void update(Telemetry telemetry) {
//        if (lift.getLiftTargetPos() > Status.STAGES.get("speed mode threshold")) {
//            speed_scalar = 1.5;
//        } else if (btn_x.get()) {
//            speed_scalar = 1;
//        } else if (btn_dpad_down.get()){
//            speed_scalar = 2;
//        }
        if (lift.getLiftTargetPos() > Status.STAGES.get("neutral") - 1000 && lift.getLiftTargetPos() < Status.STAGES.get("neutral") + 3000) {
            speed_scalar = 1;
        }
        if (lift.getLiftTargetPos() == Status.STAGES.get("pitstop") || lift.getLiftTargetPos() == 0) {
            speed_scalar = 2;
        }
        if (lift.getLiftCurrentPos() > Status.STAGES.get("mid")) {
            speed_scalar = 0.8;
        }

        teleMove(-gamepad1.left_stick_y * 0.45 * speed_scalar,
                                     gamepad1.left_stick_x * 0.45 * speed_scalar,
                                      gamepad1.right_stick_x * 0.45 * speed_scalar);
    }

    public void teleMove(double forward, double strafe, double turn) {
        double tele_strafe = strafe * 0.7;
        double wall_distance = drivetrain.dist_y.getDistance(DistanceUnit.CM);
        heading_delta = 0 - heading_was; // TODO Removed imu.getHeading()
        //if (Math.abs(heading_delta) > 4) heading_delta = 0;
        if (turn != 0) heading_delta = 0;

        if ((lift.getLiftTargetPos() == Status.STAGES.get("pitstop") || lift.getLiftTargetPos() > Status.STAGES.get("low")) && wall_distance < 40 && strafe < 0.1 && turn < 0.1 && !lift.duck_cycle_flag) {
            tele_strafe += -Range.clip(wall_distance - 5, 0, 5) * 0.05;
        }

        drivetrain.move(forward, (tele_strafe), (turn * 0.6) + (heading_delta * Status.TURN_CORRECTION_P));
        heading_was = 0; // TODO Removed imu.getHeading()
    }
}
