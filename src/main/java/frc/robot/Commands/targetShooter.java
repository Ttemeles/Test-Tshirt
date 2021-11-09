package frc.robot.Commands;

public class targetShooter {
    public double horizOffset, vertOffset, angleOffset;
    public boolean targetExist;
    public targetShooter() {
        requires(Robot.shooter);
    
}
    
    @Override
    protected void execute()
    { 
        double leftStickval = Robot.oi.getControllerValue(1);
        double rightStickVal = Robot.oi.getControllerValue(4);
        
        double vertPower = verOffset/8;
        
        if(OI.controllerLeftBumper()) {
            vertPower = -.5;
        }
        else if (OI.controllerRightBumper()) {
            vertPower= .5;
        }
        else if (Math.abs(vertOffset) > 0 && targetExist) {
            vertPower = vertOFfset/8 * -1;
        }
        
        
