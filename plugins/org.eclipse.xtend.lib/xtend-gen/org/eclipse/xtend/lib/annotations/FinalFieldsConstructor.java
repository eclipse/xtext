package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructorProcessor;
import org.eclipse.xtend.lib.macro.Active;

/**
 * <h1>Annotated on a class</h1> Creates a constructor that takes all
 * non-static, final fields of the class as an argument and assigns them to
 * their corresponding fields. The order of arguments is the same as the order
 * of the fields.
 * 
 * <h1>Annotated on a constructor</h1> Turns that constructor into a final
 * fields constructor as described above. This is useful for adding annotations
 * to the constructor, e.g. for dependency injection frameworks.
 * 
 * @since 2.7
 */
@Target({ ElementType.TYPE, ElementType.CONSTRUCTOR })
@GwtCompatible
@Beta
@Active(FinalFieldsConstructorProcessor.class)
public @interface FinalFieldsConstructor {
}
