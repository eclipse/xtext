/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.parser;

import java.util.Collection;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.service.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class GenericEcoreElementFactory implements IAstFactory {

	@Inject
	protected IMetamodelAccess metamodelAccess;

	@Inject
	protected IValueConverterService converterService;

	@Inject
	protected IGrammarAccess grammarAccess;

	public EObject create(String fullTypeName) {
		EClass clazz = getEClass(fullTypeName);
		if (clazz == null)
			throw new IllegalArgumentException("Coudln't find EClass for name " + fullTypeName);

		if (clazz.isAbstract() || clazz.isInterface())
			throw new IllegalArgumentException("Can't create instance of abstract type " + fullTypeName);
		return clazz.getEPackage().getEFactoryInstance().create(clazz);
	}

	@Deprecated
	public void set(EObject _this, String feature, Object value) throws RecognitionException {
		set(_this, feature, value, null);
	}

	public void set(EObject _this, String feature, Object value, String ruleName) throws RecognitionException {
		try {
			if (value instanceof Token) {
				value = ((Token) value).getText();
				if (ruleName != null) {
					value = converterService.toValue((String) value, ruleName);
				}
			}
			EObject eo = (EObject) _this;
			EStructuralFeature structuralFeature = eo.eClass().getEStructuralFeature(feature);
			eo.eSet(structuralFeature, value);
		} catch (Exception exc) {
			throw new RecognitionException();
		}
	}

	@Deprecated
	public void add(EObject _this, String feature, Object value) throws RecognitionException {
		add(_this, feature, value, null);
	}

	@SuppressWarnings("unchecked")
	public void add(EObject _this, String feature, Object value, String ruleName) throws RecognitionException {
		try {
			if (value == null)
				return;
			if (value instanceof Token) {
				value = ((Token) value).getText();
				if (ruleName != null) {
					value = converterService.toValue((String) value, ruleName);
				}
			}
			EObject eo = (EObject) _this;
			EStructuralFeature structuralFeature = eo.eClass().getEStructuralFeature(feature);
			((Collection) eo.eGet(structuralFeature)).add(value);
		} catch (Exception exc) {
			throw new RecognitionException();
		}
	}

	protected EPackage getEPackage(AbstractMetamodelDeclaration metaModelDecl) {
		AbstractMetamodelDeclaration decl = metaModelDecl == null ? 
				GrammarUtil.findDefaultMetaModel(grammarAccess.getGrammar()) : metaModelDecl;
		if (decl != null) {
			if (decl instanceof GeneratedMetamodel) {
				GeneratedMetamodel mm = (GeneratedMetamodel) decl;
				return EcoreUtil2.loadEPackage(mm.getNsURI(), grammarAccess.getClass().getClassLoader());
			} else {
				ReferencedMetamodel mm = (ReferencedMetamodel) decl;
				return EcoreUtil2.loadEPackage(mm.getUri(), grammarAccess.getClass().getClassLoader());
			}
		}
		String languageId = GrammarUtil.getLanguageId(grammarAccess.getGrammar());
		throw new IllegalArgumentException("No EPackage without alias could be found for language "
				+ languageId);
	}

	public EClass getEClass(String fullTypeName) {
		TypeRef typeRef = GrammarUtil.getTypeRef(grammarAccess.getGrammar(), fullTypeName);
		EPackage pack = getEPackage(typeRef.getMetamodel());
		if (pack == null) {
			throw new IllegalStateException("Couldn't find any epackages for typeref '" + fullTypeName + "'");
		}
		EClassifier classifier = pack.getEClassifier(typeRef.getName());
		if (classifier instanceof EClass) {
			return (EClass) classifier;
		}
		return null;
	}

}
