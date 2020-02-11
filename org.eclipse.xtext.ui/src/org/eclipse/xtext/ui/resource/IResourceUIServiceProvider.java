/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;

import com.google.inject.ImplementedBy;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
@ImplementedBy(DefaultResourceUIServiceProvider.class)
public interface IResourceUIServiceProvider extends IResourceServiceProvider {

	/**
	 * @return the EObject description label provider for this service manager.
	 */
	ILabelProvider getLabelProvider();
	
	/**
	 * Tells whether the given URI together with the underlying {@link IStorage} can be handled by this {@link IResourceServiceProvider}
	 * @param uri - might be null
	 * @param storage - might be null
	 * @return true if the URI and {@link IStorage} can be handled
	 */
	boolean canHandle(URI uri, IStorage storage);
	
	/**
	 * The {@link IURIEditorOpener} of the language
	 */
	IURIEditorOpener getURIEditorOpener();
	
	/**
	 * The reference updater of the language.
	 * @deprecated use {@link #get(Class) get(IReferenceUpdater.class)} instead
	 */
	@Deprecated
	IReferenceUpdater getReferenceUpdater();
}
