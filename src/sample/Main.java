package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
    Stage stage;
    List<Prisoner> prisoners = new ArrayList<>();
    List<Long> studentIDList = new ArrayList<>();
    List<String> prisonersNames = new ArrayList<>();
    List<String> prisonerSurnames = new ArrayList<>();

    //public long prisID;
    //public List<Prisoner> prisoners = new ArrayList<>();


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        firstUI();
    }

    private void firstUI() {
        stage.setTitle("Welcome!");

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);
        root.setHgap(10);

        Button enterPrisData = new Button("Enter New Prisoner");
        enterPrisData.setOnAction(event -> {
            enterPrisonerDataUI();
        });

        Button addPoints = new Button("Add points to prisoner");
        addPoints.setOnAction(event -> {
            addPointsUIusingNameUI();
        });


        Button seePrisonersButton = new Button("See Prisoners");
        seePrisonersButton.setOnAction(event -> {
            showPrisUI();
        });

        Button searchPrisButton = new Button("Search Prisoner");
        searchPrisButton.setOnAction(event -> {
            userIsLookingUsingPrisNameUI();
        });

        Button searchForPrisonersJailCellButton = new Button("Search for Prisoner's Jail Cell");
        searchForPrisonersJailCellButton.setOnAction(event -> {
            searchForPrisJailcellUsingPrisNameUI();
        });

        root.add(enterPrisData, 0, 1);
        root.add(addPoints, 1, 1);
        root.add(seePrisonersButton, 2, 1);
        root.add(searchPrisButton, 3, 1);
        root.add(searchForPrisonersJailCellButton,4,1);

        stage.setScene(new Scene(root, 800, 600, Color.BLUE));
        stage.show();
    }

    private void enterPrisonerDataUI() {
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


        Button enterPrisIntoDataBase = new Button("Enter Prisoner Into Database");
        enterPrisIntoDataBase.setOnAction(event -> {

            if (enterPrisIntoDataBase.getText() == null || enterPrisonerSurnameTextField.getText() == null || comboBox.getValue() == null || enterPrisonersCrimeHere.getText() == null ||
                    prisonerJailTimeComboBox.getValue() == null || prisPoints.getValue() == null) {
                warningUI();
                return;
            }

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


            confirmationUI(prisName, prisSurname, prisCrime, prisAge, prisJailTime, prisPointsint, execute, male);
        });
        root.add(enterPrisIntoDataBase, 3, 10);

        Button back = new Button("Back");
        back.setOnAction(event -> firstUI());
        root.add(back, 3, 11);

        stage.setScene(new Scene(root, 800, 1000, Color.BLUE));

    }

    private void warningUI() {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);
        root.setHgap(10);

        // TODO: 2/14/2020 if user presses back, program crashes (No, it doesn't, you're lying)

        //Text text = new Text("You have missed one of more of the required fields while entering the Prisoner's Data, please try again ");
        Text text = new Text("You have to try again ");

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            firstUI();
        });

        root.add(text, 0, 0);
        root.add(backButton, 1, 0);

        stage.setScene(new Scene(root, 600, 300, Color.BLUE));


    }

    private void confirmationUI(String prisName, String prisSurname, String prisCrime, int prisAge, int prisJailTime, int prisPoints, boolean execute, boolean sex) {
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
            prisonersNames.add(prisName);
            prisonerSurnames.add(prisSurname);

            Prisoner prisoner = new Prisoner(prisID(prisAge, prisJailTime, prisPoints, finalSexStr), prisAge, prisJailTime, prisPoints, prisCrime, prisName, prisSurname, execute, sex);
            prisoners.add(prisoner);
            JailCell jailCell = new JailCell(prisoner);
            jailCell.getJailCellNumber(prisoner);

           // DataBase.savePrisonerInDB(prisoner);

            prisIDandJailCellShownUI(prisoner);

        });

        Button noButton = new Button("No");
        noButton.setOnAction(event -> {
            enterPrisonerDataUI();
        });

        root.add(text1, 1, 0);
        root.add(yesButton, 2, 1);
        root.add(noButton, 3, 1);


        stage.setScene(new Scene(root, 1000, 400));
        stage.show();
    }

    private long prisID(int prisAge, int prisJailTime, int prisPoints, String sex) {
        long prisId = 0;
        if (prisAge == 0 || prisJailTime == 0 || prisPoints == 0) {
            prisAge = (int) (Math.random() * 98 + 1);
            prisJailTime = (int) (Math.random() * 98 + 1);
            prisPoints = (int) (Math.random() * 98 + 1);
            prisId = prisID(prisAge, prisJailTime, prisPoints, sex);
        }

        int i = (int) (Math.random() * 98 + 1);
        int j = (int) (Math.random() * 8 + 1);


        prisId = ((prisAge * prisJailTime * prisPoints * i) ^ 2) * j + prisId;


        if (sex.equals("M")) {
            prisId = prisId * 1000;
        } else {
            prisId = prisId * 10000;
        }
        studentIDList.add(prisId);
        return prisId;
    }

    private void prisIDandJailCellShownUI(Prisoner prisoner) {
        stage.setTitle("Prisoner ID");

        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        root.setPrefSize(500, 350);

        String prisIDString = String.valueOf(prisoner.getPrisonerID());
        JailCell jailCellID = new JailCell(prisoner);
        int i = (int) (Math.random() * 9) + 1;

        Text text = new Text("Prisoner ID is : ");
        Text prisIDText = new Text(prisIDString);

        Text jailCell = new Text("Prisoner Will be Held in Jail Cell: ");
        Text jailCellText = new Text(jailCellID.getJailCellNumber(prisoner) + i);

        prisoner.setJailCell(jailCellID.getJailCellNumber(prisoner) + i);


        Button backButton = new Button("OK");
        backButton.setOnAction(event -> {
            firstUI();
        });

        // TODO: 2/14/2020 add to database after clicking ok (I'll try)

        root.add(backButton, 2, 3);
        root.add(jailCell, 1, 2);
        root.add(jailCellText, 2, 2);
        root.add(text, 1, 1);
        root.add(prisIDText, 2, 1);


        stage.setScene(new Scene(root, 1000, 400));
        stage.show();

    }

    private void addPointsUIusingNameUI() {
        stage.setTitle("Add Points To Prisoner");

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);
        root.setHgap(10);

        Text prisName = new Text("Type in Prisoner Name : ");
        TextField textField1 = new TextField();

        Text prisSurname = new Text("Type in Prisoner Surname : ");
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

            Prisoner tempPrisoner = new Prisoner(prisSurnameString, prisNameString);

            // TODO: 2/13/2020 loop through all prisoners in database and find which one has the same name and surname as the searched pris
           for (int i = 0; i < prisonersNames.size(); i++) {
               if(prisNameString.equals(prisonersNames.get(i))){
                   if(prisSurnameString.equals(prisonerSurnames.get(i))){
                       prisoners.get(i).addPoints(pointsToBeGiven);
                   }
               }
         }

            //prisoner.addPoints(pointsToBeGiven); //TODO 2/13/2020 call this method, adding the points to the real prisoner


        });
        root.add(button, 2, 2);

        Button idButton = new Button("Search using ID");
        idButton.setOnAction(event -> {
            addPOintsUIusingIDUI();
        });
        root.add(idButton, 0, 3);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            firstUI();
        });
        root.add(backButton, 3, 4);

        stage.setScene(new Scene(root, 700, 800, Color.BLUE));
        stage.show();
    }

    private void addPOintsUIusingIDUI() {
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

        Button addPointsBUtton = new Button("Add Points");
        addPointsBUtton.setOnAction(event -> {
            long prisIDlooked = Long.parseLong(textField.getText());
            int pointsToBeGiven = comboBox.getValue();

            Prisoner tempPris = new Prisoner(prisIDlooked); // TODO: 2/13/2020 loop through all prisoners in database and find which one has the same id as the searched pris

//            for (int i = 0; i < ; i++) {
            // todo iterate through all pris
//            }
//            tempPris = prisoner;

//            prisoner.addPoints(pointsToBeGiven);

        });
        root.add(addPointsBUtton, 1, 2);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            addPointsUIusingNameUI();
        });

        root.add(backButton, 1, 3);

        root.add(text, 0, 0);
        root.add(textField, 1, 0);
        root.add(text1, 0, 1);
        root.add(comboBox, 1, 1);


        stage.setScene(new Scene(root, 700, 800, Color.BLUE));
        stage.show();
    }

    private void userIsLookingUsingPrisNameUI() {
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

            prisonerWhichHasBeenFoundUI(searchForPrisonerUsingNameAndSurname(prisName, prisSurname));

        });

        root.add(button, 2, 3);

        Button idButton = new Button("Search Using Prisoner ID");
        idButton.setOnAction(event -> {
            userIsLookingUsingPrisIDUI();
        });

        root.add(idButton, 3, 3);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            firstUI();
        });

        root.add(backButton, 4, 3);

        // cycle through all Prisoners and find the one they are looking for, if none are present do smth

        stage.setScene(new Scene(root));
        stage.show();
    }

    private void userIsLookingUsingPrisIDUI() {
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

            Prisoner tempPrisoner = new Prisoner(prisID); // TODO: 2/13/2020 iteration ma dude


            /*for (int i = 0; i < ; i++) {
            todo find the dude

            }*/


//            prisonerWhichHasBeenFoundUI(prisoner);
        });

        root.add(button, 2, 3);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            firstUI();
        });

        root.add(backButton, 3, 3);

        stage.setScene(new Scene(root));
        stage.show();
    }

    private void showPrisUI() {
        stage.setTitle("Pris Database");

        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        root.setPrefSize(500, 350);

        ListView<Prisoner> listViewofPrisoners = new ListView<>();
        ObservableList<Prisoner> items = FXCollections.observableArrayList(
                DataBase.getAllPrisonersFromDB()
        );
        listViewofPrisoners.setItems(items);

        listViewofPrisoners.setMinSize(500, 600);

        // TODO: 2/13/2020 get all prisoners from database, add them to list prisoners


        root.add(listViewofPrisoners, 0, 0);
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            firstUI();
        });

        root.add(backButton, 3, 3);


        stage.setScene(new Scene(root, 800, 1000));
        stage.show();
    }

    private void searchForPrisJailcellUsingPrisNameUI() {
        stage.setTitle("Search for Prisoner's Jail Cell");

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);
        root.setHgap(10);

        Text enterPrisNameHere = new Text("Enter Prisoner Name here: ");
        TextField enterPrisNameTextField = new TextField();
        Text enterPrisSurnameHere = new Text("Enter Prisoner Surname here: ");
        TextField enterPrisSurnameHereTextField = new TextField();

        root.add(enterPrisNameHere, 1, 1);
        root.add(enterPrisNameTextField, 2, 1);
        root.add(enterPrisSurnameHere, 1, 2);
        root.add(enterPrisSurnameHereTextField, 2, 2);

        Button searchButton = new Button("Search");
        searchButton.setOnAction(event -> {
            String prisName = enterPrisNameTextField.getText();
            String prisSurname = enterPrisSurnameHereTextField.getText();

            //something idk lmao
        });

        root.add(searchButton, 4, 4);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            firstUI();
        });
        root.add(backButton, 4, 5);

        Button searchUsingIDButton = new Button("Search using ID");
        searchUsingIDButton.setOnAction(event -> searchForPrisJailCellUsingPrisIDUI());

        stage.setScene(new Scene(root, 600, 800));
        stage.show();
    }

    private void searchForPrisJailCellUsingPrisIDUI() {
        stage.setTitle("Search for Prisoner's Jail Cell");

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);
        root.setHgap(10);

        Text enterPrisIDHere = new Text("Enter Prisoner ID here: ");
        TextField enterPrisIDHereTextField = new TextField();

        root.add(enterPrisIDHere, 1, 1);
        root.add(enterPrisIDHereTextField, 2, 1);

        Button searchButton = new Button("Search");
        searchButton.setOnAction(event -> {
            long prisID = Long.parseLong(enterPrisIDHere.getText());

            prisonerWhichHasBeenFoundUI(searchForPrisonerUsingID(prisID));

        });


        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            firstUI();
        });
        root.add(backButton, 4, 5);

        stage.setScene(new Scene(root, 600, 800));
        stage.show();
    }

    private Prisoner searchForPrisonerUsingID(Long prisID) {
        Prisoner tempPris = new Prisoner(prisID);

//        for (int i = 0; i < ; i++) {
//          todo iterate trhough all prisoners, see if they match id
//        }

        return tempPris;
    }

    private Prisoner searchForPrisonerUsingNameAndSurname(String name, String surname) {
        Prisoner tempPris = new Prisoner(name, surname);

//        for (int i = 0; i < ; i++) {
//          todo iterate through all prisoners, find the matching ones
//        }

        return tempPris;
    }

    private void prisonerWhichHasBeenFoundUI(Prisoner prisoner) {
        stage.setTitle("Prisoner has been found");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);
        root.setHgap(10);

        Text prisonerText = new Text(prisoner.getNameAndSurname());

        root.add(prisonerText, 1, 1);

        Button backButton = new Button("Nice");
        backButton.setOnAction(event -> {
            firstUI();
        });
        stage.setScene(new Scene(root, 800, 600));
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
