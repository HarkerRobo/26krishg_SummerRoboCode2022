package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Wrist extends SubsystemBase{
    private static Wrist instance;

    private static final int HS_M_ID = 0;
    private static final int VSPX_F_ID = 1;

    private HSTalon master;
    private VictorSPX follower;

    private final boolean masterInvert = false;
    private final boolean fInvert = false;

    private Wrist(){
        master = new HSTalon(HS_M_ID);
        follower = new VictorSPX(VSPX_F_ID);

        follower.follow(master);

        master.setInverted(masterInvert);
        follower.setInverted(fInvert);
        
    }
    public static Wrist getInstance(){
        if(instance==null){
            instance = new Wrist();
        }
        return instance;
    }

    public void setPercentOutPut(double output){
        master.set(ControlMode.PercentOutput, output);
    }
}
    
