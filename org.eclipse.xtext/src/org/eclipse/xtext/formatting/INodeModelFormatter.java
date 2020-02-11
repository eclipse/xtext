/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting;

import org.eclipse.xtext.nodemodel.ICompositeNode;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface INodeModelFormatter {

	interface IFormattedRegion {
		String getFormattedText();

		/**
		 * @since 2.0
		 */
		int getLength();

		int getOffset();
	}

	IFormattedRegion format(ICompositeNode root, int offset, int length);

}
