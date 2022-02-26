package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.teamcode.util.Status;

public class LineFinder {
    public final ColorSensor line_finder;
    public int alpha_init = -1;

    public LineFinder(ColorSensor line_finder){
        this.line_finder = line_finder;
    }

    public void initialize(){
        alpha_init = line_finder.alpha();
    }

    public boolean lineFound() {
        double check_value = alpha_init * Status.LIGHT_MULTIPLIER;
        return line_finder.alpha() > check_value;
    }
}
