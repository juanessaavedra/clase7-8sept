package ejemplo1.service;

import java.io.*;

public class ObjectSerializer {
    public static void writeObjectToFile(Object obj, String fileName) throws IOException { //Serializar
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(obj);
        objOut.close();
        fileOut.close();
    }

    public static Object readObjectFromFile(String fileName) throws IOException, ClassNotFoundException { //Deserealizar
        FileInputStream fileIn = new FileInputStream(fileName);
        ObjectInputStream objIn = new ObjectInputStream(fileIn);
        Object obj = objIn.readObject();
        objIn.close();
        fileIn.close();
        return obj;
    }
}
