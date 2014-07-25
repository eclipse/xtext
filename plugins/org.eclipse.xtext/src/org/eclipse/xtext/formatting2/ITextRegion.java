/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;


/**
 * TODO: maybe use {@link org.eclipse.xtext.util.ITextRegion} instead?
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.7
 */
public interface ITextRegion extends Comparable<ITextRegion> {
	int getEndOffset();

	int getLength();

	int getLineCount();

	int getOffset();

	String getText();

	boolean isMultiline();

	ITextRegionAccess getTokenAccess();
}
