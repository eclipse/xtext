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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.TreeConstructionReport;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor2.AbstractToken2;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("serial")
public class TreeConstructionReportImpl implements TreeConstructionReport {

	protected List<AbstractToken2> deadends = new ArrayList<AbstractToken2>();

	protected Map<AbstractToken2, Integer> length = new HashMap<AbstractToken2, Integer>() {
		@Override
		public Integer get(Object key) {
			AbstractToken2 t = (AbstractToken2) key;
			Integer r = super.get(key);
			if (r == null) {
				int l = 0;
				AbstractToken2 x = t;
				while ((x = x.getNext()) != null)
					l++;
				r = l;
				put(t, l);
			}
			return r;
		}
	};

	protected AbstractToken2 success;

	public TreeConstructionReportImpl() {
		super();
	}

	protected void addDeadEnd(AbstractToken2 deadend) {
		this.deadends.add(deadend);
	}

	protected String checkUnconsumed(AbstractToken2 t, IInstanceDescription inst) {
		boolean finalNode = ParseTreeConstructorUtil.isRuleEnd(t
				.getGrammarElement());
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

	protected List<String> collectDiagnostics(AbstractToken2 t) {
		int i = 0;
		AbstractToken2 f;
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

	public List<AbstractToken2> getDeadends() {
		return deadends;
	}

	public List<AbstractToken2> getDeadEndsSorted() {
		ArrayList<AbstractToken2> r = new ArrayList<AbstractToken2>(deadends);
		Collections.sort(r, new Comparator<AbstractToken2>() {
			public int compare(AbstractToken2 o1, AbstractToken2 o2) {
				return length.get(o2).compareTo(length.get(o1));
			}
		});
		return r;

	}

	public List<String> getLikelyErrorReasons() {
		List<AbstractToken2> r = getDeadEndsSorted();
		ArrayList<String> msgs = new ArrayList<String>();
		for (int i = 0; i < r.size() && i < 5; i++) {
			AbstractToken2 t = r.get(i);
			StringBuffer b = new StringBuffer();
			b.append(length.get(r.get(i)));
			b.append(": \"");
			b.append(t.serialize(10, 50, true));
			b.append("\":");
			for (String s : collectDiagnostics(t)) {
				b.append("\n  -> ");
				b.append(s);
			}
			msgs.add(b.toString());
		}
		return msgs;
	}

	public AbstractToken2 getSuccess() {
		return success;
	}

	public boolean isSuccess() {
		return success != null;
	}

	protected void setSuccess(AbstractToken2 succes) {
		this.success = succes;
	}

	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append("<# of serialized tokens>: ");
		b.append("<serializable fragment, starting from the end>:\n");
		b.append("  -> <possible reasons for not continuing >\n");
		for (String s : getLikelyErrorReasons()) {
			b.append(s);
			b.append("\n");
		}
		return b.toString();
	}

}