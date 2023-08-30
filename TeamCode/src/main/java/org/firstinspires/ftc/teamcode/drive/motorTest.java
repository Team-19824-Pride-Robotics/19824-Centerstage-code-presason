package org.firstinspires.ftc.teamcode.drive;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(group = "drive")
@Config
public class motorTest extends LinearOpMode {

    public static double power1 = 0;
    public static double power2 = 0;

    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        DcMotor M1;
        DcMotor M2;

        M1 = hardwareMap.get(DcMotor.class, "M1");
        M2 = hardwareMap.get(DcMotor.class, "M2");

        waitForStart();

        M1.setPower(power1);
        M2.setPower(power2);


        while (!isStopRequested()) {

            telemetry.addData("Run time",getRuntime());
            telemetry.addData("M1 Power",M1.getPower());
            telemetry.addData("M2 Power",M2.getPower());
            telemetry.update();


        }
    }
}