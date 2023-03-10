/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.evaluator;

import java.util.List;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.codetemplates.templates.Dollar;
import org.eclipse.xtext.ui.codetemplates.templates.Literal;
import org.eclipse.xtext.ui.codetemplates.templates.Codetemplate;
import org.eclipse.xtext.ui.codetemplates.templates.TemplateBody;
import org.eclipse.xtext.ui.codetemplates.templates.TemplatePart;
import org.eclipse.xtext.ui.codetemplates.templates.Variable;
import org.eclipse.xtext.ui.codetemplates.ui.projectedEditing.IProjectedContent;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EvaluatedTemplate implements IProjectedContent {

	private final List<Pair<Integer, Integer>> mappedOffsetHints; 

	private final String evaluatedResult;
	
	private final String originalTemplate;
	
	public EvaluatedTemplate(Codetemplate template) {
		TemplateBody body = template.getBody();
		StringBuilder buffer = new StringBuilder();
		StringBuilder original = new StringBuilder();
		mappedOffsetHints = Lists.newArrayList();
		int lastOffset = 0;
		for(TemplatePart part: body.getParts()) {
			ICompositeNode node = NodeModelUtils.getNode(part);
			if (node != null) {
				mappedOffsetHints.add(Tuples.create(buffer.length(), node.getTotalOffset()));
				lastOffset = node.getTotalOffset() + node.getTotalLength();
				original.append(node.getText());
				if (part instanceof Literal) {
					buffer.append(((Literal) part).getValue());
				} else if (part instanceof Dollar) {
					buffer.append("$");
				} else if (part instanceof Variable) {
					if (((Variable) part).getName() != null) {
						buffer.append(((Variable) part).getName());
					}
				}
			}
		}
		mappedOffsetHints.add(Tuples.create(buffer.length(), lastOffset));
		evaluatedResult = buffer.toString();
		originalTemplate = original.toString();
	}
	
	@Override
	public int getOriginalOffset(int mappedOffset) {
		Pair<Integer, Integer> current = mappedOffsetHints.get(0);
		for(int i = 1; i < mappedOffsetHints.size(); i++) {
			Pair<Integer, Integer> next = mappedOffsetHints.get(i);
			if (next.getFirst() > mappedOffset) {
				int result = current.getSecond() + mappedOffset - current.getFirst();
				return result;
			}
			current = next;
		}
		int result = current.getSecond() + mappedOffset - current.getFirst();
		return result;
	}
	
	@Override
	public int getMappedOffset(int originalOffset) {
		Pair<Integer, Integer> current = mappedOffsetHints.get(0);
		for(int i = 1; i < mappedOffsetHints.size(); i++) {
			Pair<Integer, Integer> next = mappedOffsetHints.get(i);
			if (next.getSecond() > originalOffset) {
				int result = current.getFirst() + originalOffset - current.getSecond();
				return result;
			}
			current = next;
		}
		int result = current.getFirst() + originalOffset - current.getSecond();
		return result;
	}
	
	@Override
	public String getOriginalString() {
		return originalTemplate;
	}
	
	@Override
	public String getMappedString() {
		return evaluatedResult;
	}
}
