package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.annotations.EqualsHashCodeProcessor;
import org.eclipse.xtend.lib.macro.Active;

/**
 * Creates default implementations for {@link Object#equals(Object) equals} and {@link Object#hashCode hashCode}.
 * All non-static, non-transient fields are used.
 * If there is a superclass that overrides equals, then <code>super.equals()</code> and <code>super.hashCode</code> are also called.
 * In such cases, instances of subclasses are never equal to instances of their superclass.
 * @since 2.7
 */
@Beta
@GwtCompatible
@Target(ElementType.TYPE)
@Active(EqualsHashCodeProcessor.class)
public @interface EqualsHashCode {
}
