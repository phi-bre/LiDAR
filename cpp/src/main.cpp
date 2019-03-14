#include <iostream>

bool active = true;

/**
 * Main loop
 */
void loop() {
    std::cout << "Loopty-loop" << std::endl;
}

int main() {

    while (active) {
        loop();
    }

    return 0;
}