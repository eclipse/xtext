/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import java.util.List;

import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IElementChangedListener;
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
	}
	
	@Override
	public void elementChanged(ElementChangedEvent event) {
		List<Delta> deltas = deltaConverter.convert(event.getDelta());
		if (deltas != null && !deltas.isEmpty()) {
			queue.queueChanges(deltas);
		}
	}

}
