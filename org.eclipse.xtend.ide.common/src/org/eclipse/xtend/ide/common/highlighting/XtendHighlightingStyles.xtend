/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.common.highlighting

import org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingStyles

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
interface XtendHighlightingStyles extends XbaseHighlightingStyles {
	String RICH_TEXT_ID = "xtend.richText";
	String RICH_TEXT_DELIMITER_ID = "xtend.richText.delimiter";
	String INSIGNIFICANT_TEMPLATE_TEXT = "xtend.insignificant.template.text";
	String POTENTIAL_LINE_BREAK = "xtend.potential.line.break";
	String SEMANTIC_LINE_BREAK = "xtend.template.line.break";
	String ACTIVE_ANNOTATION = "xtend.active.annotation";
	
	String SINGLE_LINE_COMMENT = "xtend.single.line.comment";
	String MULTI_LINE_COMMENT = "xtend.multi.line.comment"
}
