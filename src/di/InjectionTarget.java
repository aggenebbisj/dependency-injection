package di;

public class InjectionTarget {

    @MyInject
    private Injectee injectee;

    @Override
    public String toString() {
        return "InjectionTarget{" + "injectee=" + injectee + '}';
    }
    
}
