/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import java.util.List;
import org.eclipse.xtext.resource.IResourceDescription;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public interface BuildListener {
  public abstract void afterBuild(final List<IResourceDescription.Delta> deltas);
}
