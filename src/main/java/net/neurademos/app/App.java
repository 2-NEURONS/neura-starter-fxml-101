package net.neurademos.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

import java.time.LocalDateTime;
import java.util.Arrays;


public class App extends Application
{

  public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        primaryStage.setTitle("neura-TxRx-100");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }
/*
public static void main(String[] args)
{



    SerialPort serialPort = new SerialPort("/dev/cu.usbmodem14201");
    try
    {

        LocalDateTime switchOffTime = LocalDateTime.of(2021, 4, 5, 21, 31);

        new Thread( new Runnable()
    {

        public void run()
        {
            LocalDateTime compareTime;
            try
            {

                compareTime = LocalDateTime.of(LocalDateTime.now().getYear(),LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth(),LocalDateTime.now().getHour(), LocalDateTime.now().getMinute());

                    serialPort.openPort();//Open serial port
                    serialPort.setParams(SerialPort.BAUDRATE_115200,
                            SerialPort.DATABITS_8,
                            SerialPort.STOPBITS_1,
                            SerialPort.PARITY_NONE);
                    while(!compareTime.isEqual(switchOffTime))
                    {
                    serialPort.writeByte((byte)1);
                    Thread.sleep(5000);




                        compareTime = LocalDateTime.of(LocalDateTime.now().getYear(),LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth(),LocalDateTime.now().getHour(), LocalDateTime.now().getMinute());
                    //System.out.println(Arrays.asList(SerialPortList.getPortNames()));
                   // serialPort.closePort();
                } // whi;e
                serialPort.closePort();
            }
            catch(SerialPortException exxx)
            {

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
        ).start();
    }
    catch (Exception ex)
    {
        System.out.println(ex);
    }
}
*/

}
