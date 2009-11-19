package org.eclipse.xtext.builder.impl.javasupport;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.builder.impl.ResourceIndexer;

public class JdtResourceIndexer extends ResourceIndexer {

	@Override
	protected String getContainerName(IStorage storage) {
		if (!isOnJavaProject(storage))
			return super.getContainerName(storage);
		
		IPackageFragmentRoot packageFragmentRoot = getPackageFragmentRoot(storage);
		return "java:"+packageFragmentRoot.getElementName();
	}

	private IPackageFragmentRoot getPackageFragmentRoot(IStorage storage) {
		if (storage instanceof IJarEntryResource) {
			return ((IJarEntryResource)storage).getPackageFragmentRoot();
		} else if (storage instanceof IResource) {
			return getPackageFragmentRoot(getJavaProject(storage), (IResource) storage);
		}
		throw new IllegalArgumentException("Couldn't handle "+storage);
	}

	@Override
	protected String getProjectName(IStorage storage) {
		if (!isOnJavaProject(storage))
			return super.getProjectName(storage);
		return getJavaProject(storage).getElementName();
	}

	private boolean isOnJavaProject(IStorage storage) {
		return getJavaProject(storage)!=null;
	}

	private IJavaProject getJavaProject(IStorage storage) {
		if (storage instanceof IResource) {
			IProject project = ((IResource) storage).getProject();
			IJavaProject javaProject = JavaCore.create(project);
			if (javaProject.exists() && getPackageFragmentRoot(javaProject, (IResource)storage)!=null)
				return javaProject;
		} else if (storage instanceof IJarEntryResource) {
			return ((IJarEntryResource)storage).getPackageFragmentRoot().getJavaProject();
		}
		throw new IllegalArgumentException("Couldn't handle storage : "+storage);
	}

	private IPackageFragmentRoot getPackageFragmentRoot(IJavaProject jp, IResource resource) {
		try {
			IPackageFragmentRoot[] roots = jp.getPackageFragmentRoots();
			for (IPackageFragmentRoot root : roots) {
				if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
					IResource resource2 = root.getUnderlyingResource();
					if (resource2.contains((IResource) resource))
						return root;
				}
			}
		} catch (JavaModelException jme) {
			throw new WrappedException(jme);
		}
		return null;
	}
}
