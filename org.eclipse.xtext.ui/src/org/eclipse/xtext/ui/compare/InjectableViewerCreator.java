/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.compare;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.IViewerCreator;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class InjectableViewerCreator implements IViewerCreator {
	@Inject
	protected IViewerCreator viewerCreator;

	@Override
	public Viewer createViewer(Composite parent, CompareConfiguration config) {
		return viewerCreator.createViewer(parent, config);
	}

}
