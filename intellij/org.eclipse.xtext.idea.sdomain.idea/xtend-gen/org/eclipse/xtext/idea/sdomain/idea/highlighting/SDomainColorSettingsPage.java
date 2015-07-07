package org.eclipse.xtext.idea.sdomain.idea.highlighting;

import com.google.common.base.Objects;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;
import org.eclipse.xtext.idea.sdomain.idea.highlighting.SDomainSyntaxHighlighter;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;

@SuppressWarnings("all")
public class SDomainColorSettingsPage extends AbstractColorSettingsPage {
  private AttributesDescriptor[] descriptors;
  
  public SDomainColorSettingsPage() {
    SDomainLanguage.INSTANCE.injectMembers(this);
  }
  
  @Override
  public String getDemoText() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// comment");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  @Override
  public AttributesDescriptor[] getAttributeDescriptors() {
    boolean _equals = Objects.equal(this.descriptors, null);
    if (_equals) {
      AttributesDescriptor _createDescriptor = this.createDescriptor("Keywords", SDomainSyntaxHighlighter.KEYWORD);
      AttributesDescriptor _createDescriptor_1 = this.createDescriptor("Numbers", SDomainSyntaxHighlighter.NUMBER);
      AttributesDescriptor _createDescriptor_2 = this.createDescriptor("Comments", SDomainSyntaxHighlighter.COMMENT);
      AttributesDescriptor _createDescriptor_3 = this.createDescriptor("Strings", SDomainSyntaxHighlighter.STRING);
      this.descriptors = new AttributesDescriptor[] { _createDescriptor, _createDescriptor_1, _createDescriptor_2, _createDescriptor_3 };
    }
    return this.descriptors;
  }
  
  @Override
  public String getDisplayName() {
    return SDomainLanguage.INSTANCE.getDisplayName();
  }
}
