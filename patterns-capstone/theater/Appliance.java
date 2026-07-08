package theater;

import java.util.ArrayList;
import java.util.List;

// TEMPLATE METHOD (given, so you can see the shape). startUp() is the fixed skeleton:
// every appliance plugs in, warms up, then reports ready - always in that order. It is
// declared FINAL on purpose, so no subclass can change the order. The only thing that
// varies between appliances is the warmUp() hook, which each subclass fills in.
public abstract class Appliance {

    // The locked skeleton. Same steps, same order, for every appliance.
    public final List<String> startUp() {
        List<String> log = new ArrayList<>();
        log.add("plugged in");     // fixed
        log.add(warmUp());         // the one varying step (the hook)
        log.add("ready");          // fixed
        return log;
    }

    // The hook: each appliance decides what "warming up" means for it.
    protected abstract String warmUp();
}
