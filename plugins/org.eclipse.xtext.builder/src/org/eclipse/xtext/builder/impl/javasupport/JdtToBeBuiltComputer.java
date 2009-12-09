package org.eclipse.xtext.builder.impl.javasupport;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.builder.impl.ToBeBuilt;
import org.eclipse.xtext.builder.impl.ToBeBuiltComputer;
import org.eclipse.xtext.ui.core.resource.JarWalker;

public class JdtToBeBuiltComputer extends ToBeBuiltComputer {
	
	private final static Logger log = Logger.getLogger(JdtToBeBuiltComputer.class);

	@Override
	public ToBeBuilt updateProject(IProject project, IProgressMonitor monitor) throws CoreException {
		final ToBeBuilt toBeBuilt = super.updateProject(project, monitor);
		IJavaProject javaProject = JavaCore.create(project);
		if (javaProject.exists()) {
			IPackageFragmentRoot[] roots = javaProject.getPackageFragmentRoots();
			for (IPackageFragmentRoot root : roots) {
				if (shouldHandle(root)) {
					new JarWalker<Void>() {
						@Override
						protected Void handle(IJarEntryResource jarEntry) {
							URI uri = getUri(jarEntry);
							if (uri != null) {
								toBeBuilt.getToBeDeleted().add(uri);
								toBeBuilt.getToBeUpdated().add(uri);
							}
							return null;
						}
					}.traverse(root,false);
				}
			}
		}
		return toBeBuilt;
	}

	private boolean shouldHandle(IPackageFragmentRoot root) {
		try {
			return (!"org.eclipse.jdt.launching.JRE_CONTAINER".equals(root.getRawClasspathEntry().getPath().toString()) && (root
					.isArchive() || root.isExternal()));
		} catch (JavaModelException e) {
			log.error(e.getMessage(),e);
			return false;
		}
	}

	@Override
	protected boolean isOnProject(IStorage storage, IProject project) {
		if (storage instanceof IJarEntryResource) {
			IPackageFragmentRoot root = ((IJarEntryResource) storage).getPackageFragmentRoot();
			return root.getJavaProject().getProject().equals(project);
		}
		return super.isOnProject(storage, project);
	}

	@Override
	protected boolean isHandled(IStorage resource) {
		return (resource instanceof IJarEntryResource) || super.isHandled(resource);
	}
}
