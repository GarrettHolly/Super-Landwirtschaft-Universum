public class CowPurchaseDisplay extends Observer {
    public CowPurchaseDisplay(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("You have purchased a cow.");

    }
}
