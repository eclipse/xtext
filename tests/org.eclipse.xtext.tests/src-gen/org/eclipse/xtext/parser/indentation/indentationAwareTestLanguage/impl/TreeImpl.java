/**
 */
package org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.IndentationAwareTestLanguagePackage;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.TreeImpl#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TreeImpl extends MinimalEObjectImpl.Container implements Tree
{
  /**
   * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodes()
   * @generated
   * @ordered
   */
  protected EList<TreeNode> nodes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TreeImpl()
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
    return IndentationAwareTestLanguagePackage.Literals.TREE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TreeNode> getNodes()
  {
    if (nodes == null)
    {
      nodes = new EObjectContainmentEList<TreeNode>(TreeNode.class, this, IndentationAwareTestLanguagePackage.TREE__NODES);
    }
    return nodes;
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
      case IndentationAwareTestLanguagePackage.TREE__NODES:
        return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case IndentationAwareTestLanguagePackage.TREE__NODES:
        return getNodes();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case IndentationAwareTestLanguagePackage.TREE__NODES:
        getNodes().clear();
        getNodes().addAll((Collection<? extends TreeNode>)newValue);
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
      case IndentationAwareTestLanguagePackage.TREE__NODES:
        getNodes().clear();
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
      case IndentationAwareTestLanguagePackage.TREE__NODES:
        return nodes != null && !nodes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TreeImpl
