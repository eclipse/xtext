/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist.antlr;

import java.util.List;

import org.eclipse.xtext.AbstractElement;

/**
 * Simple bean that reflects the current state, when the content assist parser
 * hit EOF.
 *
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FollowElement {

	private AbstractElement currentGrammarElement;
	private List<AbstractElement> trace;
	private List<AbstractElement> localTrace;
	private int lookAhead;
	private List<LookAheadTerminal> lookAheadTerminals;
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
	
	public List<LookAheadTerminal> getLookAheadTerminals() {
		return lookAheadTerminals;
	}
	
	public void setLookAheadTerminals(List<LookAheadTerminal> lookAheadTerminals) {
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
		FollowElement other = (FollowElement) obj;
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
