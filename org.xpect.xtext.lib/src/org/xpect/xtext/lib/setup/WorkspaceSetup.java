package org.xpect.xtext.lib.setup;

import org.xpect.setup.AbstractXpectSetup;
import org.xpect.xtext.lib.setup.WorkspaceSetup.ClassCtx;
import org.xpect.xtext.lib.setup.WorkspaceSetup.TestCtx;

public class WorkspaceSetup extends AbstractXpectSetup<ClassCtx, FileCtx, TestCtx, Object> {
	protected static class ClassCtx {
	}

	protected static class FileCtx extends ClassCtx {
	}

	protected static class TestCtx extends FileCtx {
	}
}
