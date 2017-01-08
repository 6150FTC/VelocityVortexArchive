package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
Made by jeremy
 */
@Autonomous(name = "AutoBlueFarRampBeacon NO NAV", group = "Autonomous")
public class AutoBlueFarRampBeacon extends LinearOpMode
{
    //assumes that front omni wheels is on the bottom edge of the 2nd tle from the corner of the alliance splitter, meaning it's farther from alliance's robot from the ramp
    private OmniDriveBot robot = new OmniDriveBot();
    public void runOpMode() throws InterruptedException
    {
        int timesScanned = 0;
        robot.init(hardwareMap);
        waitForStart();

        //A suggestion but add part to shoot particles into center washing machine
        while(!gamepad1.a){}
        robot.driveStraight(90, -153,.87);
        sleep(100);

        while(!gamepad1.a){}
        robot.spin(90);
        sleep(100);

        while(!gamepad1.a){}
        robot.driveStraight(29,90,.87);

        while(!gamepad1.a){}
        //Next beacon,
        sleep(100);
        while(!robot.isDetectingBlue())
        {
            if (timesScanned > 17)
                break;

            timesScanned++;
            robot.driveStraight(1,180,.87);
            sleep(100);
        }

        while(!gamepad1.a){}
        robot.driveStraight(5,90,.75);
        sleep(100);
        robot.driveStraight(1,-90,.87);

        while(!gamepad1.a){}
        robot.driveStraight(31 - timesScanned, 180, .87);
        robot.driveStraight(9, 90, .2);
        sleep(2000);

        while(!gamepad1.a){}
        robot.driveStraight(1.5,-90,.87);
        sleep(100);
        robot.driveStraight(15, 180, .87);

        while(!gamepad1.a){}
        timesScanned = 0;
        while(!robot.isDetectingBlue())
        {
            if (timesScanned > 17)
                break;

            timesScanned++;
            robot.driveStraight(1,180,.87);
            sleep(100);
        }

        while(!gamepad1.a){}
        robot.driveStraight(8,90,.75);
        sleep(100);

        while(!gamepad1.a){}
        if (timesScanned <= 4)
        {
            robot.driveStraight(64, -55, .95);
            robot.spin(180);
            robot.driveStraight(8, 125, .95);
        }
        else
        {
            robot.driveStraight(70,-48,.95);
            robot.spin(180);
            robot.driveStraight(8, 132, .95);
        }
    }
}
