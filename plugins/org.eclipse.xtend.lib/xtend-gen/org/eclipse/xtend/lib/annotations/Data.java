package org.eclipse.xtend.lib.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.eclipse.xtend.lib.annotations.DataProcessor;
import org.eclipse.xtend.lib.macro.Active;

/**
 * @since 2.7
 */
@Target(ElementType.TYPE)
@Active(DataProcessor.class)
public @interface Data {
}
