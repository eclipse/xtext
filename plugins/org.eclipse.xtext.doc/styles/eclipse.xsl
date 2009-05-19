<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:import href="file:../../../lib/docbook/xsl/eclipse/eclipse.xsl" />
	<xsl:output method="xml" indent="yes" encoding="ISO-8859-1" omit-xml-declaration="yes" />

    <xsl:param name="html.stylesheet">../book.css</xsl:param>
    <xsl:param name="chunk.first.sections" select="0" />
    <xsl:param name="chunk.section.depth" select="0" />
    <xsl:param name="base.dir" select="'contents/'"></xsl:param>
    <xsl:param name="use.id.as.filename" select="1" />
    <xsl:param name="suppress.navigation" select="1" />
    <xsl:param name="chapter.autolabel" select="0" />
    <xsl:param name="generate.section.toc.level" select="1"></xsl:param>
    <xsl:param name="toc.max.depth">1</xsl:param>
    <xsl:param name="table.borders.with.css" select="1"></xsl:param>
    <xsl:param name="table.cell.border.color" select="'#000000'"></xsl:param>
    <xsl:param name="table.cell.border.thickness" select="'2'"></xsl:param>
    <xsl:param name="html.cellspacing" select="'0'"></xsl:param>
    <xsl:param name="html.cellpadding" select="'10'"></xsl:param>

    <xsl:param name="html.cleanup" select="1"></xsl:param>

    <xsl:param name="generate.toc">
        appendix  toc,title
        article/appendix  nop
        article   toc,title
        book      nop
        chapter   toc
        part      toc
        preface   toc,title
        qandadiv  toc
        qandaset  toc
        reference toc,title
        sect1     nop
        sect2     nop
        sect3     nop
        sect4     nop
        sect5     nop
        section   nop
        set       toc,title
    </xsl:param>
    
    <xsl:param name="eclipse.plugin.extensions">
    <![CDATA[
   <extension
   	  point="org.eclipse.ui.intro.configExtension">
   	  <configExtension
         configId="org.eclipse.ui.intro.universalConfig"
         content="intro/overviewExtensionContext.xml">
      </configExtension>
   	  <configExtension
         configId="org.eclipse.ui.intro.universalConfig"
         content="intro/newsExtensionContext.xml">
   	  </configExtension>
   	  <configExtension
         configId="org.eclipse.ui.intro.universalConfig"
         content="intro/tutorialsExtensionContext.xml">
   	  </configExtension> 
   </extension>
   <extension
   	  point="org.eclipse.ui.cheatsheets.cheatSheetContent">
   	  <category
         id="org.openarchitectureware"
         name="openArchitectureWare"/>
   	  <cheatsheet
         category="org.openarchitectureware"
         composite="false"
         contentFile="$nl$/cheatsheets/CreatingAnOAWProject.xml"
         id="org.openarchitectureware.create.project.oaw"
         name="Creating an oAW generator project">
   	  </cheatsheet>
   </extension>
   ]]>
	</xsl:param>

</xsl:stylesheet>