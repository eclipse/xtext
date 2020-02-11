/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.document;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.ui.contentassist.WhitespaceHelper;
import org.eclipse.xtext.xbase.ui.document.DocumentSourceAppender.Factory.OptionalParameters;

import com.google.inject.Inject;

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

	public static class Factory {
		@Inject
		private IWhitespaceInformationProvider whitespaceInformationProvider;

		@Inject
		private RewritableImportSection.Factory rewritableImportSectionFactory;

		@Inject
		private DocumentRewriter.Section.Factory sectionFactory;
		
		public DocumentRewriter create(IXtextDocument document, XtextResource resource) {
			return new DocumentRewriter(document, resource, this);
		}
	}

	public static class Section extends DocumentSourceAppender {

		static class Factory extends DocumentSourceAppender.Factory<Section> {
			@Override
			protected Section newInstance(IXtextDocument document, RewritableImportSection importSection,  
					WhitespaceHelper whitespaceHelper,
					String indentString, String lineSeparator, int baseIndentationLevel, boolean isJava) {
				return new Section(document, importSection, whitespaceHelper, indentString, lineSeparator, baseIndentationLevel, isJava);
			}
		}
		
		public Section(IXtextDocument document, RewritableImportSection importSection, WhitespaceHelper whitespaceHelper, String indentString,
				String lineSeparator, int baseIndentationLevel, boolean isJava) {
			super(document, importSection, whitespaceHelper, indentString, lineSeparator, baseIndentationLevel, isJava);
		}

		public boolean isOverlap(Section other) {
			return getTotalOffset() == other.getTotalOffset() 
					|| (getTotalOffset() < other.getTotalOffset() + other.getTotalLength()
						&& getTotalOffset() + getTotalLength() > other.getTotalOffset());
		}

	}

	private IXtextDocument document;

	private XtextResource resource;
	
	private List<Section> sections;

	private RewritableImportSection importSection;

	private Factory factory;
	
	private String indentString;

	private String lineSeparator;
	
	protected DocumentRewriter(IXtextDocument document, XtextResource resource, Factory factory) {
		this.document = document;
		this.resource = resource;
		this.importSection = factory.rewritableImportSectionFactory.parse(resource);
		importSection.setSort(true);
		this.indentString = factory.whitespaceInformationProvider.getIndentationInformation(resource.getURI()).getIndentString();
		this.lineSeparator = factory.whitespaceInformationProvider.getLineSeparatorInformation(resource.getURI())
				.getLineSeparator();
		this.factory = factory;
		sections = newArrayList();
	}

	public IXtextDocument getDocument() {
		return document;
	}

	protected RewritableImportSection getImportSection() {
		return importSection;
	}

	public List<ReplaceRegion> getChanges() {
		List<ReplaceRegion> changes = newArrayList();
		for (Section section : sections) {
			ReplaceRegion change = section.getChange();
			changes.add(change);
		}
		for (ReplaceRegion change : importSection.rewrite()) {
			changes.add(change);
		}
		return changes;
	}

	public Section newSection(int offset, int length) {
		OptionalParameters parameters = createOptionalParameters();
		Section section = factory.sectionFactory.create(document, resource, offset, length, parameters);
		addSection(section);
		return section;
	}

	public Section newSection(int offset, int length, boolean ensureEmptyLinesAround) {
		OptionalParameters parameters = createOptionalParameters();
		parameters.ensureEmptyLinesAround = ensureEmptyLinesAround;
		Section section = factory.sectionFactory.create(document, resource, offset, length, parameters);
		addSection(section);
		return section;
	}

	public Section newSection(int offset, int length, int baseIndentationLevel, boolean ensureEmptyLinesAround) {
		OptionalParameters parameters = createOptionalParameters();
		parameters.ensureEmptyLinesAround = ensureEmptyLinesAround;
		parameters.baseIndentationLevel = baseIndentationLevel;
		Section section = factory.sectionFactory.create(document, resource, offset, length, parameters);
		addSection(section);
		return section;
	}
	
	protected OptionalParameters createOptionalParameters() {
		OptionalParameters parameters = new OptionalParameters();
		parameters.importSection = importSection;
		return parameters;
	}
	
	protected void addSection(Section newSection) {
		for (Section otherSection : sections) {
			if (newSection.isOverlap(otherSection))
				throw new IllegalArgumentException("Section overlaps with exisiting section");				
		}
		sections.add(newSection);
	}

	public String getLineSeparator() {
		return lineSeparator;
	}
	
	public String getIndentString() {
		return indentString;
	}
}
