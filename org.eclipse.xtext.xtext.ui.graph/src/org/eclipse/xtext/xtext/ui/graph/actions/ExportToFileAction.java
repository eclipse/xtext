/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors:
 *   Jan Koehnlein - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.graph.actions;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.xtext.ui.graph.RailroadView;

import com.google.inject.Inject;

/**
 * Exports an Xtext grammar railroad diagram to an image file.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ExportToFileAction extends Action {

	@Inject
	private RailroadView railroadView;

	public static final int PADDING = 20;

	public ExportToFileAction() {
		setText("Export to file");
		setDescription("Exports this diagram to an image file");
		setToolTipText("Exports this diagram to an image file");
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_ETOOL_SAVE_EDIT));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_ETOOL_SAVE_EDIT_DISABLED));
	}

	@Override
	public void run() {
		IFigure contents = railroadView.getContents();
		if (contents != null) {
			FileDialog fileDialog = new FileDialog(this.railroadView.getSite().getShell(), SWT.SAVE);
			fileDialog.setFilterExtensions(new String[] { "*.png" });
			fileDialog.setText("Choose diagram file");
			String fileName = fileDialog.open();
			if (fileName == null) {
				return;
			}
			Dimension preferredSize = contents.getPreferredSize();
			Image image = new Image(Display.getDefault(), preferredSize.width + 2 * PADDING, preferredSize.height + 2
					* PADDING);
			GC gc = new GC(image);
			SWTGraphics graphics = new SWTGraphics(gc);
			graphics.translate(PADDING, PADDING);
			graphics.translate(contents.getBounds().getLocation().getNegated());
			contents.paint(graphics);
			ImageData imageData = image.getImageData();
			ImageLoader imageLoader = new ImageLoader();
			imageLoader.data = new ImageData[] { imageData };
			imageLoader.save(fileName, SWT.IMAGE_PNG);
		}
	}
}