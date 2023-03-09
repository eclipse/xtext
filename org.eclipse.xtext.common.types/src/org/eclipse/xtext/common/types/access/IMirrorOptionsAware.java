/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import java.util.Map;

/**
 * A mirror that wants to explore the load options during initialization may implement this interface.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.7
 */
public interface IMirrorOptionsAware extends IMirror {
	void initialize(TypeResource typeResource, Map<?, ?> options);
}