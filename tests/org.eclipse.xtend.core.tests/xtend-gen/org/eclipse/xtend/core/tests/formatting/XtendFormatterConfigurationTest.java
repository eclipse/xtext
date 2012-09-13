package org.eclipse.xtend.core.tests.formatting;

import java.util.Map;
import org.eclipse.xtend.core.formatting.XtendFormatterConfig;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendFormatterConfigurationTest {
  @Test
  public void test() {
    XtendFormatterConfig _xtendFormatterConfig = new XtendFormatterConfig();
    final XtendFormatterConfig cfg = _xtendFormatterConfig;
    final Map<String,String> map = cfg.asMap();
    XtendFormatterConfig _xtendFormatterConfig_1 = new XtendFormatterConfig(map);
    final XtendFormatterConfig cfg2 = _xtendFormatterConfig_1;
    Assert.assertNotNull(cfg2);
  }
}
