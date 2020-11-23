
/**
 * Observer for when a sheep is purchased.
 */
public class SheepPurchaseDisplay extends Observer {
    public SheepPurchaseDisplay(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("You have purchased a sheep.");

    }
}
