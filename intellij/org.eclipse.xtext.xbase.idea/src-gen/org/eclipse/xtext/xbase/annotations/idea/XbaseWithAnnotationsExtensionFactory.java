package org.eclipse.xtext.xbase.annotations.idea;

import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class XbaseWithAnnotationsExtensionFactory implements ExtensionFactory {

	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return XbaseWithAnnotationsLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
