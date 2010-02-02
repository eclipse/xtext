/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.notification;

import java.util.Collection;

import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescriptionChangeEventSource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StateChangeEventBroker extends AbstractResourceDescriptionChangeEventSource implements IStateChangeEventBroker {

	public static class StateChangeEventBrokerEvent extends ResourceDescriptionChangeEvent {

		public StateChangeEventBrokerEvent(Collection<IResourceDescription.Delta> delta, IStateChangeEventBroker sender) {
			super(delta, sender);
		}

		@Override
		public IStateChangeEventBroker getSender() {
			return (IStateChangeEventBroker) super.getSender();
		}
	}
	
	public void descriptionsChanged(IResourceDescription.Event event) {
		notifyListeners(new StateChangeEventBrokerEvent(event.getDeltas(), this));
	}
	
}
