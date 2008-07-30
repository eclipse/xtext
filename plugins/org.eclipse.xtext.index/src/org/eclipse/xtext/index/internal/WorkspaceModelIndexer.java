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
import java.util.ArrayList;
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
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.xtext.index.internal.dbaccess.EClassDAO;
import org.eclipse.xtext.index.internal.dbaccess.EObjectDAO;
import org.eclipse.xtext.index.internal.dbaccess.IndexDatabase;
import org.eclipse.xtext.index.internal.dbaccess.NotFoundInIndexException;
import org.eclipse.xtext.index.internal.dbaccess.ResourceContainerDAO;
import org.eclipse.xtext.index.internal.dbaccess.ResourceDAO;
import org.eclipse.xtext.util.Strings;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class WorkspaceModelIndexer {

	private static Logger log = Logger.getLogger(WorkspaceModelIndexer.class);

	static final Set<String> REGISTERED_EXTENSIONS = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
			.keySet();

	private ResourceSet resourceSet;

	public WorkspaceModelIndexer() throws Exception {
		resourceSet = new ResourceSetImpl();
	}

	public void indexWorkspace() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject project : projects) {
			try {
				int resourceContainerID = getResourceContainerID(project);
				if (project.hasNature(JavaCore.NATURE_ID)) {
					indexJavaProject(resourceContainerID, JavaCore.create(project));
				}
				else {
					indexProject(resourceContainerID, project);
				}
			}
			catch (Exception e) {
				log.error(e);
			}
		}
		try {
			List<URI> allResourceURIs = ResourceDAO.findAllResources();
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
			IndexDatabase.getInstance().commitOrRollback();
		}
		catch (SQLException exc) {
			log.error(exc);
		}
	}

	public void indexProject(int resourceContainerID, IProject project) {
		try {
			IResourceVisitor resourceVisitor = new ResourceVisitor(this, resourceContainerID);
			project.accept(resourceVisitor);
		}
		catch (Exception e) {
			log.error(e);
		}

	}

	public void indexJavaProject(int resourceContainerID, IJavaProject project) {
		try {
			ResourceVisitor resourceVisitor = new ResourceVisitor(this, resourceContainerID);
			for (IClasspathEntry classpathEntry : project.getRawClasspath()) {
				if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_LIBRARY) {
					IPath libraryPath = classpathEntry.getPath();
					if (!libraryPath.toString().startsWith(JavaRuntime.JRE_CONTAINER)) {
						IResource libraryInWorkspace = project.getProject().getParent().findMember(libraryPath);
						if (libraryInWorkspace != null && libraryInWorkspace.exists()
								&& libraryInWorkspace instanceof IFile) {
							indexJarFile(libraryInWorkspace.getLocation());
						}
						else {
							indexJarFile(libraryPath);
						}
					}
				}
			}
			project.getProject().accept(resourceVisitor);
		}
		catch (Exception e) {
			log.error(e);
		}
	}

	public void indexJarFile(IPath path) throws SQLException, ZipException, IOException {
		File jarFile = path.toFile();
		String jarFileURI = "jar:file:" + jarFile.getAbsolutePath() + "!";
		int containerID = ResourceContainerDAO.create(jarFileURI);
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
					resourceID = ResourceDAO.getID(name, containerID);
				}
				catch (NotFoundInIndexException e) {
					resourceID = ResourceDAO.create(name, containerID);
					isAlreadyIndexed = false;
				}
				indexResource(resourceID, resource, isAlreadyIndexed);
			}
		}
	}

	public void indexModelFile(int resourceContainerID, IFile file) {
		try {
			String path = file.getProjectRelativePath().toString();
			int resourceID;
			boolean isAlreadyIndexed = true;
			try {
				resourceID = ResourceDAO.getID(path, resourceContainerID);
			}
			catch (NotFoundInIndexException exc) {
				isAlreadyIndexed = false;
				resourceID = ResourceDAO.create(path, resourceContainerID);
			}
			URI fileURI = URI.createURI(file.getLocationURI().toString());
			Resource resource = resourceSet.getResource(fileURI, true);
			indexResource(resourceID, resource, isAlreadyIndexed);
		}
		catch (Exception e) {
			log.error(e);
		}
	}

	public void indexResource(int resourceID, Resource resource, boolean isAlreadyIndexed) throws SQLException {
		List<String> fragmentsInResource = EObjectDAO.findFragmentsInResource(resourceID);
		for (Iterator<EObject> contents = resource.getAllContents(); contents.hasNext();) {
			EObject content = contents.next();
			indexEObject(resourceID, resource, content, fragmentsInResource);
		}
		List<Integer> deletedEObjectIDs = new ArrayList<Integer>(fragmentsInResource.size());
		for (String staleFragment : fragmentsInResource) {
			try {
				int staleEObjectID = EObjectDAO.getID(staleFragment, resourceID);
				deletedEObjectIDs.add(staleEObjectID);
				EObjectDAO.delete(staleEObjectID);
			}
			catch (NotFoundInIndexException e) {
				log.error("Cannot find stale EObject in index", e);
			}
		}
		List<URI> danglingReferences = new ArrayList<URI>();
		for (int deletedEObjectID : deletedEObjectIDs) {
			danglingReferences.addAll(EObjectDAO.findReferencesTo(deletedEObjectID));
		}
		// TODO what to do about dangling refs?
		resourceSet.getResources().remove(resource);
	}

	public void indexEObject(int resourceID, Resource resource, EObject content, List<String> fragmentsInResource)
			throws SQLException {
		try {
			int eClassID = EClassDAO.getID(content.eClass());
			String fragment = resource.getURIFragment(content);
			if (!fragmentsInResource.remove(fragment)) {
				EObjectDAO.create(fragment, eClassID, resourceID);
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
				int sourceID = EObjectDAO.getID(eObject);
				EList<EObject> crossReferences = eObject.eCrossReferences();
				for (EObject crossReference : crossReferences) {
					try {
						if (crossReference.eResource() != null) {
							int targetID = EObjectDAO.getID(crossReference);
							EObjectDAO.createCrossReference(sourceID, targetID);
						}
					}
					catch (NotFoundInIndexException nfiie) {
						log.error("Illegal or dangling cross-reference");
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

	private int getResourceContainerID(IProject project) throws SQLException {
		String projectURI = URI.createPlatformResourceURI(project.getFullPath().toString(), true).toString();
		int resourceContainerID;
		try {
			resourceContainerID = ResourceContainerDAO.getID(projectURI);
		}
		catch (NotFoundInIndexException exc) {
			resourceContainerID = ResourceContainerDAO.create(projectURI);
		}
		return resourceContainerID;
	}

}
