/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.folding;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.projection.IProjectionPosition;

/**
 * Abstract base class for positions that implement the {@link IProjectionPosition} interface.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class FoldedPosition extends Position implements IProjectionPosition {

	protected FoldedPosition(int offset, int length) {
		super(offset, length);
	}
	
}
