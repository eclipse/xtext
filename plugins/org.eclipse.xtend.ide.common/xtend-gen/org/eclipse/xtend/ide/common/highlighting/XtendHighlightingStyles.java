/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.common.highlighting;

import org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingStyles;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public interface XtendHighlightingStyles extends XbaseHighlightingStyles {
  public final static String RICH_TEXT_ID = "xtend.richText";
  
  public final static String RICH_TEXT_DELIMITER_ID = "xtend.richText.delimiter";
  
  public final static String INSIGNIFICANT_TEMPLATE_TEXT = "xtend.insignificant.template.text";
  
  public final static String POTENTIAL_LINE_BREAK = "xtend.potential.line.break";
  
  public final static String SEMANTIC_LINE_BREAK = "xtend.template.line.break";
  
  public final static String ACTIVE_ANNOTATION = "xtend.active.annotation";
  
  public final static String SINGLE_LINE_COMMENT = "xtend.single.line.comment";
  
  public final static String MULTI_LINE_COMMENT = "xtend.multi.line.comment";
}
