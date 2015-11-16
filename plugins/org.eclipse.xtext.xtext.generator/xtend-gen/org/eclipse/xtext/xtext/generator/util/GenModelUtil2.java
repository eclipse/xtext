/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.util;

import com.google.common.base.Objects;
import java.util.Map;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2;

@SuppressWarnings("all")
public class GenModelUtil2 {
  public static GenClass getGenClass(final EClass cls, final ResourceSet resourceSet) {
    GenClassifier _genClassifier = GenModelUtil2.getGenClassifier(cls, resourceSet);
    return ((GenClass) _genClassifier);
  }
  
  public static GenClassifier getGenClassifier(final EClassifier cls, final ResourceSet resourceSet) {
    EPackage _ePackage = cls.getEPackage();
    final GenPackage genPackage = GenModelUtil2.getGenPackage(_ePackage, resourceSet);
    EList<GenClassifier> _genClassifiers = genPackage.getGenClassifiers();
    for (final GenClassifier genCls : _genClassifiers) {
      String _name = cls.getName();
      EClassifier _ecoreClassifier = genCls.getEcoreClassifier();
      String _name_1 = _ecoreClassifier.getName();
      boolean _equals = Objects.equal(_name, _name_1);
      if (_equals) {
        return genCls;
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("No GenClassifier named \'");
    String _name_2 = cls.getName();
    _builder.append(_name_2, "");
    _builder.append("\' found in GenModel ");
    Resource _eResource = genPackage.eResource();
    URI _uRI = _eResource.getURI();
    _builder.append(_uRI, "");
    throw new RuntimeException(_builder.toString());
  }
  
  public static GenDataType getGenDataType(final EDataType dt, final ResourceSet resourceSet) {
    GenClassifier _genClassifier = GenModelUtil2.getGenClassifier(dt, resourceSet);
    return ((GenDataType) _genClassifier);
  }
  
  public static GenEnum getGenEnum(final EEnum en, final ResourceSet resourceSet) {
    GenClassifier _genClassifier = GenModelUtil2.getGenClassifier(en, resourceSet);
    return ((GenEnum) _genClassifier);
  }
  
  public static GenFeature getGenFeature(final EStructuralFeature feature, final ResourceSet resourceSet) {
    EClass _eContainingClass = feature.getEContainingClass();
    GenClassifier _genClassifier = GenModelUtil2.getGenClassifier(_eContainingClass, resourceSet);
    final GenClass genCls = ((GenClass) _genClassifier);
    EList<GenFeature> _genFeatures = genCls.getGenFeatures();
    for (final GenFeature genFeat : _genFeatures) {
      String _name = feature.getName();
      EStructuralFeature _ecoreFeature = genFeat.getEcoreFeature();
      String _name_1 = _ecoreFeature.getName();
      boolean _equals = Objects.equal(_name, _name_1);
      if (_equals) {
        return genFeat;
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("No GenFeature named \'");
    String _name_2 = feature.getName();
    _builder.append(_name_2, "");
    _builder.append("\' found in GenClass \'");
    _builder.append(genCls, "");
    _builder.append("\' from GenModel");
    Resource _eResource = genCls.eResource();
    URI _uRI = _eResource.getURI();
    _builder.append(_uRI, "");
    throw new RuntimeException(_builder.toString());
  }
  
  public static GenPackage getGenPackage(final EPackage pkg, final ResourceSet resourceSet) {
    final String nsURI = pkg.getNsURI();
    String location = null;
    Resource _eResource = pkg.eResource();
    URI _uRI = null;
    if (_eResource!=null) {
      _uRI=_eResource.getURI();
    }
    boolean _tripleNotEquals = (_uRI != null);
    if (_tripleNotEquals) {
      Resource _eResource_1 = pkg.eResource();
      URI _uRI_1 = _eResource_1.getURI();
      String _string = _uRI_1.toString();
      location = _string;
    }
    final Resource genModelResource = GenModelUtil2.getGenModelResource(location, nsURI, resourceSet);
    if ((genModelResource != null)) {
      EList<EObject> _contents = genModelResource.getContents();
      for (final EObject model : _contents) {
        if ((model instanceof GenModel)) {
          final GenPackage genPkg = ((GenModel)model).findGenPackage(pkg);
          if ((genPkg != null)) {
            EPackage _ecorePackage = genPkg.getEcorePackage();
            _ecorePackage.getEClassifiers();
            return genPkg;
          }
        }
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("No GenPackage for NsURI ");
      _builder.append(nsURI, "");
      _builder.append(" found in ");
      URI _uRI_2 = genModelResource.getURI();
      _builder.append(_uRI_2, "");
      throw new RuntimeException(_builder.toString());
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("No GenPackage for NsURI ");
    _builder_1.append(nsURI, "");
    _builder_1.append(".");
    throw new RuntimeException(_builder_1.toString());
  }
  
  public static Resource getGenModelResource(final String locationInfo, final String nsURI, final ResourceSet resourceSet) {
    Map<String, URI> _ePackageNsURIToGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap(false);
    final URI genModelURI = _ePackageNsURIToGenModelLocationMap.get(nsURI);
    if ((genModelURI == null)) {
      boolean _equals = EcorePackage.eNS_URI.equals(nsURI);
      if (_equals) {
        return null;
      }
      EList<Resource> _resources = resourceSet.getResources();
      for (final Resource res : _resources) {
        EList<EObject> _contents = res.getContents();
        for (final EObject obj : _contents) {
          if ((obj instanceof GenModel)) {
            EList<GenPackage> _genPackages = ((GenModel)obj).getGenPackages();
            for (final GenPackage genPackage : _genPackages) {
              String _nSURI = genPackage.getNSURI();
              boolean _equals_1 = _nSURI.equals(nsURI);
              if (_equals_1) {
                return genPackage.eResource();
              }
            }
          }
        }
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Could not find a GenModel for EPackage \'");
      _builder.append(nsURI, "");
      _builder.append("\'");
      {
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(locationInfo);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          _builder.append(" from ");
          _builder.append(locationInfo, "");
        }
      }
      _builder.append(".");
      _builder.newLineIfNotEmpty();
      _builder.append("If the missing GenModel has been generated via ");
      String _simpleName = EMFGeneratorFragment2.class.getSimpleName();
      _builder.append(_simpleName, "");
      _builder.append(", make sure to run it first in the workflow.");
      _builder.newLineIfNotEmpty();
      _builder.append("If you have a *.genmodel-file, make sure to register it via StandaloneSetup.registerGenModelFile(String).");
      _builder.newLine();
      throw new RuntimeException(_builder.toString());
    }
    if ((resourceSet == null)) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("There is no ResourceSet for EPackage \'");
      _builder_1.append(nsURI, "");
      _builder_1.append("\'. Please make sure the EPackage has been loaded from a .ecore file and not from the generated Java file.");
      throw new RuntimeException(_builder_1.toString());
    }
    final Resource genModelResource = resourceSet.getResource(genModelURI, true);
    if ((genModelResource == null)) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Error loading GenModel ");
      _builder_2.append(genModelURI, "");
      throw new RuntimeException(_builder_2.toString());
    }
    EList<EObject> _contents_1 = genModelResource.getContents();
    for (final EObject content : _contents_1) {
      if ((content instanceof GenModel)) {
        ((GenModel)content).reconcile();
      }
    }
    return genModelResource;
  }
  
  public static String getPackageLiteral() {
    return "eINSTANCE";
  }
  
  public static String getIntLiteral(final EClass clazz, final EStructuralFeature feature, final ResourceSet resourceSet) {
    GenClass _genClass = GenModelUtil2.getGenClass(clazz, resourceSet);
    GenFeature _genFeature = GenModelUtil2.getGenFeature(feature, resourceSet);
    return _genClass.getFeatureID(_genFeature);
  }
  
  public static String getIntLiteral(final EClassifier classifier, final ResourceSet resourceSet) {
    GenClassifier _genClassifier = GenModelUtil2.getGenClassifier(classifier, resourceSet);
    return _genClassifier.getClassifierID();
  }
  
  public static String getTypeLiteral(final EClassifier classifier, final ResourceSet resourceSet) {
    final GenClassifier genClassifier = GenModelUtil2.getGenClassifier(classifier, resourceSet);
    GenPackage _genPackage = genClassifier.getGenPackage();
    boolean _isLiteralsInterface = _genPackage.isLiteralsInterface();
    if (_isLiteralsInterface) {
      String _classifierID = genClassifier.getClassifierID();
      return ("Literals." + _classifierID);
    } else {
      String _classifierAccessorName = genClassifier.getClassifierAccessorName();
      String _plus = ("eINSTANCE.get" + _classifierAccessorName);
      return (_plus + "()");
    }
  }
  
  public static String getFeatureLiteral(final EStructuralFeature feature, final ResourceSet resourceSet) {
    final GenFeature genFeature = GenModelUtil2.getGenFeature(feature, resourceSet);
    GenPackage _genPackage = genFeature.getGenPackage();
    boolean _isLiteralsInterface = _genPackage.isLiteralsInterface();
    if (_isLiteralsInterface) {
      GenClass _genClass = genFeature.getGenClass();
      String _featureID = _genClass.getFeatureID(genFeature);
      return ("Literals." + _featureID);
    } else {
      String _featureAccessorName = genFeature.getFeatureAccessorName();
      String _plus = ("eINSTANCE.get" + _featureAccessorName);
      return (_plus + "()");
    }
  }
  
  public static String getJavaTypeName(final EClassifier classifier, final ResourceSet resourceSet) {
    final GenClassifier genClassifier = GenModelUtil2.getGenClassifier(classifier, resourceSet);
    if ((genClassifier instanceof GenClass)) {
      return ((GenClass)genClassifier).getQualifiedInterfaceName();
    } else {
      return ((GenDataType) genClassifier).getQualifiedInstanceClassName();
    }
  }
  
  public static String getGetAccessor(final EStructuralFeature feature, final ResourceSet resourceSet) {
    final GenFeature genFeature = GenModelUtil2.getGenFeature(feature, resourceSet);
    final GenClass genClass = genFeature.getGenClass();
    boolean _isMapEntry = genClass.isMapEntry();
    if (_isMapEntry) {
      GenFeature _mapEntryKeyFeature = genClass.getMapEntryKeyFeature();
      boolean _equals = Objects.equal(genFeature, _mapEntryKeyFeature);
      if (_equals) {
        return "getKey";
      }
      GenFeature _mapEntryValueFeature = genClass.getMapEntryValueFeature();
      boolean _equals_1 = Objects.equal(genFeature, _mapEntryValueFeature);
      if (_equals_1) {
        return "getValue";
      }
    }
    return genFeature.getGetAccessor();
  }
}
