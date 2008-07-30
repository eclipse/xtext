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
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class EObjectDAO {

	private static final Logger log = Logger.getLogger(EObjectDAO.class);
	private static PreparedStatement selectURIByEClass;
	private static PreparedStatement selectIDByEObject;
	private static PreparedStatement createCrossReference;
	private static PreparedStatement selectURIByCrossReferenceTarget;
	private static PreparedStatement selectFragmentsByResource;
	private static PreparedStatement deleteByFragmentAndResource;
	private static PreparedStatement deleteReferencesBySource;

	static {
		try {
			selectIDByEObject = IndexDatabase.getInstance().prepareStatements(
					"SELECT EObject.id FROM EObject WHERE EObject.fragment=? AND EObject.resource=?");
			selectURIByEClass = IndexDatabase
					.getInstance()
					.prepareStatements(
							"SELECT Container.uri, Resource.path, EObject.fragment FROM EObject, Resource, Container WHERE EObject.eClass=? AND EObject.resource=Resource.id AND Resource.container=Container.id");
			createCrossReference = IndexDatabase.getInstance().prepareStatements(
					"INSERT INTO CrossReference(source,target) VALUES(?,?)");
			selectURIByCrossReferenceTarget = IndexDatabase
					.getInstance()
					.prepareStatements(
							"SELECT Container.uri, Resource.path, EObject.fragment FROM CrossReference, EObject, Resource, Container WHERE CrossReference.target=? AND CrossReference.source=EObject.id AND EObject.resource=Resource.id AND Resource.container=Container.id");
			selectFragmentsByResource = IndexDatabase.getInstance().prepareStatements(
					"SELECT fragment FROM EObject WHERE resource=?");
			deleteByFragmentAndResource = IndexDatabase.getInstance().prepareStatements(
					"DELETE FROM EObject WHERE id=?");
			deleteReferencesBySource = IndexDatabase.getInstance().prepareStatements(
				"DELETE FROM CrossReference WHERE source=?");
		}
		catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	public static int getID(EObject eObject) throws SQLException, NotFoundInIndexException {
		Resource resource = eObject.eResource();
		if (resource == null) {
			throw new NotFoundInIndexException("EObject must be in a resource in order to get ID");
		}
		String fragment = resource.getURIFragment(eObject);
		int resourceID = ResourceDAO.getID(resource);
		return getID(fragment, resourceID);
	}

	public static int getID(String fragment, int resourceID) throws SQLException, NotFoundInIndexException {
		selectIDByEObject.setString(1, fragment);
		selectIDByEObject.setInt(2, resourceID);
		return IndexDatabase.getInstance().queryID(selectIDByEObject);
	}

	public static List<URI> findByEClass(EClass eClass) throws SQLException, NotFoundInIndexException {
		int eClassID = EClassDAO.getID(eClass);
		ResultSet result = null;
		try {
			selectURIByEClass.setInt(1, eClassID);
			result = selectURIByEClass.executeQuery();
			List<URI> uris = createURIsFromResult(result);
			return uris;
		}
		finally {
			if (result != null) {
				result.close();
			}
		}
	}

	private static List<URI> createURIsFromResult(ResultSet result) throws SQLException {
		List<URI> uris = new ArrayList<URI>();
		while (result.next()) {
			StringBuffer uriBuffer = new StringBuffer();
			uriBuffer.append(result.getString(1));
			uriBuffer.append('/');
			uriBuffer.append(result.getString(2));
			uriBuffer.append('#');
			uriBuffer.append(result.getString(3));
			URI uri = URI.createURI(uriBuffer.toString());
			uris.add(uri);
		}
		return uris;
	}

	public static int create(String fragment, int eClassID, int resourceID) throws SQLException {
		StringBuffer insertStatementBuffer = new StringBuffer(
				"INSERT INTO EObject(fragment, eClass, resource) VALUES('");
		insertStatementBuffer.append(fragment);
		insertStatementBuffer.append("',");
		insertStatementBuffer.append(eClassID);
		insertStatementBuffer.append(",");
		insertStatementBuffer.append(resourceID);
		insertStatementBuffer.append(")");
		return IndexDatabase.getInstance().insertWithAutoID(insertStatementBuffer.toString());
	}

	public static void createCrossReference(int sourceID, int targetID) throws SQLException {
		createCrossReference.setInt(1, sourceID);
		createCrossReference.setInt(2, targetID);
		createCrossReference.execute();
	}

	public static List<URI> findReferencesTo(EObject eObject) throws SQLException {
		try {
			int eObjectID = EObjectDAO.getID(eObject);
			return findReferencesTo(eObjectID);
		}
		catch (NotFoundInIndexException e) {
			log.warn("EObject is not indexed");
			return Collections.emptyList();
		}
	}

	public static List<URI> findReferencesTo(int eObjectID) throws SQLException {
		ResultSet result = null;
		try {
			selectURIByCrossReferenceTarget.setInt(1, eObjectID);
			result = selectURIByCrossReferenceTarget.executeQuery();
			List<URI> uris = createURIsFromResult(result);
			return uris;
		}
		finally {
			if (result != null) {
				result.close();
			}
		}
	}

	public static List<String> findFragmentsInResource(int resourceID) throws SQLException {
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

	public static void delete(int eObjectID) throws SQLException {
		deleteReferencesBySource.setInt(1, eObjectID);
		deleteReferencesBySource.executeUpdate();
		deleteByFragmentAndResource.setInt(1, eObjectID);
		deleteByFragmentAndResource.executeUpdate();
	}
}
