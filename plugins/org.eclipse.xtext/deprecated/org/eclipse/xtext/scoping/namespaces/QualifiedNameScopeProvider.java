/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.namespaces;

import org.apache.log4j.Logger;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @deprecated use {@link ImportedNamespaceAwareLocalScopeProvider} instead.
 */
@Deprecated
public class QualifiedNameScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {

	static {
		Logger.getLogger(QualifiedNameScopeProvider.class).warn(
			"The QualifiedNameScopeProvider is deprecated. Please change the usages to ImportedNamespaceAwareLocalScopeProvider");
	}
}
