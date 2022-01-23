package co.xapuka.demo.archunit.share.amodule;

public final class ModuleUtils {
    private ModuleUtils(){
    }

    public static void doSomething() {
        System.out.println(ModuleUtils.class.getSimpleName() + ".doSomething!!!");
    }



}
