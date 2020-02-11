/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.serializer;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.DelegatingSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.StringBufferSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.WhitespaceAddingSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.sequencer.ContextFinder;
import org.eclipse.xtext.serializer.sequencer.IHiddenTokenSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializerTestHelper {
	@Inject
	protected ContextFinder contextFinder;

	@Inject
	protected Provider<IHiddenTokenSequencer> hiddenTokenSequencerProvider;

	@Inject
	protected ParseHelper<EObject> parseHelper;

	@Inject
	protected Provider<ISemanticSequencer> semanticSequencerProvider;

	@Inject
	protected Provider<ISyntacticSequencer> syntacticSequencerProvider;

	@Inject
	protected ValidationTestHelper validationHelper;

	protected void assertEqualWithEmfFormatter(EObject semanticObject, EObject parsed) {
		String expected = EmfFormatter.objToStr(semanticObject);
		String actual = EmfFormatter.objToStr(parsed);
		Assert.assertEquals(expected, actual);
	}

	public void assertSerializable(EObject semanticObject) {
		assertSerializeWithNodeModel(semanticObject);
		assertSerializeWithoutNodeModel(semanticObject);
	}

	public void assertSerializable(String semanticObject) {
		assertSerializeWithNodeModel(semanticObject);
		assertSerializeWithoutNodeModel(semanticObject);
	}

	public void assertSerializeWithNodeModel(EObject semanticObject) {
		String expected = getTextFromNodeModel(semanticObject);
		String actual = serializeWithNodeModel(semanticObject);
		Assert.assertEquals(expected, actual);
	}

	public void assertSerializeWithNodeModel(String semanticModel) {
		try {
			EObject semanticObject = parseHelper.parse(semanticModel);
			validationHelper.assertNoErrors(semanticObject);
			assertSerializeWithNodeModel(semanticObject);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void assertSerializeWithoutNodeModel(EObject semanticObject) {
		try {
			EObject parsed;
			if (semanticObject.eResource().getContents().contains(semanticObject)) {
				List<Pair<EObject, ICompositeNode>> nodes = detachNodeModel(semanticObject);
				String serialized = serializeWithoutNodeModel(semanticObject);
				parsed = parseHelper.parse(serialized, semanticObject.eResource().getResourceSet());
				reattachNodes(nodes);
			} else {
				INode oldNode = NodeModelUtils.getNode(semanticObject);
				String oldtext = oldNode.getRootNode().getText();
				String oldURI = semanticObject.eResource().getURIFragment(semanticObject);
				List<Pair<EObject, ICompositeNode>> nodes = detachNodeModel(semanticObject);
				String serialized = serializeWithoutNodeModel(semanticObject);

				ITextRegion oldRegion = oldNode.getTextRegion();
				String newtext = oldtext.substring(0, oldRegion.getOffset()) + serialized
						+ oldtext.substring(oldRegion.getOffset() + oldRegion.getLength());
				EObject newmodel = parseHelper.parse(newtext, semanticObject.eResource().getResourceSet());
				parsed = newmodel.eResource().getEObject(oldURI);
				reattachNodes(nodes);
			}
			EcoreUtil.resolveAll(parsed);
			Assert.assertTrue(parsed.eResource().getErrors().toString(), parsed.eResource().getErrors().isEmpty());
			parsed.eResource().getResourceSet().getResources().remove(parsed.eResource());
			assertEqualWithEmfFormatter(semanticObject, parsed);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void assertSerializeWithoutNodeModel(String semanticModel) {
		EObject semanticObject;
		try {
			semanticObject = parseHelper.parse(semanticModel);
			validationHelper.assertNoErrors(semanticObject);
			assertSerializeWithoutNodeModel(semanticObject);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

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

	protected ISerializationContext getContext(EObject semanticObject) {
		Iterable<ISerializationContext> contexts = contextFinder.findByContentsAndContainer(semanticObject, null);
		if (Iterables.size(contexts) != 1) {
			StringBuilder msg = new StringBuilder();
			msg.append("One context is expected, but " + Iterables.size(contexts) + " have been found\n");
			msg.append("Contexts: " + Joiner.on(", ").join(contexts));
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

	protected void reattachNodes(List<Pair<EObject, ICompositeNode>> nodes) {
		for (Pair<EObject, ICompositeNode> pair : nodes)
			pair.getFirst().eAdapters().add((Adapter) pair.getSecond());
	}

	protected String serialize(EObject semanticObject, DelegatingSequenceAcceptor... acceptors) {
		ISequenceAcceptor debug = null;
		try {
			ISerializationDiagnostic.Acceptor errors = ISerializationDiagnostic.EXCEPTION_THROWING_ACCEPTOR;
			ISemanticSequencer semantic = semanticSequencerProvider.get();
			ISyntacticSequencer syntactic = syntacticSequencerProvider.get();
			IHiddenTokenSequencer hidden = hiddenTokenSequencerProvider.get();
			ISequenceAcceptor result = new StringBufferSequenceAcceptor();
			ISequenceAcceptor out = result;
			for (DelegatingSequenceAcceptor delegate : acceptors) {
				delegate.setDelegate(out);
				out = delegate;
			}
			out = debug = new DebugSequenceAcceptor(out);
			semantic.init((ISemanticSequenceAcceptor) syntactic, errors);
			ISerializationContext context = getContext(semanticObject);
			syntactic.init(context, semanticObject, (ISyntacticSequenceAcceptor) hidden, errors);
			hidden.init(context, semanticObject, out, errors);
			semantic.createSequence(context, semanticObject);
			return result.toString();
		} catch (Exception t) {
			if (debug != null) {
				System.out.println("Serializer debug output:");
				System.out.println(debug.toString());
			}
			Exceptions.sneakyThrow(t);
			return "";
		}
	}

	protected String serializeWithNodeModel(EObject semanticObject) {
		return serialize(semanticObject, new AssertStructureAcceptor(), new AssertNodeModelAcceptor());
	}

	protected String serializeWithoutNodeModel(EObject semanticObject) {
		return serialize(semanticObject, new WhitespaceAddingSequenceAcceptor(), new AssertStructureAcceptor());
	}

}
