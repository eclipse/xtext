/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.BitSet;
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
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleNames;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.SynAbsorberNfaAdapter;
import org.eclipse.xtext.serializer.impl.FeatureFinderUtil;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaFactory;
import org.eclipse.xtext.util.formallang.NfaUtil;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class SemanticSequencerNfaProvider implements ISemanticSequencerNfaProvider {

	protected static class SemNfa implements Nfa<ISemState> {

		protected final ISemState start;
		protected final ISemState stop;

		public SemNfa(ISemState starts, ISemState stops) {
			super();
			this.start = starts;
			this.stop = stops;
		}

		@Override
		public List<ISemState> getFollowers(ISemState node) {
			return node.getFollowers();
		}

		@Override
		public ISemState getStart() {
			return start;
		}

		@Override
		public ISemState getStop() {
			return stop;
		}

	}

	protected static class SemState implements ISemState {

		protected BitSet allFollowerFeatures;
		protected AbstractElement assignedGrammarElement;
		protected List<AbstractElement> contentValidationNeeded;
		protected EStructuralFeature feature;
		protected int featureID = -2;
		protected List<ISemState> followers;
		protected int orderID = 0;
		protected EClass type;
		protected Boolean booleanAssignment;

		public SemState(EClass type, AbstractElement assignedGrammarElement) {
			super();
			this.type = type;
			this.assignedGrammarElement = assignedGrammarElement;
		}

		@Override
		public BitSet getAllFollowerFeatures() {
			if (allFollowerFeatures == null)
				allFollowerFeatures = new BitSet();
			return allFollowerFeatures;
		}

		@Override
		public AbstractElement getAssignedGrammarElement() {
			return assignedGrammarElement;
		}

		@Override
		public EStructuralFeature getFeature() {
			if (feature == null && assignedGrammarElement != null)
				feature = FeatureFinderUtil.getFeature(assignedGrammarElement, type);
			return feature;
		}

		@Override
		public int getFeatureID() {
			if (featureID < -1)
				featureID = getFeature() != null ? type.getFeatureID(getFeature()) : -1;
			return featureID;
		}

		@Override
		public List<ISemState> getFollowers() {
			return followers == null ? Collections.<ISemState> emptyList() : followers;
		}

		@Override
		public int getOrderID() {
			return orderID;
		}

		@Override
		public List<AbstractElement> getToBeValidatedAssignedElements() {
			return contentValidationNeeded;
		}

		@Override
		public String toString() {
			if (assignedGrammarElement == null)
				return "(null)";
			return new GrammarElementTitleSwitch().showQualified().showAssignments().apply(assignedGrammarElement);
		}

		@Override
		public boolean isBooleanAssignment() {
			if (booleanAssignment == null) {
				Assignment assignment = GrammarUtil.containingAssignment(assignedGrammarElement);
				booleanAssignment = assignment != null && GrammarUtil.isBooleanAssignment(assignment);
			}
			return booleanAssignment;
		}
	}

	protected static class SemStateFactory implements NfaFactory<SemNfa, ISemState, ISynAbsorberState> {

		@Override
		public SemNfa create(ISynAbsorberState start, ISynAbsorberState stop) {
			SemState starts = new SemState(stop.getEClass(), stop.getGrammarElement());
			SemState stops = new SemState(start.getEClass(), start.getGrammarElement());
			return new SemNfa(starts, stops);
		}

		@Override
		public ISemState createState(SemNfa nfa, ISynAbsorberState token) {
			return new SemState(token.getEClass(), token.getGrammarElement());
		}

		@Override
		public void setFollowers(SemNfa nfa, ISemState owner, Iterable<ISemState> followers) {
			((SemState) owner).followers = Lists.newArrayList(followers);
		}

	}

	protected Map<AbstractElement, Integer> elementIDCache;

	@Inject
	protected RuleNames ruleNames;

	@Inject
	protected ISyntacticSequencerPDAProvider pdaProvider;

	protected Map<Pair<EObject, EClass>, Nfa<ISemState>> resultCache = Maps.newHashMap();

	protected boolean addAll(BitSet to, BitSet bits) {
		BitSet cpy = new BitSet();
		cpy.or(to);
		cpy.or(bits);
		if (cpy.equals(to))
			return false;
		to.or(bits);
		return true;
	}

	protected int getElementID(AbstractElement ele) {
		if (elementIDCache == null) {
			elementIDCache = Maps.newHashMap();
			int counter = 0;
			for (ParserRule pr : ruleNames.getAllParserRules())
				for (AbstractElement e : EcoreUtil2.getAllContentsOfType(pr, AbstractElement.class))
					elementIDCache.put(e, counter++);
		}
		return elementIDCache.get(ele);
	}

	@Override
	public Nfa<ISemState> getNFA(EObject context, EClass type) {
		Pair<EObject, EClass> key = Tuples.create(context, type);
		Nfa<ISemState> nfa = resultCache.get(key);
		if (nfa != null)
			return nfa;
		NfaUtil util = new NfaUtil();
		SynAbsorberNfaAdapter synNfa = new SynAbsorberNfaAdapter(pdaProvider.getPDA(context, type));
		//		System.out.println(new NfaFormatter().format(synNfa));
		Map<ISynAbsorberState, Integer> distanceMap = util.distanceToFinalStateMap(synNfa);
		nfa = util.create(util.sort(synNfa, distanceMap), new SemStateFactory());
		//		util.sortInplace(nfa, distanceMap);
		if (type != null)
			initContentValidationNeeded(type, nfa);
		initRemainingFeatures(nfa.getStop(), util.inverse(nfa), Sets.<ISemState> newHashSet());
		initOrderIDs(nfa);
		//		System.out.println(new NfaFormatter().format(nfa));
		resultCache.put(key, nfa);
		return nfa;
	}

	protected void initContentValidationNeeded(EClass clazz, Nfa<ISemState> nfa) {
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

	protected void initOrderIDs(Nfa<ISemState> nfa) {
		for (ISemState state : new NfaUtil().collect(nfa))
			if (state.getAssignedGrammarElement() != null)
				((SemState) state).orderID = getElementID(state.getAssignedGrammarElement());
	}

	protected void initRemainingFeatures(ISemState state, Nfa<ISemState> inverseNfa, Set<ISemState> visited) {
		BitSet features = state.getAllFollowerFeatures();
		if (state.getFeature() != null) {
			BitSet f = new BitSet();
			f.or(features);
			f.set(state.getFeatureID());
			features = f;
		}
		for (ISemState follower : inverseNfa.getFollowers(state)) {
			if (!addAll(follower.getAllFollowerFeatures(), features) && !visited.add(follower))
				continue;
			initRemainingFeatures(follower, inverseNfa, visited);
		}
	}

	protected boolean isContentValidationNeeded(Collection<AbstractElement> ass) {
		if (ass == null || ass.size() < 2)
			return false;
		Iterator<AbstractElement> it = ass.iterator();
		AbstractElement first = it.next();
		CrossReference firstRef = GrammarUtil.containingCrossReference(first);
		while (it.hasNext()) {
			AbstractElement next = it.next();
			if (next instanceof Action)
				return true;
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
}
