package org.eclipse.xtend.core.idea;

import org.eclipse.xtend.core.idea.lang.XtendLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class XtendExtensionFactory implements ExtensionFactory {

	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return XtendLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
