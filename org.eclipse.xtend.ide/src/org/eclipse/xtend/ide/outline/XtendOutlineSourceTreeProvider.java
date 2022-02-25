/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.outline;

import org.eclipse.xtend.ide.common.outline.IXtendOutlineContext;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Customization of the default outline structure.
 * 
 * @author Jan Koehnlein
 * @author Dennis Huebner
 */
public class XtendOutlineSourceTreeProvider extends AbstractMultiModeOutlineTreeProvider {

	@Inject
	private Provider<EclipseXtendOutlineSourceContext> xtendOutlineContextProvider;

	@Override
	protected IXtendOutlineContext newContext(IOutlineNode parentNode) {
		EclipseXtendOutlineSourceContext context = xtendOutlineContextProvider.get();
		context.setShowInherited(isShowInherited());
		context.setParentNode(parentNode);
		return context;
	}

}
