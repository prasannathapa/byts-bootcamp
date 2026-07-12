package theater;

// The modern interface the theater speaks. Any amplifier the theater drives must look
// like this: turn on, set a volume 0..100, and report its status.
public interface SoundSystem {
    void on();
    void setVolume(int percent);   // 0..100
    String status();
}
