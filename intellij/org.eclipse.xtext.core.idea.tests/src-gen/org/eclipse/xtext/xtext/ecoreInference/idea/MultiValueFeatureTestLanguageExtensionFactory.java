package org.eclipse.xtext.xtext.ecoreInference.idea;

import org.eclipse.xtext.xtext.ecoreInference.idea.lang.MultiValueFeatureTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class MultiValueFeatureTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return MultiValueFeatureTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
