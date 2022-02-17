//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//
//import org.firstinspires.ftc.robotcore.external.Telemetry;
//
//public class LiftControl extends OpMode {
//    public void liftPosition(Robot robot) {
//        if (gamepad1.dpad_down) {
//            robot.Lift.setPower(0);
//        } else if (gamepad1.dpad_right) {
//            robot.Lift.setPower(0.5);
//        } else if (gamepad1.dpad_up) {
//            robot.Lift.setPower(1);
//        } else {
//            telemetry.addData("Program Status: ", "Something else is wrong during the whole Lift Position");
//    }
//}
//
//    public void liftInOrOut(Robot robot) {
//            if (gamepad1.right_trigger >= 0.5){
//                robot.LiftPosition.setPosition(1);
//            } else if (gamepad1.left_trigger >= 0.5){
//                robot.LiftPosition.setPosition(0);
//            } else if (gamepad1.right_trigger >= 0.5 && gamepad1.left_trigger >= 0.5){
//                robot.LiftPosition.setPosition(0.5);
//            } else {
//                telemetry.addData("Program Status: ", "Something else went wrong during Lift in or out");
//            }
//        }
//
//
//    public void liftBracketInOrOut(Robot robot){
//        while (robot.LiftPosition.getPosition() == 0 || robot.LiftPosition.getPosition() == 1){
//            if (gamepad1.right_bumper){
//                robot.LiftBracketPosition.setPosition(1);
//            } else if (gamepad1.left_bumper){
//                robot.LiftBracketPosition.setPosition(0);
//            } else if (gamepad1.right_bumper && gamepad1.left_bumper){
//                robot.LiftPosition.setPosition(0.5);
//            } else {
//                telemetry.addData("Program Status: ", "Something else went wrong during Lift's bracket in or out");
//            }
//        }
//    }
//
//
//    @Override
//    public void init() {
//
//    }
//
//    @Override
//    public void loop() {
//
//    }
//}
