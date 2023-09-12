package org.firstinspires.ftc.teamcode.drive;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(group = "drive")
@Config
public class spmTest extends LinearOpMode {

    public static double Pos = 0;
    public static double Pos2 = 0;

    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        Servo S1;

        S1 = hardwareMap.get(Servo.class, "S1");

        waitForStart();
        if (gamepad1.x) {
            S1.setPosition(Pos);

        }
        else if (gamepad1.a) {
            S1.setPosition(Pos2);

        }


        while (!isStopRequested()) {

            telemetry.addData("Run time",getRuntime());
            telemetry.addData("POS",Pos);
            telemetry.addData("POS2",Pos2);

            telemetry.update();


        }
    }
}