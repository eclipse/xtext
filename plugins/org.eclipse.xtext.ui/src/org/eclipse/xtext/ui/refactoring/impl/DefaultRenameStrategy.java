/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
public class DefaultRenameStrategy extends AbstractRenameStrategy {

	public static class Provider implements IRenameStrategy.Provider {

		@Inject
		private ILocationInFileProvider locationInFileProvider;

		@Inject
		private IValueConverterService valueConverterService;

		public IRenameStrategy get(final EObject targetElement, IRenameElementContext renameElementContext) {
			EAttribute nameAttribute = getNameAttribute(targetElement);
			if (nameAttribute == null)
				return null;
			return new DefaultRenameStrategy(targetElement, nameAttribute, getOriginalNameRegion(targetElement,
					nameAttribute), getNameRuleName(targetElement, nameAttribute), getValueConverterService());
		}

		protected ITextRegion getOriginalNameRegion(final EObject targetElement, EAttribute nameAttribute) {
			return getLocationInFileProvider().getFullTextRegion(targetElement, nameAttribute, 0);
		}

		protected ILocationInFileProvider getLocationInFileProvider() {
			return locationInFileProvider;
		}

		protected IValueConverterService getValueConverterService() {
			return valueConverterService;
		}

		protected EAttribute getNameAttribute(EObject targetElement) {
			return SimpleAttributeResolver.NAME_RESOLVER.getAttribute(targetElement);
		}

		protected String getNameRuleName(EObject targetElement, EAttribute nameAttribute) {
			List<INode> nameNodes = NodeModelUtils.findNodesForFeature(targetElement, nameAttribute);
			if (nameNodes.size() != 1 || !(nameNodes.get(0).getGrammarElement() instanceof RuleCall)) {
				return null;
			}
			return ((RuleCall) nameNodes.get(0).getGrammarElement()).getRule().getName();
		}

	}

	protected ITextRegion originalNameRegion;

	protected String nameRuleName;

	protected IValueConverterService valueConverterService;
	
	/*
	 * This is somewhat hacky but we have to maintain the reference to the object itself until 
	 * we can inject the IValueConverterService for backwards compatibility reasons
	 */
	/**
	 * @deprecated exists for backwards compatibility reasons only and will be removed in Xtext 2.1
	 */
	@Deprecated
	private EObject temporaryObjectReference;

	protected DefaultRenameStrategy(EObject targetElement, EAttribute nameAttribute, ITextRegion originalNameRegion,
			String nameRuleName, IValueConverterService valueConverterService) {
		super(targetElement, nameAttribute);
		this.originalNameRegion = originalNameRegion;
		this.nameRuleName = nameRuleName;
		this.valueConverterService = valueConverterService;
	}

	/**
	 * @deprecated exists for backwards compatibility reasons only and will be removed in Xtext 2.1
	 */
	@Deprecated
	protected DefaultRenameStrategy(EObject targetElement,
			ILocationInFileProvider locationInFileProvider) {
		super(targetElement);
		originalNameRegion = locationInFileProvider.getFullTextRegion(targetElement, getNameAttribute(), 0);
		this.temporaryObjectReference = targetElement;
	}
	
	/**
	 * @deprecated exists for backwards compatibility reasons only and will be removed in Xtext 2.1
	 */
	@SuppressWarnings("unused")
	@Deprecated
	@Inject
	private void injectServicesForDeprecationReasons(IValueConverterService valueConverter) {
		try {
			if (nameRuleName != null)
				return;
			this.valueConverterService = valueConverter;
			nameRuleName = getNameRuleName(temporaryObjectReference, getNameAttribute());
		} finally {
			temporaryObjectReference = null;
		}
	}
	
	/**
	 * @deprecated exists for backwards compatibility reasons only and will be removed in Xtext 2.1
	 */
	@Deprecated
	private String getNameRuleName(EObject targetElement, EAttribute nameAttribute) {
		List<INode> nameNodes = NodeModelUtils.findNodesForFeature(targetElement, nameAttribute);
		if (nameNodes.size() != 1 || !(nameNodes.get(0).getGrammarElement() instanceof RuleCall)) {
			return null;
		}
		return ((RuleCall) nameNodes.get(0).getGrammarElement()).getRule().getName();
	}

	public void createDeclarationUpdates(String newName, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor) {
		updateAcceptor.accept(getTargetElementOriginalURI().trimFragment(), getDeclarationTextEdit(newName));
	}

	protected TextEdit getDeclarationTextEdit(String newName) {
		String text = newName;
		return new ReplaceEdit(originalNameRegion.getOffset(), originalNameRegion.getLength(), text);
	}

	protected String getNameAsText(String nameAsValue) {
		return (nameRuleName != null) ? valueConverterService.toString(nameAsValue, nameRuleName) : nameAsValue;
	}
	
	protected String getNameAsValue(String nameAsText) {
		return (nameRuleName != null) ? valueConverterService.toValue(nameAsText, nameRuleName, null).toString() : nameAsText;
	}
	
	@Override
	public String getOriginalName() {
		return getNameAsText(super.getOriginalName());
	}

	@Override
	public void applyDeclarationChange(String newName, ResourceSet resourceSet) {
		super.applyDeclarationChange(getNameAsValue(newName), resourceSet);
	}
}
