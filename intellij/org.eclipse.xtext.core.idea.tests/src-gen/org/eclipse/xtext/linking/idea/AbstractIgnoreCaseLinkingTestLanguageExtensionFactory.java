package org.eclipse.xtext.linking.idea;

import org.eclipse.xtext.linking.idea.lang.AbstractIgnoreCaseLinkingTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class AbstractIgnoreCaseLinkingTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return AbstractIgnoreCaseLinkingTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
