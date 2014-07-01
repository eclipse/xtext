package org.eclipse.xtend.lib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.DataProcessor;
import org.eclipse.xtend.lib.macro.Active;

/**
 * This annotation is used by the Xtend compiler.
 * It turns an annotated class into an immutable value object.
 * 
 * All fields become final and a getter method is added.
 * The fields' name are prepended with an underscore (i.e. <tt>myField</tt> becomes <tt>_myField</tt>)
 * One constructor for initializing the uninitialized fields is added.
 * {@link Object#equals(Object)} and {@link Object#hashCode()} implementations are added.
 * {@link Object#toString()} implementation is added.
 * 
 * @author Sven Efftinge
 * @deprecated use {@link org.eclipse.xtend.lib.annotations.Data} instead
 */
@Target(ElementType.TYPE)
@Active(DataProcessor.class)
@Deprecated
public @interface Data {
}
