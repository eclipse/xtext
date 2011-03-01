/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

public class StringBuilderBasedAppendable implements IAppendable {

	private StringBuilder builder = new StringBuilder(8 * 1024);
	private int indentationlevel = 0;
	private String indentation = "  ";
	private ImportManager importManager;
	
	public IAppendable append(Object obj) {
		if (obj instanceof Later) {
			throw new IllegalArgumentException("Later cannot be appended. Call exec on it.");
		}
		if (obj instanceof JvmTypeReference) {
			appendTypeRef((JvmTypeReference)obj);
		} else if (obj instanceof JvmType) {
			appendType((JvmType)obj);
		} else {
			String string = String.valueOf(obj);
			String replaced = string.replace("\n", getIndentationString());
			builder.append(replaced);
		}
		return this;
	}

	private CharSequence getIndentationString() {
		StringBuilder sb = new StringBuilder(10);
		sb.append("\n");
		for (int i = 0; i < indentationlevel; i++) {
			sb.append(indentation);
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return builder.toString();
	}

	public IAppendable increaseIndentation() {
		indentationlevel++;
		return this;
	}

	public IAppendable decreaseIndentation() {
		if (indentationlevel == 0)
			throw new IllegalStateException("Can't reduce indentation level. It's already zero.");
		indentationlevel--;
		return this;
	}

	private Stack<Map<Object, String>> localVars = new Stack<Map<Object, String>>();
	
	public StringBuilderBasedAppendable(ImportManager typeSerializer){
		this.importManager = typeSerializer;
		openScope();
	}
	
	public StringBuilderBasedAppendable(){
		this(new ImportManager(false));
	}

	public void openScope() {
		localVars.push(new HashMap<Object, String>());
	}

	public String declareVariable(Object key, String proposedName) {
		if (localVars.isEmpty())
			throw new IllegalStateException("No local scope has been opened.");
		Map<Object, String> currentScope = localVars.peek();
		String newName = findNewName(new HashSet<String>(currentScope.values()), proposedName);
		currentScope.put(key, newName);
		return newName;
	}

	protected String findNewName(HashSet<String> names, String proposedName) {
		if (names.contains(proposedName)) {
			for (int i = 1; i < Integer.MAX_VALUE; i++) {
				String newProposal = proposedName + "_" + i;
				if (!names.contains(newProposal))
					return newProposal;
			}
		}
		return proposedName;
	}

	public String getName(Object key) {
		if (localVars.isEmpty())
			throw new IllegalStateException("No local scope has been opened.");
		int size = localVars.size();
		int i = size-1;
		while (i>=0) {
			Map<Object, String> currentScope = localVars.get(i--);
			final String string = currentScope.get(key);
			if (string !=null)
				return string;
		}
		return null;
	}

	public void closeScope() {
		if (localVars.isEmpty())
			throw new IllegalStateException("No local scope has been opened.");
		localVars.pop();
	}
	
	protected void appendTypeRef(JvmTypeReference typeRef) {
		importManager.appendTypeRef(typeRef, builder);
	}

	protected void appendType(final JvmType type) {
		importManager.appendType(type, builder);
	}

	public List<String> getImports() {
		return importManager.getImports();
	}

}