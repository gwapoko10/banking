    package medicalsystem;


import java.util.ArrayList;
import java.util.Scanner;


class Appointment {
    int id;
    String date;
    String time;
    String status;
}

class Diagnosis{
   int id;
   String  details;

}

public class MedicalSystem {
   int id;
    String name;
    int age;
    String gender;
    String contact;
    String diagnosis;
    String appointmentDate;
    String appointmentTime;
    String appointmentStatus;
    ArrayList<Appointment> appointments = new ArrayList<>();
    ArrayList<Diagnosis> diagnosisHistory = new ArrayList<>();
    void insertDetails(int ID, String Name, int Age, String Gender, String Contact) {
        id = ID;
        name = Name;
        age = Age;
        gender = Gender;
        contact = Contact;
    }
     
   void displayRecord(){                                                          
     System.out.println("|Patient ID| Name    | Age     | Gender    | Contact Number|");              
       System.out.println("| "+id+"        | "+name+"      | "+age+"     | "+gender+"     | "+contact+"       |");  
     
   } 
   
  
  void addDiagnosis(int patientId, String diagnosisDetails) {
      Diagnosis diagnosis = new Diagnosis();
        diagnosis.id = patientId;
        diagnosis.details = diagnosisDetails;
        diagnosisHistory.add(diagnosis);
        System.out.println("Diagnosis added successfully for patient ID: " + patientId);
    }
  
  void ViewDiagnosis(){
      if(!diagnosisHistory.isEmpty()){
      System.out.println("Diagnosis History of "+ name);
      System.out.println("|=================================|");
      System.out.println("|Diagnosis ID| Diagnosis Details  |");
      System.out.println("|=================================|");
      
      for(int i=0 ;i<diagnosisHistory.size();i++){
          Diagnosis diagnosis = diagnosisHistory.get(i);
      System.out.println("|"+diagnosis.id+"           |"+diagnosis.details+"            |");
      }
      System.out.println("|---------------------------------|");
      
      }else{
         System.out.println("No diagnosis history available for patient ID: " + id);
      
      }
  }
  
  void addAppointment(int appointmentId, String date, String time, String status){
    Appointment appointment = new Appointment();
     appointment.id = appointmentId;
     appointment.date = date;
     appointment.time = time;
     appointment.status = status;
     appointments.add(appointment);
    System.out.println("Appointment scheduled successfully for patient ID: " + id);
  
  }
  
  void viewAppointment(){
  if(appointments.isEmpty()){
     System.out.println("No appointments available for patient ID: " + id);
  }else{
          System.out.println("|=====================================================|");
          System.out.println("| Appointment ID| Date    | Time      | Status        |");
          System.out.println("|=====================================================|");
      
      System.out.println("Appointment for Patiend ID:"+id);
      for(int i=0; i<appointments.size();i++){
          Appointment appointment = appointments.get(i);
          
          System.out.println("| "+appointment.id+"           |   "+appointment.date+"   |"+appointment.time+"       |"+appointment.status+" |");
          System.out.println("|=====================================================|");
      }   
  
  }
  
  }
  
  void updateAppointmentStatus(int appointmentIdToUpdate, String newStatus, ArrayList<MedicalSystem> patientsRecord) {
    for (int i = 0; i < patientsRecord.size(); i++) {
        MedicalSystem patient = patientsRecord.get(i);

        if (patient != null) {
            ArrayList<Appointment> appointments = patient.appointments;

            for (int j = 0; j < appointments.size(); j++) {
                Appointment appointment = appointments.get(j);

                if (appointment.id == appointmentIdToUpdate) {
                    appointment.status = newStatus;
                    System.out.println("Appointment status updated successfully for appointment ID: " + appointmentIdToUpdate);
                    return;
                }
            }
        }
    }

    System.out.println("Appointment not found with ID: " + appointmentIdToUpdate);
}

  
  
        
  
  
  void generatesreport(int reportchoice,ArrayList<MedicalSystem>patientsrecord){
      switch(reportchoice){
          case 1:
              generatePatientlistreport(patientsrecord);
              break;
          case 2:
              generateDiagnosishistory(patientsrecord);
              break;
          case 3:
              generateAppointmentreport(patientsrecord);
              break;
          case 4:
              break;
              
      
      
      
      }
  
  
  
  }
  
