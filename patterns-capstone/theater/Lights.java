package theater;

// A dimmable light - one box in the theater subsystem the Facade will drive. (given)
public final class Lights {
    private int level = 100;                     // percent

    public void dim(int percent) { level = Math.max(0, Math.min(100, percent)); }
    public int level()           { return level; }
}
