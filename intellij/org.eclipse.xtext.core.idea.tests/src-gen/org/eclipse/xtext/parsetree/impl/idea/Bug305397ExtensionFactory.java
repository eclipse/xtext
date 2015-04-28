package org.eclipse.xtext.parsetree.impl.idea;

import org.eclipse.xtext.parsetree.impl.idea.lang.Bug305397Language;

import com.intellij.openapi.extensions.ExtensionFactory;

public class Bug305397ExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return Bug305397Language.INSTANCE.<Object> getInstance(clazz);
	}

}
