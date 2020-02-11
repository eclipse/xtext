/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.validation.DiagnosticConverterImpl;

import com.google.common.base.Splitter;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextDiagnosticConverter extends DiagnosticConverterImpl{

	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	@Inject
	private IEObjectDocumentationProvider documentationProvider;
	
	@Override
	protected IssueLocation getLocationData(EObject obj, EStructuralFeature structuralFeature, int index) {
		if (NodeModelUtils.getNode(obj) == null) {
			ITextRegion location = locationInFileProvider.getSignificantTextRegion(obj);
			if (location != null) {
				ICompositeNode rootNode = NodeModelUtils.getNode(EcoreUtil.getRootContainer(obj));
				if (rootNode != null) {
					ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(rootNode, location.getOffset());
					return getLocationForNode(leafNode);
				}
			} else {
				return super.getLocationData(obj.eContainer(), null, index);
			}
		}
		return super.getLocationData(obj, structuralFeature, index);
	}
	
	@Override
	protected Severity getSeverity(Diagnostic diagnostic) {
		Severity result = super.getSeverity(diagnostic);
		String issueCode = getIssueCode(diagnostic);
		if (result == Severity.WARNING && issueCode != null) {
			// only warnings can be suppressed
			EObject causer = getCauser(diagnostic);
			if (causer != null) {
				if (isMarkedAsIgnored(causer, issueCode)) {
					return null;
				}
				if (!(causer instanceof AbstractRule)) {
					AbstractRule rule = GrammarUtil.containingRule(causer);
					if (rule != null && isMarkedAsIgnored(rule, issueCode)) {
						return null;
					}
				}
				Grammar grammar = GrammarUtil.getGrammar(causer);
				if (grammar != null && isMarkedAsIgnored(grammar, issueCode)) {
					return null;
				}
			}
		}
		return result;
	}
	
	// group 1 matches the suffix in an issue code e.g. someCode from org.eclipse.xtext.Xtext.someCode 
	private final Pattern afterLastDot = Pattern.compile(".*\\W(\\w+)$");
	// group 1 matches the codes given in SuppressWarnings[code1, code2], e.g. "code1, code2" is returned
	private final Pattern suppressWarnings = Pattern.compile("SuppressWarnings\\[([^]]*)\\]", Pattern.CASE_INSENSITIVE);
	private final Splitter splitter = Splitter.on(',').trimResults().omitEmptyStrings();
	private static final String ALL = "all";
	
	protected boolean isMarkedAsIgnored(EObject object, String code) {
		String documentation = documentationProvider.getDocumentation(object);
		if (documentation != null) {
			Matcher suppressWarningsMatcher = suppressWarnings.matcher(documentation);
			while (suppressWarningsMatcher.find()) {
				String suffix = null;
				String suppressed = suppressWarningsMatcher.group(1);
				Iterator<String> iter = splitter.split(suppressed).iterator();
				while(iter.hasNext()) {
					String next = iter.next();
					if (ALL.equalsIgnoreCase(next)) {
						return true;
					}
					if (suffix == null) {
						Matcher matcher = afterLastDot.matcher(code);
						if (matcher.matches()) {
							suffix = matcher.group(1);
						} else {
							suffix = "";
						}
					}
					if (suffix.equalsIgnoreCase(next)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
}
