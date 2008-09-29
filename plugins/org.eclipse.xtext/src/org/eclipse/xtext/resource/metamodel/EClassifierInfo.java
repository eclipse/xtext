/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource.metamodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.metamodel.ErrorAcceptor.ErrorCode;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Heiko Behrens
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

	public EClassifier getEClassifier() {
		return eClassifier;
	}

	public boolean isGenerated() {
		return isGenerated;
	}

	public abstract boolean addSupertype(EClassifierInfo superTypeInfo);

	public abstract boolean addFeature(String featureName, EClassifierInfo featureType, boolean isMultivalue,
			boolean isContainment, EObject parserElement) throws TransformationException;

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
			EClass eClass = getEClass();
			EClass superEClass = (EClass) superTypeInfo.getEClassifier();
			if(eClass.equals(superEClass))
				// cannot add class as it's own superclass
				// this usually happens due to a rule call
				return false;
			else
				return eClass.getESuperTypes().add(superEClass);
		}

		private EStructuralFeature findFeatureInClassIgnoringSuperclasses(EClass eClass, String featureName) {
			for (EStructuralFeature feature : eClass.getEStructuralFeatures())
				if (feature.getName().equals(featureName))
					return feature;
			return null;
		}

		@Override
		public boolean addFeature(String featureName, EClassifierInfo featureType, boolean isMultivalue,
				boolean isContainment, EObject parserElement) throws TransformationException {

			EClassifier featureClassifier = featureType.getEClassifier();
			return addFeature(featureName, featureClassifier, isMultivalue, isContainment, parserElement);
		}

		private boolean addFeature(String featureName, EClassifier featureClassifier, boolean isMultivalue,
				boolean isContainment, EObject parserElement) throws TransformationException {
			EStructuralFeature newFeature;

			if (featureClassifier instanceof EClass) {
				EReference reference = EcoreFactory.eINSTANCE.createEReference();
				reference.setContainment(isContainment);
				newFeature = reference;
			}
			else
				newFeature = EcoreFactory.eINSTANCE.createEAttribute();
			newFeature.setName(featureName);
			newFeature.setEType(featureClassifier);
			newFeature.setLowerBound(0);
			newFeature.setUpperBound(isMultivalue ? -1 : 1);

			EList<EStructuralFeature> features = getEClass().getEStructuralFeatures();
			EStructuralFeature existentFeature = findFeatureInClassIgnoringSuperclasses(getEClass(), featureName);
			if (existentFeature == null) {
				// feature does not exist, yet
				return features.add(newFeature);
			}
			else {
				if (newFeature.getLowerBound() != existentFeature.getLowerBound()
						|| newFeature.getUpperBound() != existentFeature.getUpperBound())
					throw new TransformationException(ErrorCode.FeatureWithDifferentConfigurationAlreadyExists,
							"feature with different cardinality already exists " + newFeature, parserElement);
				else {
				    // TODO Extract into something more genreral that can be used for uplifting
					// same name but different type => feature should have
					// compatible type
					// remove and add again to overcome problem with reference
					// vs. attribute
					EClassifier compatibleType = EcoreUtil2.getCompatibleType(existentFeature.getEType(), newFeature
							.getEType());
					if (compatibleType == null)
						throw new TransformationException(ErrorCode.NoCompatibleFeatureTypeAvailable,
								"Cannot find compatible type for features", parserElement);
					int oldIndex = features.indexOf(existentFeature);
					features.remove(existentFeature);
					addFeature(featureName, compatibleType, isMultivalue, isContainment, parserElement);
					existentFeature = findFeatureInClassIgnoringSuperclasses(getEClass(), featureName);
					features.move(oldIndex, existentFeature);
					return true;
				}
			}
		}

		private EClass getEClass() {
			return ((EClass) getEClassifier());
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
		public boolean addFeature(String featureName, EClassifierInfo featureType, boolean isMultivalue,
				boolean isContainment, EObject parserElement) throws TransformationException {
			throw new UnsupportedOperationException("Cannot add feature to simple datatype");
		}

	}
}
