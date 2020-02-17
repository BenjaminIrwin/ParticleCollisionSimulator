package simulation;

public abstract class Collision extends AbstractEvent {

  protected Particle[] particles = null;
  private int[] initial_hits ;

  /** Constructor for Collision */
  public Collision(double t, Particle[] ps) {
    super(t);
    this.particles = ps;
    initial_hits = new int[particles.length];
    for (int i = 0; i < particles.length; i++){
      initial_hits[i] = particles[i].collisions();
    }
  }

  /** Returns true if this Collision is (still) valid. */
  @Override
  public boolean isValid() {
    for (int i = 0; i <particles.length; i++) {
      if (initial_hits[i] != particles[i].collisions()) {
        return false;
      }
    }
      return true;
  }

  /** Returns an array containing the Particles involved in this Collision. */
  public Particle[] getParticles() {
    return particles;
  }
}
