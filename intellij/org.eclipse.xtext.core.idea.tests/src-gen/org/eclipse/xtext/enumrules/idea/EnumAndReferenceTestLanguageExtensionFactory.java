package org.eclipse.xtext.enumrules.idea;

import org.eclipse.xtext.enumrules.idea.lang.EnumAndReferenceTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class EnumAndReferenceTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return EnumAndReferenceTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
