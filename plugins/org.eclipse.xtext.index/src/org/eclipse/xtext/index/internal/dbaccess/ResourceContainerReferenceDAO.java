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
import org.eclipse.xtext.index.internal.URIUtil;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class ResourceContainerReferenceDAO {

	private IndexDatabase indexDatabase;

	private PreparedStatement deleteReferenceBySource;

	private PreparedStatement selectReferences;

	private PreparedStatement deleteReferenceBySourceAndTarget;

	public ResourceContainerReferenceDAO(IndexDatabase indexDatabase) {
		try {
			this.indexDatabase = indexDatabase;
			selectReferences = indexDatabase
					.prepareStatements("SELECT ContainerReference.target FROM ContainerReference WHERE source=?");
			deleteReferenceBySource = indexDatabase.prepareStatements("DELETE FROM ContainerReference WHERE source=?");
			deleteReferenceBySourceAndTarget = indexDatabase.prepareStatements("DELETE FROM ContainerReference WHERE source=? and target=?");
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public List<URI> findDependencyURIs(int containerID) throws SQLException {
		ResultSet result = null;
		try {
			selectReferences.setInt(1, containerID);
			result = selectReferences.executeQuery();
			List<URI> dependencies = new ArrayList<URI>();
			while (result.next()) {
				dependencies.add(URIUtil.createResourceContainerURI(result.getString(1)));
			}
			return dependencies;
		}
		finally {
			if (result != null) {
				result.close();
			}
		}
	}

	public void create(int sourceContainerID, URI targetURI) throws SQLException {
		create(sourceContainerID, targetURI.toString());
	}
	
	public void create(int sourceContainerID, String targetURI) throws SQLException {
		StringBuffer insertStatementBuffer = new StringBuffer("INSERT INTO ContainerReference(source, target) VALUES(");
		insertStatementBuffer.append(sourceContainerID);
		insertStatementBuffer.append(",'");
		insertStatementBuffer.append(URIUtil.trimTrailingSlash(targetURI));
		insertStatementBuffer.append("')");
		indexDatabase.insertWithAutoID(insertStatementBuffer.toString());
	}
	
	public void deleteBySource(int sourceContainerID) throws SQLException {
		deleteReferenceBySource.setInt(1, sourceContainerID);
		deleteReferenceBySource.execute();
	}
	
	public void deleteBySourceAndTarget(int resourceContainerID, URI targetURI) throws SQLException {
		deleteReferenceBySourceAndTarget.setInt(1, resourceContainerID);
		deleteReferenceBySourceAndTarget.setString(2, URIUtil.trimTrailingSlash(targetURI));
		deleteReferenceBySourceAndTarget.execute();
	}
}
