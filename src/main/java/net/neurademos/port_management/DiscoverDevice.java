package net.neurademos.port_management;

import jssc.SerialPortList;

public class DiscoverDevice
{
    /**
     * find device port
     * @return
     */
    public static String[] getPort()
    {
        return SerialPortList.getPortNames();
    }
}
