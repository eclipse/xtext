/**
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.example.domainmodel.serializer.AbstractDomainmodelSyntacticSequencer;
import org.eclipse.xtext.nodemodel.INode;

@SuppressWarnings("all")
public class DomainmodelSyntacticSequencer extends AbstractDomainmodelSyntacticSequencer {
  @Override
  protected String getArrayBracketsToken(final EObject semanticObject, final RuleCall ruleCall, final INode node) {
    if ((node != null)) {
      return this.getTokenText(node);
    }
    return "[]";
  }
}
