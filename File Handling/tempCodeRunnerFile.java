try (FileWriter fw = new FileWriter("hello.txt", true)){
            fw.write(". I live in Delhi");
        
            // fw.append(". My name is Rameez");


        } catch(IOException e){
            System.out.println(e.getMessage());
        }