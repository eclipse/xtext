/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ecore;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescription.Manager;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EcoreResourceDescriptionManager implements Manager {

	public IResourceDescription getResourceDescription(Resource resource) {
		return new EcoreResourceDescription(resource);
	}

	public boolean isAffected(Delta delta, IResourceDescription candidate) throws IllegalArgumentException {
		return false;
	}

}
