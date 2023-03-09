/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public enum SemanticRegionNullFinder implements ISemanticRegionsFinder {
	INSTANCE;

	@Override
	public ISemanticRegion assignment(Assignment assignment) {
		return null;
	}

	@Override
	public List<ISemanticRegion> assignments(Assignment... assignments) {
		return Collections.emptyList();
	}

	@Override
	public ISemanticRegion crossRef(CrossReference crossReference) {
		return null;
	}

	@Override
	public List<ISemanticRegion> crossRefs(CrossReference... crossReferences) {
		return Collections.emptyList();
	}

	@Override
	public ISemanticRegion element(AbstractElement element) {
		return null;
	}

	@Override
	public List<ISemanticRegion> elements(AbstractElement... elements) {
		return Collections.emptyList();
	}

	@Override
	public ISemanticRegion feature(EStructuralFeature feature) {
		return null;
	}

	@Override
	public List<ISemanticRegion> features(EStructuralFeature... features) {
		return Collections.emptyList();
	}

	@Override
	public ISemanticRegion keyword(Keyword keyword) {
		return null;
	}

	@Override
	public ISemanticRegion keyword(String keyword) {
		return null;
	}

	@Override
	public List<Pair<ISemanticRegion, ISemanticRegion>> keywordPairs(Keyword kw1, Keyword kw2) {
		return Collections.emptyList();
	}

	@Override
	public List<Pair<ISemanticRegion, ISemanticRegion>> keywordPairs(String kw1, String kw2) {
		return Collections.emptyList();
	}

	@Override
	public List<ISemanticRegion> keywords(Keyword... keywords) {
		return Collections.emptyList();
	}

	@Override
	public List<ISemanticRegion> keywords(String... keywords) {
		return Collections.emptyList();
	}

	@Override
	public ISemanticRegion ruleCall(RuleCall ruleCall) {
		return null;
	}

	@Override
	public List<ISemanticRegion> ruleCalls(RuleCall... ruleCalls) {
		return Collections.emptyList();
	}

	@Override
	public List<ISemanticRegion> ruleCallsTo(AbstractRule... rules) {
		return Collections.emptyList();
	}

	@Override
	public ISemanticRegion ruleCallTo(AbstractRule rule) {
		return null;
	}

}
