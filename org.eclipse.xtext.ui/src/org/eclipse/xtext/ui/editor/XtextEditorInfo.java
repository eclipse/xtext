/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.xtext.LanguageInfo;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
@Singleton
public class XtextEditorInfo {

	protected final LanguageInfo languageInfo;
	
	@Inject
	public XtextEditorInfo(LanguageInfo languageInfo) {
		this.languageInfo = languageInfo;
	}
	
	public String getEditorId() {
		return languageInfo.getLanguageName();
	}
	
	public LanguageInfo getLanguageInfo() {
		return languageInfo;
	}
	
}
