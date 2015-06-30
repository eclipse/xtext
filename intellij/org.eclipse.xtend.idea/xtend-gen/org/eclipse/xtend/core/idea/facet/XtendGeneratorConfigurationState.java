/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.facet;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author dhuebner - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public class XtendGeneratorConfigurationState extends GeneratorConfigurationState {
  private boolean useJavasSourcelevel;
  
  @Pure
  public boolean isUseJavasSourcelevel() {
    return this.useJavasSourcelevel;
  }
  
  public void setUseJavasSourcelevel(final boolean useJavasSourcelevel) {
    this.useJavasSourcelevel = useJavasSourcelevel;
  }
}
