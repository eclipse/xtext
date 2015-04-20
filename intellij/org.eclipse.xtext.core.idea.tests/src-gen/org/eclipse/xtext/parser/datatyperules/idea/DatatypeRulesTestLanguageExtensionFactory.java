package org.eclipse.xtext.parser.datatyperules.idea;

import org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class DatatypeRulesTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return DatatypeRulesTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
