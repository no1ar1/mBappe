
package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnCmd extends CommandBase {
    private final DriveSubsystem driveSubsystem;

    public TurnCmd(DriveSubsystem driveSubsystem) {
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("DriveForwardCmd started!");

    }

    @Override
    public void execute() {
        // for (int i = 0; i < 500; i++) {

        double left = 1;
        double right = -1;
        for (int i = 0; i < 10; i++) {
            driveSubsystem.setMotors(left, right);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //driveSubsystem.setMotors(-left, -right);
            //try {
            //    Thread.sleep(200);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
        }
        // }
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.setMotors(0, 0);
        System.out.println("DriveForwardCmd ended!");
    }
}
