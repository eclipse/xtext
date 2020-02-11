/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.AbstractInjectableValidator;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator.DiagnosticChainAcceptor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ConcreteSyntaxEValidator extends AbstractInjectableValidator {

	public static final String DISABLE_CONCRETE_SYNTAX_EVALIDATOR = ConcreteSyntaxEValidator.class.getName()
			+ ".disable";

	private IGrammarAccess grammar;

	@Inject
	private IConcreteSyntaxValidator validator;

	@Inject
	// this ensures that the grammar is available when AbstractInjectableValidator.register(EValidatorRegistrar) is called
	public ConcreteSyntaxEValidator(IGrammarAccess grammar) {
		super();
		this.grammar = grammar;
	}

	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> pkg = new ArrayList<EPackage>();
		for (AbstractMetamodelDeclaration a : GrammarUtil.allMetamodelDeclarations(grammar.getGrammar()))
			pkg.add(a.getEPackage());
		return pkg;
	}

	@Override
	protected boolean internalValidate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (Boolean.TRUE.equals(context.get(DISABLE_CONCRETE_SYNTAX_EVALIDATOR)))
			return true;
		if (!(eObject.eResource() instanceof XtextResource))
			return true;
		return validator.validateObject(eObject, new DiagnosticChainAcceptor(diagnostics), context);
	}
}
