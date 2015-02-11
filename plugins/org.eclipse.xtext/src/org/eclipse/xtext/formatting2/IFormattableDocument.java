/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
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
	 * Creates a delegate that allows to filter subsequent replacers based on the
	 * given condition. Replacers are used if the predicate yields <code>true</code>.
	 */
	IFormattableDocument withReplacerFilter(Predicate<? super ITextReplacer> filter);

	/**
	 * Returns the region that is formatted. 
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
	 */
	List<ITextReplacement> renderToTextReplacements();

	/**
	 * Append the given semantic region and obtain the formatting information for trailing
	 * whitespace and comments from the given procedure.
	 * 
	 * Returns the given semantic region.
	 */
	ISemanticRegion append(ISemanticRegion semanticRegion, Procedure1<? super IHiddenRegionFormatter> after);

	/**
	 * Append the given information and obtain the formatting information for trailing
	 * whitespace and comments from the given procedure.
	 * 
	 * Returns the given semantic object.
	 */
	<T extends EObject> T append(T semanticRegion, Procedure1<? super IHiddenRegionFormatter> after);
	
	/**
	 * Append the given semantic region and obtain the formatting information for leading
	 * whitespace and comments from the given procedure.
	 * 
	 * Returns the given semantic region.
	 */
	ISemanticRegion prepend(ISemanticRegion semanticRegion, Procedure1<? super IHiddenRegionFormatter> before);

	/**
	 * Append the given information and obtain the formatting information for leading
	 * whitespace and comments from the given procedure.
	 * 
	 * Returns the given semantic object.
	 */
	<T extends EObject> T prepend(T semanticRegion, Procedure1<? super IHiddenRegionFormatter> before);
	
	/**
	 * Append the given semantic region and obtain the formatting information for leading and trailing
	 * whitespace and comments from the given procedure.
	 * 
	 * Returns the given semantic region.
	 */
	ISemanticRegion surround(ISemanticRegion semanticRegion, Procedure1<? super IHiddenRegionFormatter> beforeAndAfter);

	/**
	 * Append the given information and obtain the formatting information for leading and trailing
	 * whitespace and comments from the given procedure.
	 * 
	 * Returns the given semantic object.
	 */
	<T extends EObject> T surround(T owner, Procedure1<? super IHiddenRegionFormatter> beforeAndAfter);

	/**
	 * Apply the formatting of the first sub formatter that succeeds to the given owner's region.
	 */
	void formatConditionally(EObject owner, ISubFormatter... formatters) throws FormattingNotApplicableException;

	/**
	 * Apply the formatting of the first sub formatter that succeeds to the given region.
	 */
	void formatConditionally(int offset, int length, ISubFormatter... formatters)
			throws FormattingNotApplicableException;

	/**
	 * Format the given hidden region with the initialized formatter.
	 */
	IHiddenRegion set(IHiddenRegion hiddenRegion, Procedure1<? super IHiddenRegionFormatter> init);

}
