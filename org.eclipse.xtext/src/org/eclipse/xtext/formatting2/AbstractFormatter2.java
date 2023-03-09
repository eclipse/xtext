/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.internal.CommentReplacer;
import org.eclipse.xtext.formatting2.internal.DoubleHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.internal.HiddenRegionFormatting;
import org.eclipse.xtext.formatting2.internal.HiddenRegionFormattingMerger;
import org.eclipse.xtext.formatting2.internal.HiddenRegionReplacer;
import org.eclipse.xtext.formatting2.internal.MultilineCommentReplacer;
import org.eclipse.xtext.formatting2.internal.RegionTraceMissingException;
import org.eclipse.xtext.formatting2.internal.RootDocument;
import org.eclipse.xtext.formatting2.internal.SingleHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.internal.SinglelineCodeCommentReplacer;
import org.eclipse.xtext.formatting2.internal.SinglelineDocCommentReplacer;
import org.eclipse.xtext.formatting2.internal.SubDocument;
import org.eclipse.xtext.formatting2.internal.TextReplacerContext;
import org.eclipse.xtext.formatting2.internal.TextReplacerMerger;
import org.eclipse.xtext.formatting2.internal.WhitespaceReplacer;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegionPart;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionFinder;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextRegions;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextReplacement;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.preferences.TypedPreferenceKey;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.common.collect.Lists;

