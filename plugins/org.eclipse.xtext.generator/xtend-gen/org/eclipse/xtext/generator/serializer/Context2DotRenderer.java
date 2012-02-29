package org.eclipse.xtext.generator.serializer;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.serializer.analysis.IContextProvider;
import org.eclipse.xtext.util.GraphvizDotBuilder;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class Context2DotRenderer {
  @Inject
  private IContextProvider contextProvider;
  
  @Inject
  private Grammar grammar;
  
  @Inject
  private Naming naming;
  
  @Inject
  private Context2NameFunction nameFunction;
  
  public Iterable<Pair<EObject,EClass>> types(final EObject ctx) {
    Set<EClass> _typesForContext = this.contextProvider.getTypesForContext(ctx);
    final Function1<EClass,Pair<EObject,EClass>> _function = new Function1<EClass,Pair<EObject,EClass>>() {
        public Pair<EObject,EClass> apply(final EClass t) {
          Pair<EObject,EClass> _mappedTo = Pair.<EObject, EClass>of(ctx, t);
          return _mappedTo;
        }
      };
    Iterable<Pair<EObject,EClass>> _map = IterableExtensions.<EClass, Pair<EObject,EClass>>map(_typesForContext, _function);
    return _map;
  }
  
  public Iterable<Pair<EObject,EClass>> contexts() {
    List<EObject> _allContexts = this.contextProvider.getAllContexts(this.grammar);
    final Function1<EObject,Iterable<Pair<EObject,EClass>>> _function = new Function1<EObject,Iterable<Pair<EObject,EClass>>>() {
        public Iterable<Pair<EObject,EClass>> apply(final EObject c) {
          Iterable<Pair<EObject,EClass>> _types = Context2DotRenderer.this.types(c);
          return _types;
        }
      };
    List<Iterable<Pair<EObject,EClass>>> _map = ListExtensions.<EObject, Iterable<Pair<EObject,EClass>>>map(_allContexts, _function);
    Iterable<Pair<EObject,EClass>> _flatten = Iterables.<Pair<EObject,EClass>>concat(_map);
    return _flatten;
  }
  
  public Iterable<Pair<String,String>> render2Dot(final GraphvizDotBuilder builder, final String name) {
    Iterable<Pair<EObject,EClass>> _contexts = this.contexts();
    final Function1<Pair<EObject,EClass>,Pair<String,String>> _function = new Function1<Pair<EObject,EClass>,Pair<String,String>>() {
        public Pair<String,String> apply(final Pair<EObject,EClass> c) {
          String _fileName = Context2DotRenderer.this.getFileName(c, name);
          String _draw = builder.draw(c);
          Pair<String,String> _mappedTo = Pair.<String, String>of(_fileName, _draw);
          return _mappedTo;
        }
      };
    Iterable<Pair<String,String>> _map = IterableExtensions.<Pair<EObject,EClass>, Pair<String,String>>map(_contexts, _function);
    return _map;
  }
  
  public String getFileName(final Pair<EObject,EClass> ctx, final String name) {
    String _xblockexpression = null;
    {
      String _name = this.grammar.getName();
      String _simpleName = this.naming.toSimpleName(_name);
      String _plus = (_simpleName + "_");
      EClass _value = ctx.getValue();
      String _name_1 = _value==null?(String)null:_value.getName();
      String _plus_1 = (_plus + _name_1);
      String _plus_2 = (_plus_1 + "_");
      EObject _key = ctx.getKey();
      String _contextName = this.nameFunction.getContextName(_key);
      String _plus_3 = (_plus_2 + _contextName);
      String _plus_4 = (_plus_3 + "_");
      final String fn = (_plus_4 + name);
      String _basePackageRuntime = this.naming.basePackageRuntime(this.grammar);
      String _asPath = this.naming.asPath(_basePackageRuntime);
      String _plus_5 = (_asPath + "/serializer/");
      String _plus_6 = (_plus_5 + fn);
      String _plus_7 = (_plus_6 + ".dot");
      _xblockexpression = (_plus_7);
    }
    return _xblockexpression;
  }
}
