package thread;

public class SleepMessages {
    public static void main(String args[])
        throws InterruptedException {
        String importantInfo[] = {
            "Коля дюбит мамбу",
            "Оля любит мамбу",
            "И Сережа тоже",
            "Мамбу любят все"
        };

        for (int i = 0;
             i < importantInfo.length;
             i++) {
            //Pause for 4 seconds
           // Thread.sleep(4000);
            //Print a message
            System.out.println(importantInfo[i]);
        }

//        for (int i = 0; i < inputs.length; i++) {
//            heavyCrunch(inputs[i]);
//            if (Thread.interrupted()) {
//                // We've been interrupted: no more crunching.
//                return;
//            }
//        }
//
//        if (Thread.interrupted()) {
//            throw new InterruptedException();
//        }

    }
}
