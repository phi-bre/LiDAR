import serial
import time


class Sensor:
    def __init__(self):
        self.port = serial.Serial("/dev/ttyS0", 115200)
        if not self.port.isOpen():
            self.port.open()

    def measure(self):
        while True:
            count = self.port.in_waiting
            if count >= 9:
                recv = self.port.read(9)
                self.port.reset_input_buffer()
                if recv[0] == 'Y' and recv[1] == 'Y':  # 0x59 is 'Y'
                    low = int(recv[2].encode('hex'), 16)
                    high = int(recv[3].encode('hex'), 16)
                    distance = low + high * 256

                    s1 = int(recv[4].encode('hex'), 16)
                    s2 = int(recv[5].encode('hex'), 16)
                    strength = s1 + s2 * 256
                    return distance
