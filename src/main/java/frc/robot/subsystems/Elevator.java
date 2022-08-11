package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Elevator extends SubsystemBase{
    private static Elevator instance;

    private static final int HS_M_ID = 0;
    private static final int HS_F_ID = 1;
    private static final int VSPX1_F_ID = 2;
    private static final int VSPX2_F_ID = 3;

    private HSTalon master;
    private HSTalon follower1;
    private VictorSPX follower2;
    private VictorSPX follower3;

    private final boolean masterInvert = false;
    private final boolean f1Invert = false;
    private final boolean f2Invert = false;
    private final boolean f3Invert = false;

    public Elevator(){
        master = new HSTalon(HS_M_ID);
        follower1 = new HSTalon(HS_F_ID);
        follower2 = new VictorSPX(VSPX1_F_ID);
        follower3 = new VictorSPX(VSPX2_F_ID);

        follower1.follow(master);
        follower2.follow(master);
        follower3.follow(master);


        master.setInverted(masterInvert);
        follower1.setInverted(f1Invert);
        follower2.setInverted(f2Invert);
        follower3.setInverted(f3Invert);
    }
    public static Elevator getInstance(){
        if(instance==null){
            instance = new Elevator();
        }
        return instance;
    }

    public void setPercentOutPut(double output){
        master.set(ControlMode.PercentOutput, output);
    }


}
