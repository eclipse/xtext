/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.resource.OutdatedStateManager;
import org.eclipse.xtext.service.OperationCanceledManager;

import com.google.inject.Inject;

/**
 * A container for services provided by injection.
 * to be passed down to TypeResources.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypeResourceServices {

	@Inject OperationCanceledManager operationCanceledManager;
	@Inject OutdatedStateManager outdatedStateManager;
	
	public OperationCanceledManager getOperationCanceledManager() {
		return operationCanceledManager;
	}
	
	public OutdatedStateManager getOutdatedStateManager() {
		return outdatedStateManager;
	}
}
