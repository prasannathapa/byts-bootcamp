package theater;

// TODO: the BUILDER pattern. A Scene has one required part (its name) and three OPTIONAL
// parts, each with a sensible default. Instead of a four-argument constructor, callers
// build it fluently and skip whatever they don't care about:
//
//     Scene s = Scene.builder("Movie").lights(10).volume(40).source("projector").build();
//     Scene s = Scene.builder("Reading").build();        // everything defaults
//
// Fill in the four Builder methods and describe(). Each setter must RETURN the builder
// (return this) so the calls can chain. describe() returns exactly:
//     "<name>: lights <lights>%, volume <volume>, source <source>"
// e.g. "Movie: lights 10%, volume 40, source projector"
public final class Scene {

    private final String name;
    private final int lights;      // percent, 0..100
    private final int volume;      // 0..100
    private final String source;   // "projector" / "tv" / "none"

    private Scene(Builder b) {
        this.name = b.name;
        this.lights = b.lights;
        this.volume = b.volume;
        this.source = b.source;
    }

    public String name()   { return name; }
    public int lights()    { return lights; }
    public int volume()    { return volume; }
    public String source() { return source; }

    public String describe() {
        throw new UnsupportedOperationException("TODO: \"<name>: lights <lights>%, volume <volume>, source <source>\"");
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }

    // The builder carries the defaults and collects the optional parts.
    public static final class Builder {
        private final String name;
        private int lights = 100;      // defaults, used for any part the caller omits
        private int volume = 20;
        private String source = "none";

        private Builder(String name) { this.name = name; }

        public Builder lights(int percent) {
            throw new UnsupportedOperationException("TODO: set lights, then return this");
        }

        public Builder volume(int percent) {
            throw new UnsupportedOperationException("TODO: set volume, then return this");
        }

        public Builder source(String src) {
            throw new UnsupportedOperationException("TODO: set source, then return this");
        }

        public Scene build() {
            throw new UnsupportedOperationException("TODO: return new Scene(this)");
        }
    }
}
