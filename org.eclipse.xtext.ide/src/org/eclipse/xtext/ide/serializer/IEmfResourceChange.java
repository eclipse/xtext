/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Represents a an {@link Resource} that has been directly modified or is affected by a change from
 * {@link IChangeSerializer}.
 * 
 * If the {@link Resource} is an {@link XtextResource}, the object should also implement {@link ITextDocumentChange}.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IEmfResourceChange {

	Resource getResource();

	URI getOldURI();

	URI getNewURI();
}
