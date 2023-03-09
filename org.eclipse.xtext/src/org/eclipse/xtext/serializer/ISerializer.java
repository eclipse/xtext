/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
 * Using a grammar, the Serializer converts EMF models to text. This is inverse to the parser converting text into EMF
 * models.
 * 
 * For reasons of backwards compatibility, this interface is still bound to
 * {@link org.eclipse.xtext.parsetree.reconstr.Serializer}. It is recommended to bind it to
 * {@link org.eclipse.xtext.serializer.impl.Serializer} in the runtime module of your language.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.0
 */
@SuppressWarnings("deprecation")
@ImplementedBy(Serializer.class)
public interface ISerializer {
	public String serialize(EObject obj);

	public String serialize(EObject obj, SaveOptions options);

	public void serialize(EObject obj, Writer writer, SaveOptions options) throws IOException;

	public ReplaceRegion serializeReplacement(EObject obj, SaveOptions options);
}
