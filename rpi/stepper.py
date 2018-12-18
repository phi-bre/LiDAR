from Adafruit_MotorHAT import Adafruit_MotorHAT, Adafruit_DCMotor, Adafruit_StepperMotor
from threading import Thread
import time
import atexit


class Stepper(Thread):
    def __init__(self, speed):
        # Create Adafruit Instance
        hat = Adafruit_MotorHAT()

        def turnOffMotors():
            hat.getMotor(1).run(Adafruit_MotorHAT.RELEASE)
            hat.getMotor(2).run(Adafruit_MotorHAT.RELEASE)
            hat.getMotor(3).run(Adafruit_MotorHAT.RELEASE)
            hat.getMotor(4).run(Adafruit_MotorHAT.RELEASE)

        atexit.register(turnOffMotors)

        # Initialize
        self.speed = speed
        self.instance = hat.getStepper(48, 1)
        self.instance.setSpeed(speed)
        self.running = False

        # Thread
        Thread.__init__(self)

    def run(self):
        self.running = True
        while self.running:
            self.instance.step(48, Adafruit_MotorHAT.FORWARD, Adafruit_MotorHAT.DOUBLE)

    def stop(self):
        self.running = False
        self.join()

    def setSpeed(self, speed):
        self.speed = speed
