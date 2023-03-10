/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import java.util.Collection;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.TwoPaneElementSelector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FileOpenerSelector extends TwoPaneElementSelector {

	protected static class EditorOpenerLabelProvider extends LabelProvider {

		private ResourceManager resourceManager = new LocalResourceManager(JFaceResources.getResources());

		@Override
		public Image getImage(Object element) {
			return (Image) resourceManager.get(((FileOpener) element).getImageDescriptor());
		}
	}

	protected static class EditorOpenerDetailLabelProvider extends EditorOpenerLabelProvider {
		@Override
		public String getText(Object element) {
			return ((FileOpener) element).getQualifiedLabel();
		}
	}

	protected static class EditorOpenerShortLabelProvider extends EditorOpenerLabelProvider {
		@Override
		public String getText(Object element) {
			return ((FileOpener) element).getShortLabel();
		}
	}

	public FileOpenerSelector(Shell parent, Collection<FileOpener> storages) {
		super(parent, new EditorOpenerShortLabelProvider(), new EditorOpenerDetailLabelProvider());
		setTitle("Open File");
		setMessage("Select a file to open.");
		setElements(storages.toArray(new FileOpener[storages.size()]));
	}
}
