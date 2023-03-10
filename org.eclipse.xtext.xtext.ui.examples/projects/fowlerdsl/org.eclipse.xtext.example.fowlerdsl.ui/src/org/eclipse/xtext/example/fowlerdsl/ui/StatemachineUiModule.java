/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.example.fowlerdsl.ui.folding.StatemachineFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
public class StatemachineUiModule extends AbstractStatemachineUiModule {

	public StatemachineUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends IFoldingRegionProvider> bindIFoldingRegionProvider() {
		return StatemachineFoldingRegionProvider.class;
	}
}
