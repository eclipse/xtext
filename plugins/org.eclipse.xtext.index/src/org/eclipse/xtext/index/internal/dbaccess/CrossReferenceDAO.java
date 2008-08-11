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
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class CrossReferenceDAO {

	private final Logger log = Logger.getLogger(EObjectDAO.class);

	private PreparedStatement createCrossReference;
	private PreparedStatement selectURIByCrossReferenceTarget;

	private IndexDatabase indexDatabase;


	public CrossReferenceDAO(IndexDatabase indexDatabase) {
		try {
			this.indexDatabase = indexDatabase;
			createCrossReference = indexDatabase.prepareStatements(
				"INSERT INTO CrossReference(source,target) VALUES(?,?)");
			selectURIByCrossReferenceTarget = indexDatabase
					.prepareStatements("SELECT Container.uri, Resource.path, EObject.fragment FROM CrossReference, EObject, Resource, Container WHERE CrossReference.target=? AND CrossReference.source=EObject.id AND EObject.resource=Resource.id AND Resource.container=Container.id");
		}
		catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	public List<URI> findReferencesTo(EObject eObject) throws SQLException {
		return findReferencesTo(EcoreUtil.getURI(eObject));
	}
		
	public List<URI> findReferencesTo(URI uri) throws SQLException {
		return findReferencesTo(uri.toString());
	}

	public List<URI> findReferencesTo(String eObjectURI) throws SQLException {
		
		
		ResultSet result = null;
		try {
			selectURIByCrossReferenceTarget.setString(1, eObjectURI);
			result = selectURIByCrossReferenceTarget.executeQuery();
			List<URI> uris = indexDatabase.createURIsFromResult(result);
			return uris;
		}
		finally {
			if (result != null) {
				result.close();
			}
		}
	}

	public void create(int sourceID, String targetID) throws SQLException {
		createCrossReference.setInt(1, sourceID);
		createCrossReference.setString(2, targetID);
		createCrossReference.execute();
	}

}
