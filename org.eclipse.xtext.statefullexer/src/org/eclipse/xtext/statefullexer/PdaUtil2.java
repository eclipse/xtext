package org.eclipse.xtext.statefullexer;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.util.formallang.Cfg;
import org.eclipse.xtext.util.formallang.FollowerFunction;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaFactory;
import org.eclipse.xtext.util.formallang.PdaUtil;
import org.eclipse.xtext.util.formallang.ProductionUtil;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

@SuppressWarnings("restriction")
public class PdaUtil2 extends PdaUtil {
	protected <S, P, E, T1, T2, D extends Pda<S, P>> void create(Cfg<E, T1> cfg, D pda, S state, E ele, Iterable<E> followerElements, boolean canEnter,
			FollowerFunction<E> ff, Function<E, T2> tokens, PdaFactory<D, S, P, ? super T2> fact, Map<E, S> states, Map<E, S> stops, Multimap<E, E> callers) {
		List<S> followerStates = Lists.newArrayList();
		for (E fol : followerElements) {
			E e;
			if (fol == null) {
				E root = new ProductionUtil().getRoot(cfg, ele);
				if (root == cfg.getRoot())
					followerStates.add(pda.getStop());
				for (E c : callers.get(root)) {
					S s = stops.get(c);
					if (s == null) {
						s = fact.createPop(pda, tokens.apply(c));
						stops.put(c, s);
						create(cfg, pda, s, c, ff.getFollowers(c), false, ff, tokens, fact, states, stops, callers);
					}
					followerStates.add(s);
				}
			} else if ( /*canEnter && */ (e = cfg.getCall(fol)) != null) {
				S s = states.get(fol);
				if (s == null) {
					s = fact.createPush(pda, tokens.apply(fol));
					states.put(fol, s);
					create(cfg, pda, s, e, ff.getStarts(e), true, ff, tokens, fact, states, stops, callers);
				}
				followerStates.add(s);
			} else {
				S s = states.get(fol);
				if (s == null) {
					s = fact.createState(pda, tokens.apply(fol));
					states.put(fol, s);
					create(cfg, pda, s, fol, ff.getFollowers(fol), true, ff, tokens, fact, states, stops, callers);
				}
				followerStates.add(s);
			}

		}
		fact.setFollowers(pda, state, followerStates);
	}
}
