package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

/**
 * Created by David.Mitchell on 10/24/2017.
 */

@TeleOp //Not @Autonomous
public class MyFirstJavaOpMode extends LinearOpMode {
    private Gyroscope imu;
    private DcMotor motor1;
    private DigitalChannel digitalTouch;
    private DistanceSensor sensorColorRange;
    private Servo servo1;
    @Override
    public void runOpMode() {
        imu = hardwareMap.get(Gyroscope.class, "imu");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
        sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        // set digital channel to input mode.
        digitalTouch.setMode(DigitalChannel.Mode.INPUT);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // is button pressed?
            if (digitalTouch.getState() == false) {
                // button is pressed.
                telemetry.addData("Button", "PRESSED");
            } else {
                // button is not pressed.
                telemetry.addData("Button", "NOT PRESSED");
            }
            telemetry.addData("Distance (cm)", sensorColorRange.getDistance(DistanceUnit.CM));
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }

}
