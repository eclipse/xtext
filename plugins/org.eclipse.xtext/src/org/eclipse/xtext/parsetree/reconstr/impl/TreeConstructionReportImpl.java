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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.TreeConstructionDiagnostic;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.TreeConstructionReport;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("serial")
public class TreeConstructionReportImpl implements TreeConstructionReport {

	protected class TreeConstructionDiagnosticImpl implements
			TreeConstructionDiagnostic {

		protected EObject current;

		protected List<AbstractToken> ends;

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

		public TreeConstructionDiagnosticImpl(EObject current) {
			super();
			this.current = current;
		}

		protected void addDeadend(AbstractToken end) {
			if (ends == null)
				ends = new ArrayList<AbstractToken>();
			ends.add(end);
		}

		public List<AbstractToken> getDeadEndsSorted() {
			if (ends == null)
				return Collections.emptyList();
			ArrayList<AbstractToken> r = new ArrayList<AbstractToken>(ends);
			Collections.sort(r, new Comparator<AbstractToken>() {
				public int compare(AbstractToken o1, AbstractToken o2) {
					return length.get(o2).compareTo(length.get(o1));
				}
			});
			return r;

		}

		public EObject getEObject() {
			return current;
		}

		public List<String> getLikelyErrorReasons(int count) {
			return getLikelyErrorReasons("", count);
		}

		public List<String> getLikelyErrorReasons(String prefix, int count) {
			List<AbstractToken> r = getDeadEndsSorted();
			ArrayList<String> msgs = new ArrayList<String>();
			for (int i = 0; i < r.size() && i < count; i++) {
				AbstractToken t = r.get(i);
				StringBuffer b = new StringBuffer(prefix);
				b.append(length.get(r.get(i)));
				b.append(": \"");
				b.append(t.serialize(10, 50, true));
				b.append("\":");
				for (String s : collectDiagnostics(t)) {
					b.append("\n");
					b.append(prefix);
					b.append("  -> ");
					b.append(s);
				}
				msgs.add(b.toString());
			}
			return msgs;
		}

		protected TreeConstructionDiagnosticImpl getSubDiagnostic(EObject obj) {
			if (obj == current)
				return this;
			if (subDiag == null)
				subDiag = new HashMap<EObject, TreeConstructionDiagnosticImpl>();
			TreeConstructionDiagnosticImpl r = subDiag.get(obj);
			if (r == null)
				subDiag.put(obj, r = createDiagnostic(obj));
			return r;
		}

		public Collection<? extends TreeConstructionDiagnostic> getSubDiagnostics() {
			if (subDiag == null)
				return Collections.emptyList();
			return subDiag.values();
		}

		@Override
		public String toString() {
			StringBuffer b = new StringBuffer();
			toString("", b);
			return b.toString();
		}

		public void toString(String prefix, StringBuffer out) {
			final String INDENT = "    ";
			out.append(prefix);
			if (current.eContainer() != null) {
				out.append(current.eContainmentFeature().getName());
				if (current.eContainmentFeature().isMany()) {
					Object lst = current.eContainer().eGet(
							current.eContainmentFeature());
					int index = ((List<?>) lst).indexOf(current);
					out.append("[");
					out.append(index);
					out.append("]");
				}
				out.append(" = ");
			}
			out.append(current.eClass().getName());
			EStructuralFeature nameF = current.eClass().getEStructuralFeature(
					"name");
			if (nameF != null) {
				out.append("(name='");
				out.append(current.eGet(nameF));
				out.append("')");
			}
			out.append(" { \n");
			if (subDiag != null)
				for (TreeConstructionDiagnosticImpl tcd : subDiag.values())
					tcd.toString(prefix + INDENT, out);
			else
				for (String r : getLikelyErrorReasons(prefix + INDENT, 5)) {
					out.append(r);
					out.append("\n");
				}
			out.append(prefix);
			out.append("}\n");
		}
	}

	protected List<AbstractToken> deadends = new ArrayList<AbstractToken>();

	protected TreeConstructionDiagnosticImpl diagnostic;

	protected EObject root;

	protected AbstractToken success;

	public TreeConstructionReportImpl(EObject root) {
		super();
		this.root = root;
	}

	protected void addDeadEnd(AbstractToken deadend) {
		this.deadends.add(deadend);
	}

	protected String checkUnconsumed(AbstractToken t, IInstanceDescription inst) {
		if (t.getGrammarElement() == null)
			return null;
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

	public Set<EObject> collectConsumedEObjects() {
		Set<EObject> r = new HashSet<EObject>();
		for (AbstractToken end : deadends) {
			AbstractToken t = end;
			while (t.getNext() != null && t.getNext().getParent() != null
					&& t.getNext().getParent().getGrammarElement() != null) {
				if (GrammarUtil.containingRule(t.getNext().getParent()
						.getGrammarElement()) == GrammarUtil.containingRule(t
						.getGrammarElement()))
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

	protected TreeConstructionDiagnosticImpl createDiagnostic(EObject current) {
		return new TreeConstructionDiagnosticImpl(current);
	}

	public List<AbstractToken> getDeadends() {
		return deadends;
	}

	public TreeConstructionDiagnostic getDiagnostic() {
		if (isSuccess())
			return null;
		if (diagnostic == null) {
			diagnostic = createDiagnostic(root);
			Set<EObject> consumed = collectConsumedEObjects();
			for (AbstractToken t : deadends) {
				EObject c = t.getCurrent().getDelegate();
				if (!consumed.contains(c)) {
					List<EObject> path = new ArrayList<EObject>();
					path.add(c);
					while (c.eContainer() != null)
						path.add(c = c.eContainer());
					Collections.reverse(path);
					TreeConstructionDiagnosticImpl di = diagnostic;
					for (EObject p : path)
						di = di.getSubDiagnostic(p);
					di.addDeadend(t);
				}
			}
		}
		return diagnostic;
	}

	protected String getPath(EObject obj) {
		if (obj.eContainer() == null)
			return "";
		EObject c = obj.eContainer();
		EReference r = obj.eContainmentFeature();
		if (r.isMany()) {
			int index = ((List<?>) c.eGet(r)).indexOf(obj);
			return getPath(c) + "/" + r.getName() + "[" + index + "]";
		}
		return getPath(c) + "/" + r.getName();
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
		b.append("<# of serialized tokens>: ");
		b.append("\"<serializable fragment, starting from the end>\":\n");
		b.append("  -> <possible reasons for not continuing>\n");
		b.append(getDiagnostic().toString());
		return b.toString();
	}
}