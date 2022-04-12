package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardware.Robot;
import org.firstinspires.ftc.teamcode.hardware.SensorCapstoneDetector;

@Autonomous(name = "Auto")
public class Auto extends LoggingOpMode{

    SensorCapstoneDetector capDetector;


    @Override
    public void init() {
        super.init();
        Robot robot = Robot.initialize(hardwareMap);
        capDetector = robot.capDetector;
    }

    @Override
    public void loop() {
        capDetector.capstoneDetection(telemetry);
        telemetry.addData("LoopCycleNum", capDetector.getLoopCycleNum());
        telemetry.update();
    }
}

