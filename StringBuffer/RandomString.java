package StringBuffer;

import java.util.Random;

public class RandomString {
    public static void main(String[] args) {
        int size = 10;
        System.out.println(generateRandomString(size));
    }

    static String generateRandomString(int size){
        StringBuffer sb = new StringBuffer(size);

        Random r = new Random();

        for(int i=0; i<size; i++){
            char randomChar = (char)(97 + (r.nextFloat() * 26));
            sb.append(randomChar);
        }

        return sb.toString();


    }
}

