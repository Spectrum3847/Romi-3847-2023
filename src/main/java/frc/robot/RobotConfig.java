package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class RobotConfig {

    private RobotType robotType;
    public final String Canivore = "3847";
    public final Motors motors = new Motors();
    public final Pneumatic pneumatic = new Pneumatic();
    public final String praticeBotMAC = "18:66:DA:19:D4:41";

    public final class Motors {
        public final int driveMotorLeft = 0;
        public final int driveMotorRight = 1;
        public final int ledOutput = 3;
        public final int elevatorMotor = 9;
        public final int intakeMotor = 20;
        public final int intakeFollower = 21;
    }

    public final class Pneumatic {
        public final int intake = 0;
    }

    public RobotConfig() {
        checkRobotType();
        switch (getRobotType()) {
            case COMP:
                // Set all the constants specifically for the competition robot
                break;
            case PRACTICE:
                // Set all the constants specifically for the practice robot
                break;
            case SIM:
                // Set all the constants specifically for the simulation
                break;
        }
    }

    public void checkRobotType() {
        if (Robot.isSimulation()) {
            robotType = RobotType.SIM;
            System.out.println("Robot Type: Simulation");
        } else if (Robot.MAC.equals(praticeBotMAC)) {
            robotType = RobotType.PRACTICE;
            System.out.println("Robot Type: Practice");
        } else {
            robotType = RobotType.COMP;
            System.out.println("Robot Type: Competition");
        }
    }

    public RobotType getRobotType() {
        return robotType;
    }

    public enum RobotType {
        COMP,
        PRACTICE,
        SIM
    }
}
