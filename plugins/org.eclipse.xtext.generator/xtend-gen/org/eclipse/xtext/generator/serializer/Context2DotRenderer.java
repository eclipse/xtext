package org.eclipse.xtext.generator.serializer;

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
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

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
          Pair<EObject,EClass> _operator_mappedTo = ObjectExtensions.<EObject, EClass>operator_mappedTo(ctx, t);
          return _operator_mappedTo;
        }
      };
    Iterable<Pair<EObject,EClass>> _map = IterableExtensions.<EClass, Pair<EObject,EClass>>map(_typesForContext, _function);
    return _map;
  }
  
  public Iterable<Pair<EObject,EClass>> contexts() {
    Grammar _grammar = this.grammar;
    List<EObject> _allContexts = this.contextProvider.getAllContexts(_grammar);
    final Function1<EObject,Iterable<Pair<EObject,EClass>>> _function = new Function1<EObject,Iterable<Pair<EObject,EClass>>>() {
        public Iterable<Pair<EObject,EClass>> apply(final EObject c) {
          Iterable<Pair<EObject,EClass>> _types = Context2DotRenderer.this.types(c);
          return _types;
        }
      };
    List<Iterable<Pair<EObject,EClass>>> _map = ListExtensions.<EObject, Iterable<Pair<EObject,EClass>>>map(_allContexts, _function);
    Iterable<Pair<EObject,EClass>> _flatten = IterableExtensions.<Pair<EObject,EClass>>flatten(_map);
    return _flatten;
  }
  
  public Iterable<Pair<String,String>> render2Dot(final GraphvizDotBuilder builder, final String name) {
    Iterable<Pair<EObject,EClass>> _contexts = this.contexts();
    final Function1<Pair<EObject,EClass>,Pair<String,String>> _function = new Function1<Pair<EObject,EClass>,Pair<String,String>>() {
        public Pair<String,String> apply(final Pair<EObject,EClass> c) {
          String _fileName = Context2DotRenderer.this.getFileName(c, name);
          String _draw = builder.draw(c);
          Pair<String,String> _operator_mappedTo = ObjectExtensions.<String, String>operator_mappedTo(_fileName, _draw);
          return _operator_mappedTo;
        }
      };
    Iterable<Pair<String,String>> _map = IterableExtensions.<Pair<EObject,EClass>, Pair<String,String>>map(_contexts, _function);
    return _map;
  }
  
  public String getFileName(final Pair<EObject,EClass> ctx, final String name) {
    String _xblockexpression = null;
    {
      Grammar _grammar = this.grammar;
      String _name = _grammar.getName();
      String _simpleName = this.naming.toSimpleName(_name);
      String _operator_plus = StringExtensions.operator_plus(_simpleName, "_");
      EClass _value = ctx.getValue();
      String _name_1 = _value.getName();
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _name_1);
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "_");
      EObject _key = ctx.getKey();
      String _contextName = this.nameFunction.getContextName(_key);
      String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, _contextName);
      String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "_");
      String _operator_plus_5 = StringExtensions.operator_plus(_operator_plus_4, name);
      final String fn = _operator_plus_5;
      Grammar _grammar_1 = this.grammar;
      String _basePackageRuntime = this.naming.basePackageRuntime(_grammar_1);
      String _asPath = this.naming.asPath(_basePackageRuntime);
      String _operator_plus_6 = StringExtensions.operator_plus(_asPath, "/serializer/");
      String _operator_plus_7 = StringExtensions.operator_plus(_operator_plus_6, fn);
      String _operator_plus_8 = StringExtensions.operator_plus(_operator_plus_7, ".dot");
      _xblockexpression = (_operator_plus_8);
    }
    return _xblockexpression;
  }
}
