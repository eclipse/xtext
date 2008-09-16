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

import org.eclipse.emf.ecore.EClass;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class EClassDAO {

	private IndexDatabase indexDatabase;

	private PreparedStatement insertEntry;
	private PreparedStatement selectIDByEClass;
	private PreparedStatement selectEClassesByEPackage;
	private PreparedStatement deleteEClassByID;
	private PreparedStatement deleteEClassByName;

	public EClassDAO(IndexDatabase indexDatabase) {
		try {
			this.indexDatabase = indexDatabase;
			insertEntry = indexDatabase.prepareStatements("INSERT INTO EClass(id, name, ePackage) values(?,?,?)");
			selectIDByEClass = indexDatabase.prepareStatements("SELECT EClass.id FROM EClass, EPackage "
					+ "WHERE EClass.name=? AND EPackage.nsUri=?");
			selectEClassesByEPackage = indexDatabase.prepareStatements("SELECT name FROM EClass WHERE ePackage=?");
			deleteEClassByID = indexDatabase.prepareStatements("DELETE FROM EClass WHERE id=?");
			deleteEClassByName = indexDatabase.prepareStatements("DELETE FROM EClass WHERE name=?");
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public int getID(EClass eClass) throws SQLException, NotFoundInIndexException {
		selectIDByEClass.setString(1, eClass.getName());
		selectIDByEClass.setString(2, eClass.getEPackage().getNsURI());
		return indexDatabase.queryID(selectIDByEClass);
	}

	public int create(EClass eClass, int ePackageID) throws SQLException {
		int id = indexDatabase.nextUniqueID();
		insertEntry.setInt(1, id);
		insertEntry.setString(2, eClass.getName());
		insertEntry.setInt(3, ePackageID);
		insertEntry.executeUpdate();
		return id;
		// StringBuffer insertStatementBuffer = new
		// StringBuffer("INSERT INTO EClass(name, ePackage) values('");
		// insertStatementBuffer.append(eClass.getName());
		// insertStatementBuffer.append("',");
		// insertStatementBuffer.append(ePackageID);
		// insertStatementBuffer.append(")");
		// return
		// indexDatabase.insertWithAutoID(insertStatementBuffer.toString());
	}

	public List<String> findAllEClassNames(int ePackageID) throws SQLException {
		selectEClassesByEPackage.setInt(1, ePackageID);
		ResultSet result = null;
		try {
			result = selectEClassesByEPackage.executeQuery();
			List<String> eClasses = new ArrayList<String>();
			while (result.next()) {
				eClasses.add(result.getString(1));
			}
			return eClasses;
		}
		finally {
			if (result != null) {
				result.close();
			}
		}
	}

	public void delete(int eClassID) throws SQLException {
		deleteEClassByID.setInt(1, eClassID);
		deleteEClassByID.execute();
	}

	public void delete(String staleEClassName) throws SQLException {
		deleteEClassByName.setString(1, staleEClassName);
		deleteEClassByName.execute();
	}

}
