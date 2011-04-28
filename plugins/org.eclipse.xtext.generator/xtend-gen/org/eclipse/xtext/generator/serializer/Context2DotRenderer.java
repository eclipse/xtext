package org.eclipse.xtext.generator.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.serializer.IContextProvider;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.util.GraphvizDotBuilder;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Context2DotRenderer {
  @Inject private IContextProvider iContextProvider;
  @Inject private Grammar grammar;
  @Inject private Naming naming;
  @Inject private Context2NameFunction context2NameFunction;
  
  public Iterable<Pair<String,String>> render2Dot(final GraphvizDotBuilder builder, final String name) {
    List<EObject> _allContexts = this.iContextProvider.getAllContexts(this.grammar);
    final Function1<EObject,Pair<String,String>> _function = new Function1<EObject,Pair<String,String>>() {
        public Pair<String,String> apply(EObject c) {
          String _fileName = Context2DotRenderer.this.getFileName(c, name);
          final EObject typeConverted_c = (EObject)c;
          String _draw = builder.draw(typeConverted_c);
          Pair<String,String> _operator_mappedTo = ObjectExtensions.<String, String>operator_mappedTo(_fileName, _draw);
          return _operator_mappedTo;
        }
      };
    List<Pair<String,String>> _map = ListExtensions.<EObject, Pair<String,String>>map(_allContexts, _function);
    return _map;
  }
  
  public String getFileName(final EObject ctx, final String name) {
    String _basePackageRuntime = this.naming.basePackageRuntime(this.grammar);
    String _asPath = this.naming.asPath(_basePackageRuntime);
    String _operator_plus = StringExtensions.operator_plus(_asPath, "/serializer/");
    String _name = this.grammar.getName();
    String _simpleName = this.naming.toSimpleName(_name);
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _simpleName);
    String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "_");
    String _contextName = this.context2NameFunction.getContextName(ctx);
    String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, _contextName);
    String _operator_plus_4 = StringExtensions.operator_plus(_operator_plus_3, "_");
    final String typeConverted_name = (String)name;
    String _operator_plus_5 = StringExtensions.operator_plus(_operator_plus_4, typeConverted_name);
    String _operator_plus_6 = StringExtensions.operator_plus(_operator_plus_5, ".dot");
    return _operator_plus_6;
  }
}