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

	private static PreparedStatement selectIDByEClass;
	private static PreparedStatement selectEClassesByEPackage;
	private static PreparedStatement deleteEClassByName;

	static {
		try {
			selectIDByEClass = IndexDatabase.getInstance().prepareStatements(
					"SELECT EClass.id FROM EClass, EPackage WHERE EClass.name=? AND EPackage.nsUri=?");
			selectEClassesByEPackage = IndexDatabase.getInstance().prepareStatements(
					"SELECT name FROM EClass WHERE ePackage=?");
			deleteEClassByName = IndexDatabase.getInstance().prepareStatements("DELETE FROM EClass WHERE name=?");
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public static int getID(EClass eClass) throws SQLException, NotFoundInIndexException {
		selectIDByEClass.setString(1, eClass.getName());
		selectIDByEClass.setString(2, eClass.getEPackage().getNsURI());
		return IndexDatabase.getInstance().queryID(selectIDByEClass);
	}

	public static int create(EClass eClass, int ePackageID) throws SQLException {
		StringBuffer insertStatementBuffer = new StringBuffer("INSERT INTO EClass(name, ePackage) values('");
		insertStatementBuffer.append(eClass.getName());
		insertStatementBuffer.append("',");
		insertStatementBuffer.append(ePackageID);
		insertStatementBuffer.append(")");
		return IndexDatabase.getInstance().insertWithAutoID(insertStatementBuffer.toString());
	}

	public static List<String> findAllEClassNames(int ePackageID) throws SQLException {
		selectEClassesByEPackage.setInt(1, ePackageID);
		ResultSet result = null;
		try {
			result = selectEClassesByEPackage.executeQuery();
			List<String> eClasses = new ArrayList<String>();
			while(result.next()) {
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

	public static void delete(String staleEClassName) throws SQLException {
		deleteEClassByName.setString(1, staleEClassName);
		deleteEClassByName.execute();
	}
}
