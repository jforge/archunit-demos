package livedemo.jax2019;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import javax.transaction.Transactional;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "com.muchsoft")
public class JAX_7_Methods_Test {

    @ArchTest
    public void customConditionsAndPredicates(JavaClasses javaClasses) {

        ArchRule rule = methods().that().areDeclaredInClassesThat()
                .haveSimpleNameEndingWith("Repository")
                .should().beAnnotatedWith(Transactional.class);

        rule.check(javaClasses);
    }
}
