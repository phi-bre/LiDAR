
#ifndef CPP_SENSOR_H
#define CPP_SENSOR_H


class Sensor {
public:
    Sensor();
    int measure();
    bool ready();

protected:
    int rangeMax;
    int rangeMin;
};


#endif //CPP_SENSOR_H
