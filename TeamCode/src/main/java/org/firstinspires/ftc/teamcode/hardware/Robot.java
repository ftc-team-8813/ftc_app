package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Robot {

    public Drivetrain DriveTrain;

    public Robot(HardwareMap hardwareMap) {

        DcMotor front_left = hardwareMap.get(DcMotor.class, "front left");
        DcMotor front_right = hardwareMap.get(DcMotor.class, "front right");
        DcMotor back_left = hardwareMap.get(DcMotor.class, "back left");
        DcMotor back_right = hardwareMap.get(DcMotor.class, "back right");
        DcMotor lift = hardwareMap.get(DcMotor.class, "lift");

        Servo dropper = hardwareMap.get(Servo.class, "dropper");

        this.DriveTrain = new Drivetrain(front_left, front_right, back_left, back_right, lift, dropper);

    }

}
