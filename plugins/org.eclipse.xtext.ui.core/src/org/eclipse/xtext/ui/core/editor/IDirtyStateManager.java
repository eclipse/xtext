/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;


import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.resource.IExternalContentSupport.IExternalContentProvider;

import com.google.common.collect.ImmutableCollection;
import com.google.inject.Provider;

/**
 * An implementation of {@link IDirtyStateManager} can be used to register
 * a currently edited resource and listen to changes on those resources.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IDirtyStateManager extends IExternalContentSupport.IExternalContentProvider {

	/**
	 * Provide access to the one and only dirty state manager.
	 */
	IDirtyStateManager INSTANCE = new DirtyStateManager();
	
	Provider<IDirtyStateManager> PROVIDER = new Provider<IDirtyStateManager>() {
		public IDirtyStateManager get() {
			return INSTANCE;
		}
	};

	Provider<IExternalContentProvider> PROVIDER_AS_CONTENTPROVIDER = new Provider<IExternalContentProvider>() {
		public IExternalContentProvider get() {
			return INSTANCE;
		}
	};
	
	/**
	 * A listener for events raised by the dirty state manager.
	 */
	interface IDirtyStateListener {
		/**
		 * <p>The manager will call this method to announce changed
		 * resource. The collection of affected resources may be empty.
		 * None of the parameters will be <code>null</code>.
		 * </p><p>
		 * Listeners are free to remove themselves from the sender
		 * of the event or add other listeners. However added listeners
		 * will not be informed about the current change. 
		 * </p><p>This event may be fired 
		 * asynchronously from the originating call to {@link IDirtyStateManager#announceDirtyStateChanged(IDirtyResource)}
		 * or {@link IDirtyStateManager#discardDirtyState(IDirtyResource)}. 
		 * It is ensured that the changed resources will provide the content as it 
		 * was when the change has been announced to the sender of the event.
		 * </p>
		 * @param sender the sender of this event. Is never <code>null</code>.
		 * @param changedResources an immutable collection of changed resources. 
		 * Is never <code>null</code> but may be empty.
		 */
		void dirtyStateChanged(IDirtyStateManager sender, ImmutableCollection<IDirtyResource> changedResources);
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
	 * manageDirtyState has not been called before. Another dirty resources with the
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
	 */
	void announceDirtyStateChanged(IDirtyResource dirtyResource);
	
	/**
	 * Add a listener to the dirty state manager. Listeners will not be added twice.
	 * Subsequent calls to {@link #addListener(IDirtyStateListener)} will not affect the number
	 * of events that the listener receives. {@link #removeListener(IDirtyStateListener)} will
	 * remove the listener immediately independently from the number of calls to
	 * {@link #addListener(IDirtyStateListener)}.
	 * @param listener the listener to be registered. May not be <code>null</code>.
	 */
	void addListener(IDirtyStateListener listener);
	
	/**
	 * Removes a registed listener from the manager.
	 * If the listener has not been registered before, the call does nothing.
	 * @param listener the listener to be removed. May not be <code>null</code>. 
	 */
	void removeListener(IDirtyStateListener listener);
	
}
