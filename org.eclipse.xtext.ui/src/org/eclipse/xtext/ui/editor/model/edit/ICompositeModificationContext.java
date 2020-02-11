/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.Issue;

/**
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * 
 * @since 2.13
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ICompositeModificationContext<E extends EObject> {

	interface IModificationPart<T extends Notifier> {
		void apply(T object);
	}

	<T extends Notifier> void addModification(T toModify, IModificationPart<T> modification);

	E getElement();

	Issue getIssue();

	ITextRegionDiffBuilder getModifiableDocument(XtextResource resource);

	/**
	 * @see IChangeSerializer#isUpdateCrossReferences()
	 */
	boolean isUpdateCrossReferences();

	/**
	 * @see IChangeSerializer#isUpdateRelatedFiles()
	 */
	boolean isUpdateRelatedFiles();

	/**
	 * @see IChangeSerializer#isUpdateCrossReferences()
	 */
	void setUpdateCrossReferences(boolean value);

	/**
	 * @see IChangeSerializer#isUpdateRelatedFiles()
	 */
	void setUpdateRelatedFiles(boolean value);
}
