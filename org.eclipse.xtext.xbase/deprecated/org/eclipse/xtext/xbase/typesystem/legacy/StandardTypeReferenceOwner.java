/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.legacy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * Plain instantiable implementation of the {@link ITypeReferenceOwner}.
 * It is not capable of handling reference resolution or unbound type argument hints.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @deprecated use org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner instead.
 */
@Deprecated
public class StandardTypeReferenceOwner extends org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner {

	public StandardTypeReferenceOwner(CommonTypeComputationServices services, EObject context) {
		super(services, context);
	}

	public StandardTypeReferenceOwner(CommonTypeComputationServices services, Resource context) {
		super(services, context);
	}

	public StandardTypeReferenceOwner(CommonTypeComputationServices services, ResourceSet context) {
		super(services, context);
	}

}