package org.eclipse.xtext.idea.example.entities.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class EntitiesLanguage extends AbstractXtextLanguage {

	public static final EntitiesLanguage INSTANCE = new EntitiesLanguage();

	private EntitiesLanguage() {
		super("org.eclipse.xtext.idea.example.entities.Entities");
	}

}
