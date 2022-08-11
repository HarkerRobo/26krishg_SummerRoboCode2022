package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class WristRoller extends SubsystemBase{
    private static WristRoller instance;
    
    private static final int HS_M_ID = 0;
    private HSTalon master;
    private final boolean masterInvert = false;
 
    private WristRoller(){
        master = new HSTalon(HS_M_ID);
        master.setInverted(masterInvert);

    }

    public void setPercentOutPut(double output){
        master.set(ControlMode.PercentOutput, output);
    }
    
    public static WristRoller getInstance(){
        if(instance==null){
            instance = new WristRoller();
        }
        return instance;
    }
}
