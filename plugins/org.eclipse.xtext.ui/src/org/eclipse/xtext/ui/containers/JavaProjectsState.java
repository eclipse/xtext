/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.containers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.xtext.ui.resource.PackageFragmentRootWalker;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class JavaProjectsState extends AbstractAllContainersState implements IElementChangedListener {

	private final static Logger log = Logger.getLogger(JavaProjectsState.class);
	
	@Override
	protected void registerAsListener() {
		super.registerAsListener();
		JavaCore.addElementChangedListener(this);
	}
	
	@Override
	public void unregisterAsListener() {
		JavaCore.removeElementChangedListener(this);
		super.unregisterAsListener();
	}
	
	@Override
	protected String doInitHandle(URI uri) {
		IPackageFragmentRoot root = getPackageFragmentRoot(uri);
		if (root != null)
			return root.getHandleIdentifier();
		return null;
	}
	
	@Override
	protected Collection<URI> doInitContainedURIs(String containerHandle) {
		IJavaElement javaElement = JavaCore.create(containerHandle);
		if (javaElement instanceof IPackageFragmentRoot) {
			IPackageFragmentRoot root = (IPackageFragmentRoot) javaElement;
			final List<URI> uris = Lists.newArrayList();
			if (root.isArchive() || root.isExternal()) {
				try {
					new PackageFragmentRootWalker<Void>() {
						@Override
						protected Void handle(IJarEntryResource jarEntry, TraversalState state) {
							URI uri = getUri(jarEntry);
							if (uri != null) {
								uris.add(uri);	
							}
							return null;
						}
					}.traverse(root, false);
					return uris;
				} catch (JavaModelException e) {
					if (!e.isDoesNotExist())
						log.error(e.getMessage(), e);
					return Collections.emptyList();
				}
			} else {
				try {
					IResource resource = root.getResource();
					if (resource != null) {
						resource.accept(new IResourceVisitor() {
							public boolean visit(IResource resource) throws CoreException {
								if (resource instanceof IStorage) {
									URI uri = getUri((IStorage) resource);
									if (uri != null) {
										uris.add(uri);	
									}
									return false;
								}
								return true;
							}
						});
					}
					return uris;
				} catch (CoreException e) {
					log.error(e.getMessage(), e);
					return Collections.emptyList();
				}
			}
		}
		return Collections.emptyList();
	}
	
	@Override
	protected List<String> doInitVisibleHandles(String handle) {
		IJavaElement javaElement = JavaCore.create(handle);
		if (javaElement != null) {
			IJavaProject project = javaElement.getJavaProject();
			List<String> rootHandles = getPackageFragmentRootHandles(project);
			return rootHandles;
		}
		return Collections.emptyList();
	}
	
	protected List<String> getPackageFragmentRootHandles(IJavaProject project) {
		List<String> result = Lists.newArrayList();
		try {
			IPackageFragmentRoot[] roots = project.getAllPackageFragmentRoots();
			for (IPackageFragmentRoot root : roots) {
				if (root != null && !"org.eclipse.jdt.launching.JRE_CONTAINER".equals(root.getRawClasspathEntry().getPath().toString()))
					result.add(root.getHandleIdentifier());
			}
		} catch (JavaModelException e) {
			if (!e.isDoesNotExist()) {
				log.error("Cannot find rootHandles in project " + project.getProject().getName(), e);
			}
		}
		return result;
	}
	
	protected IPackageFragmentRoot getPackageFragmentRoot(URI uri) {
		if (uri.isArchive()) {
			return getJarWithEntry(uri);
		}
		final IFile file = getWorkspaceRoot().getFile(new Path(uri.toPlatformString(true)));
		if (file == null) {
			return getJarWithEntry(uri);
		}
		IPackageFragmentRoot root = getJavaElement(file);
		if (root == null)
			return getJarWithEntry(uri);
		return root;
	}
	
	protected IPackageFragmentRoot getJavaElement(final IFile file) {
		IJavaProject jp = JavaCore.create(file.getProject());
		if (!jp.exists())
			return null;
		IPackageFragmentRoot[] roots;
		try {
			roots = jp.getPackageFragmentRoots();
			for (IPackageFragmentRoot root : roots) {
				if (root.getKind() == IPackageFragmentRoot.K_SOURCE) {
					IResource resource2 = root.getUnderlyingResource();
					if (resource2.contains(file))
						return root;
				}
			}
		} catch (JavaModelException e) {
			if (!e.isDoesNotExist())
				log.error(e.getMessage(), e);
		}
		return null;
	}

	protected IPackageFragmentRoot getJarWithEntry(URI uri) {
		Iterable<IStorage> storages = getStorages(uri);
		for (IStorage storage : storages) {
			if (storage instanceof IJarEntryResource) {
				IPackageFragmentRoot fragmentRoot = ((IJarEntryResource) storage).getPackageFragmentRoot();
				if (fragmentRoot != null)
					return fragmentRoot;
			}
		}
		return null;
	}

	public void elementChanged(ElementChangedEvent event) {
		if (event.getDelta() != null) {
			if (isAffectingPackageFragmentRoots(event.getDelta())) {
				initialize();
			}
		}
	}

	private boolean isAffectingPackageFragmentRoots(IJavaElementDelta delta) {
		IJavaElement element = delta.getElement();
		if (element instanceof IPackageFragmentRoot) {
			if (delta.getKind() == IJavaElementDelta.REMOVED
				|| delta.getKind() == IJavaElementDelta.ADDED
				|| (delta.getFlags() & IJavaElementDelta.F_REORDER) != 0
				|| (delta.getFlags() & IJavaElementDelta.F_REMOVED_FROM_CLASSPATH) != 0
				|| (delta.getFlags() & IJavaElementDelta.F_ADDED_TO_CLASSPATH) != 0
				|| (((IPackageFragmentRoot) element).isExternal() && (delta.getFlags() & // external folders change
						(IJavaElementDelta.F_CONTENT 
								| IJavaElementDelta.F_SOURCEATTACHED 
								| IJavaElementDelta.F_SOURCEDETACHED)) == delta.getFlags())) {
				return true;
			}
		} else if (element instanceof IJavaModel) {
			return isAffectingPackageFragmentRoots(delta.getAffectedChildren());
		} else if (element instanceof IJavaProject) {
			if ((delta.getFlags() & IJavaElementDelta.F_CLASSPATH_CHANGED) != 0 ||
					(delta.getFlags() & IJavaElementDelta.F_RESOLVED_CLASSPATH_CHANGED) != 0)
				return true;
			return isAffectingPackageFragmentRoots(delta.getAffectedChildren());
		}
		return false;
	}
	
	private boolean isAffectingPackageFragmentRoots(IJavaElementDelta[] affectedChildren) {
		for (IJavaElementDelta delta : affectedChildren) {
			if (isAffectingPackageFragmentRoots(delta))
				return true;
		}
		return false;
	}

}
