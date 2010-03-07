/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.UnorderedGroup;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.internal.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnorderedGroupHelper implements IUnorderedGroupHelper {

	@Singleton
	public static class Collector {
		
		private final ImmutableList<UnorderedGroup> groups;

		@Inject
		public Collector(IGrammarAccess grammarAccess) {
			Grammar grammar = grammarAccess.getGrammar();
			List<ParserRule> parserRules = GrammarUtil.allParserRules(grammar);
			List<UnorderedGroup> groups = Lists.newArrayList();
			for(ParserRule rule: parserRules) {
				Iterator<EObject> iter = rule.eAllContents();
				while(iter.hasNext()) {
					EObject next = iter.next();
					if (next instanceof UnorderedGroup) {
						groups.add((UnorderedGroup) next);
					}
				}
			}
			this.groups = ImmutableList.copyOf(groups);
		}

		public ImmutableList<UnorderedGroup> getGroups() {
			return groups;
		}
		
	}
	
	private Map<UnorderedGroup, State> groupToState;
	
	@Inject
	public UnorderedGroupHelper(Collector collector) {
		groupToState = Maps.newHashMap();
		for(UnorderedGroup group: collector.getGroups())
			configure(group);
	}
	
	private void configure(UnorderedGroup group) {
		groupToState.put(group, new State(group));
	}
	
	private State get(UnorderedGroup group) {
		State result = groupToState.get(group);
		if (result == null)
			throw new IllegalArgumentException("Unexpected group: " + group);
		return result;
	}
	
	public void enter(UnorderedGroup group) {
		get(group).enter();
	}
	
	public void leave(UnorderedGroup group) {
		get(group).leave();
	}
	
	public boolean canSelect(UnorderedGroup group, int index) {
		return get(group).canSelect(index);
	}
	
	public void select(UnorderedGroup group, int index) {
		get(group).select(index);
	}
	
	public void returnFromSelection(UnorderedGroup group) {
		get(group).returnFromSelection();
	}
	
	public boolean canLeave(UnorderedGroup group) {
		return get(group).canLeave();
	}
	
	private static class State {

		private Stack<Frame> frames;
		private int alternatives;
		private int mandatoryAlternativeCount;
		private boolean returnTrue = true;
		private boolean[] mandatoryAlternatives;
		/**
		 * We have to remember the selected
		 * path due to quirky antlr predicate propagation and
		 * implement special treatment for it.
		 */
		private int selected = -1;

		public State(UnorderedGroup group) {
			frames = new Stack<Frame>();
			EList<AbstractElement> elements = group.getElements();
			alternatives = elements.size();
			mandatoryAlternatives = new boolean[alternatives];
			mandatoryAlternativeCount = 0;
			for(int i = 0; i < alternatives; i++) {
				boolean isMandatory = !GrammarUtil.isOptionalCardinality(elements.get(i));
				if (isMandatory) {
					mandatoryAlternatives[i] = true;
					mandatoryAlternativeCount++;
				}
			}
		}
		
		protected void pushFrame() {
			Frame frame = new Frame();
			frame.predicate = new boolean[alternatives];
			frame.remaining = mandatoryAlternativeCount;
			frames.push(frame);
		}

		public boolean canLeave() {
			if (returnTrue)
				throw new IllegalStateException();
			return frames.peek().remaining == 0;
		}

		public void returnFromSelection() {
			returnTrue = false;
			selected = -1;
		}

		public boolean canSelect(int index) {
			boolean result = (returnTrue && index != selected) || !frames.peek().predicate[index];
			return result;
		}

		public void select(int index) {
			returnTrue = true;
			selected = index;
			Frame current = frames.peek();
			current.predicate[index] = true;
			if (mandatoryAlternatives[index])
				current.remaining--;
		}

		public void leave() {
			returnTrue = true;
			frames.pop();
		}

		public void enter() {
			returnTrue = false;
			pushFrame();
		}
		
	}
	
	private static class Frame {
		boolean[] predicate;
		int remaining;
	}
	
}
