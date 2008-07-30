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

	private static PreparedStatement selectURIByEClass;
	private static PreparedStatement selectIDByEObject;

	static {
		try {
			selectIDByEObject = IndexDatabase.getInstance()
					.prepareStatements("SELECT EObject.id FROM EObject WHERE EObject.fragment=? AND EObject.resource=?");
			selectURIByEClass = IndexDatabase.getInstance()
					.prepareStatements("SELECT Container.uri, Resource.path, EObject.fragment FROM EObject, Resource, Container WHERE EObject.eClass=? AND EObject.resource=Resource.id AND Resource.container=Container.id");
		}
		catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	public static int getID(EObject eObject) throws SQLException, NotFoundInIndexException {
		Resource resource = eObject.eResource();
		if (resource == null) {
			throw new IllegalArgumentException("EObject must be in a resource in order to get ID");
		}
		String fragment = resource.getURIFragment(eObject);
		int resourceID = ResourceDAO.getID(resource);
		selectIDByEObject.setString(1, fragment);
		selectIDByEObject.setInt(2, resourceID);
		return IndexDatabase.getInstance().queryID(selectIDByEObject);
	}

	public static List<URI> findByEClass(EClass eClass) throws SQLException, NotFoundInIndexException {
		int eClassID = EClassDAO.getID(eClass);
		List<URI> uris = new ArrayList<URI>();
		ResultSet result = null;
		try {
			selectURIByEClass.setInt(1, eClassID);
			result = selectURIByEClass.executeQuery();
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
		finally {
			if (result != null) {
				result.close();
			}
		}
	}

	public static int create(String fragment, int eClassID, int resourceID) throws SQLException {
		StringBuffer insertStatementBuffer = new StringBuffer("INSERT INTO EObject(fragment, eClass, resource) VALUES('");
		insertStatementBuffer.append(fragment);
		insertStatementBuffer.append("',");
		insertStatementBuffer.append(eClassID);
		insertStatementBuffer.append(",");
		insertStatementBuffer.append(resourceID);
		insertStatementBuffer.append(")");
		return IndexDatabase.getInstance().insertWithAutoID(insertStatementBuffer.toString());
	}

}
