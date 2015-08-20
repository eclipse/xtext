<?xml version="1.0" encoding="UTF-8"?>
<mspec:mspec xmlns:mspec="http://www.eclipse.org/buckminster/MetaData-1.0" materializer="p2" name="Xtext Target Platform MSPEC" shortDesc="Materializes an eclipse platform" url="xtext-platform.cquery">
  <mspec:property key="target.os" value="*"/>
  <mspec:property key="target.arch" value="*"/>
  <mspec:property key="target.ws" value="*"/>
  <mspec:property key="eclipse.target.platform" mutable="true" value="${eclipse.download}/eclipse/updates/3.6"/>
  <mspec:property key="eclipse.stable.target.platform" mutable="true" value="${eclipse.download}/eclipse/updates/4.2"/>
  <mspec:property key="eclipse.latest.target.platform" mutable="true" value="${eclipse.download}/eclipse/updates/4.5"/>
  <mspec:mspecNode materializer="workspace" filter="(buckminster.source=true)"/>
</mspec:mspec>
