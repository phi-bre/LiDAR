from Adafruit_MotorHAT import Adafruit_MotorHAT, Adafruit_DCMotor, Adafruit_StepperMotor
import time
import atexit
import sys
import json

hat = Adafruit_MotorHAT()


def turnOffMotors():
    hat.getMotor(1).run(Adafruit_MotorHAT.RELEASE)
    hat.getMotor(2).run(Adafruit_MotorHAT.RELEASE)
    hat.getMotor(3).run(Adafruit_MotorHAT.RELEASE)
    hat.getMotor(4).run(Adafruit_MotorHAT.RELEASE)


atexit.register(turnOffMotors)

stepper = hat.getStepper(200, 1)
stepper.setSpeed(255)
stepper.step(1000, Adafruit_MotorHAT.FORWARD, Adafruit_MotorHAT.MICROSTEP)
