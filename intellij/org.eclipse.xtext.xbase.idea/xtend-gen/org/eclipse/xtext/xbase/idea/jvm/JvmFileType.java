/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvm;

import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.fileTypes.LanguageFileType;
import javax.swing.Icon;
import org.eclipse.xtext.xbase.idea.jvm.JvmLanguage;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmFileType extends LanguageFileType {
  public final static JvmFileType INSTANCE = new JvmFileType();
  
  private JvmFileType() {
    super(JvmLanguage.INSTANCE);
  }
  
  @Override
  public String getDefaultExtension() {
    return JavaFileType.INSTANCE.getDefaultExtension();
  }
  
  @Override
  public String getDescription() {
    return JavaFileType.INSTANCE.getDescription();
  }
  
  @Override
  public Icon getIcon() {
    return JavaFileType.INSTANCE.getIcon();
  }
  
  @Override
  public String getName() {
    return JavaFileType.INSTANCE.getName();
  }
}
