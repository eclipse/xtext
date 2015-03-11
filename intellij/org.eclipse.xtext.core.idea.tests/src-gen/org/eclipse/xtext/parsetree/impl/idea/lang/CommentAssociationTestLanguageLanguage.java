package org.eclipse.xtext.parsetree.impl.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

import com.google.inject.Injector;

public final class CommentAssociationTestLanguageLanguage extends AbstractXtextLanguage {

	public static final CommentAssociationTestLanguageLanguage INSTANCE = new CommentAssociationTestLanguageLanguage();

	private Injector injector;

	private CommentAssociationTestLanguageLanguage() {
		super("org.eclipse.xtext.parsetree.impl.CommentAssociationTestLanguage");
		this.injector = new org.eclipse.xtext.parsetree.impl.idea.CommentAssociationTestLanguageStandaloneSetupIdea().createInjectorAndDoEMFRegistration();
		
	}

	@Override
	protected Injector getInjector() {
		return injector;
	}
}
