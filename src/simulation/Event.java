package simulation;

public interface Event extends Comparable<Event> {

  double time();

  void happen(ParticleEventHandler h);

  boolean isValid();
}
