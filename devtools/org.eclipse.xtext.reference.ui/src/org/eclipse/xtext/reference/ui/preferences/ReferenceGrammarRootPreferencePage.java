/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.reference.ui.preferences;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtext.ui.editor.preferences.AbstractRootPreferencePage;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class ReferenceGrammarRootPreferencePage extends AbstractRootPreferencePage {

	@Override
	protected void createFieldEditors() {

	}

	@Override
	public String qualifiedName() {
		return "org.eclipse.xtext.reference.ReferenceGrammar";
	}

	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		ScopedPreferenceStore scopedPreferenceStore = new ScopedPreferenceStore(new InstanceScope(),
				"org.eclipse.xtext.ui");
		return scopedPreferenceStore;
	}

}
