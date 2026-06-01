package proj4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.*;

/**
 * Implements TransitSystemGui <br>
 * Filename: TransitSystemGui <br>
 * Project 4: TransitSystemGui <br>
 * Date: 2026-05-15
 * @author Roland Pelzel
 */
public class TransitSystemGui extends Application {
	
	private TransitSystem system = new TransitSystem("Ashland");
    
	private Stage stage;
    
	/** Main method */
	public static void main(String[] args) {
		launch(args);
	}
    
	/**
	 * Start the application.
	 */
	public void start(Stage primaryStage) {
		
		this.stage = primaryStage;
		
		stage.setTitle("Transit System");
		
		stage.setScene(createMainMenuScene());
		
		stage.show();
	}
	
	/**
	 * Main menu scene.
	 * @return Scene
	 */
	public Scene createMainMenuScene() {
		
		Text title = new Text("Transit System");
		
		Button busBtn = new Button("Add Bus");
		Button passengerBtn = new Button("Create Passenger");
		Button ticketBtn = new Button("Buy Ticket");
		
		// Buttons for different scenes.
		busBtn.setOnAction(event ->
			stage.setScene(createBusScene())
		);
		
		passengerBtn.setOnAction(event ->
			stage.setScene(createPassengerScene())
		);
		
		ticketBtn.setOnAction(event ->
			stage.setScene(createTicketScene())
		);
		
		VBox box = new VBox(
				15,
				title,
				busBtn,
				passengerBtn,
				ticketBtn
		);
		
		box.setPadding(new Insets(20));
		
		return new Scene(box, 400, 300);
	}
	
	/**
	 * Bus scene
	 * @return Scene
	 */
	public Scene createBusScene() {
		
		Text title = new Text("Add Bus");
		
		TextField idField = new TextField();
		idField.setPromptText("Vehicle ID");
		
		TextField modelField = new TextField();
		modelField.setPromptText("Model");
		
		TextField capacityField = new TextField();
		capacityField.setPromptText("Capacity");
		
		TextField driverName = new TextField();
		driverName.setPromptText("Driver Name");
		
		TextField driverId = new TextField();
		driverId.setPromptText("Driver ID");
		
		TextField license = new TextField();
		license.setPromptText("License Number");
		
		Text output = new Text();
		
		Button add = new Button("Add");
		Button back = new Button("Back");
		
		add.setOnAction(event -> {
			
			try {
				
				Bus bus = new Bus(
						Integer.parseInt(idField.getText()),
						modelField.getText(),
						Integer.parseInt(capacityField.getText()),
						new Driver(
								driverName.getText(),
								Integer.parseInt(driverId.getText()),
								license.getText()
						)
				);
				
				system.addVehicle(bus);
				
				output.setText("Added:\n" + bus);
				
			} 
			catch(Exception e) {
				output.setText("Invalid input.");
			}
		});
		
		back.setOnAction(e ->
			stage.setScene(createMainMenuScene())
		);
		
		VBox box = new VBox(
				10,
				title,
				idField,
				modelField,
				capacityField,
				driverName,
				driverId,
				license,
				add,
				back,
				output
		);
		
		box.setPadding(new Insets(20));
		
		return new Scene(box, 400, 500);
	}
	
	/**
	 * Passenger scene
	 * @return Scene
	 */
	public Scene createPassengerScene() {
		
		Text title = new Text("Create Passenger");
        
		TextField name = new TextField();
		name.setPromptText("Name");
        
		TextField id = new TextField();
        id.setPromptText("ID");
        
        TextField balance = new TextField();
        balance.setPromptText("Balance");
        
        Text output = new Text();
        
        Button create = new Button("Create");
        Button back = new Button("Back");
        
        create.setOnAction(event -> {
        	
            try {
            	
                Passenger p = new Passenger(
                        name.getText(),
                        Integer.parseInt(id.getText()),
                        Double.parseDouble(balance.getText())
                );
                
                output.setText("Created:\n" + p);
                
            } 
            catch(Exception e) {
                output.setText("Invalid input.");
            }
        });
        
        back.setOnAction(e ->
                stage.setScene(createMainMenuScene())
        );
        
        VBox box = new VBox(
                10,
                title,
                name,
                id,
                balance,
                create,
                back,
                output
        );
        
        box.setPadding(new Insets(20));
        
        return new Scene(box, 400, 400);
    }

    /**
     * Ticket scene.
     * @return Scene
     */
    public Scene createTicketScene() {

        Text title = new Text("Buy Ticket");
        
        TextField fare = new TextField();
        fare.setPromptText("Fare");
        
        Text output = new Text();
        
        ToggleGroup passes = new ToggleGroup();
        RadioButton mp = new RadioButton("Monthly Pass");
        RadioButton dp = new RadioButton("Day Pass");
        
        mp.setToggleGroup(passes);
        dp.setToggleGroup(passes);
        
        Button buy = new Button("Buy");
        Button back = new Button("Back");
        
        buy.setOnAction(event -> {
        	
            try {
            	
                Ticket t = new Ticket(
                        Double.parseDouble(fare.getText()),
                        mp.isSelected(),
                        dp.isSelected()
                );
                
                output.setText("Ticket:\n" + t);
                
            } 
            catch(Exception e) {
            	
                output.setText("Invalid ticket.");
            }
        });
        
        back.setOnAction(event ->
                stage.setScene(createMainMenuScene())
        );
        
        VBox box = new VBox(
                10,
                title,
                fare,
                mp, dp,
                buy,
                back,
                output
        );
        
        box.setPadding(new Insets(20));
        
        return new Scene(box, 400, 300);
    }
}