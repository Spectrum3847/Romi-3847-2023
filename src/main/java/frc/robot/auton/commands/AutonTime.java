package frc.robot.auton.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.commands.DriveTime;
import frc.robot.drivetrain.commands.TurnTime;

public class AutonTime extends SequentialCommandGroup {
    /**
     * Creates a new Autonomous Drive based on time. This will drive out for a period of time, turn
     * around for time (equivalent to time to turn around) and drive forward again. This should
     * mimic driving out, turning around and driving back.
     *
     * @param drivetrain The drive subsystem on which this command will run
     */
    public AutonTime() {
        addCommands(
                new DriveTime(-0.6, 2.0),
                new TurnTime(-0.5, 1.3),
                new DriveTime(-0.6, 2.0),
                new TurnTime(0.5, 1.3));
    }
}
