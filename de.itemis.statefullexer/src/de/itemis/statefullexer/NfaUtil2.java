package de.itemis.statefullexer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.Cfg;
import org.eclipse.xtext.util.formallang.CfgUtil;
import org.eclipse.xtext.util.formallang.FollowerFunction;
import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaFactory;
import org.eclipse.xtext.util.formallang.NfaUtil;
import org.eclipse.xtext.util.formallang.NfaUtil.MappedComparator;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaUtil.HashStack;
import org.eclipse.xtext.util.formallang.ProductionUtil;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import de.itemis.statefullexer.NfaWithGroups.NfaWithGroupsFactory;

@SuppressWarnings("restriction")
public class NfaUtil2 {

	protected static class GroupingTraversalItem<S, R, G> {
		protected R data;
		protected Iterator<S> followers;
		protected S state;
		protected G group;

		public GroupingTraversalItem(S state, Iterable<S> followers, R previous, G group) {
			super();
			this.state = state;
			this.followers = followers.iterator();
			this.data = previous;
			this.group = group;
		}

		@Override
		@SuppressWarnings("rawtypes")
		public boolean equals(Object obj) {
			if (obj == null || obj.getClass() != getClass())
				return false;
			GroupingTraversalItem other = (GroupingTraversalItem) obj;
			return data.equals(other.data) && state.equals(other.state) && Objects.equal(group, other.group);
		}

		@Override
		public int hashCode() {
			return data.hashCode() + (state.hashCode() * 7) + (group == null ? 0 : group.hashCode() * 13);
		}

		@Override
		public String toString() {
			return "[" + group + "]" + state;
		}
	}

	protected <S, R, P, G> GroupingTraversalItem<S, R, G> newItem(Pda<S, P> pda, MappedComparator<S, Integer> comp, Map<S, Integer> distances, S next, R item,
			G group) {
		List<S> followers = Lists.newArrayList();
		for (S f : pda.getFollowers(next))
			if (distances.containsKey(f))
				followers.add(f);
		Collections.sort(followers, comp);
		return new GroupingTraversalItem<S, R, G>(next, followers, item, group);
	}

	@SuppressWarnings("unchecked")
	public <S, P, R, G, T, X, D extends Nfa<X>> D create(Pda<S, P> pda, GroupingTraverser<? super Pda<S, P>, S, R, G> traverser, Predicate<S> filter,
			Function<S, T> tokens, NfaFactory<D, X, T> factory) {
		HashStack<GroupingTraversalItem<S, R, G>> trace = new HashStack<GroupingTraversalItem<S, R, G>>();
		R previous = traverser.enter(pda, pda.getStart(), null);
		G previousGroup = traverser.getGroup(previous);
		if (previous == null)
			return factory.create(tokens.apply(pda.getStart()), tokens.apply(pda.getStop()));
		Map<S, Integer> distances = new NfaUtil().distanceToFinalStateMap(pda);
		MappedComparator<S, Integer> distanceComp = new MappedComparator<S, Integer>(distances);
		trace.push(newItem(pda, distanceComp, distances, pda.getStart(), previous, previousGroup));
		Multimap<Pair<G, S>, Pair<G, S>> edges = LinkedHashMultimap.create();
		HashSet<Pair<G, S>> states = Sets.newHashSet();
		HashSet<Triple<S, R, G>> success = Sets.newHashSet();
		states.add(Tuples.create(previousGroup, pda.getStart()));
		states.add(Tuples.create(previousGroup, pda.getStop()));
		ROOT: while (!trace.isEmpty()) {
			GroupingTraversalItem<S, R, G> current = trace.peek();
			while (current.followers.hasNext()) {
				S next = current.followers.next();
				R item = traverser.enter(pda, next, current.data);
				if (item != null) {
					G group = traverser.getGroup(item);
					if ((next == pda.getStop() && traverser.isSolution(item)) || success.contains(Tuples.create(next, item, group))) {
						S s = null;
						G g = null;
						for (GroupingTraversalItem<S, R, G> i : trace) {
							if (s != null)
								edges.put(Tuples.create(g, s), Tuples.create(i.group, i.state));
							states.add(Tuples.create(i.group, i.state));
							success.add(Tuples.create(i.state, i.data, i.group));
							s = i.state;
							g = i.group;
						}
						edges.put(Tuples.create(g, s), Tuples.create(group, next));
					} else {
						if (trace.push(newItem(pda, distanceComp, distances, next, item, group)))
							continue ROOT;
					}
				}
			}
			trace.pop();
		}
		D result = factory.create(tokens.apply(pda.getStart()), tokens.apply(pda.getStop()));
		Map<Pair<G, S>, Pair<G, X>> old2new = Maps.newHashMap();
		old2new.put(Tuples.create(previousGroup, pda.getStart()), Tuples.create(previousGroup, result.getStart()));
		old2new.put(Tuples.create(previousGroup, pda.getStop()), Tuples.create(previousGroup, result.getStop()));
		for (Pair<G, S> old : states) {
			X state = null;
			if (old.getSecond() == pda.getStart())
				state = result.getStart();
			else if (old.getSecond() == pda.getStop())
				state = result.getStop();
			else if (filter.apply(old.getSecond()))
				state = factory.createState(result, tokens.apply(old.getSecond()));
			if (state != null) {
				old2new.put(old, Tuples.create(old.getFirst(), state));
				if (factory instanceof NfaWithGroupsFactory<?, ?, ?, ?>) {
					NfaWithGroupsFactory<D, G, X, S> f = (NfaWithGroupsFactory<D, G, X, S>) factory;
					f.setGroup(result, old.getFirst(), state);
				}
			}
		}
		for (Pair<G, S> old : old2new.keySet()) {
			List<X> followers = Lists.newArrayList();
			collectFollowers(old, edges, old2new, followers, Sets.<Pair<G, S>> newHashSet());
			factory.setFollowers(result, old2new.get(old).getSecond(), followers);
		}
		return result;
	}

