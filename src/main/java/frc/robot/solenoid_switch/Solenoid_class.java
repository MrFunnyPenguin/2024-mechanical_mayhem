    package frc.robot.solenoid_switch;
    
    import edu.wpi.first.wpilibj.Solenoid;
    import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

// Create a solenoid object, assuming the solenoid is connected to the first channel of the Pneumatics Module
public class Solenoid_class {
    Solenoid mySolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 35); 
}


// To activate the solenoid:

//mySolenoid.set(true); // Equivalent to "mySolenoid.set(Value.kForward)" [2, 4, 5]



// To deactivate the solenoid:

// mySolenoid.set(false); // Equivalent to "mySolenoid.set(Value.kReverse)" [2, 4] 
