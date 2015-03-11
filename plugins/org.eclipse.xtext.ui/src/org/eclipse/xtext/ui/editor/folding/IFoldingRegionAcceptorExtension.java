/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.folding;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.8
 */
public interface IFoldingRegionAcceptorExtension<AdditionalParam> extends IFoldingRegionAcceptor<AdditionalParam>{

	/**
	 * @param offset
	 *            of the significant content
	 * @param length
	 *            of the significant content
	 * @param initiallyFolded
	 * 			  whether this region should be folded by default
	 */
	void accept(int offset, int length, boolean initiallyFolded);

	/**
	 * @param offset
	 *            of the significant content
	 * @param length
	 *            of the significant content
	 * @param initiallyFolded
	 * 			  whether this region should be folded by default
	 * @param param
	 *            used to compute the significant region.
	 */
	void accept(int offset, int length, boolean initiallyFolded, AdditionalParam param);
}
