/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.document;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceSerializer;
import org.eclipse.xtext.xbase.ui.contentassist.WhitespaceHelper;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DocumentSourceAppender implements ISourceAppender {

	public abstract static class Factory<T extends DocumentSourceAppender> {
		
		private static final Logger LOG = Logger.getLogger(Factory.class);
		
		@Inject
		private IWhitespaceInformationProvider whitespaceInformationProvider;
		
		@Inject
		private Provider<WhitespaceHelper> whitespaceHelperProvider;

		@Inject
		private RewritableImportSection.Factory rewritableImportSectionFactory;

		protected abstract T newInstance(IXtextDocument document, RewritableImportSection rewritableImportSection, WhitespaceHelper whitespaceHelper,
				String indentString, String lineSeparator, int baseIndentationLevel, boolean isJava); 
		
		public T create(IXtextDocument document, XtextResource resource, int offset, int length) {
			return create(document, resource, offset, length, new OptionalParameters());
		}
		
		public T create(IXtextDocument document, XtextResource resource, int offset, int length, OptionalParameters params) {
			int baseIndentationLevel = (params.baseIndentationLevel != -1) ? params.baseIndentationLevel : getIndentationLevelAtOffset(offset, document, resource);
			RewritableImportSection importSection = (params.importSection != null) ? params.importSection : rewritableImportSectionFactory.parse(resource);
			String indentString = getIndentString(resource);
			String lineSeparator = whitespaceInformationProvider.getLineSeparatorInformation(resource.getURI()).getLineSeparator();
			WhitespaceHelper whitespaceHelper = whitespaceHelperProvider.get();
			whitespaceHelper.initialize(document, offset, length, params.ensureEmptyLinesAround);
			T appendable = newInstance(document, importSection, whitespaceHelper,
					indentString, lineSeparator, baseIndentationLevel, params.isJava);
			return appendable;
		}
		
		protected String getIndentString(XtextResource resource) {
			return whitespaceInformationProvider.getIndentationInformation(resource.getURI()).getIndentString();
		}
		
		public int getIndentationLevelAtOffset(int offset, IDocument document, XtextResource resource) {
			try {
				if (offset <= 0)
					return 0;
				int currentOffset = offset - 1;
				char currentChr = document.getChar(currentOffset);
				int indentationOffset = 0;
				if(currentChr == '\n' || currentChr == '\r') {
					-- currentOffset;
					if(currentOffset < 0)
						return 0;
					currentChr = document.getChar(currentOffset);
				}
				while (currentChr != '\n' && currentChr != '\r' && currentOffset > 0) {
					if (Character.isWhitespace(currentChr))
						++indentationOffset;
					else
						indentationOffset = 0;
					--currentOffset;
					currentChr = document.getChar(currentOffset);
				}
				return indentationOffset / getIndentString(resource).length();
			} catch (BadLocationException e) {
				LOG.error("Error calculating indentation at offset", e);
			}
			return 0;
		}
		
		public static class OptionalParameters {
			public boolean isJava;
			public boolean ensureEmptyLinesAround;
			public int baseIndentationLevel = -1;
			public RewritableImportSection importSection;
		}
	}
	
	
	private int baseIndentLevel = 0;

	private String indentString = "  ";
	
	private String lineSeparator = "\n";
	
	private LightweightTypeReferenceSerializer lightweightTypeReferenceSerializer;
	
	private boolean isJava;

	private StringBuilder builder = new StringBuilder(8 * 1024);
	
	private int currentIndentLevel = 0;

	private final IXtextDocument document;
	
	private final WhitespaceHelper whitespaceHelper;

	private final RewritableImportSection importSection;
	
	public DocumentSourceAppender(IXtextDocument document, RewritableImportSection importSection, WhitespaceHelper whitespaceHelper, 
			String indentString, String lineSeparator, int baseIndentationLevel, boolean isJava) {
		this.baseIndentLevel = baseIndentationLevel;
		this.indentString = indentString;
		this.currentIndentLevel = baseIndentationLevel;
		this.lineSeparator = lineSeparator;
		this.lightweightTypeReferenceSerializer = createLightweightTypeReferenceSerializer();
		this.isJava = isJava;
		this.document = document;
		this.importSection = importSection;
		this.whitespaceHelper = whitespaceHelper;
	}
	
	protected LightweightTypeReferenceSerializer createLightweightTypeReferenceSerializer() {
		return new LightweightTypeReferenceSerializer(this);
	}

	public int getBaseIndentLevel() {
		return baseIndentLevel;
	}

	protected int getCurrentIndentLevel() {
		return currentIndentLevel;
	}

	protected CharSequence getIndentationString() {
		StringBuilder sb = new StringBuilder(10);
		sb.append(lineSeparator);
		for (int i = 0; i < currentIndentLevel; i++) {
			sb.append(indentString);
		}
		return sb.toString();
	}

	protected String getLineSeparator() {
		return lineSeparator;
	}

	public boolean isJava() {
		return isJava;
	}

	public IXtextDocument getDocument() {
		return document;
	}

	public RewritableImportSection getImportSection() {
		return importSection;
	}

	public ISourceAppender append(JvmType type) {
		appendType(type, builder);
		return this;
	}

	public void appendType(final /* @NonNull */ JvmType type, /* @NonNull */ StringBuilder builder) {
		if (type instanceof JvmPrimitiveType || type instanceof JvmVoid || type instanceof JvmTypeParameter) {
			builder.append(type.getQualifiedName(getInnerTypeSeparator()));
		} else if (type instanceof JvmArrayType) {
			appendType(((JvmArrayType) type).getComponentType(), builder);
			builder.append("[]");
		} else {
			final String qualifiedName = type.getQualifiedName(getInnerTypeSeparator());
			final String simpleName = type.getSimpleName();
			JvmDeclaredType importedType = getImportedType(type);
			if (importedType == type) {
				builder.append(simpleName);
			} else if (importedType == null) {
				importSection.addImport((JvmDeclaredType) type);
				builder.append(simpleName);
			} else {
				builder.append(qualifiedName);
			}
		}
	}

	protected JvmDeclaredType getImportedType(JvmType type) {
		List<JvmDeclaredType> importedTypes = importSection.getImportedTypes(type.getSimpleName());
		if (importedTypes == null) {
			return null;
		}
		for (JvmDeclaredType importedType : importedTypes) {
			if (importedType == type) {
				return importedType;
			}
		}
		return IterableExtensions.last(importedTypes);
	}
	
	protected char getInnerTypeSeparator() {
		return '.';
	}

	public ISourceAppender append(LightweightTypeReference typeRef) {
		typeRef.accept(lightweightTypeReferenceSerializer);
		return this;
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
			sb.append(indentString);
		}
		return sb.toString();
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

	public ISourceAppender increaseIndentation() {
		currentIndentLevel++;
		return this;
	}

	public ISourceAppender decreaseIndentation() {
		if (currentIndentLevel == 0)
			throw new IllegalStateException("Can't reduce indentation level. It's already zero.");
		currentIndentLevel--;
		return this;
	}	

	public int length() {
		return builder.length();
	}
	
	@Override
	/* @NonNull */
	public String toString() {
		return builder.toString();
	}

	/* @NonNull */
	public String getCode() {
		StringBuilder builder = new StringBuilder();
		if (whitespaceHelper.getPrefix() != null)
			builder.append(whitespaceHelper.getPrefix().replace(getLineSeparator(), getIndentationString()));
		builder.append(toString());
		if (whitespaceHelper.getSuffix() != null)
			builder.append(whitespaceHelper.getSuffix().replace(getLineSeparator(), getIndentationString()));
		return builder.toString();
	}

	public ReplaceRegion getChange() {
		return new ReplaceRegion(whitespaceHelper.getTotalOffset(), whitespaceHelper.getTotalLength(), getCode());
	}

	public ReplaceRegion getChange(int offset, int length) {
		int actualOffset = Math.min(whitespaceHelper.getTotalOffset(), offset);
		int endOffset = Math.max(whitespaceHelper.getTotalOffset() + whitespaceHelper.getTotalLength(), offset + length);
		return new ReplaceRegion(actualOffset, endOffset - actualOffset, getCode());
	}

	public int getTotalOffset() {
		return whitespaceHelper.getTotalOffset();
	}

	public int getTotalLength() {
		return whitespaceHelper.getTotalLength();
	}
}
