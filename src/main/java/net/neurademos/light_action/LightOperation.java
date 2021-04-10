package net.neurademos.light_action;

import jssc.SerialPort;
import jssc.SerialPortException;
import net.neurademos.port_management.NeuraLightSpecification;

public class LightOperation implements NeuraLightSpecification
{


    private SerialPort serialPort;

    /**
     * Simple Gtters and Stters
     * @param serialPort
     */
    public LightOperation(SerialPort serialPort)
    {
        this.serialPort = serialPort;
    }
    public SerialPort getSerialPort()
    {
        return serialPort;
    }
    public void setSerialPort(SerialPort serialPort)
    {
        this.serialPort = serialPort;
    }

    /**
     * Seria; Communication Specific MEthods
     * @param
     */
    @Override
    public void openPort()
    {
        try
        {
            serialPort.openPort(); // open port so you communicate
        }
        catch (SerialPortException e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void switchOn()
    {
        try
        {
            serialPort.writeByte((byte)1); // send 1 00000000001

        }
        catch (SerialPortException e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void switchOff()
    {

    }
    @Override
    public void portParams()
    {
        /**
         *
         * Set some parameters for serial communication
         */
        try
        {
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
        }
        catch (SerialPortException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
