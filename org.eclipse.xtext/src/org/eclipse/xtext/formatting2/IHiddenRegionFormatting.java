/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import org.eclipse.xtext.formatting2.internal.HiddenRegionFormatting;

/**
 * <p>
 * HiddenRegionFormatting specifies formatting information for a HiddenRegion. A HiddenRegion is the group of all hidden
 * tokens (whitespace and comments) between to non-hidden tokens.
 * </p>
 * 
 * <p>
 * HiddenRegionFormattings can sometimes be automatically {@link #mergeValuesFrom(IHiddenRegionFormatting) merged} when
 * two different formattings are registered for the same region in an {@link IFormattableDocument}.
 * </p>
 * 
 * @see IHiddenRegionFormatter
 * @noimplement This interface is not intended to be implemented by clients, use {@link HiddenRegionFormatting}
 * @noextend This interface is not intended to be extended by clients, use {@link HiddenRegionFormatting}
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
public interface IHiddenRegionFormatting {

	void mergeValuesFrom(IHiddenRegionFormatting other) throws ConflictingFormattingException;

	Integer getAutowrap();

	Integer getIndentationDecrease();

	Integer getIndentationIncrease();

	Integer getNewLineDefault();

	Integer getNewLineMax();

	Integer getNewLineMin();

	Boolean getNoIndentation();

	IAutowrapFormatter getOnAutowrap();

	int getPriority();

	FormatterRequest getRequest();

	String getSpace();

	void setAutowrap(Integer value);

	void setIndentationDecrease(Integer indentation);

	void setIndentationIncrease(Integer indentation);

	void setNewLinesDefault(Integer newLines);

	void setNewLinesMax(Integer newLines);

	void setNewLinesMin(Integer newLines);

	void setNoIndentation(Boolean value);

	void setOnAutowrap(IAutowrapFormatter formatter);

	void setPriority(int priority);

	void setSpace(String space);
}