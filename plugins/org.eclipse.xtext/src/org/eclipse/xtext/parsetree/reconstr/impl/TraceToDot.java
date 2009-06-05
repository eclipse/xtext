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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor2.AbstractToken2;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TraceToDot extends FollowerToDot {

	protected Props drawObject(Object obj) {
		if (obj instanceof AbstractToken2)
			return drawPTC((AbstractToken2) obj);
		return super.drawObject(obj);
	}

	protected Digraph drawPTC(AbstractToken2 obj) {
		Digraph d = new Digraph();
		Set<AbstractToken2> drawn = new HashSet<AbstractToken2>();
		Set<ParserRule> drawnRules = new HashSet<ParserRule>();
		List<AbstractToken2> traces = new ArrayList<AbstractToken2>();
		traces.add(obj);
		traces.addAll(obj.getParseTreeConstructor().getFails());
		boolean sol = true;
		for (AbstractToken2 t : traces) {
			while (t != null && !drawn.contains(t)) {
				// String ser = ((AbstractToken2) t).serialize().replaceAll(
				// "\\\\", "\\\\");
				String s = t.getClass().getSimpleName() + "\\n"
						+ t.getCurrent() + "\\n'" /* + ser */+ "'";
				d.add(new Node(t, s));
				if (t.getGrammarElement() != null) {
					ParserRule pr = GrammarUtil.containingParserRule(t
							.getGrammarElement());
					if (pr != null && !drawnRules.contains(pr)) {
						drawnRules.add(pr);
						drawRule(pr, d);
					}
				}
				if (t.getNext() != null) {
					Edge e = new Edge(t.getNext(), t);
					e.setLabel(String.valueOf(((AbstractToken2) t).getNo()));
					if (!sol)
						e.setStyle("dashed");
					d.add(e);
				}
				drawn.add(t);
				t = (AbstractToken2) t.getNext();
			}
			sol = false;
		}
		return d;
	}
}
