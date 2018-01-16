/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import org.eclipse.xtext.resource.persistence.SerializableEObjectDescription;

/**
 * @since 2.11
 */
@SuppressWarnings("all")
public interface SerializableEObjectDescriptionProvider {
  public abstract SerializableEObjectDescription toSerializableEObjectDescription();
}
