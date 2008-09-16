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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.index.internal.URIUtil;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class ResourceDAO {

	private IndexDatabase indexDatabase;

	private PreparedStatement insertEntry;
	private PreparedStatement selectIDByResource;
	private PreparedStatement selectIDByPath;
	private PreparedStatement selectAllResourceURIs;
	private PreparedStatement selectResourceURIsByContainer;
	private PreparedStatement deleteResourceByID;

	public ResourceDAO(IndexDatabase indexDatabase) {
		try {
			this.indexDatabase = indexDatabase;
			insertEntry = indexDatabase.prepareStatements("INSERT INTO Resource(id, path, container) VALUES(?,?,?)");
			selectIDByResource = indexDatabase
					.prepareStatements("SELECT Resource.id FROM Resource LEFT JOIN Container ON Container.id=Resource.container WHERE Resource.path=? AND Container.uri=?");
			selectIDByPath = indexDatabase
					.prepareStatements("SELECT Resource.id FROM Resource WHERE path=? AND container=?");
			selectAllResourceURIs = indexDatabase
					.prepareStatements("SELECT Container.uri, Resource.path FROM Resource LEFT JOIN Container ON Resource.container=Container.id");
			selectResourceURIsByContainer = indexDatabase
					.prepareStatements("SELECT Container.uri, Resource.path FROM Resource LEFT JOIN Container ON Resource.container=Container.id WHERE Container.id=?");
			deleteResourceByID = indexDatabase.prepareStatements("DELETE FROM Resource WHERE id=?");
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public int getID(URI resourceURI) throws SQLException, NotFoundInIndexException {
		String uriAsString = resourceURI.toString();
		int containerURILength = indexDatabase.getResourceContainerDAO().getContainerURILength(resourceURI);
		String containerURI = uriAsString.substring(0, containerURILength);
		String path = uriAsString.substring(containerURILength + 1);
		selectIDByResource.setString(1, path);
		selectIDByResource.setString(2, containerURI);
		return indexDatabase.queryID(selectIDByResource);
	}
		
	public int getID(Resource resource) throws SQLException, NotFoundInIndexException {
		URI resourceURI = resource.getURI();
		return getID(resourceURI);
	}

	public int getID(String path, int containerID) throws SQLException, NotFoundInIndexException {
		selectIDByPath.setString(1, URIUtil.trimLeadingSlash(path));
		selectIDByPath.setInt(2, containerID);
		return indexDatabase.queryID(selectIDByPath);
	}

	public int create(Resource resource, int containerID) throws SQLException {
		URI uri = resource.getURI();
		return create(uri, containerID);
	}

	public int create(URI uri, int containerID) throws SQLException {
		if (uri.isPlatform() && uri.segmentCount() > 2) {
			String uriAsString = uri.toString();
			int containerURILength = indexDatabase.getResourceContainerDAO().getContainerURILength(uri);
			String path = uriAsString.substring(containerURILength + 1);
			return create(path, containerID);
		}
		throw new IllegalArgumentException("Only platform URIs are supported");
	}

	public int create(String path, int containerID) throws SQLException {
		int id = indexDatabase.nextUniqueID();
		insertEntry.setInt(1, id);
		insertEntry.setString(2, URIUtil.trimLeadingSlash(path));
		insertEntry.setInt(3, containerID);
		insertEntry.executeUpdate();
		return id;
//		StringBuffer insertStatementBuffer = new StringBuffer("INSERT INTO Resource(path, container) VALUES('");
//		insertStatementBuffer.append(URIUtil.trimLeadingSlash(path));
//		insertStatementBuffer.append("',");
//		insertStatementBuffer.append(containerID);
//		insertStatementBuffer.append(")");
//		return indexDatabase.insertWithAutoID(insertStatementBuffer.toString());
	}

	public List<URI> findAllResources() throws SQLException {
		ResultSet result = null;
		try {
			result = selectAllResourceURIs.executeQuery();
			List<URI> uris = createResourceURIsFromResult(result);
			return uris;
		}
		finally {
			if (result != null) {
				result.close();
			}
		}
	}

	public List<URI> findByContainer(int resourceContainerID) throws SQLException {
		ResultSet result = null;
		try {
			selectResourceURIsByContainer.setInt(1, resourceContainerID);
			result = selectResourceURIsByContainer.executeQuery();
			List<URI> uris = createResourceURIsFromResult(result);
			return uris;
		}
		finally {
			if (result != null) {
				result.close();
			}
		}
	}

	public void delete(int resourceID) throws SQLException {
		deleteResourceByID.setInt(1, resourceID);
		deleteResourceByID.executeUpdate();
	}

	private List<URI> createResourceURIsFromResult(ResultSet result) throws SQLException {
		List<URI> uris = new ArrayList<URI>();
		while (result.next()) {
			StringBuffer uriBuffer = new StringBuffer();
			uriBuffer.append(result.getString(1));
			uriBuffer.append('/');
			uriBuffer.append(result.getString(2));
			URI uri = URI.createURI(uriBuffer.toString());
			uris.add(uri);
		}
		return uris;
	}

}
