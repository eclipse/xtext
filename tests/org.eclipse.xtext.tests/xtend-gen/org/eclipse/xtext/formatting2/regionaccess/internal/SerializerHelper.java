/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.regionaccess.internal;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Iterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.sequencer.IContextFinder;
import org.eclipse.xtext.serializer.sequencer.IHiddenTokenSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;

@SuppressWarnings("all")
public class SerializerHelper {
  @Inject
  private Provider<ISemanticSequencer> semanticSequencerProvider;
  
  @Inject
  private Provider<ISyntacticSequencer> syntacticSequencerProvider;
  
  @Inject
  private Provider<IHiddenTokenSequencer> hiddenTokenSequencerProvider;
  
  @Inject
  private IContextFinder contextFinder;
  
  public void serialize(final EObject semanticObject, final ISequenceAcceptor tokens) {
    final ISerializationDiagnostic.ExceptionThrowingAcceptor errors = new ISerializationDiagnostic.ExceptionThrowingAcceptor();
    Iterable<EObject> _findContextsByContentsAndContainer = this.contextFinder.findContextsByContentsAndContainer(semanticObject, null);
    Iterator<EObject> _iterator = _findContextsByContentsAndContainer.iterator();
    final EObject context = _iterator.next();
    final ISemanticSequencer semantic = this.semanticSequencerProvider.get();
    final ISyntacticSequencer syntactic = this.syntacticSequencerProvider.get();
    final IHiddenTokenSequencer hidden = this.hiddenTokenSequencerProvider.get();
    semantic.init(((ISemanticSequenceAcceptor) syntactic), errors);
    syntactic.init(context, semanticObject, ((ISyntacticSequenceAcceptor) hidden), errors);
    hidden.init(context, semanticObject, tokens, errors);
    semantic.createSequence(context, semanticObject);
  }
}
