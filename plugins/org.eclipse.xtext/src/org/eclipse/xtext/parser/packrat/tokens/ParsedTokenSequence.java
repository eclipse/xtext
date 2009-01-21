/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParsedTokenSequence {

	public class Marker {
		private int size;

		public void rollback() {
			ParsedTokenSequence.this.size = size;
		}
		
		public void release() {
			if (bufferSize < markerBuffer.length)
				markerBuffer[bufferSize++] = this;
		}

		public String toString() {
			return "Marker for Token[" + size + "]"; 
		}
	}
	
	private Marker[] markerBuffer;
	private int bufferSize;
	
	private ArrayList<AbstractParsedToken> content;
	private int size;
	

	public ParsedTokenSequence() {
		this.content = new ArrayList<AbstractParsedToken>(128);
		this.size = 0;
		this.markerBuffer = new Marker[10];
	}
	
	public void append(AbstractParsedToken token) {
		if (size == content.size())
			content.add(token);
		else
			content.set(size, token);
		size++;
	}
	
	public void accept(IParsedTokenVisitor visitor) {
		for(int i = 0; i < size; i++) {
			content.get(i).accept(visitor);
		}
	}
	
	public void acceptAndClear(IParsedTokenVisitor visitor) {
		accept(visitor);
		clear();
	}
	
	public void clear() {
		content.clear();
		size = 0;
		Arrays.fill(markerBuffer, null);
		bufferSize = 0;
	}

	public Marker mark() {
		final Marker result = bufferSize > 0 ? markerBuffer[--bufferSize] : new Marker();
		result.size = size;
		return result;
	}
	
}
