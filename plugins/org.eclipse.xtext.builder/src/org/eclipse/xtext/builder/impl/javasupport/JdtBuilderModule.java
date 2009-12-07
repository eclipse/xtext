/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import org.eclipse.xtext.builder.BuilderModule;
import org.eclipse.xtext.builder.impl.IUriUtil;
import org.eclipse.xtext.builder.impl.ToBeBuiltComputer;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class JdtBuilderModule extends BuilderModule {
	
	@Override
	protected void configure() {
		super.configure();
		bind(ToBeBuiltComputer.class).to(JdtToBeBuiltComputer.class);
		bind(IUriUtil.class).to(JdtUriUtil.class);
		bind(ElementChangeListener.class).asEagerSingleton();
	}
	
	
}