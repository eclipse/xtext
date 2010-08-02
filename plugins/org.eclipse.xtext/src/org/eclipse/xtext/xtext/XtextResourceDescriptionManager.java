/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextResourceDescriptionManager extends DefaultResourceDescriptionManager {

	@Override
	protected IResourceDescription internalGetResourceDescription(Resource resource, IQualifiedNameProvider nameProvider) {
		return new XtextResourceDescription(resource, nameProvider);
	}
	
}
