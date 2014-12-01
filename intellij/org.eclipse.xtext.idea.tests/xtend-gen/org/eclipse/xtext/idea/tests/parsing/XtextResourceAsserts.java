package org.eclipse.xtext.idea.tests.parsing;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.resource.PsiToEcoreAdapter;
import org.eclipse.xtext.idea.tests.parsing.NodeModelPrinter;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;

@SuppressWarnings("all")
public class XtextResourceAsserts extends Assert {
  @Inject
  @Extension
  private NodeModelPrinter nodeModelPrinter;
  
  @Inject
  @Extension
  private InvariantChecker invariantChecker;
  
  public void assertResource(final XtextResource expectedResource, final XtextResource actualResource) {
    IParseResult _parseResult = expectedResource.getParseResult();
    final ICompositeNode expectedRootNode = _parseResult.getRootNode();
    IParseResult _parseResult_1 = actualResource.getParseResult();
    final ICompositeNode actualRootNode = _parseResult_1.getRootNode();
    String _print = this.nodeModelPrinter.print(expectedRootNode);
    String _print_1 = this.nodeModelPrinter.print(actualRootNode);
    Assert.assertEquals(_print, _print_1);
    IParseResult _parseResult_2 = expectedResource.getParseResult();
    final EObject expectedRootASTElement = _parseResult_2.getRootASTElement();
    IParseResult _parseResult_3 = actualResource.getParseResult();
    final EObject actualRootASTElement = _parseResult_3.getRootASTElement();
    String _objToStr = EmfFormatter.objToStr(expectedRootASTElement);
    String _objToStr_1 = EmfFormatter.objToStr(actualRootASTElement);
    Assert.assertEquals(_objToStr, _objToStr_1);
    this.invariantChecker.checkInvariant(actualRootNode);
    PsiToEcoreAdapter _get = PsiToEcoreAdapter.get(actualResource);
    final Map<ASTNode, INode> nodesMapping = _get.getNodesMapping();
    Set<ASTNode> _keySet = nodesMapping.keySet();
    for (final ASTNode astNode : _keySet) {
      {
        final INode node = nodesMapping.get(astNode);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Node ");
        _builder.append(node, "");
        _builder.append(" is not a part of the tree");
        boolean _belongsTo = this.belongsTo(node, actualRootNode);
        Assert.assertTrue(_builder.toString(), _belongsTo);
      }
    }
  }
  
  protected boolean belongsTo(final INode node, final ICompositeNode rootNode) {
    BidiTreeIterable<INode> _asTreeIterable = rootNode.getAsTreeIterable();
    final Function1<INode, Boolean> _function = new Function1<INode, Boolean>() {
      public Boolean apply(final INode it) {
        return Boolean.valueOf(Objects.equal(it, node));
      }
    };
    return IterableExtensions.<INode>exists(_asTreeIterable, _function);
  }
}
