package frc.robot.commands;

import frc.robot.subsystems.Intake;
import frc.robot.util.OI;
import harkerrobolib.commands.IndefiniteCommand;

public class IntakeManual extends IndefiniteCommand{
    public IntakeManual(){
        addRequirements(Intake.getInstance());
    }
    public void execute(){
        double speed = OI.getInstance().getDriver().getRightTrigger();
        
        if(speed>0.5)
            Intake.getInstance().setPercentOutPut(0.3);
        else
            Intake.getInstance().setPercentOutPut(0);
    }
    public void end(boolean interrupted){
        Intake.getInstance().setPercentOutPut(0);
    }
}
