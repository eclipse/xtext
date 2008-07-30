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
import java.util.Collections;
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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.index.IModelIndex;
import org.eclipse.xtext.index.internal.dbaccess.EClassDAO;
import org.eclipse.xtext.index.internal.dbaccess.EObjectDAO;
import org.eclipse.xtext.index.internal.dbaccess.EPackageDAO;
import org.eclipse.xtext.index.internal.dbaccess.NotFoundInIndexException;
import org.eclipse.xtext.index.internal.dbaccess.ResourceContainerDAO;
import org.eclipse.xtext.index.internal.dbaccess.ResourceDAO;
import org.eclipse.xtext.util.Strings;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class WorkspaceModelIndex implements IModelIndex {

	private static Logger log = Logger.getLogger(WorkspaceModelIndex.class);

	private static final Set<String> REGISTERED_EXTENSIONS = Resource.Factory.Registry.INSTANCE
			.getExtensionToFactoryMap().keySet();

	/**
	 * @author Jan Köhnlein - Initial contribution and API
	 * 
	 */
	private final class ResourceVisitor implements IResourceVisitor {

		private int resourceContainerID;
		private List<IResource> ignoredResources;

		public ResourceVisitor(int resourceContainerID) {
			this.resourceContainerID = resourceContainerID;
			ignoredResources = new ArrayList<IResource>();
		}

		public void addIgnoredResource(IResource ignoredResource) {
			ignoredResources.add(ignoredResource);
		}

		public boolean visit(IResource resource) throws CoreException {
			if (resource.isDerived() || ignoredResources.contains(resource)) {
				return false;
			}
			if (resource instanceof IFile) {
				IFile file = (IFile) resource;
				String fileExtension = file.getFileExtension();
				if (REGISTERED_EXTENSIONS.contains(fileExtension)) {
					indexModelFile(resourceContainerID, file);
				}
				return false;
			}
			return true;
		}
	}

	private ResourceSet resourceSet;

	public WorkspaceModelIndex(boolean isRegisterEPackages) throws Exception {
		resourceSet = new ResourceSetImpl();
		if (isRegisterEPackages) {
			indexRegisteredEPackages();
		}
	}

	public boolean exists(URI fragmentUri) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<URI> findReferencesTo(URI referencedUri, IProject scope) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<URI> findInstances(EClass eClass, IProject scope) {
		try {
			return EObjectDAO.findByEClass(eClass);
		}
		catch (Exception e) {
			log.error(e);
		}
		return Collections.<URI> emptyList();
	}

	private void indexRegisteredEPackages() {
		List<String> nsURIs = new ArrayList<String>(EPackage.Registry.INSTANCE.keySet());
		for (String nsURI : nsURIs) {
			try {
				Object object = EPackage.Registry.INSTANCE.get(nsURI);
				EPackage ePackage = null;
				if (object instanceof EPackage.Descriptor) {
					ePackage = ((EPackage.Descriptor) object).getEPackage();
				}
				else if (object instanceof EPackage) {
					ePackage = (EPackage) object;
				}
				if (ePackage != null) {
					indexEPackage(ePackage);
				}
			}
			catch (Exception exc) {
				log.error(exc);
			}
		}
	}

	public void indexEPackage(EPackage ePackage) throws SQLException {
		int ePackageID;
		List<String> allEClassNames;
		try {
			ePackageID = EPackageDAO.getID(ePackage);
			allEClassNames = EClassDAO.findAllEClassNames(ePackageID);
		}
		catch (NotFoundInIndexException exc) {
			ePackageID = EPackageDAO.create(ePackage);
			allEClassNames = Collections.emptyList();
		}
		log.info("Indexing EPackage: " + ePackageID + " " + ePackage.getNsURI());
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			if (classifier instanceof EClass) {
				if (!allEClassNames.remove(classifier.getName())) {
					EClassDAO.create((EClass) classifier, ePackageID);
				}
			}
		}
		for (String staleEClassName : allEClassNames) {
			EClassDAO.delete(staleEClassName);
		}
		for (EPackage subPackage : ePackage.getESubpackages()) {
			indexEPackage(subPackage);
		}
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
	}

	/**
	 * @param project
	 */
	public void indexProject(int resourceContainerID, IProject project) {
		try {
			IResourceVisitor resourceVisitor = new ResourceVisitor(resourceContainerID);
			project.accept(resourceVisitor);
		}
		catch (Exception e) {
			log.error(e);
		}

	}

	public void indexJavaProject(int resourceContainerID, IJavaProject project) {
		try {
			ResourceVisitor resourceVisitor = new ResourceVisitor(resourceContainerID);
			for (IClasspathEntry classpathEntry : project.getResolvedClasspath(true)) {
				if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_LIBRARY) {
					IPath libraryPath = classpathEntry.getPath();
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
			resourceSet.getResources().remove(resource);
		}
		catch (Exception e) {
			log.error(e);
		}
	}

	public void indexResource(int resourceID, Resource resource, boolean isAlreadyIndexed) throws SQLException {
		for (EObject rootElement : resource.getContents()) {
			for (Iterator<EObject> contents = rootElement.eAllContents(); contents.hasNext();) {
				EObject content = contents.next();
				indexEObject(resourceID, resource, content);
			}
		}
	}

	public void indexEObject(int resourceID, Resource resource, EObject content) throws SQLException {
		try {
			int eClassID = EClassDAO.getID(content.eClass());
			String fragment = resource.getURIFragment(content);
			EObjectDAO.create(fragment, eClassID, resourceID);
		}
		catch (NotFoundInIndexException e) {
			log.error("EClass " + Strings.notNull(content.eClass().getName()) + " is not indexed.", e);
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
