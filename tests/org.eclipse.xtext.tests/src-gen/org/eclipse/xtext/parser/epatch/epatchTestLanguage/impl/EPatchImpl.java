/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl;

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

import org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPatch;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.Import;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EPatch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EPatchImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EPatchImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EPatchImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EPatchImpl#getObjects <em>Objects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EPatchImpl extends MinimalEObjectImpl.Container implements EPatch
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
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<Import> imports;

  /**
   * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResources()
   * @generated
   * @ordered
   */
  protected EList<NamedResource> resources;

  /**
   * The cached value of the '{@link #getObjects() <em>Objects</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjects()
   * @generated
   * @ordered
   */
  protected EList<ObjectRef> objects;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EPatchImpl()
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
    return EpatchTestLanguagePackage.Literals.EPATCH;
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
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.EPATCH__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Import> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<Import>(Import.class, this, EpatchTestLanguagePackage.EPATCH__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NamedResource> getResources()
  {
    if (resources == null)
    {
      resources = new EObjectContainmentEList<NamedResource>(NamedResource.class, this, EpatchTestLanguagePackage.EPATCH__RESOURCES);
    }
    return resources;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ObjectRef> getObjects()
  {
    if (objects == null)
    {
      objects = new EObjectContainmentEList<ObjectRef>(ObjectRef.class, this, EpatchTestLanguagePackage.EPATCH__OBJECTS);
    }
    return objects;
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
      case EpatchTestLanguagePackage.EPATCH__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case EpatchTestLanguagePackage.EPATCH__RESOURCES:
        return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
      case EpatchTestLanguagePackage.EPATCH__OBJECTS:
        return ((InternalEList<?>)getObjects()).basicRemove(otherEnd, msgs);
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
      case EpatchTestLanguagePackage.EPATCH__NAME:
        return getName();
      case EpatchTestLanguagePackage.EPATCH__IMPORTS:
        return getImports();
      case EpatchTestLanguagePackage.EPATCH__RESOURCES:
        return getResources();
      case EpatchTestLanguagePackage.EPATCH__OBJECTS:
        return getObjects();
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
      case EpatchTestLanguagePackage.EPATCH__NAME:
        setName((String)newValue);
        return;
      case EpatchTestLanguagePackage.EPATCH__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case EpatchTestLanguagePackage.EPATCH__RESOURCES:
        getResources().clear();
        getResources().addAll((Collection<? extends NamedResource>)newValue);
        return;
      case EpatchTestLanguagePackage.EPATCH__OBJECTS:
        getObjects().clear();
        getObjects().addAll((Collection<? extends ObjectRef>)newValue);
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
      case EpatchTestLanguagePackage.EPATCH__NAME:
        setName(NAME_EDEFAULT);
        return;
      case EpatchTestLanguagePackage.EPATCH__IMPORTS:
        getImports().clear();
        return;
      case EpatchTestLanguagePackage.EPATCH__RESOURCES:
        getResources().clear();
        return;
      case EpatchTestLanguagePackage.EPATCH__OBJECTS:
        getObjects().clear();
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
      case EpatchTestLanguagePackage.EPATCH__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case EpatchTestLanguagePackage.EPATCH__IMPORTS:
        return imports != null && !imports.isEmpty();
      case EpatchTestLanguagePackage.EPATCH__RESOURCES:
        return resources != null && !resources.isEmpty();
      case EpatchTestLanguagePackage.EPATCH__OBJECTS:
        return objects != null && !objects.isEmpty();
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
    result.append(')');
    return result.toString();
  }

} //EPatchImpl
