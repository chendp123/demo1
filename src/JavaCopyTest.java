public class JavaCopyTest {

    public static void main(String[] args){
        //java 直接赋值
//        Person p=new Person("Tom",24,"2005-2007海外学习，精通java");
//        Person p1=p;
//        p.displayPerson();
//        p.setAge(25);
//        p.setName("cdp");
//        p.displayPerson();
//        p1.displayPerson();

        //java 浅拷贝     创建一个新对象，然后将当前对象的非静态字段复制到该新对象，如果字段是值类型的，那么对该字段执行复制
//        Person1 p2=new Person1("Tom",24,"2005-2007海外学习，精通java");
//        Person1 p3=(Person1) p2.clone();
//        p2.displayPerson();
//        p2.setAge(23);
//        p2.setName("ppt");
//        p2.displayPerson();
//        p3.displayPerson();

        //java 浅拷贝     如果该字段是引用类型的话，则复制引用但不复制引用的对象。因此，原始对象及其副本引用同一个对象。
//        Person1 p4=new Person1("Tom",24);
//        p4.setExperience("2006-2007海外学习","精通java");
//        p4.displayPerson();
//        Person1 p5=(Person1) p4.clone();
//        p4.setExperience("2006-2007海外学习","精通c++");
//        p4.displayPerson();
//        p5.displayPerson();

        //java深拷贝
        Person1 p4=new Person1("Tom",24);
        p4.setExperience("2006-2007海外学习","精通java");
        p4.displayPerson();
        Person1 p5=(Person1) p4.clone();
        p4.setExperience("2006-2007海外学习","精通c++");
        p4.displayPerson();
        p5.displayPerson();
    }


}


class Person {
   private String name;

   private int age;

   //工作经历
   private String experience;

   public Person(String name,int age,String experience){
       this.name=name;
       this.age=age;
       this.experience=experience;
   }

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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void displayPerson(){
        System.out.println("person name is "+name +"  age is "+age+"  experience is "+experience);
    }
}



class Experience {

    private String educationBackground;
    private String skills;

    public void setExperience(String educationBackground, String skills) {
        this.educationBackground = educationBackground;
        this.skills = skills;
    }
    public String toString() {
        return educationBackground + skills;
    }
}
//实现clone
class Person1 implements Cloneable{
    private String name;

    private int age;

    //工作经历
//    private String experience;

    private Experience experience;

    public Person1(String name,int age){
        this.name=name;
        this.age=age;
        this.experience = new Experience();
    }

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


    public Experience getExperience() {
        return experience;
    }

    public void setExperience(String educationBackground, String skills) {
        experience=new Experience();   //JAVA 深拷贝
       experience.setExperience(educationBackground,skills);
    }

    public void displayPerson(){
        System.out.println("person name is "+name +"  age is "+age+"  experience is "+experience);
    }

    public Object clone(){
        try {
            return (Person1)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}

