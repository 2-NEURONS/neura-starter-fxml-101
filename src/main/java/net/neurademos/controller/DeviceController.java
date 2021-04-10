package net.neurademos.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import jssc.SerialPortList;
import net.neurademos.light_action.SwitchOff;
import net.neurademos.light_action.SwitchOn;
import net.neurademos.port_management.DiscoverDevice;
import java.net.URL;
import java.util.ResourceBundle;


public class DeviceController implements Initializable
{

    private Thread SWOthread; // thread for switching the light ON
    private Thread SWFFthread; // Thread for switching the light Off
    @FXML
    private  ComboBox<String> lightsOperation;
    @FXML
    private Label portMessage;
    @FXML
    private ComboBox<String>  connection_device;
    ObservableList<String> port, lights;
    public final  String[] lights_array = new String[]{"ON","OFF"};
    @FXML
    public void connectDevice(ActionEvent actionEvent)
    {

            portMessage.setText(DiscoverDevice.getPort()[0] + " Connected!");
            portMessage.setTextFill(Color.web("#228B22", 0.8));

    }
    public void switchLight(ActionEvent actionEvent)
    {
        SWOthread = new Thread(new SwitchOn()); // create the thread

        if(lightsOperation.getValue().equals("ON"))
        {
           // System.out.println("Ndiyanyhwebheza ngoku");
            SWOthread.start(); // start the thread;;;;;;
        }
        else if(lightsOperation.getValue().equals("OFF"))
        {
            //System.out.println("Yhoo Tlmfo");
            SWFFthread = new Thread(new SwitchOff());

        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        lights = FXCollections.observableArrayList(lights_array);
        lightsOperation.setItems(lights);


        /**
         * accessing the Port
         */
        if(DiscoverDevice.getPort().length>0)
        {
            portMessage.setTextFill(Color.web("#228B22",0.8));
            portMessage.setText("Device Successfully Detected!");
            port = FXCollections.observableArrayList(DiscoverDevice.getPort());
            connection_device.setItems(port);
        }
        else
        {
            portMessage.setTextFill(Color.web("#ff0000",0.8));
            portMessage.setText("Please Ensure your device is attached");

        }

    }
}
