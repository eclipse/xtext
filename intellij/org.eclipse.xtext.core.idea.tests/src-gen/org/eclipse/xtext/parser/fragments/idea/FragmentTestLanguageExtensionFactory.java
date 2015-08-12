package org.eclipse.xtext.parser.fragments.idea;

import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class FragmentTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return FragmentTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
