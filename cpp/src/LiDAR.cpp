
#include "LiDAR.h"

LiDAR::LiDAR(Sensor* sensor) {
    this->sensor = sensor;

}

void LiDAR::loop() {

}

measurement* LiDAR::getMeasurements() {
    return this->measurements;
}
