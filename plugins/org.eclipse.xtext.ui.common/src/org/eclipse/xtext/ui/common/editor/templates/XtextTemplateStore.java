/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.templates;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.ui.editors.text.templates.ContributionTemplateStore;
import org.eclipse.xtext.Constants;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class XtextTemplateStore extends ContributionTemplateStore {

	@Inject
	public XtextTemplateStore(ContextTypeRegistry registry, IPreferenceStore store, @Named(Constants.LANGUAGE_NAME) String key) {
		super(registry, store, key+".templates");
	}

}
