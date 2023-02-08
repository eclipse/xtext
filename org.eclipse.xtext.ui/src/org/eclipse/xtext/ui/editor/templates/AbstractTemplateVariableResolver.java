/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.templates;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateVariable;
import org.eclipse.jface.text.templates.TemplateVariableResolver;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;

import com.google.inject.Inject;

/**
 * Provides a common base class for xtext <code>TemplateVariableResolver</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public abstract class AbstractTemplateVariableResolver extends
		TemplateVariableResolver {

	@Inject(optional = true)
	private IGrammarAccess grammarAccess;
	
	public AbstractTemplateVariableResolver() {
		super();
	}

	public AbstractTemplateVariableResolver(String type, String description) {
		super(type, description);
	}

	@Override
	public void resolve(TemplateVariable variable, TemplateContext templateContext) {
		XtextTemplateContext castedContext = (XtextTemplateContext) templateContext;
		List<String> names = resolveValues(variable, castedContext);
		String[] bindings = names.toArray(new String[names.size()]);
		if (bindings.length != 0)
			variable.setValues(bindings);
		if (bindings.length > 1)
			variable.setUnambiguous(false);
		else
			variable.setUnambiguous(isUnambiguous(castedContext));
		variable.setResolved(true);
	}

	protected EClassifier getEClassifierForGrammar(String fqnClassName,
			Grammar grammar) {
		int dotIndex = fqnClassName.indexOf('.');
		String packageName = null;
		String className = fqnClassName;
		if (dotIndex > 0) {
			packageName = fqnClassName.substring(0, dotIndex);
			className = fqnClassName.substring(dotIndex + 1);
		}
		List<AbstractMetamodelDeclaration> allMetamodelDeclarations = GrammarUtil
				.allMetamodelDeclarations(grammar);
		for (AbstractMetamodelDeclaration decl : allMetamodelDeclarations) {
			EPackage pack = decl.getEPackage();
			if (packageName == null || pack.getName().equals(packageName)) {
				EClassifier eClassifier = pack.getEClassifier(className);
				if (eClassifier != null) {
					return eClassifier;
				}
			}
		}
		return null;
	}

	protected Grammar getGrammar(XtextTemplateContext xtextTemplateContext) {
		EObject grammarElement = xtextTemplateContext.getContentAssistContext()
				.getRootNode().getGrammarElement();
		if (grammarElement == null && grammarAccess != null)
			return grammarAccess.getGrammar();
		return (Grammar) EcoreUtil.getRootContainer(grammarElement);
	}

	public abstract List<String> resolveValues(TemplateVariable variable,
			XtextTemplateContext xtextTemplateContext);
}