package theater;

// A projector screen - another box in the subsystem the Facade will drive. (given)
public final class Screen {
    private String showing = "nothing";

    public void show(String title) { showing = title; }
    public String showing()        { return showing; }
}
