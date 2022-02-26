package org.firstinspires.ftc.teamcode.opmodes;

import android.util.Log;

import androidx.appcompat.app.WindowDecorActionBar;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.Robot;
import org.firstinspires.ftc.teamcode.opmodes.teleop.ControlMgr;
import org.firstinspires.ftc.teamcode.opmodes.teleop.DriveControl;
import org.firstinspires.ftc.teamcode.opmodes.teleop.DuckControl;
import org.firstinspires.ftc.teamcode.opmodes.teleop.LiftControl;
import org.firstinspires.ftc.teamcode.opmodes.teleop.IntakeControl;
import org.firstinspires.ftc.teamcode.opmodes.teleop.TelemetryControl;
import org.firstinspires.ftc.teamcode.util.Logger;
import org.firstinspires.ftc.teamcode.util.Persistent;
import org.opencv.android.OpenCVLoader;

@TeleOp(name = "!!THE TeleOp!!")
public class CurrentTele extends LoggingOpMode
{
    // Robot and Controller Vars
    private Robot robot;
    private Logger log;
    private ControlMgr control_mgr;
    private ElapsedTime timer;

    static
    {
        OpenCVLoader.initDebug();
    }
    
    @Override
    public void init()
    {
        super.init();
        robot = Robot.initialize(hardwareMap, "Main TeleOp", 0);
        log = new Logger("Tele Op");
        timer = new ElapsedTime();
        
        control_mgr = new ControlMgr(robot, gamepad1, gamepad2);

        // Controller Modules
//        controlMgr.addModule(new ServerControl("Server Control"));
//        control_mgr.addModule(new TelemetryControl("Telemetry Control"));
        control_mgr.addModule(new DriveControl("Drive Control"));
        control_mgr.addModule(new IntakeControl("Intake Control"));
        control_mgr.addModule(new LiftControl("FourBar Control"));
        control_mgr.addModule(new DuckControl("Duck Control"));

        control_mgr.initModules();
    }
    
    @Override
    public void init_loop()
    {
        control_mgr.init_loop(telemetry);
    }
    
    @Override
    public void start()
    {
        timer.reset();
        Persistent.clear();
    }
    
    @Override
    public void loop()
    {
        double start_time = timer.seconds();
        // Loop Updaters
        control_mgr.loop(telemetry);
        telemetry.update();
        log.i("Loop Time: ", timer.seconds() - start_time);

    }
    
    @Override
    public void stop()
    {
        control_mgr.stop();
        super.stop();
    }
}
