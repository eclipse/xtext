/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.web;


/**
 * Use this class to register components to be used within the web application.
 */
public class StatemachineWebModule extends AbstractStatemachineWebModule {
	
	public StatemachineWebModule(Provider<ExecutorService> executorServiceProvider) {
		super(executorServiceProvider);
	}
	
}
