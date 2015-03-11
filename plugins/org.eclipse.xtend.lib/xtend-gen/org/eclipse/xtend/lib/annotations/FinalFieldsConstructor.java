package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructorProcessor;
import org.eclipse.xtend.lib.macro.Active;

/**
 * <p>Creates a constructor that takes a parameter for each final field of a class.</p>
 * 
 * Annotated on a class
 * <p>
 * Creates a constructor that takes all
 * non-static, final fields of the class as an argument and assigns them to
 * their corresponding fields. The order of arguments is the same as the order
 * of the fields.
 * </p>
 * Annotated on a constructor
 * <p>
 * Turns that constructor into a final
 * fields constructor as described above. This is useful for adding annotations
 * to the constructor, e.g. for dependency injection frameworks.
 * </p>
 * 
 * @since 2.7
 */
@Target({ ElementType.TYPE, ElementType.CONSTRUCTOR })
@GwtCompatible
@Beta
@Active(FinalFieldsConstructorProcessor.class)
@Documented
public @interface FinalFieldsConstructor {
}
