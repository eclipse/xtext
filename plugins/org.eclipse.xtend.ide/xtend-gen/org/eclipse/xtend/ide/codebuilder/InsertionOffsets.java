/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
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
@NonNullByDefault
@SuppressWarnings("all")
public class InsertionOffsets {
  public int getNewTypeInsertOffset(@Nullable final EObject call, final XtendTypeDeclaration ownerType) {
    return this.after(ownerType);
  }
  
  public int getNewFieldInsertOffset(@Nullable final EObject call, final XtendTypeDeclaration ownerType) {
    EList<XtendMember> _members = ownerType.getMembers();
    boolean _isEmpty = _members.isEmpty();
    if (_isEmpty) {
      return this.inEmpty(ownerType);
    }
    EList<XtendMember> _members_1 = ownerType.getMembers();
    Iterable<XtendField> _filter = Iterables.<XtendField>filter(_members_1, XtendField.class);
    final XtendField lastDefinedField = IterableExtensions.<XtendField>last(_filter);
    boolean _equals = Objects.equal(lastDefinedField, null);
    if (_equals) {
      EList<XtendMember> _members_2 = ownerType.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members_2);
      return this.before(_head);
    } else {
      return this.after(lastDefinedField);
    }
  }
  
  public int getNewMethodInsertOffset(@Nullable final EObject call, final XtendTypeDeclaration ownerType) {
    final XtendMember callingMember = EcoreUtil2.<XtendMember>getContainerOfType(call, XtendMember.class);
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(callingMember, null));
    if (!_notEquals) {
      _and = false;
    } else {
      EList<XtendMember> _members = ownerType.getMembers();
      boolean _contains = _members.contains(callingMember);
      _and = _contains;
    }
    if (_and) {
      return this.after(callingMember);
    } else {
      EList<XtendMember> _members_1 = ownerType.getMembers();
      boolean _isEmpty = _members_1.isEmpty();
      if (_isEmpty) {
        return this.inEmpty(ownerType);
      } else {
        EList<XtendMember> _members_2 = ownerType.getMembers();
        XtendMember _last = IterableExtensions.<XtendMember>last(_members_2);
        return this.after(_last);
      }
    }
  }
  
  public int getNewConstructorInsertOffset(@Nullable final EObject call, final XtendTypeDeclaration ownerType) {
    EList<XtendMember> _members = ownerType.getMembers();
    Iterable<XtendConstructor> _filter = Iterables.<XtendConstructor>filter(_members, XtendConstructor.class);
    final XtendConstructor lastDefinedConstructor = IterableExtensions.<XtendConstructor>last(_filter);
    boolean _equals = Objects.equal(lastDefinedConstructor, null);
    if (_equals) {
      return this.getNewFieldInsertOffset(call, ownerType);
    } else {
      return this.after(lastDefinedConstructor);
    }
  }
  
  protected int before(final EObject element) {
    ICompositeNode _findActualNodeFor = NodeModelUtils.findActualNodeFor(element);
    return _findActualNodeFor.getOffset();
  }
  
  protected int after(final EObject element) {
    int _xblockexpression = (int) 0;
    {
      final ICompositeNode node = NodeModelUtils.findActualNodeFor(element);
      _xblockexpression = (node.getEndOffset());
    }
    return _xblockexpression;
  }
  
  protected int inEmpty(final XtendTypeDeclaration ownerType) {
    int _xblockexpression = (int) 0;
    {
      final ICompositeNode classNode = NodeModelUtils.findActualNodeFor(ownerType);
      Iterable<ILeafNode> _leafNodes = classNode.getLeafNodes();
      final Function1<ILeafNode,Boolean> _function = new Function1<ILeafNode,Boolean>() {
        public Boolean apply(final ILeafNode it) {
          String _text = it.getText();
          return Boolean.valueOf(Objects.equal(_text, "{"));
        }
      };
      final ILeafNode openingBraceNode = IterableExtensions.<ILeafNode>findFirst(_leafNodes, _function);
      int _xifexpression = (int) 0;
      boolean _notEquals = (!Objects.equal(openingBraceNode, null));
      if (_notEquals) {
        int _offset = openingBraceNode.getOffset();
        _xifexpression = (_offset + 1);
      } else {
        _xifexpression = classNode.getEndOffset();
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
}
