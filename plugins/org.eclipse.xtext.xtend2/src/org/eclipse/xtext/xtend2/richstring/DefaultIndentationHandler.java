/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.richstring;

import java.util.LinkedList;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultIndentationHandler implements IRichStringIndentationHandler {

	protected static abstract class IndentationData {
		protected String value;
		
		protected IndentationData(String value) {
			this.value = value;
		}
		
		protected abstract void accept(IRichStringPartAcceptor acceptor);
		
		@Override
		public String toString() {
			return getClass().getSimpleName() + " [" + value + "]";
		}
	}
	
	protected static class SemanticIndentationData extends IndentationData {

		protected SemanticIndentationData(String value) {
			super(value);
		}

		@Override
		protected void accept(IRichStringPartAcceptor acceptor) {
			acceptor.acceptSemanticText(value);
		}
		
	}

	protected static class TemplateIndentationData extends IndentationData {

		protected TemplateIndentationData(String value) {
			super(value);
		}

		@Override
		protected void accept(IRichStringPartAcceptor acceptor) {
			acceptor.acceptTemplateText(value);
		}
		
	}

	private LinkedList<IndentationData> indentationData;
	private LinkedList<LinkedList<IndentationData>> indentationDataStack;
	
	public DefaultIndentationHandler() {
		this.indentationData = Lists.newLinkedList();
		this.indentationDataStack = Lists.newLinkedList();
		indentationDataStack.add(indentationData);
	}
	
	public void popIndentation() {
		indentationData.removeLast();
		if (indentationData.isEmpty() && indentationDataStack.size() > 1) {
			indentationDataStack.removeLast();
		}
	}

	public void pushTemplateIndentation(String indentation) {
		if (indentationData.isEmpty()) {
			indentationData.add(new TemplateIndentationData(indentation));
		} else {
			IndentationData head = indentationData.getLast();
			if (indentation.startsWith(head.value)) {
				String trimmedIndentation = indentation.substring(head.value.length());
				indentationData.add(new TemplateIndentationData(trimmedIndentation));
			} else {
				LinkedList<IndentationData> newIndentationData = Lists.newLinkedList();
				newIndentationData.add(new TemplateIndentationData(indentation));
				indentationDataStack.add(newIndentationData);
			}
		}
	}
	
	public void pushSemanticIndentation(String indentation) {
		if (indentationData.isEmpty()) {
			indentationData.add(new SemanticIndentationData(indentation));
		} else {
			IndentationData head = indentationData.getLast();
			if (indentation.startsWith(head.value)) {
				String trimmedIndentation = indentation.substring(head.value.length());
				indentationData.add(new SemanticIndentationData(trimmedIndentation));
			} else {
				LinkedList<IndentationData> newIndentationData = Lists.newLinkedList();
				newIndentationData.add(new SemanticIndentationData(indentation));
				indentationDataStack.add(newIndentationData);
			}
		}
	}
	
	public String getTotalSemanticIndentation() {
		StringBuilder result = new StringBuilder();
		for(IndentationData data: indentationData) {
			if (data instanceof SemanticIndentationData)
				result.append(data.value);
		}
		return result.toString();
	}
	
	public void accept(IRichStringPartAcceptor acceptor) {
		for(IndentationData data: indentationData) {
			data.accept(acceptor);
		}
	}

}
