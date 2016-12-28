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
        boolean isBlueOnRight = true;
//      short timesScanned = 0; MAy be needed to make it so thath robot doesn't shimmy/scan until it hits wall
        robot.init(hardwareMap);

        waitForStart();

        //A suggestion but add part to shoot particles into center washing machine
        while(!gamepad1.a){}
        /*load balls, needs testing

         */
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
            if (robot.isDetectingRed())
                isBlueOnRight = false;
            robot.driveStraight(1,180,.87);
            sleep(100);
        }
        sleep(100);

        if (isBlueOnRight)
            robot.driveStraight(3,180,.87);

        while(!gamepad1.a){}
        robot.driveStraight(3,90,.87);
        sleep(100);
        robot.driveStraight(1,-90,.87);

        while(!gamepad1.a){}
        //robot.driveStraight(40,180,.87);
        if (isBlueOnRight)
            robot.driveStraight(27, 180, .87);
        else if (!isBlueOnRight)
            robot.driveStraight(22, 180, .87);

        robot.driveStraight(9, 90,.38);

        while(!gamepad1.a){}
        robot.driveStraight(3,-90,.87);
        robot.driveStraight(19, 180, .87);

        while(!gamepad1.a){}
        isBlueOnRight = true;
        while(!robot.isDetectingBlue())
        {
            if (robot.isDetectingRed())
                isBlueOnRight = false;
            robot.driveStraight(1,180,.87);
            telemetry.update();
            sleep(200);
        }

        while(!gamepad1.a){}
        robot.driveStraight(6,90,.87);
        sleep(100);

        while(!gamepad1.a){}
        if (isBlueOnRight)
        {
            robot.driveStraight(64, -55, .95);
            /*
            robot.driveStraight(4,-90,.87);
            robot.spin(115);
            while(!gamepad1.a){}
            robot.driveStraight(55,180,.87);
            */
        }
        else if (!isBlueOnRight)
        {
            robot.driveStraight(70,-48,.95);
            /*
            robot.driveStraight(4,-90);
            robot.spin(135);
            while(!gamepad1.a){}
            robot.driveStraight(59,180,.87);
            */
        }
    }
}
