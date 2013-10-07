package org.xpect.xtext.lib.setup.workspace;

import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.IGrammarAccess;
import org.xpect.setup.ISetupInitializer;
import org.xpect.setup.XpectSetup;
import org.xpect.state.Creates;
import org.xpect.xtext.lib.setup.InjectorSetup;
import org.xpect.xtext.lib.setup.generic.GenericResource;
import org.xpect.xtext.lib.util.GrammarAnalyzer;

import com.google.common.collect.Lists;
import com.google.inject.Injector;

@XpectSetup({ WorkspaceDefaultsSetup.class, InjectorSetup.class })
public class WorkspaceDefaultsSetup {

	public static final Path XTEND_LIBRARY_PATH = new Path("org.eclipse.xtend.XTEND_CONTAINER");

	private List<GenericResource> genericResources = Lists.newArrayList();

	private Workspace workspace;

	public WorkspaceDefaultsSetup(ISetupInitializer<WorkspaceDefaultsSetup> initializer, Injector injector) {
		super();
		initialize(initializer, injector);
	}

	public void add(GenericResource file) {
		this.genericResources.add(file);
	}

	public void add(Workspace workspace) {
		if (this.workspace != null)
			throw new IllegalStateException("Only one workspace per setup is supported.");
		this.workspace = workspace;
	}

	protected IResourceFactory<IFile, IContainer> convert(GenericResource res) {
		if (res instanceof org.xpect.xtext.lib.setup.generic.File)
			return new File((org.xpect.xtext.lib.setup.generic.File) res);
		else if (res instanceof org.xpect.xtext.lib.setup.generic.ThisFile)
			return new org.xpect.xtext.lib.setup.workspace.ThisFile((org.xpect.xtext.lib.setup.generic.ThisFile) res);
		throw new IllegalStateException();
	}

	protected Workspace createWorkspace() {
		return new Workspace();
	}

	public List<GenericResource> getGenericResources() {
		return genericResources;
	}

	@Creates
	public Workspace getWorkspace() {
		return this.workspace;
	}

	protected void initialize(ISetupInitializer<WorkspaceDefaultsSetup> initializer, Injector injector) {
		initializer.initialize(this);
		if (workspace == null)
			add(createWorkspace());
		GrammarAnalyzer ga = new GrammarAnalyzer(injector.getInstance(IGrammarAccess.class).getGrammar());
		switch (ga.getLanguageKind()) {
		case XBASE:
			initializeXbaseProject();
			break;
		case JAVA:
			initializeJavaProject();
			break;
		default:
			initializeDefaultProject();
			break;
		}
	}

	protected void initializeDefaultProject() {
		if (workspace.getDefaultProject() == null)
			workspace.add(new Project("default_project"));
		Project defaultProject = workspace.getDefaultProject();
		for (GenericResource res : getGenericResources())
			defaultProject.add(convert(res));
		if (workspace.getThisFile() == null)
			defaultProject.add(new org.xpect.xtext.lib.setup.workspace.ThisFile());
	}

	protected void initializeJavaProject() {
		if (workspace.getMember(JavaProject.class) == null)
			workspace.add(new JavaProject("default_java_project"));
		JavaProject javaProject = workspace.getMember(JavaProject.class);
		initializeJavaProject(javaProject);
	}

	protected void initializeJavaProject(JavaProject javaProject) {
		if (javaProject.getMember(SrcFolder.class) == null)
			javaProject.add(new SrcFolder("src"));
		SrcFolder srcFolder = javaProject.getMember(SrcFolder.class);
		for (GenericResource res : getGenericResources())
			srcFolder.add(convert(res));
		if (workspace.getThisFile() == null)
			srcFolder.add(new org.xpect.xtext.lib.setup.workspace.ThisFile());
	}

	protected void initializeXbaseProject() {
		initializeJavaProject();
		JavaProject javaProject = workspace.getMember(JavaProject.class);
		javaProject.addClasspathEntry(JavaCore.newContainerEntry(XTEND_LIBRARY_PATH));
	}

}
