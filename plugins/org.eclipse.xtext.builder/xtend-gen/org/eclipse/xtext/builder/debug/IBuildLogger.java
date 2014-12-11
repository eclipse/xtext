/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.debug;

import com.google.inject.ImplementedBy;
import org.eclipse.xtext.builder.debug.XtextBuildConsole;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(XtextBuildConsole.Logger.class)
@SuppressWarnings("all")
public interface IBuildLogger {
  public abstract void log(final Object o);
}
