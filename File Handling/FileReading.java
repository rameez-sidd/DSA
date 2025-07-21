import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class FileReading {
    public static void main(String[] args) {
        // try(FileReader fr = new FileReader("file.txt")){
        //     int letter = fr.read();
        //     while (letter != -1) {
        //         System.out.print((char) letter);
        //         letter = fr.read();
        //     }
        // } catch(IOException e){
        //     System.out.println(e.getMessage());
        // }

        // try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
        //     System.out.println("You Typed : " + br.readLine());
        // } catch(IOException e){
        //     System.out.println(e.getMessage());
        // }

        // output writer
        try(OutputStreamWriter osw = new OutputStreamWriter(System.out)){
            osw.write("Hello world");
            osw.write(97);
            osw.write(10);
            osw.write('A');
            osw.write('\n');
            char[] arr = "hello world".toCharArray();
            osw.write(arr);
            // osw.write(🤫);
        } catch(IOException e){
            System.out.println(e.getMessage());
        }



        // File Writer
        try (FileWriter fw = new FileWriter("hello.txt", true)){
            fw.write(". I live in Delhi");
        
            // fw.append(". My name is Rameez");


        } catch(IOException e){
            System.out.println(e.getMessage());
        }


        // Buffered Writer
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("hey.txt"))){
            bw.write("Hey, How are you?");


        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
