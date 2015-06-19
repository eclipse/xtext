/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.typesystem;

import java.lang.annotation.ElementType;
import java.util.ArrayList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;
import com.google.inject.Injector;


//0% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=REWRITTEN, type=OBJECT} 0.60 ns; ?=0.00 ns @ 3 trials
//1% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=REWRITTEN, type=OBJECT} 0.60 ns; ?=0.01 ns @ 4 trials
//2% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=REWRITTEN, type=OBJECT} 0.89 ns; ?=0.01 ns @ 10 trials
//3% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=REWRITTEN, type=OBJECT} 4.40 ns; ?=0.08 ns @ 10 trials
//4% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=REWRITTEN, type=OBJECT} 51.16 ns; ?=1.92 ns @ 10 trials
//5% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=CURRENT, type=OBJECT} 158.22 ns; ?=0.83 ns @ 3 trials
//5% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=CURRENT, type=OBJECT} 26.94 ns; ?=0.65 ns @ 10 trials
//6% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=CURRENT, type=OBJECT} 0.41 ns; ?=0.00 ns @ 3 trials
//7% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=CURRENT, type=OBJECT} 1895.95 ns; ?=9.62 ns @ 3 trials
//8% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=CURRENT, type=OBJECT} 3112.21 ns; ?=12.78 ns @ 3 trials
//9% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=REWRITTEN, type=CLONEABLE} 0.60 ns; ?=0.01 ns @ 5 trials
//10% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=REWRITTEN, type=CLONEABLE} 0.60 ns; ?=0.00 ns @ 3 trials
//11% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=REWRITTEN, type=CLONEABLE} 1.05 ns; ?=0.01 ns @ 3 trials
//12% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=REWRITTEN, type=CLONEABLE} 4.09 ns; ?=0.01 ns @ 3 trials
//13% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=REWRITTEN, type=CLONEABLE} 56.73 ns; ?=0.56 ns @ 3 trials
//14% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=CURRENT, type=CLONEABLE} 160.02 ns; ?=1.06 ns @ 3 trials
//15% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=CURRENT, type=CLONEABLE} 27.78 ns; ?=0.90 ns @ 10 trials
//15% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=CURRENT, type=CLONEABLE} 0.32 ns; ?=0.03 ns @ 10 trials
//16% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=CURRENT, type=CLONEABLE} 1926.91 ns; ?=18.46 ns @ 6 trials
//17% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=CURRENT, type=CLONEABLE} 3152.71 ns; ?=4.55 ns @ 3 trials
//18% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=REWRITTEN, type=RESOURCE_FACTORY_REGISTRY} 0.60 ns; ?=0.00 ns @ 3 trials
//19% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=REWRITTEN, type=RESOURCE_FACTORY_REGISTRY} 0.60 ns; ?=0.01 ns @ 5 trials
//20% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=REWRITTEN, type=RESOURCE_FACTORY_REGISTRY} 0.96 ns; ?=0.07 ns @ 10 trials
//21% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=REWRITTEN, type=RESOURCE_FACTORY_REGISTRY} 4.08 ns; ?=0.03 ns @ 3 trials
//22% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=REWRITTEN, type=RESOURCE_FACTORY_REGISTRY} 51.00 ns; ?=1.74 ns @ 10 trials
//23% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=CURRENT, type=RESOURCE_FACTORY_REGISTRY} 157.52 ns; ?=5.07 ns @ 10 trials
//24% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=CURRENT, type=RESOURCE_FACTORY_REGISTRY} 28.51 ns; ?=2.32 ns @ 10 trials
//25% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=CURRENT, type=RESOURCE_FACTORY_REGISTRY} 0.31 ns; ?=0.01 ns @ 10 trials
//25% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=CURRENT, type=RESOURCE_FACTORY_REGISTRY} 1943.90 ns; ?=12.14 ns @ 3 trials
//26% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=CURRENT, type=RESOURCE_FACTORY_REGISTRY} 3293.51 ns; ?=158.85 ns @ 10 trials
//27% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=REWRITTEN, type=OVERRIDE} 0.61 ns; ?=0.02 ns @ 10 trials
//28% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=REWRITTEN, type=OVERRIDE} 0.63 ns; ?=0.05 ns @ 10 trials
//29% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=REWRITTEN, type=OVERRIDE} 0.60 ns; ?=0.03 ns @ 10 trials
//30% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=REWRITTEN, type=OVERRIDE} 0.90 ns; ?=0.03 ns @ 10 trials
//31% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=REWRITTEN, type=OVERRIDE} 52.45 ns; ?=15.89 ns @ 10 trials
//32% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=CURRENT, type=OVERRIDE} 193.12 ns; ?=15.54 ns @ 10 trials
//33% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=CURRENT, type=OVERRIDE} 26.43 ns; ?=0.89 ns @ 10 trials
//34% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=CURRENT, type=OVERRIDE} 35.00 ns; ?=3.49 ns @ 10 trials
//35% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=CURRENT, type=OVERRIDE} 2040.66 ns; ?=281.66 ns @ 10 trials
//35% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=CURRENT, type=OVERRIDE} 3442.54 ns; ?=134.59 ns @ 10 trials
//36% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=REWRITTEN, type=ELEMENT_TYPE} 0.62 ns; ?=0.05 ns @ 10 trials
//37% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=REWRITTEN, type=ELEMENT_TYPE} 0.66 ns; ?=0.04 ns @ 10 trials
//38% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=REWRITTEN, type=ELEMENT_TYPE} 0.70 ns; ?=0.00 ns @ 3 trials
//39% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=REWRITTEN, type=ELEMENT_TYPE} 0.94 ns; ?=0.07 ns @ 10 trials
//40% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=REWRITTEN, type=ELEMENT_TYPE} 51.83 ns; ?=0.39 ns @ 3 trials
//41% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=CURRENT, type=ELEMENT_TYPE} 161.10 ns; ?=1.37 ns @ 3 trials
//42% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=CURRENT, type=ELEMENT_TYPE} 26.09 ns; ?=0.13 ns @ 3 trials
//43% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=CURRENT, type=ELEMENT_TYPE} 31.66 ns; ?=1.06 ns @ 10 trials
//44% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=CURRENT, type=ELEMENT_TYPE} 1935.07 ns; ?=18.26 ns @ 3 trials
//45% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=CURRENT, type=ELEMENT_TYPE} 3388.36 ns; ?=255.32 ns @ 10 trials
//45% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=REWRITTEN, type=ARRAY_LIST} 0.62 ns; ?=0.06 ns @ 10 trials
//46% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=REWRITTEN, type=ARRAY_LIST} 0.61 ns; ?=0.03 ns @ 10 trials
//47% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=REWRITTEN, type=ARRAY_LIST} 0.90 ns; ?=0.02 ns @ 10 trials
//48% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=REWRITTEN, type=ARRAY_LIST} 4.45 ns; ?=0.01 ns @ 3 trials
//49% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=REWRITTEN, type=ARRAY_LIST} 55.85 ns; ?=0.55 ns @ 5 trials
//50% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=CURRENT, type=ARRAY_LIST} 159.17 ns; ?=1.05 ns @ 3 trials
//51% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=CURRENT, type=ARRAY_LIST} 26.55 ns; ?=0.25 ns @ 6 trials
//52% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=CURRENT, type=ARRAY_LIST} 0.41 ns; ?=0.00 ns @ 3 trials
//53% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=CURRENT, type=ARRAY_LIST} 1878.10 ns; ?=4.38 ns @ 3 trials
//54% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=CURRENT, type=ARRAY_LIST} 3121.65 ns; ?=2.18 ns @ 3 trials
//55% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=REWRITTEN, type=INT} 0.60 ns; ?=0.00 ns @ 3 trials
//55% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=REWRITTEN, type=INT} 0.60 ns; ?=0.00 ns @ 3 trials
//56% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=REWRITTEN, type=INT} 0.60 ns; ?=0.01 ns @ 8 trials
//57% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=REWRITTEN, type=INT} 0.91 ns; ?=0.01 ns @ 3 trials
//58% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=REWRITTEN, type=INT} 37.45 ns; ?=0.40 ns @ 10 trials
//59% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=CURRENT, type=INT} 155.00 ns; ?=0.45 ns @ 3 trials
//60% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=CURRENT, type=INT} 0.32 ns; ?=0.00 ns @ 5 trials
//61% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=CURRENT, type=INT} 28.36 ns; ?=0.95 ns @ 10 trials
//62% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=CURRENT, type=INT} 57.52 ns; ?=3.61 ns @ 10 trials
//63% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=CURRENT, type=INT} 3287.13 ns; ?=108.58 ns @ 10 trials
//64% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=REWRITTEN, type=BOOLEAN_WRAPPER} 0.63 ns; ?=0.06 ns @ 10 trials
//65% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=REWRITTEN, type=BOOLEAN_WRAPPER} 0.60 ns; ?=0.02 ns @ 10 trials
//65% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=REWRITTEN, type=BOOLEAN_WRAPPER} 0.92 ns; ?=0.04 ns @ 10 trials
//66% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=REWRITTEN, type=BOOLEAN_WRAPPER} 16.44 ns; ?=0.05 ns @ 3 trials
//67% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=REWRITTEN, type=BOOLEAN_WRAPPER} 53.45 ns; ?=3.19 ns @ 10 trials
//68% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=CURRENT, type=BOOLEAN_WRAPPER} 162.08 ns; ?=4.12 ns @ 10 trials
//69% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=CURRENT, type=BOOLEAN_WRAPPER} 30.38 ns; ?=1.28 ns @ 10 trials
//70% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=CURRENT, type=BOOLEAN_WRAPPER} 0.41 ns; ?=0.00 ns @ 3 trials
//71% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=CURRENT, type=BOOLEAN_WRAPPER} 1674.45 ns; ?=0.91 ns @ 3 trials
//72% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=CURRENT, type=BOOLEAN_WRAPPER} 3152.04 ns; ?=8.88 ns @ 3 trials
//73% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=REWRITTEN, type=VOID} 0.90 ns; ?=0.02 ns @ 10 trials
//74% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=REWRITTEN, type=VOID} 0.60 ns; ?=0.02 ns @ 10 trials
//75% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=REWRITTEN, type=VOID} 0.60 ns; ?=0.01 ns @ 3 trials
//75% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=REWRITTEN, type=VOID} 0.89 ns; ?=0.01 ns @ 5 trials
//76% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=REWRITTEN, type=VOID} 28.52 ns; ?=0.19 ns @ 3 trials
//77% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=CURRENT, type=VOID} 154.23 ns; ?=0.24 ns @ 3 trials
//78% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=CURRENT, type=VOID} 20.44 ns; ?=0.16 ns @ 3 trials
//79% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=CURRENT, type=VOID} 31.36 ns; ?=3.24 ns @ 10 trials
//80% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=CURRENT, type=VOID} 57.86 ns; ?=5.05 ns @ 10 trials
//81% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=CURRENT, type=VOID} 3280.55 ns; ?=299.99 ns @ 10 trials
//82% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=REWRITTEN, type=VOID_WRAPPER} 0.75 ns; ?=0.06 ns @ 10 trials
//83% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=REWRITTEN, type=VOID_WRAPPER} 0.64 ns; ?=0.05 ns @ 10 trials
//84% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=REWRITTEN, type=VOID_WRAPPER} 0.96 ns; ?=0.09 ns @ 10 trials
//85% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=REWRITTEN, type=VOID_WRAPPER} 21.75 ns; ?=0.15 ns @ 3 trials
//85% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=REWRITTEN, type=VOID_WRAPPER} 51.42 ns; ?=2.60 ns @ 10 trials
//86% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=CURRENT, type=VOID_WRAPPER} 161.78 ns; ?=4.27 ns @ 10 trials
//87% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=CURRENT, type=VOID_WRAPPER} 26.70 ns; ?=1.80 ns @ 10 trials
//88% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=CURRENT, type=VOID_WRAPPER} 0.41 ns; ?=0.01 ns @ 10 trials
//89% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=CURRENT, type=VOID_WRAPPER} 2318.33 ns; ?=175.58 ns @ 10 trials
//90% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=CURRENT, type=VOID_WRAPPER} 4113.00 ns; ?=536.58 ns @ 10 trials
//91% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=REWRITTEN, type=SHORT} 0.74 ns; ?=0.10 ns @ 10 trials
//92% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=REWRITTEN, type=SHORT} 0.67 ns; ?=0.10 ns @ 10 trials
//93% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=REWRITTEN, type=SHORT} 0.62 ns; ?=0.04 ns @ 10 trials
//94% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=REWRITTEN, type=SHORT} 0.99 ns; ?=0.10 ns @ 10 trials
//95% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=REWRITTEN, type=SHORT} 34.88 ns; ?=1.03 ns @ 10 trials
//95% Scenario{vm=java7, trial=0, benchmark=IsPrimitiveVoid, implementation=CURRENT, type=SHORT} 153.42 ns; ?=0.33 ns @ 3 trials
//96% Scenario{vm=java7, trial=0, benchmark=IsPrimitive, implementation=CURRENT, type=SHORT} 0.32 ns; ?=0.00 ns @ 5 trials
//97% Scenario{vm=java7, trial=0, benchmark=IsInterface, implementation=CURRENT, type=SHORT} 28.03 ns; ?=0.22 ns @ 3 trials
//98% Scenario{vm=java7, trial=0, benchmark=IsWrapper, implementation=CURRENT, type=SHORT} 49.53 ns; ?=0.83 ns @ 10 trials
//99% Scenario{vm=java7, trial=0, benchmark=IsType, implementation=CURRENT, type=SHORT} 3122.57 ns; ?=11.05 ns @ 3 trials
//
//implementation       benchmark                      type       ns linear runtime
//    REWRITTEN IsPrimitiveVoid                    OBJECT    0.596 =
//    REWRITTEN IsPrimitiveVoid                 CLONEABLE    0.597 =
//    REWRITTEN IsPrimitiveVoid RESOURCE_FACTORY_REGISTRY    0.599 =
//    REWRITTEN IsPrimitiveVoid                  OVERRIDE    0.612 =
//    REWRITTEN IsPrimitiveVoid              ELEMENT_TYPE    0.623 =
//    REWRITTEN IsPrimitiveVoid                ARRAY_LIST    0.618 =
//    REWRITTEN IsPrimitiveVoid                       INT    0.598 =
//    REWRITTEN IsPrimitiveVoid           BOOLEAN_WRAPPER    0.633 =
//    REWRITTEN IsPrimitiveVoid                      VOID    0.902 =
//    REWRITTEN IsPrimitiveVoid              VOID_WRAPPER    0.754 =
//    REWRITTEN IsPrimitiveVoid                     SHORT    0.741 =
//    REWRITTEN     IsPrimitive                    OBJECT    0.597 =
//    REWRITTEN     IsPrimitive                 CLONEABLE    0.602 =
//    REWRITTEN     IsPrimitive RESOURCE_FACTORY_REGISTRY    0.600 =
//    REWRITTEN     IsPrimitive                  OVERRIDE    0.629 =
//    REWRITTEN     IsPrimitive              ELEMENT_TYPE    0.661 =
//    REWRITTEN     IsPrimitive                ARRAY_LIST    0.615 =
//    REWRITTEN     IsPrimitive                       INT    0.599 =
//    REWRITTEN     IsPrimitive           BOOLEAN_WRAPPER    0.601 =
//    REWRITTEN     IsPrimitive                      VOID    0.600 =
//    REWRITTEN     IsPrimitive              VOID_WRAPPER    0.641 =
//    REWRITTEN     IsPrimitive                     SHORT    0.667 =
//    REWRITTEN     IsInterface                    OBJECT    0.894 =
//    REWRITTEN     IsInterface                 CLONEABLE    1.046 =
//    REWRITTEN     IsInterface RESOURCE_FACTORY_REGISTRY    0.959 =
//    REWRITTEN     IsInterface                  OVERRIDE    0.604 =
//    REWRITTEN     IsInterface              ELEMENT_TYPE    0.698 =
//    REWRITTEN     IsInterface                ARRAY_LIST    0.901 =
//    REWRITTEN     IsInterface                       INT    0.598 =
//    REWRITTEN     IsInterface           BOOLEAN_WRAPPER    0.924 =
//    REWRITTEN     IsInterface                      VOID    0.600 =
//    REWRITTEN     IsInterface              VOID_WRAPPER    0.958 =
//    REWRITTEN     IsInterface                     SHORT    0.617 =
//    REWRITTEN       IsWrapper                    OBJECT    4.404 =
//    REWRITTEN       IsWrapper                 CLONEABLE    4.088 =
//    REWRITTEN       IsWrapper RESOURCE_FACTORY_REGISTRY    4.082 =
//    REWRITTEN       IsWrapper                  OVERRIDE    0.903 =
//    REWRITTEN       IsWrapper              ELEMENT_TYPE    0.936 =
//    REWRITTEN       IsWrapper                ARRAY_LIST    4.448 =
//    REWRITTEN       IsWrapper                       INT    0.912 =
//    REWRITTEN       IsWrapper           BOOLEAN_WRAPPER   16.436 =
//    REWRITTEN       IsWrapper                      VOID    0.885 =
//    REWRITTEN       IsWrapper              VOID_WRAPPER   21.747 =
//    REWRITTEN       IsWrapper                     SHORT    0.991 =
//    REWRITTEN          IsType                    OBJECT   51.157 =
//    REWRITTEN          IsType                 CLONEABLE   56.732 =
//    REWRITTEN          IsType RESOURCE_FACTORY_REGISTRY   50.996 =
//    REWRITTEN          IsType                  OVERRIDE   52.454 =
//    REWRITTEN          IsType              ELEMENT_TYPE   51.833 =
//    REWRITTEN          IsType                ARRAY_LIST   55.850 =
//    REWRITTEN          IsType                       INT   37.451 =
//    REWRITTEN          IsType           BOOLEAN_WRAPPER   53.455 =
//    REWRITTEN          IsType                      VOID   28.522 =
//    REWRITTEN          IsType              VOID_WRAPPER   51.417 =
//    REWRITTEN          IsType                     SHORT   34.878 =
//      CURRENT IsPrimitiveVoid                    OBJECT  158.221 =
//      CURRENT IsPrimitiveVoid                 CLONEABLE  160.016 =
//      CURRENT IsPrimitiveVoid RESOURCE_FACTORY_REGISTRY  157.522 =
//      CURRENT IsPrimitiveVoid                  OVERRIDE  193.124 =
//      CURRENT IsPrimitiveVoid              ELEMENT_TYPE  161.096 =
//      CURRENT IsPrimitiveVoid                ARRAY_LIST  159.174 =
//      CURRENT IsPrimitiveVoid                       INT  155.001 =
//      CURRENT IsPrimitiveVoid           BOOLEAN_WRAPPER  162.079 =
//      CURRENT IsPrimitiveVoid                      VOID  154.233 =
//      CURRENT IsPrimitiveVoid              VOID_WRAPPER  161.775 =
//      CURRENT IsPrimitiveVoid                     SHORT  153.421 =
//      CURRENT     IsPrimitive                    OBJECT   26.942 =
//      CURRENT     IsPrimitive                 CLONEABLE   27.775 =
//      CURRENT     IsPrimitive RESOURCE_FACTORY_REGISTRY   28.505 =
//      CURRENT     IsPrimitive                  OVERRIDE   26.431 =
//      CURRENT     IsPrimitive              ELEMENT_TYPE   26.088 =
//      CURRENT     IsPrimitive                ARRAY_LIST   26.548 =
//      CURRENT     IsPrimitive                       INT    0.317 =
//      CURRENT     IsPrimitive           BOOLEAN_WRAPPER   30.376 =
//      CURRENT     IsPrimitive                      VOID   20.443 =
//      CURRENT     IsPrimitive              VOID_WRAPPER   26.703 =
//      CURRENT     IsPrimitive                     SHORT    0.317 =
//      CURRENT     IsInterface                    OBJECT    0.411 =
//      CURRENT     IsInterface                 CLONEABLE    0.318 =
//      CURRENT     IsInterface RESOURCE_FACTORY_REGISTRY    0.315 =
//      CURRENT     IsInterface                  OVERRIDE   35.002 =
//      CURRENT     IsInterface              ELEMENT_TYPE   31.658 =
//      CURRENT     IsInterface                ARRAY_LIST    0.410 =
//      CURRENT     IsInterface                       INT   28.365 =
//      CURRENT     IsInterface           BOOLEAN_WRAPPER    0.411 =
//      CURRENT     IsInterface                      VOID   31.359 =
//      CURRENT     IsInterface              VOID_WRAPPER    0.413 =
//      CURRENT     IsInterface                     SHORT   28.030 =
//      CURRENT       IsWrapper                    OBJECT 1895.946 =============
//      CURRENT       IsWrapper                 CLONEABLE 1926.913 ==============
//      CURRENT       IsWrapper RESOURCE_FACTORY_REGISTRY 1943.902 ==============
//      CURRENT       IsWrapper                  OVERRIDE 2040.656 ==============
//      CURRENT       IsWrapper              ELEMENT_TYPE 1935.069 ==============
//      CURRENT       IsWrapper                ARRAY_LIST 1878.096 =============
//      CURRENT       IsWrapper                       INT   57.516 =
//      CURRENT       IsWrapper           BOOLEAN_WRAPPER 1674.450 ============
//      CURRENT       IsWrapper                      VOID   57.862 =
//      CURRENT       IsWrapper              VOID_WRAPPER 2318.333 ================
//      CURRENT       IsWrapper                     SHORT   49.534 =
//      CURRENT          IsType                    OBJECT 3112.205 ======================
//      CURRENT          IsType                 CLONEABLE 3152.706 ======================
//      CURRENT          IsType RESOURCE_FACTORY_REGISTRY 3293.509 ========================
//      CURRENT          IsType                  OVERRIDE 3442.542 =========================
//      CURRENT          IsType              ELEMENT_TYPE 3388.356 ========================
//      CURRENT          IsType                ARRAY_LIST 3121.655 ======================
//      CURRENT          IsType                       INT 3287.127 =======================
//      CURRENT          IsType           BOOLEAN_WRAPPER 3152.037 ======================
//      CURRENT          IsType                      VOID 3280.548 =======================
//      CURRENT          IsType              VOID_WRAPPER 4112.996 ==============================
//      CURRENT          IsType                     SHORT 3122.573 ======================

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParameterizedTypeReferenceBenchmark extends SimpleBenchmark {
	
	private IndexedJvmTypeAccess indexedAccess = new IndexedJvmTypeAccess() {
		@Override
		public EObject getIndexedJvmType(QualifiedName qualifiedName, String fragment, ResourceSet resourceSet) {
			return null;
		}

		@Override
		public EObject getIndexedJvmType(URI javaObjectURI, ResourceSet resourceSet) {
			return null;
		}
	};

	public enum Impl {
		REWRITTEN {
			@Override
			boolean isPrimitiveVoid(ParameterizedTypeReference typeReference) {
				return typeReference.isPrimitiveVoid();
			}
			@Override
			boolean isPrimitive(ParameterizedTypeReference typeReference) {
				return typeReference.isPrimitive();
			}
			@Override
			boolean isInterfaceType(ParameterizedTypeReference typeReference) {
				return typeReference.isInterfaceType();
			}
			@Override
			boolean isWrapper(ParameterizedTypeReference typeReference) {
				return typeReference.isWrapper();
			}
			@Override
			boolean isType(ParameterizedTypeReference typeReference, Class<?> clazz) {
				return typeReference.isType(clazz);
			}
		},
		CURRENT {
			@Override
			boolean isPrimitiveVoid(ParameterizedTypeReference typeReference) {
				return Void.TYPE.getCanonicalName().equals(typeReference.getType().getIdentifier());
			}
			@Override
			boolean isPrimitive(ParameterizedTypeReference typeReference) {
				return typeReference.getType() instanceof JvmPrimitiveType;
			}
			@Override
			boolean isInterfaceType(ParameterizedTypeReference typeReference) {
				JvmType type = typeReference.getType();
				if (type instanceof JvmGenericType) {
					return ((JvmGenericType) type).isInterface();
				}
				return false;
			}
			@Override
			boolean isWrapper(ParameterizedTypeReference typeReference) {
				JvmType type = typeReference.getType();
				if (type instanceof JvmDeclaredType || type instanceof JvmTypeParameter) {
					Primitives primitives = typeReference.getOwner().getServices().getPrimitives();
					boolean result = primitives.isWrapperType(type);
					return result;
				}
				return false;
			}
			@Override
			boolean isType(ParameterizedTypeReference typeReference, Class<?> clazz) {
				return clazz.getCanonicalName().equals(typeReference.getType().getIdentifier());
			}
		},
		;
		abstract boolean isPrimitiveVoid(ParameterizedTypeReference typeReference);
		abstract boolean isPrimitive(ParameterizedTypeReference typeReference);
		abstract boolean isWrapper(ParameterizedTypeReference typeReference);
		abstract boolean isInterfaceType(ParameterizedTypeReference typeReference);
		abstract boolean isType(ParameterizedTypeReference typeReference, Class<?> type);
	}

	public enum Type {
		OBJECT {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.Object");
				return owner.newParameterizedTypeReference(type);
			}
		},
		CLONEABLE {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.Cloneable");
				return owner.newParameterizedTypeReference(type);
			}
		},
		RESOURCE_FACTORY_REGISTRY {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("org.eclipse.emf.ecore.resource.Resource$Factory$Registry");
				return owner.newParameterizedTypeReference(type);
			}
		},
		OVERRIDE {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.Override");
				return owner.newParameterizedTypeReference(type);
			}
		},
		ELEMENT_TYPE {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.annotation.ElementType");
				return owner.newParameterizedTypeReference(type);
			}
		},
		ARRAY_LIST {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.util.ArrayList");
				return owner.newParameterizedTypeReference(type);
			}
		},
		INT {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("int");
				return owner.newParameterizedTypeReference(type);
			}
		},
		BOOLEAN_WRAPPER {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.Boolean");
				return owner.newParameterizedTypeReference(type);
			}
		},
		VOID {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("void");
				return owner.newParameterizedTypeReference(type);
			}
		},
		VOID_WRAPPER {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.Void");
				return owner.newParameterizedTypeReference(type);
			}
		},
		SHORT {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("short");
				return owner.newParameterizedTypeReference(type);
			}
		},
		;
		abstract ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner);
	}

	@Param
	Impl implementation;

	@Param
	Type type;

	private ParameterizedTypeReference typeReference;

	@Override
	protected void setUp() throws Exception {
		Injector injector = new XbaseStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = new XtextResourceSet();
		ClassLoader loader = getClass().getClassLoader();
		resourceSet.setClasspathURIContext(loader);
		ClasspathTypeProvider typeProvider = new ClasspathTypeProvider(loader, resourceSet, indexedAccess, null);
		CommonTypeComputationServices services = injector.getInstance(CommonTypeComputationServices.class);
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, resourceSet);
		typeReference = type.getReference(typeProvider, owner);
		EcoreUtil.resolveAll(resourceSet);
	}

	public int timeIsPrimitiveVoid(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.isPrimitiveVoid(typeReference)) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}
	
	public int timeIsPrimitive(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.isPrimitive(typeReference)) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}
	
	public int timeIsInterface(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.isInterfaceType(typeReference)) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}
	
	public int timeIsWrapper(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.isWrapper(typeReference)) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}
	
	public int timeIsType(int reps) {
		int result = 0;
		result += _timeIsTypeObject(reps);
		result += _timeIsTypeInt(reps);
		result += _timeIsTypeArrayList(reps);
		result += _timeIsTypeCloneable(reps);
		result += _timeIsTypeElementType(reps);
		result += _timeIsTypeObjectArray(reps);
		result += _timeIsTypeOverride(reps);
		result += _timeIsTypeResourceFactoryRegistry(reps);
		result += _timeIsTypeVoid(reps);
		return result;
	}
	
	public int _timeIsTypeObject(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.isType(typeReference, Object.class)) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}
	
	public int _timeIsTypeResourceFactoryRegistry(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.isType(typeReference, Resource.Factory.Registry.class)) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}
	
	public int _timeIsTypeOverride(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.isType(typeReference, Override.class)) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}
	
	public int _timeIsTypeElementType(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.isType(typeReference, ElementType.class)) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}
	
	public int _timeIsTypeVoid(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.isType(typeReference, void.class)) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}
	
	public int _timeIsTypeInt(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.isType(typeReference, int.class)) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}
	
	public int _timeIsTypeCloneable(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.isType(typeReference, Cloneable.class)) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}
	
	public int _timeIsTypeObjectArray(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.isType(typeReference, Object[].class)) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}
	
	public int _timeIsTypeArrayList(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.isType(typeReference, ArrayList.class)) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Runner.main(ParameterizedTypeReferenceBenchmark.class, args);
	}

}
