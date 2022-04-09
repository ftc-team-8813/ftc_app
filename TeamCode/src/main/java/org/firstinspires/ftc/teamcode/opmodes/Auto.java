package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardware.Robot;

@Autonomous(name = "Auto")
public class Auto extends LoggingOpMode{

    public Robot robot;

    @Override
    public void init() {
        super.init();
        robot = Robot.initialize(hardwareMap);

    }

    @Override
    public void loop() {
        robot.capDetector.capstoneDetection(telemetry);
        telemetry.addData("Loop Number", robot.capDetector.getLoopCycleNum());
        telemetry.update();
    }
}