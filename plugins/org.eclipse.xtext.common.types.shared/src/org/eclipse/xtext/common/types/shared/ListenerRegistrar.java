/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.shared;

import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.builder.impl.javasupport.JavaChangeQueueFiller;
import org.eclipse.xtext.common.types.ui.notification.TypeResourceUnloader;
import org.eclipse.xtext.ui.notification.IStateChangeEventBroker;
import org.eclipse.xtext.ui.shared.contribution.EagerContribution;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow
 * @since 2.5
 */
@SuppressWarnings("restriction")
public class ListenerRegistrar implements EagerContribution {

	@Inject
	private IStateChangeEventBroker eventBroker;

	@Inject
	private TypeResourceUnloader typeResourceUnloader;

	@Inject
	private JavaChangeQueueFiller javaChangeQueueFiller;

	public void initialize() {
		typeResourceUnloader.addListener(eventBroker);
		JavaCore.addElementChangedListener(
				typeResourceUnloader,
				ElementChangedEvent.POST_RECONCILE);

		JavaCore.addElementChangedListener(
				javaChangeQueueFiller,
				ElementChangedEvent.POST_CHANGE);
	}

	public void discard() {
		JavaCore.removeElementChangedListener(javaChangeQueueFiller);

		JavaCore.removeElementChangedListener(typeResourceUnloader);
		typeResourceUnloader.removeListener(eventBroker);
	}

}
