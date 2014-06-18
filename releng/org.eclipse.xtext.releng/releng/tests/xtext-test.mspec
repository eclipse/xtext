<?xml version="1.0" encoding="UTF-8"?>
<md:mspec xmlns:md="http://www.eclipse.org/buckminster/MetaData-1.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.eclipse.org/buckminster/MetaData-1.0 http://www.eclipse.org/buckminster/schemas/metadata-1.0.xsd"
	materializer="workspace" name="xtext-test.mspec" url="xtext-test.cquery">
	<md:property key="target.os" value="*" />
	<md:property key="target.arch" value="*" />
	<md:property key="target.ws" value="*" />
	<md:mspecNode namePattern="org\.junit.*" materializer="p2"
		componentType="osgi.bundle" exclude="false" />
	<md:mspecNode namePattern="org\.eclipse\.emf*"
		materializer="p2" componentType="osgi.bundle" exclude="false" />
</md:mspec>