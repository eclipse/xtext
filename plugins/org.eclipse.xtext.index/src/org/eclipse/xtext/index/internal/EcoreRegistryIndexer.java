/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index.internal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.index.internal.dbaccess.IndexDatabase;
import org.eclipse.xtext.index.internal.dbaccess.NotFoundInIndexException;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class EcoreRegistryIndexer {

	private static Logger log = Logger.getLogger(EcoreRegistryIndexer.class);
	private IndexDatabase indexDatabase;

	public EcoreRegistryIndexer(IndexDatabase indexDatabase) {
		this.indexDatabase = indexDatabase;
	}

	public void indexRegisteredEPackages() {
		List<String> nsURIs = new ArrayList<String>(EPackage.Registry.INSTANCE.keySet());
		for (String nsURI : nsURIs) {
			try {
				Object object = EPackage.Registry.INSTANCE.get(nsURI);
				EPackage ePackage = null;
				if (object instanceof EPackage.Descriptor) {
					ePackage = ((EPackage.Descriptor) object).getEPackage();
				}
				else if (object instanceof EPackage) {
					ePackage = (EPackage) object;
				}
				if (ePackage != null) {
					indexEPackage(ePackage);
				}
			}
			catch (Exception exc) {
				log.error(exc);
			}
		}
	}

	public void indexEPackage(EPackage ePackage) throws SQLException {
		int ePackageID;
		List<String> allEClassNames;
		try {
			ePackageID = indexDatabase.getEPackageDAO().getID(ePackage);
			allEClassNames = indexDatabase.getEClassDAO().findAllEClassNames(ePackageID);
		}
		catch (NotFoundInIndexException exc) {
			ePackageID = indexDatabase.getEPackageDAO().create(ePackage);
			allEClassNames = Collections.emptyList();
		}
		log.info("Indexing EPackage: " + ePackageID + " " + ePackage.getNsURI());
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			if (classifier instanceof EClass) {
				if (!allEClassNames.remove(classifier.getName())) {
					indexDatabase.getEClassDAO().create((EClass) classifier, ePackageID);
				}
			}
		}
		for (String staleEClassName : allEClassNames) {
			indexDatabase.getEClassDAO().delete(staleEClassName);
		}
		for (EPackage subPackage : ePackage.getESubpackages()) {
			indexEPackage(subPackage);
		}
	}

}
