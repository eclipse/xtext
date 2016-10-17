/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.util;

import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.util.IDisposable;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * A compound disposable that serves as a registry. Call this one at the end of the lifecycle of your injector.
 */
@Singleton
@SuppressWarnings("all")
public class DisposableRegistry implements IDisposable {
  private final List<IDisposable> disposables = CollectionLiterals.<IDisposable>newArrayList();
  
  public void register(final IDisposable disposable) {
    this.disposables.add(disposable);
  }
  
  @Override
  public void dispose() {
    for (final IDisposable d : this.disposables) {
      d.dispose();
    }
  }
}
