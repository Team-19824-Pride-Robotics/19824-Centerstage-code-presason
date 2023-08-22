package org.firstinspires.ftc.teamcode.drive;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystem.subsystemServo;

/**
 * A simple command that grabs a stone with the
 * {@link subsystemServo}.  Written explicitly for
 * pedagogical purposes. Actual code should inline a
 * command this simple with {@link
 * com.arcrobotics.ftclib.command.InstantCommand}.
 */
public class servoTest extends CommandBase {

    // The subsystem the command runs on
    private final subsystemServo m_gripperSubsystem;

    public servoTest(subsystemServo subsystem) {
        m_gripperSubsystem = subsystem;
        addRequirements(m_gripperSubsystem);
    }

    @Override
    public void initialize() {
        m_gripperSubsystem.grab();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}