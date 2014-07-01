package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.AccessorsProcessor;
import org.eclipse.xtend.lib.macro.Active;

/**
 * @since 2.7
 */
@GwtCompatible
@Target({ ElementType.FIELD, ElementType.TYPE })
@Active(AccessorsProcessor.class)
public @interface Accessors {
  public AccessorType[] value() default { AccessorType.PUBLIC_GETTER, AccessorType.PUBLIC_SETTER };
}
