/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.builder.internal.Activator;

import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GlobalResourceDescriptionsAccess {

	public static Provider<IResourceDescriptions> getDirtyResourceDescriptions() {
		return new Provider<IResourceDescriptions>() {
			public IResourceDescriptions get() {
				return Activator.getDefault().getInjector().getInstance(IResourceDescriptions.class);
			}
		};
	}
	
}
