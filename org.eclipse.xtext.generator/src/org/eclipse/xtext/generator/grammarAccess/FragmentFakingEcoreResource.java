/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated(forRemoval = true)
public class FragmentFakingEcoreResource extends XMIResourceImpl {

	private final ResourceSaveIndicator isSaving;

	public FragmentFakingEcoreResource(URI uri, ResourceSaveIndicator isSaving) {
		super(uri);
		this.isSaving = isSaving;

		setEncoding("UTF-8");
	    getDefaultSaveOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
	    getDefaultSaveOptions().put(XMLResource.OPTION_LINE_WIDTH, 80);
	    getDefaultSaveOptions().put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());
	}

	@Override
	protected boolean useIDs()
	{
	  return eObjectToIDMap != null || idToEObjectMap != null;
	}

	@Override
	public String getURIFragment(EObject eObject) {
		if (isSaving.isSaving()) {
			if (eObject instanceof EClassifier) {
	    		String result = getURIFragment((EClassifier) eObject);
	    		if (result != null)
	    			return result;
			}
		}
		return super.getURIFragment(eObject);
	}

	public String getURIFragment(EClassifier eObject) {
		// we need to handle empty subpackages in a special way
		EClassifier classifier = eObject;
		if (classifier.getEPackage().getESuperPackage() != null) {
			StringBuilder result = new StringBuilder(60);
			calculateURIFragment(classifier.getEPackage(), result, Sets.<EPackage>newHashSet());
			result.append(classifier.getName());
			return result.toString();
		}
		return null;
	}

	private void calculateURIFragment(EPackage ePackage, StringBuilder result, Set<EPackage> visited) {
		if (!visited.add(ePackage)) {
			throw new IllegalStateException();
		}
		if (ePackage.getESuperPackage() != null) {
			if (ePackage.eResource() == ePackage.getESuperPackage().eResource()) {
				calculateURIFragment(ePackage.getESuperPackage(), result, visited);
				if (!ePackage.getEClassifiers().isEmpty()) {
					if (result.length() != 0)
						result.append(ePackage.getName()).append('/');
					else
						result.append("//");
				}
			} else {
				result.append("//");
			}
		} else {
			result.append("//");
		}
	}
}