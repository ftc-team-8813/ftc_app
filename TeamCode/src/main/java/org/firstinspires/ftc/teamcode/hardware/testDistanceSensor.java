package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.checkerframework.checker.index.qual.LTEqLengthOf;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class testDistanceSensor{
    Telemetry telemetry;
    DistanceSensor DistanceSensorLeft;
    DistanceSensor DistanceSensorRight;

    public testDistanceSensor(Telemetry telemetry){

        this.telemetry = telemetry;
    }

    public void detectedOrNot(DistanceSensor distanceSensor){
        if (distanceSensor.getDistance(DistanceUnit.CM) != 0){
            double distance = distanceSensor.getDistance(DistanceUnit.CM);
            telemetry.addData("Detection Status: ", "Detected");
            telemetry.addData("Distance in CM is: ", distance);
        } else {
            telemetry.addData("Detection Status: ", "Nothing is being detected right now");
        }
    }
}
