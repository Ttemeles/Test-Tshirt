package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class DriveWithJoystick extends Command {
    public double leftStickVal, righStickVal;
}

public DriveWithJoystick () {
    //use requires() here to declare subsystem dependencies
    //eg. requires(chassis);
    requires(Robot.drive);
}

@Override
protected void initialize() {
    SmartDashboard.putString("Drive With Joystick Running?:","Running");
}

@Override
protected void execute()
{
    leftStickVal = Robot.oi.getControllerValue(1);
    rightStickVal = Robot.oi.getControllerValue(2);

    Robot.drive.arcadeDrive(leftStickVal, -rightStickVal);
    SmartDashboard.putNumber("LeftStick Val", leftStickVal );
    SmartDashboard.putNumber("RightStick Val", rightStickVal );

@Override
protected boolean isFinished() {
    return false;
}

@Override
protected void end() {
    SmartDashboard.putString("Drive With Joystick Running"
}