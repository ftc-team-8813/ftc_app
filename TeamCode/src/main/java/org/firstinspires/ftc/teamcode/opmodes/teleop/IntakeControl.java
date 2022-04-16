package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.hardware.Intake;
import org.firstinspires.ftc.teamcode.hardware.Lift;
import org.firstinspires.ftc.teamcode.hardware.Robot;
import org.firstinspires.ftc.teamcode.input.ControllerMap;
import org.firstinspires.ftc.teamcode.util.Storage;

public class IntakeControl extends ControlModule{
    private Intake intake;
    private Lift lift;
    private ElapsedTime timer;

    private ControllerMap.AxisEntry left_trigger;
    private ControllerMap.AxisEntry right_trigger;
    private ControllerMap.ButtonEntry right_bumper;

    private Gamepad gamepad1;
    private Gamepad gamepad2;

    private boolean rumbled = false;

    private double HOLD_TIME;
    private double CLOSE_CLAW_FREIGHT;
    private double OPEN_CLAW;
    private double PITSTOP;
    private boolean holding_freight;

    public IntakeControl(String name) {
        super(name);
    }

    @Override
    public void initialize(Robot robot, ControllerMap controllerMap, ControlMgr manager) {
        this.intake = robot.intake;
        this.lift = robot.lift;
        this.timer = new ElapsedTime();

        left_trigger = controllerMap.getAxisMap("intake:outtake", "gamepad1", "left_trigger");
        right_trigger = controllerMap.getAxisMap("intake:intake", "gamepad1", "right_trigger");
        right_bumper = controllerMap.getButtonMap("intake:deposit", "gamepad2", "right_bumper");

        gamepad1 = controllerMap.gamepad1;
        gamepad2 = controllerMap.gamepad2;

        HOLD_TIME = Storage.getJsonValue("hold_time");
        CLOSE_CLAW_FREIGHT = Storage.getJsonValue("close_claw_freight");
        OPEN_CLAW = Storage.getJsonValue("open_claw");
        PITSTOP = Storage.getJsonValue("pitstop");
    }

    @Override
    public void init_loop(Telemetry telemetry) {
        super.init_loop(telemetry);
    }

    @Override
    public void update(Telemetry telemetry) {
        if (intake.freightDetected()){
            intake.setPower((-left_trigger.get() * 0.3) - 0.2);
            if (!rumbled) {
                gamepad1.rumble(200);
                gamepad2.rumble(200);
                rumbled = true;
            }
        } else {
            intake.setPower(right_trigger.get() - left_trigger.get());
            rumbled = false;
        }

        // Starts timer for moving claw
        if ((right_bumper.get() && lift.getLiftPosition() > PITSTOP)){
            intake.deposit(OPEN_CLAW);
        } else if ((!intake.freightDetected() && lift.getLiftTarget() < 30)) {
            intake.deposit(OPEN_CLAW);
        } else {
            intake.deposit(CLOSE_CLAW_FREIGHT);
        }

        if (right_bumper.edge() == -1) {
            if (Math.abs(lift.getPivotTarget()) < 60 && lift.getPivotTarget() != 0) {
                lift.rotate(Math.signum(lift.getPivotTarget()) * (Math.abs(lift.getPivotTarget()) - 5));
            }
        }

        telemetry.addData("Freight Distance: ", intake.freight_checker.getDistance(DistanceUnit.CM));
    }
}
