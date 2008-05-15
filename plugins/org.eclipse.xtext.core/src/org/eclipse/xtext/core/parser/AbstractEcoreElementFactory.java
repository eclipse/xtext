/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.core.parser;

import java.util.Collection;

import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public abstract class AbstractEcoreElementFactory implements IElementFactory {

	public EObject create(String fullTypeName) {
		String[] split = fullTypeName.split("::");
		String typeName = fullTypeName;
		String alias = null;
		if (split.length > 1) {
			alias = split[0];
			typeName = split[1];
		}
		EPackage[] packages = getEPackages(alias);
		if (packages == null || packages.length == 0) {
			throw new IllegalStateException(
					"Couldn't find any epackages for alias '" + alias + "'");
		}
		for (EPackage package1 : packages) {
			if (package1 == null)
				throw new IllegalStateException(
						"Problems loading EPackages for alias '" + alias
								+ "' - one entry was null.");
			EClassifier classifier = package1.getEClassifier(typeName);
			if (classifier instanceof EClass) {
				EClass clazz = (EClass) classifier;
				EObject newObject = clazz.getEPackage().getEFactoryInstance()
						.create(clazz);
				return newObject;
			}
		}

		return null;
	}

	public void set(EObject _this, String feature, Object value) {
		if (value instanceof Token) {
			value = ((Token) value).getText();
		}
		EObject eo = (EObject) _this;
		EStructuralFeature structuralFeature = eo.eClass()
				.getEStructuralFeature(feature);
		eo.eSet(structuralFeature, value);
	}

	@SuppressWarnings("unchecked")
	public void add(EObject _this, String feature, Object value) {
		EObject eo = (EObject) _this;
		EStructuralFeature structuralFeature = eo.eClass()
				.getEStructuralFeature(feature);
		((Collection) eo.eGet(structuralFeature)).add(value);
	}

	protected abstract EPackage[] getEPackages(String alias);

}
