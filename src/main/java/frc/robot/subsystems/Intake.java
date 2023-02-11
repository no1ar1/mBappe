package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    private static Intake Instance;

    public static final TalonSRX intakeMotor = new TalonSRX(5);

    public static Intake getInstance() {
        if (Instance == null) {
            Instance = new Intake();
        }
        return Instance;
    }

    public Intake() {}

    @Override
    public void periodic() {}

    public void setMotor(boolean on) {
        double speed;
        if (on) {
            speed = 0.8;
        } else {
            speed = 0;
        }
        intakeMotor.set(ControlMode.PercentOutput, speed);
    }
}