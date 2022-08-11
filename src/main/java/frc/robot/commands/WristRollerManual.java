package frc.robot.commands;

import frc.robot.subsystems.WristRoller;
import frc.robot.util.OI;
import frc.robot.subsystems.Intake;
import harkerrobolib.commands.IndefiniteCommand;

public class WristRollerManual extends IndefiniteCommand{
    public WristRollerManual(){
        addRequirements(WristRoller.getInstance());
    }
    



    public void execute(){
        
        if(Intake.getInstance().isIntaking()){
            WristRoller.getInstance().setPercentOutPut(0.3);
        }
        else if(OI.getInstance().getDriver().getLeftTrigger()>0.5){
            WristRoller.getInstance().setPercentOutPut(-0.3);
        }
        else
            WristRoller.getInstance().setPercentOutPut(0.1);
        
    }
    public void end(boolean interrupted){
        WristRoller.getInstance().setPercentOutPut(0);
    }
}
