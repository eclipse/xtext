package org.eclipse.xpect.lib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.xpect.lib.IXpectParameterProvider.IXpectSingleParameterProvider;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.ANNOTATION_TYPE })
public @interface XpectSingleParameterProvider {
	Class<? extends IXpectSingleParameterProvider> value();
}
