/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index.internal;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.xtext.index.internal.dbaccess.IndexDatabase;
import org.eclipse.xtext.index.internal.dbaccess.NotFoundInIndexException;
import org.eclipse.xtext.util.Strings;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class WorkspaceModelIndexer {

	private IndexDatabase indexDatabase;

	private static Logger log = Logger.getLogger(WorkspaceModelIndexer.class);

	public static final Set<String> REGISTERED_EXTENSIONS = Resource.Factory.Registry.INSTANCE
			.getExtensionToFactoryMap().keySet();

	private ResourceSet resourceSet;

	public WorkspaceModelIndexer(IndexDatabase indexDatabase) {
		this.indexDatabase = indexDatabase;
		resourceSet = new ResourceSetImpl();
	}

	public void indexWorkspace() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject project : projects) {
			try {
				indexProject(project);
			}
			catch (Exception e) {
				log.error(e);
			}
		}
		try {
			List<URI> allResourceURIs = indexDatabase.getResourceDAO().findAllResources();
			for (URI resourceUri : allResourceURIs) {
				Resource resource = resourceSet.getResource(resourceUri, true);
				indexCrossRefs(resource);
				resource.unload();
			}
		}
		catch (SQLException exc) {
			log.error(exc);
		}
		try {
			indexDatabase.commitOrRollback();
		}
		catch (SQLException exc) {
			log.error(exc);
		}
	}

	public void indexProject(IProject project) {
		try {
			if (project.hasNature(JavaCore.NATURE_ID)) {
				indexJavaProject(JavaCore.create(project));
			}
			else {
				indexPlainProject(project);
			}
		}
		catch (Exception exc) {
			log.error(exc);
		}
	}

	public void indexJarFile(IPath path, int projectContainerID) throws SQLException, ZipException, IOException {
		File jarFile = path.toFile();
		String jarFileURI = "jar:file:" + jarFile.getAbsolutePath() + "!";
		int containerID = indexDatabase.getResourceContainerDAO().create(jarFileURI);
		ZipFile zipFile = new ZipFile(jarFile);
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		while (entries.hasMoreElements()) {
			ZipEntry zipEntry = entries.nextElement();
			String name = zipEntry.getName();
			if (!name.startsWith("/")) {
				name = "/" + name;
			}
			String fileExtension = name.substring(name.lastIndexOf('.') + 1);
			if (!zipEntry.isDirectory() && REGISTERED_EXTENSIONS.contains(fileExtension)) {
				URI resourceURI = URI.createURI(jarFileURI + name);
				Resource resource = resourceSet.getResource(resourceURI, true);
				int resourceID;
				boolean isAlreadyIndexed = true;
				try {
					resourceID = indexDatabase.getResourceDAO().getID(name, containerID);
				}
				catch (NotFoundInIndexException e) {
					resourceID = indexDatabase.getResourceDAO().create(name, containerID);
					isAlreadyIndexed = false;
				}
				indexResource(resourceID, resource, isAlreadyIndexed, containerID);
			}
		}
	}

	public void indexModelFile(IFile file) {
		try {
			indexModelFile(file, getResourceContainerID(file.getProject()));
		}
		catch (Exception e) {
			log.error(e);
		}
	}

	public void indexModelFile(IFile file, int resourceContainerID) {
		try {
			String path = file.getProjectRelativePath().toString();
			int resourceID;
			boolean isAlreadyIndexed = true;
			try {
				resourceID = indexDatabase.getResourceDAO().getID(path, resourceContainerID);
			}
			catch (NotFoundInIndexException exc) {
				isAlreadyIndexed = false;
				resourceID = indexDatabase.getResourceDAO().create(path, resourceContainerID);
			}
			URI resourceURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = resourceSet.getResource(resourceURI, true);
			indexResource(resourceID, resource, isAlreadyIndexed, resourceContainerID);
		}
		catch (Exception e) {
			log.error(e);
		}
	}

	public void removeProject(IProject project) {
	}

	public void removeJarFile(IPath path) {
		// TODO: implement
	}

	public void removeModelFile(IFile modelFile) {
		try {
			removeModelFile(modelFile, getResourceContainerID(modelFile.getProject()));
		}
		catch (Exception e) {
			log.error(e);
		}
	}
	
	public void removeModelFile(IFile modelFile, int resourceContainerID) {
		// TODO: implement
	}

	private int getResourceContainerID(IProject project) throws SQLException {
		String projectURI = URI.createPlatformResourceURI(project.getFullPath().toString(), true).toString();
		int resourceContainerID;
		try {
			resourceContainerID = indexDatabase.getResourceContainerDAO().getID(projectURI);
		}
		catch (NotFoundInIndexException exc) {
			resourceContainerID = indexDatabase.getResourceContainerDAO().create(projectURI);
		}
		return resourceContainerID;
	}

	private void indexPlainProject(IProject project) {
		try {
			int containerID = getResourceContainerID(project);
			ResourceVisitor resourceVisitor = new ResourceVisitor(this, containerID);
			project.accept(resourceVisitor);
		}
		catch (Exception e) {
			log.error(e);
		}
	}

	private void indexJavaProject(IJavaProject project) {
		try {
			int containerID = getResourceContainerID(project.getProject());
			for (IClasspathEntry classpathEntry : project.getRawClasspath()) {
				IPath classpathEntryPath = classpathEntry.getPath();
				IResource classpathEntryInWorkspace = project.getProject().getParent().findMember(classpathEntryPath);
				switch (classpathEntry.getEntryKind()) {
					case IClasspathEntry.CPE_LIBRARY:
						if (!classpathEntryPath.toString().startsWith(JavaRuntime.JRE_CONTAINER)) {
							if (classpathEntryInWorkspace != null && classpathEntryInWorkspace.exists()
									&& classpathEntryInWorkspace instanceof IFile) {
								indexJarFile(classpathEntryInWorkspace.getLocation(), containerID);
							}
							else {
								indexJarFile(classpathEntryPath, containerID);
							}
						}
						break;
					case IClasspathEntry.CPE_SOURCE:
						ResourceVisitor resourceVisitor = new ResourceVisitor(this, containerID);
						classpathEntryInWorkspace.accept(resourceVisitor);
						break;
					default:
						// do nothing
				}
			}
		}
		catch (Exception e) {
			log.error(e);
		}
	}

	private void indexResource(int resourceID, Resource resource, boolean isAlreadyIndexed, int containerID)
			throws SQLException {
		List<String> fragmentsInResource = indexDatabase.getEObjectDAO().findFragmentsInResource(resourceID);
		for (Iterator<EObject> contents = resource.getAllContents(); contents.hasNext();) {
			EObject content = contents.next();
			indexEObject(resourceID, resource, content, fragmentsInResource);
		}
		for (String staleFragment : fragmentsInResource) {
			try {
				int staleEObjectID = indexDatabase.getEObjectDAO().getID(staleFragment, resourceID);
				indexDatabase.getEObjectDAO().deleteEObjectAndCrossrefs(staleEObjectID);
			}
			catch (NotFoundInIndexException e) {
				log.error("Cannot find stale EObject in index", e);
			}
		}
		resourceSet.getResources().remove(resource);
	}

	private void indexEObject(int resourceID, Resource resource, EObject content, List<String> fragmentsInResource)
			throws SQLException {
		try {
			int eClassID = indexDatabase.getEClassDAO().getID(content.eClass());
			String fragment = resource.getURIFragment(content);
			if (!fragmentsInResource.remove(fragment)) {
				indexDatabase.getEObjectDAO().create(fragment, eClassID, resourceID);
			}
		}
		catch (NotFoundInIndexException e) {
			log.error("EClass " + Strings.notNull(content.eClass().getName()) + " is not indexed.", e);
		}
	}

	private void indexCrossRefs(Resource resource) throws SQLException {
		for (Iterator<EObject> allContents = resource.getAllContents(); allContents.hasNext();) {
			EObject eObject = allContents.next();
			try {
				int sourceID = indexDatabase.getEObjectDAO().getID(eObject);
				BasicEList<EObject> crossReferences = (BasicEList<EObject>) eObject.eCrossReferences();
				for (int i=0; i< crossReferences.size(); ++i) {
					EObject crossReference = crossReferences.basicGet(i);
					try {
						URI targetURI = EcoreUtil.getURI(crossReference);
						indexDatabase.getCrossReferenceDAO().create(sourceID, targetURI.toString());
					}
					catch (SQLException exc) {
						log.error("Error creating cross-reference");
					}
				}
			}
			catch (NotFoundInIndexException exc) {
				log.error("EObject has not been indexed. Concurrent modification?");
			}
		}
	}

}
