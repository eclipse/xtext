package org.eclipse.xtend.core.tests.macro;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.eclipse.xtend.core.tests.macro.GetProcessor;
import org.eclipse.xtend.lib.macro.Active;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Active(GetProcessor.class)
public @interface Get {
  public String value();
}
