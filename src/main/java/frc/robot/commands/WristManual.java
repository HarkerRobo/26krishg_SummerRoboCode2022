package frc.robot.commands;

import frc.robot.subsystems.Wrist;
import frc.robot.util.OI;
import harkerrobolib.commands.IndefiniteCommand;

public class WristManual extends IndefiniteCommand{
    public WristManual(){
        addRequirements(Wrist.getInstance());
    }

    public void execute(){
        boolean upDPad = OI.getInstance().getDriver().getUpDPadButton().get();
        boolean downDPad = OI.getInstance().getDriver().getDownDPadButton().get();
        
        if(downDPad)
            Wrist.getInstance().setPercentOutPut(-0.7);

        else if(upDPad)
            Wrist.getInstance().setPercentOutPut(0.7);
        
        else
            Wrist.getInstance().setPercentOutPut(0.2);
        
    }
    public void end(boolean interrupted){
        Wrist.getInstance().setPercentOutPut(0);
    }
}

