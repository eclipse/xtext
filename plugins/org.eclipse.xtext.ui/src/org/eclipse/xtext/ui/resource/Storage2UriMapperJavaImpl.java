/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;
import static java.util.Collections.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.IPath;
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
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.xtext.ui.util.IJdtHelper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 */
@Singleton
public class Storage2UriMapperJavaImpl implements IStorage2UriMapperJdtExtensions, IStorage2UriMapperContribution {
	
	private static final Logger log = Logger.getLogger(Storage2UriMapperJavaImpl.class);
	
	/**
	 * @since 2.5
	 */
	public static class PackageFragmentRootData {
		public URI uriPrefix;
		public final Object modificationStamp;
		public final Map<String, IPackageFragmentRoot> associatedRoots;

		public PackageFragmentRootData(Object modificationStamp) {
			this.modificationStamp = modificationStamp;
			this.associatedRoots = newHashMap();
		}

		public Map<URI, IStorage> uri2Storage = newLinkedHashMap();
		
		@Override
		public String toString() {
			return getPath() + " / " + uriPrefix;
		}

		public boolean exists() {
			if (associatedRoots.size() == 0) {
				return false;
			}
			return associatedRoots.values().iterator().next().exists();
		}

		public IPath getPath() {
			if (associatedRoots.size() == 0) {
				return null;
			}
			return associatedRoots.values().iterator().next().getPath();
		}

		public void addRoot(IPackageFragmentRoot root) {
			if (root != null) {
				associatedRoots.put(root.getHandleIdentifier(), root);
			}
		}

	}
	
	
	@Inject private JarEntryLocator locator;
	@Inject private IJdtHelper jdtHelper;
	@Inject private UriValidator uriValidator;
	
	@Inject private IStorage2UriMapper host;
	
	/**
	 * Public for testing purpose
	 * 
	 * @since 2.4
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setJdtHelper(IJdtHelper jdtHelper) {
		this.jdtHelper = jdtHelper;
	}
	
	/**
	 * Public for testing purpose
	 * 
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setLocator(JarEntryLocator locator) {
		this.locator = locator;
	}
	
	/**
	 * Public for testing purpose
	 * 
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setUriValidator(UriValidator uriValidator) {
		this.uriValidator = uriValidator;
	}
	
	/**
	 * Public for testing purpose
	 * 
	 * @since 2.5
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setHost(IStorage2UriMapper host) {
		this.host = host;
	}
	
	private Map<String, PackageFragmentRootData> cachedPackageFragmentRootData = newLinkedHashMap();
	
	/**
	 * Rejects Java output folders when traversing a project.
	 * @return <code>true</code> if the folder is a java output folder. Otherwise <code>false</code>.
	 * @since 2.5
	 */
	public boolean isRejected(/* @NonNull */ IFolder folder) {
		return jdtHelper.isFromOutputPath(folder);
	}
	
	/**
	 * @since 2.4
	 */
	public Pair<URI, URI> getURIMapping(IPackageFragmentRoot root) throws JavaModelException {
		PackageFragmentRootData data = getData(root);
		if (data.uriPrefix == null)
			return null;
		IPath path = root.isExternal() ? root.getPath() : root.getUnderlyingResource().getLocation();
		URI physical = null;
		if (root.isArchive()) {
			String archiveScheme = "zip".equalsIgnoreCase(root.getPath().getFileExtension()) ? "zip" : "jar";
			physical = URI.createURI(archiveScheme+":file:"+path.toFile().getPath()+"!/");
		} else {
			physical = URI.createFileURI(path.toFile().getPath()+"/");
		}
		return Tuples.create(data.uriPrefix, physical);
	}
	
	/**
	 * @since 2.4
	 */
	public Map<URI, IStorage> getAllEntries(IPackageFragmentRoot root) {
		try {
			if (root.getUnderlyingResource() instanceof IFolder) {
				return host.getAllEntries((IFolder)root.getUnderlyingResource());
			}
		} catch (JavaModelException e) {
			log.error(e.getMessage(), e);
			return emptyMap();
		}
		PackageFragmentRootData data = getData(root);
		return data.uri2Storage;
	}
	
