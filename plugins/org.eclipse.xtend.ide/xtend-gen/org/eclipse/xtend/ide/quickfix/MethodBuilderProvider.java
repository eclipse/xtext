package org.eclipse.xtend.ide.quickfix;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.xtend.ide.quickfix.JavaMethodBuilder;
import org.eclipse.xtend.ide.quickfix.XtendMethodBuilder;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;

@SuppressWarnings("all")
public class MethodBuilderProvider {
  @Inject
  private Provider<XtendMethodBuilder> xtendMethodBuilderProvider;
  
  @Inject
  private Provider<JavaMethodBuilder> javaMethodBuilderProvider;
  
  public XtendMethodBuilder newXtendMethodBuilder(final String methodName, final XAbstractFeatureCall call) {
    XtendMethodBuilder _invoke = this.invoke(this.xtendMethodBuilderProvider, methodName, call);
    return _invoke;
  }
  
  public XtendMethodBuilder newJavaMethodBuilder(final String methodName, final XAbstractFeatureCall call) {
    XtendMethodBuilder _invoke = this.invoke(this.javaMethodBuilderProvider, methodName, call);
    return _invoke;
  }
  
  private XtendMethodBuilder invoke(final Provider<? extends XtendMethodBuilder> provider, final String methodName, final XAbstractFeatureCall call) {
    XtendMethodBuilder _xblockexpression = null;
    {
      final XtendMethodBuilder builder = provider.get();
      builder.setMethodName(methodName);
      builder.setFeatureCall(call);
      _xblockexpression = (builder);
    }
    return _xblockexpression;
  }
}
