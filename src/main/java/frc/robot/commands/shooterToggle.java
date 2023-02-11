package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class shooterToggle extends CommandBase {
    private final Shooter m_shooter;

    public shooterToggle(Shooter m_shooter) {
        this.m_shooter = m_shooter;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        System.out.println("Shooter Motor Activated!");
    }

    @Override
    public void execute() {
        m_shooter.setMotor(true);
    }

    @Override
    public void end(boolean interrupted) {
        m_shooter.setMotor(false);
        System.out.println("Shooter Motor Deactivated!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
