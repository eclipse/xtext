/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.ng;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class BuilderSwitch {
  @Accessors
  private static boolean useNewCompiler = false;
  
  @Pure
  public static boolean isUseNewCompiler() {
    return BuilderSwitch.useNewCompiler;
  }
  
  public static void setUseNewCompiler(final boolean useNewCompiler) {
    BuilderSwitch.useNewCompiler = useNewCompiler;
  }
}
