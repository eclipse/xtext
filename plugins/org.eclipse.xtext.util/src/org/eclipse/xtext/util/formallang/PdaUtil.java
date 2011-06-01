/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Sets;
import com.google.inject.internal.Join;
import com.google.inject.internal.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class PdaUtil {

	protected class StackItem<T> {
		protected StackItem<T> parent;
		protected Iterator<T> parentIt;
		protected T value;

		public StackItem(Iterator<T> parentIt, T value) {
			super();
			this.parentIt = parentIt;
			this.value = value;
		}

		public StackItem(StackItem<T> parent, T value) {
			super();
			this.parent = parent;
			this.value = value;
		}

		public T peek() {
			return value;
		}

		public StackItem<T> pop() {
			if (parent != null)
				return parent;
			if (parentIt != null && parentIt.hasNext())
				return parent = new StackItem<T>(parentIt, parentIt.next());
			return null;
		}

		public StackItem<T> push(T value) {
			return new StackItem<T>(this, value);
		}

		public int size() {
			int result = 0;
			StackItem<T> current = this;
			while (current != null) {
				result++;
				current = current.pop();
			}
			return result;
		}

		@Override
		public String toString() {
			List<String> result = Lists.newArrayList();
			StackItem<T> current = this;
			while (current != null) {
				if (current.value != null)
					result.add(current.value.toString());
				current = current.pop();
			}
			return Join.join(", ", result);
		}
	}

	protected class TraceItem<STATE, STACKITEM> {
		protected TraceItem<STATE, STACKITEM> parent;
		protected StackItem<STACKITEM> stackitem;
		protected STATE state;

		public TraceItem(TraceItem<STATE, STACKITEM> parent, STATE state, StackItem<STACKITEM> stackitem) {
			super();
			this.parent = parent;
			this.state = state;
			this.stackitem = stackitem;
		}

		public List<STATE> asList() {
			List<STATE> result = Lists.newArrayList();
			TraceItem<STATE, STACKITEM> current = this;
			while (current != null) {
				result.add(current.state);
				current = current.parent;
			}
			Collections.reverse(result);
			return result;
		}

		public int size() {
			int result = 0;
			TraceItem<STATE, STACKITEM> current = this;
			while (current != null) {
				result++;
				current = current.parent;
			}
			return result;
		}

		@Override
		public String toString() {
			return "States: " + asList() + " Stack: " + stackitem;
		}

	}

	public final long UNREACHABLE = Long.MAX_VALUE;

	public <STATE, STACKITEM> boolean canReach(IPdaAdapter<STATE, STACKITEM> pda, STATE state,
			Iterator<STACKITEM> stack, Predicate<STATE> matches, Predicate<STATE> canPass) {
		return distanceTo(pda, Collections.singleton(state), stack, matches, canPass) != UNREACHABLE;
	}

	protected <T> StackItem<T> createStack(Iterator<T> stack) {
		if (stack.hasNext())
			return new StackItem<T>(stack, stack.next());
		return new StackItem<T>((StackItem<T>) null, null);
	}

	public <STATE, STACKITEM> long distanceTo(IPdaAdapter<STATE, STACKITEM> pda, Iterable<STATE> starts,
			Iterator<STACKITEM> stack, Predicate<STATE> matches, Predicate<STATE> canPass) {
		TraceItem<STATE, STACKITEM> trace = trace(pda, starts, stack, matches, canPass);
		if (trace != null)
			return trace.size();
		return UNREACHABLE;
	}

	public <STATE, STACKITEM> List<STATE> shortestPathTo(IPdaAdapter<STATE, STACKITEM> pda, Iterable<STATE> starts,
			Iterator<STACKITEM> stack, Predicate<STATE> matches, Predicate<STATE> canPass) {
		TraceItem<STATE, STACKITEM> trace = trace(pda, starts, stack, matches, canPass);
		if (trace != null)
			return trace.asList();
		return null;
	}

	public <STATE, STACKITEM> List<STATE> shortestPathTo(IPdaAdapter<STATE, STACKITEM> pda, Iterator<STACKITEM> stack,
			Predicate<STATE> matches) {
		return shortestPathTo(pda, pda.getStartStates(), stack, matches, Predicates.<STATE> alwaysTrue());
	}

	public <STATE, STACKITEM> List<STATE> shortestPathTo(IPdaAdapter<STATE, STACKITEM> pda, Iterator<STACKITEM> stack,
			Predicate<STATE> matches, Predicate<STATE> canPass) {
		return shortestPathTo(pda, pda.getStartStates(), stack, matches, canPass);
	}

	public <STATE, STACKITEM> List<STATE> shortestPathTo(IPdaAdapter<STATE, STACKITEM> pda, Iterator<STACKITEM> stack,
			STATE match) {
		return shortestPathTo(pda, pda.getStartStates(), stack, Predicates.equalTo(match),
				Predicates.<STATE> alwaysTrue());
	}

	public <STATE, STACKITEM> List<STATE> shortestPathToFinalState(IPdaAdapter<STATE, STACKITEM> pda,
			Iterator<STACKITEM> stack) {
		final Set<STATE> ends = Sets.newHashSet(pda.getFinalStates());
		if (ends.isEmpty()) {
			if (pda.getStartStates().iterator().hasNext())
				return null;
			return Collections.emptyList();
		}
		return shortestPathTo(pda, pda.getStartStates(), stack, new Predicate<STATE>() {
			public boolean apply(STATE input) {
				return ends.contains(input);
			}
		}, Predicates.<STATE> alwaysTrue());
	}

	public <STATE, STACKITEM> List<STATE> shortestStackpruningPathTo(IPdaAdapter<STATE, STACKITEM> pda,
			Iterable<STATE> starts, Iterator<STACKITEM> stack, Predicate<STATE> matches, Predicate<STATE> canPass) {
		TraceItem<STATE, STACKITEM> trace = traceToWithPruningStack(pda, starts, stack, matches, canPass);
		if (trace != null)
			return trace.asList();
		return null;
	}

	public <STATE, STACKITEM> List<STATE> shortestStackpruningPathTo(IPdaAdapter<STATE, STACKITEM> pda,
			Iterator<STACKITEM> stack, Predicate<STATE> matches) {
		return shortestStackpruningPathTo(pda, pda.getStartStates(), stack, matches, Predicates.<STATE> alwaysTrue());
	}

	public <STATE, STACKITEM> List<STATE> shortestStackpruningPathTo(IPdaAdapter<STATE, STACKITEM> pda,
			Iterator<STACKITEM> stack, STATE matches) {
		return shortestStackpruningPathTo(pda, pda.getStartStates(), stack, Predicates.equalTo(matches),
				Predicates.<STATE> alwaysTrue());
	}

	protected <STATE, STACKITEM> TraceItem<STATE, STACKITEM> trace(IPdaAdapter<STATE, STACKITEM> pda,
			Iterable<STATE> starts, Iterator<STACKITEM> stack, Predicate<STATE> matches, Predicate<STATE> canPass) {
		StackItem<STACKITEM> stackItem = createStack(stack);
		List<TraceItem<STATE, STACKITEM>> current = Lists.newArrayList();
		Set<STATE> visited = Sets.newHashSet(starts);
		for (STATE start : starts) {
			//			if (matches.apply(start))
			//				return new TraceItem<STATE, STACKITEM>(null, start, stackItem);
			current.add(new TraceItem<STATE, STACKITEM>(null, start, stackItem));
		}
		int counter = stackItem.size() * -1;
		while (current.size() > 0 && counter < visited.size()) {
			List<TraceItem<STATE, STACKITEM>> newCurrent = Lists.newArrayList();
			for (TraceItem<STATE, STACKITEM> trace : current)
				for (STATE follower : pda.getFollowers(trace.state)) {
					if (matches.apply(follower))
						return new TraceItem<STATE, STACKITEM>(trace, follower, trace.stackitem);
					if (canPass.apply(follower)) {
						STACKITEM push = pda.getPush(follower);
						visited.add(follower);
						if (push != null) {
							StackItem<STACKITEM> pushed = trace.stackitem.push(push);
							newCurrent.add(new TraceItem<STATE, STACKITEM>(trace, follower, pushed));
						} else {
							STACKITEM pop = pda.getPop(follower);
							if (pop != null) {
								if (trace.stackitem != null && pop == trace.stackitem.peek()) {
									StackItem<STACKITEM> popped = trace.stackitem.pop();
									newCurrent.add(new TraceItem<STATE, STACKITEM>(trace, follower, popped));
								}
							} else
								newCurrent.add(new TraceItem<STATE, STACKITEM>(trace, follower, trace.stackitem));
						}
					}
				}
			current = newCurrent;
			counter++;
		}
		return null;
	}

	protected <STATE, STACKITEM> TraceItem<STATE, STACKITEM> traceToWithPruningStack(IPdaAdapter<STATE, STACKITEM> pda,
			Iterable<STATE> starts, Iterator<STACKITEM> stack, Predicate<STATE> matches, Predicate<STATE> canPass) {
		StackItem<STACKITEM> stackItem = createStack(stack);
		List<TraceItem<STATE, STACKITEM>> current = Lists.newArrayList();
		Set<STATE> visited = Sets.newHashSet(starts);
		TraceItem<STATE, STACKITEM> result = null;
		for (STATE start : starts) {
			TraceItem<STATE, STACKITEM> item = new TraceItem<STATE, STACKITEM>(null, start, stackItem);
			//			if (matches.apply(start))
			//				result = item;
			current.add(item);
		}
		int counter = stackItem.size() * -1;
		while (current.size() > 0 && counter < visited.size()) {
			List<TraceItem<STATE, STACKITEM>> newCurrent = Lists.newArrayList();
			for (TraceItem<STATE, STACKITEM> trace : current)
				for (STATE follower : pda.getFollowers(trace.state)) {
					if (matches.apply(follower)) {
						TraceItem<STATE, STACKITEM> found = new TraceItem<STATE, STACKITEM>(trace, follower,
								trace.stackitem);
						if (found.stackitem == null)
							return found;
						if (result == null || result.stackitem.size() > found.stackitem.size()) {
							result = found;
							counter = result.stackitem.size() * -1;
						} else if (result.stackitem.size() == found.stackitem.size() && result.size() > found.size()) {
							result = found;
							counter = result.stackitem.size() * -1;
						}
					}
					if (canPass.apply(follower)) {
						STACKITEM push = pda.getPush(follower);
						visited.add(follower);
						if (push != null) {
							StackItem<STACKITEM> pushed = trace.stackitem.push(push);
							newCurrent.add(new TraceItem<STATE, STACKITEM>(trace, follower, pushed));
						} else {
							STACKITEM pop = pda.getPop(follower);
							if (pop != null) {
								if (trace.stackitem != null && pop == trace.stackitem.peek()) {
									StackItem<STACKITEM> popped = trace.stackitem.pop();
									newCurrent.add(new TraceItem<STATE, STACKITEM>(trace, follower, popped));
								}
							} else
								newCurrent.add(new TraceItem<STATE, STACKITEM>(trace, follower, trace.stackitem));
						}
					}
				}
			current = newCurrent;
			counter++;
		}
		return result;
	}

	//	public  IPdaAdapter<String, String, String> parse(String pda) {
	//		Pattern node = Pattern.compile("([a-z-A-Z0-9]*)\\[([a-z-A-Z0-9,= ]*)\\]");
	//		Pattern transition = Pattern.compile("([a-z-A-Z0-9]*) -> ([a-z-A-Z0-9]*)");
	//		final Set<String> starts = Sets.newHashSet();
	//		final Set<String> finals = Sets.newHashSet();
	//		final Multimap<String, String> followers = HashMultimap.create();
	//		final Map<String, String> pushs = Maps.newHashMap();
	//		final Map<String, String> pops = Maps.newHashMap();
	//		for (String line : pda.split("\\n")) {
	//			line = line.trim();
	//			Matcher nodeMatcher = node.matcher(line);
	//			if (nodeMatcher.find()) {
	//				String name = nodeMatcher.group(1);
	//				String[] args = nodeMatcher.group(2).split(",");
	//				for (String arg : args) {
	//					String[] a = arg.split("=");
	//					String argKey, argValue;
	//					if (a.length > 1) {
	//						argKey = a[0];
	//						argValue = a[1];
	//					} else {
	//						argKey = arg;
	//						argValue = null;
	//					}
	//					if ("start".equals(argKey))
	//						starts.add(name);
	//					else if ("final".equals(argKey))
	//						finals.add(name);
	//					else if ("push".equals(argKey))
	//						pushs.put(name, argValue);
	//					else if ("pop".equals(argKey))
	//						pops.put(name, argValue);
	//					else
	//						throw new RuntimeException("unknown state argument key: '" + argKey + "'");
	//				}
	//			} else {
	//				Matcher transitionMatcher = transition.matcher(line);
	//				if (transitionMatcher.find())
	//					followers.put(transitionMatcher.group(1), transitionMatcher.group(2));
	//				else
	//					throw new RuntimeException("Could not parse line: '" + line + "'");
	//			}
	//
	//		}
	//		return new IPdaAdapter<String, String, String>() {
	//
	//			public String getToken(String owner) {
	//				return null;
	//			}
	//
	//			public Iterable<String> getStartStates() {
	//				return starts;
	//			}
	//
	//			public Iterable<String> getFollowers(String node) {
	//				return followers.get(node);
	//			}
	//
	//			public Iterable<String> getFinalStates() {
	//				return finals;
	//			}
	//
	//			public String getPush(String state) {
	//				return pushs.get(state);
	//			}
	//
	//			public String getPop(String state) {
	//				return pops.get(state);
	//			}
	//		};
	//	}
}
