/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdater;
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.ImplementedBy;

/**
 * Converts changes from EMF models to the smallest possible text changes.
 * 
 * The ChangeSerializer records changes in modifications that are added using
 * {@link #addModification(Notifier, IModification) addModification(T, IModification&lt;T&gt;)}. All corresponding {@link ITextDocumentChange}s can be retrieved in the
 * end by calling {@link #applyModifications(IAcceptor)}. They contain {@link ITextReplacement} which may then be
 * applied to an editor's contents or to a persisted file.
 * 
 * In contrast to {@link ISerializer}, the ChangeSerializer aims to produce the smallest text changes possible, can
 * handle changes that span multiple files, and is able to update cross references in related files.
 * 
 * Just like {@link ISerializer}, the ChangeSerializer applies the {@link IFormatter2} before returning
 * TextReplacements.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * 
 * @since 2.13
 */
@ImplementedBy(ChangeSerializer.class)
public interface IChangeSerializer {

	interface IModification<T extends Notifier> {
		void modify(T context);
	}

	<T extends Notifier> void addModification(T context, IModification<T> modification);

	void applyModifications(IAcceptor<IEmfResourceChange> acceptor);

	ITextRegionDiffBuilder getModifiableDocument(Resource resource);

	/**
	 * @see #setUpdateCrossReferences(boolean)
	 */
	boolean isUpdateCrossReferences();

	/**
	 * @see #setUpdateRelatedFiles(boolean)
	 */
	boolean isUpdateRelatedFiles();

	/**
	 * If set, {@link #addModification(Notifier, IModification)} will report progress and check
	 * {#{@link IProgressMonitor#isCanceled()} on this monitor object.
	 */
	void setProgressMonitor(IProgressMonitor monitor);

	/**
	 * If set to true (that's the default), cross references affected by changes made in
	 * {@link #addModification(Notifier, IModification)} will be updated. This involves at least all cross references
	 * from files for which there is an {@link IModification}. If {@link #isUpdateRelatedFiles()} is true, also all
	 * other cross references known by {@link IResourceDescriptions} are updated.
	 * 
	 * Example: When a modification changes <code>myElement.name</code> from <code>"foo"</code> to <code>"bar"</code>,
	 * all references pointing to <code>"foo"</code> are updated to <code>"bar"</code>. Yes, that's a rename
	 * refactoring.
	 * 
	 * @see IReferenceUpdater
	 * @see #setUpdateRelatedFiles(boolean)
	 */
	void setUpdateCrossReferences(boolean value);

	/**
	 * If set to true, (that's the default) and {@link #isUpdateCrossReferences()} is also set to true,
	 * {@link IReferenceUpdater} will also be called for files that are not directly changed by an {@link IModification}
	 * but may contain cross references pointing to a changed files.
	 */
	void setUpdateRelatedFiles(boolean value);
}
