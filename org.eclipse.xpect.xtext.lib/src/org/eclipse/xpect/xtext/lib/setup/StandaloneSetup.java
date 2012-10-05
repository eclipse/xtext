package org.eclipse.xpect.xtext.lib.setup;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xpect.setup.AbstractXpectSetup;
import org.eclipse.xpect.util.TypedProvider;
import org.eclipse.xpect.xtext.lib.setup.StandaloneSetup.ClassCtx;
import org.eclipse.xpect.xtext.lib.setup.StandaloneSetup.FileCtx;
import org.eclipse.xpect.xtext.lib.setup.StandaloneSetup.TestCtx;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

public class StandaloneSetup extends AbstractXpectSetup<ClassCtx, FileCtx, TestCtx> {

	protected static class ClassCtx {
	}

	protected static class FileCtx extends ClassCtx {
	}

	protected static class TestCtx extends FileCtx {
	}

	private Injector injector;

	public void installInjector(Injector injector) {
		this.injector = injector;
	}

	private ResourceSet resourceSet;

	public void add(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	@Override
	public TestCtx beforeTest(ITestSetupContext frameworkCtx, FileCtx userCtx) throws IOException {
		org.eclipse.emf.ecore.resource.ResourceSet resourceSet = injector.getInstance(org.eclipse.emf.ecore.resource.ResourceSet.class);
		if (resourceSet instanceof XtextResourceSet) {
			((XtextResourceSet) resourceSet).setClasspathURIContext(frameworkCtx.getTestClass());
		}
		if (this.resourceSet != null)
			for (ISetupFile file : this.resourceSet.getFiles()) {
				Resource res = resourceSet.getResource(file.getURI(frameworkCtx), false);
				res.load(file.createInputStream(frameworkCtx), null);
				if (file instanceof ThisFile) {
					EcoreUtil.resolveAll(res);
					frameworkCtx.installParameterValue(ThisResource.class, new TypedProvider(res));
					if (!res.getContents().isEmpty())
						frameworkCtx.installParameterValue(ThisModel.class, new TypedProvider(res.getContents().get(0)));
				}
			}
		return null;
	}

}
