package ma.najeh.colorswitcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private Slider redSlider,greenSlider,blueSlider;
    private TextField hexaOut;
    private Pane outPane;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        outPane = (Pane) root.lookup("#out_pane");
        hexaOut = (TextField) root.lookup("#hexa_out");
        redSlider = (Slider) root.lookup("#red");
        greenSlider = (Slider) root.lookup("#green");
        blueSlider = (Slider) root.lookup("#blue");
        changeColor();


        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            changeColor();
        });
        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            changeColor();
        });
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            changeColor();
        });


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }



    private void changeColor() {
        int red=new Double(redSlider.getValue()).intValue();
        int green=new Double(greenSlider.getValue()).intValue();
        int blue=new Double(blueSlider.getValue()).intValue();
        changeColor(red,green,blue);
    }
    private void changeColor(int r, int g, int b) {
        StringBuilder sb=new StringBuilder("#")
                .append(getHexa(r))
                .append(getHexa(g))
                .append(getHexa(b));
        hexaOut.setText(sb.toString());
        setPaneBg();
    }

    private String getHexa(int i) {
        String color=Integer.toHexString(i);
        if (color.length()==1){
            return "0"+color;
        }
        return color;
    }

    private void setPaneBg() {
        outPane.setBackground(new Background(new BackgroundFill(Color.web(hexaOut.getText()), CornerRadii.EMPTY, Insets.EMPTY)));

    }


    public static void main(String[] args) {
        launch(args);
    }
}
