/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.refactoring2;

import java.io.Closeable;
import org.apache.log4j.Logger;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public class TryWithResource {
  private static final Logger LOG = Logger.getLogger(TryWithResource.class);
  
  public static <T extends Object> T tryWith(final Closeable closeable, final Function0<? extends T> action) {
    T _xtrycatchfinallyexpression = null;
    try {
      _xtrycatchfinallyexpression = action.apply();
    } finally {
      try {
        closeable.close();
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable t = (Throwable)_t;
          TryWithResource.LOG.error("Error closing stream", t);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  public static void tryWith(final Closeable closeable, final Procedure0 action) {
    try {
      action.apply();
    } finally {
      try {
        closeable.close();
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable t = (Throwable)_t;
          TryWithResource.LOG.error("Error closing stream", t);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
}
