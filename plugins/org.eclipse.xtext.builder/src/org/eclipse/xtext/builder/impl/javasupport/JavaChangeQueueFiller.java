/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import java.util.List;

import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.builder.impl.QueuedBuildData;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaChangeQueueFiller implements IElementChangedListener {

	@Inject
	private QueuedBuildData queue;

	@Inject
	private BuilderDeltaConverter deltaConverter;

	public JavaChangeQueueFiller() {
		JavaCore.addElementChangedListener(this, ElementChangedEvent.POST_CHANGE);
	}

	public void elementChanged(ElementChangedEvent event) {
		List<Delta> deltas = deltaConverter.convert(event.getDelta());
		if (deltas != null && !deltas.isEmpty()) {
			queue.queueChanges(deltas);
		}
	}

}
