package ie.tudublin;

public class cat {

    private String name;
    private int numLives;

    public cat(String name) {
        this.name = name;
        this.numLives = 9;
    }

    public String getName() {
        return name;
    }

    public int getNumLives() {
        return numLives;
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
    }

    public void kill() {
        if (numLives > 0) {
            numLives--;
            System.out.println("OUCH");
        } else {
            System.out.println("dead");
        }
    }
}
