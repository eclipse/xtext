package org.eclipse.xpect.xtext.lib.setup;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xpect.setup.AbstractXpectSetup;
import org.eclipse.xpect.setup.ISetupInitializer;
import org.eclipse.xpect.util.TypedProvider;
import org.eclipse.xpect.xtext.lib.setup.XtextStandaloneSetup.ClassCtx;
import org.eclipse.xpect.xtext.lib.setup.XtextStandaloneSetup.TestCtx;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class XtextStandaloneSetup extends AbstractXpectSetup<ClassCtx, FileCtx, TestCtx, FileCtx> {

	protected static class ClassCtx {
	}

	protected static class TestCtx extends FileCtx {
	}

	@Override
	public ClassCtx beforeClass(IClassSetupContext frameworkCtx) {
		return new ClassCtx();
	}

	@Override
	public FileCtx beforeFile(IFileSetupContext frameworkCtx, ClassCtx userCtx, ISetupInitializer<FileCtx> initializer) {
		FileCtx ctx = new FileCtx();
		initializer.initialize(ctx);
		return ctx;
	}

	@Override
	public TestCtx beforeTest(ITestSetupContext frameworkCtx, FileCtx userCtx) throws IOException {
		Injector injector = Guice.createInjector(userCtx.getModuleProvider().getRuntimeModule());
		org.eclipse.emf.ecore.resource.ResourceSet resourceSet = injector.getInstance(org.eclipse.emf.ecore.resource.ResourceSet.class);
		if (resourceSet instanceof XtextResourceSet) {
			((XtextResourceSet) resourceSet).setClasspathURIContext(frameworkCtx.getTestClass());
		}
		if (userCtx.getResourceSet() != null)
			for (ISetupFile file : userCtx.getResourceSet().getFiles()) {
				Resource res = injector.getInstance(IResourceFactory.class).createResource(file.getURI(frameworkCtx));
				resourceSet.getResources().add(res);
				res.load(file.createInputStream(frameworkCtx), null);
				if (file instanceof ThisFile) {
//					EcoreUtil.resolveAll(res);
					frameworkCtx.installParameterValue(ThisResource.class, new TypedProvider(res));
					if (!res.getContents().isEmpty())
						frameworkCtx.installParameterValue(ThisModel.class, new TypedProvider(res.getContents().get(0)));
				}
			}
		return null;
	}

}
