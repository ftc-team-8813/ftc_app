package org.firstinspires.ftc.teamcode;

public class MecanumDrive {

    public void Move(double fwd, double strafe, double rotate, Robot robot) {
        robot.Front_Left.setPower(fwd + strafe + rotate);
        robot.Front_Right.setPower(fwd - strafe - rotate);
        robot.Back_Left.setPower(fwd - strafe + rotate);
        robot.Back_Right.setPower(fwd + strafe - rotate);
    }
}

