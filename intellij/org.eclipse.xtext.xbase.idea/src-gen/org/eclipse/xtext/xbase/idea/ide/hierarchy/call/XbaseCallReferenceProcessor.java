package org.eclipse.xtext.xbase.idea.ide.hierarchy.call;

import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;
import org.eclipse.xtext.xbase.idea.ide.hierarchy.JvmExecutableCallReferenceProcessor;

public class XbaseCallReferenceProcessor extends JvmExecutableCallReferenceProcessor {

	public XbaseCallReferenceProcessor() {
		super(XbaseLanguage.INSTANCE);
	}

}
