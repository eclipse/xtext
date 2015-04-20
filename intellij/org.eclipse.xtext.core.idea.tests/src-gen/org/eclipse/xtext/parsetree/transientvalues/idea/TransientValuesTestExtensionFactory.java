package org.eclipse.xtext.parsetree.transientvalues.idea;

import org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class TransientValuesTestExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return TransientValuesTestLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
