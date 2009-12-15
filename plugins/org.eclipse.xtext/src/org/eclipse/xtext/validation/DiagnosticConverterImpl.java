/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator.DiagnosticImpl;
import org.eclipse.xtext.validation.Issue.IssueImpl;
import org.eclipse.xtext.validation.Issue.Severity;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DiagnosticConverterImpl implements IDiagnosticConverter {

	public void convertResourceDiagnostic(Diagnostic diagnostic, Severity severity,
			IDiagnosticConverter.Acceptor acceptor) {
		IssueImpl issue = new Issue.IssueImpl();
		issue.setSyntaxError(true);
		issue.setSeverity(severity);
		issue.setLineNumber(diagnostic.getLine());
		issue.setMessage(diagnostic.getMessage());
		//		issue.setmarker.put(IMarker.PRIORITY, Integer.valueOf(IMarker.PRIORITY_LOW));

		if (diagnostic instanceof org.eclipse.xtext.diagnostics.Diagnostic) {
			org.eclipse.xtext.diagnostics.Diagnostic xtextDiagnostic = (org.eclipse.xtext.diagnostics.Diagnostic) diagnostic;
			issue.setOffset(xtextDiagnostic.getOffset());
			issue.setLength(xtextDiagnostic.getLength());
		}
		if (diagnostic instanceof AbstractDiagnostic) {
			issue.setUriToProblem(((AbstractDiagnostic)diagnostic).getUriToProblem());
		}
		issue.setType(CheckType.FAST);
		acceptor.accept(issue);
	}

	public void convertValidatorDiagnostic(org.eclipse.emf.common.util.Diagnostic diagnostic,
			IDiagnosticConverter.Acceptor acceptor) {
		if (diagnostic.getSeverity() == org.eclipse.emf.common.util.Diagnostic.OK)
			return;
		IssueImpl issue = new Issue.IssueImpl();
		issue.setSeverity(Severity.ERROR);
		switch (diagnostic.getSeverity()) {
			case org.eclipse.emf.common.util.Diagnostic.WARNING:
				issue.setSeverity(Severity.WARNING);
				break;
			case org.eclipse.emf.common.util.Diagnostic.INFO:
				issue.setSeverity(Severity.INFO);
				break;
		}
		Triple<Integer, Integer, Integer> locationData = getLocationData(diagnostic);
		if (locationData != null) {
			issue.setLineNumber(locationData.getFirst());
			issue.setOffset(locationData.getSecond());
			issue.setLength(locationData.getThird() - issue.getOffset());
		}
		final EObject causer = getCauser(diagnostic);
		if (causer != null)
			issue.setUriToProblem(EcoreUtil.getURI(causer));
		if (diagnostic instanceof DiagnosticImpl) {
			DiagnosticImpl diagnosticImpl = (DiagnosticImpl) diagnostic;
			issue.setType(diagnosticImpl.getCheckType());
			issue.setCode(diagnosticImpl.getIssueCode());
		}
		
		//		marker.put(IXtextResourceChecker.DIAGNOSTIC_KEY, diagnostic);
		issue.setMessage(diagnostic.getMessage());
		//		marker.put(IMarker.PRIORITY, Integer.valueOf(IMarker.PRIORITY_LOW));
		acceptor.accept(issue);
	}

	protected EObject getCauser(org.eclipse.emf.common.util.Diagnostic diagnostic) {
		// causer is the first element see Diagnostician.getData
		if (diagnostic.getData().isEmpty())
			return null;
		Object causer = diagnostic.getData().get(0);
		return causer instanceof EObject ? (EObject) causer : null;
	}

	/**
	 * @return the location data for the given diagnostic.
	 *         <ol>
	 *         <li>First: line number,</li>
	 *         <li>Second: Offset of first char (inclusive), and</li>
	 *         <li>Third: Offset of last char (exclusive).</li>
	 *         </ol>
	 */
	protected Triple<Integer, Integer, Integer> getLocationData(org.eclipse.emf.common.util.Diagnostic diagnostic) {
		EObject causer = getCauser(diagnostic);
		if (causer != null) {
			// feature is the second element see Diagnostician.getData
			List<?> data = diagnostic.getData();
			Object feature = data.size() > 1 ? data.get(1) : null;
			EStructuralFeature structuralFeature = resolveStructuralFeature(causer, feature);
			return getLocationData(causer, structuralFeature);
		}
		return null;
	}

	/**
	 * @return the location data for the given diagnostic.
	 *         <ol>
	 *         <li>First: line number,</li>
	 *         <li>Second: Offset of first char (inclusive), and</li>
	 *         <li>Third: Offset of last char (exclusive).</li>
	 *         </ol>
	 */
	protected Triple<Integer, Integer, Integer> getLocationData(EObject obj, EStructuralFeature structuralFeature) {
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(obj);
		if (nodeAdapter != null) {
			AbstractNode parserNode = nodeAdapter.getParserNode();
			if (structuralFeature != null) {
				List<AbstractNode> nodes = NodeUtil.findNodesForFeature(obj, structuralFeature);
				if (!nodes.isEmpty())
					parserNode = nodes.iterator().next();
			}
			Integer lineNumber = Integer.valueOf(parserNode.getLine());
			int offset = parserNode.getOffset();
			Integer charStart = Integer.valueOf(Integer.valueOf(offset));
			Integer charEnd = Integer.valueOf(offset + parserNode.getLength());
			return Tuples.create(lineNumber, charStart, charEnd);
		}
		return null;
	}

	protected EStructuralFeature resolveStructuralFeature(EObject ele, Object feature) {
		if (feature instanceof String) {
			return ele.eClass().getEStructuralFeature((String) feature);
		} else if (feature instanceof EStructuralFeature) {
			return (EStructuralFeature) feature;
		} else if (feature instanceof Integer) {
			return ele.eClass().getEStructuralFeature((Integer) feature);
		}
		return null;
	}

}
