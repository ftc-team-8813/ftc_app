package org.firstinspires.ftc.teamcode.hardware;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Drivetrain {

    DcMotor front_left;
    DcMotor front_right;
    DcMotor back_left;
    DcMotor back_right;
    DcMotor lift;
    Servo dropper;

    double dpos;

    public Drivetrain(DcMotor front_left, DcMotor front_right, DcMotor back_left, DcMotor back_right, DcMotor lift, Servo dropper) {

        this.front_left = front_left;
        this.front_right = front_right;
        this.back_left = back_left;
        this.back_right = back_right;
        this.lift = lift;
        this.dropper = dropper;

    }

    public void left_stick_rotation(double left_x) {

        front_left.setPower(-1 * left_x);
        front_right.setPower(-1 * left_x);
        back_left.setPower(-1 * left_x);
        back_right.setPower(-1 * left_x);

    }

    public void right_stick_drive(double right_y, double right_x) {

        front_left.setPower(-1 * (-right_y + right_x)); // 1 + 0
        front_right.setPower((-right_y - right_x)); // 1 - 0
        back_left.setPower(-1 * (-right_y - right_x));// 1 - 0
        back_right.setPower((-right_y + right_x)); // 1 + 0

    }

//    public void lift_control(boolean Dpad_up, boolean Dpad_down) {
//        if (Dpad_up) {
//            lift.setPower(0.1);
//        }
//        if (Dpad_down) {
//            lift.setPower(-0.1);
//        }
//    }
//
//    public void dropper_control(boolean Dpad_right, boolean Dpad_left) {
//        if (Dpad_right) {
//            dpos = dropper.getPosition();
//            if (dpos < 1.0) {
//                dropper.setPosition(dpos + 0.5);
//            }
//        }
//        if (Dpad_left) {
//            dpos = dropper.getPosition();
//            if (dpos > 0) {
//                dropper.setPosition(dpos - 0.5);
//            }
//        }
//    }

}
