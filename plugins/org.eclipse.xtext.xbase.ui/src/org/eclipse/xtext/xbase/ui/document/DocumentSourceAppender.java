/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.document;

import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.compiler.SourceAppenderBase;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.ui.contentassist.WhitespaceHelper;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DocumentSourceAppender extends SourceAppenderBase {

	public abstract static class Factory<T extends DocumentSourceAppender> {
		
		private static final Logger LOG = Logger.getLogger(Factory.class);
		
		@Inject
		private IWhitespaceInformationProvider whitespaceInformationProvider;
		
		@Inject
		private Provider<WhitespaceHelper> whitespaceHelperProvider;

		@Inject
		private RewritableImportSection.Factory rewritableImportSectionFactory;

		protected abstract T newInstance(IXtextDocument document, RewritableImportSection rewritableImportSection, WhitespaceHelper whitespaceHelper,
				String indentString, String lineSeparator, int baseIndentationLevel); 
		
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
					indentString, lineSeparator, baseIndentationLevel);
			return appendable;
		}
		
		protected String getIndentString(XtextResource resource) {
			return whitespaceInformationProvider.getIndentationInformation(resource.getURI()).getIndentString();
		}
		
		protected int getIndentationLevelAtOffset(int offset, IDocument document, XtextResource resource) {
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
			public boolean ensureEmptyLinesAround;
			public int baseIndentationLevel = -1;
			public RewritableImportSection importSection;
		}
	}
	
	private final IXtextDocument document;
	
	private final WhitespaceHelper whitespaceHelper;

	private final RewritableImportSection importSection;
	
	public DocumentSourceAppender(IXtextDocument document, RewritableImportSection importSection, WhitespaceHelper whitespaceHelper, 
			String indentString, String lineSeparator, int baseIndentationLevel) {
		super(baseIndentationLevel, indentString, lineSeparator, false);
		this.document = document;
		this.importSection = importSection;
		this.whitespaceHelper = whitespaceHelper;
	}
	
	@Override
	protected JvmDeclaredType getImportedType(String simpleName) {
		return importSection.getImportedType(simpleName);
	}

	@Override
	protected boolean addImport(JvmDeclaredType type) {
		return importSection.addImport(type);
	}
	
	@Override
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
		return new ReplaceRegion(whitespaceHelper.getTotalOffset(), whitespaceHelper.getTotalLength(), getCode());
	}

	public int getTotalOffset() {
		return whitespaceHelper.getTotalOffset();
	}
	
	public int getTotalLength() {
		return whitespaceHelper.getTotalLength();
	}
	
	public IXtextDocument getDocument() {
		return document;
	}
	
	public RewritableImportSection getImportSection() {
		return importSection;
	}
}
