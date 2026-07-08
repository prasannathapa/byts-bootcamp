package theater;

import java.util.List;

// TODO: the FACADE pattern. One simple door - watch(scene) - over a messy subsystem
// (lights, sound, screen) plus the Hub. The caller says "watch this scene" and never
// touches the individual boxes. Apply the scene to the subsystem IN THIS ORDER, building
// and returning a log of what happened:
//   1. dim the lights to the scene's light level      -> log "lights -> <n>%"
//   2. turn the sound on                               -> log "sound on"
//   3. set the sound to the scene's volume             -> log "volume <n>"
//   4. show the scene's source on the screen           -> log "screen -> <source>"
//   5. tell the Hub to record the scene by its name    (no log line)
//
// Notice this one method drives the Builder's Scene, the Adapter'd sound, and the Singleton
// Hub together - the facade hides all of that behind a single call.
public final class Theater {

    private final Lights lights;
    private final SoundSystem sound;
    private final Screen screen;

    public Theater(Lights lights, SoundSystem sound, Screen screen) {
        this.lights = lights;
        this.sound = sound;
        this.screen = screen;
    }

    public List<String> watch(Scene scene) {
        throw new UnsupportedOperationException("TODO: apply the scene to the subsystem, record it on the Hub, return the log");
    }
}
