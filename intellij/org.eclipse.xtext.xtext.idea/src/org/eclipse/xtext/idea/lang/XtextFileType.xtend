package org.eclipse.xtext.idea.lang;

class XtextFileType extends AbstractXtextFileType {

	public static final XtextFileType INSTANCE = new XtextFileType()

	new() {
		super(XtextLanguage.INSTANCE)
	}

}
