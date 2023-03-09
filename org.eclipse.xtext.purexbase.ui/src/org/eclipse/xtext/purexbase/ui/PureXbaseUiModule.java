/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.purexbase.ui;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.purexbase.ui.autoedit.AutoEditStrategyProvider;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.folding.FoldedPosition;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
public class PureXbaseUiModule extends AbstractPureXbaseUiModule {

	public static class NoFolding implements IFoldingRegionProvider {
		@Override
		public Collection<FoldedPosition> getFoldingRegions(IXtextDocument xtextDocument) {
			return Collections.<FoldedPosition> emptySet();
		}
	}

	public PureXbaseUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}


	@Override
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return AutoEditStrategyProvider.class;
	}

	public Class<? extends IFoldingRegionProvider> bindFoldingRegionProvider() {
		return PureXbaseUiModule.NoFolding.class;
	}

}
