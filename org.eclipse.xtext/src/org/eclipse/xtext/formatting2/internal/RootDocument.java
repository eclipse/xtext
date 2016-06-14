/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RootDocument extends FormattableDocument {

	private final AbstractFormatter2 formatter;

	public RootDocument(AbstractFormatter2 formatter) {
		super();
		this.formatter = formatter;
	}

	@Override
	public AbstractFormatter2 getFormatter() {
		return formatter;
	}

	@Override
	public ITextSegment getRegion() {
		return formatter.getRequest().getTextRegionAccess().regionForDocument();
	}

	@Override
	public FormatterRequest getRequest() {
		return formatter.getRequest();
	}

}