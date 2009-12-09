/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.internal;

import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.ui.core.editor.DirtyStateManager;
import org.eclipse.xtext.ui.core.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.core.notification.IStateChangeEventBroker;
import org.eclipse.xtext.ui.core.notification.StateChangeEventBroker;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;


/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Module extends AbstractModule {
	
	@Override
	protected void configure() {
		bind(IExternalContentSupport.IExternalContentProvider.class).to(IDirtyStateManager.class).in(Scopes.SINGLETON);
		bind(IDirtyStateManager.class).to(DirtyStateManager.class).in(Scopes.SINGLETON);
		bind(IStateChangeEventBroker.class).to(StateChangeEventBroker.class).in(Scopes.SINGLETON);
	}
	
}
