/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface ResourceSetReferencingResourceSet extends ResourceSet {
	
	List<ResourceSet> getReferencedResourceSets();
}
