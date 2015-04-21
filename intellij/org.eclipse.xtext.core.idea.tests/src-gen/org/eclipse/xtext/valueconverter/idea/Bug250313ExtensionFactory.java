package org.eclipse.xtext.valueconverter.idea;

import org.eclipse.xtext.valueconverter.idea.lang.Bug250313Language;

import com.intellij.openapi.extensions.ExtensionFactory;

public class Bug250313ExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return Bug250313Language.INSTANCE.<Object> getInstance(clazz);
	}

}
