package org.eclipse.emf.index.ecore;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.index.EPackageDescriptor;
import org.eclipse.emf.index.IIndexStore;

public class EPackageRegistryIndexFeeder {
	
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
