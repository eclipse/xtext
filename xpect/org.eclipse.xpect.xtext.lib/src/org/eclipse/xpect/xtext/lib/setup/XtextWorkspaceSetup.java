package org.eclipse.xpect.xtext.lib.setup;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xpect.Environment;
import org.eclipse.xpect.XpectImport;
import org.eclipse.xpect.XpectRequiredEnvironment;
import org.eclipse.xpect.setup.XpectSetupFactory;
import org.eclipse.xpect.state.Creates;
import org.eclipse.xpect.state.Invalidates;
import org.eclipse.xpect.xtext.lib.setup.workspace.Workspace;
import org.eclipse.xpect.xtext.lib.setup.workspace.Workspace.Instance;
import org.eclipse.xpect.xtext.lib.setup.workspace.WorkspaceDefaultsSetup;
import org.eclipse.xpect.xtext.lib.util.XtextOffsetAdapter;
import org.eclipse.xpect.xtext.lib.util.XtextTargetSyntaxSupport;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;
import com.google.inject.Injector;

@XpectSetupFactory
@XpectRequiredEnvironment(Environment.PLUGIN_TEST)
@XpectImport({ WorkspaceDefaultsSetup.class, XtextTargetSyntaxSupport.class, XtextTestObjectSetup.class, InjectorSetup.class, XtextValidatingSetup.class, FileSetupContext.class,
		XtextOffsetAdapter.class })
public class XtextWorkspaceSetup {

	private final FileSetupContext ctx;
	private Workspace.Instance workspace;
	private final Workspace workspaceConfig;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	public XtextWorkspaceSetup(FileSetupContext ctx, Workspace workspace, Injector injector) {
		this.ctx = ctx;
		this.workspaceConfig = workspace;
		injector.injectMembers(this);
	}

	@Creates(ThisFile.class)
	public IFile createThisFile() {
		return getInstance().getThisFile();
	}

	@Creates(ThisProject.class)
	public IProject createThisProject() {
		return getInstance().getThisProject();
	}

	@Creates
	public IWorkspace createWorkspace() {
		return getInstance().getWorkspace();
	}

	protected Workspace.Instance getInstance() {
		if (workspace == null) {
			workspaceConfig.cleanWorkspace();
			workspace = workspaceConfig.configureWorkspace(ctx);
			if (workspaceConfig.isAutobuild()) {
				workspaceConfig.waitForAutoBuild();
			} else {
				workspaceConfig.buildIncrementally();
			}
			// System.out.println(new IResourceFormatter().formatWorkspace());
		}
		return workspace;
	}

	public void invalidate() {
		workspaceConfig.cleanWorkspace();
		this.workspace = null;
	}

	@Invalidates
	public void invalidateWorkspace(IWorkspace workspace) {
		invalidate();
	}

	@Creates(ThisResource.class)
	public XtextResource createThisResource() throws IOException, CoreException {
		Instance instance = getInstance();
		IFile file = instance.getThisFile();
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		ResourceSet resourceSet = resourceSetProvider.get(instance.getThisProject());
		XtextResource resource = (XtextResource) ctx.load(resourceSet, uri, file.getContents());
		return resource;
	}

}
