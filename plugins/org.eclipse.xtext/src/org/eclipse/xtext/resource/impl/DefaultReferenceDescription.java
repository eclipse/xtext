/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IReferenceDescription;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultReferenceDescription implements IReferenceDescription {
	
	private Integer indexInList = null;
	private URI sourceEObjectUri;
	private URI targetEObjectUri;
	private Setting setting;
	
	public DefaultReferenceDescription(Setting setting) {
		this.setting = setting;
	}
	
	@SuppressWarnings("unchecked")
	public int getIndexInList() {
		if (indexInList == null) {
			if (!getEReference().isMany()) {
				indexInList = -1;
			} else {
				List<EObject> get = (List<EObject>) this.setting.getEObject().eGet(getEReference(),false);
				indexInList = get.indexOf(setting.get(false));
			}
		}
		return indexInList;
	}
	
	public URI getSourceEObjectUri() {
		if (sourceEObjectUri==null) {
			sourceEObjectUri = EcoreUtil.getURI(this.setting.getEObject());
		}
		return sourceEObjectUri;
	}
	public URI getTargetEObjectUri() {
		if (targetEObjectUri==null) {
			targetEObjectUri = EcoreUtil.getURI((EObject) setting.get(true));
		}
		return targetEObjectUri;
	}
	
	public EReference getEReference() {
		return (EReference) setting.getEStructuralFeature();
	}
	
}
