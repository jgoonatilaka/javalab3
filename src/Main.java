import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("Numbers.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        double sum = 0.0;
        int count = 0;
        double sumOfSquares = 0.0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            try {

                double number = Double.parseDouble(line);
                sum += number;
                count++;

            } catch (NumberFormatException e) {
                System.err.println("Skipping invalid input: " + line);
            }
        }

        double mean = count > 0 ? sum / count : 0.0;

        BufferedReader reader2 = new BufferedReader(new FileReader("Numbers.txt"));
        String line_2;
        double difference = 0;
        double stdDeviation;
        while ((line_2 = reader2.readLine()) != null){
            double num2 = Double.parseDouble(line_2);
            difference = difference + Math.pow((num2 - mean) , 2);
        }

        stdDeviation = Math.sqrt(difference/count);


        FileWriter fileWriter = new FileWriter("output.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        String strDev;
        strDev = Double.toString(stdDeviation);



        printWriter.printf("Mean: %.3f%n", mean);
        printWriter.write("Standard Deviation: ");
        printWriter.write(strDev);



        bufferedReader.close();
        printWriter.close();




    }
}