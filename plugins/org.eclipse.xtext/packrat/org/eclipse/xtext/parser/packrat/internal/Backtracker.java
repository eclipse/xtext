/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.internal;

import org.eclipse.xtext.parser.packrat.IBacktracker;
import org.eclipse.xtext.parser.packrat.internal.Marker.IMarkerClient;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Backtracker implements IBacktracker {

	private final IMarkerClient markerClient;

	public Backtracker(Marker.IMarkerClient markerClient) {
		this.markerClient = markerClient;
	}

	public IBacktrackingResult skipPreviousToken() {
		return markerClient.getActiveMarker().skipPreviousToken();
	}

}
