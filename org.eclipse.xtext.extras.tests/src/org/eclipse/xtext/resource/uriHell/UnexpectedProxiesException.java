/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.uriHell;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.ImmutableList;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnexpectedProxiesException extends RuntimeException {
	private static final long serialVersionUID = -2087009837170430037L;

	public UnexpectedProxiesException(Map<EObject, Collection<EStructuralFeature.Setting>> unresolved) {
		super(toStringRepresentiation(unresolved));
	}

	private static String toStringRepresentiation(Map<EObject, Collection<EStructuralFeature.Setting>> unresolved) {
		Set<URI> uris = new HashSet<>();
		for (Collection<EStructuralFeature.Setting> collection : unresolved.values()) {
			for (EStructuralFeature.Setting setting : collection) {
				uris.addAll(UnexpectedProxiesException.getURIs(setting));
			}
		}
		return uris.toString();
	}

	public static List<URI> getURIs(EStructuralFeature.Setting setting) {
		Object it = setting.get(false);
		if (it instanceof EObject) {
			return ImmutableList.of(EcoreUtil.getURI(((EObject) it)));
		}
		if (it instanceof List) {
			List<URI> result = new ArrayList<>();
			for (Object o : ((List<?>) it)) {
				if (o instanceof EObject) {
					result.add(EcoreUtil.getURI((EObject) o));
				}
			}
			return result;
		}
		return null;
	}
}
