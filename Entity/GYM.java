package Entity;
import java.lang.*;
import java.io.*; 
import javax.swing.*;
import javax.swing.table.*;

public class GYM{
    private String traIDF,fullNameTraF,phnNumTraF,emailTraF,addressTraF,dobDateTraF,dobMonTraF,dobYrTraF,
                    identificationTraF,identificationTraCBF,specializationF, genderTraF,salaryF,experienceF;

    private String memIDF,fullNameMemF,phnNumMemF,emailMemF,addressMemF,dobDateMemF,dobMonMemF,dobYrMemF,
                    identificationMemF,paymentMethodF,identificationMemCBF, genderMemF,packageMemF;
    private File file,tempFile;
    private FileWriter fwriter;

    public GYM(){}
    public GYM(String traIDF, String fullNameTraF, String phnNumTraF, String emailTraF,String addressTraF, String dobDateTraF, String dobMonTraF, String dobYrTraF,String identificationTraF, String identificationTraCBF,String specializationF, String genderTraF,String salaryF, String experienceF){
        this.traIDF = traIDF;
        this.fullNameTraF = fullNameTraF;
        this.phnNumTraF = phnNumTraF;
        this.emailTraF = emailTraF;
        this.addressTraF = addressTraF;
        this.dobDateTraF = dobDateTraF;
        this.dobMonTraF = dobMonTraF;
        this.dobYrTraF = dobYrTraF;
        this.identificationTraF = identificationTraF;
        this.identificationTraCBF = identificationTraCBF;
        this.specializationF = specializationF;
        this.genderTraF = genderTraF;
        this.salaryF = salaryF;
        this.experienceF = experienceF;
    }

    public GYM(String memIDF, String fullNameMemF, String phnNumMemF, String emailMemF,String addressMemF, String dobDateMemF, String dobMonMemF, String dobYrMemF,String identificationMemF, String paymentMethodF,String identificationMemCBF, String genderMemF, String packageMemF){
        this.memIDF = memIDF;
        this.fullNameMemF = fullNameMemF;
        this.phnNumMemF = phnNumMemF;
        this.emailMemF = emailMemF;
        this.addressMemF = addressMemF;
        this.dobDateMemF = dobDateMemF;
        this.dobMonMemF = dobMonMemF;
        this.dobYrMemF = dobYrMemF;
        this.identificationMemF = identificationMemF;
        this.paymentMethodF = paymentMethodF;
        this.identificationMemCBF = identificationMemCBF;
        this.genderMemF = genderMemF;
        this.packageMemF = packageMemF;
    }

        public void insertTrainer() {
            try {
                file = new File("./Data/trainer.txt");
                
                if(!file.exists()){
                    file.getParentFile().mkdirs();
                    file.createNewFile();
    			}

                fwriter = new FileWriter(file, true);
                fwriter.write(
                    traIDF + "|" +
                    fullNameTraF + "|" +
                    phnNumTraF + "|" +
                    emailTraF + "|" + 
                    addressTraF + "|" +
                    dobDateTraF + "-" + dobMonTraF + "-" + dobYrTraF + "|" +
                    identificationTraF + "|" +
                    identificationTraCBF + "|" +
                    specializationF + "|" +
                    genderTraF + "|" +
                    salaryF + "|" +
                    experienceF + "\n"
                );
                fwriter.flush();
                fwriter.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null, "Trainer File Writing Error");
            }
        }

        public void insertMember() {
            try {
                file = new File("./Data/member.txt");
                if(!file.exists()){
                    file.getParentFile().mkdirs();
                    file.createNewFile();
    			}

                fwriter = new FileWriter(file, true);
                fwriter.write(
                    memIDF + "|" +
                    fullNameMemF + "|" +
                    phnNumMemF + "|" +
                    emailMemF + "|" +
                    addressMemF + "|" +
                    dobDateMemF + "-" + dobMonMemF + "-" + dobYrMemF + "|" +
                    paymentMethodF + "|" +
                    identificationMemF + "|" +
                    identificationMemCBF + "|" +
                    genderMemF + "|" +
                    packageMemF + "\n"
                );
                fwriter.flush();
                fwriter.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null, "Member File Writing Error");
            }
        }

        public void editMember(DefaultTableModel memberModel){
            try {
                FileWriter writer = new FileWriter("Data\\member.txt");
                BufferedWriter bw = new BufferedWriter(writer);
                for(int i = 0; i < memberModel.getRowCount(); i++){
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0; j < memberModel.getColumnCount(); j++){
                        sb.append(memberModel.getValueAt(i,j));
                        if(j != memberModel.getColumnCount()-1) sb.append("|");
                    }
                    bw.write(sb.toString());
                    bw.newLine();
                }
                bw.close();
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error saving member file!");
            }
        }
        public void editTrainer(DefaultTableModel trainerModel){
            try{
                FileWriter writer = new FileWriter("Data\\trainer.txt");
                BufferedWriter bw = new BufferedWriter(writer);
                for(int i = 0; i < trainerModel.getRowCount(); i++){
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0; j < trainerModel.getColumnCount(); j++){
                        sb.append(trainerModel.getValueAt(i,j));
                        if(j != trainerModel.getColumnCount()-1) sb.append("|");
                    }
                    bw.write(sb.toString());
                    bw.newLine();
                }
                bw.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error saving trainer file!");
            }
        }
        public void delMember(int selectedRow){
                try {
                    File file = new File("Data\\member.txt");
                    File tempFile = new File("Data\\member_temp.txt");

                    FileReader iF = new FileReader(file);
                    FileWriter tF = new FileWriter(tempFile);

                    BufferedReader reader = new BufferedReader(iF);
                    BufferedWriter writer = new BufferedWriter(tF);

                    String line;
                    int currentRow = 0;

                    while ((line = reader.readLine()) != null) {
                        if (currentRow != selectedRow) {
                            writer.write(line);
                            writer.newLine();
                        }
                        currentRow++;
                    }

                    writer.close();
                    reader.close();

                    if(file.delete()){
                        tempFile.renameTo(file);
                    }

                    JOptionPane.showMessageDialog(null, "Member deleted successfully!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error deleting member!");
                }
        }
        public void delTrainer(int selectedRow){
             try{
                    File file = new File("Data\\trainer.txt");
                    File tempFile = new File("Data\\trainer_temp.txt");

                    FileReader iF = new FileReader(file);
                    FileWriter tF = new FileWriter(tempFile);

                    BufferedReader reader = new BufferedReader(iF);
                    BufferedWriter writer = new BufferedWriter(tF);

                    String line;
                    int currentRow = 0;

                    while((line = reader.readLine())!= null){
                        if(currentRow!= selectedRow){
                            writer.write(line);
                            writer.newLine();
                        }
                        currentRow++;
                    }
                    writer.close();
                    reader.close();

                    if(file.delete()){
                        tempFile.renameTo(file);
                    }
                    JOptionPane.showMessageDialog(null,"Trainer deleted successfully!");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error deleting trainer!");
                }
        }
}
