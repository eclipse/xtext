/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.shared;

import org.eclipse.xtext.builder.impl.javasupport.BuilderDeltaConverter;
import org.eclipse.xtext.builder.impl.javasupport.JavaChangeQueueFiller;
import org.eclipse.xtext.builder.impl.javasupport.ProjectClasspathChangeListener;
import org.eclipse.xtext.common.types.ui.notification.DeltaConverter;
import org.eclipse.xtext.common.types.ui.notification.TypeResourceUnloader;
import org.eclipse.xtext.naming.IQualifiedNameConverter;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * @author Sebastian Zarnekow
 * @since 2.5
 */
@SuppressWarnings("restriction")
public class GlobalListenerModule implements Module {

	public void configure(Binder binder) {
		binder.bind(BuilderDeltaConverter.class);
		binder.bind(DeltaConverter.class);
		
		binder.bind(ProjectClasspathChangeListener.class).asEagerSingleton();
		binder.bind(TypeResourceUnloader.class).asEagerSingleton();
		binder.bind(JavaChangeQueueFiller.class).asEagerSingleton();
	}
	
}
