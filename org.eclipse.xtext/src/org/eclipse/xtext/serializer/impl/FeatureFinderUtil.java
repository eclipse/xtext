/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;

import com.google.common.base.Preconditions;

/**
 * @author Sebastian Zarnekow - Moved from GrammarUtil
 */
public class FeatureFinderUtil {

	/**
	 * @since 2.0
	 */
	public static EStructuralFeature getFeature(AbstractElement grammarElement, EClass owner) {
		Preconditions.checkNotNull(owner);
		if (grammarElement == null)
			return null;
		String featureName = null;
		if (grammarElement instanceof Action)
			featureName = ((Action) grammarElement).getFeature();
		else {
			Assignment ass = GrammarUtil.containingAssignment(grammarElement);
			if (ass != null)
				featureName = ass.getFeature();
		}
		if (featureName != null)
			return owner.getEStructuralFeature(featureName);
		return null;
	}

}
