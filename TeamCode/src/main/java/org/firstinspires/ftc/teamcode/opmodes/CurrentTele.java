package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Drivetrain;
import org.firstinspires.ftc.teamcode.hardware.Robot;



@TeleOp(name = "!!Abhi-TeleOp!!")
public class CurrentTele extends OpMode {



    Robot robot;
    Drivetrain DriveTrain;

    @Override
    public void init() {

        robot = new Robot(hardwareMap);
        DriveTrain = robot.DriveTrain;

    }

    @Override
    public void loop() {

        double rY = gamepad1.right_stick_y;
        double rX = gamepad1.right_stick_x;
        double lY = gamepad1.left_stick_y;
        double lX = gamepad1.left_stick_x;
        boolean dpad_up = gamepad1.dpad_up;
        boolean dpad_down = gamepad1.dpad_down;
        boolean dpad_right = gamepad1.dpad_right;
        boolean dpad_left = gamepad1.dpad_left;

        DriveTrain.left_stick_rotation(lX);
        DriveTrain.right_stick_drive(rY, rX);
//        DriveTrain.lift_control(dpad_up, dpad_down);
//        DriveTrain.dropper_control(dpad_right, dpad_left);

        telemetry.addData("Right Stick X", gamepad1.right_stick_x);
        telemetry.addData("Right Stick Y", gamepad1.right_stick_y);
        telemetry.addData("Left Stick X", gamepad1.left_stick_x);
        telemetry.addData("Left Stick Y", gamepad1.left_stick_y);
        telemetry.addData("DPad Up", gamepad1.dpad_up);
        telemetry.addData("DPad Down", gamepad1.dpad_down);
        telemetry.addData("DPad Right", gamepad1.dpad_right);
        telemetry.addData("DPad Left", gamepad1.dpad_left);

    }
}
