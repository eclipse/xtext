package org.eclipse.xtext.parsetree.formatter.idea;

import org.eclipse.xtext.parsetree.formatter.idea.lang.FormatterTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class FormatterTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return FormatterTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
