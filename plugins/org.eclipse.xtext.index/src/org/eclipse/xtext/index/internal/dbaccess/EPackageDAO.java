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
import java.sql.SQLException;

import org.eclipse.emf.ecore.EPackage;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class EPackageDAO {

	private IndexDatabase indexDatabase;

	private PreparedStatement selectIDByEPackage;
	private PreparedStatement deleteEPackageByID;

	public EPackageDAO(IndexDatabase indexDatabase){
		try {
			this.indexDatabase = indexDatabase;
			selectIDByEPackage = indexDatabase.prepareStatements("SELECT id FROM EPackage WHERE nsURI=?");
			deleteEPackageByID = indexDatabase.prepareStatements("DELETE FROM EPackage WHERE id=?");
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public int getID(EPackage ePackage) throws SQLException, NotFoundInIndexException {
		selectIDByEPackage.setString(1, ePackage.getNsURI());
		return indexDatabase.queryID(selectIDByEPackage);
	}
	
	public int create(EPackage ePackage) throws SQLException {
		StringBuffer insertStatementBuffer = new StringBuffer("INSERT INTO EPackage(nsURI) values('");
		insertStatementBuffer.append(ePackage.getNsURI());
		insertStatementBuffer.append("')");
		return indexDatabase.insertWithAutoID(insertStatementBuffer.toString());
	}
	
	public void delete(int ePackageID) throws SQLException {
		deleteEPackageByID.setInt(1, ePackageID);
		deleteEPackageByID.executeUpdate();
	}

}
