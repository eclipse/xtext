/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.7
 */
public class DetachedEObjectDescription implements IEObjectDescription {
	
	private final QualifiedName name;
	private final EClass eclass;
	private final URI resourceURI;
	private final String fragment;
	private final Map<String,String> userData;
	private EObject proxy;
	private URI proxyURI;
	
	public DetachedEObjectDescription(QualifiedName name, EClass eclass, URI resourceURI, String fragment, Map<String,String> userData) {
		super();
		this.name = name;
		this.eclass = eclass;
		this.resourceURI = resourceURI;
		this.fragment = fragment;
		this.userData = userData;
	}
	
	public URI getResourceURI() {
		return resourceURI;
	}
	
	public String getFragment() {
		return fragment;
	}

	public QualifiedName getName() {
		return name;
	}

	public QualifiedName getQualifiedName() {
		return name;
	}

	public EObject getEObjectOrProxy() {
		if (proxy == null) {
			proxy = eclass.getEPackage().getEFactoryInstance().create(eclass);
			((InternalEObject)proxy).eSetProxyURI(getEObjectURI());
		}
		return proxy;
	}

	public URI getEObjectURI() {
		if (proxyURI == null) {
			proxyURI = resourceURI.appendFragment(fragment);
		}
		return proxyURI;
	}

	public EClass getEClass() {
		return eclass;
	}

	public String getUserData(String key) {
		if (userData== null)
			return null;
		return userData.get(key);
	}

	public String[] getUserDataKeys() {
		if (userData==null)
			return new String[0];
		return userData.keySet().toArray(new String[userData.size()]);
	}

}
