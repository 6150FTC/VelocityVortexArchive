package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Peter G on 1/10/2017.
 */
@TeleOp
public class ScoopServoTest extends OpMode
{
    OmniDriveBot robot = new OmniDriveBot();
    private int numerator = 500;
    private int denominator = 1000;
    public void init()
    {
        robot.init(hardwareMap);
    }

    public void loop()
    {
        while(gamepad1.dpad_up)
        {
            numerator++;
            while(gamepad1.dpad_up){}
        }

        while(gamepad1.dpad_down)
        {
            numerator--;
            while(gamepad1.dpad_down){}
        }

        while(gamepad1.a)
        {
            denominator++;
            while(gamepad1.a){}
        }

        while(gamepad1.b)
        {
            denominator--;
            while(gamepad1.b){}
        }
        telemetry.addData("Numerator:", numerator);
        telemetry.addData("Denominator:", denominator);
        telemetry.update();
    }
}
