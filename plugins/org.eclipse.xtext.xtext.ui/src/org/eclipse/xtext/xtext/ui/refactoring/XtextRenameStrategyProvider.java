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
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XtextRenameStrategyProvider extends DefaultRenameStrategy.Provider {

	@Override
	public IRenameStrategy get(EObject targetElement, final IRenameElementContext renameElementContext) {
		return new XtextSwitch<IRenameStrategy>() {

			@Override
			public IRenameStrategy caseAbstractMetamodelDeclaration(AbstractMetamodelDeclaration metamodelDeclaration) {
				return XtextRenameStrategyProvider.super.get(metamodelDeclaration, renameElementContext);
			}

			@Override
			public IRenameStrategy caseParserRule(ParserRule parserRule) {
				EAttribute nameAttribute = getNameAttribute(parserRule);
				return new DefaultRenameStrategy(parserRule, nameAttribute, getOriginalNameRegion(parserRule,
						nameAttribute), getNameRuleName(parserRule, nameAttribute), getValueConverterService()) {
					@Override
					protected EObject setName(URI targetElementURI, String newName, ResourceSet resourceSet) {
						renameReturnType(targetElementURI, newName, resourceSet);
						return super.setName(targetElementURI, newName, resourceSet);
					}

					@Override
					public void createDeclarationUpdates(String newName, ResourceSet resourceSet,
							IRefactoringUpdateAcceptor updateAcceptor) {
						super.createDeclarationUpdates(newName, resourceSet, updateAcceptor);
					}

					protected void renameReturnType(URI targetElementURI, String newName, ResourceSet resourceSet) {
						ParserRule parserRule = (ParserRule) resourceSet.getEObject(targetElementURI, false);
						TypeRef parserRuleType = parserRule.getType();
						if (parserRule.getName().equals(parserRuleType.getClassifier().getName())
								&& parserRuleType.getMetamodel() instanceof GeneratedMetamodel) {
							parserRuleType.getClassifier().setName(newName);
						}
					}
				};
			}

			@Override
			public IRenameStrategy caseGrammar(Grammar grammar) {
				return XtextRenameStrategyProvider.super.get(grammar, renameElementContext);
			}
		}.doSwitch(targetElement);
	}

	@Override
	protected EAttribute getNameAttribute(EObject targetElement) {
		if (targetElement instanceof AbstractMetamodelDeclaration) {
			return XtextPackage.Literals.ABSTRACT_METAMODEL_DECLARATION__ALIAS;
		}
		return super.getNameAttribute(targetElement);
	}
}
