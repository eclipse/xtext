/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.regex.Pattern;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceSerializer;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SourceAppenderBase implements ISourceAppender {

	private int baseIndentationLevel = 0;
	private String indentation = "  ";
	private String lineSeparator = "\n";
	private LightweightTypeReferenceSerializer lightweightTypeReferenceSerializer;
	private boolean isJava;

	private StringBuilder builder = new StringBuilder(8 * 1024);
	private int indentationLevel = 0;

	public SourceAppenderBase(int baseIndentationLevel, String indentation, String lineSeparator, boolean isJava) {
		this.indentation = indentation;
		this.baseIndentationLevel = baseIndentationLevel;
		this.indentationLevel = baseIndentationLevel;
		this.lineSeparator = lineSeparator;
		this.lightweightTypeReferenceSerializer = createLightweightTypeReferenceSerializer();
		this.isJava = isJava;
	}

	public boolean isJava() {
		return isJava;
	}

	public ISourceAppender append(JvmType type) {
		appendType(type, builder);
		return this;
	}

	public void appendType(final @NonNull JvmType type, @NonNull StringBuilder builder) {
		if (type instanceof JvmPrimitiveType || type instanceof JvmVoid || type instanceof JvmTypeParameter) {
			builder.append(type.getQualifiedName(getInnerTypeSeparator()));
		} else if (type instanceof JvmArrayType) {
			appendType(((JvmArrayType) type).getComponentType(), builder);
			builder.append("[]");
		} else {
			final String qualifiedName = type.getQualifiedName(getInnerTypeSeparator());
			final String simpleName = type.getSimpleName();
			JvmDeclaredType importedType = getImportedType(simpleName);
			if (importedType == type) {
				builder.append(simpleName);
			} else if (importedType == null) {
				addImport((JvmDeclaredType) type);
				builder.append(simpleName);
			} else {
				builder.append(qualifiedName);
			}
		}
	}
	
	/**
	 * Hook for import manager
	 * 
	 * @param simpleName unused
	 */
	protected JvmDeclaredType getImportedType(String simpleName) {
		return null;
	}
	
	/**
	 * Hook for import manager
	 * 
	 * @param type unused
	 */
	protected boolean addImport(JvmDeclaredType type) {
		return false;
	}

	protected char getInnerTypeSeparator() {
		return '.';
	}

	public ISourceAppender append(LightweightTypeReference typeRef) {
		typeRef.accept(lightweightTypeReferenceSerializer);
		return this;
	}

	protected LightweightTypeReferenceSerializer createLightweightTypeReferenceSerializer() {
		return new LightweightTypeReferenceSerializer(this);
	}
	
	public ISourceAppender append(CharSequence string) {
		String replaced = string.toString().replace(lineSeparator, getIndentationString());
		builder.append(replaced);
		return this;
	}
	
	public ISourceAppender newLine() {
		builder.append(getIndentationString());
		return this;
	}

	protected CharSequence getIndentationString() {
		StringBuilder sb = new StringBuilder(10);
		sb.append(lineSeparator);
		for (int i = 0; i < indentationLevel; i++) {
			sb.append(indentation);
		}
		return sb.toString();
	}
	
	protected int getIndentationLevel() {
		return indentationLevel;
	}

	protected String getLineSeparator() {
		return lineSeparator;
	}
	
	public ISourceAppender increaseIndentation() {
		indentationLevel++;
		return this;
	}

	public ISourceAppender decreaseIndentation() {
		if (indentationLevel == 0)
			throw new IllegalStateException("Can't reduce indentation level. It's already zero.");
		indentationLevel--;
		return this;
	}	

	public int length() {
		return builder.length();
	}
	
	@Override
	@NonNull
	public String toString() {
		return builder.toString();
	}

	protected String getCode() {
		return builder.toString();
	}

	public int getBaseIndentationLevel() {
		return baseIndentationLevel;
	}

	public void append(CharSequence content, int indentationDelta) {
		if (indentationDelta < 0)
			append(content.toString().replaceAll(
					Pattern.quote(getLineSeparator() + indentString(-indentationDelta)), getLineSeparator()));
		else if (indentationDelta > 0)
			append(content.toString().replaceAll(Pattern.quote(getLineSeparator()),
					getLineSeparator() + indentString(indentationDelta)));
		else
			append(content);
	}

	protected String indentString(int indentLevel) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < indentLevel; i++) {
			sb.append(indentation);
		}
		return sb.toString();
	}

}
