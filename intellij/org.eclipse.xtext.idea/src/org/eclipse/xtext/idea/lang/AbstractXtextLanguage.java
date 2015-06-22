/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.lang;

import org.eclipse.xtext.ISetup;

import com.google.inject.Injector;
import com.intellij.lang.Language;

public abstract class AbstractXtextLanguage extends Language implements IXtextLanguage {

	private Injector injector;

	public AbstractXtextLanguage(Language baseLanguage, String ID, String... mimeTypes) {
		super(baseLanguage, ID, mimeTypes);
	}

	public AbstractXtextLanguage(String id, boolean register) {
		super(id, register);
	}

	public AbstractXtextLanguage(String ID, String... mimeTypes) {
		super(ID, mimeTypes);
	}

	public AbstractXtextLanguage(String id) {
		super(id);
	}

	protected Injector getInjector() {
		if (injector == null) {
			synchronized (this) {
				if (injector == null) {
					ISetup setup = LanguageSetup.INSTANCE.forLanguage(this);
					this.injector = setup.createInjectorAndDoEMFRegistration();
				}
			}
		}
		return injector;
	}

	@Override
	public <T> T getInstance(Class<? extends T> clazz) {
		return getInjector().getInstance(clazz);
	}

	@Override
	public void injectMembers(Object o) {
		getInjector().injectMembers(o);
	}
}
