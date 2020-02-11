/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors:
 *   Jan Koehnlein - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.graph.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.CrossPoint;

/**
 * Interface for all building blocks of a railroad diagram.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface ISegmentFigure extends IFigure, IEObjectReferer {

	CrossPoint getEntry();

	CrossPoint getExit();
}
