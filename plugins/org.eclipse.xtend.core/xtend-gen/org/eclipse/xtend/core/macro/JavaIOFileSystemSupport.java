/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import java.io.File;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.core.macro.AbstractFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaIOFileSystemSupport extends AbstractFileSystemSupport {
  @Override
  public Iterable<? extends Path> getChildren(final URI uri, final Path path) {
    java.net.URI _uRI = this.toURI(uri);
    File _file = new File(_uRI);
    String[] _list = _file.list();
    final Function1<String, Path> _function = new Function1<String, Path>() {
      @Override
      public Path apply(final String it) {
        return path.getAbsolutePath(it);
      }
    };
    return ListExtensions.<String, Path>map(((List<String>)Conversions.doWrapArray(_list)), _function);
  }
}