/**
 * <p>
 * This is an abstract base class for language-specific formatters.
 * </p>
 * 
 * <p>
 * It is the formatters responsibility to create a list of text replacements, which, when applied to a text document,
 * increase the documents readability for humans. At the same time the text changes should not have an impact on the
 * semantic model a parser would create from the document.
 * </p>
 * 
 * <p>
 * Formatters based on this class compute text replacements in two logical steps: First, they traverses the semantic
 * model and collect {@link ITextReplacer text replaces}. Each replacer is responsible for a (small) section of the
 * document. In a second step, the replacers are executed from the beginning to the end of the document and create the
 * actual {@link TextReplacement text replacements}. This decoupling allows it to traverse the semantic model in
 * arbitrary order and yet compute information that requires sequential processing of the document, e.g. indentation.
 * </p>
 *
 * <p>
 * To allow subclasses to implement this mechanism conveniently, there are several helper classes:
 * </p>
 * 
 * <ul>
 * <li>{@link ITextRegionAccess} allows to obtain text regions for elements in the semantic model.</li>
 * <li>{@link ITextReplacer} creates {@link ITextReplacement replacements} for a specific region in the document.</li>
 * <li>{@link IFormattableDocument} collects {@link ITextReplacer replacers} and validates if they overlap.</li>
 * </ul>
 * 
 * <p>
 * A formatter based on this class typically uses the {@link ITextRegionAccess} to obtain the {@link IHiddenRegion}
 * which precedes or trails {@link EObject semantic object}, {@link EStructuralFeature features}, {@link Keyword
 * keywords}, or {@link RuleCall rule calls}. This {@link IHiddenRegion} represents the whitespace, newlines and
 * comments between semantic tokens. No matter if there are zero or N hidden tokens between two semantic tokens, there
 * is always exactly one {@link IHiddenRegion}. In other words, the {@link IHiddenRegion} groups all hidden tokens
 * between two semantic tokens.
 * </p>
 * 
 * <p>
 * For the {@link IHiddenRegion}, the formatter will create a {@link ITextReplacer} and store the replacer in the
 * {@link IFormattableDocument}. Typically this is a {@link HiddenRegionReplacer} parameterized with an
 * {@link IHiddenRegionFormatting}. The {@link HiddenRegionReplacer} will then delegate to a {@link WhitespaceReplacer}
 * or {@link CommentReplacer}, depending on which kind of tokens are inside the hidden region.
 * </p>
 * 
 * <p>
 * To format a document with syntax confirming to the parser rule:
 * </p>
 * 
 * <pre>
 * Entity:
 * 	'entity' name=ValidID '{'
 * 		features+=Feature*
 * 	'}';
 * </pre>
 * 
 * <p>
 * the following formatter implementation (Xtend code) can be used:
 * </p>
 * 
 * <pre>
	def dispatch void format(Entity entity, extension IFormattableDocument document) {
		val open = entity.regionFor.keyword("{")
		val close = entity.regionFor.keyword("}")
		entity.regionFor.feature(ABSTRACT_ELEMENT__NAME).surround[oneSpace]
		entity.superType.surround[oneSpace]
		open.append[newLine]
		interior(open, close)[indent]
		format(entity.getSuperType(), document);
		for (Feature feature : entity.features) {
			feature.format
			feature.append[setNewLines(1, 1, 2)]
		}
	}
 * </pre>
 * 
 * <p>
 * For the full example, see the DomainModel Example. It can be accessed via {@code Eclipse -> File -> New -> Example.}
 * </p>
 * 
 * <p>
 * The class {@code Entity} is part of the semantic model.
 * </p>
 * 
 * <p>
 * The method calls {@code regionFor.feature()} and {@code regionFor.keyword()} are using extension methods: {@link
 * ITextRegionExtensions#regionFor(EObject)} and {@link
 * ISemanticRegionFinder#keyword(String)} respectively {@link ISemanticRegionFinder#feature(EStructuralFeature)}. They return an {@link ISemanticRegion}.
 * </p>
 * 
 * <p>
 * The methods {@code prepend()}, {@code append()} and {@code surround()} are extension methods from
 * {@link IFormattableDocument}. They create and register an {@link HiddenRegionReplacer} for the {@link IHiddenRegion}
 * before and/or after the provided {@link ISemanticRegion}.
 * </p>
 *
 * <p>
 * Override {@code create*()} methods to customize formatter-local services.
 * </p>
 * 
 * <p>
 * This implementation is stateful and cannot be used in parallel.
 * </p>
 * 
 * @see org.eclipse.xtext.formatting2 The package {@code org.eclipse.xtext.formatting2} for an introduction to the topic
 * @see IFormatter2 {@code IFormatter2}: the interface to invoke the formatter
 * 
 * @see #format(Object, IFormattableDocument) The method {@code format(Object, IFormattableDocument)} should be
 *      overridden to implement a formatter
 * @see #initialize(FormatterRequest) The method {@code initialize(FormatterRequest)} should be overridden to set values
 *      of member fields
 * @see #reset() The method {@code reset()} should be overridden to cleanup after execution.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
public abstract class AbstractFormatter2 implements IFormatter2 {

	private FormatterRequest request = null;

	/**
	 * Offer subclasses access to the methods from {@link ITextRegionAccess} as extension methods.
	 */
	@Extension
	protected ITextRegionExtensions textRegionExtensions;

	/**
	 * Fall-back for types that are not handled by a subclasse's dispatch method.
	 */
	protected void _format(Object obj, IFormattableDocument document) {
	}

	/**
	 * Fall-back for types that are not handled by a subclasse's dispatch method.
	 */
	protected void _format(EObject obj, IFormattableDocument document) {
		for (EObject child : obj.eContents())
			document.format(child);
	}

	/**
	 * Fall-back for subclasses that accidently try to dispatch over null values.
	 */
	protected void _format(Void obj, IFormattableDocument document) {
	}

	/**
	 * For {@link XtextResource resources}, assume we want to format the first EObject from the contents list only.
	 * Because that's where the parser puts the semantic model.
	 */
	protected void _format(XtextResource resource, IFormattableDocument document) {
		List<EObject> contents = resource.getContents();
		if (!contents.isEmpty()) {
			EObject model = contents.get(0);
			document.format(model);
		}
	}

	public ITextReplacer createCommentReplacer(IComment comment) {
		EObject grammarElement = comment.getGrammarElement();
		if (grammarElement instanceof AbstractRule) {
			String ruleName = ((AbstractRule) grammarElement).getName();
			if (ruleName.startsWith("ML"))
				return new MultilineCommentReplacer(comment, '*');
			if (ruleName.startsWith("SL")) {
				if (comment.getLineRegions().get(0).getIndentation().getLength() > 0)
					return new SinglelineDocCommentReplacer(comment, "//");
				else
					return new SinglelineCodeCommentReplacer(comment, "//");
			}
		}
		String elementName = new GrammarElementTitleSwitch().showQualified().showRule().doSwitch(grammarElement);
		throw new IllegalStateException("No " + ITextReplacer.class.getSimpleName() + " configured for " + elementName);
	}

	public IFormattableDocument createFormattableRootDocument() {
		return new RootDocument(this);
	}

	public IFormattableSubDocument createFormattableSubDocument(ITextSegment region, IFormattableDocument parent) {
		return new SubDocument(region, parent);
	}

	public IHiddenRegionFormatter createHiddenRegionFormatter(IHiddenRegionFormatting formatting) {
		return new SingleHiddenRegionFormatter(formatting);
	}

	public IHiddenRegionFormatter createHiddenRegionFormatter(IHiddenRegionFormatting f1, IHiddenRegionFormatting f2) {
		return new DoubleHiddenRegionFormatter(f1, f2);
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

	public ITextReplacerContext createTextReplacerContext(IFormattableDocument document) {
		return new TextReplacerContext(document);
	}

	public IMerger<ITextReplacer> createTextReplacerMerger() {
		return new TextReplacerMerger(this);
	}

	public ITextReplacer createWhitespaceReplacer(ITextSegment hiddens, IHiddenRegionFormatting formatting) {
		return new WhitespaceReplacer(hiddens, formatting);
	}

	@Override
	public final List<ITextReplacement> format(FormatterRequest request) {
		try {
			initialize(request);
			XtextResource xtextResource = request.getTextRegionAccess().getResource();
			IFormattableDocument document = createFormattableRootDocument();
			try {
				format(xtextResource, document);
			} catch (RegionTraceMissingException e) {
				document = handleTraceMissing(document, e);
			}
			List<ITextReplacement> rendered = document.renderToTextReplacements();
			List<ITextReplacement> postprocessed = postProcess(document, rendered);
			return postprocessed;
		} finally {
			reset();
		}
	}

	protected IFormattableDocument handleTraceMissing(IFormattableDocument problematic, RegionTraceMissingException e) {
		if (request.isEnableDebugTracing()) {
			return problematic;
		}
		request.setEnableDebugTracing(true);
		XtextResource xtextResource = request.getTextRegionAccess().getResource();
		IFormattableDocument document = createFormattableRootDocument();
		format(xtextResource, document);
		return document;
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

	public ITextRegionAccess getTextRegionAccess() {
		return request.getTextRegionAccess();
	}

	/**
	 * This method is deprecated, use #initialize(FormatterRequest) instead
	 */
	@Deprecated
	protected void initalize(FormatterRequest request) {
		initialize(request);
	}
	
	/**
	 * Overwrite this method to initialize member fields before {@link #format(Object, IFormattableDocument)} is called.
	 */
	protected void initialize(FormatterRequest request) {
		this.request = request;
		this.textRegionExtensions = request.getTextRegionAccess().getExtensions();
	}

	protected boolean isInRequestedRange(EObject obj) {
		Collection<ITextRegion> regions = request.getRegions();
		if (regions.isEmpty())
			return true;
		ITextRegionAccess access = request.getTextRegionAccess();
		IEObjectRegion objRegion = access.regionForEObject(obj);
		if (objRegion == null)
			return false;
		IHiddenRegion previousHidden = objRegion.getPreviousHiddenRegion();
		IHiddenRegion nextHidden = objRegion.getNextHiddenRegion();
		int objOffset = previousHidden != null ? previousHidden.getOffset() : 0;
		int objEnd = nextHidden != null ? nextHidden.getEndOffset() : access.regionForRootEObject().getEndOffset();
		for (ITextRegion region : regions) {
			int regionOffset = region.getOffset();
			int regionEnd = regionOffset + region.getLength();
			if (regionOffset <= objEnd && regionEnd >= objOffset)
				return true;
		}
		return false;
	}

	private boolean isInRequestedRange(int offset, int endOffset) {
		Collection<ITextRegion> regions = request.getRegions();
		if (regions.isEmpty())
			return true;
		for (org.eclipse.xtext.util.ITextRegion region : regions)
			if (region.getOffset() <= offset && region.getOffset() + region.getLength() >= endOffset)
				return true;
		return false;
	}

	protected List<ITextReplacement> postProcess(IFormattableDocument document, List<ITextReplacement> replacements) {
		List<ITextSegment> expected = Lists.newArrayList();
		IHiddenRegion current = getTextRegionAccess().regionForRootEObject().getPreviousHiddenRegion();
		while (current != null) {
			if (current.isUndefined() && isInRequestedRange(current.getOffset(), current.getEndOffset()))
				expected.addAll(current.getMergedSpaces());
			current = current.getNextHiddenRegion();
		}
		if (expected.isEmpty())
			return replacements;
		List<ITextSegment> missing = TextRegions.difference(expected, replacements);
		if (missing.isEmpty())
			return replacements;
		List<ITextReplacement> result = Lists.newArrayList(replacements);
		for (ITextSegment seg : missing) {
			IHiddenRegion h = null;
			if (seg instanceof IHiddenRegion)
				h = (IHiddenRegion) seg;
			if (seg instanceof IHiddenRegionPart)
				h = ((IHiddenRegionPart) seg).getHiddenRegion();
			if (h != null && (h.getNextSemanticRegion() == null || h.getPreviousSemanticRegion() == null))
				result.add(seg.replaceWith(""));
			else
				result.add(seg.replaceWith(" "));
		}
		return result;
	}

	/**
	 * Overwrite this method to clean up member fields after {@link #format(Object, IFormattableDocument)} has been
	 * called.
	 */
	protected void reset() {
		this.request = null;
		this.textRegionExtensions = null;
	}

	public boolean shouldFormat(Object obj, IFormattableDocument document) {
		if (obj instanceof EObject)
			return isInRequestedRange((EObject) obj);
		return true;
	}

}
