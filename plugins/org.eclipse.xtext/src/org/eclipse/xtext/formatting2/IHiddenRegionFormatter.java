/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

/**
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.7
 */
public interface IHiddenRegionFormatter {
	final int HIGH_PRIORITY = 1;
	final int LOW_PRIORITY = -1;
	final int NORMAL_PRIORITY = 0;

	IHiddenRegionFormatting asBean();

	void autowrap();

	void decreaseIndentation();

	IFormatterRequest getRequest();

	void highPriority();

	void increaseIndentation();

	void noIndentation();

	void lowPriority();

	void newLine();

	void noAutowrap();

	void noSpace();

	void oneSpace();

	void setDecreaseIndentation(int indentation);

	void setIncreaseIndentation(int indentation);

	void setNewLines(int newLines);

	void setNewLines(int minNewLines, int defaultNewLines, int maxNewLines);

	void setOnAutowrap(IAutowrapFormatter formatter);

	void setPriority(int priority);

	void setSpace(String space);
}