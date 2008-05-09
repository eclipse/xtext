/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.core.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.antlr.runtime.Token;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public abstract class AbstractEcoreElementFactory implements IElementFactory {
	public Object create(String typeName) {
		EPackage[] packages = getEPackages();
		for (EPackage package1 : packages) {
			EClassifier classifier = package1.getEClassifier(typeName);
			if (classifier instanceof EClass) {
				EClass clazz = (EClass) classifier;
				return clazz.getEPackage().getEFactoryInstance().create(clazz);
			}
		}
		return null;
	}
		
	public void set(Object _this, String feature, Object value) {
		if (value instanceof Token) {
			value = ((Token)value).getText();
		}
		EObject eo = (EObject) _this;
		EStructuralFeature structuralFeature = eo.eClass().getEStructuralFeature(feature);
		eo.eSet(structuralFeature, value);
	}
	
	@SuppressWarnings("unchecked")
	public void add(Object _this, String feature, Object value) {
		EObject eo = (EObject) _this;
		EStructuralFeature structuralFeature = eo.eClass().getEStructuralFeature(feature);
		((Collection)eo.eGet(structuralFeature)).add(value);
	}
	
	protected abstract EPackage[] getEPackages();
	
}
