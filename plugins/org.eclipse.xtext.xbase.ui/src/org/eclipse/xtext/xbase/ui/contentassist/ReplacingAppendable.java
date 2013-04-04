/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.contentassist;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.compiler.AbstractStringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.ui.imports.ReplaceConverter;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * An {@link org.eclipse.xtext.xbase.compiler.IAppendable} to insert text into an Xtend document. Takes imports and
 * existing variable names into account.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReplacingAppendable extends AbstractStringBuilderBasedAppendable {

	private static final Logger LOG = Logger.getLogger(ReplacingAppendable.class);

	public static class Factory {

		@Inject
		private IJvmModelAssociations associations;

		@Inject
		private IIndentationInformation indentInformation;
		
		@Inject
		private IWhitespaceInformationProvider whitespaceInformationProvider;
		
		@Inject
		private Provider<WhitespaceHelper> whitespaceHelperProvider;

		@Inject
		private RewritableImportSection.Factory rewritableImportSectionFactory;
		
		@Inject
		private ReplaceConverter replaceConverter;
		
		public ReplacingAppendable get(IXtextDocument document, EObject context, int offset, int length) {
			return get(document, context, offset, length, getIndentationLevelAtOffset(offset, document), false);
		}

		public ReplacingAppendable get(IXtextDocument document, EObject context, int offset, int length,
				int indentationLevel, boolean ensureEmptyLinesAround) {
			try {
				XtextResource resource = (XtextResource) context.eResource();
				String indentString = indentInformation.getIndentString();
				String lineSeparator = whitespaceInformationProvider.getLineSeparatorInformation(resource.getURI()).getLineSeparator();
				RewritableImportSection rewritableImportSection = rewritableImportSectionFactory.parse(resource);
				WhitespaceHelper whitespaceHelper = whitespaceHelperProvider.get();
				whitespaceHelper.initialize(document, offset, length, ensureEmptyLinesAround);
				ReplacingAppendable appendable = new ReplacingAppendable(rewritableImportSection,
						lineSeparator, indentString, document, whitespaceHelper, replaceConverter);
				for (int i = 0; i < indentationLevel; ++i)
					appendable.increaseIndentation();
				return appendable;
			} catch (Exception exc) {
				LOG.error("Error initializing appendable", exc);
			}
			return null;
		}

		protected EObject getLocalVariableScopeContext(EObject context) {
			Set<EObject> jvmElements = associations.getJvmElements(context);
			if(jvmElements.isEmpty())
				return null;
			else 
				return jvmElements.iterator().next();
		}

		protected int getIndentationLevelAtOffset(int offset, IDocument document) {
			try {
				if (offset <= 0)
					return 0;
				int currentOffset = offset - 1;
				char currentChr = document.getChar(currentOffset);
				int indentationOffset = 0;
				while (currentChr != '\n' && currentChr != '\r' && currentOffset > 0) {
					if (Character.isWhitespace(currentChr))
						++indentationOffset;
					else
						indentationOffset = 0;
					--currentOffset;
					currentChr = document.getChar(currentOffset);
				}
				return indentationOffset / indentInformation.getIndentString().length();
			} catch (BadLocationException e) {
				LOG.error("Error calculating indentation at offset", e);
			}
			return 0;
		}
	}

	private IXtextDocument document;

	private final WhitespaceHelper whitespaceHelper;

	private RewritableImportSection importSection;

	private ReplaceConverter replaceConverter;
	
	public ReplacingAppendable(RewritableImportSection importSection, String lineSeparator, String indentString, IXtextDocument document,
			WhitespaceHelper whitespaceHelper, ReplaceConverter replaceConverter) {
		super(indentString, lineSeparator);
		this.importSection = importSection;
		this.document = document;
		this.whitespaceHelper = whitespaceHelper;
		this.replaceConverter = replaceConverter;
	}
	
	@Override
	@NonNull
	public String toString() {
		return getCode();
	}
	
	public int getTotalOffset() {
		return whitespaceHelper.getTotalOffset();
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

	public void commitChanges() throws BadLocationException {
		document.replace(whitespaceHelper.getTotalOffset(), whitespaceHelper.getTotalLength(), toString());
		insertNewImports();
	}
	
	public int commitChanges(int offset, int length) throws BadLocationException {
		int actualOffset = Math.min(whitespaceHelper.getTotalOffset(), offset);
		int endOffset = Math.max(whitespaceHelper.getTotalOffset() + whitespaceHelper.getTotalLength(), offset + length);
		int actualLength = endOffset - actualOffset;
		document.replace(actualOffset, actualLength, toString());
		int shiftCursorBy = insertNewImports();
		return shiftCursorBy;
	}

	public int insertNewImports() throws BadLocationException {
		List<ReplaceRegion> importChanges = importSection.rewrite();
		int lengthDelta = 0;
		if(!importChanges.isEmpty()) {
			for(ReplaceRegion change: importChanges) {
				lengthDelta = lengthDelta - change.getLength() + change.getText().length(); 
			}
			replaceConverter.convertToTextEdit(importChanges).apply(document);
		}
		return lengthDelta;
	}

	@Override
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
			if(importedType == type) {
				builder.append(simpleName);
			} else if(importedType == null) {
				importSection.addImport((JvmDeclaredType) type);
				builder.append(simpleName);
			} else {
				builder.append(qualifiedName);
			}
		}
	}

	protected char getInnerTypeSeparator() {
		return '$';
	}

	@Override
	public @NonNull List<String> getImports() {
		throw new UnsupportedOperationException("getImports() not implemented for ReplacingAppendable");
	}
	
	public RewritableImportSection getImportSection() {
		return importSection;
	}
}
