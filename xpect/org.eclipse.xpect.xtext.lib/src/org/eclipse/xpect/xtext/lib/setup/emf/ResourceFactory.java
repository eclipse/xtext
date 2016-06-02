/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect.xtext.lib.setup.emf;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xpect.xtext.lib.setup.FileSetupContext;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ResourceFactory {
	Resource create(FileSetupContext ctx, ResourceSet resourceSet) throws IOException;
}
