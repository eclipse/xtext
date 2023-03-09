/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ISemanticRegionFinder {

	ISemanticRegion assignment(Assignment assignment);

	ISemanticRegion crossRef(CrossReference crossReference);

	ISemanticRegion element(AbstractElement element);

	ISemanticRegion feature(EStructuralFeature feature);

	ISemanticRegion keyword(Keyword keyword);

	ISemanticRegion keyword(String keyword);

	ISemanticRegion ruleCall(RuleCall ruleCall);

	ISemanticRegion ruleCallTo(AbstractRule rule);
}
