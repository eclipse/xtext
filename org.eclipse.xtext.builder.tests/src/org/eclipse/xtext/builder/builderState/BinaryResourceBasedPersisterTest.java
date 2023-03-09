/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

/**
 * Will fail for EMF 2.6 or higher. See {@link BufferedBinaryResourceFactory} for details.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BinaryResourceBasedPersisterTest extends AbstractEMFBasedPersisterTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		persister.setFactory(new BufferedBinaryResourceFactory());
	}
	
}
