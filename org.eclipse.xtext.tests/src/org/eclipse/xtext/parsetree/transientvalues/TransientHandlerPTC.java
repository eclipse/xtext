/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.transientvalues;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TransientHandlerPTC extends DefaultTransientValueService {

	@Override
	public boolean isTransient(EObject owner, EStructuralFeature feature, int index) {
		// System.out.println("isTransient " + feature.getName()
		// + ((index >= 0) ? "[" + index + "]" : ""));
		final String n = feature.getName();
		if ("required1".equals(n) || "required2".equals(n))
			return true;
		if ("opt1".equals(n) || "opt2".equals(n))
			return true;
		if ("item".equals(n)) {
			List<?> l = (List<?>) owner.eGet(feature);
			return ((Integer) l.get(index) % 2) == 0;
		}
		return super.isTransient(owner, feature, index);
	}

	@Override
	public boolean isCheckElementsIndividually(EObject owner, EStructuralFeature feature) {
		// System.out.println("isMixedList " + feature.getName());
		if ("TestList".equals(owner.eClass().getName()))
			return true;
		return super.isCheckElementsIndividually(owner, feature);
	}

}
