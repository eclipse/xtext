/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionDeltaProvider.Deltas;
import org.eclipse.xtext.util.IAcceptor;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class ResourceUpdater {

	public abstract void applyChange(Deltas deltas, IAcceptor<IEmfResourceChange> changeAcceptor);

	public abstract void unload();

}
