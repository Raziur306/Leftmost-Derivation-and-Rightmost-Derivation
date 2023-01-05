import java.util.*;
import java.io.*;

class Derivation {
    private String line1;
    private String line2;
    private String line3;
    private String sentence;

    //calling contructor to set grammer rules
    Derivation(String line1, String line2, String line3, String sentence) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.sentence = sentence;
    }


    private void rightPar() {
        System.out.println(line1.charAt(0) + " " + sentence.charAt(1) + " " + sentence.charAt(2) + " " + sentence.charAt(5) + " " + sentence.charAt(6) + " " + sentence.charAt(1) + " " + sentence.charAt(0));
        System.out.println("Sentence not Supported..\n");
    }
    private void leftParAndE() {
        System.out.println(line1.charAt(0) + " " + sentence.charAt(1) + " " + sentence.charAt(2) + " " + line3.charAt(0) + " " + line3.charAt(1) + " " + line3.charAt(2) + " " + sentence.charAt(6) + " " + sentence.charAt(1) + " " + sentence.charAt(0));
        rightPar();
    }
    private void ADD_OP4() {
        System.out.println(line1.charAt(0) + " " + sentence.charAt(1) + " " + sentence.charAt(2) + " " + line1.charAt(0) + " " + sentence.charAt(6) + " " + sentence.charAt(1) + " " + sentence.charAt(0));
        leftParAndE();
    }
    private void EandId3() {
        System.out.println(line1.charAt(0) + " " + sentence.charAt(1) + " " + sentence.charAt(0));
        ADD_OP4();
    }
    private void EandId2() {
        System.out.println(line1.charAt(0) + " " + sentence.charAt(1) + " " + line2.charAt(0) + "" + line2.charAt(1));
        EandId3();
    }
    private void E3() {
        System.out.println(line1.charAt(0) + " " + sentence.charAt(1) + " " + line1.charAt(0));
        EandId2();
    }

    private void ADD_OP3() {
        System.out.println(line1.charAt(0));
        E3();
    }

    // for m+(d+7)
    private void rightPar2() {
        System.out.println("Supported Sentences..\n");
        ADD_OP3();
    }

    private void EandNum() {
        System.out.println(sentence.charAt(0) + " " + sentence.charAt(1) + " " + sentence.charAt(2) + " " + sentence.charAt(3) + " " + sentence.charAt(1) + " " + sentence.charAt(5) + " " + sentence.charAt(6));
        rightPar2();
    }
    private void E4() {
        System.out.println(sentence.charAt(0) + " " + sentence.charAt(1) + " " + sentence.charAt(2) + " " + sentence.charAt(3) + " " + sentence.charAt(1) + " " + line3.charAt(0) + " " + line3.charAt(1) + " " + line3.charAt(2) + " " + sentence.charAt(6));
        EandNum();
    }
    private void EandID() {
        System.out.println(sentence.charAt(0) + " " + sentence.charAt(1) + " " + sentence.charAt(2) + " " + sentence.charAt(3) + " " + sentence.charAt(1) + " " + line1.charAt(0) + " " + sentence.charAt(6));
        E4();
    }
    private void ADD_OP2() {
        System.out.println(sentence.charAt(0) + " " + sentence.charAt(1) + " " + sentence.charAt(2) + " " + line2.charAt(0) + "" + line2.charAt(1) + " " + sentence.charAt(1) + " " + line1.charAt(0) + " " + sentence.charAt(6));
        EandID();
    }
    private void leftPar() {
        System.out.println(sentence.charAt(0) + " " + sentence.charAt(1) + " " + sentence.charAt(2) + " " + line1.charAt(0) + " " + sentence.charAt(1) + " " + line1.charAt(0) + " " + sentence.charAt(6));
        ADD_OP2();
    }
    private void E2() {
        System.out.println(line2.charAt(0) + "" + line2.charAt(1) + " " + sentence.charAt(1) + " " + sentence.charAt(2) + " " + line1.charAt(0) + " " + sentence.charAt(6));
        leftPar();
    }
    private void E() {
        System.out.println(line1.charAt(0) + " " + sentence.charAt(1) + " " + sentence.charAt(2) + " " + line1.charAt(0) + " " + sentence.charAt(6));
        E2();
    }
    void FIRST_CALL() {
        System.out.println(line1.charAt(0));
        E();
    }

}




class Main {


    public static void main(String[] args) {

        String line1 = "";
        String line2 = "";
        String line3 = "";


        int counter = 0;
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("grammar.txt"));
            String line = reader.readLine();
            while (line != null) {
                if (counter == 0)
                    line1 = line;
                else if (counter == 1) {
                    line2 = line;
                } else {
                    line3 = line;
                }
                counter++;
                line = reader.readLine();

            }
            reader.close();
        } catch (Exception e) {

            System.out.println("Something went wrong");
        }





        //object and function call
        Derivation object = new Derivation(line1, line2, line3, "m+(d+7)");
        object.FIRST_CALL();

    }
}
