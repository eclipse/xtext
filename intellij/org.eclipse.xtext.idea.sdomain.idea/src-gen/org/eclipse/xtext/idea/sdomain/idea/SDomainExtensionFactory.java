package org.eclipse.xtext.idea.sdomain.idea;

import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class SDomainExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return SDomainLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
