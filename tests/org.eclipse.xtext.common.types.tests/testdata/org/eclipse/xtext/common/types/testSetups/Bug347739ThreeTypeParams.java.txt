/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.testSetups;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface Bug347739ThreeTypeParams<A, B, C> extends Bug347739ThreeTypeParamsSuper<A, B> {
	C getPush(A state);

	C getPop(A state);
}
