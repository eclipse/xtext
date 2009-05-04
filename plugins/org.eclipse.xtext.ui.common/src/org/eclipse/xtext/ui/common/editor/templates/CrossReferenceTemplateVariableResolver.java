/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.templates;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateVariable;
import org.eclipse.jface.text.templates.TemplateVariableResolver;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CrossReferenceTemplateVariableResolver extends TemplateVariableResolver {

	public CrossReferenceTemplateVariableResolver() {
		super("CrossReference", "TemplateVariableResolver for CrossReferences");
	}

	@Override
	public void resolve(TemplateVariable variable, TemplateContext templateContext) {
		XtextTemplateContext castedContext = (XtextTemplateContext) templateContext;

		String abbreviatedCrossReference = (String) variable.getVariableType().getParams().iterator().next();

		String[] classReferencePair = abbreviatedCrossReference.split("\\.");

		EReference reference = getReference(classReferencePair[0], classReferencePair[1], getGrammar(castedContext));

		IScope scope = castedContext.getScopeProvider().getScope(castedContext.getContentAssistContext().getCurrentModel(), reference);
		Iterable<IScopedElement> linkingCandidates = scope.getAllContents();

		List<String> names = new ArrayList<String>();

		for (IScopedElement scopedElement : linkingCandidates) {
			names.add(scopedElement.name());
		}

		String[] bindings = names.toArray(new String[names.size()]);

		if (bindings.length != 0)
			variable.setValues(bindings);
		if (bindings.length > 1)
			variable.setUnambiguous(false);
		else
			variable.setUnambiguous(isUnambiguous(castedContext));

		variable.setResolved(true);
	}

	private Grammar getGrammar(XtextTemplateContext xtextTemplateContext) {
		EObject grammarElement = xtextTemplateContext.getContentAssistContext().getRootNode().getGrammarElement();
		Grammar g = (Grammar) EcoreUtil.getRootContainer(grammarElement);
		return g;
	}
	
	private EReference getReference(String eClassName, String eReferenceName, Grammar g) {
		List<AbstractMetamodelDeclaration> allMetamodelDeclarations = GrammarUtil.allMetamodelDeclarations(g);
		for (AbstractMetamodelDeclaration decl : allMetamodelDeclarations) {
			EClass eClass = (EClass) decl.getEPackage().getEClassifier(eClassName);
			if (eClass != null) {
				return (EReference) eClass.getEStructuralFeature(eReferenceName);
			}
		}
		return null;
	}
}