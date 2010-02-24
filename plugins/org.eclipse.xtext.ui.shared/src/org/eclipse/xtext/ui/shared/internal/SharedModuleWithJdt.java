/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import org.eclipse.xtext.builder.impl.ToBeBuiltComputer;
import org.eclipse.xtext.builder.impl.javasupport.ElementChangeListener;
import org.eclipse.xtext.builder.impl.javasupport.JdtToBeBuiltComputer;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl;

import com.google.inject.AbstractModule;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class SharedModuleWithJdt extends AbstractModule {

	@Override
	protected void configure() {
		bind(ToBeBuiltComputer.class).to(JdtToBeBuiltComputer.class);
		bind(ElementChangeListener.class).asEagerSingleton();
		bind(IStorage2UriMapper.class).to(Storage2UriMapperJavaImpl.class);
	}

}