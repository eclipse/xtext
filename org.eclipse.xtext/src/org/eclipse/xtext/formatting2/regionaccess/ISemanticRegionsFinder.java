/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ISemanticRegionsFinder extends ISemanticRegionFinder {

	List<ISemanticRegion> assignments(Assignment... assignments);

	List<ISemanticRegion> crossRefs(CrossReference... crossReferences);

	List<ISemanticRegion> elements(AbstractElement... elements);

	List<ISemanticRegion> features(EStructuralFeature... features);

	List<Pair<ISemanticRegion, ISemanticRegion>> keywordPairs(Keyword kw1, Keyword kw2);

	List<Pair<ISemanticRegion, ISemanticRegion>> keywordPairs(String kw1, String kw2);

	List<ISemanticRegion> keywords(Keyword... keywords);

	List<ISemanticRegion> keywords(String... keywords);

	List<ISemanticRegion> ruleCalls(RuleCall... ruleCalls);

	List<ISemanticRegion> ruleCallsTo(AbstractRule... rules);

}
