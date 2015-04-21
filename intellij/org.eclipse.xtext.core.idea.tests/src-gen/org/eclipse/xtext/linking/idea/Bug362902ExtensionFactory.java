package org.eclipse.xtext.linking.idea;

import org.eclipse.xtext.linking.idea.lang.Bug362902Language;

import com.intellij.openapi.extensions.ExtensionFactory;

public class Bug362902ExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return Bug362902Language.INSTANCE.<Object> getInstance(clazz);
	}

}
