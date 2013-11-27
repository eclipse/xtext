/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import org.eclipse.xtext.builder.impl.QueuedBuildData;
import org.eclipse.xtext.builder.impl.javasupport.JdtQueuedBuildData;
import org.eclipse.xtext.generator.trace.DefaultTraceURIConverter;
import org.eclipse.xtext.ui.generator.trace.DefaultUITraceURIConverter;

import com.google.inject.AbstractModule;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SharedModuleWithJdt extends AbstractModule {

	@Override
	protected void configure() {
		bind(QueuedBuildData.class).to(JdtQueuedBuildData.class);
		
		bind(DefaultTraceURIConverter.class).to(DefaultUITraceURIConverter.class);
	}

}