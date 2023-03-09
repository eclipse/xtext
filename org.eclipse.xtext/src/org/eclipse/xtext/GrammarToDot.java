/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.util.GraphvizDotBuilder;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GrammarToDot extends GraphvizDotBuilder {

	protected GrammarElementTitleSwitch aeSwitch = new GrammarElementTitleSwitch();

	protected Node drawAbstractElementTree(AbstractElement ele, Digraph d) {
		Node n = newNode(ele, aeSwitch.doSwitch(ele));
		d.add(n);
		for (EObject c : ele.eContents())
			if (c instanceof AbstractElement) {
				drawAbstractElementTree((AbstractElement) c, d);
				d.add(drawGrammarContainementEdge(ele, (AbstractElement) c));
			}
		return n;
	}

	protected Digraph drawGrammar(Grammar g, Digraph d) {
		for (AbstractRule r : GrammarUtil.allRules(g))
			drawRule(r, d);
		return d;
	}

	protected Props drawGrammarContainementEdge(AbstractElement container, AbstractElement child) {
		return new Edge(container, child);
	}

	@Override
	protected Props drawObject(Object obj) {
		if (obj == null)
			throw new NullPointerException("Obj null");
		if (obj instanceof Grammar)
			return drawGrammar((Grammar) obj, new Digraph());
		if (obj instanceof AbstractRule)
			return drawRule((AbstractRule) obj, new Digraph());
		throw new RuntimeException("Unknown type: " + obj.getClass().getName());
	}

	protected Digraph drawRule(AbstractRule rule, Digraph d) {
		if (rule.getType().getClassifier() instanceof EClass)
			drawAbstractElementTree(rule.getAlternatives(), d);
		return d;
	}

	protected Node newNode(EObject obj, String label) {
		if (obj.eContainer() instanceof AbstractRule) {
			AbstractRule r = (AbstractRule) obj.eContainer();
			return new Node(obj, r.getName() + ":\\n" + label, "record");
		} else
			return new Node(obj, label);
	}
}
