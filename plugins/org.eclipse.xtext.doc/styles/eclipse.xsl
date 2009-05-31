<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:ng="http://docbook.org/docbook-ng"
  xmlns:db="http://docbook.org/ns/docbook"
  xmlns:exsl="http://exslt.org/common"
  version="1.0"
  exclude-result-prefixes="exsl db ng">
  
<xsl:import href="chunk.xsl"/>

<!-- ********************************************************************
     $Id: eclipse.xsl,v 1.2 2009/05/31 11:41:32 pfriese Exp $
     ********************************************************************

     This file is part of the XSL DocBook Stylesheet distribution.
     See ../README or http://docbook.sf.net/release/xsl/current/ for
     copyright and other information.

     ******************************************************************** -->

<xsl:template match="/">
  <!-- * Get a title for current doc so that we let the user -->
  <!-- * know what document we are processing at this point. -->
  <xsl:variable name="doc.title">
    <xsl:call-template name="get.doc.title"/>
  </xsl:variable>
  <xsl:choose>
    <!-- Hack! If someone hands us a DocBook V5.x or DocBook NG document,
         toss the namespace and continue.  Use the docbook5 namespaced
         stylesheets for DocBook5 if you don't want to use this feature.-->
    <!-- include extra test for Xalan quirk -->
    <xsl:when test="(function-available('exsl:node-set') or
                     contains(system-property('xsl:vendor'),
                       'Apache Software Foundation'))
                    and (*/self::ng:* or */self::db:*)">
      <xsl:call-template name="log.message">
        <xsl:with-param name="level">Note</xsl:with-param>
        <xsl:with-param name="source" select="$doc.title"/>
        <xsl:with-param name="context-desc">
          <xsl:text>namesp. cut</xsl:text>
        </xsl:with-param>
        <xsl:with-param name="message">
          <xsl:text>stripped namespace before processing</xsl:text>
        </xsl:with-param>
      </xsl:call-template>
      <xsl:variable name="nons">
        <xsl:apply-templates mode="stripNS"/>
      </xsl:variable>
      <xsl:call-template name="log.message">
        <xsl:with-param name="level">Note</xsl:with-param>
        <xsl:with-param name="source" select="$doc.title"/>
        <xsl:with-param name="context-desc">
          <xsl:text>namesp. cut</xsl:text>
        </xsl:with-param>
        <xsl:with-param name="message">
          <xsl:text>processing stripped document</xsl:text>
        </xsl:with-param>
      </xsl:call-template>
      <xsl:apply-templates select="exsl:node-set($nons)"/>
    </xsl:when>
    <xsl:otherwise>
  <xsl:choose>
    <xsl:when test="$rootid != ''">
      <xsl:choose>
        <xsl:when test="count(key('id',$rootid)) = 0">
          <xsl:message terminate="yes">
            <xsl:text>ID '</xsl:text>
            <xsl:value-of select="$rootid"/>
            <xsl:text>' not found in document.</xsl:text>
          </xsl:message>
        </xsl:when>
        <xsl:otherwise>
          <xsl:if test="$collect.xref.targets = 'yes' or
                        $collect.xref.targets = 'only'">
            <xsl:apply-templates select="key('id', $rootid)"
                        mode="collect.targets"/>
          </xsl:if>
          <xsl:if test="$collect.xref.targets != 'only'">
            <xsl:message>Formatting from <xsl:value-of 
	                          select="$rootid"/></xsl:message>
            <xsl:apply-templates select="key('id',$rootid)"
                        mode="process.root"/>
            <xsl:call-template name="etoc"/>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:when>
    <xsl:otherwise>
      <xsl:if test="$collect.xref.targets = 'yes' or
                    $collect.xref.targets = 'only'">
        <xsl:apply-templates select="/" mode="collect.targets"/>
      </xsl:if>
      <xsl:if test="$collect.xref.targets != 'only'">
        <xsl:apply-templates select="/" mode="process.root"/>
        <xsl:call-template name="etoc"/>
      </xsl:if>
    </xsl:otherwise>
  </xsl:choose>
