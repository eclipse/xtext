/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.formatting2.internal.CommentReplacer;
import org.eclipse.xtext.formatting2.internal.FormattableDocument;
import org.eclipse.xtext.formatting2.internal.HiddenRegionFormatting;
import org.eclipse.xtext.formatting2.internal.HiddenRegionFormattingMerger;
import org.eclipse.xtext.formatting2.internal.HiddenRegionReplacer;
import org.eclipse.xtext.formatting2.internal.MultilineCommentReplacer;
import org.eclipse.xtext.formatting2.internal.SinglelineCodeCommentReplacer;
import org.eclipse.xtext.formatting2.internal.SinglelineDocCommentReplacer;
import org.eclipse.xtext.formatting2.internal.TextReplacement;
import org.eclipse.xtext.formatting2.internal.TextReplacerContext;
import org.eclipse.xtext.formatting2.internal.TextReplacerMerger;
import org.eclipse.xtext.formatting2.internal.WhitespaceReplacer;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.preferences.TypedPreferenceKey;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * This is an abstract base class for language-specific formatters.
 * 
 * It is the formatters responsibility to create a list of text replacements, which, when applied to a text document,
 * increase the documents readability for humans. At the same time the text changes should not have an impact on the
 * semantic model a parser would create from the document.
 * 
 * Formatters based on this class compute text replacements in two logical steps: First, they traverses the semantic
 * model and collect {@link ITextReplacer}s. Each TextReplacer is responsible for a (small) section of the document. In
 * a second step, the TextReplacers are are executed from the beginning to the end of the document and create the actual
 * text replacements. This decoupling allows it to traverse the semantic model in arbitrary order and yet compute
 * information that requires sequential processing of the document, e.g. indentation.
 *
 * To allow subclasses to implement this mechanism conveniently, there are several helper classes:
 * 
 * <ul>
 * <li>{@link ITextRegionAccess} allows to obtain text regions for elements from the semantic model.</li>
 * <li>{@link ITextReplacer} creates {@link ITextReplacement}s for a specific region in the document.</li>
 * <li>{@link IFormattableDocument} collects {@link ITextReplacer}s and validates if they overlap.</li>
 * </ul>
 * 
 * A formatter based on this class typically uses {@link ITextRegionAccess} to obtain the {@link IHiddenRegion} which
 * precedes or trails EObjects, EStructuralFeatures, Keywords, RuleCalls. This {@link IHiddenRegion} represents the
 * whitespace, newlines and comments between semantic tokens. No matter if there are zero or N hidden tokens between two
 * semantic tokens, there is always exactly one {@link IHiddenRegion}. In other words, the {@link IHiddenRegion} groups
 * all hidden tokens between two semantic tokens.
 * 
 * For the {@link IHiddenRegion}, the formatter will create a {@link ITextReplacer} and store the replacer in the
 * {@link IFormattableDocument}. Typically this is a {@link HiddenRegionReplacer} parameterized with an
 * {@link IHiddenRegionFormatting}. The {@link HiddenRegionReplacer} will then delegate to {@link WhitespaceReplacer} or
 * {@link CommentReplacer}, depending on which kind of tokens are inside the hidden region.
 * 
 * To format a document with syntax confirming to the parser rule
 * 
 * <pre>
 * Entity:
 * 	'entity' name=ValidID '{'
 * 		features+=Feature*
 * 	'}';
 * </pre>
 * 
 * the following formatter implementation (Xtend code) can be used:
 * 
 * <pre>
 * 	def dispatch void format(Entity entity, extension IFormattableDocument document) {
 * 		entity.regionForFeature(ABSTRACT_ELEMENT__NAME).surround[oneSpace]
 * 		entity.regionForKeyword("{").append[newLine; increaseIndentation]
 * 		for (Feature feature : entity.features) {
 * 			format(feature, document);
 * 			feature.append[newLine]
 * 		}
 * 		entity.regionForKeyword("}").prepend[decreaseIndentation]
 * 	}
 * </pre>
 * 
 * For the full example, see the DomainModel Example. It can be accessed via Eclipse -> File -> New -> Example.
 * 
 * The class 'Entity' is part of the semantic model.
 * 
 * The methods 'regionForFeature()' and 'regionForKeyword' are extension methods:
 * {@link ITextRegionAccess#regionForFeature(EObject, EStructuralFeature)} and
 * {@link ITextRegionAccess#regionForKeyword(EObject, String)}. They return an {@link ISemanticRegion}.
 * 
 * The methods 'prepend', 'append' and 'surround' are extension methods from {@link IFormattableDocument}. They create
 * and register an {@link HiddenRegionReplacer} for the {@link IHiddenRegion} before and/or after the provided
 * {@link ISemanticRegion}.
 * 
 * @see org.eclipse.xtext.formatting2 for an introduction to the topic
 * @see IFormatter2 to invoke a formatter
 * 
 * @see #format(Object, IFormattableDocument) - overwrite to implement a formatter
 * @see #initalize(FormatterRequest) - overwrite to set values of member fields
 * @see #reset() - overwrite to cleanup after execution
 * @see "overwrite create*() methods to customize formatter-local services"
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
public abstract class AbstractFormatter2 implements IFormatter2 {

	/**
	 * Offer subclasses access to the methods from {@link ITextRegionAccess} as extension methods.
	 */
	@Extension
	protected ITextRegionAccess regionAccess;

	private FormatterRequest request = null;

	/**
	 * Fall-back for types that are not handled by a subclasse's dispatch method.
	 */
	protected void _format(Object obj, IFormattableDocument document) {
	}

	/**
	 * Fall-back for null-values in a subclasse's dispatch method.
	 */
	protected void _format(Void obj, IFormattableDocument document) {
	}

	/**
	 * For {@link XtextResource}s, assume we want to format the first EObject from the contents list only. Because
	 * that's where the parser puts the semantic model.
	 */
	protected void _format(XtextResource resource, IFormattableDocument document) {
		EList<EObject> contents = resource.getContents();
		if (!contents.isEmpty()) {
			EObject model = contents.get(0);
			format(model, document);
		}
	}

	public ITextReplacer createCommentReplacer(IComment comment) {
		EObject grammarElement = comment.getGrammarElement();
		if (grammarElement instanceof AbstractRule) {
			String ruleName = ((AbstractRule) grammarElement).getName();
			if (ruleName.startsWith("ML"))
				return new MultilineCommentReplacer(comment, '*');
			if (ruleName.startsWith("SL")) {
				if (comment.getIndentation().getLength() > 0)
					return new SinglelineDocCommentReplacer(comment, "//");
				else
					return new SinglelineCodeCommentReplacer(comment, "//");
			}
		}
		String elementName = new GrammarElementTitleSwitch().showQualified().showRule().doSwitch(grammarElement);
		throw new IllegalStateException("No " + ITextReplacer.class.getSimpleName() + " configured for " + elementName);
	}

	public IFormattableDocument createFormattableDocument() {
		return new FormattableDocument.RootDocument(this);
	}

	public IFormattableSubDocument createFormattableSubDocument(ITextSegment region, IFormattableDocument parent) {
		return new FormattableDocument.SubDocument(region, parent);
	}

	public IHiddenRegionFormatting createHiddenRegionFormatting() {
		return new HiddenRegionFormatting(this);
	}

	public IMerger<IHiddenRegionFormatting> createHiddenRegionFormattingMerger() {
		return new HiddenRegionFormattingMerger(this);
	}

	public ITextReplacer createHiddenRegionReplacer(IHiddenRegion region, IHiddenRegionFormatting formatting) {
		return new HiddenRegionReplacer(region, formatting);
	}

	public ITextReplacement createTextReplacement(int offset, int length, String text) {
		return new TextReplacement(getRequest().getTextRegionAccess(), offset, length, text);
	}

	public ITextReplacerContext createTextReplacerContext(IFormattableDocument document) {
		return new TextReplacerContext(document);
	}

	public IMerger<ITextReplacer> createTextReplacerMerger() {
		return new TextReplacerMerger(this);
	}

	public ITextReplacer createWhitespaceReplacer(ITextSegment hiddens, IHiddenRegionFormatting formatting) {
		return new WhitespaceReplacer(hiddens, formatting);
	}

	final public List<ITextReplacement> format(FormatterRequest request) {
		try {
			initalize(request);
			IFormattableDocument document = createFormattableDocument();
			XtextResource xtextResource = request.getTextRegionAccess().getResource();
			format(xtextResource, document);
			List<ITextReplacement> replacements = document.renderToTextReplacements();
			return replacements;
		} finally {
			reset();
		}
	}

	/**
	 * Implement this method to create a language-specific formatter.
	 * 
	 * See the JavaDoc of this class for a more detailed description of what your code should do.
	 * 
	 * @param obj
	 *            An XtextResource or an object for from your semantic model.
	 * @param document
	 *            The document to collect and execute {@link ITextReplacer}s.
	 */
	public abstract void format(Object obj, IFormattableDocument document);

	/**
	 * @return a preference value from {@link FormatterRequest#getPreferences()}
	 */
	public <T> T getPreference(TypedPreferenceKey<T> key) {
		return request.getPreferences().getPreference(key);
	}

	/**
	 * @return the preferences from the {@link FormatterRequest}
	 */
	public ITypedPreferenceValues getPreferences() {
		return request.getPreferences();
	}

	/**
	 * @return the {@link FormatterRequest} that was passed into {@link IFormatter2#format(FormatterRequest)} when
	 *         invoking the formatter.
	 */
	public FormatterRequest getRequest() {
		return request;
	}

	/**
	 * Overwrite this method to initialize member fields before {@link #format(Object, IFormattableDocument)} is called.
	 */
	protected void initalize(FormatterRequest request) {
		this.request = request;
		this.regionAccess = request.getTextRegionAccess();
	}

	/**
	 * Overwrite this method to clean up member fields after {@link #format(Object, IFormattableDocument)} has been
	 * called.
	 */
	protected void reset() {
		this.request = null;
		this.regionAccess = null;
	}

}
