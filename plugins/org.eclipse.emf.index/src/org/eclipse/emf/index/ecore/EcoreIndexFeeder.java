/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ecore;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface EcoreIndexFeeder {

	List<EClassDescriptor> index(EPackage ePackage, boolean isRecurseSubpackages);
}
