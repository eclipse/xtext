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
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.common.types.ui.notification.DeltaConverter;
import org.eclipse.xtext.common.types.ui.notification.TypeResourceUnloader;
import org.eclipse.xtext.common.types.ui.trace.ClassFileBasedOpenerContributor;
import org.eclipse.xtext.common.types.ui.trace.FolderAwareTrace;
import org.eclipse.xtext.common.types.ui.trace.ITraceForTypeRootProvider;
import org.eclipse.xtext.common.types.ui.trace.TraceForTypeRootProvider;
import org.eclipse.xtext.common.types.ui.trace.ZipFileAwareTrace;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.ui.generator.trace.OppositeFileOpenerContributor;
import org.eclipse.xtext.ui.shared.contribution.IEagerContribution;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("restriction")
public class CommonTypesContribution implements Module {

	public void configure(Binder binder) {
		binder.bind(IQualifiedNameConverter.class);
		
		binder.bind(BuilderDeltaConverter.class);
		binder.bind(DeltaConverter.class);
		binder.bind(TypeURIHelper.class);
		
		binder.bind(TypeResourceUnloader.class);
		binder.bind(JavaChangeQueueFiller.class);
		
		binder.bind(IEagerContribution.class).to(ListenerRegistrar.class);
	
		binder.bind(TraceRegionSerializer.class);
		binder.bind(ITraceForTypeRootProvider.class).to(TraceForTypeRootProvider.class);
		binder.bind(FolderAwareTrace.class);
		binder.bind(ZipFileAwareTrace.class);
		binder.bind(OppositeFileOpenerContributor.class).to(ClassFileBasedOpenerContributor.class);
	}

}
