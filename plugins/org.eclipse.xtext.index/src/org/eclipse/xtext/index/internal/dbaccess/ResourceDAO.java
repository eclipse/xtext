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

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class ResourceDAO {

	private static PreparedStatement selectIDByResource;
	private static PreparedStatement selectIDByPath;
	private static PreparedStatement selectAllResourceURIs;

	static {
		try {
			selectIDByResource = IndexDatabase
					.getInstance()
					.prepareStatements(
							"SELECT Resource.id FROM Resource LEFT JOIN Container ON Container.id=Resource.container WHERE Resource.path=? AND Container.uri=?");
			selectIDByPath = IndexDatabase.getInstance().prepareStatements(
					"SELECT Resource.id FROM Resource WHERE path=? AND container=?");
			selectAllResourceURIs = IndexDatabase
					.getInstance()
					.prepareStatements(
							"SELECT Container.uri, Resource.path FROM Resource LEFT JOIN Container ON Resource.container=Container.id");
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public static int getID(Resource resource) throws SQLException, NotFoundInIndexException {
		URI uri = resource.getURI();
		String uriAsString = uri.toString();
		int containerURILength = ResourceContainerDAO.getContainerURILength(uri);
		String containerURI = uriAsString.substring(0, containerURILength);
		String path = uriAsString.substring(containerURILength + 1);
		selectIDByResource.setString(1, path);
		selectIDByResource.setString(2, containerURI);
		return IndexDatabase.getInstance().queryID(selectIDByResource);
	}

	public static int getID(String path, int containerID) throws SQLException, NotFoundInIndexException {
		if (path.startsWith("/")) {
			path = path.substring(1);
		}
		selectIDByPath.setString(1, path);
		selectIDByPath.setInt(2, containerID);
		return IndexDatabase.getInstance().queryID(selectIDByPath);
	}

	public static int create(Resource resource, int containerID) throws SQLException {
		URI uri = resource.getURI();
		return create(uri, containerID);
	}

	public static int create(URI uri, int containerID) throws SQLException {
		if (uri.isPlatform() && uri.segmentCount() > 2) {
			String uriAsString = uri.toString();
			int containerURILength = ResourceContainerDAO.getContainerURILength(uri);
			String path = uriAsString.substring(containerURILength + 1);
			return create(path, containerID);
		}
		throw new IllegalArgumentException("Only platform URIs are supported");
	}

	public static int create(String path, int containerID) throws SQLException {
		if (path.startsWith("/")) {
			path = path.substring(1);
		}
		StringBuffer insertStatementBuffer = new StringBuffer("INSERT INTO Resource(path, container) VALUES('");
		insertStatementBuffer.append(path);
		insertStatementBuffer.append("',");
		insertStatementBuffer.append(containerID);
		insertStatementBuffer.append(")");
		return IndexDatabase.getInstance().insertWithAutoID(insertStatementBuffer.toString());
	}

	public static List<URI> findAllResources() throws SQLException {
		ResultSet result = null;
		try {
			result = selectAllResourceURIs.executeQuery();
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
		finally {
			if (result != null) {
				result.close();
			}
		}
	}

}
