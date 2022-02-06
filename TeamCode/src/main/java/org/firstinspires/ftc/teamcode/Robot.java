package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Robot {
    // Declaring Motors
    public DcMotor Front_Right;
    public DcMotor Front_Left;
    public DcMotor Back_Left;
    public DcMotor Back_Right;
    public DcMotor Lift;


    // Declaring Servos
    public Servo LiftPosition;
    public Servo LiftBracketPosition;

    public Robot(HardwareMap hardwareMap){
        //Motors
        Back_Left = hardwareMap.get(DcMotor.class, "BL");
        Back_Right = hardwareMap.get(DcMotor.class, "BR");
        Front_Right = hardwareMap.get(DcMotor.class, "FR");
        Front_Left = hardwareMap.get(DcMotor.class, "FL");
        Lift = hardwareMap.get(DcMotor.class, "lift");

        //Servos
        LiftPosition = hardwareMap.get(Servo.class, "liftPosition");
        LiftBracketPosition = hardwareMap.get(Servo.class, "liftBracketPosition");
    }
}
