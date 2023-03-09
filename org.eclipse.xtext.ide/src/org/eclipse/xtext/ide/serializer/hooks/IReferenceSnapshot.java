/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.hooks;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 *
 * @since 2.13
 */
public interface IReferenceSnapshot {
	URI getSourceEObjectUri();

	URI getContainerEObjectURI();

	EReference getEReference();

	int getIndexInList();

	IEObjectSnapshot getTarget();

}
