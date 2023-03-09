/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent;

/**
 * An implementation of {@link IDirtyStateManager} can be used to register
 * a currently edited resource and listen to changes on those resources.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IDirtyStateManager extends ISelectable, IExternalContentSupport.IExternalContentProvider, IResourceDescription.Event.Source {

	/**
	 * The {@link IDirtyStateManager} will raise specialized events that provide
	 * direct type-safe access to the source as {@link IDirtyStateManager}.
	 * @author Sebastian Zarnekow - Initial contribution and API
	 * @deprecated No longer used. {@link ResourceDescriptionChangeEvent}s are fired instead.
	 */
	@Deprecated
	interface Event extends IResourceDescription.Event {
		
		/**
		 * The sender is guaranteed to be of type {@link IDirtyStateManager}.
		 */
		IDirtyStateManager getSender();
	}
	
	/**
	 * Initially try to manage the given resource and its dirty state.
	 * <code>True</code> will be returned, if the resource with the given URI
	 * was not managed before. However clients are free to call 
	 * {@link #announceDirtyStateChanged(IDirtyResource)} even if <code>false</code> was
	 * returned. A call to {@link #manageDirtyState(IDirtyResource)} does not raise any events. 
	 * @return <code>true</code> if this resource is the first one that has been registered
	 * for its {@link org.eclipse.emf.common.util.URI}
	 */
	boolean manageDirtyState(IDirtyResource dirtyResource);
	
	/**
	 * Mark the given dirty resource as unmanaged. This method may be called even if
	 * manageDirtyState has not been called before. Another dirty resource with the
	 * same {@link URI} will not become unmanaged. A call to this method will raise an event.
	 * @see #announceDirtyStateChanged(IDirtyResource)
	 */
	void discardDirtyState(IDirtyResource dirtyResource);
	
	/**
	 * Announce the dirty state of the given resource. Clients should decide on their own when
	 * to call this method. The dirty state manager will not refuse any announcement
	 * due to incorrect internal state of the resource.
	 * Listeners will be notified about the changed dirty state. It is up to the implementor
	 * to decide about the actual point in time. Implementations are free to collect
	 * various announcement before actually raising an event. Events may be fired in a different
	 * thread.
	 * If there is no {@link #manageDirtyState(IDirtyResource) managed} resource in the 
	 * state manager, the change will be refused and no change will be announced.
	 */
	void announceDirtyStateChanged(IDirtyResource dirtyResource);
	
	IResourceDescription getDirtyResourceDescription(URI uri);
	
}
