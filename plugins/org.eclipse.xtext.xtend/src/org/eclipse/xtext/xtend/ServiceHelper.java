/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ServiceHelper {

	/**
	 * An adapter for Xtend to access all elements in a resource set without
	 * creating huge lists.
	 * 
	 * @param scope
	 * @return all root elements in the same resource set as scope
	 */
	public static List<EObject> allRootElements(EObject scope) {
		List<EObject> allRootElements = new ArrayList<EObject>();
		EList<Resource> resources = scope.eResource().getResourceSet().getResources();
		for (Resource resource : resources) {
			allRootElements.addAll(resource.getContents());
		}
		return allRootElements;
	}
}
