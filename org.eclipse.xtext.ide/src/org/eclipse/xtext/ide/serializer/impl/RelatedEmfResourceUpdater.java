/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 *
 * @since 2.13
 */
public class RelatedEmfResourceUpdater extends RelatedResourceUpdater {

	@Inject
	private ResourceLifecycleManager lifecycleManager;

	@Override
	public void unload() {
	}

	@Override
	public void applyChange(Deltas deltas, IAcceptor<IEmfResourceChange> changeAcceptor) {
		Resource res = lifecycleManager.openAndApplyReferences(getResourceSet(), getResource());
		EmfResourceChange change = new EmfResourceChange(res, res.getURI());
		changeAcceptor.accept(change);
	}

}
