package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractIdentifiableTypeTest;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class BatchIdentifiableTypeTests extends AbstractIdentifiableTypeTest {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  public void resolvesIdentifiablesTo(final String expression, final String... types) {
    final String expressionWithQualifiedNames = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
    final List<JvmIdentifiableElement> identifiables = this.findIdentifiables(expressionWithQualifiedNames);
    boolean _isEmpty = identifiables.isEmpty();
    Assert.assertFalse(_isEmpty);
    int _size = ((List<String>)Conversions.doWrapArray(types)).size();
    int _size_1 = identifiables.size();
    Assert.assertEquals(_size, _size_1);
    JvmIdentifiableElement _head = IterableExtensions.<JvmIdentifiableElement>head(identifiables);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(_head);
    final Procedure2<JvmIdentifiableElement,Integer> _function = new Procedure2<JvmIdentifiableElement,Integer>() {
        public void apply(final JvmIdentifiableElement identifiable, final Integer index) {
          final LightweightTypeReference type = resolvedTypes.getActualType(identifiable);
          Assert.assertNotNull(type);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("failed for identifiable at ");
          _builder.append(index, "");
          String _get = ((List<String>)Conversions.doWrapArray(types)).get((index).intValue());
          String _simpleName = type.getSimpleName();
          Assert.assertEquals(_builder.toString(), _get, _simpleName);
        }
      };
    IterableExtensions.<JvmIdentifiableElement>forEach(identifiables, _function);
  }
}
