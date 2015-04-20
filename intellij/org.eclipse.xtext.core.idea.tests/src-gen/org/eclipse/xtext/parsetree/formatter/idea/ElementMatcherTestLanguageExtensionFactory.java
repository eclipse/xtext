package org.eclipse.xtext.parsetree.formatter.idea;

import org.eclipse.xtext.parsetree.formatter.idea.lang.ElementMatcherTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class ElementMatcherTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return ElementMatcherTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
