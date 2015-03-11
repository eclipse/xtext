package org.eclipse.xtend.core.idea.ide.hierarchy.call;

import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtext.xbase.idea.ide.hierarchy.JvmExecutableCallReferenceProcessor;

public class XtendCallReferenceProcessor extends JvmExecutableCallReferenceProcessor {

	public XtendCallReferenceProcessor() {
		super(XtendLanguage.INSTANCE);
	}

}
