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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.index.IModelIndex;
import org.eclipse.xtext.index.internal.dbaccess.EObjectDAO;
import org.eclipse.xtext.index.internal.dbaccess.NotFoundInIndexException;
import org.eclipse.xtext.index.internal.dbaccess.ResourceContainerDAO;
import org.eclipse.xtext.index.internal.dbaccess.ResourceDAO;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class ModelIndex implements IModelIndex{

	private static Logger log = Logger.getLogger(ModelIndex.class);
	private WorkspaceModelIndexer workspaceModelIndexer;
	private EcoreRegistryIndexer ecoreRegistryIndexer;
	
	public ModelIndex(boolean isRegisterEPackages) throws Exception {
		workspaceModelIndexer = new WorkspaceModelIndexer();
		ecoreRegistryIndexer = new EcoreRegistryIndexer();
		if (isRegisterEPackages) {
			ecoreRegistryIndexer.indexRegisteredEPackages();
		}
	}

	public boolean exists(URI fragmentURI) {
		int containerURILength = ResourceContainerDAO.getContainerURILength(fragmentURI);
		String resourceUriAsString = fragmentURI.trimFragment().toString();
		String containerURI = resourceUriAsString.substring(0, containerURILength);
		String path = resourceUriAsString.substring(containerURILength + 1);
		String fragment = fragmentURI.fragment();
		try {
			int containerID = ResourceContainerDAO.getID(containerURI);
			int resourceID = ResourceDAO.getID(path, containerID);
			EObjectDAO.getID(fragment, resourceID);
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
			return EObjectDAO.findReferencesTo(eObject);
		}
		catch (Exception e) {
			log.error(e);
		}
		return Collections.<URI> emptyList();
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
}
