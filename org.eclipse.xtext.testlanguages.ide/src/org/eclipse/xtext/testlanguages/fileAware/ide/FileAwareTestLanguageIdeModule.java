/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.fileAware.ide;

import org.eclipse.xtext.ide.refactoring.IResourceRelocationStrategy;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdater;
import org.eclipse.xtext.testlanguages.fileAware.ide.refactoring.FileAwareTestLanguageReferenceUpdater;
import org.eclipse.xtext.testlanguages.fileAware.ide.refactoring.FileAwareTestLanguageResourceRelocationStrategy;

/**
 * Use this class to register ide components.
 */
public class FileAwareTestLanguageIdeModule extends AbstractFileAwareTestLanguageIdeModule {

	public Class<? extends IResourceRelocationStrategy> bindIResourceRelocationStrategy() {
		return FileAwareTestLanguageResourceRelocationStrategy.class;
	}

	public Class<? extends IReferenceUpdater> bindReferenceUpdater() {
		return FileAwareTestLanguageReferenceUpdater.class;
	}

}
