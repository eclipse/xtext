/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.hooks;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ide.serializer.impl.EObjectDescriptionProvider;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(EObjectDescriptionProvider.class)
public interface IEObjectDescriptionProvider {

	Iterable<IEObjectDescription> getEObjectDescriptions(Resource resource);

}
