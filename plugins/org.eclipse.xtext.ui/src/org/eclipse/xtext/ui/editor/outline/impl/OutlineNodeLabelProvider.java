/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.PluginImageHelper;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.label.AbstractLabelProvider;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class OutlineNodeLabelProvider extends AbstractLabelProvider {

	@Inject
	private PluginImageHelper pluginImageHelper;

	@Override
	protected Object doGetText(Object element) {
		if (element instanceof IOutlineNode) {
			return ((IOutlineNode) element).getText();
		}
		return super.doGetText(element);
	}

	@Override
	protected Object doGetImage(Object element) {
		if (element instanceof IOutlineNode) {
			return ((IOutlineNode) element).getImage();
		}
		return super.doGetImage(element);
	}

	@Override
	protected Object getDefaultImage() {
		return pluginImageHelper.getImage("defaultoutlinenode.gif");
	}

	@Override
	protected String getDefaultText() {
		return "<null>";
	}
	
	@Override
	public Image getImage(Object element) {
		return super.getImage(element);
	}
	
	@Override
	public String getText(Object element) {
		return super.getText(element);
	}
}
