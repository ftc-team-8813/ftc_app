package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class MecanumDrive extends OpMode {

    Robot robot = new Robot();

    public void MechanumDrive(){
        robot.Front_Left.setDirection(DcMotorSimple.Direction.REVERSE);
        robot.Front_Right.setDirection(DcMotorSimple.Direction.REVERSE);

        if (gamepad1.right_stick_y >= 0 && gamepad1.right_stick_y <= 1){
            robot.setAll(robot.Back_Left, robot.Back_Right, robot.Front_Left, robot.Front_Right, 1.0);
        } else if (gamepad1.right_stick_y <= 0 && gamepad1.right_stick_y >= -1){
            robot.setAll(robot.Back_Left, robot.Back_Right, robot.Front_Left, robot.Front_Right, 0);
        } else if (gamepad1.right_stick_x >= 0 && gamepad1.right_stick_x <= 1){
            robot.Front_Left.setPower(1);
            robot.Back_Right.setPower(1);
            robot.Front_Right.setPower(-1);
            robot.Back_Left.setPower(-1);
        } else if (gamepad1.right_stick_x <= 0 && gamepad1.right_stick_x >= 1){
            robot.Front_Left.setPower(-1);
            robot.Back_Right.setPower(-1);
            robot.Front_Right.setPower(1);
            robot.Back_Left.setPower(1);
        } else {
            telemetry.addData("Right Now", "Something Else Went Wrong");
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }
}
