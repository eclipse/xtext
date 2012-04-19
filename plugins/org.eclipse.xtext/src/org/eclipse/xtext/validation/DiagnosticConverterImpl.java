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
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Issue.IssueImpl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DiagnosticConverterImpl implements IDiagnosticConverter {

	protected static class IssueLocation {
		
		public IssueLocation() {}
		
		public Integer lineNumber;
		public Integer offset;
		public Integer length;
	}
	
	public void convertResourceDiagnostic(Diagnostic diagnostic, Severity severity,	IAcceptor<Issue> acceptor) {
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
			AbstractDiagnostic castedDiagnostic = (AbstractDiagnostic)diagnostic;
			issue.setUriToProblem(castedDiagnostic.getUriToProblem());
			issue.setCode(castedDiagnostic.getCode());
			issue.setData(castedDiagnostic.getData());
		}
		issue.setType(CheckType.FAST);
		acceptor.accept(issue);
	}

	public void convertValidatorDiagnostic(org.eclipse.emf.common.util.Diagnostic diagnostic,
			IAcceptor<Issue> acceptor) {
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
		IssueLocation locationData = getLocationData(diagnostic);
		if (locationData != null) {
			issue.setLineNumber(locationData.lineNumber);
			issue.setOffset(locationData.offset);
			issue.setLength(locationData.length);
		}
		final EObject causer = getCauser(diagnostic);
		if (causer != null)
			issue.setUriToProblem(EcoreUtil.getURI(causer));
		if (diagnostic instanceof AbstractValidationDiagnostic) {
			AbstractValidationDiagnostic diagnosticImpl = (AbstractValidationDiagnostic) diagnostic;
			issue.setType(diagnosticImpl.getCheckType());
			issue.setCode(diagnosticImpl.getIssueCode());
			issue.setData(diagnosticImpl.getIssueData());
		} else {
			// default to FAST
			issue.setType(CheckType.FAST);
			issue.setCode(diagnostic.getSource() + "." + diagnostic.getCode());
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
	protected IssueLocation getLocationData(org.eclipse.emf.common.util.Diagnostic diagnostic) {
		EObject causer = getCauser(diagnostic);
		if (causer != null) {
			if (diagnostic instanceof RangeBasedDiagnostic) {
				RangeBasedDiagnostic castedDiagnostic = (RangeBasedDiagnostic) diagnostic;
				INode parserNode = NodeModelUtils.getNode(causer);
				IssueLocation result = new IssueLocation();
				if (parserNode != null) {
					String completeText = parserNode.getRootNode().getText();
					int startLine = Strings.countLines(completeText.substring(0, castedDiagnostic.getOffset())) + 1;
					result.lineNumber = startLine;
				}
				result.offset = castedDiagnostic.getOffset();
				result.length = castedDiagnostic.getLength();
				return result;
			} else if (diagnostic instanceof FeatureBasedDiagnostic) {
				 FeatureBasedDiagnostic castedDiagnostic = (FeatureBasedDiagnostic) diagnostic;
				 return getLocationData(causer, castedDiagnostic.getFeature(), castedDiagnostic.getIndex());
			} else {
				// feature is the second element see Diagnostician.getData
				List<?> data = diagnostic.getData();
				Object feature = data.size() > 1 ? data.get(1) : null;
				EStructuralFeature structuralFeature = resolveStructuralFeature(causer, feature);
				return getLocationData(causer, structuralFeature, 0);
			}
		}
		return null;
	}

	protected IssueLocation getLocationData(EObject obj, EStructuralFeature structuralFeature) {
		return getLocationData(obj, structuralFeature, 0);
	}
	
	/**
	 * @return the location data for the given diagnostic.
	 */
	protected IssueLocation getLocationData(EObject obj, EStructuralFeature structuralFeature, int index) {
		INode parserNode = NodeModelUtils.getNode(obj);
		if (parserNode != null) {
			if (structuralFeature != null) {
				List<INode> nodes = NodeModelUtils.findNodesForFeature(obj, structuralFeature);
				if (index < 0) // insignificant index
					index = 0;
				if (nodes.size()>index)
					parserNode = nodes.get(index);
			}
			return getLocationForNode(parserNode);
		}
		return null;
	}

	protected IssueLocation getLocationForNode(INode node) {
		IssueLocation result = new IssueLocation();
		result.lineNumber = node.getStartLine();
		result.offset = node.getOffset();
		result.length = node.getLength();
		return result;
	}

	protected EStructuralFeature resolveStructuralFeature(EObject ele, Object feature) {
		if (feature instanceof EStructuralFeature) {
			return (EStructuralFeature) feature;
		} 
		return null;
	}

}
