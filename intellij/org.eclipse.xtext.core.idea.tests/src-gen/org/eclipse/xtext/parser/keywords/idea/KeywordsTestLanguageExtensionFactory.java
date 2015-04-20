package org.eclipse.xtext.parser.keywords.idea;

import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class KeywordsTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return KeywordsTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
