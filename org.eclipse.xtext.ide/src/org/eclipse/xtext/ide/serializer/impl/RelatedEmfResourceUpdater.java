/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
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
