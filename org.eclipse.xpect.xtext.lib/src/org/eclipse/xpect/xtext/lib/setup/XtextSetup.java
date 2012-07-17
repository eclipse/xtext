package org.eclipse.xpect.xtext.lib.setup;

import org.eclipse.xpect.setup.AbstractXpectSetup;
import org.eclipse.xpect.setup.IGuiceModuleProvider;
import org.eclipse.xpect.setup.IXpectSetup;
import org.eclipse.xpect.xtext.lib.setup.XtextSetup.ClassCtx;
import org.eclipse.xpect.xtext.lib.setup.XtextSetup.FileCtx;
import org.eclipse.xpect.xtext.lib.setup.XtextSetup.TestCtx;

public class XtextSetup extends AbstractXpectSetup<ClassCtx, FileCtx, TestCtx> {

	private IGuiceModuleProvider moduleProvider;

	protected static class ClassCtx {
	}

	protected static class FileCtx extends ClassCtx {
	}

	protected static class TestCtx extends FileCtx {
	}

	public IGuiceModuleProvider getModuleProvider() {
		return moduleProvider;
	}

	public void setModuleProvider(IGuiceModuleProvider moduleProvider) {
		this.moduleProvider = moduleProvider;
	}

	public void add(IXpectSetup<?, ?, ?> delegate) {

	}

}
