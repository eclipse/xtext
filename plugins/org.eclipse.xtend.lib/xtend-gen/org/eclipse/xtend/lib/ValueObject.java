package org.eclipse.xtend.lib;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.ValueObjectProcessor;
import org.eclipse.xtend.lib.macro.Active;

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
@Active(ValueObjectProcessor.class)
@Target(ElementType.TYPE)
public @interface ValueObject {
}
