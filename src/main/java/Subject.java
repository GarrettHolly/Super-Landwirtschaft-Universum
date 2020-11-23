import java.util.ArrayList;
import java.util.List;

/**
 * Subjects used for the observer to get what needs to be notified of updates.
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private GameState gameState;

    public GameState getState() {
        return gameState;
    }

    public void setState(GameState gameState) {
        this.gameState = gameState;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
