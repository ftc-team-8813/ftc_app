package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Robot {
    // Declaring Motors
    public DcMotor Front_Right;
    public DcMotor Front_Left;
    public DcMotor Back_Left;
    public DcMotor Back_Right;
    public DcMotor Lift;
    public DistanceSensor DistanceSensorLeft;
    public DistanceSensor DistanceSensorRight;


    // Declaring Servos
    public Servo LiftPosition;
    public Servo LiftBracketPosition;

    public Robot(HardwareMap hardwareMap){
        //Motors
//        Back_Left = hardwareMap.get(DcMotor.class, "back left");
//        Back_Right = hardwareMap.get(DcMotor.class, "back right");
//        Front_Right = hardwareMap.get(DcMotor.class, "front right");
//        Front_Left = hardwareMap.get(DcMotor.class, "front left");
//        Lift = hardwareMap.get(DcMotor.class, "lift");
//
//        //Servos
//        LiftPosition = hardwareMap.get(Servo.class, "liftPosition");
//        LiftBracketPosition = hardwareMap.get(Servo.class, "dropper");

        //Distance Sensors
        DistanceSensorLeft = hardwareMap.get(DistanceSensor.class, "leftDS");
        DistanceSensorRight = hardwareMap.get(DistanceSensor.class, "rightDS");
    }
}
