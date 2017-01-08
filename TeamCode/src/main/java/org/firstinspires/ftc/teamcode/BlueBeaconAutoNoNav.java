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

    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();
        robot.driveStraight(58, -135, .75);
        sleep(100);
        robot.driveStraight(16, 180, .75);
        sleep(100);
        robot.spin(92);
        sleep(100);
        int forwardCount = 0;
        for (int i = 0; i < 20; i++) {
            robot.driveStraight(.75, 180, .5);
            forwardCount++;
            sleep(300);
            if (robot.isDetectingRed() == true) {
                robot.driveStraight(3, 90, .75);
                sleep(100);
                robot.driveStraight(2, -90, .75);
                break;
            }
        }
        sleep(3000);
        robot.driveStraight(20 - (.75 * forwardCount), 180, .75);
        sleep(100);
        robot.driveStraight(10, 90, .20);
        sleep(100);
        robot.driveStraight(5, -90, .50);
        sleep(100);
        robot.driveStraight(28, 180, .75);
        for (int i = 0; i < 20; i++) {
            robot.driveStraight(1, 180, .5);
            sleep(300);
            if (robot.isDetectingRed() == true) {
                robot.driveStraight(3, 90, 1);
                sleep(100);
                robot.driveStraight(2, -90, .75);
                break;
            }
        }
        robot.driveStraight(60, -45, .75);
    }
}
