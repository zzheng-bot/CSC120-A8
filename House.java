import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;


  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }


  public House(boolean hasDiningRoom){
    this("Generic House", "Unknown Address", 1, hasDiningRoom, false);
  }


  public House() {
    this("Default House", "Unknown", 2, false, false);
  }

  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  public boolean hasElevator() {
    return hasElevator;
  }

  public int nResidents() {
    return residents.size();
  }


  public void moveIn(Student s) {
    residents.add(s);
  }

  public void moveIn(Student s1, Student s2) {
    residents.add(s1);
    residents.add(s2);
  }

  public Student moveOut(Student s) {
    if (residents.remove(s)) return s;
    return null;
  }

  public boolean isResident(Student s) {
    return residents.contains(s);
  }

  @Override
  public void showOptions() {
    super.showOptions();
    System.out.println("+ moveIn(Student) / moveIn(Student,Student) \n + moveOut(Student)");
  }

  @Override
  public void goToFloor(int n) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("Must enter the house first!");
    }
    if (hasElevator) {
      super.goToFloor(n);
    } else {
      if (Math.abs(n - this.activeFloor) == 1) {
        super.goToFloor(n);
      } else {
        System.out.println("No elevator: you can only go up/down one floor at a time!");
      }
    }
  }
}