package org.jetbrains.plugins.clojure.parser;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.plugins.clojure.psi.impl.*;
import org.jetbrains.plugins.clojure.psi.impl.defs.ClDefImpl;
import org.jetbrains.plugins.clojure.psi.impl.defs.ClDefnDashImpl;
import org.jetbrains.plugins.clojure.psi.impl.defs.ClDefnImpl;
import org.jetbrains.plugins.clojure.psi.impl.symbols.ClImplicitArgumentImpl;
import org.jetbrains.plugins.clojure.psi.impl.symbols.ClSymbolImpl;

/**
 * @author ilyas
 */
public class ClojurePsiCreator {

  public static PsiElement createElement(ASTNode node) {
    final IElementType elementType = node.getElementType();

    if (elementType == ClojureElementTypes.LIST) return new ClListImpl(node);
    if (elementType == ClojureElementTypes.VECTOR) return new ClVector(node);
    if (elementType == ClojureElementTypes.MAP) return new ClMap(node);
    if (elementType == ClojureElementTypes.SET) return new ClMap(node);

    if (elementType == ClojureElementTypes.MAP_ENTRY) return new ClMapEntry(node);

    if (elementType == ClojureElementTypes.QUOTED_FORM) return new ClQuotedForm(node);
    if (elementType == ClojureElementTypes.META_FORM) return new ClMetaForm(node);
    if (elementType == ClojureElementTypes.METADATA) return new ClMetadataImpl(node);

    if (elementType == ClojureElementTypes.SYMBOL) return new ClSymbolImpl(node);
    if (elementType == ClojureElementTypes.IMPLICIT_ARG) return new ClImplicitArgumentImpl(node);
    
    if (elementType == ClojureElementTypes.DEFN) return new ClDefnImpl(node);
    if (elementType == ClojureElementTypes.DEFNDASH) return new ClDefnDashImpl(node);
    if (elementType == ClojureElementTypes.DEF) return new ClDefImpl(node);
    if (elementType == ClojureElementTypes.BINDINGS) return new ClBindings(node);
    if (elementType == ClojureElementTypes.KEYWORD) return new ClKey(node);
    if (elementType == ClojureElementTypes.LITERAL) return new ClLiteralImpl(node);
    if (elementType == ClojureElementTypes.BACKQUOTED_EXPRESSION) return new ClBackQuotedExpression(node);
    if (elementType == ClojureElementTypes.SHARP_EXPRESSION) return new ClSharp(node);
    if (elementType == ClojureElementTypes.TILDA_EXPRESSION) return new ClTilda(node);
    if (elementType == ClojureElementTypes.AT_EXPRESSION) return new ClAt(node);
    if (elementType == ClojureElementTypes.TILDAAT_EXPRESSION) return new ClTildaAt(node);

    throw new Error("Unexpected ASTNode: " + node.getElementType());
  }


}