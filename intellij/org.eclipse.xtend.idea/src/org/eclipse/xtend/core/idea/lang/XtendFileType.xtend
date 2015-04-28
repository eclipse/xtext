package org.eclipse.xtend.core.idea.lang;

import org.eclipse.xtend.core.idea.icons.XtendIcons

class XtendFileType extends AbstractXtendFileType {

	public static val INSTANCE = new XtendFileType()
	
	new() {
		super(XtendLanguage.INSTANCE)
	}
	
	override getIcon() {
		XtendIcons.Xtend_FILETYPE
	}

}
