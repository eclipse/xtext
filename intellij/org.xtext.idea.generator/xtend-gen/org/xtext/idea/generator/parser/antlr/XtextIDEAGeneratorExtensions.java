package org.xtext.idea.generator.parser.antlr;

import com.google.common.base.Objects;
import com.google.inject.Singleton;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;

@Singleton
@SuppressWarnings("all")
public class XtextIDEAGeneratorExtensions {
  private final String IDEA_SRC = "IDEA_SRC";
  
  private final String IDEA_SRC_GEN = "IDEA_SRC_GEN";
  
  public Outlet getSrcOutlet(final Xtend2ExecutionContext it) {
    return this.getOutlet(it, this.IDEA_SRC);
  }
  
  public Outlet getSrcGenOutlet(final Xtend2ExecutionContext it) {
    return this.getOutlet(it, this.IDEA_SRC_GEN);
  }
  
  public Outlet getOutlet(final Xtend2ExecutionContext it, final String outletName) {
    XpandExecutionContext _xpandExecutionContext = it.getXpandExecutionContext();
    Output _output = _xpandExecutionContext.getOutput();
    return _output.getOutlet(outletName);
  }
  
  public void installOutlets(final Xtend2ExecutionContext it, final String pathIdeaPluginProject, final String encoding) {
    this.installOutlet(it, pathIdeaPluginProject, this.IDEA_SRC, "/src", encoding, Generator.SRC);
    this.installOutlet(it, pathIdeaPluginProject, this.IDEA_SRC_GEN, "/src-gen", encoding, Generator.SRC_GEN);
  }
  
  public void installOutlet(final Xtend2ExecutionContext it, final String pathIdeaPluginProject, final String outletName, final String projectPath, final String encoding, final String defaultOutletName) {
    Outlet _outlet = this.getOutlet(it, outletName);
    boolean _notEquals = (!Objects.equal(_outlet, null));
    if (_notEquals) {
      return;
    }
    final Outlet outlet = new Outlet(outletName);
    outlet.setName(outletName);
    outlet.setFileEncoding(encoding);
    String _xifexpression = null;
    boolean _notEquals_1 = (!Objects.equal(pathIdeaPluginProject, null));
    if (_notEquals_1) {
      _xifexpression = (pathIdeaPluginProject + projectPath);
    } else {
      Outlet _outlet_1 = this.getOutlet(it, defaultOutletName);
      _xifexpression = _outlet_1.getPath();
    }
    outlet.setPath(_xifexpression);
    XpandExecutionContext _xpandExecutionContext = it.getXpandExecutionContext();
    Output _output = _xpandExecutionContext.getOutput();
    _output.addOutlet(outlet);
  }
}
