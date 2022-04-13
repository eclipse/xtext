/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.common.highlighting;

import org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingStyles;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public interface XtendHighlightingStyles extends XbaseHighlightingStyles {
  static final String RICH_TEXT_ID = "xtend.richText";

  static final String RICH_TEXT_DELIMITER_ID = "xtend.richText.delimiter";

  static final String INSIGNIFICANT_TEMPLATE_TEXT = "xtend.insignificant.template.text";

  static final String POTENTIAL_LINE_BREAK = "xtend.potential.line.break";

  static final String SEMANTIC_LINE_BREAK = "xtend.template.line.break";

  static final String ACTIVE_ANNOTATION = "xtend.active.annotation";

  static final String SINGLE_LINE_COMMENT = "xtend.single.line.comment";

  static final String MULTI_LINE_COMMENT = "xtend.multi.line.comment";
}
