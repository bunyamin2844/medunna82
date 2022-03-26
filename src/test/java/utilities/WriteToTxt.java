package utilities;

import pojos.Appointment;
import pojos.PatientApi;
import pojos.Registrant;
import pojos.US07_AppointmentPost;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
public class WriteToTxt {
    public static void saveRegistrantData(Registrant registrant){
        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("api_registrant_data"), true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(registrant+"\n");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void saveAppointData(Appointment appointment){
        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("appointment_records"), true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(appointment+"\n");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void saveRegistrantData(List<Object> SSNIds){
        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("database_registrant_data"), false);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for(Object eachSSN: SSNIds) {
                writer.append(eachSSN + ",\n");
            }
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void savePatientData(PatientApi patientApi) {
        try {
            //src/resources/testdata/PatientData.txt
            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("patient_records"), true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(patientApi + "\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void saveAppointmentCreation(US07_AppointmentPost appointment) {
        try {

            FileWriter fileWriter = new FileWriter(ConfigurationReader.getProperty("appointment_creation_records"), true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(appointment + "\n");
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}