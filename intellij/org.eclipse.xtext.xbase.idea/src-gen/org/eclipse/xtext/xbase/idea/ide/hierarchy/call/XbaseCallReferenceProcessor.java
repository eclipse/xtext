package org.eclipse.xtext.xbase.idea.ide.hierarchy.call;

import org.eclipse.xtext.xbase.idea.ide.hierarchy.JvmExecutableCallReferenceProcessor;
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;

public class XbaseCallReferenceProcessor extends JvmExecutableCallReferenceProcessor {

	public XbaseCallReferenceProcessor() {
		super(XbaseLanguage.INSTANCE);
	}

}