	private PackageFragmentRootData getData(IPackageFragmentRoot root) {
		final boolean isCachable = root.isArchive() || root.isExternal();
		if (isCachable) {
			return getCachedData(root);
		}
		PackageFragmentRootData data = initializeData(root);
		return data;
	}

	private PackageFragmentRootData getCachedData(IPackageFragmentRoot root) {
		final String path = root.getPath().toString();
		synchronized (cachedPackageFragmentRootData) {
			if(cachedPackageFragmentRootData.containsKey(path)) {
				final PackageFragmentRootData data = cachedPackageFragmentRootData.get(path);
				if (isUpToDate(data, root)) {
					data.addRoot(root);
					return data;
				} else {
					cachedPackageFragmentRootData.remove(path);
				}
			}
		}
		PackageFragmentRootData data = initializeData(root);
		synchronized (cachedPackageFragmentRootData) {
			cachedPackageFragmentRootData.put(path, data);
		}
		return data;
	}
	
	private boolean isUpToDate(PackageFragmentRootData data, IPackageFragmentRoot root) {
		return Objects.equal(data.modificationStamp, computeModificationStamp(root));
	}
	
	private Object computeModificationStamp(IPackageFragmentRoot root) {
		try {
			if (root.exists()) {
				IResource resource = root.getUnderlyingResource();
				if (resource != null) {
					return resource.getLocation().toFile().lastModified();
				}
				return root.getPath().toFile().lastModified();
			}
		} catch (JavaModelException e) {
			log.error(e.getMessage(), e);
		}
		return new Object();
	}

	/**
	 * @since 2.4
	 */
	protected PackageFragmentRootData initializeData(final IPackageFragmentRoot root) {
		final PackageFragmentRootData data = new PackageFragmentRootData(computeModificationStamp(root));
		data.addRoot(root);
		try {
			final SourceAttachmentPackageFragmentRootWalker<Void> walker = new SourceAttachmentPackageFragmentRootWalker<Void>() {
				
				@Override
				protected URI getURI(IFile file,
						org.eclipse.xtext.ui.resource.PackageFragmentRootWalker.TraversalState state) {
					if (!uriValidator.isPossiblyManaged(file))
						return null;
					return super.getURI(file, state);
				}

				@Override
				protected URI getURI(IJarEntryResource jarEntry,
						org.eclipse.xtext.ui.resource.PackageFragmentRootWalker.TraversalState state) {
					if (!uriValidator.isPossiblyManaged(jarEntry))
						return null;
					final URI uri = locator.getURI(root, jarEntry, state);
					if (!uriValidator.isValid(uri, jarEntry))
						return null;
					return uri;
				}

				@Override
				protected Void handle(URI uri, IStorage storage,
						org.eclipse.xtext.ui.resource.PackageFragmentRootWalker.TraversalState state) {
					data.uri2Storage.put(uri, storage);
					return null;
				}
				
			};
			walker.traverse(root, false);
			if (walker.getBundleSymbolicName() != null)
				data.uriPrefix = URI.createPlatformResourceURI(walker.getBundleSymbolicName()+"/", true);
		} catch (JavaModelException e) {
			log.error(e.getMessage(), e);
		}
		return data;
	}
	
