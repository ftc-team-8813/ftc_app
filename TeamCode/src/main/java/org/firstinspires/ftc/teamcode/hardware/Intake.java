package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.util.Status;
import org.firstinspires.ftc.teamcode.util.Storage;

public class Intake {
    private final DcMotor intake;
    public final DistanceSensor freight_checker;
    private final Servo claw;
    private final CRServo left_intake;
    private final CRServo right_intake;

    private double FREIGHT_DETECTION_THRESHOLD;

    public Intake(DcMotor intake, DistanceSensor freight_checker, Servo claw, CRServo left_intake, CRServo right_intake){
        this.intake = intake;
        this.freight_checker = freight_checker;
        this.claw = claw;
        this.left_intake = left_intake;
        this.right_intake = right_intake;

        this.FREIGHT_DETECTION_THRESHOLD = Storage.getJsonValue("freight_detection_threshold");
    }

    public void deposit(double target_pos){
        claw.setPosition(target_pos);
    }

    public void setPower(double power){
        intake.setPower(power);
        left_intake.setPower(power);
        right_intake.setPower(-power);
    }

    public void stop(){
        intake.setPower(0);
    }

    public boolean freightDetected() {
        return freight_checker.getDistance(DistanceUnit.CM) < FREIGHT_DETECTION_THRESHOLD;
    }

    public double getPower(){
        return intake.getPower();
    }
}
