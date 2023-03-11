/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.richstring;

import java.util.LinkedList;

import com.google.common.collect.Lists;

/**
 * Default indentation handler for rich strings. Tries to be graceful with
 * inconsistent indentation.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultIndentationHandler implements IRichStringIndentationHandler {

	protected static abstract class IndentationData {
		protected CharSequence value;
		
		protected IndentationData(CharSequence value) {
			this.value = value;
		}
		
		protected abstract void accept(IRichStringPartAcceptor acceptor);
		
		@Override
		public String toString() {
			return getClass().getSimpleName() + " [" + value + "]";
		}
	}
	
	protected static class SemanticIndentationData extends IndentationData {

		protected SemanticIndentationData(CharSequence value) {
			super(value);
		}

		@Override
		protected void accept(IRichStringPartAcceptor acceptor) {
			acceptor.acceptSemanticText(value, null);
		}
		
	}

	protected static class TemplateIndentationData extends IndentationData {

		protected TemplateIndentationData(CharSequence value) {
			super(value);
		}

		@Override
		protected void accept(IRichStringPartAcceptor acceptor) {
			acceptor.acceptTemplateText(value, null);
		}
		
	}

	private LinkedList<IndentationData> indentationData;
	private LinkedList<LinkedList<IndentationData>> indentationDataStack;
	
	public DefaultIndentationHandler() {
		this.indentationData = Lists.newLinkedList();
		this.indentationDataStack = Lists.newLinkedList();
		indentationDataStack.add(indentationData);
	}
	
	@Override
	public void popIndentation() {
		indentationData.removeLast();
		if (indentationData.isEmpty() && indentationDataStack.size() > 1) {
			indentationDataStack.removeLast();
			indentationData = indentationDataStack.getLast();
		}
	}

	@Override
	public void pushTemplateIndentation(CharSequence indentation) {
		if (indentationData.isEmpty()) {
			indentationData.add(new TemplateIndentationData(indentation));
		} else {
			String currentIndentation = getTotalIndentation();
			if (indentation.toString().startsWith(currentIndentation)) {
				String trimmedIndentation = indentation.toString().substring(currentIndentation.length());
				indentationData.add(new TemplateIndentationData(trimmedIndentation));
			} else {
				LinkedList<IndentationData> newIndentationData = Lists.newLinkedList();
				newIndentationData.add(new TemplateIndentationData(indentation));
				indentationDataStack.add(newIndentationData);
				indentationData = newIndentationData;
			}
		}
	}
	
	@Override
	public void pushSemanticIndentation(CharSequence indentation) {
		if (indentationData.isEmpty()) {
			indentationData.add(new SemanticIndentationData(indentation));
		} else {
			String currentIndentation = getTotalIndentation();
			if (indentation.toString().startsWith(currentIndentation)) {
				String trimmedIndentation = indentation.toString().substring(currentIndentation.length());
				indentationData.add(new SemanticIndentationData(trimmedIndentation));
			} else {
				LinkedList<IndentationData> newIndentationData = Lists.newLinkedList();
				newIndentationData.add(new SemanticIndentationData(indentation));
				indentationDataStack.add(newIndentationData);
				indentationData = newIndentationData;
			}
		}
	}
	
	@Override
	public CharSequence getTotalSemanticIndentation() {
		StringBuilder result = new StringBuilder();
		for(IndentationData data: indentationData) {
			if (data instanceof SemanticIndentationData)
				result.append(data.value);
		}
		return result.toString();
	}
	
	@Override
	public String getTotalIndentation() {
		StringBuilder result = new StringBuilder();
		for(IndentationData data: indentationData) {
			result.append(data.value);
		}
		return result.toString();
	}
	
	@Override
	public void accept(IRichStringPartAcceptor acceptor) {
		for(IndentationData data: indentationData) {
			data.accept(acceptor);
		}
	}

}
