package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Peter G on 12/1/2016.
 */
@Autonomous(name = "RedBeaconAutoNoNav", group = "Autonomous")
public class RedBeaconAutoNoNav extends LinearOpMode
{
    private OmniDriveBot robot = new OmniDriveBot();

    public void runOpMode()
    {
        robot.init(hardwareMap);
        waitForStart();
        robot.driveStraight(58, 130, .75);
        sleep(100);
        robot.driveStraight(16.5, 180, .75);
        sleep(100);
        robot.spin(92);
        sleep(100);
        int forwardCount = 0;
        for(int i=0; i<20; i++)
        {
            robot.driveStraight(.75, 0, .5);
            forwardCount++;
            sleep(300);
            if (robot.isDetectingRed() == true)
            {
                robot.driveStraight(3, 90, .75);
                sleep(100);
                robot.driveStraight(2, -90, .75);
                break;
            }
        }
        sleep(3000);
        robot.driveStraight(20-(.75*forwardCount), 0, .75);
        sleep(100);
        robot.driveStraight(10, 90, .20);
        sleep(100);
        robot.driveStraight(4, -90, .75);
        sleep(100);
        robot.driveStraight(28, 0, .75);
        sleep(100);
        robot.spin(7);
        for(int i=0; i<20; i++)
        {
            robot.driveStraight(1, 0, .5);
            sleep(300);
            if (robot.isDetectingRed() == true)
            {
                robot.driveStraight(2, 90, 1);
                sleep(100);
                robot.driveStraight(2, -90, .75);
                break;
            }
        }
    }
}
