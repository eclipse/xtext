/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class XtextMetamodelResource extends ResourceImpl {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl#doLoad(java.io.InputStream, java.util.Map)
	 */
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		// TODO: implement
		super.doLoad(inputStream, options);
	}
}
