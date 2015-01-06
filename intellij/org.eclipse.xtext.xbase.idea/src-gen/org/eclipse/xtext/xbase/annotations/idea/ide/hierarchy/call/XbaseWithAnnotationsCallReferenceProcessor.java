package org.eclipse.xtext.xbase.annotations.idea.ide.hierarchy.call;

import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage;
import org.eclipse.xtext.xbase.idea.ide.hierarchy.JvmExecutableCallReferenceProcessor;

public class XbaseWithAnnotationsCallReferenceProcessor extends JvmExecutableCallReferenceProcessor {

	public XbaseWithAnnotationsCallReferenceProcessor() {
		super(XbaseWithAnnotationsLanguage.INSTANCE);
	}

}
