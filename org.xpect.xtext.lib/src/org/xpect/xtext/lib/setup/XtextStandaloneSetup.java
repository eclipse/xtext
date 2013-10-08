package org.xpect.xtext.lib.setup;

import java.io.IOException;

import java.util.EnumSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.xpect.Environment;
import org.xpect.parameter.XpectParameterAdapter;
import org.xpect.setup.ISetupInitializer;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup.ClassCtx;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup.Config;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup.TestCtx;
import org.xpect.xtext.lib.setup.XtextWorkspaceSetup.FileCtx;
import org.xpect.xtext.lib.setup.emf.File;
import org.xpect.setup.ThisTestClass;
import org.xpect.setup.ThisRootTestClass;
import org.xpect.setup.XpectSetup;
import org.xpect.state.Creates;
import org.xpect.state.Precondition;
import org.xpect.util.EnvironmentUtil;
import org.xpect.xtext.lib.setup.emf.ResourceFactory;
import org.xpect.xtext.lib.util.XtextOffsetAdapter;
import org.xpect.xtext.lib.util.XtextTargetSyntaxSupport;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

@SuppressWarnings("restriction")
@XpectParameterAdapter(XtextOffsetAdapter.class)
@XpectSetup({ XtextTargetSyntaxSupport.class, XtextTestObjectSetup.class, InjectorSetup.class, XtextValidatingSetup.class })
public class XtextStandaloneSetup {

	@Precondition
	public static void checkApplicable() {
		EnvironmentUtil.requireEnvironment(Environment.STANDALONE_TEST);
	}

	private final FileSetupContext ctx;
	private final org.xpect.xtext.lib.setup.emf.ResourceSet resourceSetConfig;

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	public XtextStandaloneSetup(FileSetupContext ctx, org.xpect.xtext.lib.setup.emf.ResourceSet resourceSet, Injector injector) {
		super();
		this.resourceSetConfig = resourceSet;
		this.ctx = ctx;
		JvmModelInferrerRegistry.INSTANCE.setUseRegistry(false);
		injector.injectMembers(this);
	}

	@Override
	public Config beforeFile(IFileSetupContext frameworkCtx, ClassCtx userCtx, ISetupInitializer<Config> initializer) throws Exception {
		Config ctx = new Config();
		new Defaults(initializer).initialize(ctx);
		Resource resource = loadThisResource(frameworkCtx.getInjector(), frameworkCtx, ctx);
		ctx.getValidate().validate(resource);
		return ctx;
	}

	@Override
	public TestCtx beforeTest(ITestSetupContext frameworkCtx, Config userCtx) throws Exception {
		Injector injector = frameworkCtx.getInjector();
		injector.injectMembers(frameworkCtx.getTestInstance());
		XtextResource res = loadThisResource(injector, frameworkCtx, userCtx);
		installResourceParameterValues(frameworkCtx, res);
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

	public EnumSet<Environment> getEnvironments() {
		return EnumSet.of(Environment.STANDALONE_TEST);
	}

	public XtextResource loadThisResource(Injector injector, IFileSetupContext frameworkCtx, Config config) throws Exception {
		ResourceSet resourceSet = injector.getInstance(ResourceSet.class);
	}
	
	@Creates(ThisResource.class)
	public XtextResource createThisResource() throws IOException {
		ResourceSet resourceSet = resourceSetProvider.get();
		if (resourceSet instanceof XtextResourceSet)
			((XtextResourceSet) resourceSet).setClasspathURIContext(ctx.get(Class.class, ThisRootTestClass.class));
		Resource result = null;
		for (ResourceFactory file : resourceSetConfig.getFactories()) {
			Resource res = file.create(ctx, resourceSet);
			if (file instanceof org.xpect.xtext.lib.setup.emf.ThisFile)
				result = res;
		}
		return (XtextResource) result;
	}

	protected org.xpect.xtext.lib.setup.emf.ResourceSet getResourceSetConfig() {
		return resourceSetConfig;
	}

	protected FileSetupContext getSetupContext() {
		return ctx;
	}


}
