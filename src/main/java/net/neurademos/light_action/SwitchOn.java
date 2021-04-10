package net.neurademos.light_action;

import jssc.SerialPort;
import net.neurademos.port_management.DiscoverDevice;

public class SwitchOn implements Runnable
{
    /**
     * A thread to run switching on operation
     */
    private final SerialPort serialPort = new SerialPort(DiscoverDevice.getPort()[0]); // inject the port
    private final LightOperation lightOperation = new LightOperation(serialPort); // pass serial port for injection
    @Override
    public void run()
    {
        lightOperation.openPort(); // open the port for communication // wala
        lightOperation.portParams(); // important for protocol data exchange
        while(true)
        {
            lightOperation.switchOn();// switch the light on
        }
    }

}
