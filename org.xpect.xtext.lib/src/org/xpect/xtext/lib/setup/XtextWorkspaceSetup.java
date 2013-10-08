package org.xpect.xtext.lib.setup;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.xpect.Environment;
import org.xpect.parameter.XpectParameterAdapter;
import org.xpect.setup.XpectSetup;
import org.xpect.state.Creates;
import org.xpect.state.Invalidates;
import org.xpect.state.Precondition;
import org.xpect.util.EnvironmentUtil;
import org.xpect.xtext.lib.setup.workspace.Workspace;
import org.xpect.xtext.lib.setup.workspace.Workspace.Instance;
import org.xpect.xtext.lib.setup.workspace.WorkspaceDefaultsSetup;
import org.xpect.xtext.lib.util.XtextOffsetAdapter;
import org.xpect.xtext.lib.util.XtextTargetSyntaxSupport;

import com.google.inject.Inject;
import com.google.inject.Injector;

@XpectParameterAdapter(XtextOffsetAdapter.class)
@XpectSetup({ WorkspaceDefaultsSetup.class, XtextTargetSyntaxSupport.class, XtextTestObjectSetup.class, InjectorSetup.class,
		XtextValidatingSetup.class })
public class XtextWorkspaceSetup {

	@Precondition
	public static void checkApplicable() {
		EnvironmentUtil.requireEnvironment(Environment.PLUGIN_TEST);
	}

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
			workspaceConfig.waitForAutoBuild();
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
