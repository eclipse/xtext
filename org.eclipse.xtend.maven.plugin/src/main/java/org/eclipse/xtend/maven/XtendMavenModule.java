/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.maven;

import org.eclipse.xtend.core.XtendRuntimeModule;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

public class XtendMavenModule extends XtendRuntimeModule {

	public Class<? extends ResourceDescriptionsProvider> bindResourceDescriptionsProvider() {
		return MavenProjectAwareResourceDescriptionsProvider.class;
	}
}
