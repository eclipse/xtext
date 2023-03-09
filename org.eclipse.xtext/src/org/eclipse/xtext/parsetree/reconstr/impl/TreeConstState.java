/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.GrammarUtil.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider.NFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAState;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TreeConstState extends AbstractNFAState<TreeConstState, TreeConstTransition> {

	enum Status {
		AMBIGIOUS, DETOUR_OR_LOOP, ENABLED, ORPHAN, UNKNOWN
	}

	protected Map<TreeConstState, Integer> distances;

	protected List<TreeConstTransition> enabledOutgoing;

	protected List<TreeConstTransition> enabledOutgoingAfterReturn;

	protected Map<TreeConstState, Integer> endDistances;

	protected Status status = Status.UNKNOWN;

	protected Set<TypeRef> types;

	protected boolean typesDirty = false;

	public TreeConstState(AbstractElement element, NFABuilder<TreeConstState, TreeConstTransition> builder) {
		super(element, builder);
	}

	protected void calculateDistances(TreeConstState root, int dist) {
		if (distances == null)
			distances = Maps.newLinkedHashMap();
		else if (distances.containsKey(root) && distances.get(root) <= dist)
			return;
		distances.put(root, dist);
		if (isConsumingElement()) {
			root = this;
			dist = 0;
		}
		for (TreeConstTransition t : concat(getOutgoing(), getOutgoingAfterReturn()))
			if (!t.isRuleCall())
				t.getTarget().calculateDistances(root, dist + 1);
		if (isEndState())
			getEndDistances().put(root, dist + 1);
	}

	protected Status checkForAmbigiousPaths(Set<TreeConstState> visited) {
		if (getStatusInternal() != Status.ENABLED || visited.contains(this))
			return getStatusInternal();
		visited.add(this);
		boolean vEnd = false, vTrans = false;
		if (isEndState() && isTransitionEnabledTo(getEndDistances())) {
			consume(getEndDistances());
			vEnd = true;
		}
		for (TreeConstTransition t : concat(getOutgoing(), getOutgoingAfterReturn())) {
			if (t.isRuleCall() || t.getStatus() != Status.ENABLED)
				continue;
			if (t.getTarget().checkForAmbigiousPaths(visited) != Status.ENABLED
					|| !isTransitionEnabledTo(t.getTarget().distances))
				t.setStatus(Status.AMBIGIOUS);
			else {
				consume(t.getTarget().distances);
				vTrans = true;
			}
		}
		return !vEnd && !vTrans ? status = Status.AMBIGIOUS : getStatusInternal();
	}

	protected Status checkForDetoursAndLoops(Set<TreeConstState> visited) {
		if (visited.contains(this)) {
			return getStatusInternal();
		}
		visited.add(this);
		boolean vEnd = false, vTrans = false;
		if (isEndState() && isTransitionEnabledTo(getEndDistances()))
			vEnd = true;

		for (TreeConstTransition t : concat(getOutgoing(), getOutgoingAfterReturn())) {
			if (t.isRuleCall())
				continue;
			if (t.getTarget().checkForDetoursAndLoops(visited) != Status.ENABLED
					|| !isTransitionEnabledTo(t.getTarget().distances))
				t.setStatus(Status.DETOUR_OR_LOOP);
			else {
				t.setStatus(Status.ENABLED);
				vTrans = true;
			}
		}
		return !vEnd && !vTrans ? status = Status.DETOUR_OR_LOOP : getStatusInternal();
	}

	protected void consume(Map<TreeConstState, Integer> dist) {
		if (isConsumingElement())
			dist.remove(this);
		else
			for (Map.Entry<TreeConstState, Integer> e : distances.entrySet()) {
				Integer i = dist.get(e.getKey());
				if (i != null && i > e.getValue())
					dist.remove(e.getKey());
			}
	}

	protected void discardMisleadingDistances(Set<TreeConstState> visited) {
		if (!visited.add(this))
			return;
		for (TreeConstTransition t : concat(getOutgoing(), getOutgoingAfterReturn())) {
			if (!t.isRuleCall())
				t.getTarget().discardMisleadingDistances(visited);
		}
		if (isConsumingElement() || isEndState())
			return;
		Set<TreeConstState> doNotRemove = Sets.newLinkedHashSet();
		for (TreeConstTransition t : concat(getOutgoing(), getOutgoingAfterReturn())) {
			if (!t.isRuleCall()) {
				TreeConstState target = t.getTarget();
				Map<TreeConstState, Integer> targetDistances = target.distances;
				for (Map.Entry<TreeConstState, Integer> entry : targetDistances.entrySet()) {
					Integer targetDistance = entry.getValue();
					Integer ownDistance = distances.get(entry.getKey());
					if (ownDistance == null || targetDistance >= ownDistance) {
						doNotRemove.add(entry.getKey());
					}
				}
			} else {
				doNotRemove.addAll(t.getTarget().distances.keySet());
			}
		}
		distances.keySet().retainAll(doNotRemove);
	}

	public List<TreeConstTransition> getEnabledOutgoing() {
		if (enabledOutgoing == null) {
			enabledOutgoing = new ArrayList<TreeConstTransition>();
			for (TreeConstTransition t : getOutgoing())
				if (!t.isDisabled())
					enabledOutgoing.add(t);
		}
		return enabledOutgoing;
	}

	public List<TreeConstTransition> getEnabledOutgoingAfterReturn() {
		if (enabledOutgoingAfterReturn == null) {
			enabledOutgoingAfterReturn = new ArrayList<TreeConstTransition>();
			for (TreeConstTransition t : getOutgoingAfterReturn())
				if (!t.isDisabled())
					enabledOutgoingAfterReturn.add(t);
		}
		return enabledOutgoingAfterReturn;
	}

	protected Map<TreeConstState, Integer> getEndDistances() {
		AbstractElement rootEle = containingRule(element).getAlternatives();
		TreeConstState root = builder.getState(rootEle);
		if (root.endDistances == null)
			root.endDistances = Maps.newLinkedHashMap();
		return root.endDistances;
	}

	protected Status getStatusInternal() {
		if (status == Status.UNKNOWN)
			status = isEndState() || getOutgoing().size() > 0 || getOutgoingAfterReturn().size() > 0 ? Status.ENABLED
					: Status.ORPHAN;
		return status;
	}

	public Status getStatus() {
		if (distances == null) {
			AbstractElement rootEle = containingRule(element).getAlternatives();
			builder.getState(rootEle).initStatus();
		}
		return getStatusInternal();
	}

	public Set<TypeRef> getTypes() {
		if (types == null) {
			getStatus();
			Map<TreeConstState, List<TreeConstState>> map = Maps.newLinkedHashMap();
			Set<TreeConstState> endStates = Sets.newLinkedHashSet();
			initTypes(map, endStates);
			for (TreeConstState s : endStates)
				s.populateTypes(map);
		}
		return types;
	}

	public Collection<TypeRef> getTypesToCheck() {
		Map<EClassifier, TypeRef> localTypes = Maps.newLinkedHashMap();
		for (TypeRef t : sortTypes(getTypes()))
			if (t != null)
				localTypes.put(t.getClassifier(), t);
		List<TreeConstTransition> incomming = getIncommingWithoutRuleCalls();
		if (incomming.isEmpty())
			return localTypes.values();
		for (TreeConstTransition t : incomming)
			for (TypeRef r : t.getSource().getTypes())
				if (r != null && !localTypes.containsKey(r.getClassifier()))
					return localTypes.values();
		return Collections.emptyList();
	}

	protected void initStatus() {
		if (distances == null) {
			calculateDistances(this, 1);
			discardMisleadingDistances(new LinkedHashSet<TreeConstState>());
			checkForDetoursAndLoops(new LinkedHashSet<TreeConstState>());
			checkForAmbigiousPaths(new LinkedHashSet<TreeConstState>());
		}
	}

	protected void initTypes(Map<TreeConstState, List<TreeConstState>> map, Set<TreeConstState> endStates) {
		if (types != null) {
			endStates.add(this);
		} else {
			types = Sets.newLinkedHashSet();
			typesDirty = true;
			for (TreeConstTransition t : concat(getOutgoing(), getOutgoingAfterReturn())) {
				if (t.isDisabled() || (t.isRuleCall() && getGrammarElement() instanceof Assignment))
					continue;
				t.getTarget().initTypes(map, endStates);
				List<TreeConstState> orgins = map.get(t.getTarget());
				if (orgins == null)
					map.put(t.getTarget(), orgins = Lists.newArrayList());
				orgins.add(this);
			}
			if (element instanceof Action)
				types.add(((Action) element).getType());
			if (isEndState()) {
				endStates.add(this);
				if (element instanceof Assignment)
					types.add(GrammarUtil.containingRule(element).getType());
				else if (!isConsumingElement())
					types.add(null);
			}
		}
	}

	protected boolean isConsumingElement() {
		return element instanceof Assignment
				|| GrammarUtil.isEObjectRuleCall(element)
				|| element instanceof Action;
	}

	public boolean isDisabled() {
		return getStatus() != Status.ENABLED;
	}

	protected boolean isTransitionEnabledTo(Map<TreeConstState, Integer> dist) {
		if (isConsumingElement())
			return true;
		for (Map.Entry<TreeConstState, Integer> e : distances.entrySet()) {
			Integer i = dist.get(e.getKey());
			if (i != null && i > e.getValue())
				return true;
		}
		return false;
	}

	protected void populateTypes(Map<TreeConstState, List<TreeConstState>> map) {
		typesDirty = false;
		List<TreeConstState> origins = map.get(this);
		if (origins != null)
			for (TreeConstState origin : origins) {
				Set<TypeRef> t = types;
				if (origin.getGrammarElement() instanceof Action
						&& ((Action) origin.getGrammarElement()).getFeature() != null)
					t = Collections.emptySet();
				else if (t.contains(null) && origin.isConsumingElement()) {
					t = Sets.newLinkedHashSet(t);
					t.remove(null);
					if (origin.getGrammarElement() instanceof Assignment)
						t.add(GrammarUtil.containingRule(origin.getGrammarElement()).getType());
				}
				if (origin.getTypes().addAll(t) || origin.typesDirty)
					origin.populateTypes(map);
			}
	}

	protected List<TypeRef> sortTypes(Collection<TypeRef> types) {
		List<TypeRef> result = Lists.newArrayList(types);
		Collections.sort(result, new Comparator<TypeRef>() {
			@Override
			public int compare(TypeRef o1, TypeRef o2) {
				if (o1 == null)
					return 1;
				if (o2 == null)
					return -1;
				return o1.getClassifier().getName().compareTo(o2.getClassifier().getName());
			}
		});
		return result;
	}

	@Override
	public String toString() {
		//		if (distances == null)
		//			return "????";
		//		StringBuffer b = new StringBuffer(element.eClass().getName()).append("-").append(
		//				Integer.toHexString(hashCode())).append("\\n");
		//		for (Map.Entry<TreeConstState, Integer> e : distances.entrySet()) {
		//			String hash = e.getKey() == null ? "??" : e.getKey().element.eClass().getName() + "-"
		//					+ Integer.toHexString(e.getKey().hashCode());
		//			b.append(hash + "-" + e.getValue() + "\\n");
		//		}
		//		return b.toString();
		return "";
	}
}
