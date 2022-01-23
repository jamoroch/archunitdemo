package co.xapuka.demo.archunit.app.main.bmodule;

import co.xapuka.demo.archunit.share.amodule.ModuleUtils;

public class BService {
    public void bServiceMethod() {
        System.out.println("Calling ModuleUtils.doSomething() from Bservice");
        ModuleUtils.doSomething();
    }
}
