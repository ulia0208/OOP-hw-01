package family_tree;

import java.io.*;


public class FileHandler implements SafeTo {

    public Object load(String path){
        try (ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(path))){
            //personRestored=(Serializable) objectInputStream.readObject();
            System.out.println("Загружено");
            return objectInputStream.readObject();
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(String path, Serializable obj) {

        try (ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(path))){
            objectOutputStream.writeObject(obj);
            return true;
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
            return false;
        }
    }
}
