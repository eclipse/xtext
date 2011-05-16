/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit.serializer;

import java.util.Iterator;

import junit.framework.Assert;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.junit.util.ParseHelper;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.StringBufferSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.sequencer.IHiddenTokenSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializerTester {
	@Inject
	protected Provider<ISemanticSequencer> semanticSequencerProvider;

	@Inject
	protected Provider<ISyntacticSequencer> syntacticSequencerProvider;

	@Inject
	protected Provider<IHiddenTokenSequencer> hiddenTokenSequencerProvider;

	@Inject
	protected IGrammarAccess grammar;

	@Inject
	protected IFormatter formatter;

	protected void removeNodeModel(EObject eObject) {
		Iterator<Object> iterator = EcoreUtil.getAllContents(eObject.eResource(), false);
		while (iterator.hasNext()) {
			EObject object = (EObject) iterator.next();
			Iterator<Adapter> adapters = object.eAdapters().iterator();
			while (adapters.hasNext()) {
				Adapter adapter = adapters.next();
				if (adapter instanceof ICompositeNode) {
					adapters.remove();
					break;
				}
			}
		}
	}

	@Inject
	protected ParseHelper<EObject> parseHelper;

	@Inject
	protected ValidationTestHelper validationHelper;

	@Inject
	protected ISerializer serializer;

	public void assertSerializeWithoutNodeModel(String semanticModel) throws Exception {
		EObject semanticObject = parseHelper.parse(semanticModel);
		validationHelper.assertNoErrors(semanticObject);
		assertSerializeWithoutNodeModel(semanticObject);
	}

	public void assertSerializeWithNodeModel(String semanticModel) throws Exception {
		EObject semanticObject = parseHelper.parse(semanticModel);
		validationHelper.assertNoErrors(semanticObject);
		assertSerializeWithNodeModel(semanticObject);
	}

	public void assertSerializeWithoutNodeModel(EObject semanticObject) throws Exception {
		removeNodeModel(semanticObject);
		String serialized = serializer.serialize(semanticObject);
		EObject parsed = parseHelper.parse(serialized);
		EcoreUtil.resolveAll(parsed);
		String expected = EmfFormatter.objToStr(semanticObject);
		String actual = EmfFormatter.objToStr(parsed);
		Assert.assertEquals(expected, actual);
	}

	public void assertSerializeWithNodeModel(EObject semanticObject) {
		ISerializationDiagnostic.Acceptor errors = ISerializationDiagnostic.EXCEPTION_THROWING_ACCEPTOR;
		ISemanticSequencer semantic = semanticSequencerProvider.get();
		ISyntacticSequencer syntactic = syntacticSequencerProvider.get();
		IHiddenTokenSequencer hidden = hiddenTokenSequencerProvider.get();
		ISequenceAcceptor result = new StringBufferSequenceAcceptor();
		semantic.init((ISemanticSequenceAcceptor) syntactic, errors);
		EObject context = grammar.getGrammar().getRules().get(0);
		syntactic.init(context, semanticObject, (ISyntacticSequenceAcceptor) hidden, errors);
		hidden.init(context, semanticObject, new AssertNodeModelAcceptor(result), errors);
		semantic.createSequence(context, semanticObject);
		XtextResource res = (XtextResource) semanticObject.eResource();
		Assert.assertEquals(res.getParseResult().getRootNode().getText(), result.toString());
	}

}
