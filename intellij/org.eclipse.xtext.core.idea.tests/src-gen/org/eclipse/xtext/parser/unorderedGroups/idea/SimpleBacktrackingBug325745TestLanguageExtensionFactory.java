package org.eclipse.xtext.parser.unorderedGroups.idea;

import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class SimpleBacktrackingBug325745TestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
