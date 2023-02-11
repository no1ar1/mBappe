package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeToggle extends CommandBase {
    private final Intake m_intake;

    public IntakeToggle(Intake m_intake) {
        this.m_intake = m_intake;
        addRequirements(m_intake);
    }

    @Override
    public void initialize() {
        System.out.println("Intake Motor Activated!");
    }

    @Override
    public void execute() {
        m_intake.setMotor(true);
    }

    @Override
    public void end(boolean interrupted) {
        m_intake.setMotor(false);
        System.out.println("Intake Motor Deactivated!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
