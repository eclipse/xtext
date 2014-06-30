package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.annotations.PropertyProcessor;
import org.eclipse.xtend.lib.macro.Active;

/**
 * Creates a getter and setter method for the annotated field.
 * @since 2.7
 */
@GwtCompatible
@Target(ElementType.FIELD)
@Active(PropertyProcessor.class)
public @interface Property {
}
