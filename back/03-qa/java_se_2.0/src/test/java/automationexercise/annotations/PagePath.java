package automationexercise.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação para definir um caminho específico (path) para navegação no teste.
 * Pode ser usada na classe ou no método.
 *
 * Exemplo: @PagePath("/login")
 * Resultado: Navega para BaseURL + "/login"
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface PagePath {
    String value() default "";
}
