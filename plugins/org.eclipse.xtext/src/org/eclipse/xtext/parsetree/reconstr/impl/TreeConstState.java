/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import static org.eclipse.xtext.GrammarUtil.containingRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider.NFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAState;

import static com.google.common.collect.Iterables.*;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TreeConstState extends
		AbstractNFAState<TreeConstState, TreeConstTransition> {

	enum Status {
		AMBIGIOUS, DETOUR_OR_LOOP, ENABLED, ORPHAN, UNKNOWN
	}

	protected Map<TreeConstState, Integer> distances;

	protected List<TreeConstTransition> enabledFollowers;

	protected List<TreeConstTransition> enabledParentFollowers;

	protected Map<TreeConstState, Integer> endDistances;

	protected Status status = Status.UNKNOWN;

	public TreeConstState(AbstractElement element,
			NFABuilder<TreeConstState, TreeConstTransition> builder) {
		super(element, builder);
	}

	protected void calculateDistances(TreeConstState root, int dist) {
		if (distances == null)
			distances = new HashMap<TreeConstState, Integer>();
		else if (distances.containsKey(root) && distances.get(root) <= dist)
			return;
		distances.put(root, dist);
		if (isConsumingElement()) {
			root = this;
			dist = 0;
		}
		for (TreeConstTransition t : concat(getFollowers(),
				getParentFollowers()))
			if (!t.isRuleCall())
				t.getTarget().calculateDistances(root, dist + 1);
		if (isEndState())
			getEndDistances().put(root, dist + 1);
	}

	protected Status checkForAmbigiousPaths(Set<TreeConstState> visited) {
		if (getStatInt() != Status.ENABLED || visited.contains(this))
			return getStatInt();
		visited.add(this);
		boolean vEnd = false, vTrans = false;
		if (isEndState() && isTransitionEnabledTo(getEndDistances())) {
			consume(getEndDistances());
			vEnd = true;
		}
		for (TreeConstTransition t : concat(getFollowers(),
				getParentFollowers())) {
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
		return !vEnd && !vTrans ? status = Status.AMBIGIOUS : getStatInt();
	}

	protected Status checkForDetoursAndLoops(Set<TreeConstState> visited) {
		if (visited.contains(this)) {
			return getStatInt();
		}
		visited.add(this);
		boolean vEnd = false, vTrans = false;
		if (isEndState() && isTransitionEnabledTo(getEndDistances()))
			vEnd = true;

		for (TreeConstTransition t : concat(getFollowers(),
				getParentFollowers())) {
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
		return !vEnd && !vTrans ? status = Status.DETOUR_OR_LOOP : getStatInt();
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

	public List<TreeConstTransition> getEnabledFollowers() {
		if (enabledFollowers == null) {
			enabledFollowers = new ArrayList<TreeConstTransition>();
			for (TreeConstTransition t : getFollowers())
				if (!t.isDisabled())
					enabledFollowers.add(t);
		}
		return enabledFollowers;
	}

	public List<TreeConstTransition> getEnabledParentFollowers() {
		if (enabledParentFollowers == null) {
			enabledParentFollowers = new ArrayList<TreeConstTransition>();
			for (TreeConstTransition t : getParentFollowers())
				if (!t.isDisabled())
					enabledParentFollowers.add(t);
		}
		return enabledParentFollowers;
	}

	protected Map<TreeConstState, Integer> getEndDistances() {
		AbstractElement rootEle = containingRule(element).getAlternatives();
		TreeConstState root = builder.getState(rootEle);
		if (root.endDistances == null)
			root.endDistances = new HashMap<TreeConstState, Integer>();
		return root.endDistances;
	}

	protected Status getStatInt() {
		if (status == Status.UNKNOWN)
			status = isEndState() || getFollowers().size() > 0
					|| getParentFollowers().size() > 0 ? Status.ENABLED
					: Status.ORPHAN;
		return status;
	}

	public Status getStatus() {
		if (distances == null) {
			AbstractElement rootEle = containingRule(element).getAlternatives();
			builder.getState(rootEle).initStatus();
		}
		return getStatInt();
	}

	protected void initStatus() {
		if (distances == null) {
			calculateDistances(this, 1);
			checkForDetoursAndLoops(new HashSet<TreeConstState>());
			checkForAmbigiousPaths(new HashSet<TreeConstState>());
		}
	}

	protected boolean isConsumingElement() {
		return element instanceof Assignment || element instanceof RuleCall
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

	public String toString() {
		if (distances == null)
			return "????";
		StringBuffer b = new StringBuffer();
		for (Map.Entry<TreeConstState, Integer> e : distances.entrySet()) {
			String hash = e.getKey() == null ? "??" : Integer.toHexString(e
					.getKey().hashCode());
			b.append(hash + "-" + e.getValue() + "\\n");
		}
		return b.toString();
	}
}
