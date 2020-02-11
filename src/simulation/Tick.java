package simulation;

public class Tick extends AbstractEvent {

  /**
   * Constructor for AbstractEvent.
   *
   * @param time
   */
  public Tick(double time) {
    super(time);
  }

  @Override
  public void happen(ParticleEventHandler h) {
    h.reactTo(this);
  }

  @Override
  public boolean isValid() {
    return true;
  }
}
