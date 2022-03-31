package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardware.Robot;

@Autonomous(name = "Auto")
public class Auto extends LoggingOpMode{

    private Robot robot;

    @Override
    public void loop() {
        robot.capDetector.blueCapstoneDetection();
        robot.capDetector.getMiddleDistance(telemetry);
        robot.capDetector.getRightDistance(telemetry);
    }
}

