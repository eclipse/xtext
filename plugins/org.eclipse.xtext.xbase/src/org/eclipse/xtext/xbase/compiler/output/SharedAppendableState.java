/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler.output;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.ScopeStack;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
@NonNullByDefault
public class SharedAppendableState {

	private int indentationlevel = 0;
	private final String indentation;
	private final String lineSeparator;
	private final ScopeStack scopes;
	private final ImportManager importManager;
	
	public SharedAppendableState(String indentation, String lineSeparator, ImportManager importManager) {
		this.indentation = indentation;
		this.lineSeparator = lineSeparator;
		this.importManager = importManager;
		this.scopes = new ScopeStack();
		openScope();
	}
	
	public SharedAppendableState(ImportManager importManager) {
		this("  ", "\n", importManager);
	}
	
	public void appendNewLineAndIndentation(IAcceptor<String> content) {
		content.accept(lineSeparator);
		for(int i = 0; i < indentationlevel; i++) {
			content.accept(indentation);
		}
	}
	
	public void increaseIndentation() {
		indentationlevel++;
	}

	public void decreaseIndentation() {
		if (indentationlevel == 0)
			throw new IllegalStateException("Can't reduce indentation level. It's already zero.");
		indentationlevel--;
	}
	
	public void openScope() {
		scopes.openScope(false);
	}
	
	public void openPseudoScope() {
		scopes.openScope(true);
	}
	
	public String declareVariable(Object key, String proposedName) {
		return scopes.declareVariable(key, proposedName, false);
	}
	
	public String declareSyntheticVariable(Object key, String proposedName) {
		return scopes.declareVariable(key, proposedName, true);
	}
	
	public void closeScope() {
		scopes.closeScope();
	}
	
	public void appendType(final JvmType type, IAcceptor<String> content) {
		// don't import if if a local variable with the same name is on the scope
		//TODO logic should be moved to ImportManager eventually.
		if (hasObject(type.getSimpleName())) {
			content.accept(type.getQualifiedName('.'));
		} else {
			StringBuilder builder = new StringBuilder();
			importManager.appendType(type, builder);
			content.accept(builder.toString());
		}
	}
	
	public void appendType(final Class<?> type, IAcceptor<String> content) {
		// don't import if if a local variable with the same name is on the scope
		//TODO logic should be moved to ImportManager eventually.
		if (hasObject(type.getSimpleName())) {
			content.accept(type.getCanonicalName());
		} else {
			StringBuilder builder = new StringBuilder();
			importManager.appendType(type, builder);
			content.accept(builder.toString());
		}
	}

	public List<String> getImports() {
		return importManager.getImports();
	}
	
	public String getName(Object key) {
		String result = scopes.getName(key);
		if (result == null)
			throw new IllegalStateException("Cannot get name for " + key);
		return result;
	}
	
	public boolean hasName(Object key) {
		return scopes.getName(key) != null;
	}

	public Object getObject(String name) {
		Object result = scopes.get(name);
		if (result == null)
			throw new IllegalStateException("Cannot get object for " + name);
		return result;
	}
	
	public boolean hasObject(String name) {
		return scopes.get(name) != null;
	}
	
	/**
	 * @since 2.4
	 */
	public String getLineSeparator() {
		return lineSeparator;
	}
	
	ImportManager getImportManager() {
		return importManager;
	}
	
	String getIndentationString() {
		return indentation;
	}

}
