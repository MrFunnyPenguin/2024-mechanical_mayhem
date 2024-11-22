
package frc.robot.Lift;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Lift {

DigitalInput toplimitSwitch = new DigitalInput(0);
DigitalInput bottomlimitSwitch = new DigitalInput(1);
PWMVictorSPX motor = new PWMVictorSPX(0);
Joystick joystick = new Joystick(0);

  public CommandXboxController ArmOperatorController =
      new CommandXboxController(0);


    public final TalonFX rClimber = new TalonFX(30); // right climber
    //
    
    public void ClimbWithFalcon() {

    ArmOperatorController.rightTrigger().onTrue( // move right motor clockwise on right trigger
      new InstantCommand(() -> {
        rClimber.set(-0.5);
      })
    );

    ArmOperatorController.rightTrigger().onFalse( // stop when not in use
      new InstantCommand(() -> {
        rClimber.set(0);
      })
    );

    ArmOperatorController.rightBumper().onTrue( // move right motor counter-clockwise on right bumper
      new InstantCommand(() -> {
        rClimber.set(0.5);
      })
    );

    ArmOperatorController.rightBumper().onFalse( // stop when not in use
      new InstantCommand(() -> {
        rClimber.set(0);
      })
    );
    }

public void setLimitSwitch(double speed) {
    if (speed > 0) {
        if (toplimitSwitch.get()) {
            // We are going up and top limit is tripped so stop

            
           rClimber.set(0);
        
        } else {
            // We are going up but top limit is not tripped so go at commanded speed
            System.out.println("tripped");
        }
    } else {
        if (bottomlimitSwitch.get()) {
            // We are going down and bottom limit is tripped so stop
            motor.set(0);
        } else {
            // We are going down but bottom limit is not tripped so go at commanded speed
            motor.set(speed);
        }
    }
}
public void getLimitSwitch (){
   if (toplimitSwitch.get()) {
            // We are going up and top limit is tripped so stop
           System.out.println("tripped");
        
  
   }
}
}
