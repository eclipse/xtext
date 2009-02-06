/**
 * <copyright>
 * </copyright>
 *
 * $Id: GrammarImpl.java,v 1.1 2009/02/06 09:46:50 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.AbstractMetamodelDeclaration;
import org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.AbstractRule;
import org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Grammar;
import org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.XtextTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grammar</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.impl.GrammarImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.impl.GrammarImpl#getIdElements <em>Id Elements</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.impl.GrammarImpl#getSuperGrammarIdElements <em>Super Grammar Id Elements</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.impl.GrammarImpl#getMetamodelDeclarations <em>Metamodel Declarations</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.impl.GrammarImpl#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GrammarImpl extends EObjectImpl implements Grammar
{
  /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected static final boolean ABSTRACT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
  protected boolean abstract_ = ABSTRACT_EDEFAULT;

  /**
   * The cached value of the '{@link #getIdElements() <em>Id Elements</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdElements()
   * @generated
   * @ordered
   */
  protected EList<String> idElements;

  /**
   * The cached value of the '{@link #getSuperGrammarIdElements() <em>Super Grammar Id Elements</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperGrammarIdElements()
   * @generated
   * @ordered
   */
  protected EList<String> superGrammarIdElements;

  /**
   * The cached value of the '{@link #getMetamodelDeclarations() <em>Metamodel Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodelDeclarations()
   * @generated
   * @ordered
   */
  protected EList<AbstractMetamodelDeclaration> metamodelDeclarations;

  /**
   * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRules()
   * @generated
   * @ordered
   */
  protected EList<AbstractRule> rules;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GrammarImpl()
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
    return XtextTestPackage.Literals.GRAMMAR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAbstract()
  {
    return abstract_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAbstract(boolean newAbstract)
  {
    boolean oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.GRAMMAR__ABSTRACT, oldAbstract, abstract_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getIdElements()
  {
    if (idElements == null)
    {
      idElements = new EDataTypeEList<String>(String.class, this, XtextTestPackage.GRAMMAR__ID_ELEMENTS);
    }
    return idElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getSuperGrammarIdElements()
  {
    if (superGrammarIdElements == null)
    {
      superGrammarIdElements = new EDataTypeEList<String>(String.class, this, XtextTestPackage.GRAMMAR__SUPER_GRAMMAR_ID_ELEMENTS);
    }
    return superGrammarIdElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractMetamodelDeclaration> getMetamodelDeclarations()
  {
    if (metamodelDeclarations == null)
    {
      metamodelDeclarations = new EObjectContainmentEList<AbstractMetamodelDeclaration>(AbstractMetamodelDeclaration.class, this, XtextTestPackage.GRAMMAR__METAMODEL_DECLARATIONS);
    }
    return metamodelDeclarations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractRule> getRules()
  {
    if (rules == null)
    {
      rules = new EObjectContainmentEList<AbstractRule>(AbstractRule.class, this, XtextTestPackage.GRAMMAR__RULES);
    }
    return rules;
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
      case XtextTestPackage.GRAMMAR__METAMODEL_DECLARATIONS:
        return ((InternalEList<?>)getMetamodelDeclarations()).basicRemove(otherEnd, msgs);
      case XtextTestPackage.GRAMMAR__RULES:
        return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
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
      case XtextTestPackage.GRAMMAR__ABSTRACT:
        return isAbstract() ? Boolean.TRUE : Boolean.FALSE;
      case XtextTestPackage.GRAMMAR__ID_ELEMENTS:
        return getIdElements();
      case XtextTestPackage.GRAMMAR__SUPER_GRAMMAR_ID_ELEMENTS:
        return getSuperGrammarIdElements();
      case XtextTestPackage.GRAMMAR__METAMODEL_DECLARATIONS:
        return getMetamodelDeclarations();
      case XtextTestPackage.GRAMMAR__RULES:
        return getRules();
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
      case XtextTestPackage.GRAMMAR__ABSTRACT:
        setAbstract(((Boolean)newValue).booleanValue());
        return;
      case XtextTestPackage.GRAMMAR__ID_ELEMENTS:
        getIdElements().clear();
        getIdElements().addAll((Collection<? extends String>)newValue);
        return;
      case XtextTestPackage.GRAMMAR__SUPER_GRAMMAR_ID_ELEMENTS:
        getSuperGrammarIdElements().clear();
        getSuperGrammarIdElements().addAll((Collection<? extends String>)newValue);
        return;
      case XtextTestPackage.GRAMMAR__METAMODEL_DECLARATIONS:
        getMetamodelDeclarations().clear();
        getMetamodelDeclarations().addAll((Collection<? extends AbstractMetamodelDeclaration>)newValue);
        return;
      case XtextTestPackage.GRAMMAR__RULES:
        getRules().clear();
        getRules().addAll((Collection<? extends AbstractRule>)newValue);
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
      case XtextTestPackage.GRAMMAR__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
        return;
      case XtextTestPackage.GRAMMAR__ID_ELEMENTS:
        getIdElements().clear();
        return;
      case XtextTestPackage.GRAMMAR__SUPER_GRAMMAR_ID_ELEMENTS:
        getSuperGrammarIdElements().clear();
        return;
      case XtextTestPackage.GRAMMAR__METAMODEL_DECLARATIONS:
        getMetamodelDeclarations().clear();
        return;
      case XtextTestPackage.GRAMMAR__RULES:
        getRules().clear();
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
      case XtextTestPackage.GRAMMAR__ABSTRACT:
        return abstract_ != ABSTRACT_EDEFAULT;
      case XtextTestPackage.GRAMMAR__ID_ELEMENTS:
        return idElements != null && !idElements.isEmpty();
      case XtextTestPackage.GRAMMAR__SUPER_GRAMMAR_ID_ELEMENTS:
        return superGrammarIdElements != null && !superGrammarIdElements.isEmpty();
      case XtextTestPackage.GRAMMAR__METAMODEL_DECLARATIONS:
        return metamodelDeclarations != null && !metamodelDeclarations.isEmpty();
      case XtextTestPackage.GRAMMAR__RULES:
        return rules != null && !rules.isEmpty();
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
    result.append(" (abstract: ");
    result.append(abstract_);
    result.append(", idElements: ");
    result.append(idElements);
    result.append(", superGrammarIdElements: ");
    result.append(superGrammarIdElements);
    result.append(')');
    return result.toString();
  }

} //GrammarImpl
