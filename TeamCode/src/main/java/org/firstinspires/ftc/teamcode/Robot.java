package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Robot {
    public DcMotor Front_Right;
    public DcMotor Front_Left;
    public DcMotor Back_Left;
    public DcMotor Back_Right;



    public void setAll(DcMotor FR, DcMotor FL, DcMotor BL, DcMotor BR, double power){
        FR.setPower(power);
        BL.setPower(power);
        BR.setPower(power);
        FL.setPower(power);
    }


}
