public class DiseasedCropDisplay extends Observer {

    public DiseasedCropDisplay(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("A crop has withered you have a chance to cure it still. You have "
                + this.subject.getState().getNumHealthyCrops() + " crops still alive.");

    }

}
