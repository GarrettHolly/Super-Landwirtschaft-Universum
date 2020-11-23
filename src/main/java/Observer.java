
/**
 * Observer for notifying of updates through game loop.
 */
public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}
