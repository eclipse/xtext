/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting;

import org.eclipse.xtext.parsetree.reconstr.ITokenStream;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IFormatter {

	public ITokenStream createFormatterStream(String initalIndentation,
			ITokenStream outputStream, boolean preserveWhitespaces);

}
