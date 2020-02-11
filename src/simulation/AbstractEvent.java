package simulation;

public abstract class AbstractEvent implements Event {

  protected double time = -1;

  /** Constructor for AbstractEvent. */
  public AbstractEvent(double time) {
    this.time = time;
  }

  /** Returns the time (in ticks) at which this event will occur. */
  @Override
  public double time() {
    return this.time;
  }

  //TODO: Improve formatting of print.
  @Override
  public String toString() {
    return String.valueOf(time);
  }

  /** Compares this object with the specified Event. */
  @Override
  public int compareTo(Event that) {
    if (time > that.time()) {
      return 1;
    } else if (time == that.time()) {
      return 0;
    }
    return -1;
  }
}
