// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */

  //motors initiated 
  WPI_TalonFX leftBack = new WPI_TalonFX(3);
  WPI_TalonFX leftFront = new WPI_TalonFX(2);
  WPI_TalonFX rightBack = new WPI_TalonFX(9);
  WPI_TalonFX rightFront = new WPI_TalonFX(8);
  //grouping up wheels so same speed for diff drive haha

  

  MotorControllerGroup left = new MotorControllerGroup(leftBack, leftFront);
  MotorControllerGroup right = new MotorControllerGroup(rightBack, rightFront);
  
  //drive command stuff yep.
  DifferentialDrive diffDrive = new DifferentialDrive(left, right);

 
 
 public DriveSubsystem() {}

  public void drive(double speed, double turn, boolean squareInputs){
    diffDrive.arcadeDrive(speed * .25, -turn * .25, squareInputs);
    System.out.println("Input: " + speed);
    System.out.println("Turn:  " + turn * -1);
  }

  public void stop(){
    diffDrive.arcadeDrive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }



}
