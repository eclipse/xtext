package org.eclipse.xtext.grammarinheritance.idea;

import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class InheritanceTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return InheritanceTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
