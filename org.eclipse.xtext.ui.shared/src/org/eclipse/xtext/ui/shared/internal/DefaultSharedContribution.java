/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import org.eclipse.xtext.builder.DerivedResourceMarkers;
import org.eclipse.xtext.builder.impl.ClosedProjectsQueue;
import org.eclipse.xtext.builder.impl.ProjectOpenedOrClosedListener;
import org.eclipse.xtext.ui.containers.WorkspaceProjectsState;
import org.eclipse.xtext.ui.generator.IDerivedResourceMarkers;
import org.eclipse.xtext.ui.generator.trace.DerivedResourceMarkerBasedOpenerContributor;
import org.eclipse.xtext.ui.generator.trace.OppositeFileOpenerContributor;
import org.eclipse.xtext.ui.generator.trace.TraceBasedOpenerContributor;
import org.eclipse.xtext.ui.generator.trace.TraceOrMarkerBasedOpenerContributor;
import org.eclipse.xtext.ui.shared.contribution.IEagerContribution;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultSharedContribution implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(ProjectOpenedOrClosedListener.class);
		binder.bind(ClosedProjectsQueue.class);
		binder.bind(IEagerContribution.class).to(ListenerRegistrar.class);
		binder.bind(WorkspaceProjectsState.class);
		binder.bind(TraceBasedOpenerContributor.class);
		binder.bind(DerivedResourceMarkerBasedOpenerContributor.class);
		binder.bind(DerivedResourceMarkers.GeneratorIdProvider.class);
		binder.bind(IDerivedResourceMarkers.class).to(DerivedResourceMarkers.class);
		binder.bind(OppositeFileOpenerContributor.class).to(TraceOrMarkerBasedOpenerContributor.class);
	}

}
