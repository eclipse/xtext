package org.eclipse.xtext.grammarinheritance.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class ConcreteTestLanguageLanguage extends AbstractXtextLanguage {

	public static final ConcreteTestLanguageLanguage INSTANCE = new ConcreteTestLanguageLanguage();

	private ConcreteTestLanguageLanguage() {
		super("org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage");
	}

}
