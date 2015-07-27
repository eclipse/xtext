/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.javaconverter;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.xtend.core.javaconverter.JavaConverter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaJavaConverter extends JavaConverter {
  @Override
  protected void provideCustomEnvironment(final ASTParser parser) {
    final ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
    URL[] _uRLs = ((URLClassLoader) sysClassLoader).getURLs();
    final Function1<URL, String> _function = new Function1<URL, String>() {
      @Override
      public String apply(final URL it) {
        return it.getFile();
      }
    };
    final List<String> cpEntries = ListExtensions.<URL, String>map(((List<URL>)Conversions.doWrapArray(_uRLs)), _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("|");
    _builder.newLine();
    String _join = IterableExtensions.join(cpEntries, _builder);
    InputOutput.<String>println(_join);
    parser.setEnvironment(null, null, null, false);
  }
}
