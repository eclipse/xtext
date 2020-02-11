/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.base.Predicate;

/**
 * <p>
 * A FormattableDocument is a stateful object that holds a list of {@link ITextReplacer replacers}. Each replacer is
 * responsible for a text region inside this document. The document can be populated with replacers in any order.
 * However, it is not possible and not intended to register two or more replacers for the same or overlapping
 * {@link ITextSegment region}.
 * </p>
 * 
 * <p>
 * Eventually, all replacers are invoked from the beginning of the document to the end of the document. Each replacer
 * produces {@link ITextReplacement text replacements} for their region. A {@link ITextReplacerContext} is passed on
 * from replacer to replacer and holds state such as the current indentation level.
 * </p>
 * 
 * <p>
 * Besides this, a formattable document
 * </p>
 * <ul>
 * <li>offers convenience API to define formatting for HiddenRegions. See {@link ITextRegionAccess} for a definition of
 * HiddenRegions and {@link IHiddenRegionFormatter} for how they can be formatted.</li>
 * <li>supports conditional formatting. For example, it can try to format a region into the current line and. if that
 * doesn't work, apply an alternative strategy.</li>
 * </ul>
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 2.8
 */
public interface IFormattableDocument {

	/**
	 * Creates a new formattable document to which only replacers can be added for which the provided predicate yields
	 * <code>true</code>.
	 */
	IFormattableDocument withReplacerFilter(Predicate<? super ITextReplacer> filter);

	/**
	 * Returns the region this formattable document is responsible for.
	 */
	ITextSegment getRegion();

	/**
	 * Returns the formatter that is being used.
	 */
	AbstractFormatter2 getFormatter();

	/**
	 * Returns the current formatting request.
	 */
	FormatterRequest getRequest();

	/**
	 * Add a new replacer to the document.
	 */
	void addReplacer(ITextReplacer replacer);

	/**
	 * Render the document.
	 * 
	 * This executes all contained replacers and returns the text replacements created by them.
	 */
	List<ITextReplacement> renderToTextReplacements();

	/**
	 * Create a new {@link IHiddenRegionFormatting}, initialize it, and add it behind the given semanticRegion.
	 * 
	 * Returns the given semantic region.
	 */
	ISemanticRegion append(ISemanticRegion appendAfter, Procedure1<? super IHiddenRegionFormatter> initializer);

	/**
	 * Create a new {@link IHiddenRegionFormatting}, initialize it, and add it behind the given semantic object.
	 * 
	 * Returns the given semantic object.
	 */
	<T extends EObject> T append(T appendAfter, Procedure1<? super IHiddenRegionFormatter> initializer);

	/**
	 * Create a new {@link IHiddenRegionFormatting}, initialize it, and add it before the given semanticRegion.
	 * 
	 * Returns the given semantic region.
	 */
	ISemanticRegion prepend(ISemanticRegion prependBefore, Procedure1<? super IHiddenRegionFormatter> initializer);

	/**
	 * Create a new {@link IHiddenRegionFormatting}, initialize it, and add it before the given semantic object.
	 * 
	 * Returns the given semantic object.
	 */
	<T extends EObject> T prepend(T prependBefore, Procedure1<? super IHiddenRegionFormatter> initializer);

	/**
	 * Create a new {@link IHiddenRegionFormatting}, initialize it, and add it before and after the given semantic
	 * region.
	 * 
	 * Returns the given semantic region.
	 */
	ISemanticRegion surround(ISemanticRegion semanticRegion, Procedure1<? super IHiddenRegionFormatter> beforeAndAfter);

	/**
	 * Create a new {@link IHiddenRegionFormatting}, initialize it, and add it before and after the given semantic
	 * object.
	 * 
	 * Returns the given semantic object.
	 */
	<T extends EObject> T surround(T owner, Procedure1<? super IHiddenRegionFormatter> beforeAndAfter);

	/**
	 * Apply the formatting of the first sub formatter that can successfully format the given owner's region.
	 * 
	 * A sub formatters execution is considered successful if it didn't throw an
	 * {@link FormattingNotApplicableException}.
	 */
	void formatConditionally(EObject owner, ISubFormatter... formatters) throws FormattingNotApplicableException;

	/**
	 * Apply the formatting of the first sub formatter that can successfully format the given region.
	 * 
	 * A sub formatters execution is considered successful if it didn't throw an
	 * {@link FormattingNotApplicableException}.
	 */
	void formatConditionally(int offset, int length, ISubFormatter... formatters)
			throws FormattingNotApplicableException;

	/**
	 * Create a new {@link IHiddenRegionFormatting}, initialize it, and add it for the given hidden region.
	 * 
	 * Returns the given hidden region.
	 */
	IHiddenRegion set(IHiddenRegion hiddenRegion, Procedure1<? super IHiddenRegionFormatter> init);

	Pair<IHiddenRegion, IHiddenRegion> set(IHiddenRegion first, IHiddenRegion second,
			Procedure1<? super IHiddenRegionFormatter> init);

	<T1 extends ISemanticRegion, T2 extends ISemanticRegion> // 
	Pair<T1, T2> interior(T1 first, T2 second, Procedure1<? super IHiddenRegionFormatter> init);

	<T1 extends ISemanticRegion, T2 extends ISemanticRegion> // 
	Pair<T1, T2> interior(Pair<T1, T2> pair, Procedure1<? super IHiddenRegionFormatter> init);

	<T extends EObject> T interior(T object, Procedure1<? super IHiddenRegionFormatter> init);

	<T> T format(T obj);
}
