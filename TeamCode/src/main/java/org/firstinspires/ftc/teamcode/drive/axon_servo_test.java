package org.firstinspires.ftc.teamcode.drive;


import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.PwmControl;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;


@Config
@TeleOp
public class axon_servo_test extends OpMode {

    public static double b = .51;
    public static double a = .35;
    public static double x = .155;

    ServoImplEx servo;
   // AnalogInput sEncoder;
   AnalogInput sEncoder;

    @Override
    public void init() {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        servo = (ServoImplEx) hardwareMap.get(Servo.class, "servo1");
        servo.setPwmRange(new PwmControl.PwmRange(505, 2495));
        sEncoder = hardwareMap.get(AnalogInput.class, "sEncoder");

    }

    @Override
    public void loop() {

        double pos = sEncoder.getVoltage() / 3.3 * 360;

        if (gamepad1.a) {
            servo.setPosition(a);
        }
        if (gamepad1.b) {
            servo.setPosition(b);
        }
        if (gamepad1.x) {
            servo.setPosition(x);
        }
        telemetry.addData("Run time",getRuntime());
        telemetry.addData("pos", pos);
        telemetry.addData("test", 1);
        telemetry.update();
    }


}