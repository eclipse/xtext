/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.List;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DelegatingAppendable implements IAppendable {
	private IAppendable appendable;

	public DelegatingAppendable(IAppendable appendable) {
		super();
		this.appendable = appendable;
	}

	public IAppendable append(Object obj) {
		appendable = appendable.append(obj);
		return this;
	}

	public IAppendable increaseIndentation() {
		appendable = appendable.increaseIndentation();
		return this;
	}

	public IAppendable decreaseIndentation() {
		appendable = appendable.decreaseIndentation();
		return this;
	}

	public List<String> getImports() {
		return appendable.getImports();
	}

	public void openScope() {
		appendable.openScope();
	}

	public String declareVariable(Object key, String proposedName) {
		return appendable.declareVariable(key, proposedName);
	}

	public String getName(Object key) {
		return appendable.getName(key);
	}

	public void closeScope() {
		appendable.closeScope();
	}
	
}
