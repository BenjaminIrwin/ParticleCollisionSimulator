package simulation;

public interface ParticleEventHandler {

  void reactTo(Tick tick);

  void reactTo(Collision c);
}
