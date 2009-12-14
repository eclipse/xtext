/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.namespaces;

import org.apache.log4j.Logger;
import org.eclipse.xtext.resource.IQualifiedNameProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @deprecated use {@link org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider} instead.
 */
@Deprecated
public class DefaultDeclarativeQualifiedNameProvider extends
		org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider implements IQualifiedNameProvider {

	static {
		Logger.getLogger(DefaultDeclarativeQualifiedNameProvider.class).warn(
				"The DefaultDeclarativeQualifiedNameProvider is deprecated. Please change the usages to org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider");
	}
}
