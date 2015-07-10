/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.highlighting;

import com.google.inject.Inject;
import com.intellij.application.options.colors.InspectionColorSettingsPage;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.psi.codeStyle.DisplayPriority;
import com.intellij.psi.codeStyle.DisplayPrioritySortable;
import java.util.Map;
import javax.swing.Icon;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.Icons;
import org.eclipse.xtext.idea.highlighting.IdeaHighlightingAttributesProvider;
import org.eclipse.xtext.xbase.lib.Conversions;

/**
 * @author dhubner - Initial contribution and API
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public abstract class AbstractColorSettingsPage implements ColorSettingsPage, InspectionColorSettingsPage, DisplayPrioritySortable {
  @Inject
  private SyntaxHighlighter highlighter;
  
  @Inject
  private IdeaHighlightingAttributesProvider textAttributeProvider;
  
  @Override
  public AttributesDescriptor[] getAttributeDescriptors() {
    return ((AttributesDescriptor[])Conversions.unwrapArray(this.textAttributeProvider.getAttributesDescriptors(), AttributesDescriptor.class));
  }
  
  @Override
  public SyntaxHighlighter getHighlighter() {
    return this.highlighter;
  }
  
  @Override
  public String getDemoText() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// change this text in the ColorSettingsPage");
    _builder.newLine();
    _builder.append("// of your language. See getDemoText() method");
    _builder.newLine();
    _builder.newLine();
    _builder.append("abcdefghijklmnopqrstuvwxyz 0123456789 (){}[]");
    _builder.newLine();
    _builder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ +-*/= .,;:!? #&$%@|^");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Styles:");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("result = \"text, text, text\";");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("i = 5");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("return i;");
    _builder.newLine();
    return _builder.toString();
  }
  
  @Override
  public abstract String getDisplayName();
  
  @Override
  public ColorDescriptor[] getColorDescriptors() {
    return ColorDescriptor.EMPTY_ARRAY;
  }
  
  @Override
  public Icon getIcon() {
    return Icons.DSL_FILE_TYPE;
  }
  
  @Override
  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return this.textAttributeProvider.getXtextStyle2TextAttributes();
  }
  
  @Override
  public DisplayPriority getPriority() {
    return DisplayPriority.LANGUAGE_SETTINGS;
  }
}
