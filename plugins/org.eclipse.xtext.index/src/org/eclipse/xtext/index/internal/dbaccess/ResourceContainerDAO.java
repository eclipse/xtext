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

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.index.internal.URIUtil;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class ResourceContainerDAO {

	private static final Logger log = Logger.getLogger(ResourceContainerDAO.class);

	private IndexDatabase indexDatabase;

	private PreparedStatement insertEntry;
	private PreparedStatement selectIDByURI;
	private PreparedStatement deleteContainerByID;
	private PreparedStatement selectAllContainerIDs;

	public ResourceContainerDAO(IndexDatabase indexDatabase) {
		try {
			this.indexDatabase = indexDatabase;
			insertEntry = indexDatabase.prepareStatements("INSERT INTO Container(id, uri) VALUES(?,?)");
			selectIDByURI = indexDatabase.prepareStatements("SELECT Container.id FROM Container WHERE uri=?");
			selectAllContainerIDs = indexDatabase.prepareStatements("SELECT id FROM Container");
			deleteContainerByID = indexDatabase.prepareStatements("DELETE FROM Container WHERE id=?");
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public int getID(String uri) throws SQLException, NotFoundInIndexException {
		selectIDByURI.setString(1, URIUtil.trimTrailingSlash(uri));
		return indexDatabase.queryID(selectIDByURI);
	}

	public int create(URI platformURI) throws SQLException {
		String uriAsString = platformURI.toString();
		return create(uriAsString.substring(0, getContainerURILength(platformURI)));
	}

	public int create(String uri) throws SQLException {
		int id = indexDatabase.nextUniqueID();
		insertEntry.setInt(1, id);
		insertEntry.setString(2, URIUtil.trimTrailingSlash(uri));
		insertEntry.executeUpdate();
		return id;
//		StringBuffer insertStatementBuffer = new StringBuffer("INSERT INTO Container(uri) VALUES('");
//		insertStatementBuffer.append(URIUtil.trimTrailingSlash(uri));
//		insertStatementBuffer.append("')");
//		return indexDatabase.insertWithAutoID(insertStatementBuffer.toString());
	}

	public List<Integer> findAllResourceContainerIDs() throws SQLException {
		ResultSet result = null;
		try {
			result = selectAllContainerIDs.executeQuery();
			List<Integer> ids = new ArrayList<Integer>();
			while (result.next()) {
				ids.add(result.getInt(1));
			}
			return ids;
		}
		finally {
			if (result != null) {
				result.close();
			}
		}
	}

	public List<Integer> findResourceContainerScope(int resourceContainerID) throws SQLException {
		List<URI> dependencyURIs = indexDatabase.getResourceContainerReferenceDAO().findDependencyURIs(
				resourceContainerID);
		List<Integer> dependencyIDs = new ArrayList<Integer>();
		dependencyIDs.add(resourceContainerID);
		for (int i = 0; i < dependencyURIs.size(); ++i) {
			try {
				int dependencyID = getID(dependencyURIs.get(i).toString());
				if (!dependencyIDs.contains(dependencyID)) {
					List<Integer> nextStageDependencyIDs = findResourceContainerScope(dependencyID);
					nextStageDependencyIDs.removeAll(dependencyIDs);
					dependencyIDs.addAll(nextStageDependencyIDs);
				}
			}
			catch (NotFoundInIndexException e) {
				log.error("Resource container not in index " + dependencyURIs.get(i).toString(), e);
			}
		}
		return dependencyIDs;
	}

	public int getContainerURILength(URI resourceURI) {
		String uriAsString = resourceURI.toString();
		if (resourceURI.isPlatform()) {
			return uriAsString.indexOf('/', resourceURI.segment(0).length() + 11);
		}
		else {
			return uriAsString.indexOf("!/") + 1;
		}
	}

	/**
	 * @param resourceContainerID
	 * @throws SQLException
	 */
	public void delete(int resourceContainerID) throws SQLException {
		deleteContainerByID.setInt(1, resourceContainerID);
		deleteContainerByID.executeUpdate();
	}

}
