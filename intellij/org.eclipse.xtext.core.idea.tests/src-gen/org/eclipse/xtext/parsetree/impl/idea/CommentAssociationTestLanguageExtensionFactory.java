package org.eclipse.xtext.parsetree.impl.idea;

import org.eclipse.xtext.parsetree.impl.idea.lang.CommentAssociationTestLanguageLanguage;

import com.intellij.openapi.extensions.ExtensionFactory;

public class CommentAssociationTestLanguageExtensionFactory implements ExtensionFactory {

	@Override
	public Object createInstance(final String factoryArgument, final String implementationClass) {
		Class<?> clazz;
		try {
			clazz = Class.forName(implementationClass);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Couldn't load "+implementationClass, e);
		}
		return CommentAssociationTestLanguageLanguage.INSTANCE.<Object> getInstance(clazz);
	}

}
