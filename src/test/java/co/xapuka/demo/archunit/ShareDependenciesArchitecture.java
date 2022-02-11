package co.xapuka.demo.archunit;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.core.importer.Location;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.freeze.FreezingArchRule.freeze;

@AnalyzeClasses(packages = "co.xapuka.demo.archunit", importOptions = {ShareDependenciesArchitecture.IgnoreClasses.class})
class ShareDependenciesArchitecture {

    @ArchTest
    static final ArchRule onlyUseShareInAModule = freeze(classes().that().resideInAPackage("..share..")
            .should().onlyHaveDependentClassesThat().resideInAnyPackage("..app.main.amodule.."));

     static class IgnoreClasses implements ImportOption {

        @Override
        public boolean includes(Location location) {
            if (!location.contains("co/xapuka/demo/archunit/app/Service.class")) {
                return false;
            }
            if (!location.contains("BService.class")) {
                return false;
            }
            return true;
        }
    }
}