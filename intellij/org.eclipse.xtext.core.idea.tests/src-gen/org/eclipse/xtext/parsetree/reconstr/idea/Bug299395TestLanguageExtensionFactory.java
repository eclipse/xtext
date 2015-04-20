package org.eclipse.xtext.parsetree.reconstr.idea;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug299395TestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class Bug299395TestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return Bug299395TestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
