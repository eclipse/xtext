package org.eclipse.xpect.xtext.lib.setup;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xpect.XpectFile;
import org.eclipse.xpect.registry.ILanguageInfo;
import org.eclipse.xpect.setup.AbstractXpectSetup;
import org.eclipse.xpect.setup.ISetupInitializer;
import org.eclipse.xpect.setup.XtextInjectorSetup;
import org.eclipse.xpect.util.TypedProvider;
import org.eclipse.xpect.xtext.lib.setup.ThisOffset.ThisOffsetProvider;
import org.eclipse.xpect.xtext.lib.setup.XtextStandaloneSetup.ClassCtx;
import org.eclipse.xpect.xtext.lib.setup.XtextStandaloneSetup.TestCtx;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.util.JavaReflectAccess;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;
import com.google.inject.Module;

@SuppressWarnings("restriction")
public class XtextStandaloneSetup extends AbstractXpectSetup<ClassCtx, FileCtx, TestCtx, FileCtx> {

	protected static class ClassCtx {
	}

	protected static class TestCtx extends FileCtx {
	}

	@Override
	public ClassCtx beforeClass(IClassSetupContext frameworkCtx) {
		return new ClassCtx();
	}

	protected Class<? extends Module> getTestModule(XpectFile file) {
		JvmDeclaredType testClass = file.getTest().getTestClass();
		if (testClass == null)
			return null;
		Class<?> type = new JavaReflectAccess().getRawType(testClass);
		XtextInjectorSetup annotation = type.getAnnotation(XtextInjectorSetup.class);
		if (annotation != null)
			return annotation.standaloneTestModule();
		return null;
	}

	protected Injector getInjector(XpectFile file) {
		String ext = file.eResource().getURI().fileExtension();
		ILanguageInfo info = ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension(ext);
		if (info == null)
			throw new IllegalStateException("No Xtext language configuration found for file extension '" + ext + "'.");
		Class<? extends Module> testModule = getTestModule(file);
		if (testModule != null)
			return info.getInjector(info.getInjector().getInstance(testModule));
		return info.getInjector();
	}

	@Override
	public FileCtx beforeFile(IFileSetupContext frameworkCtx, ClassCtx userCtx, ISetupInitializer<FileCtx> initializer) throws IOException {
		FileCtx ctx = new FileCtx();
		initializer.initialize(ctx);
		Injector injector = getInjector(frameworkCtx.getXpectFile());
		Resource resource = loadThisResource(injector, frameworkCtx, ctx);
		validate(ctx, resource);
		return ctx;
	}

	protected void validate(FileCtx ctx, Resource resource) {
		ctx.getValidate().validate(resource);
	}

	@Override
	public TestCtx beforeTest(ITestSetupContext frameworkCtx, FileCtx userCtx) throws IOException {
		Injector injector = getInjector(frameworkCtx.getXpectFile());
		injector.injectMembers(frameworkCtx.getTestInstance());
		XtextResource res = loadThisResource(injector, frameworkCtx, userCtx);
		frameworkCtx.installParameterAdapter(new XtextOffsetAdapter(res));
		frameworkCtx.installParameterValue(ThisResource.class, new TypedProvider(res));
		frameworkCtx.installParameterValue(ThisOffset.class, new ThisOffsetProvider(frameworkCtx.getXpectInvocation(), res));
		if (!res.getContents().isEmpty())
			frameworkCtx.installParameterValue(ThisModel.class, new TypedProvider(res.getContents().get(0)));
		return null;
	}

	public XtextResource loadThisResource(Injector injector, IFileSetupContext frameworkCtx, FileCtx userCtx) throws IOException {
		org.eclipse.emf.ecore.resource.ResourceSet resourceSet = injector.getInstance(org.eclipse.emf.ecore.resource.ResourceSet.class);
		if (resourceSet instanceof XtextResourceSet) {
			((XtextResourceSet) resourceSet).setClasspathURIContext(frameworkCtx.getTestClass());
		}
		if (userCtx.getResourceSet() != null) {
			Resource result = null;
			for (ISetupFile file : userCtx.getResourceSet().getFiles()) {
				Resource res = injector.getInstance(IResourceFactory.class).createResource(file.getURI(frameworkCtx));
				resourceSet.getResources().add(res);
				res.load(file.createInputStream(frameworkCtx), null);
				if (file instanceof ThisFile)
					result = res;
			}
			return (XtextResource) result;
		} else {
			URI thisURI = frameworkCtx.getXpectFile().eResource().getURI();
			Resource res = injector.getInstance(IResourceFactory.class).createResource(thisURI);
			resourceSet.getResources().add(res);
			res.load(resourceSet.getURIConverter().createInputStream(thisURI), null);
			return (XtextResource) res;
		}
	}

}
