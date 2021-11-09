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
        
        
       //reducing values, less power to shoot
      
        if(OI.controllerLeftBumper()) {
            vertPower = -.5;
        }
        else if (OI.controllerRightBumper()) {
            vertPower= .5;
        }
        else if (Math.abs(vertOffset) > 0 && targetExist) {      //
            vertPower = vertOFfset/8 * -1;
        }
        
        else {
            vertPower = 0; 
        }
        
        double latPower = 0;
        double horzPower = horizOffset/8;
        double miniPower = .3;
        double turnleft = horizOffset > 0 ? 1:-1;
        minPower = minPower * turnleft;
        horzPower = Robot.drive.limit(horzPower, .75, -.75);
        
        if(Math.abs(leftStickVal) > .15 || Math.abs(rightStickVal) > .15)
            
        {
            horzPower = rightStickVal;
            latPower = leftStickVal;
        }
        
        else if(Math.abs(leftStickVal) > .15 && Math.abs(horizOffset) > 0 && targetExist)
        {
            horzPower = horzPower + minPower;
            latPower = leftStickVal;
        }
        
        else if(Math.abs(horizOffset) > 0 &&targetExist) {
            horzPower = horzPower + minPower;
        }
        else{
            horzPower=0;
            latpower = 0;
        }
        
        double VP = .75, HP = 1;
           
        
