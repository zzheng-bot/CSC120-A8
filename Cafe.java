public class Cafe extends Building implements CafeRequirements {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
    }

    public Cafe(int coffee, int sugar, int cream, int cups) {
        this("Campus Cafe", "Smith College Center", 1, coffee, sugar, cream, cups);
    }

    public Cafe() {
        this("Default Cafe", "Center Campus", 1, 100, 50, 50, 50);
    }

    public void sellCoffee(int size, int sugar, int cream) {
        if (nCoffeeOunces < size || nSugarPackets < sugar || nCreams < cream || nCups < 1) {
            restock(100, 50, 50, 50);
        }
        nCoffeeOunces -= size;
        nSugarPackets -= sugar;
        nCreams -= cream;
        nCups -= 1;
        System.out.println("Enjoy your coffee!");
    }

    public void sellCoffee(int size) {
        sellCoffee(size, 0, 0);
    }

    public void sellCoffee() {
        sellCoffee(8, 0, 0);
    }

    private void restock(int coffee, int sugar, int cream, int cups) {
        nCoffeeOunces += coffee;
        nSugarPackets += sugar;
        nCreams += cream;
        nCups += cups;
        System.out.println("Restocked cafe inventory!");
    }

    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println("+ sellCoffee() \n + sellCoffee(size) \n + sellCoffee(size,sugar,cream)");
    }

    @Override
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("Must enter the cafe first!");
        }
        if (floorNum != 1) {
            System.out.println("Sorry—upper floors are for staff only! You must stay on floor 1.");
        } else {
            super.goToFloor(1);
        }
    }
}