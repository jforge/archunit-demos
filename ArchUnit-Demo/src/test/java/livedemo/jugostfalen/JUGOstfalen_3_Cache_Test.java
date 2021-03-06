package livedemo.jugostfalen;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.*;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import javax.ejb.Stateful;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.muchsoft", cacheMode = CacheMode.PER_CLASS)
public class JUGOstfalen_3_Cache_Test {

    @ArchTest
    public void myFirstArchUnitTest(JavaClasses classes) {

        ArchRule rule = classes()
                .that().resideInAPackage("..api..")
                .should().bePublic();

        rule.check(classes);
    }

    @ArchTest
    public void noStatefulEJBs(JavaClasses classes) {

        ArchRule rule = classes()
                .should().notBeAnnotatedWith(Stateful.class);

        rule.check(classes);
    }

    @ArchTest
    public static final ArchRule IMPL_IN_BACKEND = classes()
            .that().haveSimpleNameEndingWith("Impl")
            .should().resideInAPackage("..backend..")
            .orShould().beAnnotatedWith(Deprecated.class);

    @ArchTest
    public static ArchRules REGELN_VON_ANDERSWO = ArchRules.in(JUGOstfalen_1_Test.class);

}
