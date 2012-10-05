package org.eclipse.xpect.setup;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface XpectSetup {
	Class<? extends IXpectSetup<?, ?, ?, ?>> value();
}
