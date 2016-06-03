package thread;

public class WaitMessages {
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
            //Pause for 5 seconds
            Thread.sleep(5000);
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
