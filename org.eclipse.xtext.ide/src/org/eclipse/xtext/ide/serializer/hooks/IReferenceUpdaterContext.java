/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.hooks;

import java.util.List;

import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas;
import org.eclipse.xtext.ide.serializer.impl.RelatedResourcesProvider.RelatedResource;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 *
 * @since 2.13 
 */
public interface IReferenceUpdaterContext {

	RelatedResource getRelatedResource();

	Deltas getEObjectDescriptionDeltas();

	ITextRegionDiffBuilder getModifyableDocument();

	XtextResource getResource();

	List<IUpdatableReference> getUpdatableReferences();

	void modifyModel(Runnable runnable);

	void updateReference(IUpdatableReference updatableReference);
}