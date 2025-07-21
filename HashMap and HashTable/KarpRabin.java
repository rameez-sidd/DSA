public class KarpRabin {
    private final int PRIME = 101;

    private long calculateHash(String str){
        long hash = 0;

        for(int i=0; i < str.length(); i++){
            hash = hash + (str.charAt(i) * (long)Math.pow(PRIME, i));
        }

        return hash;
    }

    private long updateHash(Long prevHash, char oldChar, char newChar, int patternLength) {
        long newHash = (prevHash - oldChar)/PRIME;
        newHash = newHash + newChar * (long)Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    public void search(String text, String pattern) {
        int patternLength = pattern.length();
        long patternHash = calculateHash(pattern);

        long textHash = calculateHash(text.substring(0, patternLength));

        for(int i=0; i <= text.length() - patternLength; i++) {
            if(textHash == patternHash) {
                if(text.substring(i, i + patternLength).equals(pattern)) {
                    System.out.println("Pattern found at index: " + i);
                }
            }

            if(i < text.length() - patternLength) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            } 
        }
    }


    public static void main(String[] args) {
        KarpRabin kr = new KarpRabin();
        String text = "ApoorvKunalRahul";
        String pattern = "Kunal";

        kr.search(text, pattern);
    }
}
