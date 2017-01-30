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

        robot.driveStraight(90, -153,.87);
        robot.stop();
        sleep(100);

        robot.spin(90);
        robot.stop();
        sleep(100);

        robot.driveStraight(30,90,.87);
        robot.stop();

        sleep(100);
        while(!robot.isDetectingBlue())
        {
            if (timesScanned > 14)
                break;

            timesScanned++;
            robot.driveStraight(1,180,.87);
        }


        robot.driveStraight(5,90,.75);
        robot.stop();
        sleep(100);
        robot.driveStraight(1,-90,.87);
        robot.stop();


        robot.driveStraight(29 - timesScanned, 180, .87);
        robot.stop();
        robot.driveStraight(9, 90, .2);
        robot.stop();
        sleep(2000);

        robot.driveStraight(1,-90,.87);
        robot.stop();
        sleep(100);
        robot.driveStraight(15, 180, .87);
        robot.stop();
        robot.spin(-7);
        robot.stop();

        timesScanned = 0;
        while(!robot.isDetectingBlue())
        {
            if (timesScanned > 10)
                break;

            timesScanned++;
            robot.driveStraight(1,180,.87);
        }

        robot.stop();
        robot.driveStraight(8,90,.75);
        sleep(100);

        /*if (timesScanned <= 4)
            robot.driveStraight(64, -55, .95);
        else
            robot.driveStraight(70,-48,.95);

        robot.spin(180);
        robot.driveStraight(9, 119, .95);*/
    }
}
