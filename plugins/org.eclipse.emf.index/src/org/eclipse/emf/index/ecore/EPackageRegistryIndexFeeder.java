package org.eclipse.emf.index.ecore;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.index.EPackageDescriptor;
import org.eclipse.emf.index.IIndexStore;

public class EPackageRegistryIndexFeeder {
	
	public static void feedEPackagesFromRegistry(IIndexStore indexStore) {
		for (boolean hasChanged = true; hasChanged;) {
			for (String nsURI : EPackage.Registry.INSTANCE.keySet()) {
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
