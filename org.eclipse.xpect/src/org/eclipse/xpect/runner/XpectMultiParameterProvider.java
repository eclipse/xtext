package org.eclipse.xpect.runner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.xpect.runner.IXpectParameterProvider.IXpectMultiParameterProvider;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.ANNOTATION_TYPE })
public @interface XpectMultiParameterProvider {
	Class<? extends IXpectMultiParameterProvider> value();
}
