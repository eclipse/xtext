/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.persistence;

import org.eclipse.xtext.resource.persistence.SerializableEObjectDescription;

/**
 * @since 2.11
 */
@SuppressWarnings("all")
public interface SerializableEObjectDescriptionProvider {
  SerializableEObjectDescription toSerializableEObjectDescription();
}
