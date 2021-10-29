import visitor.*;
import syntaxtree.*;

public class TreeTransformB extends DepthFirstVisitor {
    private StringBuilder DNAseq;
    //    private boolean findToken;
    private int compoundDepth;  // 记录代码块层数
    private int assignmentDepth; // 标记是否在赋值语句内
    private boolean afterAssignment; // 标记是否在赋值等号前

    public TreeTransformB() {
        this.DNAseq = new StringBuilder();
        this.compoundDepth = 0;
        this.assignmentDepth = 0;
    }

    // 在代码块内
    public void visit(CompoundStatement n) {

        this.compoundDepth++;
        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        this.compoundDepth--;
    }

    // 循环
    public void visit(IterationStatement n) {
        this.DNAseq.append("H");
        n.f0.accept(this);
    }

    // 赋值
    public void visit(AssignmentExpression n) {
        if (this.assignmentDepth == 0) {
            this.afterAssignment = false;   // 刚进入赋值语句，则在等号前
        }
        this.assignmentDepth++;
        n.f0.accept(this);
        this.assignmentDepth--;
    }

    // 比较运算
//    public void visit(RelationalExpression n) {
//        this.DNAseq.append("C");
//        n.f0.accept(this);
//        n.f1.accept(this);
//    }

    // 检查符号
    public void visit(NodeToken n) {
        if (this.compoundDepth == 0) {
            // 不在代码块内
            return;
        }

//        if (!this.findToken) {
//            return;
//        }

        switch (n.kind) {
            case 95:
                // ++
                this.DNAseq.append("Q");
                break;
            case 85:
            case 86:
            case 87:
            case 88:
                // 比较运算符
                this.DNAseq.append("C");
                break;
            case 70:
                // +=
                this.DNAseq.append("P");
                this.afterAssignment = true;
                break;
            case 65:
            case 91:
                // *, +
                this.DNAseq.append("A");
                break;
            case 63:
                // [
                // 在操作数组
                this.DNAseq.deleteCharAt(this.DNAseq.length() - 1);
                if (afterAssignment) {
                    // 读
                    this.DNAseq.append("R");
                } else {
                    // 写
                    this.DNAseq.append("W");
                }
                break;
            case 59:
                // =
                this.DNAseq.append("E");
                this.afterAssignment = true;
                break;
            case 52:
                // identifier
                this.DNAseq.append("I");
                break;
            case 12:
                // 数字
                if (n.tokenImage.equals("0")) {
                    this.DNAseq.append("Z");
                }
                break;
        }
    }

    public String getDNA() {
        return this.DNAseq.toString();
    }
}
