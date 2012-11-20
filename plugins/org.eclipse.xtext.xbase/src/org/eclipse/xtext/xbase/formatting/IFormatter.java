/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting;

import java.util.List;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.configuration.IConfigurationKeys;
import org.eclipse.xtext.xbase.configuration.IConfigurationValues;

/**
 * A formatter creates a list of TextReplacements that are applicable on the XtextResource's underlying document (i.e.
 * the string that has been parsed). The TextReplacements are only allowed to replace characters for with
 * {@link Character#isWhitespace(char)} is true.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IFormatter<T extends IConfigurationKeys> {

	List<TextReplacement> format(XtextResource res, int offset, int length, IConfigurationValues cfg);
}
