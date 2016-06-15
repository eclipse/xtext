/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.refactoring;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategyProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XtextRenameStrategyProvider extends DefaultRenameStrategyProvider {

	@Inject
	private Provider<MetamodelDeclarationRenameStrategy> metamodelDeclarationProvider;
	
	@Inject
	private Provider<RuleRenameStrategy> ruleProvider;
	
	@Override
	protected IRenameStrategy createRenameStrategy(final EObject targetElement, final IRenameElementContext context) {
		return new XtextSwitch<IRenameStrategy>() {

			@Override
			public IRenameStrategy caseAbstractMetamodelDeclaration(AbstractMetamodelDeclaration metamodelDeclaration) {
				return metamodelDeclarationProvider.get();
			}

			@Override
			public IRenameStrategy caseAbstractRule(AbstractRule rule) {
				return ruleProvider.get();
			}

			@Override
			public IRenameStrategy caseGrammar(Grammar grammar) {
				return XtextRenameStrategyProvider.super.createRenameStrategy(targetElement, context);
			}
		}.doSwitch(targetElement);
	}

	protected static class MetamodelDeclarationRenameStrategy extends DefaultRenameStrategy {
		@Override
		protected EAttribute getNameAttribute(EObject targetElement) {
			return XtextPackage.Literals.ABSTRACT_METAMODEL_DECLARATION__ALIAS;
		}
	}
	
	protected static class RuleRenameStrategy extends DefaultRenameStrategy {
	
		@Override
		protected EObject setName(URI targetElementURI, String newName, ResourceSet resourceSet) {
			renameReturnType(targetElementURI, newName, resourceSet);
			return super.setName(targetElementURI, newName, resourceSet);
		}

		protected void renameReturnType(URI targetElementURI, String newName, ResourceSet resourceSet) {
			AbstractRule rule = (AbstractRule) resourceSet.getEObject(targetElementURI, false);
			TypeRef parserRuleType = rule.getType();
			if (rule.getName().equals(parserRuleType.getClassifier().getName())
					&& parserRuleType.getMetamodel() instanceof GeneratedMetamodel) {
				parserRuleType.getClassifier().setName(newName);
			}
		}

	}
}
