package org.xpect.xtext.lib.setup.workspace;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.xpect.setup.IXpectRunnerSetup.IFileSetupContext;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class JavaProject extends Project {

	private static final String JRE_CONTAINER_1_5 = "org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5";

	private List<IClasspathEntry> classpathEntries = Lists.newArrayList();

	public JavaProject() {
		this("java_project");
	}

	public JavaProject(String name) {
		super(name);
		addNature(JavaCore.NATURE_ID);
		this.classpathEntries.add(JavaCore.newContainerEntry(new Path(JRE_CONTAINER_1_5)));
	}

	public void addClasspathEntry(IClasspathEntry path) {
		classpathEntries.add(path);
	}

	@Override
	public IProject create(IFileSetupContext ctx, IWorkspaceRoot container) throws CoreException, IOException {
		IProject project = super.create(ctx, container);
		IJavaProject java = JavaCore.create(project);
		LinkedHashSet<IClasspathEntry> classPath = Sets.newLinkedHashSet(Lists.newArrayList(java.getRawClasspath()));
		classPath.remove(JavaCore.newSourceEntry(project.getFullPath()));
		classPath.addAll(classpathEntries);
		for (SrcFolder srcFolder : getMembers(SrcFolder.class))
			classPath.add(JavaCore.newSourceEntry(project.getFolder(srcFolder.getName()).getFullPath()));
		java.setRawClasspath(Lists.newArrayList(classPath).toArray(new IClasspathEntry[classPath.size()]), new NullProgressMonitor());
		java.save(null, true);
		return project;
	}

}
