package org.eclipse.xtext.parser.epatch.idea;

import org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class EpatchTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return EpatchTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
