/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.folding;

import org.eclipse.jface.text.source.projection.ProjectionViewer;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public interface IFoldingStructureProvider {
	void updateFoldingStructure(ProjectionViewer projectionViewer);
}
