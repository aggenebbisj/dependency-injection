
package di;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Bootstrap {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        InjectionTarget target = (InjectionTarget) Class.forName("di.InjectionTarget").newInstance();
        for (Field field : target.getClass().getDeclaredFields()) {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation.annotationType().isAssignableFrom(MyInject.class)) {
                    field.setAccessible(true); // override private
                    field.set(target, field.getType().newInstance());
                }
            }
        }
        
        System.out.println("target.injectee = " + target);
    }
}
