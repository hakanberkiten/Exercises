public class GradeSystem {
    public static void main(String[] args) {

     
     


        
    }
}
class Person {
private String name;
private String surname; 
private long ID;
private String position;

public Person(String name, String surname, long iD, String position) {
    this.name = name;
    this.surname = surname;
    ID = iD;
    this.position = position;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getSurname() {
    return surname;
}

public void setSurname(String surname) {
    this.surname = surname;
}

public long getID() {
    return ID;
}

public void setID(long iD) {
    ID = iD;
}

public String getPosition() {
    return position;
}

public void setPosition(String position) {
    this.position = position;
}

}
class Student extends Person{
private double Math;
private double CSE;
private double Physics;


public Student(String name, String surname, long ID , double Math , double CSE , double Physics){

    super(name , surname , ID , "student");
    this.Math = Math;
    this.CSE = CSE;
    this.Physics = Physics;



}


public double getMath() {
    return Math;
}


public void setMath(double math) {
    Math = math;
}


public double getCSE() {
    return CSE;
}


public void setCSE(double cSE) {
    CSE = cSE;
}


public double getPhysics() {
    return Physics;
}


public void setPhysics(double physics) {
    Physics = physics;
}


public void lookGrades(){
System.out.println("Student: " + getName());
System.out.println("Math: " +getMath());
System.out.println("Physics: " +getPhysics());
System.out.println("CSE: " +getCSE());


}
public void showAverage(){
double average =  (getMath() + getCSE() + getPhysics()) / 3;

System.out.println("Your average is " + average);
}



}
class Teacher extends Person{

    public Teacher(String name, String surname, long ID , String position){

        super(name , surname , ID , position);
    
    }

    

    @Override
    public long getID() {
        return super.getID();
    }



    @Override
    public String getName() {
        return super.getName();
    }



    @Override
    public String getPosition() {
        return super.getPosition();
    }



    @Override
    public String getSurname() {
        return super.getSurname();
    }



    @Override
    public void setID(long iD) {
        super.setID(iD);
    }



    @Override
    public void setName(String name) {
        super.setName(name);
    }



    @Override
    public void setPosition(String position) {
        super.setPosition(position);
    }



    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }




    public void changeGrade(Student student, String lesson, double newGrade) {
        if (getPosition().equals("CSE Teacher") && lesson.equals("CSE")) {
        student.setCSE(newGrade);
        System.out.println("You are changed grade for " + student.getName()+ " Previous grade: " + student.getCSE() + " New grade: " + newGrade);
        }
        else if (getPosition().equals("Math Teacher")&& lesson.equals("Math")) {
        student.setMath(newGrade);
        System.out.println("You are changed grade for " + student.getName()+ " Previous grade: " + student.getMath() + " New grade: " + newGrade);

        }
        else if (getPosition().equals("Physics Teacher")&& lesson.equals("Physics")) {
        student.setPhysics(newGrade);
        System.out.println("You are changed grade for " + student.getName()+ " Previous grade: " + student.getPhysics() + " New grade: " + newGrade);
        }
        else{
        System.out.println("You can't change this grade.");
        }

    }   
}