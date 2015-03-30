/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvm;

import com.intellij.lang.Language;
import com.intellij.lang.java.JavaLanguage;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmLanguage extends Language {
  public final static JvmLanguage INSTANCE = new JvmLanguage();
  
  private JvmLanguage() {
    super(JavaLanguage.INSTANCE, "org.eclipse.xtext.jvm.JVM");
  }
}
