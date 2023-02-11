package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDriveCmd extends CommandBase {

    private final DriveSubsystem driveSubsystem;
    private final DoubleSupplier speedFunctionRight, speedFunctionLeft;

    public ArcadeDriveCmd(DriveSubsystem driveSubsystem, //
            DoubleSupplier speedFunctionRight, DoubleSupplier speedFunctionLeft) {
        this.speedFunctionRight = speedFunctionRight;
        this.speedFunctionLeft = speedFunctionLeft;
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("ArcadeDriveCmd started!");
    }

    @Override
    public void execute() {
        double realTimeSpeed = speedFunctionRight.getAsDouble();
        double realTimeTurn = speedFunctionLeft.getAsDouble();

        double left = realTimeSpeed;
        double right = realTimeTurn;
        driveSubsystem.setMotors(left, right);
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("ArcadeDriveCmd ended!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