            void generatePatientlistreport(ArrayList<MedicalSystem>patientsrecord){
                    System.out.println("************PATIENT LIST REPORT*****************");
                       System.out.println("============================================================");
                       System.out.println("|Patient ID| Name    | Age     | Gender    | Contact Number|"); 
                      
                       for(int i = 0; i < patientsrecord.size();i++){
                           MedicalSystem patient = patientsrecord.get(i);
                          if(patient != null){ 
                       System.out.println("| "+patient.id+"        | "+patient.name+"      | "+patient.age+"     | "+patient.gender+"     | "+patient.contact+"       |");  
                       }
                       }
                       System.out.println("============================================================");

}  
            
            void generateDiagnosishistory(ArrayList<MedicalSystem>patientsrecord){
                System.out.println("****************************Diagnosis History*******************************");
              for(int i=0; i<patientsrecord.size();i++){
                MedicalSystem patient = patientsrecord.get(i);
                if(patient != null){
                    patient.ViewDiagnosis();
                
                }
              
              }
                        
            }
  
           void generateAppointmentreport(ArrayList<MedicalSystem>patientsrecord){
               System.out.println("*****************Appointment Schedule List********************");
               for(int i = 0;i<patientsrecord.size();i++){
                MedicalSystem patient = patientsrecord.get(i);
               if(patient !=null){
                 patient.viewAppointment();
               }
               
               }
           
           
           
           
           }
  
    
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     char ans;
       ArrayList<MedicalSystem>  patientsrecord = new ArrayList<>();   
     
     
        System.out.println("\t*_*_*_*_*_*_WELCOME TO THE MEDICAL RECORD SYSTEM*_*_*_*_*_*_*_*");
          
