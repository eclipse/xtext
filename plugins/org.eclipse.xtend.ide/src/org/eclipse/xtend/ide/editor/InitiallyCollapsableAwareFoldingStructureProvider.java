/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingStructureProvider;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class InitiallyCollapsableAwareFoldingStructureProvider extends DefaultFoldingStructureProvider {

	@Override
	protected ProjectionAnnotation createProjectionAnnotation(boolean allowInitiallyCollapse, Position foldedRegion) {
		if(allowInitiallyCollapse && foldedRegion instanceof InitiallyCollapsableFoldedPosition){
			return super.createProjectionAnnotation(((InitiallyCollapsableFoldedPosition) foldedRegion).isInitiallyCollapsed(), foldedRegion);
		}
		return super.createProjectionAnnotation(false, foldedRegion);
	}
	
	@Override
	public void initialize() {
		calculateProjectionAnnotationModel(true);
	}
	
}
