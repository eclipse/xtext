/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 */
public class EObjectDescription extends AbstractEObjectDescription {

	protected EObjectDescription(QualifiedName qualifiedName, EObject element, Map<String, String> userData) {
		this.qualifiedName = qualifiedName;
		this.element = element;
		this.userData = userData;
	}

	public static IEObjectDescription create(QualifiedName qualifiedName, EObject element, Map<String, String> userData) {
		return new EObjectDescription(qualifiedName, element, userData);
	}
	
	public static IEObjectDescription create(QualifiedName qualifiedName, EObject element) {
		return create(qualifiedName, element, Collections.<String,String>emptyMap());
	}

	private final Map<String, String> userData;
	private final QualifiedName qualifiedName;
	private final EObject element;

	public EObject getEObjectOrProxy() {
		return element;
	}

	public URI getEObjectURI() {
		return EcoreUtil.getURI(element);
	}

	public QualifiedName getName() {
		return qualifiedName;
	}
	
	public QualifiedName getQualifiedName() {
		return qualifiedName;
	}
	
	@Override
	public String getUserData(String name) {
		if (userData==null)
			return null;
		return userData.get(name);
	}
	
	@Override
	public String[] getUserDataKeys() {
		if (userData==null)
			return new String[0];
		return userData.keySet().toArray(new String[userData.size()]);
	}

	public EClass getEClass() {
		return element.eClass();
	}

}
