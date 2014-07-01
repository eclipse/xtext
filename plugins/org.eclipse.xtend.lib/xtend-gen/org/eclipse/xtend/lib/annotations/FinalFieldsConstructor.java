package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructorProcessor;
import org.eclipse.xtend.lib.macro.Active;

/**
 * @since 2.7
 */
@Target({ ElementType.TYPE, ElementType.CONSTRUCTOR })
@GwtCompatible
@Beta
@Active(FinalFieldsConstructorProcessor.class)
public @interface FinalFieldsConstructor {
}
