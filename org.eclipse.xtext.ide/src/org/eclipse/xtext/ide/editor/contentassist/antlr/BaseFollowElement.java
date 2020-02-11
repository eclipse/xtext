/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import java.util.List;

import org.eclipse.xtext.AbstractElement;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @since 2.14
 */
public class BaseFollowElement<LATerminal extends ILookAheadTerminal> {

	private AbstractElement currentGrammarElement;
	private List<AbstractElement> trace;
	private List<AbstractElement> localTrace;
	private int lookAhead;
	private List<Integer> paramStack;
	private List<LATerminal> lookAheadTerminals;
	private List<AbstractElement> handledUnorderedGroupElements;
	
	public AbstractElement getGrammarElement() {
		return currentGrammarElement;
	}
	
	public void setGrammarElement(AbstractElement grammarElement) {
		this.currentGrammarElement = grammarElement;
	}
	
	public List<AbstractElement> getTrace() {
		return trace;
	}
	
	public void setTrace(List<AbstractElement> trace) {
		this.trace = trace;
	}
	
	public int getLookAhead() {
		return lookAhead;
	}
	
	public void setLookAhead(int lookAhead) {
		this.lookAhead = lookAhead;
	}
	
	public List<Integer> getParamStack() {
		return paramStack;
	}
	
	public void setParamStack(List<Integer> paramStack) {
		this.paramStack = paramStack;
	}
	
	public List<LATerminal> getLookAheadTerminals() {
		return lookAheadTerminals;
	}
	
	public void setLookAheadTerminals(List<LATerminal> lookAheadTerminals) {
		this.lookAheadTerminals = lookAheadTerminals;
	}
	
	public void setLocalTrace(List<AbstractElement> localTrace) {
		this.localTrace = localTrace;
	}
	
	public List<AbstractElement> getLocalTrace() {
		return localTrace;
	}
	
	public void setHandledUnorderedGroupElements(List<AbstractElement> handledUnorderedGroupElements) {
		this.handledUnorderedGroupElements = handledUnorderedGroupElements;
	}

	public List<AbstractElement> getHandledUnorderedGroupElements() {
		return handledUnorderedGroupElements;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentGrammarElement == null) ? 0 : currentGrammarElement.hashCode());
		result = prime * result + ((localTrace == null) ? 0 : localTrace.hashCode());
		result = prime * result + lookAhead;
		result = prime * result + ((paramStack == null) ? 0 : paramStack.hashCode());
		result = prime * result + ((lookAheadTerminals == null) ? 0 : lookAheadTerminals.hashCode());
		result = prime * result + ((trace == null) ? 0 : trace.hashCode());
		result = prime * result + ((handledUnorderedGroupElements == null) ? 0 : handledUnorderedGroupElements.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseFollowElement<?> other = (BaseFollowElement<?>) obj;
		if (currentGrammarElement == null) {
			if (other.currentGrammarElement != null)
				return false;
		}
		else if (!currentGrammarElement.equals(other.currentGrammarElement))
			return false;
		if (localTrace == null) {
			if (other.localTrace != null)
				return false;
		}
		else if (!localTrace.equals(other.localTrace))
			return false;
		if (lookAhead != other.lookAhead)
			return false;
		if (paramStack == null) {
			if (other.paramStack != null)
				return false;
		}
		else if (!paramStack.equals(other.paramStack))
			return false;
		if (lookAheadTerminals == null) {
			if (other.lookAheadTerminals != null)
				return false;
		}
		else if (!lookAheadTerminals.equals(other.lookAheadTerminals))
			return false;
		if (trace == null) {
			if (other.trace != null)
				return false;
		}
		else if (!trace.equals(other.trace))
			return false;
		if (handledUnorderedGroupElements == null) {
			if (other.handledUnorderedGroupElements != null)
				return false;
		}
		else if (!handledUnorderedGroupElements.equals(other.handledUnorderedGroupElements))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "FollowElement: " + getGrammarElement() + " LA: " + getLookAhead();
	}
	
}