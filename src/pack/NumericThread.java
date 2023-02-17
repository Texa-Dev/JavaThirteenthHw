package pack;

public class NumericThread extends Thread {
    private final Resources resources;

    public NumericThread(Resources res) {
        this.resources=res;
    }


    @Override
    public void run() {
        resources.val++;

    }
}
