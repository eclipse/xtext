/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @deprecated use {@link org.eclipse.xtext.util.MergeableManifest} instead
 */
@Deprecated
public class MergeableManifest extends org.eclipse.xtext.util.MergeableManifest {

	public MergeableManifest(InputStream in) throws IOException {
		super(in);
	}

	public MergeableManifest(InputStream in, String projectName) throws IOException {
		super(in, projectName);
	}

	public class OrderAwareAttributes extends org.eclipse.xtext.util.MergeableManifest.OrderAwareAttributes {}
}
