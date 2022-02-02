package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class HardwareMap extends OpMode {
    Robot robot = new Robot();

    @Override
    public void init() {
        robot.Back_Left = hardwareMap.dcMotor.get("BL");
        robot.Back_Right = hardwareMap.dcMotor.get("BR");
        robot.Front_Right = hardwareMap.dcMotor.get("FR");
        robot.Front_Left = hardwareMap.dcMotor.get("FL");
    }

    @Override
    public void loop() {

    }
}
