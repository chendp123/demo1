



import sun.misc.IOUtils;

import java.io.*;
import java.util.Date;

public class JavaSerializable {
    public static void main (String[] args) throws IOException{
        //java 序列化j
        //Initializes The Object
        User user = new User();
        user.setName("hollis");
        user.setGender("male");
        user.setAge(23);
        user.setBirthday(new Date());
        System.out.println(user);

        //Write Obj to File
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oos.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           if(oos!=null){
               oos.close();
           }
        }

        //java 反序列化
        //Read Obj from File
        File file = new File("tempFile");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            User newUser = (User) ois.readObject();
            System.out.println(newUser);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ois!=null){
                ois.close();
            }

        }

    }
}

class User implements Serializable{
    private static final long serialVersionUID = 7680879858703608479L;
    private String name;
    private int age;
    private Date birthday;
    private transient String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                '}';
    }
}
