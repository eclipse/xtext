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

	private static PreparedStatement selectIDByEPackage;

	static {
		try {
			selectIDByEPackage = IndexDatabase.getInstance().prepareStatements("SELECT id FROM EPackage WHERE nsURI=?");
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public static int getID(EPackage ePackage) throws SQLException, NotFoundInIndexException {
		selectIDByEPackage.setString(1, ePackage.getNsURI());
		return IndexDatabase.getInstance().queryID(selectIDByEPackage);
	}
	
	public static int create(EPackage ePackage) throws SQLException {
		StringBuffer insertStatementBuffer = new StringBuffer("INSERT INTO EPackage(nsURI) values('");
		insertStatementBuffer.append(ePackage.getNsURI());
		insertStatementBuffer.append("')");
		return IndexDatabase.getInstance().insertWithAutoID(insertStatementBuffer.toString());
	}

}
