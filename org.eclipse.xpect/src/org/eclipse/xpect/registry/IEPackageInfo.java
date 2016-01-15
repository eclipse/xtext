package org.eclipse.xpect.registry;

import java.util.Collection;

import org.eclipse.emf.ecore.EPackage;

public interface IEPackageInfo {

	public interface Registry {
		Registry INSTANCE = new EPackageInfoRegistry();

		IEPackageInfo getEPackageInfo(String namespaceURI);

		Collection<String> getNamespaceURIs();

	}

	String getEPackageClassName();

	String getGenmodel();

	String getNamespaceURI();

	LazyClass<EPackage> getEPackage();
}
