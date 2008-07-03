/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.parser;

import java.util.Collection;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.service.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class GenericEcoreElementFactory implements IAstFactory {

    @Inject
    protected IMetamodelAccess metamodelAccess;

    @Inject
    protected IValueConverterService converterService;

    public void setMetamodelAccess(IMetamodelAccess metamodelAccess) {
        this.metamodelAccess = metamodelAccess;
    }
    
    public EObject create(String fullTypeName) {
        EClass clazz = getEClass(fullTypeName);
        if (clazz != null && !(clazz.isAbstract() || clazz.isInterface()))
            return clazz.getEPackage().getEFactoryInstance().create(clazz);
        return null;
    }

    @Deprecated
    public void set(EObject _this, String feature, Object value) throws RecognitionException {
        set(_this, feature, value, null);
    }

    public void set(EObject _this, String feature, Object value, String ruleName) throws RecognitionException {
        try {
            if (value instanceof Token) {
                value = ((Token) value).getText();
                if (ruleName != null) {
                    value = converterService.toValue((String) value, ruleName);
                }
            }
            EObject eo = (EObject) _this;
            EStructuralFeature structuralFeature = eo.eClass().getEStructuralFeature(feature);
            eo.eSet(structuralFeature, value);
        } catch (Exception exc) {
            throw new RecognitionException();
        }
    }

    @Deprecated
    public void add(EObject _this, String feature, Object value) throws RecognitionException {
        add(_this, feature, value, null);
    }

    @SuppressWarnings("unchecked")
    public void add(EObject _this, String feature, Object value, String ruleName) throws RecognitionException {
        try {
            if (value == null)
                return;
            if (value instanceof Token) {
                value = ((Token) value).getText();
                if (ruleName != null) {
                    value = converterService.toValue((String) value, ruleName);
                }
            }
            EObject eo = (EObject) _this;
            EStructuralFeature structuralFeature = eo.eClass().getEStructuralFeature(feature);
            ((Collection) eo.eGet(structuralFeature)).add(value);
        } catch (Exception exc) {
            throw new RecognitionException();
        }
    }

    protected EPackage[] getEPackages(String alias) {
        return metamodelAccess.getGeneratedEPackages();
    }

    public EClass getEClass(String fullTypeName) {
        String[] split = fullTypeName.split("::");
        String typeName = fullTypeName;
        String alias = null;
        if (split.length > 1) {
            alias = split[0];
            typeName = split[1];
        }
        EPackage[] packages = getEPackages(alias);
        if (packages == null || packages.length == 0) {
            throw new IllegalStateException("Couldn't find any epackages for alias '" + alias + "'");
        }
        for (EPackage package1 : packages) {
            if (package1 == null)
                throw new IllegalStateException("Problems loading EPackages for alias '" + alias + "' - one entry was null.");
            EClassifier classifier = package1.getEClassifier(typeName);
            if (classifier instanceof EClass) {
                return (EClass) classifier;
            }
        }
        return null;

    }

}
