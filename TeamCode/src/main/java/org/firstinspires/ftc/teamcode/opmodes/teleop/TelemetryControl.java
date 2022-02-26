package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.hardware.Robot;

public class TelemetryControl extends ControlModule{
    private Robot robot;

    public TelemetryControl(String name) {
        super(name);
    }

    @Override
    public void initialize(Robot robot, Gamepad gamepad1, Gamepad gamepad2, ControlMgr manager) {
        this.robot = robot;
    }

    @Override
    public void update(Telemetry telemetry) {
        // Drivetrain
        telemetry.addData("Dist Y: ", robot.drivetrain.dist_y.getDistance(DistanceUnit.CM));
        telemetry.addData("Line Found: ", robot.lineFinder.lineFound());

        // Lift
        telemetry.addData("Lift Real Pos: ", robot.lift.getLiftCurrentPos());
        telemetry.addData("Lift Target Pos: ", robot.lift.getLiftTargetPos());
        telemetry.addData("Lift Limit: ", robot.lift.limitPressed());

        // Intake
        telemetry.addData("Freight Distance: ", robot.intake.getFreightDistance());

        // Navigation
//        telemetry.addData("x Error: ", error_x);
//        telemetry.addData("y Error: ", error_y);
//        telemetry.addData("a Error: ", error_a);
//
//        telemetry.addData("x position: ", field_x);
//        telemetry.addData("y position: ", field_y);
//        telemetry.addData("angle: ", heading);
    }
}
