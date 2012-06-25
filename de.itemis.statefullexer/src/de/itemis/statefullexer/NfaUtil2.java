package de.itemis.statefullexer;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.Cfg;
import org.eclipse.xtext.util.formallang.CfgUtil;
import org.eclipse.xtext.util.formallang.FollowerFunction;
import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaFactory;
import org.eclipse.xtext.util.formallang.ProductionUtil;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import de.itemis.statefullexer.NfaWithGroups.NfaWithGroupsFactory;

@SuppressWarnings("restriction")
public class NfaUtil2 {

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
