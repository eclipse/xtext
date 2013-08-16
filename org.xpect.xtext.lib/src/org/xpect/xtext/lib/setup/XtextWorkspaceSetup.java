/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.setup;

import java.io.IOException;
import java.util.EnumSet;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.IGrammarAccess;
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
import org.xpect.xtext.lib.setup.workspace.JavaProject;
import org.xpect.xtext.lib.setup.workspace.Project;
import org.xpect.xtext.lib.setup.workspace.SrcFolder;
import org.xpect.xtext.lib.setup.workspace.Workspace;
import org.xpect.xtext.lib.util.GrammarAnalyzer;

import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtextWorkspaceSetup extends AbstractXtextSetup<ClassCtx, FileCtx, TestCtx, Config> {

	public static abstract class AbstractDefaults implements ISetupInitializer<Config> {

		protected final ISetupInitializer<Config> delegate;

		public AbstractDefaults(ISetupInitializer<Config> delegate) {
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

	}

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

	public static class GenericDefaults extends AbstractDefaults {

		public GenericDefaults(ISetupInitializer<Config> delegate) {
			super(delegate);
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

	public static class JavaDefaults extends AbstractDefaults {

		public JavaDefaults(ISetupInitializer<Config> delegate) {
			super(delegate);
		}

		public void initialize(Config config) {
			delegate.initialize(config);
			if (config.getWorkspace() == null)
				config.add(new Workspace());
			Workspace workspace = config.getWorkspace();
			if (workspace.getMember(JavaProject.class) == null)
				workspace.add(new JavaProject("default_java_project"));
			JavaProject javaProject = workspace.getMember(JavaProject.class);
			initialize(config, workspace, javaProject);
		}

		protected void initialize(Config config, Workspace workspace, JavaProject javaProject) {
			if (javaProject.getMember(SrcFolder.class) == null)
				javaProject.add(new SrcFolder("src"));
			SrcFolder srcFolder = javaProject.getMember(SrcFolder.class);
			for (GenericResource res : config.getGenericResources())
				srcFolder.add(convert(res));
			if (workspace.getThisFile() == null)
				srcFolder.add(new org.xpect.xtext.lib.setup.workspace.ThisFile());
		}
	}

	protected static class TestCtx extends FileCtx {
		public TestCtx(Config workspaceConfig) {
			super(workspaceConfig);
		}
	}

	public static class XbaseDefaults extends JavaDefaults {

		public static final Path XTEND_LIBRARY_PATH = new Path("org.eclipse.xtend.XTEND_CONTAINER");

		public XbaseDefaults(ISetupInitializer<Config> delegate) {
			super(delegate);
		}

		@Override
		protected void initialize(Config config, Workspace workspace, JavaProject javaProject) {
			javaProject.addClasspathEntry(JavaCore.newContainerEntry(XTEND_LIBRARY_PATH));
			super.initialize(config, workspace, javaProject);
		}
	}

	@Override
	public void afterFile(IFileSetupContext frameworkCtx, FileCtx userCtx) throws Exception {
		if (userCtx != null && userCtx.workspaceConfig != null && userCtx.workspaceConfig.getWorkspace() != null)
			userCtx.workspaceConfig.getWorkspace().cleanWorkspace();
	}

	@Override
	public ClassCtx beforeClass(IClassSetupContext frameworkCtx) throws Exception {
		return new ClassCtx();
	}

	@Override
	public FileCtx beforeFile(IFileSetupContext frameworkCtx, ClassCtx ctx2, ISetupInitializer<Config> init) throws Exception {
		Config config = new Config();
		getDefaults(frameworkCtx, init).initialize(config);
		config.getWorkspace().cleanWorkspace();
		config.getWorkspace().configureWorkspace(frameworkCtx);
		config.getWorkspace().waitForAutoBuild();
		// System.out.println(new IResourceFormatter().formatWorkspace());
		Resource resource = loadThisResource(frameworkCtx);
		config.getValidate().validate(resource);
		return new FileCtx(config);
	}

	@Override
	public TestCtx beforeTest(ITestSetupContext frameworkCtx, FileCtx userCtx) throws Exception {
		Resource resource = loadThisResource(frameworkCtx);
		installResourceParameterValues(frameworkCtx, (XtextResource) resource);
		frameworkCtx.getInjector().injectMembers(frameworkCtx.getTestInstance());
		return new TestCtx(userCtx.workspaceConfig);
	}

	protected ISetupInitializer<Config> getDefaults(IFileSetupContext frameworkCtx, ISetupInitializer<Config> init) {
		GrammarAnalyzer ga = new GrammarAnalyzer(frameworkCtx.getInjector().getInstance(IGrammarAccess.class).getGrammar());
		switch (ga.getLanguageKind()) {
		case XBASE:
			return new XbaseDefaults(init);
		case JAVA:
			return new JavaDefaults(init);
		default:
			return new GenericDefaults(init);
		}
	}

	public EnumSet<Environment> getEnvironments() {
		return EnumSet.of(Environment.PLUGIN_TEST);
	}

	private Resource loadThisResource(IFileSetupContext frameworkCtx) throws IOException, CoreException {
		Injector injector = frameworkCtx.getInjector();
		IFile file = frameworkCtx.getParameterValue(ThisFile.class, IFile.class);
		IProject project = frameworkCtx.getParameterValue(ThisProject.class, IProject.class);
		ResourceSet resourceSet = injector.getInstance(IResourceSetProvider.class).get(project);
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		Resource resource = frameworkCtx.load(resourceSet, uri, file.getContents());
		return resource;
	}
}
