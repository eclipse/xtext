/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index.internal;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.index.IModelIndex;
import org.eclipse.xtext.index.internal.dbaccess.IndexDatabase;
import org.eclipse.xtext.index.internal.dbaccess.NotFoundInIndexException;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class ModelIndex implements IModelIndex, IResourceChangeListener {

	private static Logger log = Logger.getLogger(ModelIndex.class);
	private IndexDatabase indexDatabase;
	private WorkspaceModelIndexer workspaceModelIndexer;
	private EcoreRegistryIndexer ecoreRegistryIndexer;
	
	private ResourceDeltaVisitor resourceDeltaVisitor;

	public ModelIndex(boolean isRegisterEPackages) {
		indexDatabase = new IndexDatabase();
		workspaceModelIndexer = new WorkspaceModelIndexer(indexDatabase);
		ecoreRegistryIndexer = new EcoreRegistryIndexer(indexDatabase);
		if (isRegisterEPackages) {
			ecoreRegistryIndexer.indexRegisteredEPackages();
		}
		resourceDeltaVisitor = new ResourceDeltaVisitor(workspaceModelIndexer);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}

	public boolean exists(URI fragmentURI) {
		int containerURILength = indexDatabase.getResourceContainerDAO().getContainerURILength(fragmentURI);
		String resourceUriAsString = fragmentURI.trimFragment().toString();
		String containerURI = resourceUriAsString.substring(0, containerURILength);
		String path = resourceUriAsString.substring(containerURILength + 1);
		String fragment = fragmentURI.fragment();
		try {
			int containerID = indexDatabase.getResourceContainerDAO().getID(containerURI);
			int resourceID = indexDatabase.getResourceDAO().getID(path, containerID);
			indexDatabase.getEObjectDAO().getID(fragment, resourceID);
			return true;
		} catch(NotFoundInIndexException exc) {
			// does not exist
		} catch(SQLException sqlExc) {
			log.error(sqlExc);
		}
		return false;
	}

	public List<URI> findReferencesTo(EObject eObject, IProject scope) {
		try {
			return indexDatabase.getCrossReferenceDAO().findReferencesTo(eObject);
		}
		catch (Exception e) {
			log.error(e);
		}
		return Collections.<URI> emptyList();
	}

	public List<URI> findInstances(EClass eClass, IProject scope) {
		try {
			return indexDatabase.getEObjectDAO().findByEClass(eClass);
		}
		catch (Exception e) {
			log.error(e);
		}
		return Collections.<URI> emptyList();
	}

	/**
	 * @return the ecoreRegistryIndexer
	 */
	public EcoreRegistryIndexer getEcoreRegistryIndexer() {
		return ecoreRegistryIndexer;
	}
	
	/**
	 * @return the workspaceModelIndexer
	 */
	public WorkspaceModelIndexer getWorkspaceModelIndexer() {
		return workspaceModelIndexer;
	}
	
	public void resourceChanged(IResourceChangeEvent event) {
		try {
			event.getDelta().accept(resourceDeltaVisitor);
		}
		catch (CoreException exc) {
			log.error("Error indexing models", exc);
		}
	}
	
	public void clearAll() throws Exception {
		indexDatabase.clearAll();
	}
	
	public void shutdown() throws Exception {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		indexDatabase.shutdown();
	}
}
