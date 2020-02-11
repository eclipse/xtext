/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.grammarAccess

import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.xmi.XMLResource
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.Wrapper

class FragmentFakingEcoreResource extends XMIResourceImpl {
	
	val Wrapper<Boolean> isSaving

	new(URI uri, Wrapper<Boolean> isSaving) {
		super(uri)
		this.isSaving = isSaving
		encoding = "UTF-8"
		getDefaultSaveOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, true)
		getDefaultSaveOptions.put(XMLResource.OPTION_LINE_WIDTH, 80)
		getDefaultSaveOptions.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware)
	}

	override protected boolean useIDs() {
		eObjectToIDMap !== null || idToEObjectMap !== null
	}

	override String getURIFragment(EObject eObject) {
		if (isSaving.get) {
			if (eObject instanceof EClassifier) {
				val result = eObject.URIFragment
				if (result !== null)
					return result
			}
		}
		return super.getURIFragment(eObject)
	}

	def String getURIFragment(EClassifier classifier) {
		// We need to handle empty subpackages in a special way
		if (classifier.EPackage.ESuperPackage !== null) {
			val result = new StringBuilder(60)
			calculateURIFragment(classifier.EPackage, result, newHashSet)
			result.append(classifier.name)
			return result.toString
		}
		return null
	}

	def private void calculateURIFragment(EPackage ePackage, StringBuilder result, Set<EPackage> visited) {
		if (!visited.add(ePackage)) {
			throw new IllegalStateException
		}
		if (ePackage.ESuperPackage !== null) {
			if (ePackage.eResource === ePackage.ESuperPackage.eResource) {
				calculateURIFragment(ePackage.ESuperPackage, result, visited)
				if (!ePackage.EClassifiers.empty) {
					if (result.length !== 0) {
						result.append(ePackage.name).append('/')
					} else {
						result.append('//')
					}
				}
			} else {
				result.append('//')
			}
		} else {
			result.append('//')
		}
	}

	@FinalFieldsConstructor	
	static class FactoryImpl extends EcoreResourceFactoryImpl {

		public static final String ECORE_SUFFIX = "ecore";

		val Wrapper<Boolean> isSaving
	
		override createResource(URI uri) {
			return new FragmentFakingEcoreResource(uri, isSaving)
		}
	
	}

}
