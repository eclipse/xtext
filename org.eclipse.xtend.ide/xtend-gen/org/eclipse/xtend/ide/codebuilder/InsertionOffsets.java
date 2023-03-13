/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Calculates where to insert new members into exisitng Xtend code.
 * 
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public class InsertionOffsets {
  public int getNewTypeInsertOffset(final EObject call, final XtendTypeDeclaration ownerType) {
    return this.after(ownerType);
  }

  public int getNewFieldInsertOffset(final EObject call, final XtendTypeDeclaration ownerType) {
    boolean _isEmpty = ownerType.getMembers().isEmpty();
    if (_isEmpty) {
      return this.inEmpty(ownerType);
    }
    final XtendField callingMember = EcoreUtil2.<XtendField>getContainerOfType(call, XtendField.class);
    if (((callingMember != null) && ownerType.getMembers().contains(callingMember))) {
      return this.before(callingMember);
    }
    final XtendField lastDefinedField = IterableExtensions.<XtendField>last(Iterables.<XtendField>filter(ownerType.getMembers(), XtendField.class));
    if ((lastDefinedField == null)) {
      return this.before(IterableExtensions.<XtendMember>head(ownerType.getMembers()));
    } else {
      return this.after(lastDefinedField);
    }
  }

  public int getNewMethodInsertOffset(final EObject call, final XtendTypeDeclaration ownerType) {
    final XtendMember callingMember = EcoreUtil2.<XtendMember>getContainerOfType(call, XtendMember.class);
    if (((callingMember != null) && ownerType.getMembers().contains(callingMember))) {
      return this.after(callingMember);
    } else {
      boolean _isEmpty = ownerType.getMembers().isEmpty();
      if (_isEmpty) {
        return this.inEmpty(ownerType);
      } else {
        return this.after(IterableExtensions.<XtendMember>last(ownerType.getMembers()));
      }
    }
  }

  public int getNewConstructorInsertOffset(final EObject call, final XtendTypeDeclaration ownerType) {
    final XtendConstructor lastDefinedConstructor = IterableExtensions.<XtendConstructor>last(Iterables.<XtendConstructor>filter(ownerType.getMembers(), XtendConstructor.class));
    if ((lastDefinedConstructor == null)) {
      return this.getNewFieldInsertOffset(call, ownerType);
    } else {
      return this.after(lastDefinedConstructor);
    }
  }

  protected int before(final EObject element) {
    return NodeModelUtils.findActualNodeFor(element).getOffset();
  }

  protected int after(final EObject element) {
    int _xblockexpression = (int) 0;
    {
      final ICompositeNode node = NodeModelUtils.findActualNodeFor(element);
      _xblockexpression = node.getEndOffset();
    }
    return _xblockexpression;
  }

  protected int inEmpty(final XtendTypeDeclaration ownerType) {
    int _xblockexpression = (int) 0;
    {
      final ICompositeNode classNode = NodeModelUtils.findActualNodeFor(ownerType);
      final Function1<ILeafNode, Boolean> _function = (ILeafNode it) -> {
        String _text = it.getText();
        return Boolean.valueOf(Objects.equal(_text, "{"));
      };
      final ILeafNode openingBraceNode = IterableExtensions.<ILeafNode>findFirst(classNode.getLeafNodes(), _function);
      int _xifexpression = (int) 0;
      if ((openingBraceNode != null)) {
        int _offset = openingBraceNode.getOffset();
        _xifexpression = (_offset + 1);
      } else {
        _xifexpression = classNode.getEndOffset();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
