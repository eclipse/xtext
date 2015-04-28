package org.eclipse.xtext.generator.ecore.idea;

import org.eclipse.xtext.generator.ecore.idea.lang.SubTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class SubTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return SubTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
