/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.registry;

import static org.eclipse.emf.common.EMFPlugin.IS_ECLIPSE_RUNNING;

import java.util.Collection;
import java.util.Set;

import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ILanguageInfo {
	public interface Registry {
		public static final Registry INSTANCE = IS_ECLIPSE_RUNNING ? new DelegatingLanguageRegistry() : new StandaloneLanguageRegistry();

		public abstract ILanguageInfo getLanguageByFileExtension(String fileExtension);

		public abstract ILanguageInfo getLanguageByName(String languageName);

		public abstract Collection<ILanguageInfo> getLanguages();
	}

	public Set<String> getFileExtensions();

	public Injector getInjector(Module... modules);

	public String getLanguageName();

}