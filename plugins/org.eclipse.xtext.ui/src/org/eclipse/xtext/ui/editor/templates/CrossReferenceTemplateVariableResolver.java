/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.templates.TemplateVariable;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.inject.Inject;

/**
 * Resolves a template variable to <code>EClass classes</code> which are visible in the current scope, and are
 * assignment-compatible with the <code>TemplateVariable reference</code> type parameter (e.g. 'myRef' in
 * ${someText:CrossReference('[MyPackageName.]MyType.myRef')}).
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CrossReferenceTemplateVariableResolver extends AbstractTemplateVariableResolver {
	private static final Logger log = Logger.getLogger(CrossReferenceTemplateVariableResolver.class);

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	public CrossReferenceTemplateVariableResolver() {
		super("CrossReference",  //$NON-NLS-1$
				Messages.CrossReferenceTemplateVariableResolver_1);
	}
	
	@Override
	public List<String> resolveValues(TemplateVariable variable, XtextTemplateContext castedContext) {
		String abbreviatedCrossReference = (String) variable.getVariableType().getParams().iterator().next();
		int dotIndex = abbreviatedCrossReference.lastIndexOf('.');
		if (dotIndex <= 0) {
			log.error("CrossReference '" + abbreviatedCrossReference + "' could not be resolved."); //$NON-NLS-1$ //$NON-NLS-2$
			return Collections.emptyList();
		}
		String[] classReferencePair = new String[] { abbreviatedCrossReference.substring(0, dotIndex),
				abbreviatedCrossReference.substring(dotIndex + 1) };
		Grammar grammar = getGrammar(castedContext);
		if (grammar == null) {
			return Collections.emptyList();
		}
		EReference reference = getReference(classReferencePair[0], classReferencePair[1], grammar);
		if (reference == null) {
			log.debug("CrossReference to class '" + classReferencePair[0] + "' and reference '" + classReferencePair[1] //$NON-NLS-1$ //$NON-NLS-2$
					+ "' could not be resolved."); //$NON-NLS-1$
			return Collections.emptyList();
		}
		IScope scope = castedContext.getScopeProvider().getScope(
				castedContext.getContentAssistContext().getCurrentModel(), reference);
		Iterable<IEObjectDescription> linkingCandidates = queryScope(scope);

		List<String> names = new ArrayList<String>();
		for (IEObjectDescription eObjectDescription : linkingCandidates) {
			names.add(qualifiedNameConverter.toString(eObjectDescription.getName()));
		}
		return names;
	}

	protected Iterable<IEObjectDescription> queryScope(IScope scope) {
		return scope.getAllElements();
	}

	protected EReference getReference(String eClassName, String eReferenceName, Grammar grammar) {
		EClass eClass = (EClass) getEClassifierForGrammar(eClassName, grammar);
		if (eClass != null) {
			return (EReference) eClass.getEStructuralFeature(eReferenceName);
		}
		return null;
	}
}