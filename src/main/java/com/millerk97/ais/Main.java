package com.millerk97.ais;

import com.millerk97.ais.cryptowatch.calc.SlidingWindow;
import com.millerk97.ais.cryptowatch.impl.CryptoCompareReader;
import com.millerk97.ais.cryptowatch.impl.DataFetcher;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        //ISCalculator.calculateInfluencabilityScore("dogecoin");

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Long start = formatter.parse("01.01.2020").getTime() / 1000;
            Long end = formatter.parse("31.05.2022").getTime() / 1000;
            SlidingWindow window = new SlidingWindow(DataFetcher.getDailyOHLC("dogecoin", end.intValue(), start.intValue()), 15, 3);
            System.out.println(CryptoCompareReader.getHourlyOHLCForDays(window.findAnomalies(0, 100)));
            /*
            for (int i = 0; i < 100; i++) {
                System.out.printf("%.9f", window.calculateStandardDeviation());
                window.advanceWindow();
            }
             */
            //System.out.printf("%.9f", window.calculateStandardDeviation());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        /*
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Startscreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        */
    }
}