/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.notification;

import java.util.List;

import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescriptionChangeEventSource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent;

import com.google.inject.Inject;

/**
 * A listener that will notify the state change broker about reconcile operations
 * on java types. It converts the {@link ElementChangedEvent notifications} of the JDT
 * to {@link org.eclipse.xtext.resource.IResourceDescription.Event events} for the Xtext protocol.
 * As this will only notify  
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeResourceUnloader extends AbstractResourceDescriptionChangeEventSource implements IElementChangedListener {

	private final DeltaConverter deltaConverter;

	/**
	 * @since 2.5
	 */
	@Inject
	public TypeResourceUnloader(DeltaConverter deltaConverter) {
		this.deltaConverter = deltaConverter;
	}
	
	@Override
	public void elementChanged(ElementChangedEvent event) {
		IResourceDescription.Event resourceDescriptionEvent = getAsResourceDescriptionChange(event.getDelta());
		if (resourceDescriptionEvent != null)
			notifyListeners(resourceDescriptionEvent);
	}
	
	private IResourceDescription.Event getAsResourceDescriptionChange(IJavaElementDelta delta) {
		List<IResourceDescription.Delta> deltas = deltaConverter.convert(delta);
		if (deltas == null || deltas.isEmpty())
			return null;
		return new ResourceDescriptionChangeEvent(deltas);
	}
	
}
