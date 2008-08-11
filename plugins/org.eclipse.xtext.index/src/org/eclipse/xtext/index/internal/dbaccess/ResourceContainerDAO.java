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

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class ResourceContainerDAO {

	private IndexDatabase indexDatabase;

	private PreparedStatement selectReferences;
	private PreparedStatement selectIDByURI;

	public ResourceContainerDAO(IndexDatabase indexDatabase) {
		try {
			this.indexDatabase = indexDatabase;
			selectIDByURI = indexDatabase.prepareStatements(
					"SELECT Container.id FROM Container WHERE uri=?");
			selectReferences = indexDatabase.prepareStatements(
					"SELECT ContainerReference.target FROM ContainerReference WHERE source=?");
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public int getID(String uri) throws SQLException, NotFoundInIndexException {
		selectIDByURI.setString(1, uri);
		return indexDatabase.queryID(selectIDByURI);
	}

	public List<Integer> findDependencyIDs(int containerID) throws SQLException {
		ResultSet result = null;
		try {
			selectReferences.setInt(1, containerID);
			result = selectReferences.executeQuery();
			List<Integer> dependencies = new ArrayList<Integer>();
			while (result.next()) {
				dependencies.add(result.getInt(1));
			}
			return dependencies;
		}
		finally {
			if (result != null) {
				result.close();
			}
		}
	}

	public int create(URI platformURI) throws SQLException {
		String uriAsString = platformURI.toString();
		return create(uriAsString.substring(0, getContainerURILength(platformURI)));
	}

	public int create(String uri) throws SQLException {
		StringBuffer insertStatementBuffer = new StringBuffer("INSERT INTO Container(uri) VALUES('");
		insertStatementBuffer.append(uri);
		insertStatementBuffer.append("')");
		return indexDatabase.insertWithAutoID(insertStatementBuffer.toString());
	}

	public void createReference(int from, int to) throws SQLException {
		StringBuffer insertStatementBuffer = new StringBuffer("INSERT INTO ContainerReference(source, target) VALUES(");
		insertStatementBuffer.append(from);
		insertStatementBuffer.append(",");
		insertStatementBuffer.append(to);
		insertStatementBuffer.append(")");
		indexDatabase.insertWithAutoID(insertStatementBuffer.toString());
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

}
