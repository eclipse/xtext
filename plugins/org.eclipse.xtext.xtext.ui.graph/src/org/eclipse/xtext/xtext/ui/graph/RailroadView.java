/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Jan Koehnlein - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.graph;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.xtext.ui.graph.actions.ExportToFileAction;
import org.eclipse.xtext.xtext.ui.graph.actions.LinkWithEditorAction;
import org.eclipse.xtext.xtext.ui.graph.actions.RailroadSelectionLinker;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * A railroad diagram view for Xtext grammars.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class RailroadView extends ViewPart {
	public static final String ID = "org.eclipse.xtext.xtext.ui.graph.view";

	@Inject
	private RailroadSynchronizer synchronizer;

	@Inject
	private RailroadSelectionProvider selectionProvider;

	@Inject
	private ExportToFileAction exportAction;

	@Inject
	private LinkWithEditorAction linkWithEditorAction;

	@Inject
	private RailroadSelectionLinker selectionLinker;

	private IFigure rootFigure;

	private FigureCanvas canvas;

	private IFigure contents;

	public RailroadView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		canvas = new FigureCanvas(parent, SWT.V_SCROLL | SWT.H_SCROLL);
		rootFigure = new Figure();
		rootFigure.addMouseListener(selectionProvider);
		rootFigure.setLayoutManager(new StackLayout());
		rootFigure.setVisible(true);
		canvas.setContents(rootFigure);
		getSite().setSelectionProvider(selectionProvider);
		createActions();
	}

	private void createActions() {
		IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();
		toolBarManager.add(exportAction);
		toolBarManager.add(linkWithEditorAction);
		selectionLinker.activate();
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		synchronizer.start(site);
	}

	@Override
	public void dispose() {
		selectionLinker.deactivate();
		synchronizer.stop(getSite());
		super.dispose();
	}

	public void setContents(final IFigure newContents) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				if (contents != null)
					if(contents.getParent() == rootFigure)
						rootFigure.remove(contents);
				if (newContents != null)
					rootFigure.add(newContents);
				rootFigure.validate();
				contents = newContents;
				exportAction.setEnabled(newContents != null);
			}
		});
	}

	public IFigure getContents() {
		return contents;
	}

	public IFigure findFigureAt(Point location) {
		return rootFigure.findFigureAt(location);
	}

	public void reveal(IFigure figure) {
		Viewport viewport = canvas.getViewport();
		Rectangle viewportBounds = viewport.getBounds().getCopy();
		viewportBounds.translate(viewport.getViewLocation());
		Rectangle figureBounds = figure.getBounds().getCopy();
		figure.translateToAbsolute(figureBounds);
		figureBounds.translate(viewport.getViewLocation());
		if (!viewportBounds.contains(figureBounds)) {
			int newX = viewportBounds.x;
			int newY = viewportBounds.y;
			if(viewportBounds.x > figureBounds.x) {
				newX = figureBounds.x; 
			} else if(viewportBounds.x + viewportBounds.getRight().x < figureBounds.getRight().x) {
				newX = figureBounds.getRight().x - viewportBounds.width;
			}
			if(viewportBounds.y > figureBounds.y) {
				newY = figureBounds.y; 
			} else if(viewportBounds.getBottom().y < figureBounds.getBottom().y) {
				newY = figureBounds.getBottom().y - viewportBounds.height;
			}
			canvas.scrollSmoothTo(newX, newY);
		}
	}

	@Override
	public void setFocus() {
		canvas.setFocus();
	}

	public Control getControl() {
		return canvas;
	}

}