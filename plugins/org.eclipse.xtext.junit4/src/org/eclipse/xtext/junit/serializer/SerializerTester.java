/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit.serializer;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.StringBufferSequenceAcceptor;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.sequencer.ContextFinder;
import org.eclipse.xtext.serializer.sequencer.IHiddenTokenSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.junit.Assert;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializerTester {
	@Inject
	protected ContextFinder contextFinder;

	@Inject
	protected IFormatter formatter;

	@Inject
	protected IGrammarAccess grammar;

	@Inject
	protected Provider<IHiddenTokenSequencer> hiddenTokenSequencerProvider;

	@Inject
	protected ParseHelper<EObject> parseHelper;

	@Inject
	protected Provider<ISemanticSequencer> semanticSequencerProvider;

	@Inject
	protected ISerializer serializer;

	@Inject
	protected Provider<ISyntacticSequencer> syntacticSequencerProvider;

	@Inject
	protected ValidationTestHelper validationHelper;

	public void assertSerializeWithNodeModel(EObject semanticObject) {
		ISerializationDiagnostic.Acceptor errors = ISerializationDiagnostic.EXCEPTION_THROWING_ACCEPTOR;
		ISemanticSequencer semantic = semanticSequencerProvider.get();
		ISyntacticSequencer syntactic = syntacticSequencerProvider.get();
		IHiddenTokenSequencer hidden = hiddenTokenSequencerProvider.get();
		ISequenceAcceptor result = new StringBufferSequenceAcceptor();
		semantic.init((ISemanticSequenceAcceptor) syntactic, errors);
		EObject context = getContext(semanticObject);
		syntactic.init(context, semanticObject, (ISyntacticSequenceAcceptor) hidden, errors);
		hidden.init(context, semanticObject, new AssertNodeModelAcceptor(result), errors);
		semantic.createSequence(context, semanticObject);
		Assert.assertEquals(getTextFromNodeModel(semanticObject), result.toString());
	}

	public void assertSerializeWithNodeModel(String semanticModel) throws Exception {
		EObject semanticObject = parseHelper.parse(semanticModel);
		validationHelper.assertNoErrors(semanticObject);
		assertSerializeWithNodeModel(semanticObject);
	}

	public void assertSerializeWithoutNodeModel(EObject semanticObject) throws Exception {
		EObject parsed;
		if (semanticObject.eResource().getContents().contains(semanticObject)) {
			List<Pair<EObject, ICompositeNode>> nodes = detachNodeModel(semanticObject);
			String serialized = serializer.serialize(semanticObject);
			parsed = parseHelper.parse(serialized, semanticObject.eResource().getResourceSet());
			reattachNodes(nodes);
		} else {
			INode oldNode = NodeModelUtils.getNode(semanticObject);
			String oldtext = oldNode.getRootNode().getText();
			String oldURI = semanticObject.eResource().getURIFragment(semanticObject);
			List<Pair<EObject, ICompositeNode>> nodes = detachNodeModel(semanticObject);
			String serialized = serializer.serialize(semanticObject);
			String newtext = oldtext.substring(0, oldNode.getOffset()) + serialized
					+ oldtext.substring(oldNode.getOffset() + oldNode.getLength());
			EObject newmodel = parseHelper.parse(newtext, semanticObject.eResource().getResourceSet());
			parsed = newmodel.eResource().getEObject(oldURI);
			reattachNodes(nodes);
		}
		EcoreUtil.resolveAll(parsed);
		Assert.assertTrue(parsed.eResource().getErrors().toString(), parsed.eResource().getErrors().isEmpty());
		String expected = EmfFormatter.objToStr(semanticObject);
		String actual = EmfFormatter.objToStr(parsed);
		Assert.assertEquals(expected, actual);
	}

	public void assertSerializeWithoutNodeModel(String semanticModel) throws Exception {
		EObject semanticObject = parseHelper.parse(semanticModel);
		validationHelper.assertNoErrors(semanticObject);
		assertSerializeWithoutNodeModel(semanticObject);
	}

	protected EObject getContext(EObject semanticObject) {
		Iterable<EObject> contexts = contextFinder.findContextsByContentsAndContainer(semanticObject, null);
		if (Iterables.size(contexts) != 1) {
			StringBuilder msg = new StringBuilder();
			msg.append("One context is expected, but " + Iterables.size(contexts) + " have been found\n");
			msg.append("Contexts: " + Joiner.on(", ").join(Iterables.transform(contexts, new Context2NameFunction())));
			msg.append("Semantic Object: " + EmfFormatter.objPath(semanticObject));
			Assert.fail(msg.toString());
		}
		return contexts.iterator().next();
	}

	protected String getTextFromNodeModel(EObject semanticObject) {
		Resource res = semanticObject.eResource();
		if (res instanceof XtextResource && res.getContents().contains(semanticObject))
			return ((XtextResource) res).getParseResult().getRootNode().getText();
		INode node = NodeModelUtils.getNode(semanticObject);
		Assert.assertNotNull(node);
		return node.getText();
	}

	//	protected void removeNodeModel(EObject eObject) {
	//		Iterator<Object> iterator = EcoreUtil.getAllContents(eObject.eResource(), false);
	//		while (iterator.hasNext()) {
	//			EObject object = (EObject) iterator.next();
	//			Iterator<Adapter> adapters = object.eAdapters().iterator();
	//			while (adapters.hasNext()) {
	//				Adapter adapter = adapters.next();
	//				if (adapter instanceof ICompositeNode) {
	//					adapters.remove();
	//					break;
	//				}
	//			}
	//		}
	//	}

	protected List<Pair<EObject, ICompositeNode>> detachNodeModel(EObject eObject) {
		EcoreUtil.resolveAll(eObject);
		List<Pair<EObject, ICompositeNode>> result = Lists.newArrayList();
		Iterator<Object> iterator = EcoreUtil.getAllContents(eObject.eResource(), false);
		while (iterator.hasNext()) {
			EObject object = (EObject) iterator.next();
			Iterator<Adapter> adapters = object.eAdapters().iterator();
			while (adapters.hasNext()) {
				Adapter adapter = adapters.next();
				if (adapter instanceof ICompositeNode) {
					adapters.remove();
					result.add(Tuples.create(object, (ICompositeNode) adapter));
					break;
				}
			}
		}
		return result;
	}

	protected void reattachNodes(List<Pair<EObject, ICompositeNode>> nodes) {
		for (Pair<EObject, ICompositeNode> pair : nodes)
			pair.getFirst().eAdapters().add((Adapter) pair.getSecond());
	}

}
