public class ChickenPurchaseDisplay extends Observer {
    public ChickenPurchaseDisplay(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("You have purchased a chicken.");

    }
}
