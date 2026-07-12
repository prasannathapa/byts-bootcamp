package theater;

// TODO: the ADAPTER pattern. The theater speaks SoundSystem (on / setVolume 0..100 / status),
// but the only amplifier you have is a VintageAmp with different method names and a 0..11 dial.
// Make the VintageAmp usable through SoundSystem by WRAPPING it (already stored below) and
// translating each call:
//   on()               -> amp.powerUp()
//   setVolume(percent) -> amp.dial( percent scaled from 0..100 down to 0..11 )   // percent * 11 / 100
//   status()           -> amp.report()
// You may not change VintageAmp or SoundSystem - only translate between them here.
public final class AmpAdapter implements SoundSystem {

    private final VintageAmp amp;

    public AmpAdapter(VintageAmp amp) {
        this.amp = amp;
    }

    @Override
    public void on() {
        throw new UnsupportedOperationException("TODO: power up the vintage amp");
    }

    @Override
    public void setVolume(int percent) {
        throw new UnsupportedOperationException("TODO: scale 0..100 down to 0..11 and dial it");
    }

    @Override
    public String status() {
        throw new UnsupportedOperationException("TODO: return the amp's report()");
    }
}
