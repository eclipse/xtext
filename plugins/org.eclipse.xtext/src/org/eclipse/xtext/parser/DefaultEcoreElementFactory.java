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
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultEcoreElementFactory implements IAstFactory {

	// required due to static initializer in template for metamodelAccess
	@SuppressWarnings("unused")
	@Inject
	private IMetamodelAccess metamodelAccess;
	
	@Inject
	private IValueConverterService converterService;

	@Inject
	private IGrammarAccess grammarAccess;
	
	@Inject(optional=true)
	private ITokenToStringConverter tokenConverter;
	
	public IValueConverterService getConverterService() {
		return converterService;
	}

	public void setConverterService(IValueConverterService converterService) {
		this.converterService = converterService;
	}

	public IGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}

	public void setGrammarAccess(IGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	public EObject create(String fullTypeName) {
		EClass clazz = getEClass(fullTypeName);
		if (clazz == null)
			throw new IllegalArgumentException("Couldn't find EClass for name " + fullTypeName);

		if (clazz.isAbstract() || clazz.isInterface())
			throw new IllegalArgumentException("Can't create instance of abstract type " + fullTypeName);
		return clazz.getEPackage().getEFactoryInstance().create(clazz);
	}

	public void set(EObject _this, String feature, Object value, String ruleName, AbstractNode node) throws ValueConverterException {
		value = getTokenValue(value, ruleName, node);
		EObject eo = (EObject) _this;
		EStructuralFeature structuralFeature = eo.eClass().getEStructuralFeature(feature);
		if (structuralFeature == null)
			throw new IllegalArgumentException(feature);
		eo.eSet(structuralFeature, value);
	}
	
	private Object getTokenValue(Object tokenOrValue, String ruleName, AbstractNode node) throws ValueConverterException {
		try {
			Object value = getTokenAsStringIfPossible(tokenOrValue);
			if (value instanceof CharSequence && ruleName != null) {
				value = converterService.toValue(value.toString(), ruleName, node);
			}
			return value;
		} catch(ValueConverterException e) {
			throw e;
		} catch(Exception e) {
			throw new ValueConverterException(null, node, e);
		}	
	}

	protected Object getTokenAsStringIfPossible(Object tokenOrValue) {
		if (tokenConverter != null)
			return tokenConverter.getTokenAsStringIfPossible(tokenOrValue);
		return tokenOrValue;
	}
	
	@SuppressWarnings("unchecked")
	public void add(EObject _this, String feature, Object value, String ruleName, AbstractNode node) throws ValueConverterException {
		if (value == null)
			return;
		value = getTokenValue(value, ruleName, node);
		EObject eo = (EObject) _this;
		EStructuralFeature structuralFeature = eo.eClass().getEStructuralFeature(feature);
		((Collection) eo.eGet(structuralFeature)).add(value);
	}

	protected EPackage getEPackage(AbstractMetamodelDeclaration metaModelDecl) {
		if (metaModelDecl == null)
			throw new NullPointerException();
		if (metaModelDecl.getEPackage() == null)
			throw new NullPointerException("Cannot find package for declared model '" + metaModelDecl.getAlias() + "'");
		return metaModelDecl.getEPackage();
	}
	
	protected String getNsURI(AbstractMetamodelDeclaration metamodelDecl) {
		if (metamodelDecl.getEPackage() != null)
			return metamodelDecl.getEPackage().getNsURI();
		return null;
	}

	public EClass getEClass(String fullTypeName) {
		return findEClassByName(grammarAccess.getGrammar(), fullTypeName);
	}
	
	public EClass findEClassByName(Grammar grammar, String fullTypeName) {
		final String[] splitted = fullTypeName.split("::");
		String alias = "";
		String type = fullTypeName;
		if (splitted.length > 1) {
			alias = splitted[0];
			type = splitted[1];
		}
		final List<AbstractMetamodelDeclaration> declarations = GrammarUtil.allMetamodelDeclarations(grammar);
		AbstractMetamodelDeclaration resultMetaModel = null;
		EClassifier result = null;
		for (AbstractMetamodelDeclaration decl : declarations) {
			if (Strings.isEmpty(alias) || GrammarUtil.isSameAlias(decl.getAlias(), alias)) {
				EPackage pack = getEPackage(decl);
				if (pack != null) {
					EClassifier candidate = pack.getEClassifier(type);
					if (candidate != null) {
						if (resultMetaModel == null) {
							resultMetaModel = decl;
							result = candidate;
						} else {
							if (GrammarUtil.isSameAlias(resultMetaModel.getAlias(), alias)) {
								if (GrammarUtil.isSameAlias(decl.getAlias(), alias)) {
									return null;
								}
							} else {
								if (GrammarUtil.isSameAlias(decl.getAlias(), alias)) {
									resultMetaModel = decl;
									result = candidate;
								} else {
									result = null;
								}
							}
						}
					} 
				}
			}
		}
		if (!(result instanceof EClass))
			return null;
		return (EClass) result;
	}

}
