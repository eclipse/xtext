/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceSerializer;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractStringBuilderBasedSourceAppender implements ISourceAppender {

	private StringBuilder builder = new StringBuilder(8 * 1024);
	private int indentationlevel = 0;
	private String indentation = "  ";
	private String lineSeparator = "\n";
	private LightweightTypeReferenceSerializer lightweightTypeReferenceSerializer;
	private boolean isJava;

	public AbstractStringBuilderBasedSourceAppender(String indentation, String lineSeparator, boolean isJava) {
		this.indentation = indentation;
		this.lineSeparator = lineSeparator;
		this.lightweightTypeReferenceSerializer = createLightweightTypeReferenceSerializer();
		this.isJava = isJava;
	}

	public AbstractStringBuilderBasedSourceAppender() {
	}
	
	public boolean isJava() {
		return isJava;
	}

	public ISourceAppender append(JvmType type) {
		appendType(type, builder);
		return this;
	}

	/**
	 * Hook for import managers.
	 */
	protected abstract void appendType(JvmType type, StringBuilder builder);

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
		for (int i = 0; i < indentationlevel; i++) {
			sb.append(indentation);
		}
		return sb.toString();
	}
	
	protected int getIndentationLevel() {
		return indentationlevel;
	}

	protected String getLineSeparator() {
		return lineSeparator;
	}
	
	public ISourceAppender increaseIndentation() {
		indentationlevel++;
		return this;
	}

	public ISourceAppender decreaseIndentation() {
		if (indentationlevel == 0)
			throw new IllegalStateException("Can't reduce indentation level. It's already zero.");
		indentationlevel--;
		return this;
	}	

	public int length() {
		return builder.length();
	}
	
	@Override
	public String toString() {
		return builder.toString();
	}
}
