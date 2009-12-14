/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.apache.log4j.Logger;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @deprecated use {@link SimpleLocalScopeProvider} instead.
 */
@Deprecated
public class SimpleNameScopeProvider extends SimpleLocalScopeProvider {

	static {
		Logger.getLogger(SimpleNameScopeProvider.class).warn("The SimpleNameScopeProvider is deprecated. Please change the usages to SimpleLocalScopeProvider");
	}
}
