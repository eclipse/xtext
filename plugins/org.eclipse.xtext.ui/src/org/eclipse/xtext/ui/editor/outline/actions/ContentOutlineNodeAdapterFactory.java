/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.xtext.ui.editor.outline.IContentOutlineNode;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class ContentOutlineNodeAdapterFactory extends AdapterFactoryImpl {

	public static final ContentOutlineNodeAdapterFactory INSTANCE = new ContentOutlineNodeAdapterFactory();
	
	private ContentOutlineNodeAdapterFactory() {
	}
	
	@Override
	protected Adapter createAdapter(Notifier target) {
		return new ContentOutlineNodeAdapter();
	}
	
	@Override
	public boolean isFactoryForType(Object type) {
		return type == IContentOutlineNode.class;
	}
}
