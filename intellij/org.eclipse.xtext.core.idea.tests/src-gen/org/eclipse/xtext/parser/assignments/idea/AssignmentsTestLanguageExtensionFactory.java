package org.eclipse.xtext.parser.assignments.idea;

import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class AssignmentsTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return AssignmentsTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
