/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

/**
 * @since 2.23
 */
@Beta
@GwtCompatible
@SuppressWarnings("all")
public enum AccessorsDeprecationPolicy {
  SAME_AS_FIELD,

  ONLY_GETTER,

  ONLY_SETTER,

  ALWAYS,

  NEVER;
}
