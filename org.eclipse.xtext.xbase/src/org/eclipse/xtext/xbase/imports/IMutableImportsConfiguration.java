/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.imports;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xtype.XImportSection;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public interface IMutableImportsConfiguration extends IImportsConfiguration {
	
	void setImportSection(XtextResource resource, XImportSection importSection);

}