	/* @NonNull */
	public Iterable<Pair<IStorage, IProject>> getStorages(/* @NonNull */ URI uri) {
		List<Pair<IStorage, IProject>> result = newArrayListWithCapacity(1);
		List<PackageFragmentRootData> packageFragmentRootDatas;
		synchronized(cachedPackageFragmentRootData) {
			packageFragmentRootDatas = newArrayList(cachedPackageFragmentRootData.values());
		}
		Iterator<PackageFragmentRootData> iterator = packageFragmentRootDatas.iterator();
		while (iterator.hasNext()) {
			PackageFragmentRootData data = iterator.next();
			if (data.exists()) {
				if (data.uriPrefix == null || uri.toString().startsWith(data.uriPrefix.toString())) {
					IStorage storage = data.uri2Storage.get(uri);
					if (storage != null) {
						for (IPackageFragmentRoot root : data.associatedRoots.values()) {
							result.add(Tuples.create(storage, root.getJavaProject().getProject()));
						}
					}
				}
			} else {
				iterator.remove();
			}
		}
		if (result.isEmpty() && uri.isArchive()) {
			String authority = uri.authority();
			authority = authority.substring(0, authority.length() - 1);
			URI archiveURI = URI.createURI(authority);
			if (archiveURI.isFile() || archiveURI.isPlatformResource()) {
				IPath archivePath = new Path(archiveURI.isPlatformResource()? archiveURI.toPlatformString(true): archiveURI.toFileString());
				for (PackageFragmentRootData data : packageFragmentRootDatas) {
					if (data.uriPrefix != null && archivePath.equals(data.getPath())) {
						// prefixes have an empty last segment.
						URI prefix = data.uriPrefix.lastSegment().length()==0 ? data.uriPrefix.trimSegments(1) : data.uriPrefix;
						URI expectedURI = prefix.appendSegments(uri.segments());
						IStorage storage = data.uri2Storage.get(expectedURI);
						if (storage != null) {
							for (IPackageFragmentRoot root : data.associatedRoots.values()) {
								result.add(Tuples.create(storage, root.getJavaProject().getProject()));
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * @since 2.5
	 */
	public URI getUri(/* @NonNull */ IStorage storage) {
		if (storage instanceof IJarEntryResource) {
			final IJarEntryResource storage2 = (IJarEntryResource) storage;
			Map<URI, IStorage> data = getAllEntries(storage2.getPackageFragmentRoot());
			for (Map.Entry<URI, IStorage> entry : data.entrySet()) {
				if (entry.getValue().equals(storage2))
					return entry.getKey();
			}
		}
		return null;
	}
	
	@Deprecated public void elementChanged(ElementChangedEvent changeEvent) {
		log.warn("Storage2UriMapperJavaImpl.elementChanged(ElementChangedEvent) is deperecated and does nothing.");
	}

	@Inject
	private IWorkspace workspace;
	
	private boolean isInitialized = false;

	/**
	 * @since 2.4
	 */
	private void updateCache(IJavaProject project) {
		try {
			Set<PackageFragmentRootData> datas = newHashSet();
			for(IPackageFragmentRoot root: project.getPackageFragmentRoots()) {
				boolean isCachable = root.isArchive() || root.isExternal();
				if(isCachable) 
					datas.add(getCachedData(root));
			}
			clearCache(project, datas);
		} catch (JavaModelException e) {
			log.error("Error getting package fragments roots of " + project.getElementName(), e);
		}
	}
	
	private void clearCache(IJavaProject project, Set<PackageFragmentRootData> toBeKept) {
		Collection<PackageFragmentRootData> values;
		synchronized (cachedPackageFragmentRootData) {
			values = newArrayList(cachedPackageFragmentRootData.values());
		}
		List<PackageFragmentRootData> toBeRemoved = newArrayList();
		for (PackageFragmentRootData data : values) {
			if (toBeKept.contains(data)) {
				continue;
			}
			Iterator<Entry<String, IPackageFragmentRoot>> i = data.associatedRoots.entrySet().iterator();
			while (i.hasNext()) {
				Entry<String, IPackageFragmentRoot> root = i.next();
				if (project.equals(root.getValue().getJavaProject())) {
					i.remove();
				}
			}
			if (data.associatedRoots.size() == 0) {
				toBeRemoved.add(data);
			}
		}
		if(!toBeRemoved.isEmpty()) {
			synchronized (cachedPackageFragmentRootData) {
				cachedPackageFragmentRootData.values().removeAll(toBeRemoved);
			}
		}
	}

	/**
	 * @since 2.4
	 */
	public void initializeCache() {
		if(!isInitialized) {
			for(IProject project: workspace.getRoot().getProjects()) {
				if(project.isAccessible() && JavaProject.hasJavaNature(project)) {
					IJavaProject javaProject = JavaCore.create(project);
					updateCache(javaProject);
				}
			}
			JavaCore.addElementChangedListener(new IElementChangedListener() {
				public void elementChanged(ElementChangedEvent event) {
					Set<IJavaProject> javaProjectsWithClasspathChange = getJavaProjectsWithClasspathChange(event.getDelta());
					if(!javaProjectsWithClasspathChange.isEmpty()) {
						for(IJavaProject project: javaProjectsWithClasspathChange) {
							updateCache(project);
						}
					} 
					for(IJavaElementDelta projectDelta: getProjectDeltas(event.getDelta())) {
						IJavaProject project = (IJavaProject) projectDelta.getElement();
						if((projectDelta.getKind() & IJavaElementDelta.REMOVED) != 0) {
							clearCache(project, Collections.<PackageFragmentRootData>emptySet());
							return;
						} 
						switch(projectDelta.getFlags()) {
							case IJavaElementDelta.F_OPENED: 
								updateCache(project);
								break;
							case IJavaElementDelta.F_CLOSED:
								clearCache(project, Collections.<PackageFragmentRootData>emptySet());
								break;
						}
					}
				}
			}, ElementChangedEvent.POST_CHANGE);
			isInitialized = true;
		}
	}
	
	private Set<IJavaElementDelta> getProjectDeltas(IJavaElementDelta delta) {
		IJavaElement element = delta.getElement();
		if(delta.getElement().getElementType() == IJavaElement.JAVA_PROJECT) {
			return Collections.singleton(delta);
		}
		Set<IJavaElementDelta> result = null;
		if(element instanceof IJavaModel) {
			for(IJavaElementDelta child: delta.getAffectedChildren()) {
				Set<IJavaElementDelta> projectDeltas = getProjectDeltas(child);
				if(!projectDeltas.isEmpty()) {
					if(result == null)
						result = newLinkedHashSet(); 
					result.addAll(projectDeltas);
				}
			}
		}
		return result == null ? Collections.<IJavaElementDelta>emptySet() : result;
	}
	
	private Set<IJavaProject> getJavaProjectsWithClasspathChange(IJavaElementDelta delta) {
		IJavaElement element = delta.getElement();
		if (element instanceof IPackageFragmentRoot) {
			IPackageFragmentRoot root = (IPackageFragmentRoot) element;
			if (delta.getKind() == IJavaElementDelta.REMOVED || delta.getKind() == IJavaElementDelta.ADDED
					|| (delta.getFlags() & IJavaElementDelta.F_REORDER) != 0
					|| (delta.getFlags() & IJavaElementDelta.F_REMOVED_FROM_CLASSPATH) != 0
					|| (delta.getFlags() & IJavaElementDelta.F_ADDED_TO_CLASSPATH) != 0
					|| (root.isExternal() && (delta.getFlags() & // external folders change
					(IJavaElementDelta.F_CONTENT | IJavaElementDelta.F_SOURCEATTACHED | IJavaElementDelta.F_SOURCEDETACHED)) == delta
							.getFlags())) {
				return Collections.singleton(root.getJavaProject());
			}
		} else if (element instanceof IJavaModel) {
			return getPackageFragmentRootDeltas(delta.getAffectedChildren());
		} else if (element instanceof IJavaProject) {
			if ((delta.getFlags() & IJavaElementDelta.F_CLASSPATH_CHANGED) != 0
					|| (delta.getFlags() & IJavaElementDelta.F_RESOLVED_CLASSPATH_CHANGED) != 0)
				return Collections.singleton((IJavaProject) element);
			return getPackageFragmentRootDeltas(delta.getAffectedChildren());
		}
		return Collections.emptySet();
	}

	private Set<IJavaProject> getPackageFragmentRootDeltas(IJavaElementDelta[] affectedChildren) {
		LinkedHashSet<IJavaProject> set = Sets.newLinkedHashSet();
		for (IJavaElementDelta delta : affectedChildren) {
			set.addAll(getJavaProjectsWithClasspathChange(delta));
		}
		return set;
	}

	
}
