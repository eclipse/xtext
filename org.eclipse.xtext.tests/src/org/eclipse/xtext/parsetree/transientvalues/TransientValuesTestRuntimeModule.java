/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.transientvalues;

import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;

/**
 * used to register components to be used within the IDE.
 */
public class TransientValuesTestRuntimeModule extends AbstractTransientValuesTestRuntimeModule {

	@Override
	public Class<? extends ITransientValueService> bindITransientValueService() {
		return TransientHandlerPTC.class;
	}

	public Class<? extends org.eclipse.xtext.serializer.sequencer.ITransientValueService> bindTransientHandlerSerializer() {
		return TransientHandlerSerializer.class;
	}

}
