/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EcoreUtil2.FindResult;
import org.eclipse.xtext.util.Strings;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Heiko Behrens
 * 
 */
public abstract class EClassifierInfo {

	private final EClassifier eClassifier;
	private final boolean isGenerated;

	private EClassifierInfo(EClassifier metaType, boolean isGenerated) {
		super();
		this.isGenerated = isGenerated;
		this.eClassifier = metaType;
	}

	public static EClassifierInfo createEClassInfo(EClass eClass, boolean isGenerated, Set<String> generatedEPackageURIs) {
		return new EClassInfo(eClass, isGenerated, generatedEPackageURIs);
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

	public boolean isAssignableFrom(EClassifierInfo subTypeInfo) {
		return getEClassifier().equals(subTypeInfo.getEClassifier());
	}

	public abstract boolean addSupertype(EClassifierInfo superTypeInfo);

	public abstract boolean addFeature(String featureName, EClassifierInfo featureType, boolean isMultivalue,
			boolean isContainment, EObject parserElement) throws TransformationException;

	public static class EClassInfo extends EClassifierInfo {

		private Set<String> generatedEPackageURIs;
		
		public EClassInfo(EClassifier metaType, boolean isGenerated, Set<String> generatedEPackageURIs) {
			super(metaType, isGenerated);
			this.generatedEPackageURIs = generatedEPackageURIs;
		}

		@Override
		public boolean isAssignableFrom(EClassifierInfo subTypeInfo) {
			return super.isAssignableFrom(subTypeInfo) || (subTypeInfo instanceof EClassInfo)
					&& (getEClass().isSuperTypeOf((EClass) subTypeInfo.getEClassifier())
							|| EcorePackage.Literals.EOBJECT == getEClass());
		}

		@Override
		public boolean addSupertype(EClassifierInfo superTypeInfo) {
			EClass eClass = getEClass();
			EClass superEClass = (EClass) superTypeInfo.getEClassifier();

			if (superEClass.isSuperTypeOf(eClass)) {
				return true;
			}

			if (!isGenerated()) {
				throw new IllegalStateException("Type " + this.getEClassifier().getName()
						+ " is not generated and cannot be modified.");
			}
			if (!(superTypeInfo instanceof EClassInfo)) {
				throw new IllegalArgumentException("superTypeInfo must represent EClass");
			}

			if (eClass.equals(superEClass))
				// cannot add class as it's own superclass
				// this usually happens due to a rule call
				return false;

			return eClass.getESuperTypes().add(superEClass);
		}

		@Override
		public boolean addFeature(String featureName, EClassifierInfo featureType, boolean isMultivalue,
				boolean isContainment, EObject parserElement) throws TransformationException {
			EClassifier featureClassifier = featureType.getEClassifier();
			return addFeature(featureName, featureClassifier, isMultivalue, isContainment, parserElement);
		}

		public boolean addFeature(EStructuralFeature prototype) {
			try {
				boolean isContainment = false;
				if (prototype instanceof EReference) {
					EReference reference = (EReference) prototype;
					isContainment = reference.isContainment();
				}
				return addFeature(prototype.getName(), prototype.getEType(), prototype.isMany(), isContainment, null);
			}
			catch (TransformationException e) {
				throw new IllegalArgumentException(e.getMessage());
			}
		}

		private boolean addFeature(String featureName, EClassifier featureClassifier, boolean isMultivalue,
				boolean isContainment, EObject parserElement) throws TransformationException {
			if (!isGenerated()) {
				if (!EcoreUtil2.containsCompatibleFeature(getEClass(), featureName, isMultivalue, isContainment, featureClassifier)) {
					throw new TransformationException(TransformationErrorCode.CannotCreateTypeInSealedMetamodel, "Cannot find compatible feature "+featureName+" in sealed EClass "+getEClass().getName()+" from imported package "+getEClass().getEPackage().getNsURI()+".", parserElement);
				}
				return true;
			}
			EStructuralFeature newFeature = createFeatureWith(featureName, featureClassifier, isMultivalue,
					isContainment);

			FindResult containsSemanticallyEqualFeature = EcoreUtil2.containsSemanticallyEqualFeature(getEClass(), newFeature);
			switch (containsSemanticallyEqualFeature) {
				case FeatureDoesNotExist:
					if (!isGenerated())
						throw new TransformationException(TransformationErrorCode.CannotCreateTypeInSealedMetamodel, "Cannot create feature in sealed metamodel.", parserElement);
					return getEClass().getEStructuralFeatures().add(newFeature);
				case FeatureExists:
					// do nothing
					return false;
				default:
					// do nothing
			}

			// feature with same name exists, but has a different, 
			// potentially incompatible configuration
			EStructuralFeature existingFeature = getEClass().getEStructuralFeature(featureName);

			if (!EcoreUtil2.isFeatureSemanticallyEqualApartFromType(newFeature, existingFeature))
				throw new TransformationException(TransformationErrorCode.FeatureWithDifferentConfigurationAlreadyExists,
						"A feature '" + newFeature.getName() + "' with a different cardinality or containment " +
								"configuration already exists in type '" + getEClass().getName() + "'.",
						parserElement);
			
			EClassifier compatibleType = EcoreUtil2.getCompatibleType(existingFeature.getEType(), newFeature.getEType());
			if (compatibleType == null)
				throw new TransformationException(TransformationErrorCode.NoCompatibleFeatureTypeAvailable,
						"Cannot find compatible type for features", parserElement);
			
			if (isGenerated(existingFeature)) {
				existingFeature.setEType(compatibleType);
			} else {
				throw new TransformationException(TransformationErrorCode.FeatureWithDifferentConfigurationAlreadyExists,
						"Incompatible return type to existing feature", parserElement);
			}
			return true;
		}

		/**
		 * @param existingFeature
		 * @return
		 */
		private boolean isGenerated(EStructuralFeature existingFeature) {
			return generatedEPackageURIs.contains(existingFeature.getEContainingClass().getEPackage().getNsURI());
		}

		private EStructuralFeature createFeatureWith(String featureName, EClassifier featureClassifier,
				boolean isMultivalue, boolean isContainment) {
			EStructuralFeature newFeature;

			if (featureClassifier instanceof EClass) {
				EReference reference = EcoreFactory.eINSTANCE.createEReference();
				reference.setContainment(isContainment);
				newFeature = reference;
			} else {
				newFeature = EcoreFactory.eINSTANCE.createEAttribute();
			}
			newFeature.setName(featureName);
			newFeature.setEType(featureClassifier);
			newFeature.setLowerBound(0);
			newFeature.setUpperBound(isMultivalue ? -1 : 1);
			newFeature.setUnique(!isMultivalue || (isContainment && featureClassifier instanceof EClass));
			if (newFeature.getEType() instanceof EEnum) {
				newFeature.setDefaultValue(null);
			}
			return newFeature;
		}

		public EClass getEClass() {
			return ((EClass) getEClassifier());
		}
	}

	public static class EDataTypeInfo extends EClassifierInfo {

		public EDataTypeInfo(EClassifier metaType, boolean isGenerated) {
			super(metaType, isGenerated);
		}

		@Override
		public boolean addSupertype(EClassifierInfo superTypeInfo) {
			throw new UnsupportedOperationException("Cannot add supertype "
					+ Strings.emptyIfNull(superTypeInfo.getEClassifier().getName()) + " to simple datatype "
					+ Strings.emptyIfNull(this.getEClassifier().getName()));
		}

		@Override
		public boolean addFeature(String featureName, EClassifierInfo featureType, boolean isMultivalue,
				boolean isContainment, EObject parserElement) throws TransformationException {
			throw new UnsupportedOperationException("Cannot add feature " + featureName + " to simple datatype "
					+ Strings.emptyIfNull(this.getEClassifier().getName()));
		}

	}

}
