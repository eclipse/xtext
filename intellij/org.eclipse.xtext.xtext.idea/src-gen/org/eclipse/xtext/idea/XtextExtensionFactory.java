package org.eclipse.xtext.idea;

import org.eclipse.xtext.idea.lang.XtextLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class XtextExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return XtextLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
