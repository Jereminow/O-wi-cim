package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;


public class Main extends Application {
    Stage stage;
    public long prisID;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        enterPrisonerData();
    }

    private void enterPrisonerData() {
        stage.setTitle("Jail stuffs");

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);
        root.setHgap(10);


        Text prisonerNameText = new Text("Enter Prisoner Name Here:");
        TextField enterPrisonerNameTextfield = new TextField();

        Text prisonerSurnameText = new Text("Enter Prisoner Surname Here:");
        TextField enterPrisonerSurnameTextField = new TextField();

        Text prisonerAgeText = new Text("Enter Prisoner Age Here:");
        ComboBox<Integer> comboBox = new ComboBox<>();
        for (int i = 120; i >= 18; i--) {
            comboBox.getItems().addAll(i);
        }

        Text prisonerCrime = new Text("Enter Prisoner's Crime");
        TextField enterPrisonersCrimeHere = new TextField();

        Text prisonerJailTimeText = new Text("Enter number of years Prisoner is to be held:");
        ComboBox<Integer> prisonerJailTimeComboBox = new ComboBox<>();
        for (int i = 1; i < +100; i++) {
            prisonerJailTimeComboBox.getItems().addAll(i);
        }

        Text pointText = new Text("Does the prisoner have any points, and if so, how many?");
        ComboBox<Integer> prisPoints = new ComboBox<>();
        for (int i = 0; i <= 100; i++) {
            prisPoints.getItems().addAll(i);

        }


        RadioButton yesExecute = new RadioButton();
        yesExecute.setText("To be Executed");

        RadioButton isMale = new RadioButton();
        isMale.setText("Male");

        Button addPoints = new Button("Add points to prisoner");
        addPoints.setOnAction(event -> {
            addPointsUIusingName();
        });


        root.add(prisonerNameText, 1, 2);
        root.add(enterPrisonerNameTextfield, 2, 2);
        root.add(prisonerSurnameText, 1, 3);
        root.add(enterPrisonerSurnameTextField, 2, 3);
        root.add(prisonerAgeText, 1, 4);
        root.add(comboBox, 2, 4);
        root.add(prisonerCrime, 1, 5);
        root.add(enterPrisonersCrimeHere, 2, 5);
        root.add(prisonerJailTimeText, 1, 6);
        root.add(prisonerJailTimeComboBox, 2, 6);
        root.add(pointText, 1, 7);
        root.add(prisPoints, 2, 7);
        root.add(yesExecute, 1, 8);
        root.add(isMale, 1, 9);
        root.add(addPoints, 0, 10);

        Button seePrisonersButton = new Button("See Prisoners");
        seePrisonersButton.setOnAction(event -> {
            showPris();
        });
        root.add(seePrisonersButton, 2, 10);

        Button searchPrisButton = new Button("Search Prisoner");
        searchPrisButton.setOnAction(event -> {

            userIsLookingUsingPrisName();
        });
        root.add(searchPrisButton, 1, 10);

        Button enterPrisIntoDataBase = new Button("Enter Prisoner Into Database");
        enterPrisIntoDataBase.setOnAction(event -> {
            String prisName = enterPrisonerNameTextfield.getText();
            String prisSurname = enterPrisonerSurnameTextField.getText();
            int prisAge = comboBox.getValue();
            String prisCrime = enterPrisonersCrimeHere.getText();
            int prisJailTime = prisonerJailTimeComboBox.getValue();
            int prisPointsint = prisPoints.getValue();
            boolean male;


            boolean execute;
            execute = yesExecute.isSelected();

            male = isMale.isSelected();


            confirmation(prisName, prisSurname, prisCrime, prisAge, prisJailTime, prisPointsint, execute, male);
        });
        root.add(enterPrisIntoDataBase, 3, 10);

        stage.setScene(new Scene(root, 700, 800, Color.BLUE));
        stage.show();
    }

    private void addPointsUIusingName() {
        stage.setTitle("Add Points To Prisoner");

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);
        root.setHgap(10);

        Text prisName = new Text("Type in Prisoner Name : ");
        TextField textField1 = new TextField();

        Text prisSurname = new Text("Type in Prisoner Surename : ");
        TextField textField = new TextField();


        Text text = new Text("Enter points which Prisoner is to be rewarded : ");
        ComboBox<Integer> comboBox = new ComboBox<>();
        for (int i = 1; i <= 100; i++) {
            comboBox.getItems().addAll(i);
        }


        root.add(prisName, 0, 0);
        root.add(textField1, 1, 0);
        root.add(prisSurname, 0, 1);
        root.add(textField, 1, 1);
        root.add(text, 0, 2);
        root.add(comboBox, 1, 2);

        Button button = new Button("Add Points");
        button.setOnAction(event -> {
            String prisNameString = prisName.getText();
            String prisSurnameString = prisSurname.getText();
            int pointsToBeGiven = comboBox.getValue();

            //search prisoners and add points to him/her
        });
        root.add(button, 2, 2);

        Button idButton = new Button("Search using ID");
        idButton.setOnAction(event -> {
            addPOintsUIusingID();
        });


        stage.setScene(new Scene(root, 700, 800, Color.BLUE));
        stage.show();
    }

    private void addPOintsUIusingID() {
        stage.setTitle("Add Points To Prisoner");

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);
        root.setHgap(10);

        Text text = new Text("Type in prisoner ID");
        TextField textField = new TextField();

        Text text1 = new Text("Enter amount of points Prisoner is to be awarded");
        ComboBox<Integer> comboBox = new ComboBox<>();
        for (int i = 1; i <= 100; i++) {
            comboBox.getItems().addAll(i);
        }

        root.add(text, 0, 0);
        root.add(textField, 1, 0);
        root.add(text1, 0, 1);
        root.add(comboBox, 1, 1);


        stage.setScene(new Scene(root, 700, 800, Color.BLUE));
        stage.show();
    }


    private void userIsLookingUsingPrisName() {
        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        root.setPrefSize(700, 350);

        Text enterPrisNameHereText = new Text("Enter Pris Name Here :");
        TextField prisNameTextField = new TextField();

        Text enterPrisSurnameHere = new Text("Enter Prisoner Surname Here : ");
        TextField prisSurnameTextField = new TextField();

        root.add(enterPrisNameHereText, 1, 1);
        root.add(prisNameTextField, 2, 1);
        root.add(enterPrisSurnameHere, 1, 2);
        root.add(prisSurnameTextField, 2, 2);

        Button button = new Button("Search");
        button.setOnAction(event -> {
            String prisName = prisNameTextField.getText();
            String prisSurname = prisSurnameTextField.getText();

        /*   for (int i = 0; i < ; i++) {
                All prisoner Names here
        }*/

        });

        root.add(button, 2, 3);

        Button idButton = new Button("Search Using Prisoner ID");
        idButton.setOnAction(event -> {
            userIsLookingUsingPrisID();
        });

        root.add(idButton, 3, 3);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            enterPrisonerData();
        });

        root.add(backButton, 4, 3);

        // cycle through all Prisoners and find the one they are looking for, if none are present do smth

        stage.setScene(new Scene(root));
        stage.show();
    }

    private void userIsLookingUsingPrisID() {
        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        root.setPrefSize(500, 350);

        Text enterPrisID = new Text("Enter Prisoner ID Here : ");
        TextField prisIDTextField = new TextField();

        root.add(enterPrisID, 1, 1);
        root.add(prisIDTextField, 2, 1);

        Button button = new Button("Search");
        button.setOnAction(event -> {
            int prisID = Integer.parseInt(prisIDTextField.getText());

            /*for (int i = 0; i < ; i++) {

            }*/
        });

        root.add(button, 2, 3);

        // same as userIsLookingUsingPrisName() except instead of name search for userID
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            enterPrisonerData();
        });

        root.add(backButton, 3, 3);

        stage.setScene(new Scene(root));
        stage.show();
    }

    private void showPris() {
        stage.setTitle("Pris Database");

        stage.setTitle("Comfirmation");

        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        root.setPrefSize(500, 350);

        List<String> prisoners;  // create a list of prisoners

        // show all of them
        // cycle through and show all of them in alphabetical order with prisID

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            enterPrisonerData();
        });

        root.add(backButton, 3, 3);


        stage.setScene(new Scene(root, 1000, 400));
        stage.show();
    }


    private void confirmation(String prisName, String prisSurname, String prisCrime, int prisAge, int prisJailTime, int prisPoints, boolean execute, boolean sex) {
        stage.setTitle("Comfirmation");

        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        root.setPrefSize(500, 350);

        String toExecute = "";
        String sexStr = "";

        if (execute) {
            System.out.println("kill him");
            toExecute = "This prisoner is to be Executed";
        }

        if (!execute) {
            System.out.println("dont kill him");
            toExecute = "This prisoner is NOT to be Executed";
        }

        if (sex) {
            System.out.println("sex is male");
            sexStr = "M";
        }

        if (!sex) {
            System.out.println("sex is female");
            sexStr = "F";
        }

        Text text1 = new Text("You are about to add : " + prisName + " " + prisSurname + "(" + sexStr + ")" +
                ". Age : " + prisAge + " for " + prisJailTime + " year(s), for committing the crime : " + prisCrime + ". " + toExecute + ". Are you sure?");

        Button yesButton = new Button("Yes");
        String finalSexStr = sexStr;
        yesButton.setOnAction(event -> {
            prisID(prisAge, prisJailTime, prisPoints, finalSexStr);
            System.out.println("Prisoner has been entered");
            prisonerIDSHOWN();
        });

        Button noButton = new Button("No");
        noButton.setOnAction(event -> {
            enterPrisonerData();
        });

        root.add(text1, 1, 0);
        root.add(yesButton, 2, 1);
        root.add(noButton, 3, 1);


        stage.setScene(new Scene(root, 1000, 400));
        stage.show();
    }


    private void prisID(int prisAge, int prisJailTime, int prisPoints, String sex) {

        if (prisAge == 0 || prisJailTime == 0 || prisPoints == 0) {
            prisAge = (int) (Math.random() * 98 + 1);
            prisJailTime = (int) (Math.random() * 98 + 1);
            prisPoints = (int) (Math.random() * 98 + 1);
            prisID(prisAge, prisJailTime, prisPoints, sex);
        }

        int i = (int) (Math.random() * 98 + 1);
        int j = (int) (Math.random() * 8 + 1);


        prisID = ((prisAge * prisJailTime * prisPoints * i) ^ 2) * j;


        if (sex.equals("M")) {
            prisID = prisID * 1000;
        } else {
            prisID = prisID * 10000;
        }

        System.out.println("Pris id is: " + prisID);
    }

    private void prisonerIDSHOWN() {
        stage.setTitle("Prisoner ID");

        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        root.setPrefSize(500, 350);

        String prisIDString = String.valueOf(prisID);

        Text text = new Text("Prisoner ID is : ");
        Text prisIDText = new Text(prisIDString);

        Text jailCell = new Text("Prisoner Will be Held in Jail Cell nr : "); // somehow find the jail cell and jail block or smth
        Text jailBlock = new Text("In the Block : ");

        Button button = new Button("Okey this is will be abutton to do smth im not sure yet");
        button.setOnAction(event -> {
            //nothing lmao
        });

        Button backButton = new Button("Nice");
        backButton.setOnAction(event -> {
            enterPrisonerData();
        });


        root.add(button, 3, 3);
        root.add(backButton, 2, 3);
        root.add(jailCell, 1, 2);
        root.add(jailBlock, 2, 2);
        root.add(text, 1, 1);
        root.add(prisIDText, 2, 1);


        stage.setScene(new Scene(root, 1000, 400));
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
