/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;
import org.eclipse.xtext.util.CollectionUtils;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParsedTokenSequence {

	public class Marker {
		private final AbstractParsedToken token;

		public Marker(AbstractParsedToken token) {
			this.token = token;
		}
		
		public void rollback() {
			removeExclusive(token);
		}
	}
	
	private LinkedList<AbstractParsedToken> content;

	public ParsedTokenSequence() {
		this.content = new LinkedList<AbstractParsedToken>();
	}
	
	public void append(AbstractParsedToken token) {
		content.add(token);
	}
	
	public void removeLast() {
		if (!content.isEmpty())
			content.removeLast();
	}
	
	private void removeExclusive(AbstractParsedToken token) {
		while(!content.isEmpty() && content.getLast() != token)
			removeLast();
	}
	
	public void accept(IParsedTokenVisitor visitor) {
		Iterator<AbstractParsedToken> iter = CollectionUtils.each(content, visitor).iterator();
		while(iter.hasNext())
			iter.next();
	}
	
	public void acceptAndDrop(IParsedTokenVisitor visitor) {
		Iterator<AbstractParsedToken> iter = CollectionUtils.each(content, visitor).iterator();
		while(iter.hasNext()) {
			iter.next();
			iter.remove();
		}
	}
	
	public void clear() {
		content.clear();
	}

	public Marker mark() {
		return new Marker(content.isEmpty() ? null : content.getLast());
	}
	
	
}