        do{
        System.out.println("\t|==========================================================|");
        System.out.println("\t|****************Option to be Selected*********************|");
        System.out.println("\t|==========================================================|");
        System.out.println("\n\t\t\t1.Add Patient.\n\t\t\t2.View Patient Information.\n\t\t\t3.Add Diagnosis.\n\t\t\t4.View Diagnosis history.\n\t\t\t"+
                "5.Schedule Appointments.\n\t\t\t6.View Appointments.\n\t\t\t7.Update Appointment Status.\n\t\t\t8.Generate Reports.\n\t\t\t9.Exits");
     
        System.out.print("\n\t\t\tEnetr Otion choosen: ");
        int options = sc.nextInt();
     
     switch(options){
    
                case 1:

                    System.out.println("\t**********Patients Details**************");
                    System.out.print("Enter new Patient ID: ");
                    int Patient_id = sc.nextInt();
                    System.out.print("Enter Patient name: ");
                    String Patient_name = sc.next();
                    System.out.print("Enter Patient age: ");
                    int Patient_age = sc.nextInt();
                    System.out.print("Enter Patient Gender: ");
                    String Patient_gender = sc.next();
                    System.out.print("Enter Patient contact No.: ");
                    String Patient_contact = sc.next();

                    
                       
                       MedicalSystem newPatient = new MedicalSystem();
                      newPatient.insertDetails(Patient_id,Patient_name,Patient_age,Patient_gender,Patient_contact);
                      patientsrecord.add(newPatient);
                     break;
                              

              

                        case 2:
                            System.out.println("\t**********Patient information****************");
                            System.out.print("Enter ID of Patient to view:");
                            int Patientidtoview = sc.nextInt();

                            boolean Idfound = false;
                            for(int i=0;i<patientsrecord.size();i++){
                                MedicalSystem patient = patientsrecord.get(i);
                                if(patient != null && patient.id == Patientidtoview){
                                patient.displayRecord();
                                Idfound = true;
                                break;
                                }
                              }
                            if(!Idfound){
                                System.out.println("Patient not found with ID:"+Patientidtoview);
                            }
                            break;
                                    case 3:
                                        System.out.println("\t**********ADD DIAGNOSIS************");
                                        System.out.print("Enter patient ID:  ");
                                        int patientidfordiagnosis = sc.nextInt();
                                        sc.nextLine();

                                        System.out.print("Enter Diagnosis Details: ");
                                        String Diagnosisdetails = sc.next();

                                        for(int i=0;i<patientsrecord.size();i++){
                                           MedicalSystem patient = patientsrecord.get(i);  
                                        if(patient != null && patient.id == patientidfordiagnosis){
                                        patient.addDiagnosis(patientidfordiagnosis, Diagnosisdetails);
                                        break;
                                        }
                                       }

                                        break;
            
                case 4:
                       System.out.println("*********VIEW DIAGNOSIS****************");   
                    System.out.print("\nEnter Patient ID to view Diagnosis History: ");
                    int patientidforhistory = sc.nextInt();

                    Idfound = false;
                    for(int i=0;i<patientsrecord.size();i++){
                         MedicalSystem patient = patientsrecord.get(i);
                    if(patient != null && patient.id == patientidforhistory){
                    patient.ViewDiagnosis();
                    Idfound = true;
                    break;
                    }
                   }
                   if(!Idfound){
                        System.out.println("Patient not found with ID: " + patientidforhistory);
                   } 

                    break;

                            case 5:
                                System.out.println("\t*********SCHEDULE APPOINTMENTS*************");
                                System.out.print("Enter Patient ID for scheduling appointment: ");
                                        int patientIdForappointment = sc.nextInt();
                                        sc.nextLine(); 
                                        System.out.print("Enter Appointment ID: ");
                                        int appointmentId = sc.nextInt();
                                        sc.nextLine(); 
                                        System.out.print("Enter Appointment Date: ");
                                        String appointmentDate = sc.nextLine();
                                        System.out.print("Enter Appointment Time: ");
                                        String appointmentTime = sc.nextLine();
                                        System.out.print("Enter Appointment Status: ");
                                        String appointmentStatus = sc.nextLine();

                                for(int i = 0; i<patientsrecord.size();i++){
                                     MedicalSystem patient = patientsrecord.get(i);
                                    if(patient !=null && patient.id == patientIdForappointment){
                                    patient.addAppointment(appointmentId,appointmentDate,appointmentTime,appointmentStatus);
                                    break;
                                    }
                                 }
                              break;

          
        case 6:
            System.out.println("\t************VIEW APPOINTMENTS**************");
            System.out.print("\nEnter Patient ID to view appointment: ");
            int patientIdforappointment = sc.nextInt();
            
                  Idfound = false;
                      for(int i=0; i<patientsrecord.size();i++){
                           MedicalSystem patient = patientsrecord.get(i);
                         if(patient !=null && patient.id == patientIdforappointment){
                         patient.viewAppointment();
                          Idfound = true;
                         break;
                }
              }
            if (!Idfound) {
                        System.out.println("Patient not found with ID: " + patientIdforappointment);
                    }
        
            break;
            
        case 7:
            
                    System.out.println("\t**********UPDATE APPOINTMENT STATUS**********");
                    System.out.print("\nEnter Appointment ID to Update Status: ");
                    int appointmentIdforupdate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Status(Scheduled,In Progress,Completed,Cancelled):");
                    String newstatus = sc.nextLine();

                    MedicalSystem Patient = new MedicalSystem();
                    Patient.updateAppointmentStatus(appointmentIdforupdate, newstatus, patientsrecord);
                    break;

            
        case 8:
             System.out.println("\t\t****GENERATE REPORTS******");
                    System.out.println("\t1. Patient List");
                    System.out.println("\t2. Diagnosis History");
                    System.out.println("\t3. Appointments Schedule");
                    System.out.println("\t4. Back");
                    System.out.print("\tPlease enter your choice: ");
                    int reportchoice = sc.nextInt();
                    
                    MedicalSystem Medsystem = new MedicalSystem();
                    Medsystem.generatesreport(reportchoice,patientsrecord);
                    
            
            break;
        case 9:
            
            System.out.println("THANK YOU FOR USING THE SYSTEM !! PLSS TYPE (N/n) TO EXIT!");
            
            break;
          
    }
              System.out.println("MAKE ANOTHER ACTION(Y/N)");
                  ans = sc.next().charAt(0);
            } while (ans == 'Y' || ans == 'y');
     
    }
    
}