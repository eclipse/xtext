/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.List;

/**
 * This interface is the 'outer' view of of the formatter. If you want to invoke a formatter, have an implementation of
 * this interface injected via Guice, compose a {@link IFormatterRequest}-object and call
 * {@link #format(IFormatterRequest)}.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.7
 */
public interface IFormatter {

	/**
	 * Execute the formatter.
	 */
	List<ITextReplacement> format(IFormatterRequest request);

}
