
#ifndef CPP_ROTATOR_H
#define CPP_ROTATOR_H


class Rotator {
public:
    void setSpeed(int speed);
    int getSpeed();
    int getAngle();

protected:
    int rpm;
    int angle;
};

#endif //CPP_ROTATOR_H
