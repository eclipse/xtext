/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.document;

import static com.google.common.collect.Lists.*;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.compiler.AbstractStringBuilderBasedSourceAppender;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.ui.contentassist.WhitespaceHelper;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Allows to create text changes for multiple locations in a document and tracks new import statements. Useful for
 * content proposals, quickfixes, and refactorings that modify more than one section of the document's text.
 * 
 * The individual {@link Section}s allow to modify the document's text with the
 * {@link org.eclipse.xtext.xbase.compiler.IAppendable} API.
 * 
 * The caller must hold a
 * {@link org.eclipse.xtext.ui.editor.model.IXtextDocument#readOnly(org.eclipse.xtext.util.concurrent.IUnitOfWork)} lock
 * during the whole lifecycle of an instance.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DocumentRewriter {

	private static final Logger LOG = Logger.getLogger(DocumentRewriter.class);

	public static class Factory {
		@Inject
		private IIndentationInformation indentInformation;

		@Inject
		private IWhitespaceInformationProvider whitespaceInformationProvider;

		@Inject
		private Provider<WhitespaceHelper> whitespaceHelperProvider;

		@Inject
		private RewritableImportSection.Factory rewritableImportSectionFactory;
		
		public DocumentRewriter create(IDocument document, XtextResource resource) {
			RewritableImportSection importSection = rewritableImportSectionFactory.parse(resource);
			ImportManager importManager = new ImportManager(importSection);
			String indentString = indentInformation.getIndentString();
			String lineSeparator = whitespaceInformationProvider.getLineSeparatorInformation(resource.getURI())
					.getLineSeparator();
			return new DocumentRewriter(document, importManager, indentString, lineSeparator, this);
		}
	}

	protected static class ImportManager {

		private RewritableImportSection importSection;

		public ImportManager(RewritableImportSection importSection) {
			this.importSection = importSection;
			this.importSection.setSort(true);
		}

		public List<ReplaceRegion> getChanges() {
			return importSection.rewrite();
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
				JvmDeclaredType importedType = importSection.getImportedType(simpleName);
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

		protected char getInnerTypeSeparator() {
			return '.';
		}
	}

	public static class Section extends AbstractStringBuilderBasedSourceAppender {

		private WhitespaceHelper whitespaceHelper;

		private DocumentRewriter documentRewriter;

		private int baseIndentationLevel;

		private String indentString;

		protected Section(DocumentRewriter documentEditor, int initialIndentationLevel, String indentString,
				String lineSeparator, WhitespaceHelper whitespaceHelper) {
			super(indentString, lineSeparator, false);
			this.documentRewriter = documentEditor;
			this.baseIndentationLevel = initialIndentationLevel;
			this.whitespaceHelper = whitespaceHelper;
			this.indentString = indentString;
		}

		@Override
		@NonNull
		public String toString() {
			return getCode();
		}

		@NonNull
		public String getCode() {
			StringBuilder builder = new StringBuilder();
			if (whitespaceHelper.getPrefix() != null)
				builder.append(whitespaceHelper.getPrefix().replace(getLineSeparator(), getIndentationString()));
			builder.append(super.toString());
			if (whitespaceHelper.getSuffix() != null)
				builder.append(whitespaceHelper.getSuffix().replace(getLineSeparator(), getIndentationString()));
			return builder.toString();
		}

		public ReplaceRegion getChange() {
			return new ReplaceRegion(whitespaceHelper.getTotalOffset(), whitespaceHelper.getTotalLength(), toString());
		}

		@Override
		protected void appendType(JvmType type, StringBuilder builder) {
			documentRewriter.getImportManager().appendType(type, builder);
		}

		public int getTotalOffset() {
			return whitespaceHelper.getTotalOffset();
		}
		
		public int getTotalLength() {
			return whitespaceHelper.getTotalLength();
		}
		
		public boolean isOverlap(Section other) {
			return getTotalOffset() == other.getTotalOffset() 
					|| (getTotalOffset() < other.getTotalOffset() + other.getTotalLength()
						&& getTotalOffset() + getTotalLength() > other.getTotalOffset());
		}

		public int getBaseIndentationLevel() {
			return baseIndentationLevel;
		}

		public void append(CharSequence content, int indentationDelta) {
			if (indentationDelta < 0)
				append(content.toString().replaceAll(
						Pattern.quote(getLineSeparator() + createIndentString(-indentationDelta)), getLineSeparator()));
			else if (indentationDelta > 0)
				append(content.toString().replaceAll(Pattern.quote(getLineSeparator()),
						getLineSeparator() + createIndentString(indentationDelta)));
			else
				append(content);
		}

		protected String createIndentString(int indentLevel) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < getIndentationLevel(); i++) {
				sb.append(indentString);
			}
			return sb.toString();
		}
	}

	private IDocument document;

	private List<Section> sections;

	private ImportManager importManager;

	private Factory factory;

	private String indentString;

	private String lineSeparator;

	protected DocumentRewriter(IDocument document, ImportManager importManager, String indentString,
			String lineSeparator, Factory factory) {
		this.document = document;
		this.importManager = importManager;
		this.indentString = indentString;
		this.lineSeparator = lineSeparator;
		this.factory = factory;
		sections = newArrayList();
	}

	public IDocument getDocument() {
		return document;
	}

	protected ImportManager getImportManager() {
		return importManager;
	}

	public List<ReplaceRegion> getChanges() {
		List<ReplaceRegion> changes = newArrayList();
		for (Section section : sections) {
			ReplaceRegion change = section.getChange();
			changes.add(change);
		}
		for (ReplaceRegion change : importManager.getChanges()) {
			changes.add(change);
		}
		return changes;
	}

	public Section newSection(int offset, int length) {
		return newSection(offset, length, getIndentationLevelAtOffset(offset, document), false);
	}

	public Section newSection(int offset, int length, boolean ensureEmptyLinesAround) {
		return newSection(offset, length, getIndentationLevelAtOffset(offset, document), ensureEmptyLinesAround);
	}

	public Section newSection(int offset, int length, int indentationLevel, boolean ensureEmptyLinesAround) {
		WhitespaceHelper whitespaceHelper = factory.whitespaceHelperProvider.get();
		whitespaceHelper.initialize(document, offset, length, ensureEmptyLinesAround);
		Section section = new Section(this, indentationLevel, indentString, lineSeparator, whitespaceHelper);
		for (Section otherSection : sections)
			if (section.isOverlap(otherSection))
				throw new IllegalArgumentException("Section overlaps with exisiting section");
		for (int i = 0; i < indentationLevel; ++i)
			section.increaseIndentation();
		sections.add(section);
		return section;
	}

	protected int getIndentationLevelAtOffset(int offset, IDocument document) {
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
			return indentationOffset / factory.indentInformation.getIndentString().length();
		} catch (BadLocationException e) {
			LOG.error("Error calculating indentation at offset", e);
		}
		return 0;
	}
	
	public String getLineSeparator() {
		return lineSeparator;
	}
	
	public String getIndentString() {
		return indentString;
	}
}
