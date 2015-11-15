package org.eclipse.xtext.lexer.idea;

import org.eclipse.xtext.lexer.idea.lang.BacktrackingLexerTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class BacktrackingLexerTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return BacktrackingLexerTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
