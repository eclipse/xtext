package org.eclipse.xtext.parser.antlr.idea;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524ExTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class Bug289524ExTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return Bug289524ExTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
