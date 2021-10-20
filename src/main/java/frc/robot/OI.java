package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI implements RobotMap {
    private static final GenericHID Controller = null;

    public static OI instance;
    
    public static XboxController controller = new XboxController(4);
    public JoystickButton buttonA = new JoystickButton(controller, 1);
    public JoystickButton buttonB = new JoystickButton(controller, 2);
    public JoystickButton buttonX = new JoystickButton(controller, 3);
    public JoystickButton buttonRightBumper = new JoystickButton(controller, 6);
    public JoystickButton buttonLeftBumper = new JoystickButton(controller, 5);
    public OI()
{
    buttonA.whenPressed(new fireSolonoid("M"));
    buttonB.whenPressed(new fireSolonoid("R"));
    buttonX.whenPressed(new fireSolonoid("L"));
}

private double DeadbandJoystickValue(double joystickValue) {
    return(Math.abs(joystickValue) < JOYSTICK_DEADBAND ? 0.0 : joystickValue);

}

public double getControllerValue(int axis)
{
    return DeadbandJoystickValue(controller.getRawAxis(axis));

}

public double returnControllerLeftTrigger () {
    return(-((Math.abs(Controller.getRawAxis(2)) <.1) ?
    0: controller.getRawAxis(2)) + 1);
    
}
 
public double returnControllerRightTrigger() {
    return(-((Math.abs(Controller.getRawAxis(3)) <.1) ?
    0: controller.getRawAxis(3)) + 1);
}
//return absolute value of axis 3 if <.1, and if not, if it is 0, then still return value

public static boolean ControllerRightBumper() {
    return controller.getRawButton(6);

}

public static boolean ControllerLeftBumper() {
    return controller.getRawButton(5);
}

public static OI getInstance() {if(instance == null) {
        instance = new OI();
    }
    return instance; //return instance value no matter what, just want OI value
}
}