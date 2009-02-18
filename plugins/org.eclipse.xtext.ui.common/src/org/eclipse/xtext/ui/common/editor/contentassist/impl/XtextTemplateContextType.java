/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.templates.GlobalTemplateVariables;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateVariable;
import org.eclipse.jface.text.templates.TemplateVariableResolver;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.crossref.IScopedElement;

/**
 * Provides a convenience base type for <code>TemplateContextType's</code> preconfigured with several handy
 * Xtext <code>TemplateVariableResolver</code> .
 *
 * @author Michael Clay - Initial contribution and API
 */
public class XtextTemplateContextType extends TemplateContextType {

	public XtextTemplateContextType() {
		addResolver(new CrossReferenceTemplateVariableResolver());
		addResolver(new GlobalTemplateVariables.WordSelection());
		addResolver(new GlobalTemplateVariables.LineSelection());
		addResolver(new GlobalTemplateVariables.Date());
		addResolver(new GlobalTemplateVariables.Year());
		addResolver(new GlobalTemplateVariables.Time());
		addResolver(new GlobalTemplateVariables.Dollar());
		addResolver(new GlobalTemplateVariables.User());
		addResolver(new GlobalTemplateVariables.Cursor());
	}

	public static class CrossReferenceTemplateVariableResolver extends TemplateVariableResolver {

		public CrossReferenceTemplateVariableResolver() {
			super("CrossReference", "TemplateVariableResolver for CrossReferences");
		}

		@Override
		public void resolve(TemplateVariable variable, TemplateContext context) {

			XtextTemplateContext xtextTemplateContext = (XtextTemplateContext) context;

			String abbreviatedCrossReference = (String) variable.getVariableType().getParams().iterator().next();

			String[] classReferencePair = abbreviatedCrossReference.split("\\.");

			EReference reference = null;// getReference(classReferencePair[0], classReferencePair[1], getGrammar(xtextTemplateContext));

			Iterable<IScopedElement> linkingCandidates = xtextTemplateContext.getScopeProvider()
					.getScope(xtextTemplateContext.getContentAssistContext().getModel(), reference).getAllContents();

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
				variable.setUnambiguous(isUnambiguous(context));

			variable.setResolved(true);
		}

		private Grammar getGrammar(XtextTemplateContext xtextTemplateContext) {
			EObject grammarElement = xtextTemplateContext.getContentAssistContext().getRootNode().getGrammarElement();
			Grammar g = (Grammar) EcoreUtil.getRootContainer(grammarElement);
			return g;
		}
//TODO get rid of IMetamodelAccess
//		private EReference getReference(String eClassName, String eReferenceName) {
//			EPackage[] allEPackages = metamodelAccess.getAllEPackages();
//			for (int i = 0; i < allEPackages.length; i++) {
//				EPackage ePackage = allEPackages[i];
//				EClass eClass = (EClass) ePackage.getEClassifier(eClassName);
//				if (eClass != null) {
//					return (EReference) eClass.getEStructuralFeature(eReferenceName);
//				}
//			}
//			return null;
//		}
	}

}
