/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

/**
 * An ISubFormatter is responsible to format a sub document.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
public interface ISubFormatter {
	/**
	 * Format the given document or throw a {@link FormattingNotApplicableException}
	 * if the document cannot be formatted by this formatter.
	 */
	void format(IFormattableSubDocument document) throws FormattingNotApplicableException;
}