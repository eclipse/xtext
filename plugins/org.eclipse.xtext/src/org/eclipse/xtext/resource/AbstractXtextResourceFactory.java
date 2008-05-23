/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ILanguageFacade;

public abstract class AbstractXtextResourceFactory implements Resource.Factory {

	public Resource createResource(URI uri) {
		ILanguageFacade facade = getLanguageFacade();
		XtextResource xtextResource = new XtextResource(facade, uri);
		return xtextResource;
	}

	protected abstract ILanguageFacade getLanguageFacade();

}
