/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.io.IOException;
import java.io.Writer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.0
 */
@ImplementedBy(Serializer.class)
public interface ISerializer {
	public String serialize(EObject obj);

	public String serialize(EObject obj, SaveOptions options);

	public void serialize(EObject obj, Writer writer, SaveOptions options) throws IOException;

	public ReplaceRegion serializeReplacement(EObject obj, SaveOptions options);
}
