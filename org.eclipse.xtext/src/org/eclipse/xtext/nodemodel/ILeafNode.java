/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

/**
 * A leaf node in the parse tree.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ILeafNode extends INode {

	/**
	 * Returns <code>true</code> if the node was produced by a hidden token.
	 * @return <code>true</code> if the node was produced by a hidden token.
	 */
	boolean isHidden();

}
