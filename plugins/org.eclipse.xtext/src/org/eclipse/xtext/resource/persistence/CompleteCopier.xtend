/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence

import org.eclipse.emf.ecore.EStructuralFeature
import java.util.Map
import java.util.Collection
import org.eclipse.emf.ecore.EObject
import java.util.List
import java.util.ArrayList
import java.util.LinkedHashMap
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.FeatureMapUtil
import org.eclipse.emf.ecore.util.InternalEList
import java.util.Iterator
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.util.FeatureMap
import org.eclipse.emf.ecore.InternalEObject

/** 
 * Similar to EcoreUtil.Copier (initially copied).
 * But copies proxy objects for external cross references.  
 */
class CompleteCopier {
	/** 
	 * Whether proxies should be resolved during copying.
	 */
	protected boolean resolveProxies = true
	/** 
	 * Whether non-copied references should be used during copying.
	 */
	protected boolean useOriginalReferences = false
	
	private LinkedHashMap<EObject, EObject> old2new = new LinkedHashMap<EObject, EObject>

	/** 
	 * Creates an instance.
	 */
	new() {
		super()
	}
	
	public static def <T> T completeCopy(T toCopy) {
		val copier = new CompleteCopier();
		switch toCopy {
			Collection<? extends InternalEObject> : {
				val copyOfAll = copier.copyAll(toCopy);
				copier.copyReferences
				return copyOfAll as T
			}
			InternalEObject : {
				val copyOfAll = copier.copy(toCopy);
				copier.copyReferences
				return copyOfAll as T
			}
			default :
				throw new IllegalArgumentException("toCopy - "+toCopy)
		}
	}

	/** 
	 * Returns a collection containing a copy of each EObject in the given collection.
	 * @param eObjects the collection of objects to copy.
	 * @return the collection of copies.
	 */
	def <T extends EObject> Collection<T> copyAll(Collection<? extends T> eObjects) {
		val Collection<T> result = new ArrayList<T>(eObjects.size())
		for (object : eObjects) {
			val t = copy(object)
			if (t != null) {
				result.add(t as T)
			}
		}
		return result
	}

	/** 
	 * Returns a copy of the given eObject.
	 * @param eObject the object to copy.
	 * @return the copy.
	 */
	def EObject copy(EObject eObject) {
		if (eObject == null) {
			return null
		} 
		val copyEObject = createCopy(eObject)
		if (copyEObject != null) {
			old2new.put(eObject, copyEObject)
			val EClass eClass = eObject.eClass()
			for (it : eClass.EAllStructuralFeatures.filter[isChangeable && !isDerived]) {
				switch it {
					EAttribute : 
						copyAttribute(it, eObject, copyEObject)
					EReference case isContainment :  
						copyContainment(it, eObject, copyEObject)
				}
			}
			copyProxyURI(eObject, copyEObject)
		}
		return copyEObject

	}

	/** 
	 * Copies the proxy URI from the original to the copy, if present.
	 * @param eObject the object being copied.
	 * @param copyEObject the copy being initialized.
	 */
	def protected void copyProxyURI(EObject eObject, EObject copyEObject) {
		if (eObject.eIsProxy()) {
			(copyEObject as InternalEObject).eSetProxyURI((eObject as InternalEObject).eProxyURI())
		}
	}

	/** 
	 * Returns a new instance of the object's target class.
	 * @param eObject the object to copy.
	 * @return a new instance of the target class.
	 * @see #getTarget(EObject)
	 * @see EcoreUtil#create(EClass)
	 */
	def protected EObject createCopy(EObject eObject) {
		val EClass eClass = getTarget(eObject)
		return if(eClass == null) null else EcoreUtil.create(eClass)
	}

	/** 
	 * Returns the target class used to create a copy instance for the given instance object.
	 * @param eObject the object to be copied.
	 * @return the target class used to create a copy instance.
	 * @since 2.10
	 */
	def protected EClass getTarget(EObject eObject) {
		return getTarget(eObject.eClass())
	}

	/** 
	 * Returns the target class used to create a copy instance for objects of the given source class.
	 * @param eClass the source class.
	 * @return the target class used to create a copy instance.
	 * @see #getTarget(EStructuralFeature, EObject, EObject)
	 */
	def protected EClass getTarget(EClass eClass) {
		return eClass
	}