</xsl:otherwise>
</xsl:choose>
</xsl:template>

<xsl:template name="etoc">
  <xsl:call-template name="write.chunk">
    <xsl:with-param name="filename">
      <xsl:if test="$manifest.in.base.dir != 0">
        <xsl:value-of select="$base.dir"/>
      </xsl:if>
      <xsl:value-of select="'toc.xml'"/>
    </xsl:with-param>
    <xsl:with-param name="method" select="'xml'"/>
    <xsl:with-param name="encoding" select="'utf-8'"/>
    <xsl:with-param name="indent" select="'yes'"/>
    <xsl:with-param name="content">
      <xsl:choose>

        <xsl:when test="$rootid != ''">
          <xsl:variable name="title">
            <xsl:if test="$eclipse.autolabel=1">
              <xsl:variable name="label.markup">
                <xsl:apply-templates select="key('id',$rootid)" mode="label.markup"/>
              </xsl:variable>
              <xsl:if test="normalize-space($label.markup)">
                <xsl:value-of select="concat($label.markup,$autotoc.label.separator)"/>
              </xsl:if>
            </xsl:if>
            <xsl:apply-templates select="key('id',$rootid)" mode="title.markup"/>
          </xsl:variable>
          <xsl:variable name="href">
            <xsl:call-template name="href.target.with.base.dir">
              <xsl:with-param name="object" select="key('id',$rootid)"/>
            </xsl:call-template>
          </xsl:variable>
          
          <toc label="{normalize-space($title)}" topic="{$href}">
            <xsl:apply-templates select="key('id',$rootid)/*" mode="etoc"/>
          </toc>
        </xsl:when>

        <xsl:otherwise>
          <xsl:variable name="title">
            <xsl:if test="$eclipse.autolabel=1">
              <xsl:variable name="label.markup">
                <xsl:apply-templates select="/*" mode="label.markup"/>
              </xsl:variable>
              <xsl:if test="normalize-space($label.markup)">
                <xsl:value-of select="concat($label.markup,$autotoc.label.separator)"/>
              </xsl:if>
            </xsl:if>
            <xsl:apply-templates select="/*" mode="title.markup"/>
          </xsl:variable>
          <xsl:variable name="href">
            <xsl:call-template name="href.target.with.base.dir">
              <xsl:with-param name="object" select="/"/>
            </xsl:call-template>
          </xsl:variable>
          
          <toc label="{normalize-space($title)}" topic="{$href}">
            <xsl:apply-templates select="/*/*" mode="etoc"/>
          </toc>
        </xsl:otherwise>

      </xsl:choose>
    </xsl:with-param>
  </xsl:call-template>
</xsl:template>

<xsl:template match="book|part|reference|preface|chapter|bibliography|appendix|article|glossary|section|sect1|sect2|sect3|sect4|sect5|refentry|colophon|bibliodiv|index" mode="etoc">
  <xsl:variable name="title">
    <xsl:if test="$eclipse.autolabel=1">
      <xsl:variable name="label.markup">
        <xsl:apply-templates select="." mode="label.markup"/>
      </xsl:variable>
      <xsl:if test="normalize-space($label.markup)">
        <xsl:value-of select="concat($label.markup,$autotoc.label.separator)"/>
      </xsl:if>
    </xsl:if>
    <xsl:apply-templates select="." mode="title.markup"/>
  </xsl:variable>

  <xsl:variable name="href">
    <xsl:call-template name="href.target.with.base.dir">
      <xsl:with-param name="context" select="/"/>        <!-- Generate links relative to the location of root file/toc.xml file -->
    </xsl:call-template>
  </xsl:variable>

  <topic label="{normalize-space($title)}" href="{$href}">
    <xsl:apply-templates select="part|reference|preface|chapter|bibliography|appendix|article|glossary|section|sect1|sect2|sect3|sect4|sect5|refentry|colophon|bibliodiv|index" mode="etoc"/>
  </topic>

</xsl:template>

<xsl:template match="text()" mode="etoc"/>

</xsl:stylesheet>
