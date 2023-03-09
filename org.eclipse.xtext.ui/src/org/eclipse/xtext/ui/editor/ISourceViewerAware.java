/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.jface.text.source.ISourceViewer;

/**
 * @author Peter Friese - Initial contribution and API
 */
public interface ISourceViewerAware {
	void setSourceViewer(ISourceViewer sourceViewer);
}
