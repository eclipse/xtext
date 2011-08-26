/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.refactoring;

import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelRenameElementHandler;
import org.eclipse.xtext.xtend2.ui.preferences.Xtend2Preferences;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class Xtend2RenameElementHandler extends JvmModelRenameElementHandler {

	@Inject
	private Xtend2Preferences preferences;

	@Override
	public boolean isEnabled() {
		return preferences.isRefactoringEnabled() && super.isEnabled();
	}
}
