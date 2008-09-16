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
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
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
		List<Integer> containerIDsFromDB = null;
		try {
			containerIDsFromDB = indexDatabase.getResourceContainerDAO().findAllResourceContainerIDs();
		}
		catch (SQLException exc) {
			log.error("Error querying resouce containers", exc);
		}
		for (IProject project : projects) {
			indexProject(project, containerIDsFromDB);
		}
		if (containerIDsFromDB != null) {
			deleteStaleResourceContainers(containerIDsFromDB);
		}
		commitOrLogError();
	}

	public void indexProject(IProject project, List<Integer> containerIDsFromDB) {
		try {
			if (project.hasNature(JavaCore.NATURE_ID)) {
				indexJavaProject(JavaCore.create(project), containerIDsFromDB);
			}
			else {
				indexPlainProject(project, containerIDsFromDB);
			}
			indexDatabase.commitOrRollback();
		}
		catch (Exception e) {
			log.error("Error indexing project " + project.getName());
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

	public URI indexModelFile(IFile file, int resourceContainerID) {
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
			indexDatabase.commitOrRollback();
			return resourceURI;
		}
		catch (Exception e) {
			log.error("Error indexing " + file.getFullPath().toString(), e);
		}
		return null;
	}

	public void removeProject(IProject project) {
		try {
			int resourceContainerID = getResourceContainerID(project);
			indexDatabase.getResourceContainerDAO().delete(resourceContainerID);
			indexDatabase.commitOrRollback();
		}
		catch (SQLException e) {
			log.error(e);
		}

	}

	public void removeJarFile(IPath path) {
		try {
			File jarFile = path.toFile();
			String jarFileURI = "jar:file:" + jarFile.getAbsolutePath() + "!";
			int resourceContainerID = indexDatabase.getResourceContainerDAO().create(jarFileURI);
			indexDatabase.getResourceContainerDAO().delete(resourceContainerID);
			indexDatabase.commitOrRollback();
		}
		catch (SQLException e) {
			log.error(e);
		}
	}

	public void removeModelFile(IFile modelFile) {
		try {
			removeModelFile(modelFile, getResourceContainerID(modelFile.getProject()));
			indexDatabase.commitOrRollback();
		}
		catch (Exception e) {
			log.error(e);
		}
	}

	public void removeModelFile(IFile modelFile, int resourceContainerID) {
		try {
			int resourceID = indexDatabase.getResourceDAO().getID(modelFile.getProjectRelativePath().toString(),
					resourceContainerID);
			indexDatabase.getResourceDAO().delete(resourceID);
			indexDatabase.commitOrRollback();
		}
		catch (Exception e) {
			log.error(e);
		}
	}

	private void commitOrLogError() {
		try {
			indexDatabase.commitOrRollback();
		}
		catch (SQLException exc) {
			log.error("Error commiting changes to model index", exc);
		}
	}

	private int getResourceContainerID(IProject project) throws SQLException {
		String projectURI = URIUtil.createContainerURI(project).toString();
		return getResourceContainerID(projectURI);
	}

	private int getResourceContainerID(String containerURI) throws SQLException {
		int resourceContainerID;
		try {
			resourceContainerID = indexDatabase.getResourceContainerDAO().getID(containerURI);
		}
		catch (NotFoundInIndexException exc) {
			resourceContainerID = indexDatabase.getResourceContainerDAO().create(containerURI);
		}
		return resourceContainerID;
	}

	private void indexPlainProject(IProject project, List<Integer> containerIDsFromDB) {
		try {
			int containerID = getResourceContainerID(project);
			containerIDsFromDB.remove(new Integer(containerID));
			List<URI> resourceURIsFromDB = indexDatabase.getResourceDAO().findByContainer(containerID);
			ResourceVisitor resourceVisitor = new ResourceVisitor(this, containerID, resourceURIsFromDB);
			project.accept(resourceVisitor);
			deleteStaleResources(resourceURIsFromDB);
			List<URI> dependencyURIsFromDB = indexDatabase.getResourceContainerReferenceDAO().findDependencyURIs(
					containerID);
			IProject[] referencedProjects = project.getReferencedProjects();
			if (referencedProjects != null) {
				for (IProject referencedProject : referencedProjects) {
					URI projectURI = URIUtil.createContainerURI(referencedProject);
					if (!dependencyURIsFromDB.remove(projectURI)) {
						indexDatabase.getResourceContainerReferenceDAO().create(containerID, projectURI);
					}
				}
			}
			deleteStaleContainerReferences(containerID, dependencyURIsFromDB);
		}
		catch (Exception e) {
			log.error(e);
		}
	}

	private void indexJavaProject(IJavaProject project, List<Integer> containerIDsFromDB) {
		try {
			int projectContainerID = getResourceContainerID(project.getProject());
			containerIDsFromDB.remove(new Integer(projectContainerID));
			List<URI> containerReferenceURIsFromDB = indexDatabase.getResourceContainerReferenceDAO()
					.findDependencyURIs(projectContainerID);
			List<URI> resourceURIsFromDB = indexDatabase.getResourceDAO().findByContainer(projectContainerID);
			for (IClasspathEntry classpathEntry : project.getRawClasspath()) {
				IPath classpathEntryPath = classpathEntry.getPath();
				IResource classpathEntryInWorkspace = project.getProject().getParent().findMember(classpathEntryPath);
				switch (classpathEntry.getEntryKind()) {
					case IClasspathEntry.CPE_LIBRARY:
						if (!classpathEntryPath.toString().startsWith(JavaRuntime.JRE_CONTAINER)) {
							URI jarFileURI;
							if (classpathEntryInWorkspace != null && classpathEntryInWorkspace.exists()
									&& classpathEntryInWorkspace instanceof IFile) {
								jarFileURI = indexJarFile(classpathEntryInWorkspace.getLocation(), containerIDsFromDB);
							}
							else {
								jarFileURI = indexJarFile(classpathEntryPath, containerIDsFromDB);
							}
							if (!containerReferenceURIsFromDB.remove(jarFileURI)) {
								indexDatabase.getResourceContainerReferenceDAO().create(projectContainerID, jarFileURI);
							}
						}
						break;
					case IClasspathEntry.CPE_SOURCE:
						ResourceVisitor resourceVisitor = new ResourceVisitor(this, projectContainerID,
								resourceURIsFromDB);
						classpathEntryInWorkspace.accept(resourceVisitor);
						break;
					default:
						// do nothing
				}
			}
			String[] requiredProjectNames = project.getRequiredProjectNames();
			for (String requiredProjectName : requiredProjectNames) {
				URI requiredProjectURI = URI.createPlatformResourceURI(requiredProjectName, true);
				if (!containerReferenceURIsFromDB.remove(requiredProjectURI)) {
					indexDatabase.getResourceContainerReferenceDAO().create(projectContainerID, requiredProjectURI);
				}
			}
			deleteStaleContainerReferences(projectContainerID, containerReferenceURIsFromDB);
			deleteStaleResources(resourceURIsFromDB);
		}
		catch (Exception e) {
			log.error(e);
		}
	}

	private URI indexJarFile(IPath path, List<Integer> containerIDsFromDB) throws SQLException {
		File jarFile = path.toFile();
		String jarFileURIString = "jar:file:" + jarFile.getAbsolutePath() + "!/";
		URI jarFileURI = URI.createURI(jarFileURIString);
		int jarFileContainerID = getResourceContainerID(jarFileURIString);
		containerIDsFromDB.remove(new Integer(jarFileContainerID));
		List<URI> resourceURIsFromDB = indexDatabase.getResourceDAO().findByContainer(jarFileContainerID);
		try {
			ZipFile zipFile = new ZipFile(jarFile);
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry zipEntry = entries.nextElement();
				String name = URIUtil.trimLeadingSlash(zipEntry.getName());
				String fileExtension = name.substring(name.lastIndexOf('.') + 1);
				if (!zipEntry.isDirectory() && REGISTERED_EXTENSIONS.contains(fileExtension)) {
					URI resourceURI = URI.createURI(jarFileURIString + name);
					resourceURIsFromDB.remove(resourceURI);
					Resource resource = resourceSet.getResource(resourceURI, true);
					int resourceID;
					boolean isAlreadyIndexed = true;
					try {
						resourceID = indexDatabase.getResourceDAO().getID(name, jarFileContainerID);
					}
					catch (NotFoundInIndexException e) {
						resourceID = indexDatabase.getResourceDAO().create(name, jarFileContainerID);
						isAlreadyIndexed = false;
					}
					indexResource(resourceID, resource, isAlreadyIndexed, jarFileContainerID);
				}
			}
		}
		catch (IOException e) {
			log.error("Error indexing jar file " + jarFileURIString, e);
		}
		deleteStaleResources(resourceURIsFromDB);
		return jarFileURI;
	}

	private void indexResource(int resourceID, Resource resource, boolean isAlreadyIndexed, int containerID)
			throws SQLException {
		List<String> fragmentsInResource = indexDatabase.getEObjectDAO().findFragmentsInResource(resourceID);
		for (Iterator<EObject> contents = resource.getAllContents(); contents.hasNext();) {
			EObject content = contents.next();
			indexEObject(resourceID, resource, content, fragmentsInResource);
		}
		deleteStaleFragments(resourceID, fragmentsInResource);
		resourceSet.getResources().remove(resource);
	}

	private void indexEObject(int resourceID, Resource resource, EObject eObject, List<String> fragmentsInResource)
			throws SQLException {
		try {
			int eClassID = indexDatabase.getEClassDAO().getID(eObject.eClass());
			String fragment = resource.getURIFragment(eObject);
			if (!fragmentsInResource.remove(fragment)) {
				indexDatabase.getEObjectDAO().create(fragment, eClassID, resourceID);
			}
			indexCrossRefs(eObject);
		}
		catch (NotFoundInIndexException e) {
			log.error("EClass " + Strings.notNull(eObject.eClass().getName()) + " is not indexed.", e);
		}
	}

	private void indexCrossRefs(EObject eObject) throws SQLException {
		try {
			int sourceID = indexDatabase.getEObjectDAO().getID(eObject);
			List<URI> crossReferencesFromDB = indexDatabase.getCrossReferenceDAO().findReferencesFrom(sourceID);
			InternalEList<EObject> crossReferences = (InternalEList<EObject>) eObject.eCrossReferences();
			for (int i = 0; i < crossReferences.size(); ++i) {
				EObject crossReference = crossReferences.basicGet(i);
				try {
					URI targetURI = EcoreUtil.getURI(crossReference);
					if (!crossReferencesFromDB.remove(targetURI)) {
						indexDatabase.getCrossReferenceDAO().create(sourceID, targetURI.toString());
					}
				}
				catch (SQLException exc) {
					log.error("Error creating cross-reference");
				}
			}
			deleteStaleCrossReferences(sourceID, crossReferencesFromDB);
		}
		catch (NotFoundInIndexException exc) {
			log.error("EObject has not been indexed. Concurrent modification?");
		}
	}

	private void deleteStaleCrossReferences(int sourceID, List<URI> staleTargetURIs) {
		for (URI staleTargetURI : staleTargetURIs) {
			try {
				indexDatabase.getCrossReferenceDAO().deleteBySourceAndTarget(sourceID, staleTargetURI);
			}
			catch (SQLException e) {
				log.error("Cannot delete stale cross reference " + staleTargetURI.toString(), e);
			}
		}
	}

	private void deleteStaleFragments(int resourceID, List<String> fragmentsInResource) throws SQLException {
		for (String staleFragment : fragmentsInResource) {
			try {
				// TODO optimize: delete without query
				int staleEObjectID = indexDatabase.getEObjectDAO().getID(staleFragment, resourceID);
				indexDatabase.getEObjectDAO().delete(staleEObjectID);
			}
			catch (NotFoundInIndexException e) {
				log.error("Cannot find stale EObject in index", e);
			}
		}
	}

	private void deleteStaleResources(List<URI> staleResourceURIs) {
		for (URI staleResourceURI : staleResourceURIs) {
			try {
				// TODO optimize: delete without query
				int staleResourceID = indexDatabase.getResourceDAO().getID(staleResourceURI);
				indexDatabase.getResourceDAO().delete(staleResourceID);
			}
			catch (Exception e) {
				log.error("Cannot delete stale resource " + staleResourceURI.toString(), e);
			}
		}
	}

	private void deleteStaleContainerReferences(int containerID, List<URI> dependencyURIsFromDB) throws SQLException {
		for (URI staleDependencyURI : dependencyURIsFromDB) {
			try {
				indexDatabase.getResourceContainerReferenceDAO().deleteBySourceAndTarget(containerID,
						staleDependencyURI);
			}
			catch (Exception e) {
				log.error("Cannot delete stale container reference " + staleDependencyURI.toString(), e);
			}
		}
	}

	private void deleteStaleResourceContainers(List<Integer> containerIDsFromDB) {
		for (int staleContainerID : containerIDsFromDB) {
			try {
				indexDatabase.getResourceContainerDAO().delete(staleContainerID);
			}
			catch (SQLException e) {
				log.error("Error deleting stale resource container", e);
			}
		}
	}

}
