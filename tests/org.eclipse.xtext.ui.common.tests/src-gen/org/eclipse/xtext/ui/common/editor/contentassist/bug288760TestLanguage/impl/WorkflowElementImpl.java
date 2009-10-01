/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug288760TestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.common.editor.contentassist.bug288760TestLanguage.Attribute;
import org.eclipse.xtext.ui.common.editor.contentassist.bug288760TestLanguage.Bug288760TestLanguagePackage;
import org.eclipse.xtext.ui.common.editor.contentassist.bug288760TestLanguage.WorkflowElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workflow Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288760TestLanguage.impl.WorkflowElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288760TestLanguage.impl.WorkflowElementImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288760TestLanguage.impl.WorkflowElementImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288760TestLanguage.impl.WorkflowElementImpl#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkflowElementImpl extends MinimalEObjectImpl.Container implements WorkflowElement
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<Attribute> attributes;

  /**
   * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChildren()
   * @generated
   * @ordered
   */
  protected EList<WorkflowElement> children;

  /**
   * The default value of the '{@link #getEnd() <em>End</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnd()
   * @generated
   * @ordered
   */
  protected static final String END_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEnd() <em>End</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnd()
   * @generated
   * @ordered
   */
  protected String end = END_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WorkflowElementImpl()
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
    return Bug288760TestLanguagePackage.Literals.WORKFLOW_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Attribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__ATTRIBUTES);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<WorkflowElement> getChildren()
  {
    if (children == null)
    {
      children = new EObjectContainmentEList<WorkflowElement>(WorkflowElement.class, this, Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__CHILDREN);
    }
    return children;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEnd()
  {
    return end;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnd(String newEnd)
  {
    String oldEnd = end;
    end = newEnd;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__END, oldEnd, end));
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
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__CHILDREN:
        return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__NAME:
        return getName();
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__ATTRIBUTES:
        return getAttributes();
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__CHILDREN:
        return getChildren();
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__END:
        return getEnd();
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
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__NAME:
        setName((String)newValue);
        return;
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends Attribute>)newValue);
        return;
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__CHILDREN:
        getChildren().clear();
        getChildren().addAll((Collection<? extends WorkflowElement>)newValue);
        return;
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__END:
        setEnd((String)newValue);
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
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__ATTRIBUTES:
        getAttributes().clear();
        return;
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__CHILDREN:
        getChildren().clear();
        return;
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__END:
        setEnd(END_EDEFAULT);
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
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__CHILDREN:
        return children != null && !children.isEmpty();
      case Bug288760TestLanguagePackage.WORKFLOW_ELEMENT__END:
        return END_EDEFAULT == null ? end != null : !END_EDEFAULT.equals(end);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", end: ");
    result.append(end);
    result.append(')');
    return result.toString();
  }

} //WorkflowElementImpl
