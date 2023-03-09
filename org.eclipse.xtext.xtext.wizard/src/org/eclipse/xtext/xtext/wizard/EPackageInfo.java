/**
 * Copyright (c) 2015,2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

public class EPackageInfo {
	private final EPackage ePackage;

	private final URI ePackageImportURI;

	private final URI genmodelURI;

	private final String ePackageJavaFQN;

	private final String bundleID;

	public EPackageInfo(EPackage ePackage, URI ePackageImportURI, URI genmodelURI, String ePackageJavaFQN,
			String bundleID) {
		this.ePackage = ePackage;
		this.ePackageImportURI = ePackageImportURI;
		this.genmodelURI = genmodelURI;
		this.ePackageJavaFQN = ePackageJavaFQN;
		this.bundleID = bundleID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bundleID == null) ? 0 : bundleID.hashCode());
		result = prime * result + ((ePackage == null) ? 0 : ePackage.hashCode());
		result = prime * result + ((ePackageImportURI == null) ? 0 : ePackageImportURI.hashCode());
		result = prime * result + ((ePackageJavaFQN == null) ? 0 : ePackageJavaFQN.hashCode());
		result = prime * result + ((genmodelURI == null) ? 0 : genmodelURI.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EPackageInfo other = (EPackageInfo) obj;
		if (bundleID == null) {
			if (other.bundleID != null)
				return false;
		} else if (!bundleID.equals(other.bundleID))
			return false;
		if (ePackage == null) {
			if (other.ePackage != null)
				return false;
		} else if (!ePackage.equals(other.ePackage))
			return false;
		if (ePackageImportURI == null) {
			if (other.ePackageImportURI != null)
				return false;
		} else if (!ePackageImportURI.equals(other.ePackageImportURI))
			return false;
		if (ePackageJavaFQN == null) {
			if (other.ePackageJavaFQN != null)
				return false;
		} else if (!ePackageJavaFQN.equals(other.ePackageJavaFQN))
			return false;
		if (genmodelURI == null) {
			if (other.genmodelURI != null)
				return false;
		} else if (!genmodelURI.equals(other.genmodelURI))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("ePackage", ePackage);
		b.add("ePackageImportURI", ePackageImportURI);
		b.add("genmodelURI", genmodelURI);
		b.add("ePackageJavaFQN", ePackageJavaFQN);
		b.add("bundleID", bundleID);
		return b.toString();
	}

	public EPackage getEPackage() {
		return ePackage;
	}

	public URI getEPackageImportURI() {
		return ePackageImportURI;
	}

	public URI getGenmodelURI() {
		return genmodelURI;
	}

	public String getEPackageJavaFQN() {
		return ePackageJavaFQN;
	}

	public String getBundleID() {
		return bundleID;
	}
}
