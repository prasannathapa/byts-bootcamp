package theater;

// TODO: the SINGLETON pattern. There is exactly ONE control hub for the whole house.
// Expose a single shared instance through Hub.get() - every call must return the SAME
// object. The constructor is already private, so nobody can make a second hub with `new`.
//
//   Add the one instance and hand it out:
//       private static final Hub INSTANCE = new Hub();
//       public static Hub get() { return INSTANCE; }
//
// (Honest note from the slides: a singleton is global mutable state and is usually better
// created once at startup and injected. Here we implement the classic shape so you can see
// that Hub.get() == Hub.get().)
public final class Hub {

    // TODO: hold the single shared instance here.

    private int scenesRun = 0;
    private String lastScene = "none";

    private Hub() { }   // private: no `new Hub()` from outside

    public static Hub get() {
        throw new UnsupportedOperationException("TODO: return the one shared instance");
    }

    public void record(String sceneName) {
        scenesRun++;
        lastScene = sceneName;
    }

    public int scenesRun()    { return scenesRun; }
    public String lastScene() { return lastScene; }
}
