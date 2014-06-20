package org.eclipse.xtend.lib;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.SetterProcessor;
import org.eclipse.xtend.lib.macro.Active;

/**
 * If the target is a field, creates a setter for that field. If the target is a class, adds setters to all persistent fields.
 * @since 2.7
 */
@Beta
@GwtCompatible
@Active(SetterProcessor.class)
@Target({ ElementType.FIELD, ElementType.TYPE })
public @interface Setter {
}
