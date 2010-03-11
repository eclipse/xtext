/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;

/**
 * @author koehnlein - Initial contribution and API
 */
public class EPackageInfo {

	private EPackage ePackage;

	private URI ePackageImportURI;

	private String ePackageJavaFQN;

	private String bundleID;

	private URI genmodelURI;

	public EPackageInfo(EPackage ePackage, URI ePackageImportURI, URI genmodelURI, String ePackageJavaFQN, String bundleID) {
		super();
		this.ePackage = ePackage;
		this.ePackageImportURI = ePackageImportURI;
		this.genmodelURI = genmodelURI;
		this.ePackageJavaFQN = ePackageJavaFQN;
		this.bundleID = bundleID;
	}

	public EPackage getEPackage() {
		return ePackage;
	}
	
	public URI getEPackageImportURI() {
		return ePackageImportURI;
	}

	public String getEPackageJavaFQN() {
		return ePackageJavaFQN;
	}

	public String getBundleID() {
		return bundleID;
	}
	
	public URI getGenmodelURI() {
		return genmodelURI;
	}
	
}
