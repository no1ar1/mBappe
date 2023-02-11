package frc.robot;

import frc.robot.commands.TurnCmd;
import frc.robot.commands.IntakeToggle;
import frc.robot.commands.shooterToggle;
import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final Intake m_intake = Intake.getInstance();
  private final Shooter m_shooter = Shooter.getInstance();
  
  private final XboxController joystick1 = new XboxController(0);

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    driveSubsystem.setDefaultCommand(new ArcadeDriveCmd(driveSubsystem, //
    () -> joystick1.getLeftY(),
    () -> joystick1.getRightY())//
);
        new JoystickButton(joystick1, 1).onTrue(new TurnCmd(driveSubsystem));
        new JoystickButton(joystick1, 2).whileTrue(new IntakeToggle(m_intake));
        new JoystickButton(joystick1, 3).whileTrue(new shooterToggle(m_shooter));
  }
  

  public Command getAutonomousCommand() {

    return new SequentialCommandGroup( //
        new TurnCmd(driveSubsystem)//
    );
  }
}
