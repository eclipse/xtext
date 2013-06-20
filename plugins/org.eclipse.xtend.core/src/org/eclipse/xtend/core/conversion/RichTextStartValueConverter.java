/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.conversion;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichTextStartValueConverter extends AbstractRichTextValueConverter {

	@Override
	protected String getLeadingTerminal() {
		return "'''";
	}

	@Override
	protected String getTrailingTerminal() {
		return "\u00AB";
	}

}
