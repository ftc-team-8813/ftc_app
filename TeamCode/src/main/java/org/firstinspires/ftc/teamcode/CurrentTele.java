package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;


public class CurrentTele extends OpMode {
    Robot robot = new Robot(hardwareMap);
    MecanumDrive md = new MecanumDrive();
    LiftControl lift = new LiftControl();



    @Override
    public void init() {
        telemetry.addData("TeleOp Status: ", "Has been Initialized");
    }

    @Override
    public void loop() {
        md.Move(-gamepad1.right_stick_y, gamepad1.right_stick_x, gamepad1.right_stick_x, robot );
        lift.liftPosition(robot);
        lift.liftInOrOut(robot);
        lift.liftBracketInOrOut(robot);
    }
}
