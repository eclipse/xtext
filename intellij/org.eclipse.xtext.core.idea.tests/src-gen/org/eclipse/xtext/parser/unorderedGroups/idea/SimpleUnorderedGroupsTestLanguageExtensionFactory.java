package org.eclipse.xtext.parser.unorderedGroups.idea;

import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleUnorderedGroupsTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class SimpleUnorderedGroupsTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return SimpleUnorderedGroupsTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
