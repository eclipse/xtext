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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.index.internal.URIUtil;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class CrossReferenceDAO {

	private PreparedStatement createCrossReference;
	private PreparedStatement selectSourceURIByCrossReferenceTarget;

	private IndexDatabase indexDatabase;

	private PreparedStatement deleteReferencesBySource;
	private PreparedStatement selectTargetURIByCrossReferenceSource;
	private PreparedStatement deleteReferencesBySourceAndTarget;
	private PreparedStatement selectSourceURIByCrossReferenceTargetAndContainerID;

	public CrossReferenceDAO(IndexDatabase indexDatabase) {
		try {
			this.indexDatabase = indexDatabase;
			createCrossReference = indexDatabase
					.prepareStatements("INSERT INTO CrossReference(source,target) VALUES(?,?)");
			selectTargetURIByCrossReferenceSource = indexDatabase
					.prepareStatements("SELECT target FROM CrossReference WHERE source=?");
			selectSourceURIByCrossReferenceTarget = indexDatabase
					.prepareStatements("SELECT Container.uri, Resource.path, EObject.fragment FROM CrossReference "
							+ "LEFT JOIN EObject ON CrossReference.source=EObject.id "
							+ "LEFT JOIN Resource ON EObject.resource=Resource.id "
							+ "LEFT JOIN Container ON Resource.container=Container.id "
							+ "WHERE CrossReference.target=?");
			selectSourceURIByCrossReferenceTargetAndContainerID = indexDatabase
					.prepareStatements("SELECT Container.uri, Resource.path, EObject.fragment FROM CrossReference "
							+ "LEFT JOIN EObject ON CrossReference.source=EObject.id "
							+ "LEFT JOIN Resource ON EObject.resource=Resource.id "
							+ "LEFT JOIN Container ON Resource.container=Container.id "
							+ "WHERE CrossReference.target=? AND Container.id=?");
			deleteReferencesBySource = indexDatabase.prepareStatements("DELETE FROM CrossReference WHERE source=?");
			deleteReferencesBySourceAndTarget = indexDatabase
					.prepareStatements("DELETE FROM CrossReference WHERE source=? AND target=?");
		}
		catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	public List<URI> findReferencesTo(EObject eObject) throws SQLException {
		return findReferencesTo(URIUtil.getURI(eObject));
	}

	public List<URI> findReferencesTo(String eObjectURI) throws SQLException {
		ResultSet result = null;
		try {
			selectSourceURIByCrossReferenceTarget.setString(1, eObjectURI);
			result = selectSourceURIByCrossReferenceTarget.executeQuery();
			List<URI> uris = URIUtil.createURIsFromResult(result);
			return uris;
		}
		finally {
			if (result != null) {
				result.close();
			}
		}
	}

	public List<URI> findReferencesTo(String eObjectURI, int resourceContainerID) throws SQLException {
		ResultSet result = null;
		try {
			selectSourceURIByCrossReferenceTargetAndContainerID.setString(1, eObjectURI);
			selectSourceURIByCrossReferenceTargetAndContainerID.setInt(2, resourceContainerID);
			result = selectSourceURIByCrossReferenceTargetAndContainerID.executeQuery();
			List<URI> uris = URIUtil.createURIsFromResult(result);
			return uris;
		}
		finally {
			if (result != null) {
				result.close();
			}
		}
	}

	public List<URI> findReferencesFrom(int sourceID) throws SQLException {
		ResultSet result = null;
		try {
			selectTargetURIByCrossReferenceSource.setInt(1, sourceID);
			result = selectTargetURIByCrossReferenceSource.executeQuery();
			List<URI> uris = new ArrayList<URI>();
			while (result.next()) {
				uris.add(URI.createURI(result.getString(1)));
			}
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

	public void deleteBySource(int sourceID) throws SQLException {
		deleteReferencesBySource.setInt(1, sourceID);
		deleteReferencesBySource.executeUpdate();
	}

	public void deleteBySourceAndTarget(int sourceID, URI staleTargetURI) throws SQLException {
		deleteReferencesBySourceAndTarget.setInt(1, sourceID);
		deleteReferencesBySourceAndTarget.setString(2, staleTargetURI.toString());
		deleteReferencesBySourceAndTarget.executeUpdate();
	}

}
