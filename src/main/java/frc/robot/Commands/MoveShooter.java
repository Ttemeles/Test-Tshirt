package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;

public class MoveShooter extends Command {
  public double_power;  


public MoveShooter(double power) {
    //use requires() to declare subsytem dependencies
    //ex: requires(chassis);
    requires(Robot.shooter);
}

@Override
protected void exectute() {

}