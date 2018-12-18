from sensor import Sensor
from stepper import Stepper

sensor = Sensor()
stepper = Stepper(100)

#stepper.start()

while True:
    print(sensor.measure())

