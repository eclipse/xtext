/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.IAcceptor;

/**
 * For local references, populates an {@link IReferenceDescription} that knows its exported container URI.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ReferenceAcceptor extends org.eclipse.xtext.findReferences.ReferenceAcceptor {
	
	protected ReferenceAcceptor(IAcceptor<IReferenceDescription> delegate, IResourceServiceProvider.Registry resourceServiceProviderRegistry) {
		super(resourceServiceProviderRegistry, delegate);
	}
	
}