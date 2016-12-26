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
        boolean firstBeaconIsBlueFirst = true;
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
            if(robot.isDetectingRed())
            {
                firstBeaconIsBlueFirst = false;
            }
            robot.driveStraight(1,180,.87);
            sleep(200);
        }
        sleep(100);

        if(firstBeaconIsBlueFirst)
        {
            robot.driveStraight(3,180,.87);
        }

        while(!gamepad1.a){}
        robot.driveStraight(3,90,.87);
        sleep(100);
        robot.driveStraight(1,-90,.87);

        while(!gamepad1.a){}
        robot.driveStraight(40,180,.87);

        while(!gamepad1.a){}
        while(!robot.isDetectingBlue())
        {
            robot.driveStraight(1,180,.87);
            telemetry.update();
            sleep(200);
        }

        while(!gamepad1.a){}
        robot.driveStraight(3,90,.87);
    }
}
