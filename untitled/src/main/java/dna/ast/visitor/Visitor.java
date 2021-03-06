//
// Generated by JTB 1.3.2
//

package dna.ast.visitor;
import dna.ast.syntaxtree.*;
import java.util.*;

/**
 * All void visitors must implement this interface.
 */

public interface Visitor {

   //
   // void Auto class visitors
   //

   public void visit(NodeList n);
   public void visit(NodeListOptional n);
   public void visit(NodeOptional n);
   public void visit(NodeSequence n);
   public void visit(NodeToken n);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( ExternalDeclaration() )+
    */
   public void visit(TranslationUnit n);

   /**
    * f0 -> ( Declaration() | FunctionDefinition() )
    */
   public void visit(ExternalDeclaration n);

   /**
    * f0 -> [ DeclarationSpecifiers() ]
    * f1 -> Declarator()
    * f2 -> [ DeclarationList() ]
    * f3 -> CompoundStatement()
    */
   public void visit(FunctionDefinition n);

   /**
    * f0 -> DeclarationSpecifiers()
    * f1 -> [ InitDeclaratorList() ]
    * f2 -> ";"
    */
   public void visit(Declaration n);

   /**
    * f0 -> ( Declaration() )+
    */
   public void visit(DeclarationList n);

   /**
    * f0 -> StorageClassSpecifier() [ DeclarationSpecifiers() ]
    *       | TypeSpecifier() [ DeclarationSpecifiers() ]
    *       | TypeQualifier() [ DeclarationSpecifiers() ]
    */
   public void visit(DeclarationSpecifiers n);

   /**
    * f0 -> ( <AUTO> | <REGISTER> | <STATIC> | <EXTERN> | <TYPEDEF> )
    */
   public void visit(StorageClassSpecifier n);

   /**
    * f0 -> ( <VOID> | <CHAR> | <SHORT> | <INT> | <LONG> | <FLOAT> | <DOUBLE> | <SIGNED> | <UNSIGNED> | StructOrUnionSpecifier() | EnumSpecifier() | TypedefName() )
    */
   public void visit(TypeSpecifier n);

   /**
    * f0 -> ( <CONST> | <VOLATILE> )
    */
   public void visit(TypeQualifier n);

   /**

    * f0 -> StructOrUnion()
    * f1 -> ( [ <IDENTIFIER> ] "{" StructDeclarationList() "}" | <IDENTIFIER> )
    */
   public void visit(StructOrUnionSpecifier n);

   /**
    * f0 -> ( <STRUCT> | <UNION> )
    */
   public void visit(StructOrUnion n);

   /**
    * f0 -> ( StructDeclaration() )+
    */
   public void visit(StructDeclarationList n);

   /**
    * f0 -> InitDeclarator()
    * f1 -> ( "," InitDeclarator() )*
    */
   public void visit(InitDeclaratorList n);

   /**
    * f0 -> Declarator()
    * f1 -> [ "=" Initializer() ]
    */
   public void visit(InitDeclarator n);

   /**
    * f0 -> SpecifierQualifierList()
    * f1 -> StructDeclaratorList()
    * f2 -> ";"
    */
   public void visit(StructDeclaration n);

   /**
    * f0 -> TypeSpecifier() [ SpecifierQualifierList() ]
    *       | TypeQualifier() [ SpecifierQualifierList() ]
    */
   public void visit(SpecifierQualifierList n);

   /**
    * f0 -> StructDeclarator()
    * f1 -> ( "," StructDeclarator() )*
    */
   public void visit(StructDeclaratorList n);

   /**
    * f0 -> ( Declarator() | [ Declarator() ] ":" ConstantExpression() )
    */
   public void visit(StructDeclarator n);

   /**
    * f0 -> <ENUM>
    * f1 -> ( [ <IDENTIFIER> ] "{" EnumeratorList() "}" | <IDENTIFIER> )
    */
   public void visit(EnumSpecifier n);

