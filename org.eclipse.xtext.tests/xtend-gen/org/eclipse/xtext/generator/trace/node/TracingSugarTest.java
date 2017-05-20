/**
 * Copyright (c) 2017 TypeFox (https://typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace.node;

import com.google.inject.Inject;
import java.util.function.Function;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.generator.trace.node.IGeneratorNode;
import org.eclipse.xtext.generator.trace.node.Traced;
import org.eclipse.xtext.generator.trace.node.TracedAccessors;
import org.eclipse.xtext.generator.trace.node.TracingSugar;
import org.eclipse.xtext.linking.lazy.lazyLinking.LazyLinkingFactory;
import org.eclipse.xtext.linking.lazy.lazyLinking.Model;
import org.eclipse.xtext.linking.lazy.lazyLinking.Property;
import org.eclipse.xtext.linking.lazy.lazyLinking.Type;
import org.eclipse.xtext.linking.lazy.lazyLinking.UnresolvedProxyProperty;
import org.eclipse.xtext.linking.lazy.tests.LazyLinkingTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.tests.LineDelimiters;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(LazyLinkingTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class TracingSugarTest {
  @TracedAccessors(LazyLinkingFactory.class)
  public static class MyExtensions extends TracingSugar {
    /**
     * manual implementation for unsupported multi cross reference
     */
    public IGeneratorNode _type(final Property it, final Function1<? super Type, ? extends String> provider) {
      final ILocationData location = this.location(it, it.eClass().getEStructuralFeature("type"), 0);
      final CompositeGeneratorNode result = this.trace(location);
      this.append(result, provider.apply(IterableExtensions.<Type>head(it.getType())));
      return result;
    }
    
    public IGeneratorNode _class(final Model target, final Function<Class<?>, String> stringProvider) {
      EStructuralFeature feature = target.eClass().getEStructuralFeature("class");
      ILocationData location = this.location(target, feature, -1);
      CompositeGeneratorNode trace = this.trace(location);
      this.append(trace, stringProvider.apply(target.getClass()));
      return trace;
    }
    
    public IGeneratorNode _name(final Property target) {
      EStructuralFeature feature = target.eClass().getEStructuralFeature("name");
      ILocationData location = this.location(target, feature, -1);
      CompositeGeneratorNode trace = this.trace(location);
      this.append(trace, target.getName());
      return trace;
    }
    
    public IGeneratorNode _name(final Property target, final Function<String, String> stringProvider) {
      EStructuralFeature feature = target.eClass().getEStructuralFeature("name");
      ILocationData location = this.location(target, feature, -1);
      CompositeGeneratorNode trace = this.trace(location);
      this.append(trace, stringProvider.apply(target.getName()));
      return trace;
    }
    
    public IGeneratorNode _class(final Property target, final Function<Class<?>, String> stringProvider) {
      EStructuralFeature feature = target.eClass().getEStructuralFeature("class");
      ILocationData location = this.location(target, feature, -1);
      CompositeGeneratorNode trace = this.trace(location);
      this.append(trace, stringProvider.apply(target.getClass()));
      return trace;
    }
    
    public IGeneratorNode _extends(final Type target, final Function<Type, String> stringProvider) {
      EStructuralFeature feature = target.eClass().getEStructuralFeature("extends");
      ILocationData location = this.location(target, feature, -1);
      CompositeGeneratorNode trace = this.trace(location);
      this.append(trace, stringProvider.apply(target.getExtends()));
      return trace;
    }
    
    public IGeneratorNode _name(final Type target) {
      EStructuralFeature feature = target.eClass().getEStructuralFeature("name");
      ILocationData location = this.location(target, feature, -1);
      CompositeGeneratorNode trace = this.trace(location);
      this.append(trace, target.getName());
      return trace;
    }
    
    public IGeneratorNode _name(final Type target, final Function<String, String> stringProvider) {
      EStructuralFeature feature = target.eClass().getEStructuralFeature("name");
      ILocationData location = this.location(target, feature, -1);
      CompositeGeneratorNode trace = this.trace(location);
      this.append(trace, stringProvider.apply(target.getName()));
      return trace;
    }
    
    public IGeneratorNode _parentId(final Type target, final Function<Property, String> stringProvider) {
      EStructuralFeature feature = target.eClass().getEStructuralFeature("parentId");
      ILocationData location = this.location(target, feature, -1);
      CompositeGeneratorNode trace = this.trace(location);
      this.append(trace, stringProvider.apply(target.getParentId()));
      return trace;
    }
    
    public IGeneratorNode _class(final Type target, final Function<Class<?>, String> stringProvider) {
      EStructuralFeature feature = target.eClass().getEStructuralFeature("class");
      ILocationData location = this.location(target, feature, -1);
      CompositeGeneratorNode trace = this.trace(location);
      this.append(trace, stringProvider.apply(target.getClass()));
      return trace;
    }
    
    public IGeneratorNode _name(final UnresolvedProxyProperty target) {
      EStructuralFeature feature = target.eClass().getEStructuralFeature("name");
      ILocationData location = this.location(target, feature, -1);
      CompositeGeneratorNode trace = this.trace(location);
      this.append(trace, target.getName());
      return trace;
    }
    
    public IGeneratorNode _name(final UnresolvedProxyProperty target, final Function<String, String> stringProvider) {
      EStructuralFeature feature = target.eClass().getEStructuralFeature("name");
      ILocationData location = this.location(target, feature, -1);
      CompositeGeneratorNode trace = this.trace(location);
      this.append(trace, stringProvider.apply(target.getName()));
      return trace;
    }
    
    public IGeneratorNode _class(final UnresolvedProxyProperty target, final Function<Class<?>, String> stringProvider) {
      EStructuralFeature feature = target.eClass().getEStructuralFeature("class");
      ILocationData location = this.location(target, feature, -1);
      CompositeGeneratorNode trace = this.trace(location);
      this.append(trace, stringProvider.apply(target.getClass()));
      return trace;
    }
  }
  
  @Inject
  @Extension
  private TracingSugarTest.MyExtensions _myExtensions;
  
  @Inject
  private ParseHelper<Model> parseHelper;
  
  @Test
  public void testCodeGeneration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type String {}");
      _builder.newLine();
      _builder.append("type Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String name;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Model root = this.parseHelper.parse(LineDelimiters.toUnix(_builder.toString()));
      final InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          {
            EList<Type> _types = root.getTypes();
            for(final Type t : _types) {
              IGeneratorNode __generateType = TracingSugarTest.this._generateType(t);
              _builder.append(__generateType);
              _builder.newLineIfNotEmpty();
            }
          }
        }
      };
      this._myExtensions.generateTracedFile(fsa, "foo/bar.txt", root, _client);
      final CharSequence generated = fsa.getTextFiles().get((IFileSystemAccess.DEFAULT_OUTPUT + "foo/bar.txt"));
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        EList<Type> _types = root.getTypes();
        for(final Type t : _types) {
          CharSequence _generateType = this.generateType(t);
          _builder_1.append(_generateType);
          _builder_1.newLineIfNotEmpty();
        }
      }
      Assert.assertEquals(LineDelimiters.toUnix(_builder_1.toString()), generated.toString());
      final AbstractTraceRegion trace = ((ITraceRegionProvider) generated).getTraceRegion();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("CompletableTraceRegion [myOffset=0, myLength=55] associations={");
      _builder_2.newLine();
      _builder_2.append("  ");
      _builder_2.append("LocationData [TextRegionWithLineInformation [0:41][lineNumber=0, endLineNumber=3]][path=__synthetic0.lazylinkingtestlanguage]");
      _builder_2.newLine();
      _builder_2.append("} nestedRegions={");
      _builder_2.newLine();
      _builder_2.append("  ");
      _builder_2.append("CompletableTraceRegion [myOffset=0, myLength=17] associations={");
      _builder_2.newLine();
      _builder_2.append("    ");
      _builder_2.append("LocationData [TextRegionWithLineInformation [0:14][lineNumber=0, endLineNumber=0]][path=__synthetic0.lazylinkingtestlanguage]");
      _builder_2.newLine();
      _builder_2.append("  ");
      _builder_2.append("} nestedRegions={");
      _builder_2.newLine();
      _builder_2.append("    ");
      _builder_2.append("CompletableTraceRegion [myOffset=6, myLength=6] associations={");
      _builder_2.newLine();
      _builder_2.append("      ");
      _builder_2.append("LocationData [TextRegionWithLineInformation [5:6][lineNumber=0, endLineNumber=0]][path=__synthetic0.lazylinkingtestlanguage]");
      _builder_2.newLine();
      _builder_2.append("    ");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("  ");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("  ");
      _builder_2.append("CompletableTraceRegion [myOffset=17, myLength=38] associations={");
      _builder_2.newLine();
      _builder_2.append("    ");
      _builder_2.append("LocationData [TextRegionWithLineInformation [15:26][lineNumber=1, endLineNumber=3]][path=__synthetic0.lazylinkingtestlanguage]");
      _builder_2.newLine();
      _builder_2.append("  ");
      _builder_2.append("} nestedRegions={");
      _builder_2.newLine();
      _builder_2.append("    ");
      _builder_2.append("CompletableTraceRegion [myOffset=23, myLength=3] associations={");
      _builder_2.newLine();
      _builder_2.append("      ");
      _builder_2.append("LocationData [TextRegionWithLineInformation [20:3][lineNumber=1, endLineNumber=1]][path=__synthetic0.lazylinkingtestlanguage]");
      _builder_2.newLine();
      _builder_2.append("    ");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("    ");
      _builder_2.append("CompletableTraceRegion [myOffset=30, myLength=24] associations={");
      _builder_2.newLine();
      _builder_2.append("      ");
      _builder_2.append("LocationData [TextRegionWithLineInformation [27:12][lineNumber=2, endLineNumber=2]][path=__synthetic0.lazylinkingtestlanguage]");
      _builder_2.newLine();
      _builder_2.append("    ");
      _builder_2.append("} nestedRegions={");
      _builder_2.newLine();
      _builder_2.append("      ");
      _builder_2.append("CompletableTraceRegion [myOffset=39, myLength=4] associations={");
      _builder_2.newLine();
      _builder_2.append("        ");
      _builder_2.append("LocationData [TextRegionWithLineInformation [34:4][lineNumber=2, endLineNumber=2]][path=__synthetic0.lazylinkingtestlanguage]");
      _builder_2.newLine();
      _builder_2.append("      ");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("      ");
      _builder_2.append("CompletableTraceRegion [myOffset=46, myLength=6] associations={");
      _builder_2.newLine();
      _builder_2.append("        ");
      _builder_2.append("LocationData [TextRegionWithLineInformation [27:6][lineNumber=2, endLineNumber=2]][path=__synthetic0.lazylinkingtestlanguage]");
      _builder_2.newLine();
      _builder_2.append("      ");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("    ");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("  ");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      Assert.assertEquals(LineDelimiters.toUnix(_builder_2.toString()), trace.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Traced
  public IGeneratorNode _generateType(final Type it) {
    ILocationData _location = this._myExtensions.location(it);
    CompositeGeneratorNode _traceNode = this._myExtensions.trace(_location);
    this._myExtensions.appendTemplate(_traceNode, __generateType(it));
    return _traceNode;
  }
  
  @Traced
  public IGeneratorNode _generateProperty(final Property it) {
    ILocationData _location = this._myExtensions.location(it);
    CompositeGeneratorNode _traceNode = this._myExtensions.trace(_location);
    this._myExtensions.appendTemplate(_traceNode, __generateProperty(it));
    return _traceNode;
  }
  
  public CharSequence generateType(final Type it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Class ");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<Property> _properties = it.getProperties();
      for(final Property p : _properties) {
        _builder.append("\t");
        CharSequence _generateProperty = this.generateProperty(p);
        _builder.append(_generateProperty, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateProperty(final Property it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Property ");
    String _name = it.getName();
    _builder.append(_name);
    _builder.append(" : ");
    String _name_1 = IterableExtensions.<Type>head(it.getType()).getName();
    _builder.append(_name_1);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenationClient __generateType(final Type it) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("Class ");
        IGeneratorNode __name = TracingSugarTest.this._myExtensions._name(it);
        _builder.append(__name);
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        {
          EList<Property> _properties = it.getProperties();
          for(final Property p : _properties) {
            _builder.append("\t");
            IGeneratorNode __generateProperty = TracingSugarTest.this._generateProperty(p);
            _builder.append(__generateProperty, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    };
    return _client;
  }
  
  public StringConcatenationClient __generateProperty(final Property it) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("Property ");
        IGeneratorNode __name = TracingSugarTest.this._myExtensions._name(it);
        _builder.append(__name);
        _builder.append(" : ");
        final Function1<Type, String> _function = (Type it_1) -> {
          return it_1.getName();
        };
        IGeneratorNode __type = TracingSugarTest.this._myExtensions._type(it, _function);
        _builder.append(__type);
        _builder.newLineIfNotEmpty();
      }
    };
    return _client;
  }
}
