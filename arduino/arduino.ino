
#include <SoftwareSerial.h>
#include "TFMini.h"
#include <AFMotor.h>
#include <AccelStepper.h>

#define ABORT 1
#define BEGIN 2
#define READ_SINGLE 3
//#define CALIBRATE 4

// TF-Mini
SoftwareSerial serial(10, 11);      // Uno RX (TFMINI TX), Uno TX (TFMINI RX)
TFMini tof;

// Stepper
AF_Stepper motor(48, 1);
void forwardstep() {  
  motor.onestep(FORWARD, INTERLEAVE);
}
void backwardstep() {  
  motor.onestep(BACKWARD, INTERLEAVE);
}
AccelStepper stepper(forwardstep, backwardstep);

void setup() {
  Serial.begin(115200);
  while (!Serial);
  
  // Initialize Sensor
  serial.begin(TFMINI_BAUDRATE);
  tof.begin(&serial);
  //stepper.setSpeed(10);
  //stepper.runSpeed();
}

void read(byte buf[]) {
  uint16_t d = tof.getDistance();
  uint16_t s = tof.getRecentSignalStrength();
  
  buf[0] = (d >> 8) & 0xFF;
  buf[1] = d & 0xFF;
  buf[2] = (s >> 8) & 0xFF;
  buf[3] = s & 0xFF;
}

void loop() {
  // Send measurement
  
  for (int i = 0; i < 100; i++) {
    byte buf[4];
    read(buf);
    Serial.write(buf, 4);
    delay(25);
  }
}
