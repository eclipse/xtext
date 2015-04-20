package org.eclipse.xtext.parser.unorderedGroups.idea;

import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExUnorderedGroupsTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class ExUnorderedGroupsTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return ExUnorderedGroupsTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
