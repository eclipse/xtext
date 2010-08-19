/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import org.eclipse.osgi.util.NLS;

/**
 * @author koehnlein - Initial contribution and API
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.xtext.builder.builderState.messages"; //$NON-NLS-1$
	public static String AbstractBuilderState_0;
	public static String MarkerUpdaterImpl_ValidateResources;
	public static String PersistableResourceDescriptionsImpl_of;
	public static String PersistableResourceDescriptionsImpl_UpdateResourceDescription;
	public static String PersistableResourceDescriptionsImpl_UpdateResourceDescriptions;
	public static String ResourceDescriptionsUpdater_CleanResources;
	public static String ResourceDescriptionsUpdater_FindAffectedResources;
	public static String ResourceDescriptionsUpdater_LoadingAffectedResources;
	public static String ResourceDescriptionsUpdater_of;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
