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
  /**
   * Describes the access modifiers for generated accessors. Valid combinations
   * include at most one type for getters and one for setters.
   * Accessors may be suppressed by passing {@link AccessorType#NONE}.
   */
  public AccessorType[] value() default { AccessorType.PUBLIC_GETTER, AccessorType.PUBLIC_SETTER };
}
