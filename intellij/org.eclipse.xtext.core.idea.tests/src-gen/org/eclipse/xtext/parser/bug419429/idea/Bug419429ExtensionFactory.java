package org.eclipse.xtext.parser.bug419429.idea;

import org.eclipse.xtext.parser.bug419429.idea.lang.Bug419429Language;

import com.intellij.openapi.extensions.ExtensionFactory;

public class Bug419429ExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return Bug419429Language.INSTANCE.<Object> getInstance(clazz);
	}

}
