/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import static org.eclipse.xtext.util.CollectionUtils.each;
import static org.eclipse.xtext.util.CollectionUtils.loop;

import java.util.LinkedList;

import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;
import org.eclipse.xtext.util.CollectionUtils;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParsedTokenSequence {

	public class Marker {
		private final int size;

		public Marker(int size) {
			this.size = size;
		}
		
		public void rollback() {
			while(content.size() > size)
				content.removeLast();
		}

		public String toString() {
			return "Marker for Token[" + size + "]"; 
		}
	}
	
	private LinkedList<AbstractParsedToken> content;

	public ParsedTokenSequence() {
		this.content = new LinkedList<AbstractParsedToken>();
	}
	
	public void append(AbstractParsedToken token) {
		content.add(token);
	}
	
	public void accept(IParsedTokenVisitor visitor) {
		loop(each(content, visitor));
	}
	
	public void acceptAndClear(IParsedTokenVisitor visitor) {
		CollectionUtils.clear(each(content, visitor));
	}
	
	public void clear() {
		content.clear();
	}

	public Marker mark() {
		return new Marker(content.size());
	}
	
}
