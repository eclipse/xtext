/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.setup;

import java.util.EnumSet;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.xpect.Environment;
import org.xpect.setup.ISetupInitializer;
import org.xpect.xtext.lib.setup.XtextWorkspaceSetup.ClassCtx;
import org.xpect.xtext.lib.setup.XtextWorkspaceSetup.Config;
import org.xpect.xtext.lib.setup.XtextWorkspaceSetup.FileCtx;
import org.xpect.xtext.lib.setup.XtextWorkspaceSetup.TestCtx;
import org.xpect.xtext.lib.setup.generic.GenericResource;
import org.xpect.xtext.lib.setup.workspace.File;
import org.xpect.xtext.lib.setup.workspace.IResourceFactory;
import org.xpect.xtext.lib.setup.workspace.Project;
import org.xpect.xtext.lib.setup.workspace.Workspace;

import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtextWorkspaceSetup extends AbstractXtextSetup<ClassCtx, FileCtx, TestCtx, Config> {

	protected static class ClassCtx {
	}

	public static class Config extends AbstractXtextSetup.AbstractConfig {
		private Workspace workspace;

		public void add(Workspace workspace) {
			if (this.workspace != null)
				throw new IllegalStateException("Only one workspace per setup is supported.");
			this.workspace = workspace;
		}

		public Workspace getWorkspace() {
			return this.workspace;
		}

	}

	public static class Defaults implements ISetupInitializer<Config> {

		private final ISetupInitializer<Config> delegate;

		public Defaults(ISetupInitializer<Config> delegate) {
			super();
			this.delegate = delegate;
		}

		protected IResourceFactory<IFile, IContainer> convert(GenericResource res) {
			if (res instanceof org.xpect.xtext.lib.setup.generic.File)
				return new File((org.xpect.xtext.lib.setup.generic.File) res);
			else if (res instanceof org.xpect.xtext.lib.setup.generic.ThisFile)
				return new org.xpect.xtext.lib.setup.workspace.ThisFile((org.xpect.xtext.lib.setup.generic.ThisFile) res);
			throw new IllegalStateException();
		}

		public void initialize(Config config) {
			delegate.initialize(config);
			if (config.getWorkspace() == null)
				config.add(new Workspace());
			Workspace workspace = config.getWorkspace();
			if (workspace.getDefaultProject() == null)
				workspace.add(new Project("default_project"));
			Project defaultProject = workspace.getDefaultProject();
			for (GenericResource res : config.getGenericResources())
				defaultProject.add(convert(res));
			if (workspace.getThisFile() == null)
				defaultProject.add(new org.xpect.xtext.lib.setup.workspace.ThisFile());
		}
	}

	protected static class FileCtx extends ClassCtx {
		protected final Config workspaceConfig;

		public FileCtx(Config workspaceConfig) {
			super();
			this.workspaceConfig = workspaceConfig;
		}

		public Config getWorkspaceConfig() {
			return workspaceConfig;
		}
	}

	protected static class TestCtx extends FileCtx {
		public TestCtx(Config workspaceConfig) {
			super(workspaceConfig);
		}
	}

	@Override
	public void afterFile(IFileSetupContext frameworkCtx, FileCtx userCtx) throws Exception {
		userCtx.workspaceConfig.getWorkspace().cleanWorkspace();
	}

	@Override
	public ClassCtx beforeClass(IClassSetupContext frameworkCtx) throws Exception {
		return new ClassCtx();
	}

	@Override
	public FileCtx beforeFile(IFileSetupContext ctx1, ClassCtx ctx2, ISetupInitializer<Config> init) throws Exception {
		Config config = new Config();
		new Defaults(init).initialize(config);
		config.getWorkspace().cleanWorkspace();
		config.getWorkspace().configureWorkspace(ctx1);
		config.getWorkspace().waitForAutoBuild();
		return new FileCtx(config);
	}

	@Override
	public TestCtx beforeTest(ITestSetupContext frameworkCtx, FileCtx userCtx) throws Exception {
		Injector injector = frameworkCtx.getInjector();
		IFile file = frameworkCtx.getParameterValue(ThisFile.class, IFile.class);
		IProject project = frameworkCtx.getParameterValue(ThisProject.class, IProject.class);
		ResourceSet resourceSet = injector.getInstance(IResourceSetProvider.class).get(project);
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		Resource resource = frameworkCtx.load(resourceSet, uri, file.getContents());
		installResourceParameterValues(frameworkCtx, (XtextResource) resource);
		injector.injectMembers(frameworkCtx.getTestInstance());
		return new TestCtx(userCtx.workspaceConfig);
	}

	public EnumSet<Environment> getEnvironments() {
		return EnumSet.of(Environment.PLUGIN_TEST);
	}
}
