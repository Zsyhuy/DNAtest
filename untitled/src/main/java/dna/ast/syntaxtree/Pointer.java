//
// Generated by JTB 1.3.2
//

package dna.ast.syntaxtree;

/**
 * Grammar production:
 * f0 -> "*"
 * f1 -> [ TypeQualifierList() ]
 * f2 -> [ Pointer() ]
 */
public class Pointer implements Node {
   public NodeToken f0;
   public NodeOptional f1;
   public NodeOptional f2;

   public Pointer(NodeToken n0, NodeOptional n1, NodeOptional n2) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
   }

   public Pointer(NodeOptional n0, NodeOptional n1) {
      f0 = new NodeToken("*");
      f1 = n0;
      f2 = n1;
   }

   public void accept(dna.ast.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(dna.ast.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(dna.ast.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(dna.ast.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

