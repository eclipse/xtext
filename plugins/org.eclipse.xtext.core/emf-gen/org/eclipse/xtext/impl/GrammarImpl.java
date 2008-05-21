/**
 * <copyright>
 * </copyright>
 *
 * $Id: GrammarImpl.java,v 1.8 2008/05/21 12:02:34 jkohnlein Exp $
 */
package org.eclipse.xtext.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grammar</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.impl.GrammarImpl#getMetamodelDeclarations <em>Metamodel Declarations</em>}</li>
 *   <li>{@link org.eclipse.xtext.impl.GrammarImpl#getParserRules <em>Parser Rules</em>}</li>
 *   <li>{@link org.eclipse.xtext.impl.GrammarImpl#getLexerRules <em>Lexer Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GrammarImpl extends EObjectImpl implements Grammar
{
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
   * The cached value of the '{@link #getParserRules() <em>Parser Rules</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParserRules()
   * @generated
   * @ordered
   */
  protected EList<ParserRule> parserRules;

  /**
   * The cached value of the '{@link #getLexerRules() <em>Lexer Rules</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLexerRules()
   * @generated
   * @ordered
   */
  protected EList<LexerRule> lexerRules;

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
    return XtextPackage.Literals.GRAMMAR;
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
      metamodelDeclarations = new EObjectContainmentEList<AbstractMetamodelDeclaration>(AbstractMetamodelDeclaration.class, this, XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS);
    }
    return metamodelDeclarations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParserRule> getParserRules()
  {
    if (parserRules == null)
    {
      parserRules = new EObjectContainmentEList<ParserRule>(ParserRule.class, this, XtextPackage.GRAMMAR__PARSER_RULES);
    }
    return parserRules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LexerRule> getLexerRules()
  {
    if (lexerRules == null)
    {
      lexerRules = new EObjectContainmentEList<LexerRule>(LexerRule.class, this, XtextPackage.GRAMMAR__LEXER_RULES);
    }
    return lexerRules;
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
      case XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS:
        return ((InternalEList<?>)getMetamodelDeclarations()).basicRemove(otherEnd, msgs);
      case XtextPackage.GRAMMAR__PARSER_RULES:
        return ((InternalEList<?>)getParserRules()).basicRemove(otherEnd, msgs);
      case XtextPackage.GRAMMAR__LEXER_RULES:
        return ((InternalEList<?>)getLexerRules()).basicRemove(otherEnd, msgs);
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
      case XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS:
        return getMetamodelDeclarations();
      case XtextPackage.GRAMMAR__PARSER_RULES:
        return getParserRules();
      case XtextPackage.GRAMMAR__LEXER_RULES:
        return getLexerRules();
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
      case XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS:
        getMetamodelDeclarations().clear();
        getMetamodelDeclarations().addAll((Collection<? extends AbstractMetamodelDeclaration>)newValue);
        return;
      case XtextPackage.GRAMMAR__PARSER_RULES:
        getParserRules().clear();
        getParserRules().addAll((Collection<? extends ParserRule>)newValue);
        return;
      case XtextPackage.GRAMMAR__LEXER_RULES:
        getLexerRules().clear();
        getLexerRules().addAll((Collection<? extends LexerRule>)newValue);
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
      case XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS:
        getMetamodelDeclarations().clear();
        return;
      case XtextPackage.GRAMMAR__PARSER_RULES:
        getParserRules().clear();
        return;
      case XtextPackage.GRAMMAR__LEXER_RULES:
        getLexerRules().clear();
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
      case XtextPackage.GRAMMAR__METAMODEL_DECLARATIONS:
        return metamodelDeclarations != null && !metamodelDeclarations.isEmpty();
      case XtextPackage.GRAMMAR__PARSER_RULES:
        return parserRules != null && !parserRules.isEmpty();
      case XtextPackage.GRAMMAR__LEXER_RULES:
        return lexerRules != null && !lexerRules.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //GrammarImpl
