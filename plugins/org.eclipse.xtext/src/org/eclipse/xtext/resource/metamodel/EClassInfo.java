/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class EClassInfo {

	private EClass eClass;
	private boolean isGenerated;
	private Set<EClassInfo> superTypes = new HashSet<EClassInfo>();
	
	public EClassInfo(EClass metaType, boolean isGenerated) {
		super();
		this.isGenerated = isGenerated;
		this.eClass = metaType;
	}

	public EClass getEClass() {
		return eClass;
	}

	public boolean isGenerated() {
		return isGenerated;
	}

	public boolean addSupertype(EClassInfo superTypeInfo) {
		return superTypes.add(superTypeInfo);
	}
}
