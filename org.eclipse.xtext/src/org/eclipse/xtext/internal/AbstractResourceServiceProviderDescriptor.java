/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.internal;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;

/**
 * @author kosyakov - Initial contribution and API
 */
public abstract class AbstractResourceServiceProviderDescriptor implements IResourceServiceProvider.Provider {

	@Override
	public IResourceServiceProvider get(URI uri, String contentType) {
		Object extension = getExtension();
		if (extension instanceof IResourceServiceProvider.Provider) {
			IResourceServiceProvider.Provider provider = ((IResourceServiceProvider.Provider) extension);
			IResourceServiceProvider result = provider.get(uri, contentType);
			return result;
		} else if (extension instanceof IResourceServiceProvider) {
			return (IResourceServiceProvider) extension;
		}
		String type = extension == null ? "null" : extension.getClass().getName();
		String valid = IResourceServiceProvider.class + " or " + IResourceServiceProvider.Provider.class;
		String suffix = "";
		String contributor = getContributor();
		if (contributor != null) {
			suffix += " contributed by " + contributor;
		}
		throw new ClassCastException("The type " + type + " is not a valid " + valid + suffix);
	}

	protected abstract String getContributor();

	protected abstract Object getExtension();

}
