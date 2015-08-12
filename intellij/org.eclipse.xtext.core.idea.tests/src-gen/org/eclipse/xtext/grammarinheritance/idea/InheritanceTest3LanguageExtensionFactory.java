package org.eclipse.xtext.grammarinheritance.idea;

import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest3LanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class InheritanceTest3LanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return InheritanceTest3LanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
