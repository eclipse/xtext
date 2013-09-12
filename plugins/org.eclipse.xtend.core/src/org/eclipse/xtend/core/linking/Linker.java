/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.linking;

import java.util.Iterator;
import java.util.ListIterator;

import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.ImportedNamesAdapter;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticProducer;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.linking.XbaseLazyLinker;

import com.google.inject.Inject;

/**
 * Optimized lazy linker implementation for Xtend. It's based on the {@link LinkingProxyAwareResource}.
 * 
 * It also validates the concrete syntax of the cross link text.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Linker extends XbaseLazyLinker {

	@Inject
	private IValueConverterService valueConverterService;
	
	/**
	 * Xtend does not use the grammar pattern where the cross reference is defined 
	 * in a rule that did not instantiate the object.
	 */
	@Override
	protected boolean shouldCheckParentNode(INode node) {
		return false;
	}
	
	@Override
	protected void doLinkModel(final EObject model, IDiagnosticConsumer consumer) {
		final LinkingDiagnosticProducer producer = new LinkingDiagnosticProducer(consumer);
		getCache().execWithoutCacheClear((LinkingProxyAwareResource) model.eResource(), new IUnitOfWork.Void<LinkingProxyAwareResource>() {
			@Override
			public void process(LinkingProxyAwareResource state) throws Exception {
				state.clearEncodeURIs();
				clearReferences(model);
				installProxies(state, model, producer);
				TreeIterator<EObject> iterator = getAllNonDerivedContents(model);
				while (iterator.hasNext()) {
					EObject eObject = iterator.next();
					clearReferences(eObject);
					installProxies(state, eObject, producer);
				}
			}
		});
	}
	
	private TreeIterator<EObject> getAllNonDerivedContents(EObject root) {
		/*
		 * We cannot simply use root.eAllContents here since the iterator
		 * will probe for #hasNext on each invocation of #next. This is usually
		 * not a problem but with derived containment, it is an issue.
		 * The accessor of XAbstractFeatureCall#getImplicitReceiver uses #getFeature
		 * to initialize itself. This will cause the potential proxy feature
		 * to be resolved which in turn tries to access the mapped proxy URI fragments
		 * in the resource. Now these fragments are currently in the process of being
		 * updated, e.g. there may not even be enough entries. Thus #getFeature
		 * shall not be called here. Long story short, this iterator filters
		 * derived containment features.
		 */
		return new AbstractTreeIterator<EObject>(root, false) {
			private static final long serialVersionUID = 1L;

			@Override
			public Iterator<EObject> getChildren(Object object) {
				EObject eObject = (EObject) object;
				return getNonDerivedContents(eObject);
			}

		};
	}

	private Iterator<EObject> getNonDerivedContents(EObject eObject) {
		EStructuralFeature[] eStructuralFeatures = 
		  ((EClassImpl.FeatureSubsetSupplier) eObject.eClass().getEAllStructuralFeatures()).containments();

		return (eStructuralFeatures == null 
				? EContentsEList.<EObject> emptyContentsEList()
				: new EContentsEList<EObject>(eObject, eStructuralFeatures) {
					@Override
					protected ListIterator<EObject> newResolvingListIterator() {
						return new ResolvingFeatureIteratorImpl<EObject>(eObject, eStructuralFeatures) {
							@Override
							protected boolean isIncluded(EStructuralFeature eStructuralFeature) {
								return !eStructuralFeature.isDerived();
							}
						};
					}
				}).iterator();
	}
	
	@Override
	protected void beforeModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		ImportedNamesAdapter adapter = ImportedNamesAdapter.find(model.eResource());
		if (adapter!=null)
			adapter.clear();
	}

	protected void installProxies(LinkingProxyAwareResource state, EObject obj, IDiagnosticProducer producer) {
		ICompositeNode node = NodeModelUtils.getNode(obj);
		if (node == null)
			return;
		installProxies(state, obj, producer, node);
	}
	
	private void installProxies(LinkingProxyAwareResource state, EObject obj, IDiagnosticProducer producer, ICompositeNode parentNode) {
		final EClass eClass = obj.eClass();
		if (eClass.getEAllReferences().size() - eClass.getEAllContainments().size() == 0)
			return;

		for (INode node = parentNode.getFirstChild(); node != null; node = node.getNextSibling()) {
			EObject grammarElement = node.getGrammarElement();
			if (grammarElement instanceof CrossReference && hasLeafNodes(node)) {
				CrossReference xref = (CrossReference) grammarElement;
				producer.setNode(node);
				final EReference eRef = GrammarUtil.getReference(xref, eClass);
				if (eRef == null) {
					throw new IllegalStateException("Couldn't find EReference for crossreference " + grammarElement);
				}
				createAndSetProxy(state, obj, node, eRef, xref, producer);
			}
		}
	}

	@Override
	protected boolean hasLeafNodes(INode node) {
		if (node.getTotalLength() > 0)
			return true;
		if (node instanceof ICompositeNode) {
			return ((ICompositeNode) node).getLastChild() instanceof ILeafNode;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	protected void createAndSetProxy(LinkingProxyAwareResource state, EObject obj, INode node, EReference eRef, CrossReference xref, IDiagnosticProducer diagnosticProducer) {
		final EObject proxy = createProxy(state, obj, node, eRef, xref, diagnosticProducer);
		// TODO eDeliver could be set to false, here
		if (eRef.isMany()) {
			((InternalEList<EObject>) obj.eGet(eRef, false)).addUnique(proxy);
		} else {
			obj.eSet(eRef, proxy);
		}
	}
	
	protected EObject createProxy(LinkingProxyAwareResource resource, EObject obj, INode node, EReference eRef, CrossReference xref, IDiagnosticProducer diagnosticProducer) {
		final URI uri = resource.getURI();
		final URI encodedLink = uri.appendFragment("|" + resource.registerEncodedURI(obj, eRef, node));
		EClass referenceType = getProxyType(eRef.getEReferenceType());
		final EObject proxy = EcoreUtil.create(referenceType);
		((InternalEObject) proxy).eSetProxyURI(encodedLink);
		
		AbstractElement terminal = xref.getTerminal();
		if (!(terminal instanceof RuleCall)) { 
			throw new IllegalArgumentException(String.valueOf(xref));
		}
		AbstractRule rule = ((RuleCall) terminal).getRule();
		try {
			String tokenText = NodeModelUtils.getTokenText(node);
			valueConverterService.toValue(tokenText, rule.getName(), node);
		} catch(ValueConverterException e) {
			diagnosticProducer.addDiagnostic(new DiagnosticMessage(e.getMessage(), Severity.ERROR, Diagnostic.SYNTAX_DIAGNOSTIC, Strings.EMPTY_ARRAY));
		}
		
		return proxy;
	}
	
	private EClass getProxyType(EClass referenceType) {
		if (referenceType == TypesPackage.Literals.JVM_TYPE 
				|| referenceType == TypesPackage.Literals.JVM_IDENTIFIABLE_ELEMENT)
			return TypesPackage.Literals.JVM_VOID;
		if (referenceType == TypesPackage.Literals.JVM_DECLARED_TYPE)
			return TypesPackage.Literals.JVM_GENERIC_TYPE;
		return referenceType;
	}
}
