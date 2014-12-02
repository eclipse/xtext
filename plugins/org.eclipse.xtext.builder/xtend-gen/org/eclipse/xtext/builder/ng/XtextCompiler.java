/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.ng;

import java.util.List;
import org.eclipse.xtext.builder.ng.CompilationRequest;
import org.eclipse.xtext.builder.ng.debug.XtextCompilerConsole;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextCompiler {
  public List<IResourceDescription.Delta> compile(final CompilationRequest compilationRequest) {
    List<IResourceDescription.Delta> _xblockexpression = null;
    {
      XtextCompilerConsole.log(compilationRequest);
      _xblockexpression = CollectionLiterals.<IResourceDescription.Delta>emptyList();
    }
    return _xblockexpression;
  }
}
