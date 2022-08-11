package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Intake extends SubsystemBase{
    private static Intake instance;

    private boolean intaking;

    private static final int id = 0;
    private static final boolean invert = false;

    
    private HSTalon motor;

    private static final int port1 = 0;
    private static final int port2 = 1;

    private DoubleSolenoid piston;

    private Intake(){
        intaking = false;
        motor = new HSTalon(id);
        motor.setInverted(invert);

        piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, port1, port2);
    }

    public void setPercentOutPut(double output){
        motor.set(ControlMode.PercentOutput, output);
        if(output>=0.3){
            intaking = true;
        }
        else{
            intaking = false;
        }
    }
    public boolean isIntaking(){
        return intaking;
    }

    public HSTalon getMotor(){
        return motor;
    }

    public void toggleState(){
        if(piston.get()!=DoubleSolenoid.Value.kReverse){
            piston.set(DoubleSolenoid.Value.kReverse);

        }
        else{
            piston.set(DoubleSolenoid.Value.kForward);
        }
    }

    public static Intake getInstance(){
        if(instance==null){
            instance = new Intake();
        }
        return instance;
    }
}
