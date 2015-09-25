package org.eclipse.xtext.idea.lang;

import org.eclipse.xtext.idea.XtextXtextIcons

class XtextFileType extends AbstractXtextFileType {

	public static final XtextFileType INSTANCE = new XtextFileType()

	new() {
		super(XtextLanguage.INSTANCE)
	}
	
	override getIcon() {
		return XtextXtextIcons.GRAMMAR_FILE_TYPE
	}

}
