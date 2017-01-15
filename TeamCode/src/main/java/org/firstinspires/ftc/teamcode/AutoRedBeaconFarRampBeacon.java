package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by jerent on 12/6/2016.
 */
@Autonomous(name = "AutoRedBeaconFarRampBeacon NO NAV", group = "Autonomous")
public class AutoRedBeaconFarRampBeacon extends LinearOpMode
{
    //assumes that front omni wheels is on the bottom edge of the 2nd tle from the corner of the alliance splitter, meaning it's farther from alliance's robot from the ramp
    private OmniDriveBot robot = new OmniDriveBot();
    public void runOpMode() throws InterruptedException
    {
        int timesScanned = 0;
        robot.init(hardwareMap);

        waitForStart();

        //A suggestion but add part to shoot particles into center washing machine
        /*load balls, needs testing

         */
        robot.driveStraight(90, 153,.87);
        sleep(100);

        robot.spin(90);
        sleep(100);

        robot.driveStraight(34,90,.87);

        robot.spin(9);
        //Next beacon,
        sleep(100);
        while(!robot.isDetectingRed())
        {
            if (timesScanned > 14)
                break;
            timesScanned++;
            robot.driveStraight(1,0,.87);
        }
        robot.spin(7);
        robot.driveStraight(.9, 180, .87);
        robot.driveStraight(8,90,.5);
        robot.driveStraight(1.3,-90,.87);

        robot.driveStraight(29 - timesScanned, 0, .87);
        robot.driveStraight(12, 90,.2);
        sleep(2000);

        robot.driveStraight(5,-90,.87);
        robot.driveStraight(15, 0, .87);
        robot.spin(4);

        timesScanned = 0;
        while(!robot.isDetectingRed())
        {
            if (timesScanned > 10)
                break;

            timesScanned++;
            robot.driveStraight(1,0,.87);
        }
        robot.driveStraight(2, 180, .87);
        robot.driveStraight(8,90,.5);
        sleep(100);

        if (timesScanned <= 4)
            robot.driveStraight(64, -135 ,.87);
        else
            robot.driveStraight(70,-144,.87);

        robot.spin(180);
        robot.driveStraight(9, 100, .95);
    }

}
