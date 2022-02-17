package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class CapStoneDetector {
    private int location;

    public CapStoneDetector(){
        this.location = 0;
    }
    public void CapStoneDetection(DistanceSensor left, DistanceSensor right){
        if ((left.getDistance(DistanceUnit.CM) >= 50 && left.getDistance(DistanceUnit.CM) <= 70)){
            location = 1;
        } else if ((right.getDistance(DistanceUnit.CM) >= 50 && right.getDistance(DistanceUnit.CM) <= 70)){
            location = 3;
        } else {
            location = 2;
        }
    }

    public int getLocation(){
        return location;
    }

}
