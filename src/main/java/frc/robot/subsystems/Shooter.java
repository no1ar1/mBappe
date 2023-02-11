package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    private static Shooter Instance;

    public static final TalonSRX shooterMotor = new TalonSRX(6);
     
    public static Shooter getInstance() {
        if (Instance == null) {
            Instance = new Shooter();
        }
        return Instance;
    }

    public Shooter() {}

    @Override
    public void periodic() {}

    public void setMotor(boolean on) {
        double speed;
        if (on) {
            speed = 0.8;
        } else {
            speed = 0;
        }
        shooterMotor.set(ControlMode.PercentOutput, speed);
    }
}    

