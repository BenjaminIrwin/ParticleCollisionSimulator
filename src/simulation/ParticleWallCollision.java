package simulation;

public class ParticleWallCollision extends Collision {

  public Wall wall = null;
  /**
   * Constructor for Collision
   *
   * @param particle
   * @param wall
   * @param time
   */
  public ParticleWallCollision(Particle particle, Wall wall, double time) {
    this.time = time;
    this.particles = new Particle[] {particle};
    this.wall = wall;
  }

  @Override
  public void happen(ParticleEventHandler handler) {
    Particle.collide(this.particles[0], wall);
    handler.reactTo(this);
  }
}