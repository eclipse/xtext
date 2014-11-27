/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import org.eclipse.xtext.formatting2.internal.HiddenRegionFormatting;

/**
 * HiddenRegionFormatting specifies formatting information for a HiddenRegion. A HiddenRegion is the group of all hidden
 * tokens (whitespace and commend) between to non-hidden tokens.
 * 
 * HiddenRegionFormattings can sometimes be automatically merged when two are registered for the same region in an
 * {@link IFormattableDocument}.
 * 
 * 
 * @noimplement This interface is not intended to be implemented by clients, use {@link HiddenRegionFormatting}
 * @noextend This interface is not intended to be extended by clients, use {@link HiddenRegionFormatting}
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
public interface IHiddenRegionFormatting {

	void mergeValuesFrom(IHiddenRegionFormatting other) throws ConflictingFormattingException;

	IHiddenRegionFormatter asFormatter();

	Integer getAutowrap();

	Integer getIndentationDecrease();

	Integer getIndentationIncrease();

	Integer getNewLineDefault();

	Integer getNewLineMax();

	Integer getNewLineMin();

	Boolean getNoIndetation();

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