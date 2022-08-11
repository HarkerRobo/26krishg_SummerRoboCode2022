package frc.robot.util;

public class OI {
    private static OI instance;

    private static final int XBoxGamepadDriver;

    private OI(){

    }

    private static OI getInstance(){
        if(instance==null){
            instance = new OI();
        }
        return instance;
    }
}
