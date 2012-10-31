package org.xpect.xtext.lib.setup;

import org.xpect.setup.AbstractXpectSetup;
import org.xpect.setup.IXpectSetup;
import org.xpect.xtext.lib.setup.XtextSetup.ClassCtx;
import org.xpect.xtext.lib.setup.XtextSetup.TestCtx;

public class XtextSetup extends AbstractXpectSetup<ClassCtx, FileCtx, TestCtx, Object> {

	protected static class ClassCtx {
	}

	protected static class FileCtx extends ClassCtx {
	}

	protected static class TestCtx extends FileCtx {
	}

	public void add(IXpectSetup<?, ?, ?, ?> delegate) {

	}

}
