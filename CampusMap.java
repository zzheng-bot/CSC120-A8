import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    public CampusMap() {
        buildings = new ArrayList<>();
    }

    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " from the map.");
        return b;
    }

    public String toString() {
        String mapString = "\n===== SMITH COLLEGE CAMPUS DIRECTORY =====\n";
        for (int i = 0; i < this.buildings.size(); i++) {
            mapString += "\n  " + (i+1) + ". " + this.buildings.get(i).getName()
                    + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();

        myMap.addBuilding(new Building("Ford Hall", "100 Green Street", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court", 4));
        myMap.addBuilding(new Building("Smith College Museum", "Green St", 3));

        House comstock = new House("Comstock House", "Green St", 3, true, true);
        House tyler = new House(true);
        House lamont = new House();

        Library neilson = new Library("Neilson Library", "Campus Rd", 4, true);
        Library agym = new Library();
        Library hillyer = new Library("Hillyer Library", "Hillyer Hall", 2, false);

        Cafe campusCafe = new Cafe("Campus Cafe", "Center Campus", 1, 100, 50, 50, 30);
        Cafe compactCafe = new Cafe(50, 20, 20, 10);
        Cafe star = new Cafe();

        myMap.addBuilding(comstock);
        myMap.addBuilding(tyler);
        myMap.addBuilding(lamont);
        myMap.addBuilding(neilson);
        myMap.addBuilding(agym);
        myMap.addBuilding(hillyer);
        myMap.addBuilding(campusCafe);
        myMap.addBuilding(compactCafe);
        myMap.addBuilding(star);

        System.out.println(myMap);

        System.out.println("\n===== DEMONSTRATING OVERLOADED METHODS =====");

        Student alice = new Student("Alice", "999", 2014);
        Student bob = new Student("Bob","123", 2028);
        comstock.moveIn(alice);
        comstock.moveIn(alice, bob);
        System.out.println("Comstock residents: " + comstock.nResidents());

        neilson.addTitle("Java Basics");
        neilson.addTitle("OOP Guide", false);
        neilson.printCollection();

        campusCafe.sellCoffee(12);
        campusCafe.sellCoffee(16, 2, 1);
        campusCafe.sellCoffee();

        System.out.println("\n===== DEMONSTRATING OVERRIDDEN METHODS =====");
        comstock.showOptions();
        neilson.showOptions();
        campusCafe.showOptions();

        campusCafe.enter();
        campusCafe.goToFloor(2); // blocked
        campusCafe.goToFloor(1); // allowed

        System.out.println("All demos completed successfully!");
    }
}