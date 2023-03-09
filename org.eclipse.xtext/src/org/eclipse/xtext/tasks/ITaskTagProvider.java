/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.tasks;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.ImplementedBy;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@ImplementedBy(DefaultTaskTagProvider.class)
public interface ITaskTagProvider {
	TaskTags getTaskTags(Resource resource);
}
