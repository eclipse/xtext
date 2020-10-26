/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace.node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * A template node applies a {@link StringConcatenationClient} to compute its children.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class TemplateNode extends CompositeGeneratorNode
		implements StringConcatenationClient.TargetStringConcatenation {
	private final GeneratorNodeExtensions nodeFactory;

	public TemplateNode(StringConcatenationClient contents, GeneratorNodeExtensions nodeFactory) {
		this.nodeFactory = nodeFactory;
		StringConcatenationClient.appendTo(contents, this);
	}

	private CompositeGeneratorNode currentParent = this;

	@Override
	public void append(Object object, String indentation) {
		if (indentation.length() > 0) {
			CompositeGeneratorNode before = currentParent;
			try {
				currentParent = new IndentNode(indentation, false, true);
				before.getChildren().add(currentParent);
				append(object);
			} finally {
				currentParent = before;
			}
		} else {
			append(object);
		}
	}

	private static final Splitter lineSplitter = Splitter.on(Pattern.compile("\\R"));

	@Override
	public void append(Object object) {
		if (object == null) {
			return;
		}
		if (object instanceof StringConcatenationClient) {
			nodeFactory.appendTemplate(currentParent, ((StringConcatenationClient) object));
		} else if (object instanceof IGeneratorNode) {
			currentParent.getChildren().add((IGeneratorNode) object);
		} else {
			String str = object.toString();
			Iterator<String> iter = lineSplitter.split(str).iterator();
			while (iter.hasNext()) {
				String segment = iter.next();
				nodeFactory.append(currentParent, segment);
				if (iter.hasNext()) {
					newLine();
				}
			}
		}
	}

	protected Iterable<IGeneratorNode> leafsBackwards(IGeneratorNode it) {
		if (it instanceof CompositeGeneratorNode) {
			return IterableExtensions.reduce(
					Lists.transform(Lists.reverse(((CompositeGeneratorNode) it).getChildren()), this::leafsBackwards),
					Iterables::concat);
		} else {
			return Lists.newArrayList(it);
		}
	}

	@Override
	public void appendImmediate(Object object, String indentation) {
		List<IGeneratorNode> removed = new ArrayList<>();
		for (int i = currentParent.getChildren().size() - 1; i >= 0; i--) {
			IGeneratorNode node = currentParent.getChildren().get(i);
			if (node instanceof TextNode && !TemplateNode.hasContent(((TextNode) node).getText())) {
				removed.add(currentParent.getChildren().remove(i));
			} else {
				if (node instanceof NewLineNode) {
					removed.add(currentParent.getChildren().remove(i));
				} else {
					append(object, indentation);
					Lists.reverse(removed).forEach(it -> append(it, indentation));
					return;
				}
			}
		}
		append(object, indentation);
	}

	protected static boolean hasContent(CharSequence s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isWhitespace(s.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void newLine() {
		nodeFactory.appendNewLine(currentParent);
	}

	@Override
	public void newLineIfNotEmpty() {
		nodeFactory.appendNewLineIfNotEmpty(currentParent);
	}

	@Override
	public char charAt(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int length() {
		throw new UnsupportedOperationException();
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		throw new UnsupportedOperationException();
	}
}
