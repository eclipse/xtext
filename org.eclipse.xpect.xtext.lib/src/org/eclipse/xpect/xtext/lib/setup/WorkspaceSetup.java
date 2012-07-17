package org.eclipse.xpect.xtext.lib.setup;

import org.eclipse.xpect.setup.AbstractXpectSetup;
import org.eclipse.xpect.xtext.lib.setup.XtextSetup.ClassCtx;
import org.eclipse.xpect.xtext.lib.setup.XtextSetup.FileCtx;
import org.eclipse.xpect.xtext.lib.setup.XtextSetup.TestCtx;

public class WorkspaceSetup extends AbstractXpectSetup<ClassCtx, FileCtx, TestCtx> {
	protected static class ClassCtx {
	}

	protected static class FileCtx extends ClassCtx {
	}

	protected static class TestCtx extends FileCtx {
	}
}
