/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.hooks;

import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas;
import org.eclipse.xtext.ide.serializer.impl.ReferenceUpdater;
import org.eclipse.xtext.ide.serializer.impl.RelatedResourcesProvider.RelatedResource;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 *
 * @since 2.13
 */
@ImplementedBy(ReferenceUpdater.class)
public interface IReferenceUpdater {

	boolean isAffected(Deltas deltas, RelatedResource resource);

	void update(IReferenceUpdaterContext context);

	void updateReference(ITextRegionDiffBuilder rewriter, IUpdatableReference updatable);
}
