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
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class JavaChangeQueueFiller implements IElementChangedListener {

	private QueuedBuildData queue;

	private BuilderDeltaConverter deltaConverter;

	@Inject
	public JavaChangeQueueFiller(QueuedBuildData queue, BuilderDeltaConverter deltaConverter) {
		this.queue = queue;
		this.deltaConverter = deltaConverter;
		JavaCore.addElementChangedListener(this, ElementChangedEvent.POST_CHANGE);
	}
	
	public void discard() {
		JavaCore.removeElementChangedListener(this);
	}

	public void elementChanged(ElementChangedEvent event) {
		List<Delta> deltas = deltaConverter.convert(event.getDelta());
		if (deltas != null && !deltas.isEmpty()) {
			queue.queueChanges(deltas);
		}
	}

}
