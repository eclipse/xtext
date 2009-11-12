/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @deprecated use {@link EcoreUtil2}
 */
@Deprecated
public class ImportUriUtil {
	
	@Deprecated
	public static boolean isValidUri(EObject context, String uri) {
		return EcoreUtil2.isValidUri(context, URI.createURI(uri));
	}

	@Deprecated
	public static Resource getResource(Resource context, String uri) {
		return EcoreUtil2.getResource(context, uri);
	}
}
