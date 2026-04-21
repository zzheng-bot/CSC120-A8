import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {
    private Hashtable<String, Boolean> collection;
    private boolean hasElevator;

    public Library(String name, String address, int nFloors, boolean hasElevator) {
        super(name, address, nFloors);
        collection = new Hashtable<>();
        this.hasElevator = hasElevator;
    }

    public Library() {
        this("Neilson Library", "Smith College Campus", 4, true);
    }


    public Library(String name, String address) {
        this(name, address, 3, true);
    }

    public boolean hasElevator() {
        return hasElevator;
    }


    public void addTitle(String title) {
        collection.put(title, true);
    }


    public void addTitle(String title, boolean isAvailable) {
        collection.put(title, isAvailable);
    }

    public String removeTitle(String title) {
        if (collection.containsKey(title)) {
            collection.remove(title);
            return title;
        }
        return null;
    }

    public void checkOut(String title) {
        if (collection.containsKey(title)) {
            collection.replace(title, false);
        }
    }

    public void returnBook(String title) {
        if (collection.containsKey(title)) {
            collection.replace(title, true);
        }
    }

    public boolean containsTitle(String title) {
        return collection.containsKey(title);
    }

    public boolean isAvailable(String title) {
        return collection.getOrDefault(title, false);
    }

    public void printCollection() {
        System.out.println("\n=== " + this.name + " Collection ===");
        for (String title : collection.keySet()) {
            String status = collection.get(title) ? "Available" : "Checked out";
            System.out.println("- " + title + " | " + status);
        }
    }

    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println("+ addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + printCollection()");
    }

    @Override
    public void goToFloor(int n) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("Must enter the library first!");
        }
        if (hasElevator) {
            super.goToFloor(n);
        } else {
            if (Math.abs(n - activeFloor) == 1) {
                super.goToFloor(n);
            } else {
                System.out.println("No elevator: only one floor at a time!");
            }
        }
    }
}