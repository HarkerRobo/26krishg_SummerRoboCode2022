package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends SubsystemBase {
    private static Drivetrain instance;

    private static final int rmMOTOR_ID = 0;
    private static final int lmMOTOR_ID = 1;
    private static final int rfMOTOR_ID = 2;
    private static final int lfMOTOR_ID = 3;
    
    private HSTalon rightMaster;
    private HSTalon leftMaster;
    private VictorSPX rightFollower;
    private VictorSPX leftFollower;
    
    private static boolean rightMInvert = false;
    private static boolean leftMInvert = false;
    private static boolean rightFInvert = false;
    private static boolean leftFInvert = false;

    private Drivetrain(){
        rightMaster = new HSTalon(rmMOTOR_ID);
        leftMaster = new HSTalon(lmMOTOR_ID);
        rightFollower = new VictorSPX(rfMOTOR_ID);
        leftFollower = new VictorSPX(lfMOTOR_ID);
        rightFollower.follow(rightMaster);
        leftFollower.follow(leftMaster);


        rightMaster.setInverted(rightMInvert);
        leftMaster.setInverted(leftMInvert);
        rightFollower.setInverted(rightFInvert);
        leftFollower.setInverted(leftFInvert);
    }
    public HSTalon getrightMaster(){
        return rightMaster;
    }
    public HSTalon getleftMaster(){
        return leftMaster;
    }
    public VictorSPX getrightFollower(){
        return rightFollower;
    }
    public VictorSPX getleftFollower(){
        return leftFollower;
    }

    public void setArcadeDrive(double speed, double turn){
        rightMaster.set(ControlMode.PercentOutput, speed-turn);
        leftMaster.set(ControlMode.PercentOutput, speed+turn);
    }

    public static Drivetrain getInstance(){
        if(instance == null){
            instance = new Drivetrain();
        }
        
        return instance;
    }
}