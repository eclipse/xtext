/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractNodeImpl.java,v 1.2 2008/06/02 13:20:56 sefftinge Exp $
 */
package org.eclipse.xtext.parsetree.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.ParsetreePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.AbstractNodeImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.AbstractNodeImpl#getGrammarElement <em>Grammar Element</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.AbstractNodeImpl#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractNodeImpl extends EObjectImpl implements AbstractNode
{
  /**
   * The cached value of the '{@link #getGrammarElement() <em>Grammar Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGrammarElement()
   * @generated
   * @ordered
   */
  protected EObject grammarElement;

  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected EObject element;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractNodeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ParsetreePackage.Literals.ABSTRACT_NODE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompositeNode getParent()
  {
    if (eContainerFeatureID != ParsetreePackage.ABSTRACT_NODE__PARENT) return null;
    return (CompositeNode)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParent(CompositeNode newParent, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newParent, ParsetreePackage.ABSTRACT_NODE__PARENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParent(CompositeNode newParent)
  {
    if (newParent != eInternalContainer() || (eContainerFeatureID != ParsetreePackage.ABSTRACT_NODE__PARENT && newParent != null))
    {
      if (EcoreUtil.isAncestor(this, newParent))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newParent != null)
        msgs = ((InternalEObject)newParent).eInverseAdd(this, ParsetreePackage.COMPOSITE_NODE__CHILDREN, CompositeNode.class, msgs);
      msgs = basicSetParent(newParent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParsetreePackage.ABSTRACT_NODE__PARENT, newParent, newParent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getGrammarElement()
  {
    if (grammarElement != null && grammarElement.eIsProxy())
    {
      InternalEObject oldGrammarElement = (InternalEObject)grammarElement;
      grammarElement = eResolveProxy(oldGrammarElement);
      if (grammarElement != oldGrammarElement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParsetreePackage.ABSTRACT_NODE__GRAMMAR_ELEMENT, oldGrammarElement, grammarElement));
      }
    }
    return grammarElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetGrammarElement()
  {
    return grammarElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGrammarElement(EObject newGrammarElement)
  {
    EObject oldGrammarElement = grammarElement;
    grammarElement = newGrammarElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParsetreePackage.ABSTRACT_NODE__GRAMMAR_ELEMENT, oldGrammarElement, grammarElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getElement()
  {
    if (element != null && element.eIsProxy())
    {
      InternalEObject oldElement = (InternalEObject)element;
      element = eResolveProxy(oldElement);
      if (element != oldElement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParsetreePackage.ABSTRACT_NODE__ELEMENT, oldElement, element));
      }
    }
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetElement()
  {
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElement(EObject newElement)
  {
    EObject oldElement = element;
    element = newElement;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParsetreePackage.ABSTRACT_NODE__ELEMENT, oldElement, element));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int length()
  {
    if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.length((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.length((LeafNodeImpl) this);} else {return ParsetreeUtil.length((AbstractNodeImpl) this);}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int offset()
  {
    if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.offset((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.offset((LeafNodeImpl) this);} else {return ParsetreeUtil.offset((AbstractNodeImpl) this);}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int line()
  {
    if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.line((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.line((LeafNodeImpl) this);} else {return ParsetreeUtil.line((AbstractNodeImpl) this);}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String serialize()
  {
    if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.serialize((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.serialize((LeafNodeImpl) this);} else {return ParsetreeUtil.serialize((AbstractNodeImpl) this);}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LeafNode> getLeafNodes()
  {
    if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.getLeafNodes((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.getLeafNodes((LeafNodeImpl) this);} else {return ParsetreeUtil.getLeafNodes((AbstractNodeImpl) this);}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LeafNode> getLeafNodes(AbstractNode to)
  {
    if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.getLeafNodes((CompositeNodeImpl) this, to);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.getLeafNodes((LeafNodeImpl) this, to);} else {return ParsetreeUtil.getLeafNodes((AbstractNodeImpl) this, to);}
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ParsetreePackage.ABSTRACT_NODE__PARENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetParent((CompositeNode)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ParsetreePackage.ABSTRACT_NODE__PARENT:
        return basicSetParent(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID)
    {
      case ParsetreePackage.ABSTRACT_NODE__PARENT:
        return eInternalContainer().eInverseRemove(this, ParsetreePackage.COMPOSITE_NODE__CHILDREN, CompositeNode.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ParsetreePackage.ABSTRACT_NODE__PARENT:
        return getParent();
      case ParsetreePackage.ABSTRACT_NODE__GRAMMAR_ELEMENT:
        if (resolve) return getGrammarElement();
        return basicGetGrammarElement();
      case ParsetreePackage.ABSTRACT_NODE__ELEMENT:
        if (resolve) return getElement();
        return basicGetElement();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ParsetreePackage.ABSTRACT_NODE__PARENT:
        setParent((CompositeNode)newValue);
        return;
      case ParsetreePackage.ABSTRACT_NODE__GRAMMAR_ELEMENT:
        setGrammarElement((EObject)newValue);
        return;
      case ParsetreePackage.ABSTRACT_NODE__ELEMENT:
        setElement((EObject)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ParsetreePackage.ABSTRACT_NODE__PARENT:
        setParent((CompositeNode)null);
        return;
      case ParsetreePackage.ABSTRACT_NODE__GRAMMAR_ELEMENT:
        setGrammarElement((EObject)null);
        return;
      case ParsetreePackage.ABSTRACT_NODE__ELEMENT:
        setElement((EObject)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ParsetreePackage.ABSTRACT_NODE__PARENT:
        return getParent() != null;
      case ParsetreePackage.ABSTRACT_NODE__GRAMMAR_ELEMENT:
        return grammarElement != null;
      case ParsetreePackage.ABSTRACT_NODE__ELEMENT:
        return element != null;
    }
    return super.eIsSet(featureID);
  }

} //AbstractNodeImpl
