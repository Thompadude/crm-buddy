package managers;

/**
 * Forces console to wait for given amount of milliseconds before executing next code.
 */
public class WaitingMechanics {

    public void wait(int milliSecondsToWait) {
        try {
            Thread.sleep(milliSecondsToWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}