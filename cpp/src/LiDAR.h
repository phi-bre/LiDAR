
#ifndef CPP_LIDAR_H
#define CPP_LIDAR_H

#include "Sensor.h"

struct measurement {
    int distance;
    int angle;
    int strength;
};

class LiDAR {
public:
    LiDAR(Sensor* sensor);
    void loop();
    measurement* getMeasurements();

private:
    Sensor* sensor;
    measurement* measurements;
};


#endif //CPP_LIDAR_H
