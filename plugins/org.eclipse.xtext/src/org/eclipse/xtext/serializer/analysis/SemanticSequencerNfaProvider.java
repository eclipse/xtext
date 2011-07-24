/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.SynAbsorberNfaAdapter;
import org.eclipse.xtext.serializer.impl.FeatureFinderUtil;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.INfaAdapter;
import org.eclipse.xtext.util.formallang.INfaFactory;
import org.eclipse.xtext.util.formallang.NfaUtil;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class SemanticSequencerNfaProvider implements ISemanticSequencerNfaProvider {

	protected static class SemNfa implements INfaAdapter<ISemState, List<ISemState>> {

		protected List<ISemState> starts = Lists.newArrayList();
		protected List<ISemState> stops = Lists.newArrayList();

		public SemNfa(List<ISemState> starts, List<ISemState> stops) {
			super();
			this.starts = starts;
			this.stops = stops;
		}

		public List<ISemState> getFinalStates() {
			return stops;
		}

		public List<ISemState> getFollowers(ISemState node) {
			return node.getFollowers();
		}

		public List<ISemState> getStartStates() {
			return starts;
		}

	}

	protected static class SemState implements ISemState {

		protected AbstractElement assignedGrammarElement;
		protected EStructuralFeature feature;
		protected int featureID = -1;
		protected List<ISemState> followers;
		protected EClass type;
		protected List<AbstractElement> contentValidationNeeded;

		public SemState(EClass type, AbstractElement assignedGrammarElement) {
			super();
			this.type = type;
			this.assignedGrammarElement = assignedGrammarElement;
		}

		public AbstractElement getAssignedGrammarElement() {
			return assignedGrammarElement;
		}

		public EStructuralFeature getFeature() {
			if (feature == null && assignedGrammarElement != null)
				feature = FeatureFinderUtil.getFeature(assignedGrammarElement, type);
			return feature;
		}

		public int getFeatureID() {
			if (featureID < 0)
				featureID = type.getFeatureID(getFeature());
			return featureID;
		}

		public List<ISemState> getFollowers() {
			return followers == null ? Collections.<ISemState> emptyList() : followers;
		}

		public List<AbstractElement> getToBeValidatedAssignedElements() {
			return contentValidationNeeded;
		}

		@Override
		public String toString() {
			if (assignedGrammarElement == null)
				return "(null)";
			return new GrammarElementTitleSwitch().showQualified().showAssignments().apply(assignedGrammarElement);
		}
	}

	protected static class SemStateFactory implements INfaFactory<ISemState, List<ISemState>, ISynAbsorberState> {

		public ISemState createEndState(ISynAbsorberState token) {
			return new SemState(token.getEClass(), token.getGrammarElement());
		}

		public INfaAdapter<ISemState, List<ISemState>> createNfa(Iterable<ISemState> startStates,
				Iterable<ISemState> stopStates) {
			return new SemNfa(Lists.newArrayList(startStates), Lists.newArrayList(stopStates));
		}

		public ISemState createStartState(ISynAbsorberState token) {
			return new SemState(token.getEClass(), token.getGrammarElement());
		}

		public ISemState createState(ISynAbsorberState token) {
			return new SemState(token.getEClass(), token.getGrammarElement());
		}

		public void setFollowers(ISemState owner, Iterable<ISemState> followers) {
			((SemState) owner).followers = Lists.newArrayList(followers);
		}

	}

	@Inject
	protected ISyntacticSequencerPDAProvider pdaProvider;

	protected Map<Pair<EObject, EClass>, INfaAdapter<ISemState, List<ISemState>>> cache = Maps.newHashMap();

	public INfaAdapter<ISemState, List<ISemState>> getNFA(EObject context, EClass type) {
		Pair<EObject, EClass> key = Tuples.create(context, type);
		INfaAdapter<ISemState, List<ISemState>> nfa = cache.get(key);
		if (nfa != null)
			return nfa;
		NfaUtil util = new NfaUtil();
		SynAbsorberNfaAdapter synNfa = new SynAbsorberNfaAdapter(pdaProvider.getPDA(context, type));
		//		System.out.println(new NfaFormatter().format(synNfa));
		nfa = util.create(synNfa, new SemStateFactory());
		Map<ISemState, Integer> distanceMap = util.distanceToFinalStateMap(nfa);
		util.sortInplace(nfa, distanceMap);
		initContentValidationNeeded(type, nfa);
		//		System.out.println(new NfaFormatter().format(nfa));
		cache.put(key, nfa);
		return nfa;
	}

	protected boolean isContentValidationNeeded(Collection<AbstractElement> ass) {
		if (ass == null || ass.size() < 2)
			return false;
		Iterator<AbstractElement> it = ass.iterator();
		AbstractElement first = it.next();
		CrossReference firstRef = GrammarUtil.containingCrossReference(first);
		while (it.hasNext()) {
			AbstractElement next = it.next();
			if (!EcoreUtil.equals(first, next))
				return true;
			if (firstRef != null) {
				CrossReference nextRef = GrammarUtil.containingCrossReference(next);
				if (nextRef != null && nextRef.getType().getClassifier() != firstRef.getType().getClassifier())
					return true;
			}
		}
		return false;
	}

	protected void initContentValidationNeeded(EClass clazz, INfaAdapter<ISemState, List<ISemState>> nfa) {
		Multimap<EStructuralFeature, AbstractElement> assignments = HashMultimap.create();
		Set<ISemState> states = new NfaUtil().collect(nfa);
		for (ISemState state : states)
			if (state.getFeature() != null)
				assignments.put(state.getFeature(), state.getAssignedGrammarElement());
		boolean[] validationNeeded = new boolean[clazz.getFeatureCount()];
		for (EStructuralFeature feature : clazz.getEAllStructuralFeatures())
			validationNeeded[clazz.getFeatureID(feature)] = isContentValidationNeeded(assignments.get(feature));
		for (ISemState state : states)
			if (state.getFeature() != null && validationNeeded[state.getFeatureID()])
				((SemState) state).contentValidationNeeded = Lists.newArrayList(assignments.get(state.getFeature()));
			else
				((SemState) state).contentValidationNeeded = Collections.emptyList();
	}
}
