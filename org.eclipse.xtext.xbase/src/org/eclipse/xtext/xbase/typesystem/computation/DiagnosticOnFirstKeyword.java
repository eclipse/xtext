/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DiagnosticOnFirstKeyword extends EObjectDiagnosticImpl {
	public DiagnosticOnFirstKeyword(
			Severity severity,
			String problemCode,
			String message,
			EObject problematicObject,
			String[] data) {
		super(severity, problemCode, message, problematicObject, null, -1, data);
	}

	@Override
	protected INode getNode() {
		INode result = super.getNode();
		for(ILeafNode leaf: result.getLeafNodes()) {
			if (!leaf.isHidden()) {
				return leaf;
			}
		}
		return result;
	}
}