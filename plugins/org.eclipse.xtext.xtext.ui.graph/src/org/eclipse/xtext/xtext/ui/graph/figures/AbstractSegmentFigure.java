/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Jan Koehnlein - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.graph.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.CrossPoint;

/**
 * Base class of all {@link ISegmentFigure}s.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractSegmentFigure extends Figure implements ISegmentFigure {

	private URI eObjectURI;
	private CrossPoint entry;
	private CrossPoint exit;

	protected AbstractSegmentFigure(EObject eObject) {
		if(eObject != null)
			eObjectURI = EcoreUtil.getURI(eObject);
		setLayoutManager(createLayoutManager());
	}
	
	@Override
	public URI getEObjectURI() {
		return eObjectURI;
	}

	protected abstract LayoutManager createLayoutManager();

	@Override
	public CrossPoint getEntry() {
		return entry;
	}

	@Override
	public CrossPoint getExit() {
		return exit;
	}

	protected void setEntry(CrossPoint entry) {
		this.entry = entry;
	}

	protected void setExit(CrossPoint exit) {
		this.exit = exit;
	}

	@Override
	protected boolean useLocalCoordinates() {
		return true;
	}
	
	public boolean isSelectable() {
		return false;
	}
}
