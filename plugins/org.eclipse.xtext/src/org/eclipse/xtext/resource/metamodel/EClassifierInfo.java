/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

/**
 * @author Jan K?hnlein - Initial contribution and API
 * 
 */
public abstract class EClassifierInfo {

	private EClassifier eClassifier;
	private boolean isGenerated;

	private EClassifierInfo(EClassifier metaType, boolean isGenerated) {
		super();
		this.isGenerated = isGenerated;
		this.eClassifier = metaType;
	}

	public static EClassifierInfo createEClassInfo(EClass eClass, boolean isGenerated) {
		return new EClassInfo(eClass, isGenerated);
	}

	public static EClassifierInfo createEDataTypeInfo(EDataType eDataType, boolean isGenerated) {
		return new EDataTypeInfo(eDataType, isGenerated);
	}

	public EClassifier getEClass() {
		return eClassifier;
	}

	public boolean isGenerated() {
		return isGenerated;
	}

	public abstract boolean addSupertype(EClassifierInfo superTypeInfo);

	public abstract boolean addFeature(String featureName, EClassifierInfo featureType, boolean isMultivalue);

	static class EClassInfo extends EClassifierInfo {

		public EClassInfo(EClassifier metaType, boolean isGenerated) {
			super(metaType, isGenerated);
		}

		@Override
		public boolean addSupertype(EClassifierInfo superTypeInfo) {
			if (!isGenerated()) {
				throw new IllegalStateException("Generated Type cannot be modified.");
			}
			if (!(superTypeInfo instanceof EClassInfo)) {
				throw new IllegalArgumentException("superTypeInfo must represent EClass");
			}
			EClass eClass = (EClass) getEClass();
			EClass superEClass = (EClass) superTypeInfo.getEClass();
			return eClass.getESuperTypes().add(superEClass);
		}

		@Override
		public boolean addFeature(String featureName, EClassifierInfo featureType, boolean isMultivalue) {

			EClassifier featureClassifier = featureType.getEClass();

			EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
			attribute.setName(featureName);
			attribute.setEType(featureClassifier);
			attribute.setLowerBound(0);
			attribute.setUpperBound(isMultivalue ? -1 : 1);

			EList<EStructuralFeature> features = ((EClass) getEClass()).getEStructuralFeatures();
			return features.add(attribute);
		}
	}

	static class EDataTypeInfo extends EClassifierInfo {

		public EDataTypeInfo(EClassifier metaType, boolean isGenerated) {
			super(metaType, isGenerated);
		}

		@Override
		public boolean addSupertype(EClassifierInfo superTypeInfo) {
			throw new UnsupportedOperationException("Cannot add supertype to simple datatype");
		}

		@Override
		public boolean addFeature(String featureName, EClassifierInfo featureType, boolean isMultivalue) {
			throw new UnsupportedOperationException("Cannot add feature to simple datatype");
		}

	}
}
