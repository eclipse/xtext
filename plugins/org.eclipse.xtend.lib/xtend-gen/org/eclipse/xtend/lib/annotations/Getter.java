package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.annotations.GetterProcessor;
import org.eclipse.xtend.lib.macro.Active;

/**
 * If the target is a field, creates a getter for that field. If the target is a class, adds getters to all persistent fields.
 * @since 2.7
 */
@Beta
@GwtCompatible
@Target({ ElementType.FIELD, ElementType.TYPE })
@Active(GetterProcessor.class)
public @interface Getter {
}
