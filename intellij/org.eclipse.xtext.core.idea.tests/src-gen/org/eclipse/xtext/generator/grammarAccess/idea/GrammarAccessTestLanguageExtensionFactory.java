package org.eclipse.xtext.generator.grammarAccess.idea;

import org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class GrammarAccessTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return GrammarAccessTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
