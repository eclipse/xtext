/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.lang;

import com.intellij.lang.LanguageExtension;
import org.eclipse.xtext.ISetup;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class LanguageSetup extends LanguageExtension<ISetup> {
  public final static LanguageSetup INSTANCE = new LanguageSetup();
  
  public LanguageSetup() {
    super("org.eclipse.xtext.idea.lang.setup");
  }
}
