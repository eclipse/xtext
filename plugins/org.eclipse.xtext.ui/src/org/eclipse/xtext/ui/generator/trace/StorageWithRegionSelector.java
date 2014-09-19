/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import java.util.Collection;

import org.eclipse.core.resources.IStorage;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.TwoPaneElementSelector;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.Strings;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StorageWithRegionSelector extends TwoPaneElementSelector {

	protected static class AbstractStorageWithRegionLabelProvider extends LabelProvider {
		protected WorkbenchLabelProvider workbenchLabelProvider = new WorkbenchLabelProvider();

		@Override
		public Image getImage(Object element) {
			return workbenchLabelProvider.getImage(unwrap(element));
		}

		protected Object unwrap(Object obj) {
			if (obj instanceof StorageWithRegion)
				return ((StorageWithRegion) obj).getStorage();
			return obj;
		}
	}

	protected static class StorageWithRegionDetailLabelProvider extends AbstractStorageWithRegionLabelProvider {

		protected String getText(IStorage storage) {
			return storage.getFullPath().toString();
		}

		protected String getText(ITextRegion region) {
			if (region instanceof ITextRegionWithLineInformation) {
				ITextRegionWithLineInformation lines = ((ITextRegionWithLineInformation) region);
				if (lines.getLineNumber() == lines.getEndLineNumber())
					return String.format("line %d", lines.getLineNumber());
				return String.format("lines %d-%d", lines.getLineNumber(), lines.getEndLineNumber());
			} else if (region != null) {
				return String.format("offset %d, lenght %d", region.getOffset(), region.getLength());
			}
			return "";
		}

		@Override
		public String getText(Object element) {
			if (element instanceof StorageWithRegion) {
				StorageWithRegion storageWithRegion = (StorageWithRegion) element;
				String storage = getText(storageWithRegion.getStorage());
				String region = getText(storageWithRegion.getRegion());
				if (Strings.isEmpty(region)) {
					return storage;
				} else {
					return storage + " " + region;
				}
			}
			return element.toString();
		}

	}

	protected static class StorageWithRegionShortLabelProvider extends AbstractStorageWithRegionLabelProvider implements
			IStyledLabelProvider {

		public StyledString getStyledText(Object element) {
			return workbenchLabelProvider.getStyledText(unwrap(element));
		}

		@Override
		public String getText(Object element) {
			return workbenchLabelProvider.getText(unwrap(element));
		}

	}

	public StorageWithRegionSelector(Shell parent, Collection<StorageWithRegion> storages) {
		super(parent, new StorageWithRegionShortLabelProvider(), new StorageWithRegionDetailLabelProvider());
		setTitle("Open File");
		setMessage("Select a file to open.");
		setElements(storages.toArray(new StorageWithRegion[storages.size()]));
	}
}
