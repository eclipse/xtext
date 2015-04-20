package org.eclipse.xtext.parser.antlr.idea;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889ExTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class Bug296889ExTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return Bug296889ExTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
