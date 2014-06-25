/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone;

import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 *
 * @author Holger Schill - Initial contribution and API
 */
public class DisabledClusteringStrategy implements IClusteringStrategy{

	public boolean continueProcessing(ResourceSet resourceSet, int alreadyProcessed) {
		return true;
	}

}
