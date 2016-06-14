/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.impl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.serialization.DeserializationConversionContext;
import org.eclipse.xtext.nodemodel.serialization.SerializationConversionContext;
import org.eclipse.xtext.nodemodel.serialization.SerializationUtil;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Mark Christiaens - Serialization support
 * @noextend This class is not intended to be subclassed by clients.
 */
public class CompositeNodeWithSemanticElement extends CompositeNode implements Adapter {

	private EObject semanticElement;
	
	@Override
	public EObject getSemanticElement() {
		if (semanticElement != null)
			return semanticElement;
		return super.getSemanticElement();
	}
	
	@Override
	public EObject basicGetSemanticElement() {
		return semanticElement;
	}
	
	protected void basicSetSemanticElement(EObject element) {
		this.semanticElement = element;
	}

	@Override
	public void notifyChanged(Notification notification) {
		// ignore
	}

	@Override
	public Notifier getTarget() {
		return semanticElement;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		if (newTarget == null || newTarget instanceof EObject)
			semanticElement = (EObject) newTarget;
		else
			throw new IllegalArgumentException("Notifier must be an Eobject");
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type instanceof Class<?> && INode.class.isAssignableFrom((Class<?>)type);
	}

	@Override
	void readData(DataInputStream in, DeserializationConversionContext context) throws IOException {
		super.readData(in, context);

		boolean isNull = in.readBoolean();

		if (!isNull) {
			int id = SerializationUtil.readInt(in, true);

			semanticElement = context.getSemanticObject(id);
			semanticElement.eAdapters().add(this);
		}
	}

	@Override
	void write(DataOutputStream out, SerializationConversionContext scc) throws IOException {
		super.write(out, scc);

		boolean isNull = semanticElement == null;

		out.writeBoolean(isNull);

		if (!isNull) {
			Integer id = scc.getEObjectId(semanticElement);
			SerializationUtil.writeInt(out, id, true);
		}
	}

	@Override
	NodeType getNodeId() {
		return NodeType.CompositeNodeWithSemanticElement;
	}
}
