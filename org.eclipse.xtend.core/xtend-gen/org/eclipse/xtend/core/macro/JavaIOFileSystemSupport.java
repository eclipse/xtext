/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro;

import java.io.File;
import java.util.List;
import org.eclipse.emf.common.util.URI;
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
    final Function1<String, Path> _function = (String it) -> {
      return path.getAbsolutePath(it);
    };
    return ListExtensions.<String, Path>map(((List<String>)Conversions.doWrapArray(new File(_uRI).list())), _function);
  }
}
