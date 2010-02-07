/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.GraphvizDotBuilder;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GrammarToDot extends GraphvizDotBuilder {

	protected class AESwitch extends XtextSwitch<Node> {

		private String card(AbstractElement ele) {
			return ele.getCardinality() == null ? "" : ele.getCardinality();
		}

		@Override
		public Node caseAbstractElement(AbstractElement object) {
			return newNode(object, object.eClass().getName() + card(object));
		}

		@Override
		public Node caseAction(Action object) {
			String o = object.getOperator();
			String t = object.getType().getClassifier().getName();
			String f = object.getFeature();
			o = (o == null) ? "" : o;
			t = (t == null) ? "" : t;
			f = (f == null) ? "" : "." + f;
			return newNode(object, "{" + t + f + o + "}" + card(object));
		}

		@Override
		public Node caseAlternatives(Alternatives object) {
			return newNode(object, "\\|" + card(object));
		}
		
		@Override
		public Node caseUnorderedGroup(UnorderedGroup object) {
			return newNode(object, "\\&" + card(object));
		}

		@Override
		public Node caseAssignment(Assignment object) {
			return newNode(object, object.getFeature() + object.getOperator()
					+ " " + card(object));
		}

		@Override
		public Node caseCrossReference(CrossReference object) {
			return newNode(object, "["
					+ object.getType().getClassifier().getName() + "]"
					+ card(object));
		}

		@Override
		public Node caseGroup(Group object) {
			return newNode(object, "( )" + card(object));
		}

		@Override
		public Node caseKeyword(Keyword object) {
			return newNode(object, "\"" + object.getValue() + "\""
					+ card(object));
		}

		@Override
		public Node caseRuleCall(RuleCall object) {
			return newNode(object, "=>" + object.getRule().getName()
					+ card(object));
		}

		@Override
		public Node defaultCase(EObject object) {
			return newNode(object, object.eClass().getName());
		}

	}

	protected AESwitch aeSwitch = new AESwitch();

	protected Node drawAbstractElementTree(AbstractElement ele, Digraph d) {
		Node n = aeSwitch.doSwitch(ele);
		d.add(n);
		for (EObject c : ele.eContents())
			if (c instanceof AbstractElement) {
				drawAbstractElementTree((AbstractElement) c, d);
				d.add(new Edge(ele, c));
			}
		return n;
	}

	protected Digraph drawGrammar(Grammar g, Digraph d) {
		for (AbstractRule r : g.getRules())
			drawRule(r, d);
		return d;
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

	protected Digraph drawRule(AbstractRule r, Digraph d) {
		drawAbstractElementTree(r.getAlternatives(), d);
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
