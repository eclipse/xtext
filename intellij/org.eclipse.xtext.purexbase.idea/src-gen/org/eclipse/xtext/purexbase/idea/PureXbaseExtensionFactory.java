package org.eclipse.xtext.purexbase.idea;

import org.eclipse.xtext.purexbase.idea.lang.PureXbaseLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class PureXbaseExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return PureXbaseLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
