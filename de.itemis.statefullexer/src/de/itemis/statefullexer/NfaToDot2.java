package de.itemis.statefullexer;

import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaUtil;

import com.google.common.base.Functions;

@SuppressWarnings("restriction")
public class NfaToDot2 extends GraphvizDotBuilder2 {

	@SuppressWarnings("unchecked")
	protected Edge create(Props result, Nfa<Object> nfa, Object from, Object to) {
		Edge edge = new Edge(from, to);
		if (nfa instanceof NfaWithTransitions<?, ?>) {
			NfaWithTransitions<Object, Object> n = (NfaWithTransitions<Object, Object>) nfa;
			for (Object t : n.getOutgoingTransitions(from))
				if (n.getTarget(t) == to)
					edge.setLabel(t.toString());
		}
		return edge;
	}

	protected Node create(Props result, Nfa<Object> nfa, Object state) {
		Node n = new Node2(state, stateToString(nfa, state));
		if (state == nfa.getStart() || state == nfa.getStop())
			n.setShape("diamond");
		return n;
	}

	protected DispatchFunction<Object, String> stateFormatter = new DispatchFunction<Object, String>("(null)").add(Functions.toStringFunction());
	protected DispatchFunction<Object, String> groupFormatter = new DispatchFunction<Object, String>("(null)").add(Functions.toStringFunction());

	protected void draw(Digraph2 result, Nfa<Object> nfa) {
		for (Object s : new NfaUtil().collect(nfa)) {
			result.add(create(result, nfa, s));
			for (Object f : nfa.getFollowers(s))
				result.add(create(result, nfa, s, f));
		}
	}

	protected void draw(Digraph2 result, NfaWithGroups<Object, Object> nfa) {
		for (Object group : nfa.getAllGroups()) {
			Cluster c = new Cluster(group, groupToString(nfa, group));
			result.add(c);
//			System.out.println("Group: " + group);
			if (group != null)
				for (Object s : nfa.getStatesInGroup(group)) {
					c.add(create(c, nfa, s));
//					System.out.println("  State: " + s);
					for (Object f : nfa.getFollowers(s))
						c.add(create(c, nfa, s, f));
				}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	protected Props drawObject(Object obj) {
		Digraph2 result = new Digraph2();
		if (obj instanceof NfaWithGroups<?, ?>)
			draw(result, (NfaWithGroups<Object, Object>) obj);
		else if (obj instanceof Nfa<?>)
			draw(result, (Nfa<Object>) obj);
		return result;
	}

	public DispatchFunction<Object, String> getGroupFormatter() {
		return groupFormatter;
	}

	public DispatchFunction<Object, String> getStateFormatter() {
		return stateFormatter;
	}

	protected String stateToString(Nfa<Object> nfa, Object state) {
		return stateFormatter.apply(state);
	}

	protected String groupToString(Nfa<Object> nfa, Object group) {
		return groupFormatter.apply(group);
	}
}
