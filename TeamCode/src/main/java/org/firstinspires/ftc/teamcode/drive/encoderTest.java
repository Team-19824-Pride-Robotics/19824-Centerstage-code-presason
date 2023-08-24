package org.firstinspires.ftc.teamcode.drive;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.dashboard.FtcDashboard;


@TeleOp(group = "drive")
@Config
public class encoderTest extends LinearOpMode {

    public void runOpMode() throws InterruptedException {
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        DcMotor FR;
        DcMotor FL;
        DcMotor BR;
        DcMotor BL;
        FR = hardwareMap.get(DcMotor.class, "FR");
        FL = hardwareMap.get(DcMotor.class, "FL");
        BR = hardwareMap.get(DcMotor.class, "BR");
        BL = hardwareMap.get(DcMotor.class, "BL");

        waitForStart();

        while (!isStopRequested()) {
            telemetry.addData(" FRX Encoder", FR.getCurrentPosition());
            telemetry.addData(" FL Encoder", FL.getCurrentPosition());
            telemetry.addData(" BR Encoder", BR.getCurrentPosition());
            telemetry.addData(" BL Encoder", BL.getCurrentPosition());
            telemetry.addData("Run time",getRuntime());
            telemetry.update();


        }
    }
}