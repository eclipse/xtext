/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.internal;

import org.eclipse.xtext.index.IXtextIndex;
import org.eclipse.xtext.ui.core.builder.impl.ISharedState;
import org.eclipse.xtext.ui.core.index.NameSearchTrackingIndexImpl;


/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Module extends org.eclipse.emf.emfindex.EquinoxEmfIndexModule {
	
	@Override
	protected void configure() {
		super.configure();
		binder().bind(IXtextIndex.class).to(NameSearchTrackingIndexImpl.class);
		binder().bind(ISharedState.class).to(NameSearchTrackingIndexImpl.class);
		binder().bind(NameSearchTrackingIndexImpl.class).asEagerSingleton();
	}
	
}
