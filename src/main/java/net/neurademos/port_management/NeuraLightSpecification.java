package net.neurademos.port_management;

import jssc.SerialPort;
import jssc.SerialPortException;

public interface NeuraLightSpecification
{
    void openPort();
    void switchOn();
    void switchOff();
    void portParams() throws SerialPortException;

}
