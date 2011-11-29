/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.List;

import org.eclipse.xtext.common.types.JvmType;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DelegatingAppendable implements IAppendable {
	private IAppendable appendable;

	public DelegatingAppendable(IAppendable appendable) {
		super();
		this.appendable = appendable;
	}

	public IAppendable append(String string) {
		return appendable.append(string);
	}

	public IAppendable append(JvmType type) {
		return appendable.append(type);
	}

	public IAppendable increaseIndentation() {
		return appendable.increaseIndentation();
	}

	public IAppendable decreaseIndentation() {
		return appendable.decreaseIndentation();
	}

	public List<String> getImports() {
		return appendable.getImports();
	}

	public void openScope() {
		appendable.openScope();
	}

	public void openPseudoScope() {
		appendable.openPseudoScope();
	}

	public String declareVariable(Object key, String proposedName) {
		return appendable.declareVariable(key, proposedName);
	}

	public String declareSyntheticVariable(Object key, String proposedName) {
		return appendable.declareSyntheticVariable(key, proposedName);
	}

	public String getName(Object key) {
		return appendable.getName(key);
	}

	public Object getObject(String name) {
		return appendable.getObject(name);
	}

	public void closeScope() {
		appendable.closeScope();
	}

}
