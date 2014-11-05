package org.eclipse.xtext.xbase.idea;

import org.eclipse.xtext.xbase.idea.lang.XtypeLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class XtypeExtensionFactory implements ExtensionFactory {

	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return XtypeLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
