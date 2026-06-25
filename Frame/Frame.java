    package Frame;

    import Entity.GYM;

    import javax.swing.*;
    import javax.swing.table.*;
    import java.awt.*;
    import java.io.*;
    import java.awt.event.*;

    public class Frame extends JFrame implements ActionListener, MouseListener{
        
        // Instance Variable
        private JPanel background, menuPanel, introPanel, addPanel, addMemPanel,addTraPanel, accListPanel, memListPanel, traListPanel;
        private JLabel imageEF;
        private ImageIcon iconEF,iconIntro,iconSrcAcc,iconAddAcc;
        private JButton exitBt,introPanelBt,addAccBt,accListBt,viewAccBt;
        private Font fontForButton,fontForTitle,fontForTextB,fontForText,fontForHighlight,fontForVer;

        //Intro Panel
        private JButton addBt,listBt;
        private JLabel welcome;
        private JLabel management,version;
        private JLabel imgEFintro;
        private ImageIcon iconEFintro;
        
        //ADD A NEW ACCOUNT
        private JLabel addANewAcc,member,trainer;
        private JLabel imgMember,imgTrainer;
        private ImageIcon iconMember,iconTrainer;

        private JLabel backarrowMem,backarrowTra, mem,tra;
        private Font fontForBack;

        //ADD A NEW ACCOUNT - MEMBER
        private JLabel addANewAccMem,memID,fullNameMem,ageMem,phnNumMem,emailMem,addressMem,genderMem,packageMem,paymentMethod,identificationMem;
        private JLabel imgMember2,imgTrainer2;
        private JTextField memIDTF,fullNameMemTF,phnNumMemTF,emailMemTF;
        private JTextArea addressMemTF;
        private JComboBox dobDateMem,dobMonMem,dobYrMem, identificationMemCB;
        private JRadioButton genderMaleForMem, genderFemaleForMem, monthly, quarterly, yearly;
        private JButton submitMem;
        private JPasswordField identificationMemPF;
        private ButtonGroup genderBG,membershipBG;
        private JCheckBox bKash,nagad,cash,card,bank;
        private JButton hideMem;
        private ImageIcon hideicon;

        //ADD A NEW ACCOUNT - TRAINER
        private JLabel addANewAccTra,traID,fullNameTra,ageTra,phnNumTra,emailTra,addressTra,genderTra,specialization,salary,experience,identificationTra;
        private JTextField traIDTF,fullNameTraTF, phnNumTraTF,emailTraTF,salaryTF,experienceTF;
        private JTextArea addressTraTF;
        private JPasswordField identificationTraPF;
        private JCheckBox cardio, weightTraining, crossFit, yoga;
        private JButton submitTra;
        private JComboBox dobDateTra,dobMonTra,dobYrTra, identificationTraCB;
        private JRadioButton genderFemaleForTra,genderMaleForTra;
        private ButtonGroup genderTraBG;
        private JButton hideTra;

        // Account List
        private JLabel accountList;
        private JButton delButton, addButton, editButton;
        private JLabel trainerList, memberList;
        private JLabel trainerListTxt, memberListTxt;
        private GYM gym;
        
        // Member List
        private JLabel memList;
        private JLabel backarrowListMem;
        private JLabel mem2,accountListMem;
        private JPanel memberTabP;
        private JTable memberTab;
        private DefaultTableModel memberModel;
        private JScrollPane scrollMem;
        private JButton addForMem,delForMem,editForMem;
        private int editingMemberRow = -1;

        // Trainer List
        private JLabel traList;
        private JLabel backarrowListTra;
        private JLabel tra2,accountListTra;
        private JPanel trainerTabP;
        private JTable trainerTab;
        private DefaultTableModel trainerModel;
        private JScrollPane scrollTra;
        private JButton addForTra,delForTra,editForTra;
        private int editingTrainerRow = -1;


        public Frame(){
            // important step for frame
            super("Eminents Fitness");
            super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            super.setBounds(320,180,1295,758);
            super.getContentPane().setBackground(new Color(0x222222));
            super.setLayout(null);

            //menu panel
            menuPanel = new JPanel();
            menuPanel.setLayout(null);
            menuPanel.setBounds(0,0,256,720);
            menuPanel.setBackground(new Color(0x2B2B2B));
            super.add(menuPanel);

            //importing icon for menu
            iconEF = new ImageIcon("Picture\\icon.png");
            imageEF = new JLabel(iconEF);
            imageEF.setBounds(33,34,140,48);
            menuPanel.add(imageEF);

            //introboard Button (icon + text)
            //icon
            iconIntro = new ImageIcon("Picture\\iconHome.png");
            //Actual bt
            introPanelBt = new JButton("Home",iconIntro);
            introPanelBt.setBackground(new Color(0x262626));
            introPanelBt.setBounds(20,120,205,30);
            introPanelBt.setForeground(Color.WHITE);
            menuPanel.add(introPanelBt);

            //add accout Button (icon + text)
            //icon
            iconAddAcc = new ImageIcon("Picture\\addAccIcon.png");
            //Actual bt
            addAccBt = new JButton("Add New Account",iconAddAcc);
            addAccBt.setBackground(new Color(0x262626));
            addAccBt.setBounds(20,157,205,30);
            addAccBt.setForeground(Color.WHITE);
            menuPanel.add(addAccBt);

            //search accout Button (icon + text)
            //icon
            iconSrcAcc = new ImageIcon("Picture\\searchAccIcon.png");
            //Actual bt
            accListBt = new JButton("Account List",iconSrcAcc);
            accListBt.setBackground(new Color(0x262626));
            accListBt.setBounds(20,194,205,30);
            accListBt.setForeground(Color.WHITE);
            menuPanel.add(accListBt);


            //exit button
            exitBt = new JButton("Exit");
            exitBt.setBackground(new Color(0xBA2222));
            exitBt.setBounds(20,667,205,30);
            exitBt.setForeground(new Color(0xFFFFFF));
            menuPanel.add(exitBt);
            
            //intro Panel
            introPanel = new JPanel();
            introPanel.setLayout(null);
            introPanel.setBounds(266,14,1004,691);
            introPanel.setBackground(new Color(0x2B2B2B));
            super.add(introPanel);

            iconEFintro = new ImageIcon("Picture\\iconIntro.png");
            imgEFintro = new JLabel(iconEFintro);
            imgEFintro.setBounds(53,67,332,114);
            introPanel.add(imgEFintro);

            welcome = new JLabel("Welcome to Eminents Fitness");
            welcome.setBounds(53,208,782,66);
            welcome.setForeground(Color.WHITE);
            introPanel.add(welcome);

            management = new JLabel("GYM Management System");
            management.setBounds(53,274,352,27);
            management.setForeground(Color.WHITE);
            introPanel.add(management);

            addBt = new JButton("Add New Account");
            addBt.setBounds(53,331,183,44);
            addBt.setForeground(new Color(0xffffff));
            addBt.setBackground(new Color(0x0c8ce9));
            introPanel.add(addBt);

            listBt = new JButton("Account List");
            listBt.setBounds(256,331,183,44);
            listBt.setForeground(new Color(0xffffff));
            listBt.setBackground(new Color(0x369AE0));
            introPanel.add(listBt);

            version = new JLabel("v1.0 by NayX");
            version.setBounds(933,666,112,28);
            version.setForeground(new Color(0x202136));
            introPanel.add(version);


            //Add New Accout - Main
            addPanel = new JPanel();
            addPanel.setLayout(null);
            addPanel.setBounds(266,14,1004,691);
            addPanel.setBackground(new Color(0x2B2B2B));
            super.add(addPanel);

            addANewAcc = new JLabel("Add A New Account");
            addANewAcc.setBounds(53,62,437,66);
            addANewAcc.setForeground(new Color(0xFFFFFF));
            addPanel.add(addANewAcc);
            
            iconMember = new ImageIcon("Picture\\member.png");
            imgMember = new JLabel(iconMember);
            imgMember.setBounds(53,157,250,250);
            addPanel.add(imgMember);

            member = new JLabel("Member");
            member.setBounds(130,427,80,27);
            member.setForeground(new Color(0xFFFFFF));
            addPanel.add(member);

            iconTrainer = new ImageIcon("Picture\\Trainer.png");
            imgTrainer = new JLabel(iconTrainer);
            imgTrainer.setBounds(349,157,250,250);
            addPanel.add(imgTrainer);

            trainer = new JLabel("Trainer");
            trainer.setBounds(433,427,80,27);
            trainer.setForeground(new Color(0xFFFFFF));
            addPanel.add(trainer);


            

            //Add new Account - Member
            addMemPanel = new JPanel();
            addMemPanel.setLayout(null);
            addMemPanel.setBounds(266,14,1004,691);
            addMemPanel.setBackground(new Color(0x2B2B2B));
            super.add(addMemPanel);
            
            addANewAccMem = new JLabel("Add A New Account");
            addANewAccMem.setBounds(53,49,437,66);
            addANewAccMem.setForeground(new Color(0xFFFFFF));
            addMemPanel.add(addANewAccMem);

            backarrowMem = new JLabel("<");
            backarrowMem.setBounds(53,100,23,49);
            backarrowMem.setForeground(new Color(0xFFFFFF));
            addMemPanel.add(backarrowMem);
            
            mem = new JLabel("Member");
            mem.setBounds(76,115,94,22);
            mem.setForeground(new Color(0xFFFFFF));
            addMemPanel.add(mem);

            submitMem = new JButton("Submit");
            submitMem.setBounds(53,611,135,27);
            submitMem.setBackground(new Color(0x0C8CE9));
            submitMem.setForeground(new Color(0xffffff));
            addMemPanel.add(submitMem);

            imgMember2 = new JLabel(iconMember);
            imgMember2.setBounds(708,156,250,250);
            addMemPanel.add(imgMember2);

            memID = new JLabel("Member ID");
            memID.setBounds(53,160,59,16);
            memID.setForeground(new Color(0xFFFFFF));
            addMemPanel.add(memID);

            memIDTF = new JTextField();
            memIDTF.setBounds(53,179,125,27);
            addMemPanel.add(memIDTF);

            fullNameMem = new JLabel("Full Name");
            fullNameMem.setBounds(53,224,54,16);
            fullNameMem.setForeground(new Color(0xFFFFFF));
            addMemPanel.add(fullNameMem);

            fullNameMemTF = new JTextField();
            fullNameMemTF.setBounds(53,243,269,27);
            addMemPanel.add(fullNameMemTF);

            ageMem = new JLabel("Date of birth");
            ageMem.setBounds(53,283,69,16);
            ageMem.setForeground(new Color(0xFFFFFF));
            addMemPanel.add(ageMem);

            String date[] = {"","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
            dobDateMem = new JComboBox(date);
            dobDateMem.setBounds(53,302,44,27);
            addMemPanel.add(dobDateMem);       

            String month[] = {"", "January", "February", "March", "April", "May", "June","July", "August", "September", "October", "November", "December"};
            dobMonMem = new JComboBox(month);
            dobMonMem.setBounds(103,302,100,27);
            addMemPanel.add(dobMonMem);

            String year[] = {"", "1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};
            dobYrMem = new JComboBox(year);
            dobYrMem.setBounds(210,302,80,27);
            addMemPanel.add(dobYrMem);

            phnNumMem = new JLabel("Phone Number");
            phnNumMem.setBounds(53,342,82,16);
            phnNumMem.setForeground(new Color(0xFFFFFF));
            addMemPanel.add(phnNumMem);

            phnNumMemTF = new JTextField();
            phnNumMemTF.setBounds(53,361,269,27);
            addMemPanel.add(phnNumMemTF);

            emailMem = new JLabel("Email");
            emailMem.setBounds(53,399,30,16);
            emailMem.setForeground(new Color(0xFFFFFF));
            addMemPanel.add(emailMem);

            emailMemTF = new JTextField();
            emailMemTF.setBounds(53,418,269,27);
            addMemPanel.add(emailMemTF);

            addressMem = new JLabel("Address");
            addressMem.setBounds(53,455,46,16);
            addressMem.setForeground(new Color(0xFFFFFF));
            addMemPanel.add(addressMem);

            addressMemTF = new JTextArea();
            addressMemTF.setBounds(53,474,269,73);
            addMemPanel.add(addressMemTF);

            genderMem = new JLabel("Gender");
            genderMem.setBounds(405,224,41,16);
            genderMem.setForeground(new Color(0xFFFFFF));
            addMemPanel.add(genderMem);

            genderMaleForMem = new JRadioButton("Male");
            genderMaleForMem.setBounds(405,249,61,16);
            genderMaleForMem.setForeground(new Color(0xFFFFFF));
            genderMaleForMem.setBackground(new Color(0x2B2B2B));
            addMemPanel.add(genderMaleForMem);

            genderFemaleForMem = new JRadioButton("Female");
            genderFemaleForMem.setBounds(485,249,70,16);
            genderFemaleForMem.setBackground(new Color(0x2B2B2B));
            genderFemaleForMem.setForeground(new Color(0xFFFFFF));
            addMemPanel.add(genderFemaleForMem);

            genderBG = new ButtonGroup();
            genderBG.add(genderFemaleForMem);
            genderBG.add(genderMaleForMem);

            packageMem = new JLabel("Membership");
            packageMem.setBounds(405,283,69,16);
            packageMem.setForeground(new Color(0xFFFFFF));
            addMemPanel.add(packageMem);

            monthly = new JRadioButton("Monthly");
            monthly.setBounds(405,304,70,16);
            monthly.setBackground(new Color(0x2B2B2B));
            monthly.setForeground(new Color(0xFFFFFF));
            addMemPanel.add(monthly);

            quarterly = new JRadioButton("Quarterly");
            quarterly.setBounds(485,304,80,16);
            quarterly.setBackground(new Color(0x2b2b2b));
            quarterly.setForeground(new Color(0xffffff));
            addMemPanel.add(quarterly);

            yearly = new JRadioButton("Yearly");
            yearly.setBounds(575,304,60,16);
            yearly.setForeground(new Color(0xffffff));
            yearly.setBackground(new Color(0x2b2b2b));
            addMemPanel.add(yearly);

            membershipBG = new ButtonGroup();
            membershipBG.add(monthly);
            membershipBG.add(quarterly);
            membershipBG.add(yearly);

            paymentMethod = new JLabel("Payment Method");
            paymentMethod.setBounds(405,339,101,16);
            paymentMethod.setForeground(new Color(0xFFFFFF));
            addMemPanel.add(paymentMethod);

            bKash = new JCheckBox("bKash");
            bKash.setBounds(405,360,70,16);
            bKash.setForeground(new Color(0xffffff));
            bKash.setBackground(new Color(0x2b2b2b));
            addMemPanel.add(bKash);

            nagad = new JCheckBox("Nagad");
            nagad.setBounds(405,383,70,16);
            nagad.setBackground(new Color(0x2b2b2b));
            nagad.setForeground(new Color(0xffffff));
            addMemPanel.add(nagad);

            card = new JCheckBox("Card");
            card.setBounds(405,406,70,16);
            card.setBackground(new Color(0x2b2b2b));
            card.setForeground(new Color(0xffffff));
            addMemPanel.add(card);
            
            bank = new JCheckBox("Bank");
            bank.setBounds(405,429,70,16);
            bank.setBackground(new Color(0x2b2b2b));
            bank.setForeground(new Color(0xffffff));
            addMemPanel.add(bank);

            cash = new JCheckBox("Cash");
            cash.setBounds(405,452,70,16);
            cash.setBackground(new Color(0x2b2b2b));
            cash.setForeground(new Color(0xffffff));
            addMemPanel.add(cash);

            String identificationList[] = {"","National ID","Birth Certificate","Passport","Driving License"};
            identificationMem = new JLabel("Identification");
            identificationMem.setBounds(405,506,82,16);
            identificationMem.setForeground(new Color(0xffffff));
            addMemPanel.add(identificationMem);

            identificationMemCB = new JComboBox(identificationList);
            identificationMemCB.setBounds(405,523,120,27);
            addMemPanel.add(identificationMemCB);

            identificationMemPF = new JPasswordField();
            identificationMemPF.setBounds(532,523,161,27);
            identificationMemPF.setEchoChar('*');
            addMemPanel.add(identificationMemPF);

            hideicon = new ImageIcon("Picture\\visibilityOff.png");
            hideMem = new JButton(hideicon);
            hideMem.setBounds(700,523,27,27);
            hideMem.setBackground(new Color(0x000000));
            hideMem.setForeground(new Color(0xffffff));
            addMemPanel.add(hideMem);

            //Add new Account - Trainer
            addTraPanel = new JPanel();
            addTraPanel.setLayout(null);
            addTraPanel.setBounds(266,14,1004,691);
            addTraPanel.setBackground(new Color(0x2B2B2B));
            super.add(addTraPanel);

            addANewAccTra = new JLabel("Add A New Account");
            addANewAccTra.setBounds(53,49,437,66);
            addANewAccTra.setForeground(new Color(0xFFFFFF));
            addTraPanel.add(addANewAccTra);

            backarrowTra = new JLabel("<");
            backarrowTra.setBounds(53,100,23,49);
            backarrowTra.setForeground(new Color(0xFFFFFF));
            addTraPanel.add(backarrowTra);

            submitTra = new JButton("Submit");
            submitTra.setBounds(53,611,135,27);
            submitTra.setBackground(new Color(0x0C8CE9));
            submitTra.setForeground(new Color(0xffffff));
            addTraPanel.add(submitTra);

            tra = new JLabel("Trainer");
            tra.setBounds(76,115,94,22);
            tra.setForeground(new Color(0xFFFFFF));
            addTraPanel.add(tra);

            imgTrainer2 = new JLabel(iconTrainer);
            imgTrainer2.setBounds(708,156,250,250);
            addTraPanel.add(imgTrainer2);

            traID = new JLabel("Trainer ID");
            traID.setBounds(53,160,59,16);
            traID.setForeground(new Color(0xFFFFFF));
            addTraPanel.add(traID);

            traIDTF = new JTextField();
            traIDTF.setBounds(53,179,125,27);
            addTraPanel.add(traIDTF);

            fullNameTra = new JLabel("Full Name");
            fullNameTra.setBounds(53,224,54,16);
            fullNameTra.setForeground(new Color(0xFFFFFF));
            addTraPanel.add(fullNameTra);

            fullNameTraTF = new JTextField();
            fullNameTraTF.setBounds(53,243,269,27);
            addTraPanel.add(fullNameTraTF);

            ageTra = new JLabel("Date of birth");
            ageTra.setBounds(53,283,69,16);
            ageTra.setForeground(new Color(0xFFFFFF));
            addTraPanel.add(ageTra);

            dobDateTra = new JComboBox(date);
            dobDateTra.setBounds(53,302,44,27);
            addTraPanel.add(dobDateTra);       

            dobMonTra = new JComboBox(month);
            dobMonTra.setBounds(103,302,100,27);
            addTraPanel.add(dobMonTra);

            dobYrTra = new JComboBox(year);
            dobYrTra.setBounds(210,302,80,27);
            addTraPanel.add(dobYrTra);

            phnNumTra = new JLabel("Phone Number");
            phnNumTra.setBounds(53,342,82,16);
            phnNumTra.setForeground(new Color(0xFFFFFF));
            addTraPanel.add(phnNumTra);

            phnNumTraTF = new JTextField();
            phnNumTraTF.setBounds(53,361,269,27);
            addTraPanel.add(phnNumTraTF);

            emailTra = new JLabel("Email");
            emailTra.setBounds(53,399,30,16);
            emailTra.setForeground(new Color(0xFFFFFF));
            addTraPanel.add(emailTra);

            emailTraTF = new JTextField();
            emailTraTF.setBounds(53,418,269,27);
            addTraPanel.add(emailTraTF);

            addressTra = new JLabel("Address");
            addressTra.setBounds(53,455,46,16);
            addressTra.setForeground(new Color(0xFFFFFF));
            addTraPanel.add(addressTra);

            addressTraTF = new JTextArea();
            addressTraTF.setBounds(53,474,269,73);
            addTraPanel.add(addressTraTF);

            genderTra = new JLabel("Gender");
            genderTra.setBounds(405,180,41,16);
            genderTra.setForeground(new Color(0xFFFFFF));
            addTraPanel.add(genderTra);

            genderMaleForTra = new JRadioButton("Male");
            genderMaleForTra.setBounds(405,200,61,16);
            genderMaleForTra.setForeground(new Color(0xFFFFFF));
            genderMaleForTra.setBackground(new Color(0x2B2B2B));
            addTraPanel.add(genderMaleForTra);

            genderFemaleForTra = new JRadioButton("Female");
            genderFemaleForTra.setBounds(485,200,70,16);
            genderFemaleForTra.setBackground(new Color(0x2B2B2B));
            genderFemaleForTra.setForeground(new Color(0xFFFFFF));
            addTraPanel.add(genderFemaleForTra);

            genderTraBG = new ButtonGroup();
            genderTraBG.add(genderFemaleForTra);
            genderTraBG.add(genderMaleForTra);

            specialization = new JLabel("Specialization");
            specialization.setBounds(405,237,100,16);
            specialization.setBackground(new Color(0x2b2b2b));
            specialization.setForeground(new Color(0xffffff));
            addTraPanel.add(specialization);

            cardio = new JCheckBox("Cardio");
            cardio.setBounds(405,260,80,16);
            cardio.setBackground(new Color(0x2b2b2b));
            cardio.setForeground(new Color(0xffffff));
            addTraPanel.add(cardio);

            weightTraining = new JCheckBox("Weight Training");
            weightTraining.setBounds(405,288,170,16);
            weightTraining.setBackground(new Color(0x2b2b2b));
            weightTraining.setForeground(new Color(0xffffff));
            addTraPanel.add(weightTraining);

            crossFit = new JCheckBox("Cross Fit");
            crossFit.setBounds(405,318,170,16);
            crossFit.setBackground(new Color(0x2b2b2b));
            crossFit.setForeground(new Color(0xffffff));
            addTraPanel.add(crossFit);

            yoga = new JCheckBox("Yoga");
            yoga.setBounds(405,348,70,16);
            yoga.setBackground(new Color(0x2b2b2b));
            yoga.setForeground(new Color(0xffffff));
            addTraPanel.add(yoga);

            salary = new JLabel("Salary");
            salary.setBounds(405,381,160,27);
            salary.setForeground(new Color(0xffffff));
            addTraPanel.add(salary);

            salaryTF = new JTextField();
            salaryTF.setBounds(405,402,160,27);
            addTraPanel.add(salaryTF);

            experience = new JLabel("Experience (in year)");
            experience.setBounds(405,442,110,16);
            experience.setForeground(new Color(0xffffff));
            addTraPanel.add(experience);

            experienceTF = new JTextField();
            experienceTF.setBounds(405,460,160,27);
            addTraPanel.add(experienceTF);

            identificationTra = new JLabel("Identification");
            identificationTra.setBounds(405,506,82,16);
            identificationTra.setForeground(new Color(0xffffff));
            addTraPanel.add(identificationTra);

            identificationTraCB = new JComboBox(identificationList);
            identificationTraCB.setBounds(405,523,120,27);
            addTraPanel.add(identificationTraCB);

            identificationTraPF = new JPasswordField();
            identificationTraPF.setBounds(532,523,161,27);
            identificationTraPF.setEchoChar('*'); 
            addTraPanel.add(identificationTraPF);

            hideTra = new JButton(hideicon);
            hideTra.setBounds(700,523,27,27);
            hideTra.setForeground(new Color(0xffffff));
            hideTra.setBackground(new Color(0x000000));
            addTraPanel.add(hideTra);

            // Accout
            accListPanel = new JPanel();
            accListPanel.setLayout(null);
            accListPanel.setBounds(266,14,1004,691);
            accListPanel.setBackground(new Color(0x2b2b2b));
            super.add(accListPanel);

            accountList = new JLabel("Account List");
            accountList.setBounds(53,51,292,66);
            accountList.setForeground(new Color(0xffffff));
            accListPanel.add(accountList);

            memberList = new JLabel(iconMember);
            memberList.setBounds(53,146,250,250);
            accListPanel.add(memberList);

            memberListTxt = new JLabel("Member");
            memberListTxt.setBounds(130,416,80,27);
            memberListTxt.setForeground(new Color(0xFFFFFF));
            accListPanel.add(memberListTxt);

            trainerList = new JLabel(iconTrainer);
            trainerList.setBounds(349,146,250,250);
            accListPanel.add(trainerList);

            trainerListTxt = new JLabel("Trainer");
            trainerListTxt.setBounds(433,416,80,27);
            trainerListTxt.setForeground(new Color(0xFFFFFF));
            accListPanel.add(trainerListTxt);


            // Account List - Member
            memListPanel = new JPanel();
            memListPanel.setBounds(266,14,1004,691);
            memListPanel.setBackground(new Color(0x2b2b2b));
            memListPanel.setLayout(null);
            super.add(memListPanel);

            String[] columnsMem = {
                "ID",
                "Full Name",
                "Phone",
                "Email",
                "Address",
                "DOB",
                "Payment Method",
                "Identification",
                "ID Type",
                "Gender",
                "Package"
            };
            
            memberModel = new DefaultTableModel(columnsMem, 0);
            memberTab = new JTable(memberModel);
            memberTab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollMem = new JScrollPane(memberTab);

            memberTabP = new JPanel();
            memberTabP.setBounds(16,150,974,452);
            memberTabP.setLayout(new BorderLayout());
            memberTabP.add(scrollMem, BorderLayout.CENTER);
            memListPanel.add(memberTabP);
            loadMember();


            backarrowListMem = new JLabel("<");
            backarrowListMem.setBounds(53,101,23,49);
            backarrowListMem.setForeground(new Color(0xffffff));
            memListPanel.add(backarrowListMem);

            accountListMem = new JLabel("Account List");
            accountListMem.setBounds(53,51,292,66);
            accountListMem.setForeground(new Color(0xffffff));
            memListPanel.add(accountListMem);

            mem2 = new JLabel("Member");
            mem2.setBounds(76,116,100,22);
            mem2.setForeground(new Color(0xffffff));
            memListPanel.add(mem2);

            addForMem = new JButton("Add");
            addForMem.setBounds(863,614,120,40);
            addForMem.setBackground(new Color(0xE4E4E4));
            addForMem.setForeground(new Color(0x111111));
            memListPanel.add(addForMem);

            editForMem = new JButton("Edit");
            editForMem.setBounds(733,614,120,40);
            editForMem.setBackground(new Color(0x1E8BE5));
            editForMem.setForeground(new Color(0xffffff));
            memListPanel.add(editForMem);

            delForMem = new JButton("Delete");
            delForMem.setBounds(602,614,120,40);
            delForMem.setBackground(new Color(0xE51E1E));
            delForMem.setForeground(new Color(0xffffff));
            memListPanel.add(delForMem);

            // Account List - Trainer
            traListPanel = new JPanel();
            traListPanel.setBounds(266,14,1004,691);
            traListPanel.setBackground(new Color(0x2b2b2b));
            traListPanel.setLayout(null);
            super.add(traListPanel);

            backarrowListTra = new JLabel("<");
            backarrowListTra.setBounds(53,116,75,22);
            backarrowListTra.setForeground(new Color(0xffffff));
            traListPanel.add(backarrowListTra);

            accountListTra = new JLabel("Account List");
            accountListTra.setBounds(53,51,292,66);
            accountListTra.setForeground(new Color(0xffffff));
            traListPanel.add(accountListTra);

            tra2 = new JLabel("Trainer");
            tra2.setBounds(76,116,100,22);
            tra2.setForeground(new Color(0xffffff));
            traListPanel.add(tra2);

            String[] columnsTra = {
                "ID",
                "Full Name",
                "Phone",
                "Email",
                "Address",
                "DOB",
                "Identification",
                "ID Type",
                "Specialization",
                "Gender",
                "Salary",
                "Experience"
            };
            
            trainerModel = new DefaultTableModel(columnsTra, 0);
            trainerTab = new JTable(trainerModel);
            trainerTab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollTra = new JScrollPane(trainerTab);

            trainerTabP = new JPanel();
            trainerTabP.setBounds(16,150,974,452);
            trainerTabP.setLayout(new BorderLayout());
            trainerTabP.add(scrollTra, BorderLayout.CENTER);
            traListPanel.add(trainerTabP);
            loadTrainer();

            addForTra = new JButton("Add");
            addForTra.setBounds(863,614,120,40);
            addForTra.setBackground(new Color(0xE4E4E4));
            addForTra.setForeground(new Color(0x111111));
            traListPanel.add(addForTra);

            editForTra = new JButton("Edit");
            editForTra.setBounds(733,614,120,40);
            editForTra.setBackground(new Color(0x1E8BE5));
            editForTra.setForeground(new Color(0xffffff));
            traListPanel.add(editForTra);

            delForTra = new JButton("Delete");
            delForTra.setBounds(602,614,120,40);
            delForTra.setBackground(new Color(0xE51E1E));
            delForTra.setForeground(new Color(0xffffff));
            traListPanel.add(delForTra);


            // for all custom font
            try {
                fontForText = Font.createFont(Font.TRUETYPE_FONT, new File("Font/Manrope-Regular.ttf")).deriveFont(12f);
                memID.setFont(fontForText);
                fullNameMem.setFont(fontForText);
                ageMem.setFont(fontForText);
                phnNumMem.setFont(fontForText);
                emailMem.setFont(fontForText);
                addressMem.setFont(fontForText);
                genderMem.setFont(fontForText);
                paymentMethod.setFont(fontForText);
                packageMem.setFont(fontForText);
                identificationMem.setFont(fontForText);

                memIDTF.setFont(fontForText);
                fullNameMemTF.setFont(fontForText);
                phnNumMemTF.setFont(fontForText);
                emailMemTF.setFont(fontForText);
                addressMemTF.setFont(fontForText);
                identificationMemCB.setFont(fontForText);
                identificationMemPF.setFont(fontForText);
                genderFemaleForMem.setFont(fontForText);
                genderMaleForMem.setFont(fontForText);

                traID.setFont(fontForText);
                fullNameTra.setFont(fontForText);
                ageTra.setFont(fontForText);
                phnNumTra.setFont(fontForText);
                emailTra.setFont(fontForText);
                addressTra.setFont(fontForText);
                genderTra.setFont(fontForText);
                specialization.setFont(fontForText);
                salary.setFont(fontForText);
                experience.setFont(fontForText);
                submitTra.setFont(fontForText);
                identificationTra.setFont(fontForText);

                traIDTF.setFont(fontForText);
                fullNameTraTF.setFont(fontForText);
                phnNumTraTF.setFont(fontForText);
                emailTraTF.setFont(fontForText);
                addressTraTF.setFont(fontForText);
                salaryTF.setFont(fontForText);
                experienceTF.setFont(fontForText);
                identificationTraCB.setFont(fontForText);
                identificationTraPF.setFont(fontForText);
                
                monthly.setFont(fontForText);
                quarterly.setFont(fontForText);
                yearly.setFont(fontForText);

                dobDateMem.setFont(fontForText);
                dobMonMem.setFont(fontForText);
                dobYrMem.setFont(fontForText);

                dobDateTra.setFont(fontForText);
                dobMonTra.setFont(fontForText);
                dobYrTra.setFont(fontForText);

                cardio.setFont(fontForText);
                weightTraining.setFont(fontForText);
                crossFit.setFont(fontForText);
                yoga.setFont(fontForText);

                genderFemaleForTra.setFont(fontForText);
                genderMaleForTra.setFont(fontForText);

                bank.setFont(fontForText);
                card.setFont(fontForText);
                cash.setFont(fontForText);
                nagad.setFont(fontForText);
                bKash.setFont(fontForText);

                memberTab.setFont(fontForText);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            try {
                fontForButton = Font.createFont(Font.TRUETYPE_FONT, new File("Font/Manrope-SemiBold.ttf")).deriveFont(12f);
                exitBt.setFont(fontForButton);
                introPanelBt.setFont(fontForButton);
                addAccBt.setFont(fontForButton);
                accListBt.setFont(fontForButton);
                submitMem.setFont(fontForButton);
                addForMem.setFont(fontForButton);
                delForMem.setFont(fontForButton);
                editForMem.setFont(fontForButton);
                addForTra.setFont(fontForButton);
                delForTra.setFont(fontForButton);
                editForTra.setFont(fontForButton);
                addBt.setFont(fontForButton);
                listBt.setFont(fontForButton);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                fontForTitle = Font.createFont(Font.TRUETYPE_FONT, new File("Font/Manrope-Bold.ttf")).deriveFont(40f);
                addANewAcc.setFont(fontForTitle);
                addANewAccMem.setFont(fontForTitle);
                addANewAccTra.setFont(fontForTitle);
                accountList.setFont(fontForTitle);
                accountListMem.setFont(fontForTitle);
                accountListTra.setFont(fontForTitle);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                fontForTextB = Font.createFont(Font.TRUETYPE_FONT, new File("Font/Manrope-Bold.ttf")).deriveFont(20f);
                member.setFont(fontForTextB);
                trainer.setFont(fontForTextB);
                mem.setFont(fontForTextB);
                tra.setFont(fontForTextB);
                memberListTxt.setFont(fontForTextB);
                trainerListTxt.setFont(fontForTextB);
                mem2.setFont(fontForTextB);
                tra2.setFont(fontForTextB);
                management.setFont(fontForTextB);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try{
                fontForBack = Font.createFont(Font.TRUETYPE_FONT, new File("Font/Manrope-Bold.ttf")).deriveFont(36f);
                backarrowMem.setFont(fontForBack);
                backarrowTra.setFont(fontForBack);
                backarrowListMem.setFont(fontForBack);
                backarrowListTra.setFont(fontForBack);
            }catch(Exception e){
                e.printStackTrace();
            }
            try{
                fontForHighlight = Font.createFont(Font.TRUETYPE_FONT, new File("Font/Manrope-Bold.ttf")).deriveFont(48f);
                welcome.setFont(fontForHighlight);
            }catch(Exception e){
                e.printStackTrace();
            }
            try{
                fontForHighlight = Font.createFont(Font.TRUETYPE_FONT, new File("Font/Manrope-Bold.ttf")).deriveFont(5f);
                version.setFont(fontForVer);
            }catch(Exception e){
                e.printStackTrace();
            }

            introPanel.setVisible(true);
            accListPanel.setVisible(false);
            addPanel.setVisible(false);
            addMemPanel.setVisible(false);
            addTraPanel.setVisible(false);
            memListPanel.setVisible(false);
            traListPanel.setVisible(false);

		    exitBt.addActionListener(this);
            introPanelBt.addMouseListener(this);
            addAccBt.addMouseListener(this);
            accListBt.addMouseListener(this);

            imgMember.addMouseListener(this);
            imgTrainer.addMouseListener(this);
            memberList.addMouseListener(this);
            trainerList.addMouseListener(this);

            member.addMouseListener(this);
            trainer.addMouseListener(this);

            backarrowMem.addMouseListener(this);
            backarrowTra.addMouseListener(this);
            backarrowListMem.addMouseListener(this);
            backarrowListTra.addMouseListener(this);

            submitMem.addActionListener(this);
            submitTra.addActionListener(this);

            hideMem.addActionListener(this);
            hideTra.addActionListener(this);

            addForMem.addMouseListener(this);
            addForTra.addMouseListener(this);

            delForMem.addActionListener(this);
            delForTra.addActionListener(this);
            editForMem.addActionListener(this);
            editForTra.addActionListener(this);

            addBt.addMouseListener(this);
            listBt.addMouseListener(this);
            super.setVisible(true);
        }


        // Events 
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==exitBt){
                System.exit(0);
            }
            else if(ae.getSource() == hideMem) {
                if(identificationMemPF.getEchoChar() == '*') { 
                    identificationMemPF.setEchoChar((char)0); // show text
                } else {
                    identificationMemPF.setEchoChar('*'); // hide text
                }
            }

            else if(ae.getSource()==hideTra){
                if(identificationTraPF.getEchoChar() == '*') { 
                    identificationTraPF.setEchoChar((char)0);
                } else {
                    identificationTraPF.setEchoChar('*'); // hide text
                }
            }
            else if(ae.getSource()==submitMem){
                String memIDF,fullNameMemF,phnNumMemF,emailMemF,addressMemF,dobDateMemF,dobMonMemF,dobYrMemF,paymentMethodF,identificationMemF,identificationMemCBF, genderMemF,packageMemF;
                // For TextField
                memIDF = memIDTF.getText();
                fullNameMemF = fullNameMemTF.getText();
                phnNumMemF = phnNumMemTF.getText();
                emailMemF = emailMemTF.getText();
                // For Pass Flied
                identificationMemF = identificationMemPF.getText();
                // For Text Area
                addressMemF = addressMemTF.getText();
                // JComboBox
                dobDateMemF = dobDateMem.getSelectedItem().toString();
                dobMonMemF = dobMonMem.getSelectedItem().toString();
                dobYrMemF = dobYrMem.getSelectedItem().toString();
                identificationMemCBF = identificationMemCB.getSelectedItem().toString();
                // JChechBox (pow(2,5) man T-T i am cooked)
                if(bKash.isSelected() && !nagad.isSelected() && !card.isSelected() && !cash.isSelected() && !bank.isSelected()){
                    paymentMethodF = bKash.getText();
                }
                else if(!bKash.isSelected() && nagad.isSelected() && !card.isSelected() && !cash.isSelected() && !bank.isSelected()){
                    paymentMethodF = nagad.getText();
                }
                else if(bKash.isSelected() && nagad.isSelected() && !card.isSelected() && !cash.isSelected() && !bank.isSelected()){
                    paymentMethodF = bKash.getText()+", "+nagad.getText();
                }
                else if(!bKash.isSelected() && !nagad.isSelected() && card.isSelected() && !cash.isSelected() && !bank.isSelected()){
                    paymentMethodF = card.getText();
                }
                else if(bKash.isSelected() && !nagad.isSelected() && card.isSelected() && !cash.isSelected() && !bank.isSelected()){
                    paymentMethodF = bKash.getText()+", "+card.getText();
                }
                else if(!bKash.isSelected() && nagad.isSelected() && card.isSelected() && !cash.isSelected() && !bank.isSelected()){
                    paymentMethodF = nagad.getText()+", "+card.getText();
                }
                else if(bKash.isSelected() && nagad.isSelected() && card.isSelected() && !cash.isSelected() && !bank.isSelected()){
                    paymentMethodF = bKash.getText()+", "+nagad.getText()+", "+card.getText();
                }
                else if(!bKash.isSelected() && !nagad.isSelected() && !card.isSelected() && cash.isSelected() && !bank.isSelected()){
                    paymentMethodF = cash.getText();
                }
                else if(bKash.isSelected() && !nagad.isSelected() && !card.isSelected() && cash.isSelected() && !bank.isSelected()){
                    paymentMethodF = bKash.getText()+", "+cash.getText();
                }
                else if(!bKash.isSelected() && nagad.isSelected() && !card.isSelected() && cash.isSelected() && !bank.isSelected()){
                    paymentMethodF = nagad.getText()+", "+cash.getText();
                }
                else if(bKash.isSelected() && nagad.isSelected() && !card.isSelected() && cash.isSelected() && !bank.isSelected()){
                    paymentMethodF = bKash.getText()+", "+nagad.getText()+", "+cash.getText();
                }
                else if(!bKash.isSelected() && !nagad.isSelected() && card.isSelected() && cash.isSelected() && !bank.isSelected()){
                    paymentMethodF = card.getText()+", "+cash.getText();
                }
                else if(bKash.isSelected() && !nagad.isSelected() && card.isSelected() && cash.isSelected() && !bank.isSelected()){
                    paymentMethodF = bKash.getText()+", "+card.getText()+", "+cash.getText();
                }
                else if(!bKash.isSelected() && nagad.isSelected() && card.isSelected() && cash.isSelected() && !bank.isSelected()){
                    paymentMethodF = nagad.getText()+", "+card.getText()+", "+cash.getText();
                }
                else if(bKash.isSelected() && nagad.isSelected() && card.isSelected() && cash.isSelected() && !bank.isSelected()){
                    paymentMethodF = bKash.getText()+", "+nagad.getText()+", "+card.getText()+", "+cash.getText();
                }
                else if(!bKash.isSelected() && !nagad.isSelected() && !card.isSelected() && !cash.isSelected() && bank.isSelected()){
                    paymentMethodF = bank.getText();
                }
                else if(bKash.isSelected() && !nagad.isSelected() && !card.isSelected() && !cash.isSelected() && bank.isSelected()){
                    paymentMethodF = bKash.getText()+", "+bank.getText();
                }
                else if(!bKash.isSelected() && nagad.isSelected() && !card.isSelected() && !cash.isSelected() && bank.isSelected()){
                    paymentMethodF = nagad.getText()+", "+bank.getText();
                }
                else if(bKash.isSelected() && nagad.isSelected() && !card.isSelected() && !cash.isSelected() && bank.isSelected()){
                    paymentMethodF = bKash.getText()+", "+nagad.getText()+", "+bank.getText();
                }
                else if(!bKash.isSelected() && !nagad.isSelected() && card.isSelected() && !cash.isSelected() && bank.isSelected()){
                    paymentMethodF = card.getText()+", "+bank.getText();
                }
                else if(bKash.isSelected() && !nagad.isSelected() && card.isSelected() && !cash.isSelected() && bank.isSelected()){
                    paymentMethodF = bKash.getText()+", "+card.getText()+", "+bank.getText();
                }
                else if(!bKash.isSelected() && nagad.isSelected() && card.isSelected() && !cash.isSelected() && bank.isSelected()){
                    paymentMethodF = nagad.getText()+", "+card.getText()+", "+bank.getText();
                }
                else if(bKash.isSelected() && nagad.isSelected() && card.isSelected() && !cash.isSelected() && bank.isSelected()){
                    paymentMethodF = bKash.getText()+", "+nagad.getText()+", "+card.getText()+", "+bank.getText();
                }
                else if(!bKash.isSelected() && !nagad.isSelected() && !card.isSelected() && cash.isSelected() && bank.isSelected()){
                    paymentMethodF = cash.getText()+", "+bank.getText();
                }
                else if(bKash.isSelected() && !nagad.isSelected() && !card.isSelected() && cash.isSelected() && bank.isSelected()){
                    paymentMethodF = bKash.getText()+", "+cash.getText()+", "+bank.getText();
                }
                else if(!bKash.isSelected() && nagad.isSelected() && !card.isSelected() && cash.isSelected() && bank.isSelected()){
                    paymentMethodF = nagad.getText()+", "+cash.getText()+", "+bank.getText();
                }
                else if(bKash.isSelected() && nagad.isSelected() && !card.isSelected() && cash.isSelected() && bank.isSelected()){
                    paymentMethodF = bKash.getText()+", "+nagad.getText()+", "+cash.getText()+", "+bank.getText();
                }
                else if(!bKash.isSelected() && !nagad.isSelected() && card.isSelected() && cash.isSelected() && bank.isSelected()){
                    paymentMethodF = card.getText()+", "+cash.getText()+", "+bank.getText();
                }
                else if(bKash.isSelected() && !nagad.isSelected() && card.isSelected() && cash.isSelected() && bank.isSelected()){
                    paymentMethodF = bKash.getText()+", "+card.getText()+", "+cash.getText()+", "+bank.getText();
                }
                else if(!bKash.isSelected() && nagad.isSelected() && card.isSelected() && cash.isSelected() && bank.isSelected()){
                    paymentMethodF = nagad.getText()+", "+card.getText()+", "+cash.getText()+", "+bank.getText();
                }
                else if(bKash.isSelected() && nagad.isSelected() && card.isSelected() && cash.isSelected() && bank.isSelected()){
                    paymentMethodF = bKash.getText()+", "+nagad.getText()+", "+card.getText()+", "+cash.getText()+", "+bank.getText();
                }
                else{
                    paymentMethodF = "";
                }

                // JRadioButton
                if(genderFemaleForMem.isSelected()){ 
                    genderMemF = genderFemaleForMem.getText();
                }
                else if(genderMaleForMem.isSelected()){
                    genderMemF = genderMaleForMem.getText();
                }
                else{
                    genderMemF = "";
                }

                if(monthly.isSelected()){
                    packageMemF = monthly.getText();
                }
                else if(quarterly.isSelected()){
                    packageMemF = quarterly.getText();
                }
                else if(yearly.isSelected()){
                    packageMemF = yearly.getText();
                }
                else{
                    packageMemF = "";
                }

                if(memIDF.isEmpty() || fullNameMemF.isEmpty() || phnNumMemF.isEmpty() || emailMemF.isEmpty() || addressMemF.isEmpty() || dobDateMemF.isEmpty() || dobMonMemF.isEmpty() || dobYrMemF.isEmpty() || identificationMemF.isEmpty() || paymentMethodF.isEmpty() || identificationMemCBF.isEmpty() || genderMemF.isEmpty() || packageMemF.isEmpty()){
                    JOptionPane.showMessageDialog(this,"Please fill up all the information");
                }
                else{
                    String dobFull = dobDateMemF + "-" + dobMonMemF + "-" + dobYrMemF;
                    String[] rowData = {memIDF, fullNameMemF, phnNumMemF, emailMemF, addressMemF,
                        dobFull, paymentMethodF, identificationMemF, identificationMemCBF,
                        genderMemF, packageMemF};

                    if(editingMemberRow == -1){
                        GYM memberGYM = new GYM(memIDF, fullNameMemF, phnNumMemF, emailMemF, addressMemF, dobDateMemF, dobMonMemF, dobYrMemF,
                                                identificationMemF, paymentMethodF, identificationMemCBF, genderMemF, packageMemF);
                        memberGYM.insertMember(); 
                        memberModel.addRow(rowData);
                    } else {
                        // Edit existing member
                        for(int i=0; i<memberModel.getColumnCount(); i++){
                            memberModel.setValueAt(rowData[i], editingMemberRow, i);
                        }

                        GYM gymEdit = new GYM();
                        gymEdit.editMember(memberModel);
                        editingMemberRow = -1; // reset
                    }
                    clearMemberForm();
                    JOptionPane.showMessageDialog(this,"Member saved successfully!");
                 }  
            }
            else if(ae.getSource()==submitTra){
                String traIDF,fullNameTraF,phnNumTraF,emailTraF,addressTraF,dobDateTraF,dobMonTraF,dobYrTraF,identificationTraF,identificationTraCBF,specializationF, genderTraF,salaryF,experienceF;
                // For TextField
                traIDF = traIDTF.getText();
                fullNameTraF = fullNameTraTF.getText();
                phnNumTraF = phnNumTraTF.getText();
                emailTraF = emailTraTF.getText();
                salaryF = salaryTF.getText();
                experienceF = experienceTF.getText();
                // For Pass Flied
                identificationTraF = identificationTraPF.getText();
                // For Text Area
                addressTraF = addressTraTF.getText();
                // JComboBox
                dobDateTraF = dobDateTra.getSelectedItem().toString();
                dobMonTraF = dobMonTra.getSelectedItem().toString();
                dobYrTraF = dobYrTra.getSelectedItem().toString();
                identificationTraCBF = identificationTraCB.getSelectedItem().toString();
                // JCheckBox
                if(cardio.isSelected() && !weightTraining.isSelected() && !crossFit.isSelected() && !yoga.isSelected()){
                    specializationF = cardio.getText();
                }
                else if(!cardio.isSelected() && weightTraining.isSelected() && !crossFit.isSelected() && !yoga.isSelected()){
                    specializationF = weightTraining.getText();
                }
                else if(cardio.isSelected() && weightTraining.isSelected() && !crossFit.isSelected() && !yoga.isSelected()){
                    specializationF = cardio.getText()+", "+weightTraining.getText();
                }
                else if(!cardio.isSelected() && !weightTraining.isSelected() && crossFit.isSelected() && !yoga.isSelected()){
                    specializationF = crossFit.getText();
                }
                else if(cardio.isSelected() && !weightTraining.isSelected() && crossFit.isSelected() && !yoga.isSelected()){
                    specializationF = cardio.getText()+", "+crossFit.getText();
                }
                else if(!cardio.isSelected() && weightTraining.isSelected() && crossFit.isSelected() && !yoga.isSelected()){
                    specializationF = weightTraining.getText()+", "+crossFit.getText();
                }
                else if(cardio.isSelected() && weightTraining.isSelected() && crossFit.isSelected() && !yoga.isSelected()){
                    specializationF = cardio.getText()+", "+weightTraining.getText()+", "+crossFit.getText();
                }
                else if(!cardio.isSelected() && !weightTraining.isSelected() && !crossFit.isSelected() && yoga.isSelected()){
                    specializationF = yoga.getText();
                }
                else if(cardio.isSelected() && !weightTraining.isSelected() && !crossFit.isSelected() && yoga.isSelected()){
                    specializationF = cardio.getText()+", "+yoga.getText();
                }
                else if(!cardio.isSelected() && weightTraining.isSelected() && !crossFit.isSelected() && yoga.isSelected()){
                    specializationF = weightTraining.getText()+", "+yoga.getText();
                }
                else if(cardio.isSelected() && weightTraining.isSelected() && !crossFit.isSelected() && yoga.isSelected()){
                    specializationF = cardio.getText()+", "+weightTraining.getText()+", "+yoga.getText();
                }
                else if(!cardio.isSelected() && !weightTraining.isSelected() && crossFit.isSelected() && yoga.isSelected()){
                    specializationF = crossFit.getText()+", "+yoga.getText();
                }
                else if(cardio.isSelected() && !weightTraining.isSelected() && crossFit.isSelected() && yoga.isSelected()){
                    specializationF = cardio.getText()+", "+crossFit.getText()+", "+yoga.getText();
                }
                else if(!cardio.isSelected() && weightTraining.isSelected() && crossFit.isSelected() && yoga.isSelected()){
                    specializationF = weightTraining.getText()+" "+crossFit.getText()+" "+yoga.getText();
                }
                else if(cardio.isSelected() && weightTraining.isSelected() && crossFit.isSelected() && yoga.isSelected()){
                    specializationF = cardio.getText()+" "+weightTraining.getText()+" "+crossFit.getText()+" "+yoga.getText();
                }
                else{
                    specializationF = "";
                }

                if(genderFemaleForTra.isSelected()){ 
                    genderTraF = genderFemaleForTra.getText();
                }
                else if(genderMaleForTra.isSelected()){
                    genderTraF = genderMaleForTra.getText();
                }
                else{
                    genderTraF = "";
                }

                if(traIDF.isEmpty() || fullNameTraF.isEmpty() || phnNumTraF.isEmpty() || emailTraF.isEmpty() || addressTraF.isEmpty() || dobDateTraF.isEmpty() || dobMonTraF.isEmpty() || dobYrTraF.isEmpty() || identificationTraF.isEmpty() || identificationTraCBF.isEmpty() || specializationF.isEmpty() || genderTraF.isEmpty() || salaryF.isEmpty() || experienceF.isEmpty()){
                    JOptionPane.showMessageDialog(this,"Please fill up all the information");
                }else{
                    String dobFull = dobDateTraF + "-" + dobMonTraF + "-" + dobYrTraF;

                    String[] rowData = {
                        traIDF, fullNameTraF, phnNumTraF, emailTraF, addressTraF,
                        dobFull, identificationTraF, identificationTraCBF,
                        specializationF, genderTraF, salaryF, experienceF
                    };

                    if(editingTrainerRow == -1){
                        GYM trainerGYM = new GYM(traIDF,fullNameTraF,phnNumTraF,emailTraF,addressTraF,dobDateTraF,dobMonTraF,dobYrTraF,identificationTraF,identificationTraCBF,specializationF, genderTraF,salaryF,experienceF);
                        trainerGYM.insertTrainer();
                        trainerModel.addRow(rowData);
                    }
                    else{
                        for(int i = 0; i < rowData.length; i++){
                            trainerModel.setValueAt(rowData[i], editingTrainerRow, i);
                        }

                        GYM gymEdit = new GYM();
                        gymEdit.editTrainer(trainerModel);

                        editingTrainerRow = -1;
                    }

                    clearTrainerForm();
                    JOptionPane.showMessageDialog(this, "Trainer saved successfully!");
                }
                 
                
            }else if(ae.getSource() == delForMem) {
                int selectedRow = memberTab.getSelectedRow();
                if(selectedRow == -1) {
                    JOptionPane.showMessageDialog(this, "Please select a member to delete!");
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this member?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if(confirm != JOptionPane.YES_OPTION) return;

                GYM gym = new GYM();
                memberModel.removeRow(selectedRow);
                gym.delMember(selectedRow);
            }
            else if(ae.getSource()==delForTra){
                int selectedRow = trainerTab.getSelectedRow();
                if(selectedRow == -1){
                    JOptionPane.showMessageDialog(this,"Please select a trainer to delete!");
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(this,"Are you sure you want to delete this trainer?", "Confirm Delete",JOptionPane.YES_NO_OPTION);
                if(confirm != JOptionPane.YES_OPTION){
                    return;
                }
                GYM gym = new GYM();
                trainerModel.removeRow(selectedRow);
                gym.delTrainer(selectedRow);
               
            }

            else if(ae.getSource() == editForMem){
                int selectedRow = memberTab.getSelectedRow();
                if(selectedRow != -1){ 
                    editingMemberRow = selectedRow; 

                    memListPanel.setVisible(false);
                    addMemPanel.setVisible(true);

                    addANewAccMem.setText("Edit Account");

                    memIDTF.setText(memberModel.getValueAt(selectedRow, 0).toString());
                    fullNameMemTF.setText(memberModel.getValueAt(selectedRow, 1).toString());
                    phnNumMemTF.setText(memberModel.getValueAt(selectedRow, 2).toString());
                    emailMemTF.setText(memberModel.getValueAt(selectedRow, 3).toString());
                    addressMemTF.setText(memberModel.getValueAt(selectedRow, 4).toString());

                    String[] dobParts = memberModel.getValueAt(selectedRow, 5).toString().split("-");
                    if(dobParts.length == 3){
                        dobDateMem.setSelectedItem(dobParts[0]);
                        dobMonMem.setSelectedItem(dobParts[1]);
                        dobYrMem.setSelectedItem(dobParts[2]);
                    }

                    String paymentStr = memberModel.getValueAt(selectedRow, 6).toString();
                    bKash.setSelected(paymentStr.contains(bKash.getText()));
                    nagad.setSelected(paymentStr.contains(nagad.getText()));
                    card.setSelected(paymentStr.contains(card.getText()));
                    cash.setSelected(paymentStr.contains(cash.getText()));
                    bank.setSelected(paymentStr.contains(bank.getText()));

                    // Identification
                    identificationMemPF.setText(memberModel.getValueAt(selectedRow, 7).toString());
                    identificationMemCB.setSelectedItem(memberModel.getValueAt(selectedRow, 8).toString());

                    // Gender RadioButtons
                    String genderStr = memberModel.getValueAt(selectedRow, 9).toString();
                    genderMaleForMem.setSelected(genderStr.equals(genderMaleForMem.getText()));
                    genderFemaleForMem.setSelected(genderStr.equals(genderFemaleForMem.getText()));

                    // Package RadioButtons
                    String packageStr = memberModel.getValueAt(selectedRow, 10).toString();
                    monthly.setSelected(packageStr.equals(monthly.getText()));
                    quarterly.setSelected(packageStr.equals(quarterly.getText()));
                    yearly.setSelected(packageStr.equals(yearly.getText()));

                } else {
                     JOptionPane.showMessageDialog(this, "Please select a member to edit.");
                }
            }

            else if(ae.getSource() == editForTra){
                int row = trainerTab.getSelectedRow();

                if(row != -1){
                    editingTrainerRow = row;
                    traListPanel.setVisible(false);
                    addTraPanel.setVisible(true);
                    addANewAccTra.setText("Edit Account");

                    // Fill form from table
                    traIDTF.setText(trainerModel.getValueAt(row,0).toString());
                    fullNameTraTF.setText(trainerModel.getValueAt(row,1).toString());
                    phnNumTraTF.setText(trainerModel.getValueAt(row,2).toString());
                    emailTraTF.setText(trainerModel.getValueAt(row,3).toString());
                    addressTraTF.setText(trainerModel.getValueAt(row,4).toString());

                    String[] dob = trainerModel.getValueAt(row,5).toString().split("-");
                    if(dob.length==3){
                        dobDateTra.setSelectedItem(dob[0]);
                        dobMonTra.setSelectedItem(dob[1]);
                        dobYrTra.setSelectedItem(dob[2]);
                    }
                

                    identificationTraPF.setText(trainerModel.getValueAt(row,6).toString());
                    identificationTraCB.setSelectedItem(trainerModel.getValueAt(row,7).toString());

                    experienceTF.setText(trainerModel.getValueAt(row,11).toString());


                    String gender = trainerModel.getValueAt(row,9).toString();
                    genderMaleForTra.setSelected(gender.equals("Male"));
                    genderFemaleForTra.setSelected(gender.equals("Female"));

                    salaryTF.setText(trainerModel.getValueAt(row,10).toString());
                
                }else{
                    JOptionPane.showMessageDialog(this, "Please select a trainer to edit!");
                }
            }
        }

        public void mouseClicked(MouseEvent me){
            if(me.getSource()==introPanelBt){
                introPanel.setVisible(true);
                accListPanel.setVisible(false);
                addPanel.setVisible(false);
                addMemPanel.setVisible(false);
                addTraPanel.setVisible(false);
                memListPanel.setVisible(false);
                traListPanel.setVisible(false);
                trainerTabP.setVisible(false);
                memberTabP.setVisible(false);
            }
            else if(me.getSource()==addAccBt || me.getSource()==backarrowMem || me.getSource()==backarrowTra || me.getSource()==addBt){
                introPanel.setVisible(false);
                accListPanel.setVisible(false);
                addPanel.setVisible(true);
                addMemPanel.setVisible(false);
                addTraPanel.setVisible(false);
                memListPanel.setVisible(false);
                traListPanel.setVisible(false);
                trainerTabP.setVisible(false);
                memberTabP.setVisible(false);
            }
            else if(me.getSource()==accListBt || me.getSource()==backarrowListMem || me.getSource()==backarrowListTra || me.getSource()==listBt){
                introPanel.setVisible(false);
                accListPanel.setVisible(true);
                addPanel.setVisible(false);
                addMemPanel.setVisible(false);
                addTraPanel.setVisible(false);
                memListPanel.setVisible(false);
                traListPanel.setVisible(false);
                trainerTabP.setVisible(false);
                memberTabP.setVisible(false);
            }

            else if(me.getSource()==imgMember || me.getSource()==member || me.getSource()==addForMem){
                addANewAccMem.setText("Add A New Account");
                introPanel.setVisible(false);
                accListPanel.setVisible(false);
                addPanel.setVisible(false);
                addMemPanel.setVisible(true);
                addTraPanel.setVisible(false);
                memListPanel.setVisible(false);
                traListPanel.setVisible(false);
                trainerTabP.setVisible(false);
                memberTabP.setVisible(false);
            }
            else if(me.getSource()==imgTrainer || me.getSource()==trainer || me.getSource()==addForTra){
                addANewAccTra.setText("Add A New Account");
                introPanel.setVisible(false);
                accListPanel.setVisible(false);
                addPanel.setVisible(false);
                addMemPanel.setVisible(false);
                addTraPanel.setVisible(true);
                memListPanel.setVisible(false);
                traListPanel.setVisible(false);
                trainerTabP.setVisible(false);
                memberTabP.setVisible(false);
            }
            else if(me.getSource()==memberList){
                introPanel.setVisible(false);
                accListPanel.setVisible(false);
                addPanel.setVisible(false);
                addMemPanel.setVisible(false);
                addTraPanel.setVisible(false);
                memListPanel.setVisible(true);
                traListPanel.setVisible(false);
                trainerTabP.setVisible(false);
                memberTabP.setVisible(true);
            }
            else if(me.getSource()==trainerList){
                introPanel.setVisible(false);
                accListPanel.setVisible(false);
                addPanel.setVisible(false);
                addMemPanel.setVisible(false);
                addTraPanel.setVisible(false);
                memListPanel.setVisible(false);
                traListPanel.setVisible(true);
                trainerTabP.setVisible(true);
                memberTabP.setVisible(false);
            }
        }

        public void mousePressed(MouseEvent me){
            if(me.getSource()==introPanelBt){
                introPanelBt.setBackground(new Color(0x111111));
            }
            else if(me.getSource()==addAccBt){
                addAccBt.setBackground(new Color(0x111111));
            }
            else if(me.getSource()==accListBt){
                accListBt.setBackground(new Color(0x111111));
            }
        }

        public void mouseReleased(MouseEvent me){
            if(me.getSource()==introPanelBt){
                introPanelBt.setBackground(new Color(0x262626));
            }
            else if(me.getSource()==addAccBt){
                addAccBt.setBackground(new Color(0x262626));
            }
            else if(me.getSource()==accListBt){
                accListBt.setBackground(new Color(0x262626));
            }
        }

        public void mouseEntered(MouseEvent me){
            if(me.getSource()==introPanelBt){
                introPanelBt.setBackground(new Color(0x111111));
            }
            else if(me.getSource()==addAccBt){
                addAccBt.setBackground(new Color(0x111111));
            }
            else if(me.getSource()==accListBt){
                accListBt.setBackground(new Color(0x111111));
            }
        }

        public void mouseExited(MouseEvent me){
            if(me.getSource()==introPanelBt){
                introPanelBt.setBackground(new Color(0x262626));
            }
            else if(me.getSource()==addAccBt){
                addAccBt.setBackground(new Color(0x262626));
            }
            else if(me.getSource()==accListBt){
                accListBt.setBackground(new Color(0x262626));
            }
        }

        public void clearMemberForm(){
            memIDTF.setText("");
            fullNameMemTF.setText("");
            phnNumMemTF.setText("");
            emailMemTF.setText("");
            identificationMemPF.setText("");
            addressMemTF.setText("");
            dobDateMem.setSelectedIndex(0);
            dobMonMem.setSelectedIndex(0);
            dobYrMem.setSelectedIndex(0);
            identificationMemCB.setSelectedIndex(0);
            bKash.setSelected(false);
            nagad.setSelected(false);
            card.setSelected(false);
            cash.setSelected(false);
            bank.setSelected(false);
            genderBG.clearSelection();
            membershipBG.clearSelection();
        }

        public void clearTrainerForm() {
            traIDTF.setText("");
            fullNameTraTF.setText("");
            phnNumTraTF.setText("");
            emailTraTF.setText("");
            salaryTF.setText("");
            experienceTF.setText("");
            identificationTraPF.setText("");
            addressTraTF.setText("");

            dobDateTra.setSelectedIndex(0);
            dobMonTra.setSelectedIndex(0);
            dobYrTra.setSelectedIndex(0);
            identificationTraCB.setSelectedIndex(0);

            cardio.setSelected(false);
            weightTraining.setSelected(false);
            crossFit.setSelected(false);
            yoga.setSelected(false);

            genderTraBG.clearSelection();  
        }


        public void loadMember(){
            try{
                FileReader frMember = new FileReader("Data\\member.txt");
                BufferedReader brMember = new BufferedReader(frMember);
                String line;

                while((line = brMember.readLine())!= null){
                    String rowData[] = line.split("\\|");
                    if (rowData.length == 11) {
                        memberModel.addRow(rowData);
                    }
                }
                brMember.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"Member File is not found!");
            }
        }

        public void loadTrainer() {
            try {
                FileReader frTrainer = new FileReader("Data\\trainer.txt");
                BufferedReader brTrainer = new BufferedReader(frTrainer);
                String line;

                trainerModel.setRowCount(0); 

                while ((line = brTrainer.readLine()) != null) {
                    String[] rowData = line.split("\\|");
                    if (rowData.length >= 11) {          
                        trainerModel.addRow(rowData);    
                    }
                }

                brTrainer.close();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Trainer File is not found!");
            }
        }
}            
