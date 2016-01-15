package org.xpect.xtext.lib.setup;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.xpect.Environment;
import org.xpect.XpectImport;
import org.xpect.XpectRequiredEnvironment;
import org.xpect.setup.ThisRootTestClass;
import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;
import org.xpect.xtext.lib.setup.emf.ResourceFactory;
import org.xpect.xtext.lib.util.XtextOffsetAdapter;
import org.xpect.xtext.lib.util.XtextTargetSyntaxSupport;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

@XpectSetupFactory
@XpectRequiredEnvironment(Environment.STANDALONE_TEST)
@XpectImport({ XtextTargetSyntaxSupport.class, XtextTestObjectSetup.class, InjectorSetup.class, XtextValidatingSetup.class, org.xpect.xtext.lib.setup.emf.ResourceSet.class,
		FileSetupContext.class, XtextOffsetAdapter.class })
public class XtextStandaloneSetup {

	private final FileSetupContext ctx;
	private final org.xpect.xtext.lib.setup.emf.ResourceSet resourceSetConfig;

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	public XtextStandaloneSetup(FileSetupContext ctx, org.xpect.xtext.lib.setup.emf.ResourceSet resourceSet, Injector injector) {
		super();
		this.resourceSetConfig = resourceSet;
		this.ctx = ctx;
		JvmModelInferrerRegistryFix.apply();
		injector.injectMembers(this);
	}

	@Creates(ThisResource.class)
	public XtextResource createThisResource() throws IOException {
		ResourceSet resourceSet = resourceSetProvider.get();
		if (resourceSet instanceof XtextResourceSet)
			((XtextResourceSet) resourceSet).setClasspathURIContext(ctx.get(Class.class, ThisRootTestClass.class));
		Resource result = null;
		for (ResourceFactory file : resourceSetConfig.getFactories()) {
			Resource res = file.create(ctx, resourceSet);
			if (file instanceof org.xpect.xtext.lib.setup.emf.ThisResource)
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
