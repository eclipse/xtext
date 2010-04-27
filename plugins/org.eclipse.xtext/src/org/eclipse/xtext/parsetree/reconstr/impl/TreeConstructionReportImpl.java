/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.TreeConstructionDiagnostic;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.TreeConstructionReport;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Join;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("serial")
public class TreeConstructionReportImpl implements TreeConstructionReport {

	protected class TreeConstructionDiagnosticImpl implements TreeConstructionDiagnostic {

		protected AbstractToken deadend;

		protected Map<AbstractToken, Integer> length = new HashMap<AbstractToken, Integer>() {
			@Override
			public Integer get(Object key) {
				AbstractToken t = (AbstractToken) key;
				Integer r = super.get(key);
				if (r == null) {
					int l = 0;
					AbstractToken x = t;
					while ((x = x.getNext()) != null)
						l++;
					r = l;
					put(t, l);
				}
				return r;
			}
		};

		protected Map<EObject, TreeConstructionDiagnosticImpl> subDiag;

		public TreeConstructionDiagnosticImpl(AbstractToken deadend) {
			super();
			this.deadend = deadend;
		}

		public EObject getEObject() {
			return deadend.getCurrent().getDelegate();
		}

		public String getLikelyErrorReasons() {
			return getLikelyErrorReasons("");
		}

		public String getLikelyErrorReasons(String prefix) {
			StringBuffer b = new StringBuffer(prefix);
			b.append(length.get(deadend));
			b.append(":");
			b.append(EmfFormatter.objPath(deadend.getCurrent().getDelegate()));
			b.append(": \"");
			b.append(deadend.serialize(10, 50, true));
			b.append("\":");
			for (String s : collectDiagnostics(deadend)) {
				b.append("\n");
				b.append(prefix);
				b.append("  -> ");
				b.append(s);
			}
			return b.toString();
		}

		@Override
		public String toString() {
			return getLikelyErrorReasons();
		}

	}

	private static final int THRESHOLD = 10;

	protected SortedSet<Pair<Integer, AbstractToken>> deadends = Sets
			.newTreeSet(new Comparator<Pair<Integer, AbstractToken>>() {
				public int compare(Pair<Integer, AbstractToken> o1, Pair<Integer, AbstractToken> o2) {
					return o1.getFirst().compareTo(o2.getFirst());
				}
			});

	protected TreeConstructionDiagnosticImpl diagnostic;

	protected TreeConstructionNFAProvider nfaProvider = new TreeConstructionNFAProvider();

	protected EObject root;

	protected AbstractToken success;

	public TreeConstructionReportImpl(EObject root) {
		super();
		this.root = root;
	}

	protected void addDeadEnd(int depth, AbstractToken deadend) {
		if (deadends.size() >= THRESHOLD && depth < deadends.first().getFirst())
			return;
		if (deadends.size() >= THRESHOLD)
			deadends.remove(deadends.first());
		deadends.add(Tuples.pair(depth, deadend));
	}

	protected String checkUnconsumed(AbstractToken t, IInstanceDescription inst) {
		if (t.getGrammarElement() == null)
			return null;
		boolean finalNode = nfaProvider.getNFA(t.getGrammarElement()).isEndState();
		if (!finalNode || inst.isConsumed())
			return null;
		ParserRule pr = GrammarUtil.containingParserRule(t.getGrammarElement());
		StringBuffer b = new StringBuffer();
		b.append("Can not leave rule '");
		b.append(pr.getName());
		b.append("' since the current object '");
		b.append(inst.getDelegate().eClass().getName());
		b.append("' has features with unconsumed values: ");
		Map<EStructuralFeature, Integer> unc = inst.getUnconsumed();
		int i = 0;
		for (Map.Entry<EStructuralFeature, Integer> e : unc.entrySet()) {
			b.append("'");
			b.append(e.getKey().getName());
			b.append("':");
			b.append(e.getValue());
			if (++i != unc.size())
				b.append(", ");
		}
		return b.toString();
	}

	public Set<EObject> collectConsumedEObjects() {
		Set<EObject> r = new HashSet<EObject>();
		for (AbstractToken end : getDeadends()) {
			AbstractToken t = end;
			while (t.getNext() != null && t.getNext().getParent() != null
					&& t.getNext().getParent().getGrammarElement() != null) {
				if (GrammarUtil.containingRule(t.getNext().getParent().getGrammarElement()) == GrammarUtil
						.containingRule(t.getGrammarElement()))
					r.add(t.getNext().getCurrent().getDelegate());
				t = t.getNext();
			}
		}
		return r;
	}

	protected List<String> collectDiagnostics(AbstractToken t) {
		int i = 0;
		AbstractToken f;
		IInstanceDescription inst = t.tryConsume();
		ArrayList<String> diags = new ArrayList<String>();
		while ((f = t.createFollower(i++, inst)) != null) {
			StringBuffer b = new StringBuffer();
			b.append(f.getClass().getSimpleName());
			b.append(": ");
			String d = f.getDiagnostic();
			if (d == null)
				b.append("n/a");
			else
				b.append(d);
			diags.add(b.toString());
		}
		String cons = checkUnconsumed(t, inst);
		if (cons != null)
			diags.add(cons);
		return diags;
	}

	protected TreeConstructionDiagnosticImpl createDiagnostic(AbstractToken token) {
		return new TreeConstructionDiagnosticImpl(token);
	}

	public List<AbstractToken> getDeadends() {
		List<AbstractToken> deadends = Lists.newArrayList();
		for (Pair<Integer, AbstractToken> p : this.deadends)
			deadends.add(p.getSecond());
		Collections.reverse(deadends);
		return deadends;
	}

	public List<TreeConstructionDiagnostic> getDiagnostics() {
		if (isSuccess())
			return null;
		List<TreeConstructionDiagnostic> result = Lists.newArrayList();
		for (AbstractToken t : getDeadends())
			result.add(createDiagnostic(t));
		return result;
	}

	public AbstractToken getSuccess() {
		return success;
	}

	public boolean isSuccess() {
		return success != null;
	}

	protected void setSuccess(AbstractToken succes) {
		this.success = succes;
	}

	@Override
	public String toString() {
		if (isSuccess())
			return "Serialization has been successful";
		StringBuffer b = new StringBuffer();
		b.append("<# of serialized tokens>: <EObject path> ");
		b.append("\"<serializable fragment, starting from the end>\":\n");
		b.append("  -> <possible reasons for not continuing>\n");
		b.append(Join.join("\n", getDiagnostics()));
		return b.toString();
	}
}