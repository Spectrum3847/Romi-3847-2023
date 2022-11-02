package frc.robot.drivetrain.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

/*
 * Creates a new TurnTime command. This command will turn your robot for a
 * desired rotational speed and time.
 */
public class TurnTime extends CommandBase {
    private final double m_duration;
    private final double m_rotationalSpeed;
    private long m_startTime;

    /**
     * Creates a new TurnTime.
     *
     * @param speed The speed which the robot will turn. Negative is in reverse.
     * @param time How much time to turn in seconds
     * @param drive The drive subsystem on which this command will run
     */
    public TurnTime(double speed, double time) {
        m_rotationalSpeed = speed;
        m_duration = time * 1000;
        addRequirements(Robot.drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_startTime = System.currentTimeMillis();
        Robot.drivetrain.arcadeDrive(0, 0);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        Robot.drivetrain.arcadeDrive(0, m_rotationalSpeed);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.drivetrain.arcadeDrive(0, 0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return (System.currentTimeMillis() - m_startTime) >= m_duration;
    }
}
