package org.eclipse.xtext.serializer.idea;

import org.eclipse.xtext.serializer.idea.lang.SequencerTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class SequencerTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return SequencerTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
