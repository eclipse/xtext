/**
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;

/**
 * @since 2.7
 * @noextend This class is not intended to be subclassed by clients.
 * @noreference This class is not intended to be referenced by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
@Beta
@SuppressWarnings("all")
public class ToStringConfiguration {
  private final boolean skipNulls;

  private final boolean singleLine;

  private final boolean hideFieldNames;

  private final boolean verbatimValues;

  public ToStringConfiguration() {
    this(false, false, false, false);
  }

  public ToStringConfiguration(final boolean skipNulls, final boolean singleLine, final boolean hideFieldNames, final boolean verbatimValues) {
    this.skipNulls = skipNulls;
    this.singleLine = singleLine;
    this.hideFieldNames = hideFieldNames;
    this.verbatimValues = verbatimValues;
  }

  public ToStringConfiguration(final AnnotationReference annotation) {
    this.skipNulls = annotation.getBooleanValue("skipNulls");
    this.singleLine = annotation.getBooleanValue("singleLine");
    this.hideFieldNames = annotation.getBooleanValue("hideFieldNames");
    this.verbatimValues = annotation.getBooleanValue("verbatimValues");
  }

  public boolean isSkipNulls() {
    return this.skipNulls;
  }

  public boolean isSingleLine() {
    return this.singleLine;
  }

  public boolean isHideFieldNames() {
    return this.hideFieldNames;
  }

  public boolean isVerbatimValues() {
    return this.verbatimValues;
  }
}
