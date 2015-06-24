package org.eclipse.xtext.xbase.annotations.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class XbaseWithAnnotationsLanguage extends AbstractXtextLanguage {

	public static final XbaseWithAnnotationsLanguage INSTANCE = new XbaseWithAnnotationsLanguage();

	private XbaseWithAnnotationsLanguage() {
		super("org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations");
	}

}
