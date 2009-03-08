/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.crossref.indexImpl;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
@ImplementedBy(DefaultNameProvider.class)
public interface INameProvider {
	/**
	 * returns the name the passed element can be referred to
	 * 
	 * @param obj
	 * @return
	 */
	String getGlobalName(EObject obj);
}
