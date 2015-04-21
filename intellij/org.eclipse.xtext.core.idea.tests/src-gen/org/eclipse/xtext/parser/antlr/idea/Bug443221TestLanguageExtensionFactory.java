package org.eclipse.xtext.parser.antlr.idea;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug443221TestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class Bug443221TestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return Bug443221TestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
