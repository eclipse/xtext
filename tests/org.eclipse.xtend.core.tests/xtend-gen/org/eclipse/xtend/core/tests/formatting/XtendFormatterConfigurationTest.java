package org.eclipse.xtend.core.tests.formatting;

import java.util.Map;
import org.eclipse.xtend.core.formatting.RendererConfiguration;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendFormatterConfigurationTest {
  @Test
  public void test() {
    RendererConfiguration _rendererConfiguration = new RendererConfiguration();
    final RendererConfiguration cfg = _rendererConfiguration;
    final Map<String,String> map = cfg.asMap();
    RendererConfiguration _rendererConfiguration_1 = new RendererConfiguration(map);
    final RendererConfiguration cfg2 = _rendererConfiguration_1;
    Assert.assertNotNull(cfg2);
  }
}
