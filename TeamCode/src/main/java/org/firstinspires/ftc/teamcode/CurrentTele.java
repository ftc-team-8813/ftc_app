package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;

@TeleOp(name = "!!Reetham's TeleOp!!")
public class CurrentTele extends OpMode {
    Robot robot;
    MecanumDrive md = new MecanumDrive();
    LiftControl lift = new LiftControl();
    testDistanceSensor distanceSensor;
    CapStoneDetector csd;

    @Override
    public void init() {
        robot = new Robot(hardwareMap);
        distanceSensor = new testDistanceSensor(telemetry);
        telemetry.addData("TeleOp Status: ", "Has been Initialized");
        csd = new CapStoneDetector();
    }

    @Override
    public void start() {
    }

    @Override
    public void loop() {
//        md.Move(-gamepad1.right_stick_y, gamepad1.right_stick_x, gamepad1.right_stick_x, robot );
//        lift.liftPosition(robot);
//        lift.liftInOrut(robot);
//        lift.liftBracketInOrOut(robot);
        distanceSensor.detectedOrNot(robot.DistanceSensorLeft);
        distanceSensor.detectedOrNot(robot.DistanceSensorRight);
//        telemetry.addData("Distance Sensor Test", "It works"
        csd.CapStoneDetection(robot.DistanceSensorLeft, robot.DistanceSensorRight);
        telemetry.addData("Capstone Location: ", csd.getLocation());
        telemetry.update();
    }
}
