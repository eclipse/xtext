/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.diagnostics;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NullDiagnosticProducer implements IDiagnosticProducer {

	public void addDiagnostic(DiagnosticMessage message) {
		// nothing to do
	}

	public AbstractNode getNode() {
		return null;
	}

	public void setNode(AbstractNode node) {
		// nothing to do		
	}

	public void setTarget(EObject object, EStructuralFeature feature) {
		// nothing to do		
	}
	
}
