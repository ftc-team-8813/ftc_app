package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Robot;
import org.firstinspires.ftc.teamcode.opmodes.teleop.ControlMgr;
import org.firstinspires.ftc.teamcode.opmodes.teleop.DriveControl;
import org.firstinspires.ftc.teamcode.opmodes.teleop.DuckControl;
import org.firstinspires.ftc.teamcode.opmodes.teleop.LiftControl;
import org.firstinspires.ftc.teamcode.opmodes.teleop.IntakeControl;
import org.firstinspires.ftc.teamcode.opmodes.teleop.TelemetryControl;
import org.firstinspires.ftc.teamcode.util.Persistent;
import org.opencv.android.OpenCVLoader;

@TeleOp(name = "!!THE TeleOp!!")
public class CurrentTele extends LoggingOpMode
{
    // Robot and Controller Vars
    private Robot robot;
    private ControlMgr control_mgr;

    static
    {
        OpenCVLoader.initDebug();
    }
    
    @Override
    public void init()
    {
        super.init();
        robot = Robot.initialize(hardwareMap, "Main TeleOp", 0);
        
        control_mgr = new ControlMgr(robot, gamepad1, gamepad2);

        // Controller Modules
//        controlMgr.addModule(new ServerControl("Server Control"));
        control_mgr.addModule(new DriveControl("Drive Control"));
        control_mgr.addModule(new IntakeControl("Intake Control"));
        control_mgr.addModule(new LiftControl("FourBar Control"));
        control_mgr.addModule(new DuckControl("Duck Control"));
        control_mgr.addModule(new TelemetryControl("Telemetry Control"));
        
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
        Persistent.clear();
    }
    
    @Override
    public void loop()
    {
        // Loop Updaters
        control_mgr.loop(telemetry);
        telemetry.update();
    }
    
    @Override
    public void stop()
    {
        control_mgr.stop();
        super.stop();
    }
}
