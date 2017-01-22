package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Peter G on 1/8/2017.
 */
@Autonomous(name = "BlueBeaconAutoNoNav", group = "Autonomous")
public class BlueBeaconAutoNoNav extends LinearOpMode
{
    private OmniDriveBot robot = new OmniDriveBot();

    public void runOpMode()
    {
        robot.init(hardwareMap);
        waitForStart();
        //robot.driveStraight(2, -90, 0.25);
        sleep(100);
        robot.driveStraight(48, -135, .75);
        sleep(100);
        robot.driveStraight(22, 180, .75);
        sleep(100);
        robot.spin(75);
        sleep(100);
        int forwardCount = 0;
        for(int i=0; i<20; i++)
        {
            robot.driveStraight(.75, 180, .37);
            forwardCount++;
            sleep(250);
            if (robot.isDetectingBlue() == true)
            {
                robot.driveStraight(1.5, 180, .37);
                robot.driveStraight(3, 90, .37);
                sleep(100);
                robot.driveStraight(2, -90, .37);
                break;
            }
        }
        sleep(3000);
        robot.driveStraight(34-(.75*forwardCount), -180, .75);
        sleep(100);
        robot.driveStraight(18, 90, .25);
        sleep(100);
        robot.driveStraight(2, -90, .75);
        sleep(100);
        robot.driveStraight(14, -180, .75);
        robot.spin(-7.5);
        for(int i=0; i<20; i++)
        {
            robot.driveStraight(1, -180, .37);
            sleep(250);
            if (robot.isDetectingBlue() == true)
            {
                robot.driveStraight(1.5, 180, .37);
                robot.driveStraight(9, 90, .37);
                sleep(100);
                robot.driveStraight(2, -90, .37);
                break;
            }
        }
        robot.driveStraight(66, -45, .75);
        sleep(100);
        robot.spin(92);
        sleep(100);
        robot.driveStraight(10, -180, .75);
    }
}
