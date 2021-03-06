//
// Generated by JTB 1.3.2
//

package dna.ast.syntaxtree;

/**
 * Grammar production:
 * f0 -> CastExpression()
 * f1 -> [ ( "*" | "/" | "%" ) MultiplicativeExpression() ]
 */
public class MultiplicativeExpression implements Node {
   public CastExpression f0;
   public NodeOptional f1;

   public MultiplicativeExpression(CastExpression n0, NodeOptional n1) {
      f0 = n0;
      f1 = n1;
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

