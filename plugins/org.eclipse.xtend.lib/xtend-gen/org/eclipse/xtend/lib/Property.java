package org.eclipse.xtend.lib;

import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.PropertyProcessor;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.Active;

/**
 * Creates a getter and setter method for the annotated field.
 * Prepends the field name with an underscore (e.g. <code>_myField</code>)
 * 
 * @author Sven Efftinge
 * @deprecated use {@link Accessors} instead
 */
@GwtCompatible
@Target(ElementType.FIELD)
@Active(PropertyProcessor.class)
@Deprecated
public @interface Property {
}
