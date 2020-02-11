/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.xtend.ide.view.DerivedSourceView;

/**
 * 
 * @author Karsten Thoms (karsten.thoms@itemis.de) - Initial contribution and API
 */
public class XtendEditorAdapterFactory implements IAdapterFactory {

	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		if (adaptableObject instanceof XtendEditor && IShowInTargetList.class.equals(adapterType)) {
			return adapterType.cast(new IShowInTargetList() {
				@Override
				public String[] getShowInTargetIds() {
					return new String[] { DerivedSourceView.class.getName() };
				}
			});
		}
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return new Class[] { IShowInTargetList.class };
	}

}
