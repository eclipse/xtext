/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.Stack;

import org.antlr.runtime.BaseRecognizer;
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
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;

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
	private SortedMap<Integer, UnorderedGroupState> backtrackingSnapShot;
	private BaseRecognizer recognizer;
	private UnorderedGroup[] allGroups;
	
	@Inject
	public UnorderedGroupHelper(Collector collector) {
		groupToState = Maps.newHashMap();
		backtrackingSnapShot = Maps.newTreeMap();
		for(UnorderedGroup group: collector.getGroups())
			configure(group);
		allGroups = collector.getGroups().toArray(new UnorderedGroup[collector.getGroups().size()]);
	}
	
	@Override
	public void initializeWith(BaseRecognizer recognizer) {
		this.recognizer = recognizer;
	}
	
	protected BaseRecognizer getRecognizer() {
		return recognizer;
	}
	
	protected void configure(UnorderedGroup group) {
		groupToState.put(group, new State(group));
	}
	
	protected State get(UnorderedGroup group) {
		snapShotForBacktracking();
		State result = groupToState.get(group);
		if (result == null)
			throw new IllegalArgumentException("Unexpected group: " + group);
		return result;
	}

	protected void snapShotForBacktracking() {
		int backtrackingLevel = getBacktrackingLevel();
		// recognizer is currently in backtracking mode or was previously in backtracking mode
		if (backtrackingLevel != 0 || !backtrackingSnapShot.isEmpty()) {
			// backtracking stack was reduced
			if (backtrackingLevel == 0 || (!backtrackingSnapShot.isEmpty() && backtrackingLevel < backtrackingSnapShot.firstKey())) {
				backtrackingSnapShot.values().iterator().next().restore();
				backtrackingSnapShot.clear();
				// still backtracking
				if (backtrackingLevel > 0) {
					UnorderedGroupState state = new UnorderedGroupStateImpl(allGroups);
					backtrackingSnapShot.put(backtrackingLevel, state);
				}
			} else if (backtrackingSnapShot.isEmpty() || backtrackingLevel > backtrackingSnapShot.lastKey()) {
				// backtracking stack was increased
				UnorderedGroupState state = new UnorderedGroupStateImpl(allGroups);
				backtrackingSnapShot.put(backtrackingLevel, state);
			}
		}
	}

	protected int getBacktrackingLevel() {
		return recognizer.getBacktrackingLevel();
	}
	
	@Override
	public void enter(UnorderedGroup group) {
		get(group).enter();
	}
	
	@Override
	public void leave(UnorderedGroup group) {
		get(group).leave();
	}
	
	@Override
	public boolean canSelect(UnorderedGroup group, int index) {
		return get(group).canSelect(index);
	}
	
	@Override
	public void select(UnorderedGroup group, int index) {
		get(group).select(index);
	}
	
	@Override
	public void returnFromSelection(UnorderedGroup group) {
		get(group).returnFromSelection();
	}
	
	@Override
	public boolean canLeave(UnorderedGroup group) {
		return get(group).canLeave();
	}
	
	@Override
	public UnorderedGroupState snapShot(UnorderedGroup... groups) {
		return new UnorderedGroupStateImpl(groups);
	}
	
	@Override
	public String toString() {
		return "UnorderedGroupHelper: " + groupToState;
	}
	
	protected class UnorderedGroupStateImpl implements UnorderedGroupState {

		private Map<UnorderedGroup, State> groupToState;
		
		protected UnorderedGroupStateImpl(UnorderedGroup[] groups) {
			groupToState = Maps.newHashMap();
			for(UnorderedGroup group: groups) {
				State state = UnorderedGroupHelper.this.groupToState.get(group);
				groupToState.put(group, state.copy());
			}
		}
		
		@Override
		public void restore() {
			UnorderedGroupHelper.this.groupToState.putAll(groupToState);
		}
		
	}
	
	protected static class State {

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
		
		protected State(State original) {
			frames = new Stack<Frame>();
			Iterator<Frame> iter = original.frames.iterator();
			while(iter.hasNext()) {
				Frame copy = new Frame(iter.next());
				frames.push(copy);
			}
			alternatives = original.alternatives;
			mandatoryAlternativeCount = original.mandatoryAlternativeCount;
			returnTrue = original.returnTrue;
			mandatoryAlternatives = original.mandatoryAlternatives.clone();
			selected = original.selected;
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
		
		public State copy() {
			return new State(this);
		}
		
		@Override
		public String toString() {
			if (frames.isEmpty()) 
				return "State: []";
			Frame frame = frames.peek();
			return "State: " + Arrays.toString(frame.predicate) + " " + frame.remaining + " remaining";
		}
		
	}
	
	protected static class Frame {
		protected Frame() {
		}
		protected Frame(Frame original) {
			this.predicate = original.predicate.clone();
			this.remaining = original.remaining;
		}
		protected boolean[] predicate;
		protected int remaining;
	}
	
}