   /**
    * f0 -> Enumerator()
    * f1 -> ( "," Enumerator() )*
    */
   public void visit(EnumeratorList n);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> [ "=" ConstantExpression() ]
    */
   public void visit(Enumerator n);

   /**
    * f0 -> [ Pointer() ]
    * f1 -> DirectDeclarator()
    */
   public void visit(Declarator n);

   /**
    * f0 -> ( t=<IDENTIFIER> | "(" Declarator() ")" )
    * f1 -> ( "[" [ ConstantExpression() ] "]" | "(" ParameterTypeList() ")" | "(" [ IdentifierList() ] ")" )*
    */
   public void visit(DirectDeclarator n);

   /**
    * f0 -> "*"
    * f1 -> [ TypeQualifierList() ]
    * f2 -> [ Pointer() ]
    */
   public void visit(Pointer n);

   /**
    * f0 -> ( TypeQualifier() )+
    */
   public void visit(TypeQualifierList n);

   /**
    * f0 -> ParameterList()
    * f1 -> [ "," "..." ]
    */
   public void visit(ParameterTypeList n);

   /**
    * f0 -> ParameterDeclaration()
    * f1 -> ( "," ParameterDeclaration() )*
    */
   public void visit(ParameterList n);

   /**
    * f0 -> DeclarationSpecifiers()
    * f1 -> ( Declarator() | [ AbstractDeclarator() ] )
    */
   public void visit(ParameterDeclaration n);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> ( "," <IDENTIFIER> )*
    */
   public void visit(IdentifierList n);

   /**
    * f0 -> ( AssignmentExpression() | "{" InitializerList() [ "," ] "}" )
    */
   public void visit(Initializer n);

   /**
    * f0 -> Initializer()
    * f1 -> ( "," Initializer() )*
    */
   public void visit(InitializerList n);

   /**
    * f0 -> SpecifierQualifierList()
    * f1 -> [ AbstractDeclarator() ]
    */
   public void visit(TypeName n);

   /**
    * f0 -> ( Pointer() | [ Pointer() ] DirectAbstractDeclarator() )
    */
   public void visit(AbstractDeclarator n);

   /**
    * f0 -> ( "(" AbstractDeclarator() ")" | "[" [ ConstantExpression() ] "]" | "(" [ ParameterTypeList() ] ")" )
    * f1 -> ( "[" [ ConstantExpression() ] "]" | "(" [ ParameterTypeList() ] ")" )*
    */
   public void visit(DirectAbstractDeclarator n);

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(TypedefName n);

   /**
    * f0 -> ( LabeledStatement() | ExpressionStatement() | CompoundStatement() | SelectionStatement() | IterationStatement() | JumpStatement() )
    */
   public void visit(Statement n);

   /**
    * f0 -> ( <IDENTIFIER> ":" Statement() | <CASE> ConstantExpression() ":" Statement() | <DFLT> ":" Statement() )
    */
   public void visit(LabeledStatement n);

   /**
    * f0 -> [ Expression() ]
    * f1 -> ";"
    */
   public void visit(ExpressionStatement n);

   /**
    * f0 -> "{"
    * f1 -> [ DeclarationList() ]
    * f2 -> [ StatementList() ]
    * f3 -> "}"
    */
   public void visit(CompoundStatement n);

   /**
    * f0 -> ( Statement() )+
    */
   public void visit(StatementList n);

   /**
    * f0 -> ( <IF> "(" Expression() ")" Statement() [ <ELSE> Statement() ] | <SWITCH> "(" Expression() ")" Statement() )
    */
   public void visit(SelectionStatement n);

   /**
    * f0 -> ( <WHILE> "(" Expression() ")" Statement() | <DO> Statement() <WHILE> "(" Expression() ")" ";" | <FOR> "(" [ Expression() ] ";" [ Expression() ] ";" [ Expression() ] ")" Statement() )
    */
   public void visit(IterationStatement n);

   /**
    * f0 -> ( <GOTO> <IDENTIFIER> ";" | <CONTINUE> ";" | <BREAK> ";" | <RETURN> [ Expression() ] ";" )
    */
   public void visit(JumpStatement n);

