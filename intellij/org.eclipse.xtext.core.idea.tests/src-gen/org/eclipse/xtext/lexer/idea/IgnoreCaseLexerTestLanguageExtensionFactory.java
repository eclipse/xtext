package org.eclipse.xtext.lexer.idea;

import org.eclipse.xtext.lexer.idea.lang.IgnoreCaseLexerTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class IgnoreCaseLexerTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return IgnoreCaseLexerTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
