package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HatchLatcher extends SubsystemBase{
    private static HatchLatcher instance;
    
    private DoubleSolenoid flower;
    private DoubleSolenoid extender;

    private static final int FFlowerID=0;
    private static final int RFlowerID=1;
    private static final int FExtenderID=2;
    private static final int RExtenderID=3;


    private HatchLatcher(){
        flower = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FFlowerID, RFlowerID);
        extender = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FExtenderID, RExtenderID);
    }
    public static HatchLatcher getInstance(){
        if(instance==null){
            instance = new HatchLatcher();
        }
        return instance;
    }

    public void toggleFlower(){
        if(flower.get()!=DoubleSolenoid.Value.kReverse){
            flower.set(DoubleSolenoid.Value.kReverse);

        }
        else{
            flower.set(DoubleSolenoid.Value.kForward);
        }
    }
    public void toggleExtender(){
        if(extender.get()!=DoubleSolenoid.Value.kReverse){
            extender.set(DoubleSolenoid.Value.kReverse);

        }
        else{
            extender.set(DoubleSolenoid.Value.kForward);
        }
    }
}

