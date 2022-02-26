package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardware.Duck;
import org.firstinspires.ftc.teamcode.hardware.Robot;
import org.firstinspires.ftc.teamcode.input.ControllerMap;

public class DuckControl extends ControlModule{
    private Duck duck;
    private Gamepad gamepad1;
    private Gamepad gamepad2;
    private ElapsedTime spinner_speed_timer;
    private double spinner_speed = 0.0;
    private boolean inc_spinner_speed = false;
    private boolean stop_duck_spin = false;

    public DuckControl(String name){
        super(name);
    }

    @Override
    public void initialize(Robot robot, Gamepad gamepad1, Gamepad gamepad2, ControlMgr manager) {
        this.duck = robot.duck;
        spinner_speed_timer = new ElapsedTime();
    }

    @Override
    public void update(Telemetry telemetry) {
        if (gamepad2.right_stick_y > 0.14) {

            inc_spinner_speed = spinner_speed_timer.seconds() >= 1.2;
            stop_duck_spin = spinner_speed_timer.seconds() >= 2;
            if (stop_duck_spin) {
                spinner_speed = 0.0;
            }
            if (!inc_spinner_speed && !stop_duck_spin) {
                spinner_speed = 0.2;
            }
            if (inc_spinner_speed && !stop_duck_spin) {
                spinner_speed = 1.0;
            }

        }
        if (gamepad2.right_stick_y < -0.14) {

            inc_spinner_speed = spinner_speed_timer.seconds() >= 1.2;
            stop_duck_spin = spinner_speed_timer.seconds() >= 2;
            if (stop_duck_spin) {
                spinner_speed = 0.0;
            }
            if (!inc_spinner_speed && !stop_duck_spin) {
                spinner_speed = -0.2;
            }
            if (inc_spinner_speed && !stop_duck_spin) {
                spinner_speed = -1.0;
            }
        }

        if (gamepad2.right_stick_y <= 0.14 && gamepad2.right_stick_y >= -0.14) {
            spinner_speed_timer.reset();
            spinner_speed = 0.0;

        }

        duck.spin(spinner_speed);
    }
}
