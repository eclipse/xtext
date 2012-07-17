package org.eclipse.xpect.runner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.xpect.runner.IXpectParameterProvider.IXpectSingleParameterProvider;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.ANNOTATION_TYPE })
public @interface XpectSingleParameterProvider {
	Class<? extends IXpectSingleParameterProvider> value();
}
