#include <Arduino.h>

void setup() {
    Serial.begin(115200);
}

void loop() {
    Serial.print("Hello World!");
    delay(1000);
}