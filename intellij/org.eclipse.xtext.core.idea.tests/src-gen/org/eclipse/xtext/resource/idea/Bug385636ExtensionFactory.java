package org.eclipse.xtext.resource.idea;

import org.eclipse.xtext.resource.idea.lang.Bug385636Language;

import com.intellij.openapi.extensions.ExtensionFactory;

public class Bug385636ExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return Bug385636Language.INSTANCE.<Object> getInstance(clazz);
	}

}
