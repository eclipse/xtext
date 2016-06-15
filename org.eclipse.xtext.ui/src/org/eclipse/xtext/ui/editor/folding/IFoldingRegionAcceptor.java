/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.folding;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Sebastian Zarnekow - Distinguish between total and identifying region
 */
public interface IFoldingRegionAcceptor<AdditionalParam> {

	void accept(int offset, int length);

	/**
	 * @param offset
	 *            of the significant content
	 * @param length
	 *            of the significant content
	 * @param param
	 *            used to compute the significant region.
	 */
	void accept(int offset, int length, AdditionalParam param);

}