	protected <S, G, X> void collectFollowers(Pair<G, S> state, Multimap<Pair<G, S>, Pair<G, S>> edges, Map<Pair<G, S>, Pair<G, X>> old2new, List<X> result,
			Set<Pair<G, S>> visited) {
		for (Pair<G, S> f : edges.get(state)) {
			if (visited.add(f)) {
				Pair<G, X> n = old2new.get(f);
				if (n != null)
					result.add(n.getSecond());
				else
					collectFollowers(f, edges, old2new, result, visited);
			}
		}
	}

	protected <S, T> void getAllTransitions(NfaWithTransitions<S, T> nfa, S state, List<T> result, Set<S> visited) {
		if (!visited.add(state))
			return;
		Iterables.addAll(result, nfa.getOutgoingTransitions(state));
		for (S f : nfa.getFollowers(state))
			getAllTransitions(nfa, f, result, visited);
	}

	public <S, T> Iterable<T> getAllTransitions(NfaWithTransitions<S, T> nfa) {
		List<T> result = Lists.newArrayList();
		getAllTransitions(nfa, nfa.getStart(), result, Sets.<S> newHashSet());
		return result;
	}

	public <S, E, T, G, D extends Nfa<S>> D create(Cfg<E, T> cfg, FollowerFunction<E> ff, Function<E, G> element2group, NfaFactory<D, S, E> fact) {
		return create(cfg, ff, Functions.<E> identity(), element2group, fact);
	}

	protected <E, G, T> void collectGroups(G group, E root, Cfg<E, T> cfg, Function<E, G> element2group, Multimap<E, G> root2group) {
		if (!root2group.put(root, group))
			return;
		for (E ele : new ProductionUtil().getAllChildren(cfg, root)) {
			E target = cfg.getCall(ele);
			if (target != null) {
				G newGroup = element2group.apply(ele);
				if (newGroup == null)
					newGroup = group;
				collectGroups(newGroup, target, cfg, element2group, root2group);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public <S, E, T1, T2, G, D extends Nfa<S>> D create(Cfg<E, T1> cfg, FollowerFunction<E> ff, Function<E, T2> element2token, Function<E, G> element2group,
			NfaFactory<D, S, ? super T2> fact) {
		D nfa = fact.create(null, null);
		Map<Pair<G, E>, S> states = Maps.newHashMap();
		Multimap<E, E> callers = new CfgUtil().getCallers(cfg);
		Multimap<E, G> root2group = HashMultimap.create();
		G group = element2group.apply(null);
		collectGroups(group, cfg.getRoot(), cfg, element2group, root2group);
		Set<S> followerStates = Sets.newLinkedHashSet();
		Iterable<E> starts = ff.getStarts(cfg.getRoot());
		if (fact instanceof NfaWithGroupsFactory<?, ?, ?, ?>) {
			((NfaWithGroupsFactory<D, G, S, T2>) fact).setGroup(nfa, group, nfa.getStart());
			((NfaWithGroupsFactory<D, G, S, T2>) fact).setGroup(nfa, group, nfa.getStop());
		}
		create(cfg, nfa, group, nfa.getStart(), cfg.getRoot(), starts, ff, element2token, element2group, fact, states, callers, followerStates, root2group,
				Sets.<Pair<G, E>> newHashSet());
		fact.setFollowers(nfa, nfa.getStart(), followerStates);
		return nfa;
	}

	@SuppressWarnings("unchecked")
	protected <S, E, T1, T2, G, D extends Nfa<S>> void create(Cfg<E, T1> cfg, D nfa, G group, S state, E ele, Iterable<E> followerElements,
			FollowerFunction<E> ff, Function<E, T2> tokens, Function<E, G> element2group, NfaFactory<D, S, ? super T2> fact, Map<Pair<G, E>, S> states,
			Multimap<E, E> callers, Set<S> followerStates, Multimap<E, G> root2group, Set<Pair<G, E>> visited) {
		if (!visited.add(Tuples.create(group, ele)))
			return;
		for (E fol : followerElements) {
			E e;
			if (fol == null) {
				E root = new ProductionUtil().getRoot(cfg, ele);
				if (root == cfg.getRoot())
					followerStates.add(nfa.getStop());
				for (E c : callers.get(root)) {
					for (G newGroup : root2group.get(root))
						create(cfg, nfa, newGroup, state, c, ff.getFollowers(c), ff, tokens, element2group, fact, states, callers, followerStates, root2group,
								visited);
				}
			} else if ((e = cfg.getCall(fol)) != null) {
				for (G newGroup : root2group.get(e))
					create(cfg, nfa, newGroup, state, e, ff.getStarts(e), ff, tokens, element2group, fact, states, callers, followerStates, root2group, visited);
			} else {
				Pair<G, E> key = Tuples.create(group, fol);
				S s = states.get(key);
				if (s == null) {
					s = fact.createState(nfa, tokens.apply(fol));
					if (fact instanceof NfaWithGroupsFactory<?, ?, ?, ?>)
						((NfaWithGroupsFactory<D, G, S, T2>) fact).setGroup(nfa, group, s);
					states.put(key, s);
					Set<S> sfollowerStates = Sets.newLinkedHashSet();
					create(cfg, nfa, group, s, fol, ff.getFollowers(fol), ff, tokens, element2group, fact, states, callers, sfollowerStates, root2group,
							Sets.<Pair<G, E>> newHashSet());
					fact.setFollowers(nfa, s, sfollowerStates);
				}
				followerStates.add(s);
			}

		}
	}
}
