/*******************************************************************************
 * Copyright (c) 2008, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.util.ReflectionUtil;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Heiko Behrens
 * 
 */
public abstract class EClassifierInfo {

	private final EClassifier eClassifier;
	private final boolean isGenerated;

	protected EClassifierInfo(EClassifier metaType, boolean isGenerated) {
		this.isGenerated = isGenerated;
		this.eClassifier = metaType;
	}

	public static EClassifierInfo createEClassInfo(EClass eClass, boolean isGenerated, Set<String> generatedEPackageURIs, Grammar grammar) {
		return new EClassInfo(eClass, isGenerated, generatedEPackageURIs, grammar);
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

	public abstract boolean addFeature(String featureName, EClassifierInfoAccess featureTypeInfo, boolean isMultivalue,
			boolean isContainment, AbstractElement parserElement) throws TransformationException;
	
	public static class EClassInfo extends EClassifierInfo {

		private Set<String> generatedEPackageURIs;
		private Grammar grammar;
		
		public EClassInfo(EClass metaType, boolean isGenerated, Set<String> generatedEPackageURIs, Grammar grammar) {
			super(metaType, isGenerated);
			this.generatedEPackageURIs = generatedEPackageURIs;
			this.grammar = grammar;
		}
		
		@Override
		public String toString() {
			return "ClassifierInfo : " + getEClass().getName();
		}

		@Override
		public boolean isAssignableFrom(EClassifierInfo subTypeInfo) {
			return super.isAssignableFrom(subTypeInfo) || (subTypeInfo instanceof EClassInfo)
					&& isAssignableFrom(getEClass(),(EClass) subTypeInfo.getEClassifier());
		}
		
		/**
	     * Determine whether the class represented by {@code left} is either the same as
	     * or is a superclass of the class represented by {@code right}.
		 */
		protected boolean isAssignableFrom(EClass left, EClass right) {
			if (right != null && left.isSuperTypeOf(right))
				return true;
			EClass eObjectType = GrammarUtil.findEObject(grammar);
			if (left == eObjectType)
				return true;
			if (grammar != null) {
				Resource grammarResource = grammar.eResource();
				if (grammarResource != null) {
					ResourceSet resourceSet = grammarResource.getResourceSet();
					if (resourceSet != null) {
						EPackage.Registry registry = resourceSet.getPackageRegistry();
						if (registry != null) {
							EPackage ecorePackage = registry.getEPackage(EcorePackage.eNS_URI);
							if (ecorePackage != null) {
								EClassifier eObjectFromRegistry = ecorePackage.getEClassifier(EcorePackage.Literals.EOBJECT.getName());
								if (left == eObjectFromRegistry) {
									return true;
								}
							}
						}
					}
				}
			}
			if (right != null && left.getInstanceClass() != null && right.getInstanceClass() != null) {
				boolean result = left.getInstanceClass().isAssignableFrom(right.getInstanceClass());
				return result;
			}
			return false;
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
		public boolean addFeature(String featureName, EClassifierInfoAccess featureTypeInfo, boolean isMultivalue,
				boolean isContainment, AbstractElement parserElement) throws TransformationException {
			ImmutableList<EClassifier> featureClassifiers = FluentIterable.from(featureTypeInfo.getCurrentTypes()).transform(EClassifierInfo::getEClassifier).toList();
			EClassifier compatibleType = featureTypeInfo.getCurrentCompatibleType().getEClassifier();
			return addFeature(featureName, featureClassifiers, compatibleType, isMultivalue, isContainment, parserElement);
		}

		public boolean addFeature(EStructuralFeature prototype) {
			try {
				boolean isContainment = false;
				if (prototype instanceof EReference) {
					EReference reference = (EReference) prototype;
					isContainment = reference.isContainment();
				}
				boolean result = addFeature(prototype.getName(), Arrays.asList(prototype.getEType()), prototype.getEType(), prototype.isMany(), isContainment, null);
				if (result) {
					EStructuralFeature newFeature = getEClass().getEStructuralFeature(prototype.getName());
					SourceAdapter oldAdapter = SourceAdapter.find(prototype);
					if (oldAdapter != null) {
						for(EObject source: oldAdapter.getSources())
							SourceAdapter.adapt(newFeature, source);	
					}
				}
				return result;
			}
			catch (TransformationException e) {
				throw new IllegalArgumentException(e.getMessage());
			}
		}
		
		public boolean containsCompatibleFeature(
				String name, 
				boolean isMulti, 
				boolean isContainment,
				EClassifier expectedType,
				StringBuilder errorMessage) {
			EStructuralFeature assignedExistingFeature = getEClass().getEStructuralFeature(name);
			if (assignedExistingFeature != null) {
				if (!assignedExistingFeature.isChangeable()) {
					errorMessage.append("The existing feature '" + name + "' is not changeable.");
					return false;
				} else {
					boolean many = assignedExistingFeature.isMany();
					if (many == isMulti) {
						if (expectedType instanceof EClass && assignedExistingFeature.getEType() instanceof EClass) {
							EClass castedExpectedType = (EClass) expectedType;
							EClass castedExistingType = (EClass) assignedExistingFeature.getEType();
							boolean result = isAssignableFrom(castedExistingType, castedExpectedType);
							if (!result) {
								if (isAssignableByID(castedExistingType, castedExpectedType)) {
									errorMessage.append("The type " + classifierToString(castedExistingType) + " used in the reference '" + name + "' is inconsistent. " +
											"Probably this is due to an unsupported kind of metamodel hierarchy.");
								} else if (castedExistingType instanceof InternalEObject && castedExistingType.eIsProxy()) {
									URI proxyURI = ((InternalEObject) castedExistingType).eProxyURI();
									errorMessage.append("The type of the reference '" + name + "' could not be resolved. The URI is " + proxyURI);
								} else {
									errorMessage.append("The existing reference '" + name + "' has an incompatible type " + classifierToString(castedExistingType) + ". " +
											"The expected type is " + classifierToString(castedExpectedType) + ".");
								}
								return result;
							}
							result &= isContainment == ((EReference) assignedExistingFeature).isContainment();
							if (!result) {
								if (isContainment)
									errorMessage.append("The existing reference '" + name + "' is not a containment reference.");
								else
									errorMessage.append("The existing reference '" + name + "' is a containment reference.");
								return result;
							}
							result &= !((EReference) assignedExistingFeature).isContainer();
							if (!result) {
								errorMessage.append("The existing reference '" + name + "' is a container reference.");
								return result;
							}
							return result;
						} else if (expectedType instanceof EDataType && assignedExistingFeature.getEType() instanceof EDataType) {
							EDataType castedExpectedType = (EDataType) expectedType;
							EDataType castedExistingType = (EDataType) assignedExistingFeature.getEType();
							Class<?> expectedInstanceClass = ReflectionUtil.getObjectType(castedExpectedType.getInstanceClass());
							Class<?> existingInstanceClass = ReflectionUtil.getObjectType(castedExistingType.getInstanceClass());
							boolean result = castedExistingType.equals(castedExpectedType) || expectedInstanceClass != null && existingInstanceClass != null
									&& existingInstanceClass.isAssignableFrom(expectedInstanceClass);
							if (!result) {
								errorMessage.append("The existing attribute '" + name + "' has an incompatible type " + classifierToString(castedExistingType) + ". " +
										"The expected type is " + classifierToString(castedExpectedType) + ".");
							}
							return result;
						} else {
							String msgPart = " has no type.";
							if (assignedExistingFeature.getEType() != null)
								msgPart = " has an incompatible type " + classifierToString(assignedExistingFeature.getEType())+ ". " +
										"The expected type is " + classifierToString(expectedType) + ".";
							errorMessage.append("The existing feature '" + name + "'" + msgPart);
						}
					} else {	
						errorMessage.append("The existing feature '" + name + "' has a different cardinality.");
					}
				}
			} else {
				errorMessage.append("The type '" + getEClass().getName() + "' does not have a feature '" + name + "'.");
			}
			return false;
		}
		
		private String classifierToString(EClassifier classifier) {
			String result = "'" + classifier.getName() + "'";
			if (classifier.getInstanceTypeName() != null)
				result += " [" + classifier.getInstanceTypeName() + "]";
			return result;
		}
		
		/**
	     * Determine whether the class represented by {@code left} is either the same as
	     * or is a superclass of the class represented by {@code right} comparing the classifier ID
	     * and namespace URI.
		 */
		private boolean isAssignableByID(EClass left, EClass right) {
			if (left.getEPackage() != null) {
				// Compare namespace URI and classifier Id
				if (left.getClassifierID() == right.getClassifierID()
						&& right.getEPackage() != null
						&& left.getEPackage().getNsURI().equals(right.getEPackage().getNsURI())) {
					return true;
				}
				// Check all super-types of the right class
				for (EClass superClass : right.getEAllSuperTypes()) {
					if (left.getClassifierID() == superClass.getClassifierID()
							&& superClass.getEPackage() != null
							&& left.getEPackage().getNsURI().equals(superClass.getEPackage().getNsURI())) {
						return true;
					}
				}
			}
			return false;
		}
		
		public boolean isFeatureSemanticallyEqualApartFromType(EStructuralFeature f1, EStructuralFeature f2) {
			boolean result = f1.getName().equals(f2.getName());
			result &= f1.isMany() == f2.isMany();
			if (f1 instanceof EReference && f2 instanceof EReference)
				result &= ((EReference) f1).isContainment() == ((EReference) f2).isContainment();
			return result;
		}

		private boolean isFeatureSemanticallyEqualTo(EStructuralFeature f1, EStructuralFeature f2, Set<EClassifier> f2Types) {
			if (f1 == f2) {
				return true;
			}
			boolean result = isFeatureSemanticallyEqualApartFromType(f1, f2);
			if (f1 instanceof EReference && f2 instanceof EReference) {
				EClass f1Type = ((EReference)f1).getEReferenceType();
				result &= ((EReference) f1).isContainment() == ((EReference) f2).isContainment();
				result &= ((EReference) f1).isContainer() == ((EReference) f2).isContainer();
				if (result) {
					for(EClassifier f2Type: f2Types) {
						if (f2Type instanceof EClass) {
							if (!f1Type.isSuperTypeOf((EClass) f2Type)) {
								return false;
							}
						} else {
							return false;
						}
					}
				}
			} else {
				result &= f1.getEType().equals(EcoreUtil2.getCompatibleType(f1.getEType(), f2.getEType()));
			}
			return result;
		}

		public static enum FindResult {
			FeatureDoesNotExist, FeatureExists, DifferentFeatureWithSameNameExists
		}

		public EStructuralFeature findFeatureByName(Collection<EStructuralFeature> features, String name) {
			if (name == null)
				return null;
			for (EStructuralFeature feature : features)
				if (name.equals(feature.getName()))
					return feature;
			return null;
		}

		public FindResult containsSemanticallyEqualFeature(EStructuralFeature feature) {
			return containsSemanticallyEqualFeature(feature, Collections.singleton(feature.getEType()));
		}
		
		public FindResult containsSemanticallyEqualFeature(EStructuralFeature feature, Set<EClassifier> toBeAssignedTypes) {
			return containsSemanticallyEqualFeature(getEClass().getEAllStructuralFeatures(), feature, toBeAssignedTypes);
		}

		public FindResult containsSemanticallyEqualFeature(Collection<EStructuralFeature> features,
				EStructuralFeature feature) {
			return containsSemanticallyEqualFeature(features, feature, Collections.singleton(feature.getEType()));
		}
		
		public FindResult containsSemanticallyEqualFeature(Collection<EStructuralFeature> features,
				EStructuralFeature feature, Set<EClassifier> toBeAssignedTypes) {
			EStructuralFeature potentiallyEqualFeature = findFeatureByName(features, feature.getName());
			if (potentiallyEqualFeature == null)
				return FindResult.FeatureDoesNotExist;
			else if (isFeatureSemanticallyEqualTo(potentiallyEqualFeature, feature, toBeAssignedTypes))
				return FindResult.FeatureExists;
			else
				return FindResult.DifferentFeatureWithSameNameExists;
		}

		private boolean addFeature(
				String featureName,
				List<EClassifier> featureTypes,
				EClassifier compatibleSuperType,
				boolean isMultivalue,
				boolean isContainment, AbstractElement grammarElement) throws TransformationException {
			if (!isGenerated()) {
				StringBuilder errorMessage = new StringBuilder();
				for(EClassifier featureType: featureTypes) {
	 				if (!containsCompatibleFeature(featureName, isMultivalue, isContainment, featureType, errorMessage)) {
						throw new TransformationException(TransformationErrorCode.CannotCreateTypeInSealedMetamodel, 
								"Cannot find compatible feature "+featureName+" in sealed EClass "+getEClass().getName()+" from imported package "+getEClass().getEPackage().getNsURI()+": " + errorMessage.toString(), 
								grammarElement);
					}
				}
				return true;
			}
			EStructuralFeature newFeature = createFeatureWith(featureName, compatibleSuperType, isMultivalue,
					isContainment);

			FindResult containsSemanticallyEqualFeature = containsSemanticallyEqualFeature(newFeature);
			switch (containsSemanticallyEqualFeature) {
				case FeatureDoesNotExist:
					if (!isGenerated())
						throw new TransformationException(TransformationErrorCode.CannotCreateTypeInSealedMetamodel, "Cannot create feature in sealed metamodel.", grammarElement);
					if (grammarElement != null)
						SourceAdapter.adapt(newFeature, grammarElement);
					return getEClass().getEStructuralFeatures().add(newFeature);
				case FeatureExists:
					if (isGenerated()) {
						EStructuralFeature existingFeature = findFeatureByName(getEClass().getEAllStructuralFeatures(), featureName);
						if (grammarElement != null)
							SourceAdapter.adapt(existingFeature, grammarElement);
					}
					return false;
				default:
					// do nothing
			}

			// feature with same name exists, but has a different, 
			// potentially incompatible configuration
			EStructuralFeature existingFeature = getEClass().getEStructuralFeature(featureName);

			if (!isFeatureSemanticallyEqualApartFromType(newFeature, existingFeature))
				throw new TransformationException(TransformationErrorCode.FeatureWithDifferentConfigurationAlreadyExists,
						"A feature '" + newFeature.getName() + "' with a different cardinality or containment " +
								"configuration already exists in type '" + getEClass().getName() + "'.",
						grammarElement);
			
			EClassifier compatibleType = EcoreUtil2.getCompatibleType(existingFeature.getEType(), newFeature.getEType(), grammarElement);
			if (compatibleType == null)
				throw new TransformationException(TransformationErrorCode.NoCompatibleFeatureTypeAvailable,
						"Cannot find compatible type for the feature '" + existingFeature.getName() + "'", grammarElement);
			
			if (isGenerated(existingFeature)) {
				existingFeature.setEType(compatibleType);
			} else {
				throw new TransformationException(TransformationErrorCode.FeatureWithDifferentConfigurationAlreadyExists,
						"Incompatible return type to existing feature", grammarElement);
			}
			return true;
		}

		protected boolean isGenerated(EStructuralFeature existingFeature) {
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
		public boolean addFeature(String featureName, EClassifierInfoAccess featureType, boolean isMultivalue,
				boolean isContainment, AbstractElement parserElement) throws TransformationException {
			throw new UnsupportedOperationException("Cannot add feature " + featureName + " to simple datatype "
					+ Strings.emptyIfNull(this.getEClassifier().getName()));
		}

	}

}
