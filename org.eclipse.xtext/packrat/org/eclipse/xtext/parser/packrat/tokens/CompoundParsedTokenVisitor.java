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
import java.util.List;

import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompoundParsedTokenVisitor extends AbstractParsedTokenVisitor {

	private final List<IParsedTokenVisitor> delegates;
	
	public CompoundParsedTokenVisitor(IParsedTokenVisitor... delegates) {
		this.delegates = new ArrayList<IParsedTokenVisitor>(delegates.length);
		this.delegates.addAll(Arrays.asList(delegates));
	}
	
	public boolean add(IParsedTokenVisitor visitor) {
		return delegates.add(visitor);
	}

	public boolean remove(IParsedTokenVisitor visitor) {
		return delegates.remove(visitor);
	}

	@Override
	public void visitAbstractParsedToken(AbstractParsedToken token) {
		for(IParsedTokenVisitor visitor: delegates)
			token.accept(visitor);
	}
	
}
