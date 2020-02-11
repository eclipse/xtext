/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.diagnostics;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NullDiagnosticProducer implements IDiagnosticProducer {

	@Override
	public void addDiagnostic(DiagnosticMessage message) {
		// nothing to do
	}

	@Override
	public INode getNode() {
		return null;
	}

	@Override
	public void setNode(INode node) {
		// nothing to do		
	}

	@Override
	public void setTarget(EObject object, EStructuralFeature feature) {
		// nothing to do		
	}
	
}
