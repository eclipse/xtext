/**
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.codetemplates.templates.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.AbstractRule;

import org.eclipse.xtext.ui.codetemplates.templates.Codetemplate;
import org.eclipse.xtext.ui.codetemplates.templates.TemplateBody;
import org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Codetemplate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.impl.CodetemplateImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.impl.CodetemplateImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.impl.CodetemplateImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.impl.CodetemplateImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.impl.CodetemplateImpl#getKeywordContext <em>Keyword Context</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.impl.CodetemplateImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CodetemplateImpl extends MinimalEObjectImpl.Container implements Codetemplate
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
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContext()
   * @generated
   * @ordered
   */
  protected AbstractRule context;

  /**
   * The default value of the '{@link #getKeywordContext() <em>Keyword Context</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeywordContext()
   * @generated
   * @ordered
   */
  protected static final String KEYWORD_CONTEXT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getKeywordContext() <em>Keyword Context</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeywordContext()
   * @generated
   * @ordered
   */
  protected String keywordContext = KEYWORD_CONTEXT_EDEFAULT;

  /**
   * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
  protected TemplateBody body;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CodetemplateImpl()
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
    return TemplatesPackage.Literals.CODETEMPLATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.CODETEMPLATE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.CODETEMPLATE__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.CODETEMPLATE__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AbstractRule getContext()
  {
    if (context != null && context.eIsProxy())
    {
      InternalEObject oldContext = (InternalEObject)context;
      context = (AbstractRule)eResolveProxy(oldContext);
      if (context != oldContext)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TemplatesPackage.CODETEMPLATE__CONTEXT, oldContext, context));
      }
    }
    return context;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractRule basicGetContext()
  {
    return context;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setContext(AbstractRule newContext)
  {
    AbstractRule oldContext = context;
    context = newContext;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.CODETEMPLATE__CONTEXT, oldContext, context));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getKeywordContext()
  {
    return keywordContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setKeywordContext(String newKeywordContext)
  {
    String oldKeywordContext = keywordContext;
    keywordContext = newKeywordContext;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.CODETEMPLATE__KEYWORD_CONTEXT, oldKeywordContext, keywordContext));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TemplateBody getBody()
  {
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBody(TemplateBody newBody, NotificationChain msgs)
  {
    TemplateBody oldBody = body;
    body = newBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatesPackage.CODETEMPLATE__BODY, oldBody, newBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setBody(TemplateBody newBody)
  {
    if (newBody != body)
    {
      NotificationChain msgs = null;
      if (body != null)
        msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatesPackage.CODETEMPLATE__BODY, null, msgs);
      if (newBody != null)
        msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatesPackage.CODETEMPLATE__BODY, null, msgs);
      msgs = basicSetBody(newBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.CODETEMPLATE__BODY, newBody, newBody));
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
      case TemplatesPackage.CODETEMPLATE__BODY:
        return basicSetBody(null, msgs);
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
      case TemplatesPackage.CODETEMPLATE__NAME:
        return getName();
      case TemplatesPackage.CODETEMPLATE__ID:
        return getId();
      case TemplatesPackage.CODETEMPLATE__DESCRIPTION:
        return getDescription();
      case TemplatesPackage.CODETEMPLATE__CONTEXT:
        if (resolve) return getContext();
        return basicGetContext();
      case TemplatesPackage.CODETEMPLATE__KEYWORD_CONTEXT:
        return getKeywordContext();
      case TemplatesPackage.CODETEMPLATE__BODY:
        return getBody();
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
      case TemplatesPackage.CODETEMPLATE__NAME:
        setName((String)newValue);
        return;
      case TemplatesPackage.CODETEMPLATE__ID:
        setId((String)newValue);
        return;
      case TemplatesPackage.CODETEMPLATE__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case TemplatesPackage.CODETEMPLATE__CONTEXT:
        setContext((AbstractRule)newValue);
        return;
      case TemplatesPackage.CODETEMPLATE__KEYWORD_CONTEXT:
        setKeywordContext((String)newValue);
        return;
      case TemplatesPackage.CODETEMPLATE__BODY:
        setBody((TemplateBody)newValue);
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
      case TemplatesPackage.CODETEMPLATE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TemplatesPackage.CODETEMPLATE__ID:
        setId(ID_EDEFAULT);
        return;
      case TemplatesPackage.CODETEMPLATE__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case TemplatesPackage.CODETEMPLATE__CONTEXT:
        setContext((AbstractRule)null);
        return;
      case TemplatesPackage.CODETEMPLATE__KEYWORD_CONTEXT:
        setKeywordContext(KEYWORD_CONTEXT_EDEFAULT);
        return;
      case TemplatesPackage.CODETEMPLATE__BODY:
        setBody((TemplateBody)null);
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
      case TemplatesPackage.CODETEMPLATE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TemplatesPackage.CODETEMPLATE__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case TemplatesPackage.CODETEMPLATE__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case TemplatesPackage.CODETEMPLATE__CONTEXT:
        return context != null;
      case TemplatesPackage.CODETEMPLATE__KEYWORD_CONTEXT:
        return KEYWORD_CONTEXT_EDEFAULT == null ? keywordContext != null : !KEYWORD_CONTEXT_EDEFAULT.equals(keywordContext);
      case TemplatesPackage.CODETEMPLATE__BODY:
        return body != null;
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", id: ");
    result.append(id);
    result.append(", description: ");
    result.append(description);
    result.append(", keywordContext: ");
    result.append(keywordContext);
    result.append(')');
    return result.toString();
  }

} //CodetemplateImpl
