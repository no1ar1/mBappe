package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveSubsystem extends SubsystemBase {

    private TalonSRX leftMotor1 = new TalonSRX(1);
    private TalonSRX leftMotor2 = new TalonSRX(3);
    private TalonSRX rightMotor1 = new TalonSRX(2);
    private TalonSRX rightMotor2 = new TalonSRX(4);

    public DriveSubsystem() {
        leftMotor1.configFactoryDefault();
        leftMotor2.configFactoryDefault();
        rightMotor1.configFactoryDefault();
        rightMotor2.configFactoryDefault();

    }



    public void setMotors(double speed, double turn) {
    
        double left = speed + turn;
        double right = speed - turn;
    
        leftMotor1.set(ControlMode.PercentOutput, left);
        leftMotor2.set(ControlMode.PercentOutput, left);
        rightMotor1.set(ControlMode.PercentOutput, right);
        rightMotor2.set(ControlMode.PercentOutput, right);
    }

}
