/*******************************************************************************

 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.List;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceSerializer;

public abstract class AbstractStringBuilderBasedAppendable implements IAppendable {

	private StringBuilder builder = new StringBuilder(8 * 1024);
	private int indentationlevel = 0;
	private String indentation = "  ";
	private String lineSeparator = "\n";
	private boolean isJava;
	private GeneratorConfig generatorConfig;
	
	private LightweightTypeReferenceSerializer lightweightTypeReferenceSerializer;
	
	public AbstractStringBuilderBasedAppendable(String indentation, String lineSeparator, boolean isJava) {
		this.indentation = indentation;
		this.lineSeparator = lineSeparator;
		this.isJava = isJava;
		this.lightweightTypeReferenceSerializer = createLightweightTypeReferenceSerializer();
		openScope();
	}

	public AbstractStringBuilderBasedAppendable(boolean isJava) {
		this.isJava = isJava;
		this.lightweightTypeReferenceSerializer = createLightweightTypeReferenceSerializer();
		openScope();
	}
	
	@Override
	public boolean isJava() {
		return isJava;
	}

	@Override
	public IAppendable append(JvmType type) {
		appendType(type, builder);
		return this;
	}
	
	public IAppendable append(Class<?> type) {
		appendType(type, builder);
		return this;
	}

	@Override
	public IAppendable append(LightweightTypeReference typeRef) {
		typeRef.accept(lightweightTypeReferenceSerializer);
		return this;
	}

	protected LightweightTypeReferenceSerializer createLightweightTypeReferenceSerializer() {
		return new LightweightTypeReferenceSerializer(this);
	}
	
	@Override
	public IAppendable append(CharSequence string) {
		String replaced = string.toString().replace(lineSeparator, getIndentationString());
		builder.append(replaced);
		return this;
	}
	
	@Override
	public IAppendable newLine() {
		builder.append(getIndentationString());
		return this;
	}

	protected CharSequence getIndentationString() {
		StringBuilder sb = new StringBuilder(10);
		sb.append(lineSeparator);
		for (int i = 0; i < indentationlevel; i++) {
			sb.append(indentation);
		}
		return sb.toString();
	}
	
	protected int getIndentationLevel() {
		return indentationlevel;
	}
	
	@Override
	public String toString() {
		return builder.toString();
	}
	
	@Override
	public String getContent() {
		return toString();
	}
	
	@Override
	public int length() {
		return builder.length();
	}

	@Override
	public IAppendable increaseIndentation() {
		indentationlevel++;
		return this;
	}

	@Override
	public IAppendable decreaseIndentation() {
		if (indentationlevel == 0)
			throw new IllegalStateException("Can't reduce indentation level. It's already zero.");
		indentationlevel--;
		return this;
	}

	private ScopeStack scopes = new ScopeStack();
	
	public void setScopeStack(ScopeStack scopes) {
		this.scopes = scopes;
	}

	@Override
	public void openScope() {
		scopes.openScope(false);
	}
	
	@Override
	public void openPseudoScope() {
		scopes.openScope(true);
	}
	
	@Override
	public String declareVariable(Object key, String proposedName) {
		return scopes.declareVariable(key, proposedName, false, false);
	}
	
	@Override
	public String declareSyntheticVariable(Object key, String proposedName) {
		return scopes.declareVariable(key, proposedName, true, false);
	}
	
	@Override
	public String declareUniqueNameVariable(Object key, String proposedName) {
		return scopes.declareVariable(key, proposedName, false, true);
	}
	
	@Override
	public void closeScope() {
		scopes.closeScope();
	}
	
	@Override
	public String removeName(Object key) {
		return scopes.removeName(key);
	}

	protected abstract void appendType(final JvmType type, StringBuilder builder);
	
	protected abstract void appendType(final Class<?> type, StringBuilder builder);
	
	@Override
	@Deprecated
	public abstract List<String> getImports();

	@Override
	public String getName(Object key) {
		String result = scopes.getName(key);
		if (result == null)
			throw new IllegalStateException("Cannot get name for " + key);
		return result;
	}
	
	@Override
	public boolean hasName(Object key) {
		return scopes.getName(key) != null;
	}

	@Override
	public Object getObject(String name) {
		Object result = scopes.get(name);
		if (result == null)
			throw new IllegalStateException("Cannot get object for " + name);
		return result;
	}
	
	@Override
	public boolean hasObject(String name) {
		return scopes.get(name) != null;
	}
	
	protected String getLineSeparator() {
		return lineSeparator;
	}
	
	public char charAt(int index) {
		return builder.charAt(index);
	}
	
	public CharSequence subSequence(int start, int end) {
		return builder.subSequence(start, end);
	}

	@Override
	public GeneratorConfig getGeneratorConfig() {
		return generatorConfig;
	}
	
	public void setGeneratorConfig(GeneratorConfig config) {
		this.generatorConfig = config;
	}
	
}