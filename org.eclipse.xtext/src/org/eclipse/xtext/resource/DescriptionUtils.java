/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DescriptionUtils {

	/**
	 * Collect the URIs of resources, that are referenced by the given description.
	 * @return the list of referenced URIs. Never <code>null</code>.
	 */
	public Set<URI> collectOutgoingReferences(IResourceDescription description) {
		URI resourceURI = description.getURI();
		Set<URI> result = null;
		for(IReferenceDescription reference: description.getReferenceDescriptions()) {
			URI targetResource = reference.getTargetEObjectUri().trimFragment();
			if (!resourceURI.equals(targetResource)) {
				if (result == null)
					result = Sets.newHashSet(targetResource);
				else
					result.add(targetResource);
			}
		}
		if (result != null)
			return result;
		return Collections.emptySet();
	}
	
}
