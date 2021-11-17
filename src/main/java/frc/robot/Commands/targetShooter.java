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
                                                //vertOffset means reducing range of fire vertically
        double vertPower = verOffset/8;     
     
      
        if(OI.controllerLeftBumper()) {     //allows the T-shirt cannnon to fire at people up high with accuracy
            vertPower = -.5;
        }
        else if (OI.controllerRightBumper()) {
            vertPower= .5;
        }
        else if (Math.abs(vertOffset) > 0 && targetExist) {     //a backup loop for code
            vertPower = vertOFfset/8 * -1;
        }
        
        else {
            vertPower = 0; 
        }
        
        double latPower = 0;
        double horzPower = horizOffset/8;e
        double miniPower = .3;
        double turnleft = horizOffset > 0 ? 1:-1;
        minPower = minPower * turnleft;
        horzPower = Robot.drive.limit(horzPower, .75, -.75);
        
        if(Math.abs(leftStickVal) > .15 || Math.abs(rightStickVal) > .15)
            
        {       
            horzPower = rightStickVal;      //relying on contorller values
                                            //rightStick controls horizontally, allows to shoot at one person or close to
            latPower = leftStickVal;            //no vertical distance needed
        }
        
        else if(Math.abs(leftStickVal) > .15 && Math.abs(horizOffset) > 0 && targetExist)
        {
            horzPower = horzPower + minPower                    // if just lefStick is pressed and this value is true, do this
            latPower = leftStickVal;                            //for special cirucumstances
        }
        
        else if(Math.abs(horizOffset) > 0 &&targetExist) {      //same thing, if controller is not pressed, but it senses someone, then still fire
            
            horzPower = horzPower + minPower;
        }
        else{
            horzPower=0;
            latpower = 0;
        }
        
        double VP = .75;
        double HP = 1;
        vertPower = vertPower * VP;
        horPower = horzPower * HP;
        Shooter.moveAerm(vertPower);
        Robot.drive.arcadeDrive(latPower, horzPower);
        
        SmartDashboard.putNumber("Horizontal Drive Power", horzPower);
        SmartDashboard.pitNumber("vertical Arm Power", vertPower);
        
        @Overide
        protected boolean isFinished() {
            returnMath.abs(horizOffset)<2 &&Math.abs(vertOffset) >=2 || Robot.oi.getControllerValue(0) >.2;
            
        }}
        
        
        
           
        
