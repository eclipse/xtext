/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.parser.edited;


import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.ValueConverterWithValueException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.ITokenToStringConverter;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultEcoreElementFactory {

	private static final Logger log = Logger.getLogger(DefaultEcoreElementFactory.class);
	
	@Inject
	private IValueConverterService converterService;

	@Inject(optional=true)
	private ITokenToStringConverter tokenConverter;

	public IValueConverterService getConverterService() {
		return converterService;
	}

	public void setConverterService(IValueConverterService converterService) {
		this.converterService = converterService;
	}

	public EObject create(EClassifier classifier) {
		if (classifier == null)
			throw new NullPointerException("Classifier may not be null.");
		if (!(classifier instanceof EClass))
			throw new IllegalArgumentException("Cannot create instance of datatype '" + classifier.getName() + "'");
		EClass clazz = (EClass) classifier;
		if (clazz.isAbstract() || clazz.isInterface())
			throw new IllegalArgumentException("Cannot create instance of abstract class '" + clazz.getName() + "'");
		if (classifier.eIsProxy())
			throw new IllegalStateException("Unresolved proxy "+((InternalEObject)classifier).eProxyURI()+". Make sure the EPackage has been registered.");
		return clazz.getEPackage().getEFactoryInstance().create(clazz);
	}

	public void set(EObject object, int structuralFeature, Object value, String ruleName, INode node) throws ValueConverterException {
		InternalEObject internalObject = (InternalEObject)object;
		try {
			internalObject.eSetDeliver(false);
			final Object tokenValue = getTokenValue(value, ruleName, node);
//			checkNullForPrimitiveFeatures(structuralFeature, tokenValue, node);
			internalObject.eSet(structuralFeature, tokenValue);
		} catch(ValueConverterWithValueException e) {
			final Object tokenValue = e.getValue();
//			checkNullForPrimitiveFeatures(structuralFeature, tokenValue, node);
			internalObject.eSet(structuralFeature, tokenValue);
		} catch(ValueConverterException e) {
			throw e;
		} catch(NullPointerException e) {
			log.warn(e.getMessage(), e);
			throw new ValueConverterException("A NullPointerException occured. This indicates a missing value converter or a bug in its implementation.", node, e);
		} catch(Exception e) {
			throw new ValueConverterException(null, node, e);
		} finally {
			internalObject.eSetDeliver(true);
		}
	}

	private Object getTokenValue(Object tokenOrValue, String ruleName, INode node) throws ValueConverterException {
		Object value = getTokenAsStringIfPossible(tokenOrValue);
		if ((value == null || value instanceof CharSequence) && ruleName != null) {
			value = converterService.toValue(value == null ? null : value.toString(), ruleName, node);
		}
		return value;
	}

	protected Object getTokenAsStringIfPossible(Object tokenOrValue) {
		if (tokenConverter != null)
			return tokenConverter.getTokenAsStringIfPossible(tokenOrValue);
		return tokenOrValue;
	}

	@SuppressWarnings("unchecked")
	public void add(EObject object, int feature, Object value, String ruleName, INode node) throws ValueConverterException {
		if (value == null)
			return;
		try {
			if (value instanceof EObject) {
				// containment lists are unique per-se and the tokenValue was created just a sec ago
				InternalEObject internalEObject = (InternalEObject)object;
				internalEObject.eSetDeliver(false);
				((InternalEList<EObject>) internalEObject.eGet(feature, false, false)).addUnique((EObject) value);
				internalEObject.eSetDeliver(true);
			} else {
				final Object tokenValue = getTokenValue(value, ruleName, node);
//				checkNullForPrimitiveFeatures(feature, value, node);
				InternalEObject internalEObject = (InternalEObject)object;
				internalEObject.eSetDeliver(false);
				((InternalEList<Object>) internalEObject.eGet(feature, false, false)).addUnique(tokenValue);
				internalEObject.eSetDeliver(true);
			}
		} catch(ValueConverterWithValueException e) {
			final Object tokenValue = e.getValue();
			InternalEObject internalEObject = (InternalEObject)object;
//			checkNullForPrimitiveFeatures(structuralFeature, value, node);
			internalEObject.eSetDeliver(false);
			((InternalEList<Object>) internalEObject.eGet(feature, false, false)).addUnique(tokenValue);
			internalEObject.eSetDeliver(true);
			throw e;
		} catch(ValueConverterException e) {
			throw e;
		} catch(NullPointerException e) {
			log.error(e.getMessage(), e);
			throw new ValueConverterException("A NullPointerException occured. This indicates a missing value converter or a bug in its implementation.", node, e);
		} catch(Exception e) {
			throw new ValueConverterException(null, node, e);
		}
	}

//	private void checkNullForPrimitiveFeatures(EStructuralFeature structuralFeature, Object tokenValue, INode node) {
//		if(tokenValue == null && structuralFeature.getEType().getInstanceClass().isPrimitive()) {
//			throw new ValueConverterException("ValueConverter returned null for primitive feature " + structuralFeature.getName(), node, null);
//		}
//	}
}
