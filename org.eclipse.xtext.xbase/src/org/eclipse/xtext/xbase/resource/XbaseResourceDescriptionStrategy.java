/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.descriptions.JvmTypesResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;

import com.google.inject.Singleton;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class XbaseResourceDescriptionStrategy extends JvmTypesResourceDescriptionStrategy {
	
	@Override
	public boolean createReferenceDescriptions(EObject from, URI exportedContainerURI, IAcceptor<IReferenceDescription> acceptor) {
		if (from instanceof XAbstractFeatureCall && ((XAbstractFeatureCall) from).isPackageFragment())
			return false;
		return super.createReferenceDescriptions(from, exportedContainerURI, acceptor);
	}
}
