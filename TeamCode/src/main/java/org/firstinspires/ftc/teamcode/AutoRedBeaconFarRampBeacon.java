package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by jerent on 12/6/2016.
 */
@Autonomous(name = "AutoRedBeaconFarRampBeacon", group = "Autonomous")
public class AutoRedBeaconFarRampBeacon extends LinearOpMode
{
    //assumes that front omni wheels is on the bottom edge of the 2nd tle from the corner of the alliance splitter, meaning it's farther from alliance's robot from the ramp
    private OmniDriveBot robot = new OmniDriveBot();
    public void runOpMode() throws InterruptedException
    {
        robot.init(hardwareMap);

        waitForStart();

        //A suggestion but add part to shoot particles into center washing machine
        while(!gamepad1.a){}
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
            robot.driveStraight(1,0,.87);
            sleep(100);
        }

        while(!gamepad1.a){}
        robot.driveStraight(3,90,.87);
        sleep(100);
        robot.driveStraight(1,-90,.87);

        while(!gamepad1.a){}
        robot.driveStraight(40,0,.87);

        while(!gamepad1.a){}
        while(!robot.isDetectingBlue())
        {
            robot.driveStraight(1,0,.87);
            sleep(100);
        }

        while(!gamepad1.a){}
        robot.driveStraight(3,90,.87);
    }
}
