/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.crossref.ILinkingScopeService;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public abstract class AbstractLinkingScopeService implements ILinkingScopeService {

	/* 
	 * @see org.eclipse.xtext.crossref.ILinkingScopeService#getObjectsInScope(org.eclipse.emf.ecore.EObject)
	 */
	public abstract List<EObject> getObjectsInScope(EObject context, CrossReference reference);

}
