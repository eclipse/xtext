/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.parser.antlr;

import com.google.inject.Singleton;
import java.io.Reader;
import org.antlr.runtime.CharStream;
import org.eclipse.xtend.core.parser.ReaderCharStream;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParserBasedTokenSourceProvider;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class XtendTokenSourceProvider extends AbstractAntlrParserBasedTokenSourceProvider {
  @Override
  protected CharStream getCharStream(final Reader reader) {
    return new ReaderCharStream(reader);
  }
}
