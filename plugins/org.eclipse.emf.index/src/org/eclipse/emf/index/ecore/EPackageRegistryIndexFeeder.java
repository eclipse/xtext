/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ecore;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.index.EPackageDescriptor;
import org.eclipse.emf.index.IIndexStore;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EPackageRegistryIndexFeeder {

	/**
	 * There will be a scalability issue with this implementation, as it
	 * resolves all descriptors in the registry, thus instantiates all
	 * registered EPackages.
	 * 
	 * @param indexStore
	 */
	public static void feedEPackagesFromRegistry(IIndexStore indexStore) {
		for (boolean hasChanged = true; hasChanged;) {
			List<String> nsURIs = new ArrayList<String>(EPackage.Registry.INSTANCE.keySet());
			for (String nsURI : nsURIs) {
				hasChanged = false;
				EPackageDescriptor storedEPackages = indexStore.ePackageDAO().createQuery().nsURI(nsURI)
						.executeSingleResult();
				if (storedEPackages == null) {
					hasChanged = true;
					EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
					indexStore.indexFeeder().index(ePackage, true);
				}
			}
		}
	}
}
