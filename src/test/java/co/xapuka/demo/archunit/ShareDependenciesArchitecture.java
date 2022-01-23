package co.xapuka.demo.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.freeze.FreezingArchRule.freeze;

@AnalyzeClasses(packages = "co.xapuka.demo.archunit")
class ShareDependenciesArchitecture {

    @ArchTest
    static final ArchRule onlyUseShareInAModule =
            freeze(classes().that().resideInAPackage("..share..").should().onlyHaveDependentClassesThat().resideInAnyPackage(
                    "..app.main.amodule.."));

}