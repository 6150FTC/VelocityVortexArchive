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
        boolean isRedOnLeft = true;
//      short timesScanned = 0; MAy be needed to make it so thath robot doesn't shimmy/scan until it hits wall
        robot.init(hardwareMap);

        waitForStart();

        //A suggestion but add part to shoot particles into center washing machine
        while(!gamepad1.a){}
        /*load balls, needs testing

         */
        robot.driveStraight(90, 153,.87);
        sleep(100);
        while(!gamepad1.a){}
        robot.spin(90);
        sleep(100);
        while(!gamepad1.a){}
        robot.driveStraight(29,90,.87);

        while(!gamepad1.a){}
        //Next beacon,
        sleep(100);
        while(!robot.isDetectingRed())
        {
            if (robot.isDetectingBlue())
                isRedOnLeft = false;
            robot.driveStraight(1,0,.87);
            sleep(100);
        }
        sleep(100);

        if (isRedOnLeft)
            robot.driveStraight(3,0,.87);

        while(!gamepad1.a){}
        robot.driveStraight(3,90,.87);
        sleep(100);
        robot.driveStraight(1,-90,.87);

        while(!gamepad1.a){}
        //robot.driveStraight(40,180,.87);
        if (isRedOnLeft)
            robot.driveStraight(27, 0, .87);
        else if (!isRedOnLeft)
            robot.driveStraight(22, 0, .87);

        robot.driveStraight(9, 90,.38);

        while(!gamepad1.a){}
        robot.driveStraight(3,-90,.87);
        robot.driveStraight(19, 0, .87);

        while(!gamepad1.a){}
        isRedOnLeft = true;
        while(!robot.isDetectingRed())
        {
            if (robot.isDetectingBlue())
                isRedOnLeft = false;
            robot.driveStraight(1,0,.87);
            sleep(200);
        }

        if (isRedOnLeft)
            robot.driveStraight(3,0,.87);

        while(!gamepad1.a){}
        robot.driveStraight(6,90,.87);
        sleep(100);

        while(!gamepad1.a){}
        if (!isRedOnLeft)
        {
            robot.driveStraight(64, -143, .95);
            robot.spin(180);
            robot.driveStraight(8, 35, .95);
        }
        else if (isRedOnLeft)
        {
            robot.driveStraight(70,-138,.95);
            robot.spin(180);
            robot.driveStraight(8, 42, .95);
        }
    }
}
