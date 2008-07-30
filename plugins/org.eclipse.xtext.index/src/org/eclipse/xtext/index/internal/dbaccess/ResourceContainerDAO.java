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

	private static PreparedStatement selectReferences;
	private static PreparedStatement selectIDByURI;

	static {
		try {
			selectIDByURI = IndexDatabase.getInstance().prepareStatements(
					"SELECT Container.id FROM Container WHERE uri=?");
			selectReferences = IndexDatabase.getInstance().prepareStatements(
					"SELECT ContainerReference.target FROM ContainerReference WHERE source=?");
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public static int getID(String uri) throws SQLException, NotFoundInIndexException {
		selectIDByURI.setString(1, uri);
		return IndexDatabase.getInstance().queryID(selectIDByURI);
	}

	public static List<Integer> findDependencyIDs(int containerID) throws SQLException {
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

	public static int create(URI platformURI) throws SQLException {
		String uriAsString = platformURI.toString();
		return create(uriAsString.substring(0, getContainerURILength(platformURI)));
	}

	public static int create(String uri) throws SQLException {
		StringBuffer insertStatementBuffer = new StringBuffer("INSERT INTO Container(uri) VALUES('");
		insertStatementBuffer.append(uri);
		insertStatementBuffer.append("')");
		return IndexDatabase.getInstance().insertWithAutoID(insertStatementBuffer.toString());
	}

	public static void createReference(int from, int to) throws SQLException {
		StringBuffer insertStatementBuffer = new StringBuffer("INSERT INTO ContainerReference(source, target) VALUES(");
		insertStatementBuffer.append(from);
		insertStatementBuffer.append(",");
		insertStatementBuffer.append(to);
		insertStatementBuffer.append(")");
		IndexDatabase.getInstance().insertWithAutoID(insertStatementBuffer.toString());
	}

	public static int getContainerURILength(URI resourceURI) {
		String uriAsString = resourceURI.toString();
		if (resourceURI.isPlatform()) {
			return uriAsString.indexOf('/', resourceURI.segment(0).length() + 11);
		}
		else {
			return uriAsString.indexOf("!/") + 1;
		}
	}

}
