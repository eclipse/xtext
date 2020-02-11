/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting;

import java.util.List;

import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.resource.XtextResource;

/**
 * A formatter creates a list of TextReplacements that are applicable on the XtextResource's underlying document (i.e.
 * the string that has been parsed). The TextReplacements are only allowed to replace characters for with
 * {@link Character#isWhitespace(char)} is true.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.4
 * 
 * @deprecated use {@link IFormatter2}
 */
@Deprecated
public interface IBasicFormatter {

	List<TextReplacement> format(XtextResource res, int offset, int length, FormattingPreferenceValues cfg);
}
