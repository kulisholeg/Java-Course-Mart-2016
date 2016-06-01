package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by mda on 5/13/16.
 */
public class Lesson10HowCall {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
////        Class c = TestReflection.class;
//        Class c = Class.forName("reflection.TestReflection");
//
//        TestReflection t2 = (TestReflection) c.newInstance();
//        t2.setName("Hello reflection!");
//
//        System.out.println(t2.getName());
//
//        System.out.println("_________________________________");
//
//        Method setMethod = c.getMethod("setName", new Class[]{String.class});
//        setMethod.invoke(t2, new String[]{"Hello reflection from reflection"});
//
//        Method getMethod = c.getMethod("getName");
//
//        String name = (String) (getMethod.invoke(t2, null));
//
//        System.out.println(name);
//
//        System.out.println("Private part:");
//
//        Method setLastMethod = c.getDeclaredMethod("setLastName", new Class[]{String.class});
//        setLastMethod.setAccessible(true);
//        setLastMethod.invoke(t2, new String[]{"Hello reflection from reflection for set last name"});
//
//        Method getLastName = c.getDeclaredMethod("getLastName");
//        getLastName.setAccessible(true);
//        String lastName = (String) (getLastName.invoke(t2, null));
//
//        System.out.println(lastName);
//
//

    }}