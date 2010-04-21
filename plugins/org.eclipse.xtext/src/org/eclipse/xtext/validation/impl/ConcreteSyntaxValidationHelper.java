/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ConcreteSyntaxValidationHelper {

	@Inject
	protected ITransientValueService transSrvc;

	public int countNonTransientValues(EObject obj, EStructuralFeature feat) {
		if (feat.isMany()) {
			int count = 0, max = ((List<?>) obj.eGet(feat)).size();
			if (transSrvc.isMixedList(obj, feat)) {
				for (int i = 0; i < max; i++)
					if (!transSrvc.isTransient(obj, feat, i))
						count++;
				return count;
			}
			return transSrvc.isTransient(obj, feat, 0) ? 0 : max;
		}
		return transSrvc.isTransient(obj, feat, 0) ? 0 : 1;
	}

	public boolean isEObjectTransient(EObject obj) {
		if (obj.eContainmentFeature() == null)
			return false;
		EReference ref = obj.eContainmentFeature();
		EObject cnt = obj.eContainer();
		if (ref.isMany() && transSrvc.isMixedList(cnt, ref)) {
			if (transSrvc.isTransient(cnt, ref, ((List<?>) cnt.eGet(ref)).indexOf(obj)))
				return true;
		} else if (transSrvc.isTransient(cnt, ref, 0))
			return true;
		return false;
	}
}
