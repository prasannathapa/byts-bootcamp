package theater;

// A legacy amplifier from another vendor. Different method names from SoundSystem, and its
// dial only goes 0..11 - not 0..100. Pretend this is a third-party jar: you CANNOT change it.
// (This is the mismatch your Adapter has to bridge.)
public final class VintageAmp {
    private boolean powered = false;
    private int dial = 0;                       // 0..11

    public void powerUp()   { powered = true; }
    public void dial(int n) { dial = Math.max(0, Math.min(11, n)); }
    public String report()  { return "amp[" + (powered ? "on" : "off") + ", dial=" + dial + "]"; }
}
