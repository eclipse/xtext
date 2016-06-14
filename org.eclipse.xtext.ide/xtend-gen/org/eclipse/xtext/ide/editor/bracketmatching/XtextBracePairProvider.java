/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.bracketmatching;

import com.google.inject.Singleton;
import java.util.Collections;
import org.eclipse.xtext.ide.editor.bracketmatching.BracePair;
import org.eclipse.xtext.ide.editor.bracketmatching.DefaultBracePairProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class XtextBracePairProvider extends DefaultBracePairProvider {
  public XtextBracePairProvider() {
    super(
      Collections.<BracePair>unmodifiableSet(CollectionLiterals.<BracePair>newHashSet(new BracePair(":", ";", true), new BracePair("(", ")", false), new BracePair("{", "}", true), new BracePair("[", "]", false))));
  }
}
