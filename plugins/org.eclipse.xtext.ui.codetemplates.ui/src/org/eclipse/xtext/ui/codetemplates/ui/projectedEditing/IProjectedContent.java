/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.projectedEditing;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IProjectedContent {

	String getMappedString();

	String getOriginalString();

	int getMappedOffset(int originalOffset);

	int getOriginalOffset(int mappedOffset);

}
