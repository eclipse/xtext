/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.xtext.Constants;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
@Singleton
public class XtextEditorInfo {

	private String languageName;

	@Inject
	public void setLanguageName(@Named(Constants.LANGUAGE_NAME) String name) {
		this.languageName = name;
	}

	public String getLanguageName() {
		return languageName;
	}
	
	public String getEditorId() {
		return getLanguageName();
	}
	
}
