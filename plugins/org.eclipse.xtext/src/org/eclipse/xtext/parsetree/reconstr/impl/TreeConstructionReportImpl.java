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
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parsetree.reconstr.IEObjectConsumer;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.TreeConstructionDiagnostic;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.TreeConstructionReport;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AssignmentToken;
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

		protected Map<AbstractToken, Integer> lengthCache = new HashMap<AbstractToken, Integer>() {
			@Override
			public Integer get(Object key) {
				AbstractToken token = (AbstractToken) key;
				Integer result = super.get(key);
				if (result == null) {
					int length = 0;
					AbstractToken currentToken = token;
					while ((currentToken = currentToken.getNext()) != null)
						length++;
					result = length;
					put(token, length);
				}
				return result;
			}
		};

		protected Map<EObject, TreeConstructionDiagnosticImpl> semanticElement2diagnostic;

		public TreeConstructionDiagnosticImpl(AbstractToken deadend) {
			super();
			this.deadend = deadend;
		}

		public EObject getEObject() {
			return deadend.getEObjectConsumer().getEObject();
		}

		public String getLikelyErrorReasons() {
			return getLikelyErrorReasons("");
		}

		public String getLikelyErrorReasons(String prefix) {
			StringBuffer b = new StringBuffer(prefix);
			b.append(lengthCache.get(deadend));
			b.append(":");
			b.append(EmfFormatter.objPath(deadend.getEObjectConsumer().getEObject()));
			b.append(": \"");
			b.append(deadend.dumpTokens(10, 50, true));
			b.append("\":");
			for (String diagnosticAsString : collectDiagnostics(deadend)) {
				b.append("\n");
				b.append(prefix);
				b.append("  -> ");
				b.append(diagnosticAsString);
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

	protected String checkUnconsumed(AbstractToken token, IEObjectConsumer instanceDescription) {
		if (token.getGrammarElement() == null)
			return null;
		boolean finalNode = nfaProvider.getNFA(token.getGrammarElement()).isEndState();
		if (!finalNode || instanceDescription.isConsumed())
			return null;
		ParserRule parserRule = GrammarUtil.containingParserRule(token.getGrammarElement());
		StringBuffer b = new StringBuffer();
		b.append("Can not leave rule '");
		b.append(parserRule.getName());
		b.append("' since the current object '");
		b.append(instanceDescription.getEObject().eClass().getName());
		b.append("' has features with unconsumed values: ");
		Map<EStructuralFeature, Integer> unconsumedTokens = instanceDescription.getUnconsumed();
		int i = 0;
		for (Map.Entry<EStructuralFeature, Integer> unconsumedFeature2NumberEntry : unconsumedTokens.entrySet()) {
			b.append("'");
			b.append(unconsumedFeature2NumberEntry.getKey().getName());
			b.append("':");
			b.append(unconsumedFeature2NumberEntry.getValue());
			if (++i != unconsumedTokens.size())
				b.append(", ");
		}
		return b.toString();
	}

	public Set<EObject> collectConsumedEObjects() {
		Set<EObject> result = new HashSet<EObject>();
		for (AbstractToken endToken : getDeadends()) {
			AbstractToken currentToken = endToken;
			while (currentToken.getNext() != null && currentToken.getNext().getLastRuleCallOrigin() != null
					&& currentToken.getNext().getLastRuleCallOrigin().getGrammarElement() != null) {
				if (GrammarUtil.containingRule(currentToken.getNext().getLastRuleCallOrigin().getGrammarElement()) == GrammarUtil
						.containingRule(currentToken.getGrammarElement()))
					result.add(currentToken.getNext().getEObjectConsumer().getEObject());
				currentToken = currentToken.getNext();
			}
		}
		return result;
	}

	protected List<String> collectDiagnostics(AbstractToken token) {
		int i = 0;
		AbstractToken currentFollowerToken;
		IEObjectConsumer instanceDescription = token.tryConsume();
		ArrayList<String> diagnsotics = new ArrayList<String>();
		while ((currentFollowerToken = token.createFollower(i++, instanceDescription)) != null) {
			StringBuffer b = new StringBuffer();
			b.append(currentFollowerToken.getClass().getSimpleName());
			b.append(": ");
			String diagnostic = getDiagnosticMessage(currentFollowerToken);
			if (diagnostic == null)
				b.append("n/a");
			else
				b.append(diagnostic);
			diagnsotics.add(b.toString());
		}
		String consumedTokenAsString = checkUnconsumed(token, instanceDescription);
		if (consumedTokenAsString != null)
			diagnsotics.add(consumedTokenAsString);
		return diagnsotics;
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

	protected String getDiagnosticMessage(AbstractToken token) {
		if (token instanceof AssignmentToken)
			return getDiagnosticMessage((AssignmentToken) token);
		return null;
	}

	protected String getDiagnosticMessage(AssignmentToken token) {
		Assignment ass = (Assignment) token.getGrammarElement();
		boolean consumable = token.getEObjectConsumer().getConsumable(ass.getFeature(), false) != null;
		if (!consumable) {
			EStructuralFeature f = token.getEObjectConsumer().getEObject().eClass().getEStructuralFeature(
					ass.getFeature());
			if (f == null)
				return "The current object of type '" + token.getEObjectConsumer().getEObject().eClass().getName()
						+ "' does not have a feature named '" + ass.getFeature() + "'";
			String cls = f.getEContainingClass() == token.getEObjectConsumer().getEObject().eClass() ? f
					.getEContainingClass().getName() : f.getEContainingClass().getName() + "("
					+ token.getEObjectConsumer().getEObject().eClass().getName() + ")";
			String feat = cls + "." + f.getName();
			if (f.isMany()) {
				int size = ((List<?>) token.getEObjectConsumer().getEObject().eGet(f)).size();
				return "All " + size + " values of " + feat + " have been consumed. "
						+ "More are needed to continue here.";
			} else
				return feat + " is not set.";
		}
		return null;
	}

	public List<TreeConstructionDiagnostic> getDiagnostics() {
		if (isSuccess())
			return null;
		List<TreeConstructionDiagnostic> result = Lists.newArrayList();
		for (AbstractToken deadEndToken : getDeadends())
			result.add(createDiagnostic(deadEndToken));
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