	/** 
	 * Returns a setting for the feature and copy instance to be populated with the original object's source feature's value.
	 * @param eStructuralFeature the source feature.
	 * @return the target feature used to populate a copy instance.
	 * @see #getTarget(EStructuralFeature)
	 * @see #getTarget(EObject)
	 * @since 2.10
	 */
	def protected EStructuralFeature.Setting getTarget(EStructuralFeature eStructuralFeature, EObject eObject,
		EObject copyEObject) {

		val targetEStructuralFeature = getTarget(eStructuralFeature)
		return if (targetEStructuralFeature == null)
				null
			else
				(copyEObject as InternalEObject).eSetting(targetEStructuralFeature)
	}

	/** 
	 * Returns the target feature used to populate a copy instance from the given source feature.
	 * @param eStructuralFeature the source feature.
	 * @return the target feature used to populate a copy instance.
	 * @see #getTarget(EClass)
	 */
	def protected EStructuralFeature getTarget(EStructuralFeature eStructuralFeature) {
		return eStructuralFeature
	}

	/** 
	 * Called to handle the copying of a containment feature;
	 * this adds a list of copies or sets a single copy as appropriate for the multiplicity.
	 * @param eReference the feature to copy.
	 * @param eObject the object from which to copy.
	 * @param copyEObject the object to copy to.
	 */
	def protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
		if (eObject.eIsSet(eReference)) {

			val setting = getTarget(eReference, eObject, copyEObject)
			if (setting != null) {
				val value = eObject.eGet(eReference)
				if (eReference.isMany()) {
					/*FIXME can not add Annotation to Variable declaration. Java code: @SuppressWarnings("unchecked")*/
					val List<EObject> target = value as List<EObject>
					setting.set(copyAll(target))
				} else {
					setting.set(copy(value as EObject))
				}

			}

		}

	}

	/** 
	 * Called to handle the copying of an attribute;
	 * this adds a list of values or sets a single value as appropriate for the multiplicity.
	 * @param eAttribute the attribute to copy.
	 * @param eObject the object from which to copy.
	 * @param copyEObject the object to copy to.
	 */
	def protected void copyAttribute(EAttribute eAttribute, EObject eObject, EObject copyEObject) {
		if (eObject.eIsSet(eAttribute)) {
			if (FeatureMapUtil.isFeatureMap(eAttribute)) {
				val FeatureMap featureMap = eObject.eGet(eAttribute) as FeatureMap
				copyFeatureMap(featureMap)
			} else {
				val EStructuralFeature.Setting setting = getTarget(eAttribute, eObject, copyEObject)
				if (setting != null) {
					copyAttributeValue(eAttribute, eObject, eObject.eGet(eAttribute), setting)
				}
			}

		}

	}

	/** 
	 * Call to handle copying the contained objects within a feature map.
	 * @param featureMap the feature map the copy.
	 * @since 2.10
	 */
	def protected void copyFeatureMap(FeatureMap featureMap) {
		for (i : 0 ..< featureMap.size) {
			switch feature : featureMap.getEStructuralFeature(i) {
				EReference case feature.isContainment : {
					val Object value = featureMap.getValue(i)
					if (value != null) {
						// The containment references are hooked up later during copyReferences.
						copy(value as EObject)
					}
				}
			}
		}

	}

	/** 
	 * Called to handle copying of an attribute's value to the target setting.
	 * @param eAttribute the attribute of the source object corresponding to the value.
	 * @param eObject the object being copied.
	 * @param value the value to be copied.
	 * @param setting the feature-value pair that is the target of of the copy.
	 * @since 2.10
	 */
	def protected void copyAttributeValue(EAttribute eAttribute, EObject eObject, Object value, EStructuralFeature.Setting setting) {
		setting.set(value)
	}

	/** 
	 * Hooks up cross references; it delegates to {@link #copyReference copyReference}.
	 */
	def void copyReferences() {
		for (Map.Entry<EObject, EObject> it : old2new.entrySet()) {

			val eObject = key
			val copyEObject = value
			val EClass eClass = eObject.eClass()
			for (it : eClass.getEStructuralFeatures.filter[isChangeable && !isDerived]) {
				if (it instanceof EReference) {
					if (!isContainment() && !isContainer()) {
						copyReference(it, eObject, copyEObject)
					}
				} else if (FeatureMapUtil.isFeatureMap(it)) {
					val copyFeatureMap = getTarget(it, eObject, copyEObject) as FeatureMap
					if (copyFeatureMap != null) {
						val featureMap = eObject.eGet(it) as FeatureMap
						var copyFeatureMapSize = copyFeatureMap.size()
						for (k : 0 ..< featureMap.size) {
							switch feature : featureMap.getEStructuralFeature(k) {
								// skip the following
								EReference : {
									val Object referencedEObject = featureMap.getValue(k)
									var Object copyReferencedEObject = old2new.get(referencedEObject)
									if (copyReferencedEObject == null && referencedEObject != null) {
										if (!useOriginalReferences || feature.isContainment() ||
											feature.getEOpposite() != null) {
										} else {
											copyReferencedEObject = referencedEObject
										}
									}
									// If we can't add it, it must already be in the list so find it and move it to the end.
									//
									if (!copyFeatureMap.add(feature, copyReferencedEObject)) {
										for (var int l = 0; l < copyFeatureMapSize;( l = l + 1)) {
											if (copyFeatureMap.getEStructuralFeature(l) == feature &&
												copyFeatureMap.getValue(l) == copyReferencedEObject) {
												copyFeatureMap.move(copyFeatureMap.size() - 1, l)
												copyFeatureMapSize = copyFeatureMapSize - 1
												 /* FIXME unsupported BreakStatement: */ 
											}
										}
									}
								}
								default : 
									copyFeatureMap.add(getTarget(featureMap.getEStructuralFeature(k)),
										featureMap.getValue(k))
							}
						}
					}
				}
			}
		}
	}

	/** 
	 * Called to handle the copying of a cross reference;
	 * this adds values or sets a single value as appropriate for the multiplicity
	 * while omitting any bidirectional reference that isn't in the copy map.
	 * @param eReference the reference to copy.
	 * @param eObject the object from which to copy.
	 * @param copyEObject the object to copy to.
	 */
	def protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {
		if (eObject.eIsSet(eReference)) {
			val setting = getTarget(eReference, eObject, copyEObject)
			if (setting != null) {
				val Object value = eObject.eGet(eReference, resolveProxies)
				if (eReference.isMany()) {
					val source = value as InternalEList<EObject>
					val target = setting as InternalEList<EObject>
					if (source.isEmpty) {
						target.clear
					} else {
						val isBidirectional = eReference.getEOpposite != null
						var int index = 0
						for (val Iterator<EObject> k = if(resolveProxies) source.iterator() else source.basicIterator(); k.hasNext();) {
							val referencedEObject = k.next()
							val copyReferencedEObject = old2new.get(referencedEObject)
							if (copyReferencedEObject == null) {
								if (useOriginalReferences && !isBidirectional) {
									target.addUnique(index, referencedEObject)
									index = index + 1 
								} else {
									target.addUnique(index, createProxy(referencedEObject))
								}
							} else {
								if (isBidirectional) {
									val int position = target.indexOf(copyReferencedEObject)
									if (position == -1) {
										target.addUnique(index, copyReferencedEObject)
									} else if (index != position) {
										target.move(index, copyReferencedEObject)
									}
								} else {
									target.addUnique(index, copyReferencedEObject)
								}
								index = index + 1 
							}

						}

					}

				} else {
					if (value == null) {
						setting.set(null)
					} else {
						val Object copyReferencedEObject = old2new.get(value)
						if (copyReferencedEObject == null) {
							if (useOriginalReferences && eReference.getEOpposite() == null) {
								setting.set(value)
							} else {
								setting.set(createProxy(value as EObject))
							}
						} else {
							setting.set(copyReferencedEObject)
						}

					}

				}

			}

		}

	}
	
	def EObject createProxy(EObject object) {
		val proxyURI = EcoreUtil.getURI(object)
		val proxy = EcoreUtil.create(object.eClass)
		(proxy as InternalEObject).eSetProxyURI(proxyURI)
		return proxy
	}

}