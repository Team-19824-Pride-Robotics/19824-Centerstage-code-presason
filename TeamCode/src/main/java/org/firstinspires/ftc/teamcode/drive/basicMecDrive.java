package org.firstinspires.ftc.teamcode.drive;



import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Config
@TeleOp(group = "drive")
public class basicMecDrive extends OpMode {



    DcMotorEx FR;
    DcMotorEx FL;
    DcMotorEx BR;
    DcMotorEx BL;

    double rotate;


    @Override
    public void init() {

        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());


        FR = hardwareMap.get(DcMotorEx.class, "FR");
        FL = hardwareMap.get(DcMotorEx.class, "FL");
        BR = hardwareMap.get(DcMotorEx.class, "BR");
        BL = hardwareMap.get(DcMotorEx.class, "BL");
        BL.setDirection(DcMotorEx.Direction.REVERSE);
        FL.setDirection(DcMotorEx.Direction.REVERSE);

    }

    @Override
    public void loop() {
        telemetry.addData("Run time",getRuntime());
        telemetry.addData("FR Power", FR.getPower());
        telemetry.addData("BR Power",BR.getPower());
        telemetry.addData("FL Power", FL.getPower());
        telemetry.addData("BL Power",BL.getPower());
        telemetry.update();

        double d_power = .8-.4*gamepad1.left_trigger+(.5*gamepad1.right_trigger);
        double drive = -gamepad1.left_stick_y;
        double rotate_stick = gamepad1.right_stick_x;
        double rotate_button = 0;

        rotate = rotate_stick + .5*rotate_button;

        BL.setPower(drive + rotate);
        FL.setPower(drive + rotate);
        BR.setPower(drive - rotate);
        FR.setPower(drive - rotate);


        if (gamepad1.dpad_up) {
            BL.setPower(d_power);
            FL.setPower(d_power);
            BR.setPower(d_power);
            FR.setPower(d_power);
        }
        else if (gamepad1.dpad_down) {
            BL.setPower(-d_power);
            FL.setPower(-d_power);
            BR.setPower(-d_power);
            FR.setPower(-d_power);
        }
        else if (gamepad1.dpad_left) {
            BL.setPower(d_power);
            FL.setPower(-d_power);
            BR.setPower(-d_power);
            FR.setPower(d_power);
        }
        else if (gamepad1.dpad_right) {
            BL.setPower(-d_power);
            FL.setPower(d_power);
            BR.setPower(d_power);
            FR.setPower(-d_power);
        }



    }

}