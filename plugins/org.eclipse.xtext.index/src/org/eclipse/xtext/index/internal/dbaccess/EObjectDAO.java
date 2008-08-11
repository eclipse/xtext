/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index.internal.dbaccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class EObjectDAO {

	private IndexDatabase indexDatabase;

	private PreparedStatement selectURIByEClass;
	private PreparedStatement selectIDByEObject;

	private PreparedStatement selectFragmentsByResource;
	private PreparedStatement deleteByFragmentAndResource;
	private PreparedStatement deleteReferencesBySource;

	public EObjectDAO(IndexDatabase indexDatabase) {
		try {
			this.indexDatabase = indexDatabase;
			selectIDByEObject = indexDatabase.prepareStatements(
					"SELECT EObject.id FROM EObject WHERE EObject.fragment=? AND EObject.resource=?");
			selectURIByEClass = indexDatabase
					.prepareStatements(
							"SELECT Container.uri, Resource.path, EObject.fragment FROM EObject, Resource, Container WHERE EObject.eClass=? AND EObject.resource=Resource.id AND Resource.container=Container.id");
			selectFragmentsByResource = indexDatabase.prepareStatements(
					"SELECT fragment FROM EObject WHERE resource=?");
			deleteByFragmentAndResource = indexDatabase.prepareStatements(
					"DELETE FROM EObject WHERE id=?");
			deleteReferencesBySource = indexDatabase.prepareStatements(
					"DELETE FROM CrossReference WHERE source=?");
		}
		catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	public int getID(EObject eObject) throws SQLException, NotFoundInIndexException {
		Resource resource = eObject.eResource();
		if (resource == null) {
			throw new NotFoundInIndexException("EObject must be in a resource in order to get ID");
		}
		String fragment = resource.getURIFragment(eObject);
		int resourceID = indexDatabase.getResourceDAO().getID(resource);
		return getID(fragment, resourceID);
	}

	public int getID(String fragment, int resourceID) throws SQLException, NotFoundInIndexException {
		selectIDByEObject.setString(1, fragment);
		selectIDByEObject.setInt(2, resourceID);
		return indexDatabase.queryID(selectIDByEObject);
	}

	public List<URI> findByEClass(EClass eClass) throws SQLException, NotFoundInIndexException {
		int eClassID = indexDatabase.getEClassDAO().getID(eClass);
		ResultSet result = null;
		try {
			selectURIByEClass.setInt(1, eClassID);
			result = selectURIByEClass.executeQuery();
			List<URI> uris = indexDatabase.createURIsFromResult(result);
			return uris;
		}
		finally {
			if (result != null) {
				result.close();
			}
		}
	}

	public int create(String fragment, int eClassID, int resourceID) throws SQLException {
		StringBuffer insertStatementBuffer = new StringBuffer(
				"INSERT INTO EObject(fragment, eClass, resource) VALUES('");
		insertStatementBuffer.append(fragment);
		insertStatementBuffer.append("',");
		insertStatementBuffer.append(eClassID);
		insertStatementBuffer.append(",");
		insertStatementBuffer.append(resourceID);
		insertStatementBuffer.append(")");
		return indexDatabase.insertWithAutoID(insertStatementBuffer.toString());
	}


	public List<String> findFragmentsInResource(int resourceID) throws SQLException {
		selectFragmentsByResource.setInt(1, resourceID);
		ResultSet result = null;
		try {
			result = selectFragmentsByResource.executeQuery();
			List<String> entries = new ArrayList<String>();
			while (result.next()) {
				entries.add(result.getString(1));
			}
			return entries;
		}
		finally {
			if (result != null) {
				result.close();
			}
		}
	}

	public void deleteEObjectAndCrossrefs(int eObjectID) throws SQLException {
		deleteReferencesBySource.setInt(1, eObjectID);
		deleteReferencesBySource.executeUpdate();
		deleteByFragmentAndResource.setInt(1, eObjectID);
		deleteByFragmentAndResource.executeUpdate();
	}
	
	
}