   /**
    * f0 -> AssignmentExpression()
    * f1 -> ( "," AssignmentExpression() )*
    */
   public void visit(Expression n);

   /**
    * f0 -> UnaryExpression() AssignmentOperator() AssignmentExpression()
    *       | ConditionalExpression()
    */
   public void visit(AssignmentExpression n);

   /**
    * f0 -> ( "=" | "*=" | "/=" | "%=" | "+=" | "-=" | "<<=" | ">>=" | "&=" | "^=" | "|=" )
    */
   public void visit(AssignmentOperator n);

   /**
    * f0 -> LogicalORExpression()
    * f1 -> [ "?" Expression() ":" ConditionalExpression() ]
    */
   public void visit(ConditionalExpression n);

   /**
    * f0 -> ConditionalExpression()
    */
   public void visit(ConstantExpression n);

   /**
    * f0 -> LogicalANDExpression()
    * f1 -> [ "||" LogicalORExpression() ]
    */
   public void visit(LogicalORExpression n);

   /**
    * f0 -> InclusiveORExpression()
    * f1 -> [ "&&" LogicalANDExpression() ]
    */
   public void visit(LogicalANDExpression n);

   /**
    * f0 -> ExclusiveORExpression()
    * f1 -> [ "|" InclusiveORExpression() ]
    */
   public void visit(InclusiveORExpression n);

   /**
    * f0 -> ANDExpression()
    * f1 -> [ "^" ExclusiveORExpression() ]
    */
   public void visit(ExclusiveORExpression n);

   /**
    * f0 -> EqualityExpression()
    * f1 -> [ "&" ANDExpression() ]
    */
   public void visit(ANDExpression n);

   /**
    * f0 -> RelationalExpression()
    * f1 -> [ ( "==" | "!=" ) EqualityExpression() ]
    */
   public void visit(EqualityExpression n);

   /**
    * f0 -> ShiftExpression()
    * f1 -> [ ( "<" | ">" | "<=" | ">=" ) RelationalExpression() ]
    */
   public void visit(RelationalExpression n);

   /**
    * f0 -> AdditiveExpression()
    * f1 -> [ ( "<<" | ">>" ) ShiftExpression() ]
    */
   public void visit(ShiftExpression n);

   /**
    * f0 -> MultiplicativeExpression()
    * f1 -> [ ( "+" | "-" ) AdditiveExpression() ]
    */
   public void visit(AdditiveExpression n);

   /**
    * f0 -> CastExpression()
    * f1 -> [ ( "*" | "/" | "%" ) MultiplicativeExpression() ]
    */
   public void visit(MultiplicativeExpression n);

   /**
    * f0 -> ( "(" TypeName() ")" CastExpression() | UnaryExpression() )
    */
   public void visit(CastExpression n);

   /**
    * f0 -> ( PostfixExpression() | "++" UnaryExpression() | "--" UnaryExpression() | UnaryOperator() CastExpression() | <SIZEOF> ( UnaryExpression() | "(" TypeName() ")" ) )
    */
   public void visit(UnaryExpression n);

   /**
    * f0 -> ( "&" | "*" | "+" | "-" | "~" | "!" )
    */
   public void visit(UnaryOperator n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> ( "[" Expression() "]" | "(" [ ArgumentExpressionList() ] ")" | "." <IDENTIFIER> | "->" <IDENTIFIER> | "++" | "--" )*
    */
   public void visit(PostfixExpression n);

   /**
    * f0 -> ( <IDENTIFIER> | Constant() | "(" Expression() ")" )
    */
   public void visit(PrimaryExpression n);

   /**
    * f0 -> AssignmentExpression()
    * f1 -> ( "," AssignmentExpression() )*
    */
   public void visit(ArgumentExpressionList n);

   /**
    * f0 -> <INTEGER_LITERAL>
    *       | <FLOATING_POINT_LITERAL>
    *       | <CHARACTER_LITERAL>
    *       | <STRING_LITERAL>
    */
   public void visit(Constant n);

}

