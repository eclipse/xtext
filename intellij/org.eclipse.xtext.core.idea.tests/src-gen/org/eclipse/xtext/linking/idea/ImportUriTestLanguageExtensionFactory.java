package org.eclipse.xtext.linking.idea;

import org.eclipse.xtext.linking.idea.lang.ImportUriTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class ImportUriTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return ImportUriTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
