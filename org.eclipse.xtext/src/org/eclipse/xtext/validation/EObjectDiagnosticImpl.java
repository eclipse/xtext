/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
public class EObjectDiagnosticImpl extends AbstractDiagnostic {
	
	private EObject problematicObject;
	private EStructuralFeature problematicFeature;
	private int indexOfProblematicValueInFeature = -1;
	private Severity severity;
	private String code;
	private String message;
	private String[] data;
	
	public EObjectDiagnosticImpl(Severity severity, String problemCode, String message, EObject problematicObject,
			EStructuralFeature problematicFeature, int indexOfProblematicValueInFeature, String[] data) {
		super();
		this.severity = severity;
		this.code = problemCode;
		this.message = message;
		this.problematicObject = problematicObject;
		this.problematicFeature = problematicFeature;
		this.indexOfProblematicValueInFeature = indexOfProblematicValueInFeature;
		this.data = data;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	protected INode getNode() {
		return doGetNode(problematicObject, problematicFeature, indexOfProblematicValueInFeature);
	}
	
	protected INode doGetNode(EObject object, EStructuralFeature feature, int idx) {
		if (object == null)
			return null;
		if (feature == null) {
			INode result = NodeModelUtils.findActualNodeFor(object);
			if (result != null) {
				return result;
			}
			return doGetNode(object.eContainer(), object.eContainmentFeature(), -1);
		}
			
		List<INode> nodesForFeature = NodeModelUtils.findNodesForFeature(object, feature);
		if (nodesForFeature.isEmpty()) {
			return doGetNode(object, null, -1);
		}
		if (idx == -1 /* INSIGNIFICANT_INDEX */) {
			idx = 0;
		}
		if (nodesForFeature.size() > idx ) {
			return nodesForFeature.get(idx);
		}
		return doGetNode(object, null, -1);
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String[] getData() {
		return data;
	}
	
	@Override
	public URI getUriToProblem() {
		return EcoreUtil.getURI(problematicObject);
	}
	
	public Severity getSeverity() {
		return severity;
	}
	
	public EStructuralFeature getProblematicFeature() {
		return problematicFeature;
	}
	
	public EObject getProblematicObject() {
		return problematicObject;
	}

}
